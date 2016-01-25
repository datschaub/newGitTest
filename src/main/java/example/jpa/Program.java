package example.jpa;

import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		HelloResource con = new HelloResource();
		System.out.println(con);
		try {
			System.out.println(con.getInformation());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
