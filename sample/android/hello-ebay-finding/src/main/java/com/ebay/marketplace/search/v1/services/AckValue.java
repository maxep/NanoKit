// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.marketplace.search.v1.services;

/**
 * 
 * Indicates whether the error is a fatal error (causing the request to fail)
 * or a less severe error (a warning) that should be communicated to the user.
 * 
 */
public enum AckValue {

    /**
     * 
   * eBay successfully processed the request and the business data is returned
   * in the response. Note that it is possible for a response to return
   * Success, but still not contain the expected data in the result.
   * 
     */
    SUCCESS("Success"),
  

    /**
     * 
   * eBay encountered a fatal error during the processing of the request,
   * causing the request to fail. When a serious application-level error
   * occurs, the error is returned instead of the business data.
   * 
     */
    FAILURE("Failure"),
  

    /**
     * 
   * The request was successfully processed, but eBay encountered a non-fatal
   * error during the processing. For best results, requests should return
   * without warnings. Inspect the warning details and resolve the problem
   * before resubmitting the request.
   * 
     */
    WARNING("Warning"),
  

    /**
     * 
   * eBay successfully processed the request, but one or more non-fatal errors
   * occurred during the processing. For best results, requests should return
   * without warning messages. Inspect the message details and resolve any
   * problems before resubmitting the request.
   * 
     */
    PARTIAL_FAILURE("PartialFailure");
  
  
    private final String value;
  
    AckValue(String v) {
        value = v;
    }
    
    public String value() {
        return value;
    }
    
    public static AckValue fromValue(String v) {
        if (v != null) {
            for (AckValue c: AckValue.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
        }
        throw new IllegalArgumentException(v);
    }
}