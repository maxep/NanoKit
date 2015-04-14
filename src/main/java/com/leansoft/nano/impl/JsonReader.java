package com.leansoft.nano.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.leansoft.nano.Format;
import com.leansoft.nano.IReader;
import com.leansoft.nano.annotation.schema.AttributeSchema;
import com.leansoft.nano.annotation.schema.ElementSchema;
import com.leansoft.nano.annotation.schema.RootElementSchema;
import com.leansoft.nano.annotation.schema.ValueSchema;
import com.leansoft.nano.exception.MappingException;
import com.leansoft.nano.exception.ReaderException;
import com.leansoft.nano.transform.Transformer;
import com.leansoft.nano.util.StringUtil;
import com.leansoft.nano.util.TypeReflector;

/**
 * IReader implementation using org.json library,
 * 
 * JsonReader de-serialize JSON string into POJO, the de-serialization 
 * is guided by mapping schema defined in the POJO using Nano annotations.
 * 
 * @author bulldog
 *
 */
public class JsonReader implements IReader {
	
	private Format format;
	
	public JsonReader() {
		this(new Format());
	}
	
	public JsonReader(Format format) {
		this.format = format;
	}

	public <T> T read(Class<? extends T> type, InputStream source)
			throws ReaderException, MappingException {

		try {
			return this.read(type, new InputStreamReader(source, format.getEncoding()));
		} catch (UnsupportedEncodingException e) {
			throw new ReaderException("Encoding is not supported", e);
		}
		
	}

	public <T> T read(Class<? extends T> type, String source)
			throws ReaderException, MappingException {
		validate(type, source);

		try {
			Constructor con = TypeReflector.getConstructor(type);
			Object instance = con.newInstance();
			
			JSONObject jsonObj = new JSONObject(source);
			
			MappingSchema ms = MappingSchema.fromObject(instance);
			RootElementSchema res = ms.getRootElementSchema();
			String rootName = res.getXmlName();
			
			Object jsonValue = jsonObj.opt(rootName);
			if (jsonValue == null) {
				throw new ReaderException("Root name mismatch, can not find root name : " + rootName + " in the json string!");
			}
			
			if (jsonValue instanceof JSONArray) {
				jsonValue = ((JSONArray)jsonValue).get(0);
			}
			
			this.readObject(instance, (JSONObject)jsonValue);
			
			return (T)instance;
		} catch(ReaderException re) {
			throw re;
		} catch(MappingException me) {
			throw me;
		} catch(Exception e) {
			throw new ReaderException("Error to read object", e);
		}
	}

	public <T> T read(Class<? extends T> type, Reader source)
			throws ReaderException, MappingException {
		if (source == null) {
			throw new ReaderException("Cannot read, reader is null!");
		}

		try {
			return this.read(type, StringUtil.reader2String(source));
		} catch (IOException e) {
			throw new ReaderException("IO error!", e);
		}
		
	}
	
//	private String reader2String(Reader source) throws IOException {
//		char[] cbuf = new char[65535];
//		StringBuffer stringbuf = new StringBuffer();
//		
//		int count = 0;
//		while ((count = source.read(cbuf, 0, 65535)) != -1) {
//			stringbuf.append(cbuf, 0, count);
//		}
//		
//		return stringbuf.toString();
//	}
	
	private <T> void validate(Class<? extends T> type, String source) throws ReaderException {
		if (type == null) {
			throw new ReaderException("Cannot read, type is null!");
		}
		if (StringUtil.isEmpty(source)) {
			throw new ReaderException("Source is empty!");			
		}
		
		if (Transformer.isPrimitive(type)) {
			throw new ReaderException("Can not read primitive or enum type object, " +
					"only Nano bindable complex type object can be accepted!");
		}
	}
	
	private void readObject(Object instance, JSONObject jsonObj) throws Exception {
		MappingSchema ms = MappingSchema.fromObject(instance);
		
		this.readAttribute(instance, jsonObj, ms);
		this.readValue(instance, jsonObj, ms);
		this.readElement(instance, jsonObj, ms);
	}
	
