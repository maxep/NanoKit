// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

public enum DescriptionTemplateCodeType {

    /**
     * 
   * The template details establish how pictures are to be
   * positioned relative to the description text.
   * 
     */
    LAYOUT("Layout"),
  

    /**
     * 
   * The template determines which eBay-provided theme (e.g.
   * Valentine's Day) is to be applied for presenting pictures
   * and description text.
   * 
     */
    THEME("Theme"),
  

    /**
     * 
   * Reserved for future use.
   * 
     */
    CUSTOM_CODE("CustomCode");
  
  
    private final String value;
  
    DescriptionTemplateCodeType(String v) {
        value = v;
    }
    
    public String value() {
        return value;
    }
    
    public static DescriptionTemplateCodeType fromValue(String v) {
        if (v != null) {
            for (DescriptionTemplateCodeType c: DescriptionTemplateCodeType.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
        }
        throw new IllegalArgumentException(v);
    }
}