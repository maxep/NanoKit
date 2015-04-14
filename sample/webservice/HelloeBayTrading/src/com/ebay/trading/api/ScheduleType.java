// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;
import java.util.Date;

/**
 * 
 * Sellers create live auction catalogs and schedule their live auction events by using
 * the eBay Live Auctions Web site user interface. The seller can create a catalog in
 * the Live Auctions system several months before a sale.
 * 
 */
public class ScheduleType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "ScheduleID")
	@Order(value=0)
	public Integer scheduleID;	
	
	@Element(name = "ScheduleTime")
	@Order(value=1)
	public Date scheduleTime;	
	
	@AnyElement
	@Order(value=2)
	public List<Object> any;	
	
    
}