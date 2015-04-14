// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

/**
 * 
 * Specifies which bidder information to return.
 * 
 */
public enum GetAllBiddersModeCodeType {

    /**
     * 
   * (in) Returns all bidders for an ended or still-active
   * listing. It may be used by any user.
   * 
     */
    VIEW_ALL("ViewAll"),
  

    /**
     * 
   * (in) Returns all non-winning bidders for ended
   * listings only. It may be used only by a seller.
   * 
     */
    ENDED_LISTING("EndedListing"),
  

    /**
     * 
   * (in) Returns all non-winning bidders for an ended listing
   * who have not yet received a Second Chance Offer and noted
   * interest in receiving a Second Chance Offer. It may be used
   * only by a seller.
   * 
     */
    SECOND_CHANCE_ELIGIBLE_ENDED_LISTING("SecondChanceEligibleEndedListing"),
  

    /**
     * 
   * (out) Reserved for internal or future use.
   * 
     */
    CUSTOM_CODE("CustomCode");
  
  
    private final String value;
  
    GetAllBiddersModeCodeType(String v) {
        value = v;
    }
    
    public String value() {
        return value;
    }
    
    public static GetAllBiddersModeCodeType fromValue(String v) {
        if (v != null) {
            for (GetAllBiddersModeCodeType c: GetAllBiddersModeCodeType.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
        }
        throw new IllegalArgumentException(v);
    }
}