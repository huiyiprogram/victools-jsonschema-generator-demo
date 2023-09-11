package com.vehicle.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.vehicle.demo.enums.CarType;

public class Car extends Vehicle {
	
	@JsonProperty
	@JsonPropertyDescription("This is a description for car type")
	CarType carType;
	
	@JsonProperty(required = true)
	@JsonPropertyDescription("This is a description for remarks input")
	List<RemarksInput> remarksInput;
	
	@JsonProperty
	@JsonPropertyDescription("This is a description for owner ref")
	ObjectRef ownerRef;
}
