// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.finding.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * eBay uses specified details to build a View Item URL and Product URL string
 * in the response. These URLs include correctly formatted affiliate tracking
 * information. When a user clicks through one of these URLs to eBay, the
 * respective affiliate might get a commission, based on the tasks performed by
 * the user.
 * 
 */
public class Affiliate implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element
	@Order(value=0)
	public String trackingId;	
	
	@Element
	@Order(value=1)
	public String networkId;	
	
	@Element
	@Order(value=2)
	public String customId;	
	
	@Element
	@Order(value=3)
	public Boolean geoTargeting;	
	
	@Element
	@Order(value=4)
	public String delimiter;	
	
	@AnyElement
	@Order(value=5)
	public List<Object> any;	
	
    
}