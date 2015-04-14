// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.finding.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * Request container for the findItemsAdvanced call.
 * 
 */
@RootElement(name = "findItemsAdvancedRequest", namespace = "http://www.ebay.com/marketplace/search/v1/services")
public class FindItemsAdvancedRequest extends BaseFindingServiceRequest implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element
	@Order(value=0)
	public String keywords;	
	
	@Element
	@Order(value=1)
	public List<String> categoryId;	
	
	@Element
	@Order(value=2)
	public List<ItemFilter> itemFilter;	
	
	@Element
	@Order(value=3)
	public List<AspectFilter> aspectFilter;	
	
	@Element
	@Order(value=4)
	public List<OutputSelectorType> outputSelector;	
	
	@Element
	@Order(value=5)
	public Boolean descriptionSearch;	
	
	@Element
	@Order(value=6)
	public List<DomainFilter> domainFilter;	
	
    
}