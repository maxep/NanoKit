package com.leansoft.nano.transform;

/**
 * Transformer between a string and a Java Long object
 * 
 * @author bulldog
 *
 */
public class LongTransform implements Transformable<Long> {

	public Long read(String value) throws Exception {
	    return Long.valueOf(value);
	}

	public String write(Long value) throws Exception {
	    return value.toString();
	}

}
