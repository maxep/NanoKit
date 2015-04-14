// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * Lists the nonprofit charity organization affiliations for a specified user.
 * 
 */
public class CharityAffiliationsType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "CharityID")
	@Order(value=0)
	public List<CharityIDType> charityID;	
	
	@AnyElement
	@Order(value=1)
	public List<Object> any;	
	
    
}