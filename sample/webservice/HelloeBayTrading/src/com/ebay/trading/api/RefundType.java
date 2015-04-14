// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;
import java.util.Date;

/**
 * 
 * Contains information about a single refund. A refund contains information about the
 * amount refunded for an order line item to a single buyer.
 * <br/><br/> <span class="tablenote"><strong>Note:</strong> Three RefundType fields
 * (RefundFromSeller, RefundTime and TotalRefundToBuyer) are returned (for GetOrders)
 * only if a refund has been issued against a Half.com order line item.</span>
 * 
 */
public class RefundType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "RefundFromSeller")
	@Order(value=0)
	public AmountType refundFromSeller;	
	
	@Element(name = "TotalRefundToBuyer")
	@Order(value=1)
	public AmountType totalRefundToBuyer;	
	
	@Element(name = "RefundTime")
	@Order(value=2)
	public Date refundTime;	
	
	@Element(name = "RefundID")
	@Order(value=3)
	public String refundID;	
	
	@Element(name = "RefundTransactionArray")
	@Order(value=4)
	public RefundTransactionArrayType refundTransactionArray;	
	
	@Element(name = "RefundAmount")
	@Order(value=5)
	public AmountType refundAmount;	
	
	@Element(name = "RefundStatus")
	@Order(value=6)
	public RefundStatusCodeType refundStatus;	
	
	@Element(name = "RefundFailureReason")
	@Order(value=7)
	public RefundFailureReasonType refundFailureReason;	
	
	@Element(name = "RefundFundingSourceArray")
	@Order(value=8)
	public RefundFundingSourceArrayType refundFundingSourceArray;	
	
	@Element(name = "ExternalReferenceID")
	@Order(value=9)
	public String externalReferenceID;	
	
	@Element(name = "RefundRequestedTime")
	@Order(value=10)
	public Date refundRequestedTime;	
	
	@Element(name = "RefundCompletionTime")
	@Order(value=11)
	public Date refundCompletionTime;	
	
	@Element(name = "EstimatedRefundCompletionTime")
	@Order(value=12)
	public Date estimatedRefundCompletionTime;	
	
	@Element(name = "SellerNoteToBuyer")
	@Order(value=13)
	public String sellerNoteToBuyer;	
	
	@AnyElement
	@Order(value=14)
	public List<Object> any;	
	
    
}