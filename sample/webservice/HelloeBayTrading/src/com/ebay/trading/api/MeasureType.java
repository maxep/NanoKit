// Generated by xsd compiler for android/java
// DO NOT CHANGE!
package com.ebay.trading.api;

import java.io.Serializable;
import com.leansoft.nano.annotation.*;
import java.math.BigDecimal;

/**
 * 
 * Basic type for specifying measures and the system of measurement.
 * A decimal value (e.g., 10.25) is meaningful
 * as a measure when accompanied by a definition of the unit of measure (e.g., Pounds),
 * in which case the value specifies the quantity of that unit.
 * A MeasureType expresses both the value (a decimal) and, optionally, the unit and
 * the system of measurement.
 * Details such as shipping weights are specified as measure types.
 * 
 */
public class MeasureType implements Serializable {

    private static final long serialVersionUID = -1L;

	@Value
	@Order(value=0)
	public BigDecimal value;	
	
	@Attribute  
	@Order(value=1)
	public String unit;	
	
	@Attribute  
	@Order(value=2)
	public MeasurementSystemCodeType measurementSystem;	
	
    
}