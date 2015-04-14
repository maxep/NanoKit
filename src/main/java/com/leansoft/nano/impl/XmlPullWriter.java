package com.leansoft.nano.impl;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import com.leansoft.nano.Format;
import com.leansoft.nano.IWriter;
import com.leansoft.nano.annotation.schema.AnyElementSchema;
import com.leansoft.nano.annotation.schema.AttributeSchema;
import com.leansoft.nano.annotation.schema.ElementSchema;
import com.leansoft.nano.annotation.schema.RootElementSchema;
import com.leansoft.nano.annotation.schema.ValueSchema;
import com.leansoft.nano.exception.MappingException;
import com.leansoft.nano.exception.WriterException;
import com.leansoft.nano.transform.Transformer;
import com.leansoft.nano.util.StringUtil;

/**
 * IWriter implementation using kxml pull parser.
 * 
 * @author bulldog
 *
 */
public class XmlPullWriter implements IWriter {
	
	protected static final String IDENT_PROPERTY = "http://xmlpull.org/v1/doc/features.html#indent-output";
	protected static final String PROPERTY_SERIALIZER_INDENTATION = "http://xmlpull.org/v1/doc/properties.html#serializer-indentation";

	protected Format format;

	protected XmlPullParserFactory factory;

	public XmlPullWriter() {
		this(new Format());
	}

