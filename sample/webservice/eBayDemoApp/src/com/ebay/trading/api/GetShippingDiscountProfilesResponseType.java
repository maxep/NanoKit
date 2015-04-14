// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;

/**
 * 
 * Response to call of GetShippingDiscountProfiles.
 * 
 */
@RootElement(name = "GetShippingDiscountProfilesResponse", namespace = "urn:ebay:apis:eBLBaseComponents")
public class GetShippingDiscountProfilesResponseType extends AbstractResponseType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "CurrencyID")
	@Order(value=0)
	public CurrencyCodeType currencyID;	
	
	@Element(name = "FlatShippingDiscount")
	@Order(value=1)
	public FlatShippingDiscountType flatShippingDiscount;	
	
	@Element(name = "CalculatedShippingDiscount")
	@Order(value=2)
	public CalculatedShippingDiscountType calculatedShippingDiscount;	
	
	@Element(name = "PromotionalShippingDiscount")
	@Order(value=3)
	public Boolean promotionalShippingDiscount;	
	
	@Element(name = "CalculatedHandlingDiscount")
	@Order(value=4)
	public CalculatedHandlingDiscountType calculatedHandlingDiscount;	
	
	@Element(name = "PromotionalShippingDiscountDetails")
	@Order(value=5)
	public PromotionalShippingDiscountDetailsType promotionalShippingDiscountDetails;	
	
	@Element(name = "ShippingInsurance")
	@Order(value=6)
	public ShippingInsuranceType shippingInsurance;	
	
	@Element(name = "InternationalShippingInsurance")
	@Order(value=7)
	public ShippingInsuranceType internationalShippingInsurance;	
	
	@Element(name = "CombinedDuration")
	@Order(value=8)
	public CombinedPaymentPeriodCodeType combinedDuration;	
	
    
}