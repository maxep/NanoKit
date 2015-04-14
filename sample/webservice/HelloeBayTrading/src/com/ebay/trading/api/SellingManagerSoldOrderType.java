// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;
import java.util.Date;

/**
 * 
 * Contains information about a sale record.
 * 
 */
public class SellingManagerSoldOrderType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "SellingManagerSoldTransaction")
	@Order(value=0)
	public List<SellingManagerSoldTransactionType> sellingManagerSoldTransaction;	
	
	@Element(name = "ShippingAddress")
	@Order(value=1)
	public AddressType shippingAddress;	
	
	@Element(name = "ShippingDetails")
	@Order(value=2)
	public ShippingDetailsType shippingDetails;	
	
	@Element(name = "CashOnDeliveryCost")
	@Order(value=3)
	public AmountType cashOnDeliveryCost;	
	
	@Element(name = "TotalAmount")
	@Order(value=4)
	public AmountType totalAmount;	
	
	@Element(name = "TotalQuantity")
	@Order(value=5)
	public Integer totalQuantity;	
	
	@Element(name = "ItemCost")
	@Order(value=6)
	public AmountType itemCost;	
	
	@Element(name = "VATRate")
	@Order(value=7)
	public List<VATRateType> vatRate;	
	
	@Element(name = "NetInsuranceFee")
	@Order(value=8)
	public AmountType netInsuranceFee;	
	
	@Element(name = "VATInsuranceFee")
	@Order(value=9)
	public AmountType vatInsuranceFee;	
	
	@Element(name = "VATShippingFee")
	@Order(value=10)
	public AmountType vatShippingFee;	
	
	@Element(name = "NetShippingFee")
	@Order(value=11)
	public AmountType netShippingFee;	
	
	@Element(name = "NetTotalAmount")
	@Order(value=12)
	public AmountType netTotalAmount;	
	
	@Element(name = "VATTotalAmount")
	@Order(value=13)
	public AmountType vatTotalAmount;	
	
	@Element(name = "ActualShippingCost")
	@Order(value=14)
	public AmountType actualShippingCost;	
	
	@Element(name = "AdjustmentAmount")
	@Order(value=15)
	public AmountType adjustmentAmount;	
	
	@Element(name = "NotesToBuyer")
	@Order(value=16)
	public String notesToBuyer;	
	
	@Element(name = "NotesFromBuyer")
	@Order(value=17)
	public String notesFromBuyer;	
	
	@Element(name = "NotesToSeller")
	@Order(value=18)
	public String notesToSeller;	
	
	@Element(name = "OrderStatus")
	@Order(value=19)
	public SellingManagerOrderStatusType orderStatus;	
	
	@Element(name = "UnpaidItemStatus")
	@Order(value=20)
	public UnpaidItemStatusTypeCodeType unpaidItemStatus;	
	
	@Element(name = "SalePrice")
	@Order(value=21)
	public AmountType salePrice;	
	
	@Element(name = "EmailsSent")
	@Order(value=22)
	public Integer emailsSent;	
	
	@Element(name = "DaysSinceSale")
	@Order(value=23)
	public Integer daysSinceSale;	
	
	@Element(name = "BuyerID")
	@Order(value=24)
	public String buyerID;	
	
	@Element(name = "BuyerEmail")
	@Order(value=25)
	public String buyerEmail;	
	
	@Element(name = "SaleRecordID")
	@Order(value=26)
	public Long saleRecordID;	
	
	@Element(name = "CreationTime")
	@Order(value=27)
	public Date creationTime;	
	
	@Element(name = "RefundAmount")
	@Order(value=28)
	public AmountType refundAmount;	
	
	@Element(name = "RefundStatus")
	@Order(value=29)
	public String refundStatus;	
	
	@AnyElement
	@Order(value=30)
	public List<Object> any;	
	
    
}