package io.permut.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/app")
public class Config extends ResourceConfig{

	 public Config(){
		 packages("io.Config");
	 }
}