package com.vehicle.demo;

import java.util.List;

import com.vehicle.demo.enums.CarType;

public class Car extends Vehicle {
	CarType carType;
	List<RemarksInput> remarksInput;
	ObjectRef ownerRef;
}
