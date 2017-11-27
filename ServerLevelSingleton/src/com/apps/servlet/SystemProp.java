package com.apps.servlet;

import java.util.Properties;

public class SystemProp {
public static void main(String[] args) {
	//System.setProperty("java.ext.dirs","E://FNFClockInOut");
	Properties prop =System.getProperties();
	for(Object prop1 : prop.keySet())
	{
		System.out.println(prop1+"----------"+prop.getProperty((String)prop1));	
	}
	
}
}
