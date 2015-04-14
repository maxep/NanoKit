// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * Contains data for controlling pagination in API requests.
 * Pagination of returned data is required for some calls and not
 * needed in or not supported for some calls. See the documentation
 * for individual calls to determine whether pagination is supported,
 * required, or desirable.
 * 
 */
public class PaginationType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "EntriesPerPage")
	@Order(value=0)
	public Integer entriesPerPage;	
	
	@Element(name = "PageNumber")
	@Order(value=1)
	public Integer pageNumber;	
	
	@AnyElement
	@Order(value=2)
	public List<Object> any;	
	
    
}