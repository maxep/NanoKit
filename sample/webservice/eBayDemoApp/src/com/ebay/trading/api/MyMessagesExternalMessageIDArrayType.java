// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * Contains a list of up to 10 external message IDs.
 * 
 */
public class MyMessagesExternalMessageIDArrayType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "ExternalMessageID")
	@Order(value=0)
	public List<String> externalMessageID;	
	
    
}