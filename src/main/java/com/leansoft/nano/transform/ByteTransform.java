package com.leansoft.nano.transform;

/**
 * Transformer between a string and a Java Byte object
 * 
 * @author bulldog
 *
 */
class ByteTransform implements Transformable<Byte> {

	public Byte read(String value) throws Exception {
		return Byte.valueOf(value);
	}

	public String write(Byte value) throws Exception {
		return value.toString();
	}

}
