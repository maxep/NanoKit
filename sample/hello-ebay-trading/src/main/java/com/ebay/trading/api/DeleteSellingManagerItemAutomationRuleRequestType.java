// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;

/**
 * 
 * Removes the association of Selling Manager automation rules
 * to an item. Returns the remaining rules in the response.
 * <br><br>
 * This call is subject to change without notice; the
 * deprecation process is inapplicable to this call.
 * 
 */
@RootElement(name = "DeleteSellingManagerItemAutomationRuleRequest", namespace = "urn:ebay:apis:eBLBaseComponents")
public class DeleteSellingManagerItemAutomationRuleRequestType extends AbstractRequestType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "ItemID")
	@Order(value=0)
	public String itemID;	
	
	@Element(name = "DeleteAutomatedRelistingRule")
	@Order(value=1)
	public Boolean deleteAutomatedRelistingRule;	
	
	@Element(name = "DeleteAutomatedSecondChanceOfferRule")
	@Order(value=2)
	public Boolean deleteAutomatedSecondChanceOfferRule;	
	
    
}