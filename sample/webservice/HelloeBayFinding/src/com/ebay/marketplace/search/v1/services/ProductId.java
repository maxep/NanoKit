// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.marketplace.search.v1.services;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;

/**
 * 
 * Type that represents the unique identifier for a single product.
 * 
 */
public class ProductId implements Serializable {

    private static final long serialVersionUID = -1L;

	@Value
	@Order(value=0)
	public String value;	
	
	@Attribute  
	@Order(value=1)
	public String type;	
	
    
}