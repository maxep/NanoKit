// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;
import java.util.Date;

/**
 * 
 * If a seller has reduced the price of a listed item with the Promotional Price Display
 * feature, this type contains the original price of the discounted item and other
 * information.
 * 
 */
public class PromotionalSaleDetailsType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "OriginalPrice")
	@Order(value=0)
	public AmountType originalPrice;	
	
	@Element(name = "StartTime")
	@Order(value=1)
	public Date startTime;	
	
	@Element(name = "EndTime")
	@Order(value=2)
	public Date endTime;	
	
	@AnyElement
	@Order(value=3)
	public List<Object> any;	
	
    
}