	private void readAttribute(Object instance, JSONObject jsonObj, MappingSchema ms) throws Exception {
		Map<String, AttributeSchema> xml2AttributeSchemaMapping = ms.getXml2AttributeSchemaMapping();
		for(String xmlName : xml2AttributeSchemaMapping.keySet()) {
			Object jsonValue = jsonObj.opt("@" + xmlName);
			if (jsonValue != null) {
				if (!(jsonValue instanceof JSONObject) && !(jsonValue instanceof JSONArray)) {
					AttributeSchema as = xml2AttributeSchemaMapping.get(xmlName);
					Field field = as.getField();
					Object value = Transformer.read(String.valueOf(jsonValue), field.getType());
					field.set(instance, value);
				}
			}
		}
	}
	
	private void readValue(Object instance, JSONObject jsonObj, MappingSchema ms) throws Exception {
		ValueSchema vs = ms.getValueSchema();
		if (vs != null) {
			Object jsonValue = jsonObj.opt(JsonWriter.VALUE_KEY);
			if (jsonValue != null) {
				if (!(jsonValue instanceof JSONObject) && !(jsonValue instanceof JSONArray)) {
					Field field = vs.getField();
					Object value = Transformer.read(String.valueOf(jsonValue), field.getType());
					field.set(instance, value);
				}
			}
		}
	}
	
	private void readElement(Object instance, JSONObject jsonObj, MappingSchema ms) throws Exception {
		Map<String, Object> xml2SchemaMapping = ms.getXml2SchemaMapping();
		for(String xmlName : xml2SchemaMapping.keySet()) {
			Object jsonValue = jsonObj.opt(xmlName);
			if (jsonValue != null) {
				Object schema = xml2SchemaMapping.get(xmlName);
				if (schema instanceof ElementSchema) {
					ElementSchema es = (ElementSchema)schema;
					Field field = es.getField();
					if (!es.isList()) {
						if (jsonValue instanceof JSONArray) {
							jsonValue = ((JSONArray)jsonValue).get(0);
						}
						Class<?> type = field.getType();
						if (Transformer.isPrimitive(type)) {
							if (!(jsonValue instanceof JSONObject) && !(jsonValue instanceof JSONArray)) {
								Object value = Transformer.read(String.valueOf(jsonValue), field.getType());
								field.set(instance, value);
							}
						} else if (jsonValue instanceof JSONObject) {
							Constructor con = TypeReflector.getConstructor(type);
							Object subObj = con.newInstance();
							field.set(instance, subObj);
							this.readObject(subObj, (JSONObject)jsonValue);
						}
					} else { // List
						Class<?> type = es.getParameterizedType();
						if (jsonValue instanceof JSONArray) {
							JSONArray jsonArray = (JSONArray)jsonValue;
							if (jsonArray.length() > 0) {
								this.readArray(instance, type, field, jsonArray);
							}
						}
					}
				}
			}
		}
	}
	
	private void readArray(Object instance, Class<?> type, Field field, JSONArray jsonArray) throws Exception {
		if (Transformer.isPrimitive(type)) {
			for(int i = 0; i < jsonArray.length(); i++) {
				Object jsonValue = jsonArray.get(i);
				if (!(jsonValue instanceof JSONObject) && !(jsonValue instanceof JSONArray)) {
					Object value = Transformer.read(String.valueOf(jsonValue), type);
					List list = (List)field.get(instance);
					if (list == null) {
						list = new ArrayList();
						field.set(instance, list);
					}
					list.add(value);
				}
			}
		} else { // Object
			for(int i = 0; i < jsonArray.length(); i++) {
				Object jsonValue = jsonArray.get(i);
				if (jsonValue instanceof JSONObject) {
					Constructor con = TypeReflector.getConstructor(type);
					Object subObj = con.newInstance();
					List list = (List)field.get(instance);
					if (list == null) {
						list = new ArrayList();
						field.set(instance, list);
					}
					list.add(subObj);
					this.readObject(subObj, (JSONObject)jsonValue);
				}
			}
		}
	}

}