	public XmlPullWriter(Format format) {
		this.format = format;

		try {
			factory = XmlPullParserFactory.newInstance(System
					.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
		} catch (XmlPullParserException e) {
			throw new RuntimeException(
					"Failed to create XmlPullParserFactory!", e);
		}
	}

	public void write(Object source, Writer out) throws WriterException, MappingException {
		try {
			// entry validation
			validate(source, out);
	
			XmlSerializer serializer = factory.newSerializer();
			if (format.isIndent()) {
				try {
					serializer.setFeature(IDENT_PROPERTY, true);
				} catch (IllegalStateException ise) {
					serializer.setProperty(PROPERTY_SERIALIZER_INDENTATION, "    ");
				}
			}
			serializer.setOutput(out);
			serializer.startDocument(format.getEncoding(), null);
			
			MappingSchema ms = MappingSchema.fromObject(source);
			RootElementSchema res = ms.getRootElementSchema();
			String namespace = res.getNamespace();
			String xmlName = res.getXmlName();
			
			if (!StringUtil.isEmpty(namespace)) { // bind to default namespace
				serializer.setPrefix("", namespace);
			}
			
			serializer.startTag(namespace, xmlName);
			this.writeObject(serializer, source, namespace);
			serializer.endTag(namespace, xmlName);
			
			serializer.endDocument();
		} catch (MappingException me) {
			throw me;
		} catch (IllegalArgumentException iae) {
			throw new WriterException("Entry validation failure", iae);
		} catch (Exception e) {
			throw new WriterException("Error to write/serialize object", e);
		}
	}
	
	protected void validate(Object source, Writer out) {
		if (source == null) {
			throw new IllegalArgumentException("Can not write null instance!");
		}
		
		if (out == null) {
			throw new IllegalArgumentException("Writer is null!");
		}
		
		if (Transformer.isPrimitive(source.getClass())) {
			throw new IllegalArgumentException("Can not write primitive or enum type object, " +
					"only Nano bindable complex type object can be accepted!");
		}
	}

	public void write(Object source, OutputStream os) throws WriterException, MappingException {
		try {
			this.write(source, new OutputStreamWriter(os, format.getEncoding()));
		} catch (UnsupportedEncodingException e) {
			throw new WriterException("Error to write/serialize object", e);
		}
	}

	public String write(Object source) throws WriterException, MappingException {
		StringWriter out = new StringWriter();
		this.write(source, out);
		return out.toString();
	}
	
	protected void writeObject(XmlSerializer serializer, Object source, String namespace) throws Exception {
		MappingSchema ms = MappingSchema.fromObject(source);
		
		// write xml attributes first
		writeAttributes(serializer, source, ms);
		
		// write xml value if any
		writeValue(serializer, source, ms);
		
		// write xml elements
		writeElements(serializer, source, ms, namespace);

		// write any elements if has
		writeAnyElements(serializer, source, ms);
	}
	
	private void writeAnyElements(XmlSerializer serializer, Object source, MappingSchema ms) throws Exception {
		AnyElementSchema anyElementSchema = ms.getAnyElementSchema();
		if (anyElementSchema != null) {
			Field field = anyElementSchema.getField();
			List<?> list = (List<?>) field.get(source);
			if (list != null) {
				for(Object entry : list) {
					if (entry != null) {
						if (entry instanceof Element) {
							this.writeDomElement(serializer, (Element)entry);
						} else {
							this.writeAnyObject(serializer, entry);
						}
					}
				}
			}
		}
	}
	
	private void writeDomElement(XmlSerializer serializer, Element element) throws Exception {
		if (element == null) return; // be cautious
		
		if (!StringUtil.isEmpty(element.getLocalName())) {
			String namespace = element.getNamespaceURI();
			
			serializer.startTag(namespace, element.getLocalName());
			
			NamedNodeMap nmap =  element.getAttributes(); // write attributes
			for(int i = 0; i < nmap.getLength(); i++) {
				if (nmap.item(i).getNodeType() == Node.ATTRIBUTE_NODE) {
					String name = nmap.item(i).getNodeName();
					String value = nmap.item(i).getNodeValue();
					serializer.attribute(null, name, value);
				}
			}
			
			if (element.hasChildNodes()) { // write children elements
				NodeList children = element.getChildNodes();
				for(int i = 0; i < children.getLength(); i++) {
					Node child = children.item(i);
					if (child.getNodeType() == Node.ELEMENT_NODE) {
						writeDomElement(serializer, (Element)child);
					} else if (child.getNodeType() == Node.TEXT_NODE) { // write element text
						String value = child.getNodeValue();
						if (!StringUtil.isEmpty(value)) { 
							serializer.text(value);
						}
					}
				}
			}
			
			serializer.endTag(namespace, element.getLocalName());
		}
	}
	
	private void writeAnyObject(XmlSerializer serializer, Object source) throws Exception {
		if (source  == null) return; // be cautious
		
		MappingSchema ms = MappingSchema.fromObject(source);
		RootElementSchema res = ms.getRootElementSchema();
		String namespace = res.getNamespace();
		String xmlName = res.getXmlName();
		
		serializer.startTag(namespace, xmlName);
		this.writeObject(serializer, source, namespace);
		serializer.endTag(namespace, xmlName);
	}
	
	private void writeAttributes(XmlSerializer serializer, Object source, MappingSchema ms) throws Exception {
		Map<String, AttributeSchema> field2AttributeSchemaMapping = ms.getField2AttributeSchemaMapping();
		for(String fieldName : field2AttributeSchemaMapping.keySet()) {
			AttributeSchema as = field2AttributeSchemaMapping.get(fieldName);
			Field field = as.getField();
			Object value = field.get(source);
			if (value != null) {
				String attValue = Transformer.write(value, field.getType());
				if (!StringUtil.isEmpty(attValue)) {
					serializer.attribute(null, as.getXmlName(), attValue);
				}
			}
		}
	}
	
	private void writeValue(XmlSerializer serializer, Object source, MappingSchema ms) throws Exception {
		ValueSchema vs = ms.getValueSchema();
		if (vs == null) return; // no ValueSchema, do nothing
		
		Field field = vs.getField();
		Object value = field.get(source);
		if (value != null) {
			String text = Transformer.write(value, field.getType());
			if (!StringUtil.isEmpty(text)) {
				if(vs.isData()) {
					serializer.cdsect(text);
				} else {
					serializer.text(text);
				}
			}
		}
	}
	
	private void writeElements(XmlSerializer serializer, Object source, MappingSchema ms, String namespace) throws Exception {
		Map<String, Object> field2SchemaMapping = ms.getField2SchemaMapping();
		for (String fieldName : field2SchemaMapping.keySet()) {
			Object schemaObj = field2SchemaMapping.get(fieldName);
			if (schemaObj instanceof ElementSchema) {
				ElementSchema es = (ElementSchema)schemaObj;
				Field field = es.getField();
				Object value = field.get(source);
				if (value != null) {
					if (es.isList()) {
						this.writeElementList(serializer, value, es, namespace);
					} else {
						this.writeElement(serializer, value, es, namespace);
					}
				}
			}
		}
	}
	
	private void writeElementList(XmlSerializer serializer, Object source, ElementSchema es, String namespace) throws Exception {
		for(Object value : (List<?>)source) {
			this.writeElement(serializer, value, es, namespace);
		}
	}
	
	private void writeElement(XmlSerializer serializer, Object source, ElementSchema es, String namespace) throws Exception {
		Class<?> type = null;
		if (es.isList()) {
			type = es.getParameterizedType();
		} else {
			type = es.getField().getType();
		}
		
		if (source == null) return; // do nothing
		
		String xmlName = es.getXmlName();
		
		// primitives
		if(Transformer.isPrimitive(type)) {
			String value = Transformer.write(source, type);
			if(StringUtil.isEmpty(value)) return;
			
			serializer.startTag(namespace, xmlName);
			if(es.isData()) {
				serializer.cdsect(value);
			} else {
				serializer.text(value);
			}
			serializer.endTag(namespace, xmlName);
			
			return;
		}
		
		// object
		serializer.startTag(namespace, xmlName);
		this.writeObject(serializer, source, namespace);
		serializer.endTag(namespace, xmlName);
	}

}
