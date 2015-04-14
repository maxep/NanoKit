// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;
import java.util.Date;

/**
 * 
 * Details about a specific site.
 * 
 */
public class SiteDetailsType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "Site")
	@Order(value=0)
	public SiteCodeType site;	
	
	@Element(name = "SiteID")
	@Order(value=1)
	public Integer siteID;	
	
	@Element(name = "DetailVersion")
	@Order(value=2)
	public String detailVersion;	
	
	@Element(name = "UpdateTime")
	@Order(value=3)
	public Date updateTime;	
	
	@AnyElement
	@Order(value=4)
	public List<Object> any;	
	
    
}