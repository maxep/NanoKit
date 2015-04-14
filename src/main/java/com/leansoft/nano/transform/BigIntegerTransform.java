package com.leansoft.nano.transform;

import java.math.BigInteger;


/**
 * Transformer between a string and a java.math.BigInteger object
 * 
 * @author bulldog
 *
 */
class BigIntegerTransform implements Transformable<BigInteger> {

	public BigInteger read(String value) throws Exception {
		return new BigInteger(value);
	}

	public String write(BigInteger value) throws Exception {
		return value.toString();
	}

}
