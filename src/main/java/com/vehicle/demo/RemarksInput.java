package com.vehicle.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;

public class RemarksInput {
	
	@JsonProperty
	RemarksInputType inputType;
	
	@JsonProperty
	String remarks;
	
	@JsonProperty
	double numOfViewers;
	
	@JsonProperty
	@Email
	String email;
	
}
