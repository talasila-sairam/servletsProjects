package com.apps.singleton;
public class A {
	public static A instance;
	public A(){
		//dont remove this constructor
	}
	static{
		System.out.println("inside static block");
	}
	public static synchronized A getInstance() throws InterruptedException
	{
		if(instance == null)
		{
			System.out.println("inside if");
			instance = new A();
			System.out.println("hashcode of class A is  "+instance.hashCode());
			System.out.println("A class is loaded by  "+A.class.getClassLoader());
		}
		return instance;
	}
}