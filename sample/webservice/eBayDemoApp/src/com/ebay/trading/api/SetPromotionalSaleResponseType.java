// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;

/**
 * 
 * Contains the ID and status of a promotional sale.
 * The Promotional Price Display feature enables sellers
 * to apply discounts and/or free shipping across many listings.
 * 
 */
@RootElement(name = "SetPromotionalSaleResponse", namespace = "urn:ebay:apis:eBLBaseComponents")
public class SetPromotionalSaleResponseType extends AbstractResponseType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "Status")
	@Order(value=0)
	public PromotionalSaleStatusCodeType status;	
	
	@Element(name = "PromotionalSaleID")
	@Order(value=1)
	public Long promotionalSaleID;	
	
    
}