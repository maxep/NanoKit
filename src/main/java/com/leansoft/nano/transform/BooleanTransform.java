package com.leansoft.nano.transform;

/**
 * Transformer between a string and a Java Boolean object
 * 
 * @author bulldog
 *
 */
class BooleanTransform implements Transformable<Boolean> {

	public Boolean read(String value) throws Exception {
		return Boolean.valueOf(value);
	}

	public String write(Boolean value) throws Exception {
		return value.toString();
	}

}
