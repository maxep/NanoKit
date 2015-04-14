// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

/**
 * 
 * Enumeration type that indicates whether the buyer's payment was above or below the actual
 * total cost of an order going through the new eBay payment process.
 * 
 */
public enum MismatchTypeCodeType {

    /**
     * 
   * This value indicates that the buyer paid more than the required amount.
   * 
     */
    OVER_PAYMENT("OverPayment"),
  

    /**
     * 
   * This value indicates that the buyer paid less than the required amount.
   * 
     */
    UNDER_PAYMENT("UnderPayment"),
  

    /**
     * 
   * (out) Reserved for internal or future use
   * 
     */
    CUSTOM_CODE("CustomCode");
  
  
    private final String value;
  
    MismatchTypeCodeType(String v) {
        value = v;
    }
    
    public String value() {
        return value;
    }
    
    public static MismatchTypeCodeType fromValue(String v) {
        if (v != null) {
            for (MismatchTypeCodeType c: MismatchTypeCodeType.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
        }
        throw new IllegalArgumentException(v);
    }
}