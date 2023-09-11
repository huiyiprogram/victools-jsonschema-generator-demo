package com.vehicle.demo;

import java.util.List;

import com.vehicle.demo.enums.CarType;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

public class CarRequest {
	
	@Schema(example = "HONDA")
	CarType carType;
	
	@ArraySchema(schema = @Schema(implementation = RemarksInput.class, description = "Get remarks input"))
	List<RemarksInput> remarksInput;
	
	@Schema(implementation = ObjectRef.class, description = "Get owner reference")
	ObjectRef ownerRef;
	
	@Schema(description = "field description", nullable = true, allowableValues = {"A", "B", "C", "D"}, minLength = 1, maxLength = 1)
	String test;
}
