// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;
import java.util.Date;

/**
 * 
 * Returns the item ID and the estimated fees for the re-listed listing.
 * 
 */
@RootElement(name = "RelistItemResponse", namespace = "urn:ebay:apis:eBLBaseComponents")
public class RelistItemResponseType extends AbstractResponseType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "ItemID")
	@Order(value=0)
	public String itemID;	
	
	@Element(name = "Fees")
	@Order(value=1)
	public FeesType fees;	
	
	@Element(name = "StartTime")
	@Order(value=2)
	public Date startTime;	
	
	@Element(name = "EndTime")
	@Order(value=3)
	public Date endTime;	
	
	@Element(name = "CategoryID")
	@Order(value=4)
	public String categoryID;	
	
	@Element(name = "Category2ID")
	@Order(value=5)
	public String category2ID;	
	
	@Element(name = "DiscountReason")
	@Order(value=6)
	public List<DiscountReasonCodeType> discountReason;	
	
	@Element(name = "ProductSuggestions")
	@Order(value=7)
	public ProductSuggestionsType productSuggestions;	
	
    
}