// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.marketplace.search.v1.services;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;

/**
 * 
 * Get request for histogram information on the supplied category or aspect.
 * 
 */
@RootElement(name = "getHistogramsRequest", namespace = "http://www.ebay.com/marketplace/search/v1/services")
public class GetHistogramsRequest extends BaseServiceRequest implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element
	@Order(value=0)
	public String categoryId;	
	
    
}