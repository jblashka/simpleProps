package com.redhat.it.util.props.provider;

import com.redhat.it.util.props.SimplePropSource;
import com.redhat.it.util.props.SimplePropertyException;

import java.io.IOException;
import java.util.Properties;

public class ClasspathPropertyFileSimplePropSource implements SimplePropSource {

	private final Properties properties;

	public ClasspathPropertyFileSimplePropSource(final String filePath) {
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(filePath));
		} catch (IOException | RuntimeException e) {
			throw new SimplePropertyException("Unable to load classpath resource: " + filePath, e);
		}
	}

	@Override
	public Properties getProperties() {
		return new Properties(properties);
	}
}
