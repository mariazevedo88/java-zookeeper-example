package io.github.mariazevedo88.javazktest;

import io.github.mariazevedo88.javazktest.connection.ZKConnection;
import io.github.mariazevedo88.javazktest.manager.ZKManager;
import io.github.mariazevedo88.javazktest.manager.ZKManagerImpl;

public class ZKRemoveApplication {

	public static void main(String[] args) {

		String path = "/MyFirstZnode"; //Assign path to the Znode
		
	    try {
	    	
	    	ZKConnection conn = new ZKConnection();
	        conn.connect("localhost");
	        
	        ZKManager manager = new ZKManagerImpl();
			manager.delete(path); //delete the node with the specified path
	        
	        System.out.println(path + " deleted successfully.");
			
			conn.close();
	        
	    } catch(Exception e) {
	        System.out.println(e.getMessage()); //catches error messages
	    }
	}

}
