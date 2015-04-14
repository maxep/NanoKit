// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * This type is deprecated as the eBay Express is no longer available.
 * 
 * 
 */
public class ExpressItemRequirementsType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "SellerExpressEligible")
	@Order(value=0)
	public Boolean sellerExpressEligible;	
	
	@Element(name = "ExpressOptOut")
	@Order(value=1)
	public Boolean expressOptOut;	
	
	@Element(name = "ExpressApproved")
	@Order(value=2)
	public Boolean expressApproved;	
	
	@Element(name = "ExpressEligibleListingType")
	@Order(value=3)
	public Boolean expressEligibleListingType;	
	
	@Element(name = "ExpressEnabledCategory")
	@Order(value=4)
	public Boolean expressEnabledCategory;	
	
	@Element(name = "EligiblePayPalAccount")
	@Order(value=5)
	public Boolean eligiblePayPalAccount;	
	
	@Element(name = "DomesticShippingCost")
	@Order(value=6)
	public Boolean domesticShippingCost;	
	
	@Element(name = "EligibleReturnPolicy")
	@Order(value=7)
	public Boolean eligibleReturnPolicy;	
	
	@Element(name = "Picture")
	@Order(value=8)
	public Boolean picture;	
	
	@Element(name = "EligibleItemCondition")
	@Order(value=9)
	public Boolean eligibleItemCondition;	
	
	@Element(name = "PriceAboveMinimum")
	@Order(value=10)
	public Boolean priceAboveMinimum;	
	
	@Element(name = "PriceBelowMaximum")
	@Order(value=11)
	public Boolean priceBelowMaximum;	
	
	@Element(name = "EligibleCheckout")
	@Order(value=12)
	public Boolean eligibleCheckout;	
	
	@Element(name = "NoPreapprovedBidderList")
	@Order(value=13)
	public Boolean noPreapprovedBidderList;	
	
	@Element(name = "NoCharity")
	@Order(value=14)
	public Boolean noCharity;	
	
	@Element(name = "CombinedShippingDiscount")
	@Order(value=15)
	public Boolean combinedShippingDiscount;	
	
	@Element(name = "ShipFromEligibleCountry")
	@Order(value=16)
	public Boolean shipFromEligibleCountry;	
	
	@Element(name = "PayPalAccountAcceptsUnconfirmedAddress")
	@Order(value=17)
	public Boolean payPalAccountAcceptsUnconfirmedAddress;	
	
	@AnyElement
	@Order(value=18)
	public List<Object> any;	
	
    
}