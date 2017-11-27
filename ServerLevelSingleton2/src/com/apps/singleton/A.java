package com.apps.singleton;

public class A {
	public static A instance;
	private A(){
		//dont remove this constructor
	}
	public static synchronized A getInstance() throws InterruptedException
	{
		if(instance == null)
		{
			System.out.println("inside if");
			instance = new A();
		}
		return instance;
	}
}