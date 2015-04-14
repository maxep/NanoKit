// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * Contains the data that defines a site-based filter (used when searching for
 * items and filtering the search result set).
 * 
 */
public class SiteLocationType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "SiteID")
	@Order(value=0)
	public SiteIDFilterCodeType siteID;	
	
	@AnyElement
	@Order(value=1)
	public List<Object> any;	
	
    
}