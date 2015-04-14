package com.leansoft.nano.annotation.schema;

import java.lang.reflect.Field;

/**
 * This bean stores mapping between an XML element and a POJO field
 * 
 * @author bulldog
 *
 */
public class ElementSchema {
	
	private String xmlName;
	
	private Field field;
	
	private boolean data;
	
	private boolean list = false;
	
	private Class<?> parameterizedType;

	/**
	 * Check if this is a java.util.List filed, such as List&lt;T&gt;
	 * 
	 * @return true or false
	 */
	public boolean isList() {
		return list;
	}

	/**
	 * Set if this is a java.util.List field or not.
	 * 
	 * @param list
	 */
	public void setList(boolean list) {
		this.list = list;
	}
	
	/**
	 * Get parameterized type for a java.util.List field.
	 * 
	 * @return parameterized type.
	 */
	public Class<?> getParameterizedType() {
		return this.parameterizedType;
	}
	
	/**
	 * Set parameterized type for a java.util.List field
	 * 
	 * @param type
	 */
	public void setParameterizedType(Class<?> type) {
		this.parameterizedType = type;
	}

	/**
	 * Get XML element name
	 * 
	 * @return xml element name
	 */
	public String getXmlName() {
		return xmlName;
	}

	/**
	 * Set XML element name
	 * 
	 * @param xmlName
	 */
	public void setXmlName(String xmlName) {
		this.xmlName = xmlName;
	}

	/**
	 * Get POJO field
	 * 
	 * @return field
	 */
	public Field getField() {
		return field;
	}

	/**
	 * Set POJO field
	 * 
	 * @param field
	 */
	public void setField(Field field) {
		this.field = field;
	}

	/**
	 * Indicates if the string content of the field should be put 
	 * in a CDATA container on serialization
	 * 
	 * @return true or false
	 */
	public boolean isData() {
		return data;
	}

	/**
	 * Set if the string content of the field should be put 
	 * in a CDATA container on serialization
	 * 
	 * @param data
	 */
	public void setData(boolean data) {
		this.data = data;
	}
}
