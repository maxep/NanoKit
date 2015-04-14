// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;

/**
 * 
 * Used to reply to feedback that has been left for a user, or to post a
 * follow-up comment to a feedback comment the user has left for someone else.
 * 
 */
@RootElement(name = "RespondToFeedbackRequest", namespace = "urn:ebay:apis:eBLBaseComponents")
public class RespondToFeedbackRequestType extends AbstractRequestType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "FeedbackID")
	@Order(value=0)
	public String feedbackID;	
	
	@Element(name = "ItemID")
	@Order(value=1)
	public String itemID;	
	
	@Element(name = "TransactionID")
	@Order(value=2)
	public String transactionID;	
	
	@Element(name = "TargetUserID")
	@Order(value=3)
	public String targetUserID;	
	
	@Element(name = "ResponseType")
	@Order(value=4)
	public FeedbackResponseCodeType responseType;	
	
	@Element(name = "ResponseText")
	@Order(value=5)
	public String responseText;	
	
	@Element(name = "OrderLineItemID")
	@Order(value=6)
	public String orderLineItemID;	
	
    
}