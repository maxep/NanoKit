// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 *   Store font set.
 *   
 */
public class StoreFontType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "NameFace")
	@Order(value=0)
	public StoreFontFaceCodeType nameFace;	
	
	@Element(name = "NameSize")
	@Order(value=1)
	public StoreFontSizeCodeType nameSize;	
	
	@Element(name = "NameColor")
	@Order(value=2)
	public String nameColor;	
	
	@Element(name = "TitleFace")
	@Order(value=3)
	public StoreFontFaceCodeType titleFace;	
	
	@Element(name = "TitleSize")
	@Order(value=4)
	public StoreFontSizeCodeType titleSize;	
	
	@Element(name = "TitleColor")
	@Order(value=5)
	public String titleColor;	
	
	@Element(name = "DescFace")
	@Order(value=6)
	public StoreFontFaceCodeType descFace;	
	
	@Element(name = "DescSize")
	@Order(value=7)
	public StoreFontSizeCodeType descSize;	
	
	@Element(name = "DescColor")
	@Order(value=8)
	public String descColor;	
	
	@AnyElement
	@Order(value=9)
	public List<Object> any;	
	
    
}