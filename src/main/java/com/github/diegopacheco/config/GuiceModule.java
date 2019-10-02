package com.github.diegopacheco.config;

import com.github.diegopacheco.rest.TimeServiceRestEndpoint;
import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(TimeServiceRestEndpoint.class).asEagerSingleton();
	}
	
}