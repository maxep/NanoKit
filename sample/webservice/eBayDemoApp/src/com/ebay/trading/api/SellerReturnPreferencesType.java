// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * Container for the return preferences of the seller for eBay Returns.
 * 
 */
public class SellerReturnPreferencesType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "OptedIn")
	@Order(value=0)
	public Boolean optedIn;	
	
	@AnyElement
	@Order(value=1)
	public List<Object> any;	
	
    
}