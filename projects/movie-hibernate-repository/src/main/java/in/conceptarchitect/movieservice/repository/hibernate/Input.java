package in.conceptarchitect.movieservice.repository.hibernate;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {
	
	static BufferedReader reader;
	
	static{
		try {
		reader=new BufferedReader(new InputStreamReader(System.in));
		}catch (Exception e) {
			//don't worry. there will be no exception
		}
	}
	
	public static String readString(String prompt) {
		try {
		System.out.print(prompt);
		return reader.readLine();
		}catch(Exception ex) {
			return "";
		}
	}
	
	public static int readInt(String prompt) {
		try {
			return Integer.parseInt(readString(prompt));
			
		}catch(Exception ex) {
			return 0;
		}
	}
	

}
