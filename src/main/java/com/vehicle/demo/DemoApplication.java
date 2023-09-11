package com.vehicle.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfig;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.SchemaVersion;
import com.github.victools.jsonschema.module.jackson.JacksonModule;
import com.github.victools.jsonschema.module.jakarta.validation.JakartaValidationModule;
import com.github.victools.jsonschema.module.swagger2.Swagger2Module;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(DemoApplication.class, args);
		
		JacksonModule jacksonModule = new JacksonModule();
		JakartaValidationModule validationModule = new JakartaValidationModule();
		Swagger2Module swaggerModule = new Swagger2Module();
		
		// Using jackson annotations and jarkarta validations
		SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2020_12, OptionPreset.PLAIN_JSON)
		    .with(jacksonModule)
		    .with(validationModule)
		    .with(swaggerModule);
		SchemaGeneratorConfig config = configBuilder.build();
		SchemaGenerator generator = new SchemaGenerator(config);
		JsonNode carJsonSchema = generator.generateSchema(Car.class);
		
		// Using swagger annotations
		SchemaGeneratorConfigBuilder configBuilder2 = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2020_12, OptionPreset.PLAIN_JSON)
				.with(swaggerModule);
		SchemaGeneratorConfig config2 = configBuilder2.build();
		SchemaGenerator generator2 = new SchemaGenerator(config2);
		JsonNode carRequestJsonSchema = generator2.generateSchema(CarRequest.class);
		
		System.out.println(carJsonSchema.toPrettyString());
		System.out.println("-------------Swagger annotations-----------------");
		System.out.println(carRequestJsonSchema.toPrettyString());
	}

}
