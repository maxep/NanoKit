// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * This is for FSBO.
 * Each of the subscriptions will have following options, which will define
 * "National" vs "Local" ad format listing.
 * "LocalOptional" : This will allow national and local listing.
 * "LocalOnly" : Seller can have Local listings only.
 * "NationalOnly" : Seller can not opt into local only exposure. It has to be
 * national listing.
 * 
 */
public class NonSubscriptionDefinitionType implements Serializable {

    private static final long serialVersionUID = -1L;

	@AnyElement
	@Order(value=0)
	public List<Object> any;	
	
    
}