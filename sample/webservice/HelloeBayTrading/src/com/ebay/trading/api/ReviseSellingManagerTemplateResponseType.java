// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;

/**
 * 
 * Returns the template ID and the estimated fees for the revised listing.
 * 
 */
@RootElement(name = "ReviseSellingManagerTemplateResponse", namespace = "urn:ebay:apis:eBLBaseComponents")
public class ReviseSellingManagerTemplateResponseType extends AbstractResponseType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "SaleTemplateID")
	@Order(value=0)
	public Long saleTemplateID;	
	
	@Element(name = "Fees")
	@Order(value=1)
	public FeesType fees;	
	
	@Element(name = "CategoryID")
	@Order(value=2)
	public String categoryID;	
	
	@Element(name = "Category2ID")
	@Order(value=3)
	public String category2ID;	
	
	@Element(name = "VerifyOnly")
	@Order(value=4)
	public Boolean verifyOnly;	
	
	@Element(name = "SaleTemplateName")
	@Order(value=5)
	public String saleTemplateName;	
	
	@Element(name = "SellingManagerProductDetails")
	@Order(value=6)
	public SellingManagerProductDetailsType sellingManagerProductDetails;	
	
    
}