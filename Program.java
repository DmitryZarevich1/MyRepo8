import java.sql.*;
import java.util.Scanner;
public class Program {
	public static void main(String[] args) {
	    Program P = new Program();
	    P.open();
	    P.insert();
	    P.close();
	}
	Connection co;
	void open() {
		try {
		    Class.forName("org.sqlite.JDBC"); 
		    co = DriverManager.getConnection("jdbc:sqlite:users1.db");
		    System.out.println("Connecteddd"); 
	}
		catch(Exception e) {
		   System.out.println(e.getMessage()); 
		}
	}
	
	void insert() {
	    try {
	  
	    Scanner scr = new Scanner(System.in);
	    System.out.println("Enter the user name: ");
	    String name = scr.nextLine();
	    System.out.println("Enter the user's phone number: ");
	    String phone = scr.nextLine();
	    
	    String query = "INSERT INTO users1(name,phone) "+
	    "VALUES ('"+name+"','"+phone+"') ";
	    
	    Statement statement = co.createStatement();
	    statement.executeUpdate(query);
	    System.out.println("An entry has been added.");
	    }
	    catch(Exception e) {
		   System.out.println(e.getMessage()); 
		}
	}
	
	void close() {
	  try {
	      co.close();
	  }
	  catch(Exception e) {
		   System.out.println(e.getMessage()); 
		}
	}
}
