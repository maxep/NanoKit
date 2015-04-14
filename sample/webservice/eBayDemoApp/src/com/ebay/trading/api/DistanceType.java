// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.util.List;

/**
 * 
 * This type is deprecated as the <b>GetProduct*</b> calls are no longer available.
 * 
 * 
 */
public class DistanceType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Element(name = "DistanceMeasurement")
	@Order(value=0)
	public int distanceMeasurement;	
	
	@Element(name = "DistanceUnit")
	@Order(value=1)
	public String distanceUnit;	
	
	@AnyElement
	@Order(value=2)
	public List<Object> any;	
	
    
}