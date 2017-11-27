package com.apps.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**  In case of normal ClassLoaders this hirarchary it will follw
 * 
 * loadClass(String fullyQulifiedName);
              ||
			  ||
			  ||
       findLoadedClass()		  
	          ||
			  ||
			  ||
	     findClass()
 *
 */
public class CustomClassLoader extends ClassLoader {
	public CustomClassLoader(String str){
		System.out.println("Custom Class Loader constructor "+str);
	}
	 public Class<?> findClass(String name) throws ClassNotFoundException {
		 ClassLoader classLoader = getSystemClassLoader();
		// System.out.println(CustomClassLoader.class);
		 System.out.println("custom class loader loaded by "+this.getClass().getClassLoader());
		 System.out.println("Parent class loader of custom class loader  "+getClass().getClassLoader().getParent());
		 System.out.println("Parent of Parent class loader  "+getClass().getClassLoader().getParent().getParent());
		 System.out.println("----------------------------------------------------------------");
		 Class<?> check = findLoadedClass(name);
		 System.out.println("ffffffffffffffffff     "+check);
		 Class<?> cl = null;
		 // this method is used for checking weather parent class loader is loaded or not
		 if(check == null){
			 try {
				 cl = super.findSystemClass(name);
				 System.out.println("xxxxxxxxxxxxxxxxxxxxxx    "+cl);
		          // cl = findSystemClass(name);
		        } catch (Exception e) {
		        } 
		 }
		 if(cl == null){
			 System.out.println("inside findSystemClass method of checking null");
			 byte[] bt = loadClassData(name);
	         cl =  defineClass(name, bt, 0, bt.length);
		 }
		 return cl;   
		// return classLoader.loadClass(name);
         
      }
      private byte[] loadClassData(String className) {
    	System.out.println("Custom ClassLoader class is loaded by "+getClass().getClassLoader());
    	System.out.println("System ClassLoader  "+getSystemClassLoader());
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/")+".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        int len =0;
        try {
              while((len=is.read())!=-1){
                   byteSt.write(len);
                   }
                } catch (IOException e) {
                     e.printStackTrace();
               }
        //convert into byte array
        return byteSt.toByteArray();
     }   
}
