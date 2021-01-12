package io.github.mariazevedo88.javazktest;

import io.github.mariazevedo88.javazktest.connection.ZKConnection;
import io.github.mariazevedo88.javazktest.manager.ZKManager;
import io.github.mariazevedo88.javazktest.manager.ZKManagerImpl;

public class ZKCreateApplication {
	
	public static void main(String[] args) {

		//Znode path
		String path = "/MyFirstZnode"; //Assign path to Znode

		//Data in byte array
		byte[] data = "My first zookeeper app".getBytes(); //Declare data
		
		try {
			ZKConnection conn = new ZKConnection();
			conn.connect("localhost");
			
			ZKManager manager = new ZKManagerImpl();
			manager.create(path, data); //Create the data to the specified path
			
			System.out.println(path + " successfully created.");
			
			conn.close();
      
		} catch (Exception e) {
			System.out.println(e.getMessage()); //Catch error message
        }
    }

}
