// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * Container of ItemTransactionIDs.
 * 
 */
public class ItemTransactionIDArrayType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "ItemTransactionID")
	@Order(value=0)
	public List<ItemTransactionIDType> itemTransactionID;	
	
    
}