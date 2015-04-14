// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

/**
 * 
 * Values to be used in choosing that an uploaded picture is added to the available pictures on the eBay site.
 * 
 */
public enum PictureUploadPolicyCodeType {

    /**
     * 
   * Specifies that an uploaded picture is added to the pictures available to a
   * seller on the eBay site.
   * 
     */
    ADD("Add"),
  

    /**
     * 
   * Specifies, first, that all pictures available to a seller on the eBay site are
   * removed, and then second, that the currently uploaded picture is made
   * available to the seller.
   *  
     */
    CLEAR_AND_ADD("ClearAndAdd"),
  

    /**
     * 
   *  (out) Reserved for internal or future use.
   * 
     */
    CUSTOM_CODE("CustomCode");
  
  
    private final String value;
  
    PictureUploadPolicyCodeType(String v) {
        value = v;
    }
    
    public String value() {
        return value;
    }
    
    public static PictureUploadPolicyCodeType fromValue(String v) {
        if (v != null) {
            for (PictureUploadPolicyCodeType c: PictureUploadPolicyCodeType.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
        }
        throw new IllegalArgumentException(v);
    }
}