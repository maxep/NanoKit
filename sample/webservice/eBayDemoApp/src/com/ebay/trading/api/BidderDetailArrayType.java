// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * A collection of Bidder Detail.
 * 
 */
public class BidderDetailArrayType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "BidderDetail")
	@Order(value=0)
	public List<BidderDetailType> bidderDetail;	
	
    
}