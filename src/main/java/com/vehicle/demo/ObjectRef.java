package com.vehicle.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectRef extends BaseObject {
	
	@JsonProperty(required = true)
	String id;
	
	@JsonProperty
	String collectionName;
	
}
