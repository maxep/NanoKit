// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.amazon.webservices.awsecommerceservice._2011_08_01.cartitem.metadata;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;

public class KeyValuePair implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "Key")
	@Order(value=0)
	public String key;	
	
	@Element(name = "Value")
	@Order(value=1)
	public String value;	
	
    
}