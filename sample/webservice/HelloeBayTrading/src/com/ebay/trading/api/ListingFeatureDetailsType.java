// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;
import java.util.Date;

/**
 * 
 * Details about feature availability for the site.
 * 
 */
public class ListingFeatureDetailsType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "BoldTitle")
	@Order(value=0)
	public BoldTitleCodeType boldTitle;	
	
	@Element(name = "Border")
	@Order(value=1)
	public BorderCodeType border;	
	
	@Element(name = "Highlight")
	@Order(value=2)
	public HighlightCodeType highlight;	
	
	@Element(name = "GiftIcon")
	@Order(value=3)
	public GiftIconCodeType giftIcon;	
	
	@Element(name = "HomePageFeatured")
	@Order(value=4)
	public HomePageFeaturedCodeType homePageFeatured;	
	
	@Element(name = "FeaturedFirst")
	@Order(value=5)
	public FeaturedFirstCodeType featuredFirst;	
	
	@Element(name = "FeaturedPlus")
	@Order(value=6)
	public FeaturedPlusCodeType featuredPlus;	
	
	@Element(name = "ProPack")
	@Order(value=7)
	public ProPackCodeType proPack;	
	
	@Element(name = "DetailVersion")
	@Order(value=8)
	public String detailVersion;	
	
	@Element(name = "UpdateTime")
	@Order(value=9)
	public Date updateTime;	
	
	@AnyElement
	@Order(value=10)
	public List<Object> any;	
	
    
}