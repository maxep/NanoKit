// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.shopping.api;

/**
 * 
 * eBay sites (by the country in which each resides) on
 * which a user is registered and on which items can be listed.
 * 
 */
public enum SiteCodeType {

    /**
     * 
   * USA, site ID 0, abbreviation US, currency USD.
   * 
     */
    US("US"),
  

    /**
     * 
   * Canada, site ID 2, abbreviation CA, currencies CAD and USD.
   * 
     */
    CANADA("Canada"),
  

    /**
     * 
   * United Kingdom, site ID 3, abbreviation UK, currency GBP.
   * 
     */
    UK("UK"),
  

    /**
     * 
   * Australia, site ID 15, abbreviation AU, currency AUD.
   * 
     */
    AUSTRALIA("Australia"),
  

    /**
     * 
   * Austria, site ID 16, abbreviation AT, currency EUR.
   * 
     */
    AUSTRIA("Austria"),
  

    /**
     * 
   * Belgium (French), site ID 23, abbreviation BEFR, currency EUR.
   * 
     */
    BELGIUM_FRENCH("Belgium_French"),
  

    /**
     * 
   * France, site ID 71, abbreviation FR, currency EUR.
   * 
     */
    FRANCE("France"),
  

    /**
     * 
   * Germany, site ID 77, abbreviation DE, currency EUR.
   * 
     */
    GERMANY("Germany"),
  

    /**
     * 
   * Italy, site ID 101, abbreviation IT, currency EUR.
   * 
     */
    ITALY("Italy"),
  

    /**
     * 
   * Belgium (Dutch), site ID 123, abbreviation BENL, currency EUR.
   * 
     */
    BELGIUM_DUTCH("Belgium_Dutch"),
  

    /**
     * 
   * Netherlands, site ID 146, abbreviation NL, currency EUR.
   * 
     */
    NETHERLANDS("Netherlands"),
  

    /**
     * 
   * Spain, site ID 186, abbreviation ES, currency EUR.
   * 
     */
    SPAIN("Spain"),
  

    /**
     * 
   * Switzerland, site ID 193, abbreviation CH, currency CHF.
   * 
     */
    SWITZERLAND("Switzerland"),
  

    /**
     * 
   * Taiwan, site ID 196, abbreviation TW, currency TWD.
   * 
     */
    TAIWAN("Taiwan"),
  

    /**
     * 
   * eBay Motors, site ID 100, currency USD.
   * 
     */
    E_BAY_MOTORS("eBayMotors"),
  

    /**
     * 
   * Hong Kong, site ID 201, abbreviation HK, currency HKD.
   * 
     */
    HONG_KONG("HongKong"),
  

    /**
     * 
   * Singapore, site ID 216, abbreviation SG, currency SGD.
   * 
     */
    SINGAPORE("Singapore"),
  

    /**
     * 
   * India, site ID 203, abbreviation IN, currency INR.
   * 
     */
    INDIA("India"),
  

    /**
     * 
   * China, site ID 223, abbreviation CN, currency CNY.
   * 
     */
    CHINA("China"),
  

    /**
     * 
   * Ireland, site ID 205, abbreviation IE, currency EUR.
   * 
     */
    IRELAND("Ireland"),
  

    /**
     * 
   * Malaysia, site ID 207, abbreviation MY, currency MYR.
   * 
     */
    MALAYSIA("Malaysia"),
  

    /**
     * 
   * Philippines, site ID 211, abbreviation PH, currency PHP.
   * 
     */
    PHILIPPINES("Philippines"),
  

    /**
     * 
   * Poland, site ID 212, abbreviation PL, currency PLN.
   * 
     */
    POLAND("Poland"),
  

    /**
     * 
   * Sweden, site ID 218, abbreviation SE, currency SEK.
   * 
     */
    SWEDEN("Sweden"),
  

    /**
     * 
   * Placeholder value. See
   * <a href="types/simpleTypes.html#token">token</a>.
   * 
     */
    CUSTOM_CODE("CustomCode"),
  

    /**
     * 
   * CanadaFrench, site ID 210, abbreviation CAFR, currencies CAD and USD.
   * 
     */
    CANADA_FRENCH("CanadaFrench");
  
  
    private final String value;
  
    SiteCodeType(String v) {
        value = v;
    }
    
    public String value() {
        return value;
    }
    
    public static SiteCodeType fromValue(String v) {
        if (v != null) {
            for (SiteCodeType c: SiteCodeType.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
        }
        throw new IllegalArgumentException(v);
    }
}