// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * Retrieves the latest eBay category hierarchy for a given eBay site.
 * Information returned for each category includes the category name
 * and the unique ID for the category (unique within the eBay site for which
 * categories are retrieved). A category ID is a required input when you list most items.
 * 
 */
@RootElement(name = "GetCategoriesRequest", namespace = "urn:ebay:apis:eBLBaseComponents")
public class GetCategoriesRequestType extends AbstractRequestType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "CategorySiteID")
	@Order(value=0)
	public String categorySiteID;	
	
	@Element(name = "CategoryParent")
	@Order(value=1)
	public List<String> categoryParent;	
	
	@Element(name = "LevelLimit")
	@Order(value=2)
	public Integer levelLimit;	
	
	@Element(name = "ViewAllNodes")
	@Order(value=3)
	public Boolean viewAllNodes;	
	
    
}