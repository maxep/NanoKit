// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.finding.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;

/**
 * 
 * Reserved for future use.
 * 
 */
@RootElement(name = "findItemsForFavoriteSearchResponse", namespace = "http://www.ebay.com/marketplace/search/v1/services")
public class FindItemsForFavoriteSearchResponse extends BaseFindingServiceResponse implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element
	@Order(value=0)
	public CategoryHistogramContainer categoryHistogramContainer;	
	
	@Element
	@Order(value=1)
	public AspectHistogramContainer aspectHistogramContainer;	
	
	@Element
	@Order(value=2)
	public ConditionHistogramContainer conditionHistogramContainer;	
	
    
}