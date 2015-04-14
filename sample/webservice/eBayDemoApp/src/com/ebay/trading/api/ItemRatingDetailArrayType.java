// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * Container for a set of detailed seller ratings about an order line item.
 * If a seller has detailed ratings, they are displayed
 * in the Feedback Profile of the seller.
 * 
 */
public class ItemRatingDetailArrayType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "ItemRatingDetails")
	@Order(value=0)
	public List<ItemRatingDetailsType> itemRatingDetails;	
	
    
}