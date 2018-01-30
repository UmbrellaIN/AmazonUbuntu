package com.umbrella.Amazon.testCore;

import org.testng.IObjectFactory2;

public class ObjectFactory implements IObjectFactory2 {

	public ObjectFactory() {
		System.out.println("Custom Factory being created");
	}

	public Object newInstance(Class<?> cls) {
		try {
			return cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
