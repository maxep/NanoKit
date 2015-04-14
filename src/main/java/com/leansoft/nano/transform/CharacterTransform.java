package com.leansoft.nano.transform;

/**
 * Transformer between a string and a Java Character object
 * 
 * @author bulldog
 *
 */
class CharacterTransform implements Transformable<Character> {

	public Character read(String value) throws Exception {
	      if(value.length() != 1) {
	          throw new IllegalArgumentException("Cannot transfrom " + value + " to a character");
	       }
	       return value.charAt(0);   
	}

	public String write(Character value) throws Exception {
	      return value.toString();
	}

}
