// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * Checks the arguments that you plan to use for a RelistItem call, looking for errors
 * and listing fees, without actually relisting the item.
 * 
 */
@RootElement(name = "VerifyRelistItemRequest", namespace = "urn:ebay:apis:eBLBaseComponents")
public class VerifyRelistItemRequestType extends AbstractRequestType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "Item")
	@Order(value=0)
	public ItemType item;	
	
	@Element(name = "DeletedField")
	@Order(value=1)
	public List<String> deletedField;	
	
    
}