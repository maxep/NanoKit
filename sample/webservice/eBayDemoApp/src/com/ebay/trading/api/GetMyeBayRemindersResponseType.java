// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;

/**
 * 
 * Returns totals of various reminder types from the user's My eBay account.
 * 
 */
@RootElement(name = "GetMyeBayRemindersResponse", namespace = "urn:ebay:apis:eBLBaseComponents")
public class GetMyeBayRemindersResponseType extends AbstractResponseType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "BuyingReminders")
	@Order(value=0)
	public RemindersType buyingReminders;	
	
	@Element(name = "SellingReminders")
	@Order(value=1)
	public RemindersType sellingReminders;	
	
    
}