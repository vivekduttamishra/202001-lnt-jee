package in.conceptarchitect.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {
	
	static BufferedReader reader;
	static {
		try {
			reader= new BufferedReader(new InputStreamReader(System.in));
		}catch(Exception ex) {
			//don't worry. It won't be raised!
		}
	}
	
	public static String readString(String prompt, String defaultValue) {
		if(!defaultValue.isEmpty())
			prompt=prompt+"["+defaultValue+"]";
		System.out.print(prompt+": ");
		String s=defaultValue;
		try {
			s=reader.readLine();
			if(s==null || s.isEmpty())
				return defaultValue;
			
		}catch(Exception ex) {
			s=defaultValue;
		}
		
		return s;
	}

	public static String readString(String prompt) {
		return readString(prompt,"");
	}
	
	public static int readInt(String prompt , int defaultValue) {
		try {
			return Integer.parseInt( readString(prompt+"["+defaultValue+"]"));
		}catch(Exception ex) {
			return defaultValue;
		}
	}
	
	public static int readInt(String prompt ) {
		return readInt(prompt,0);
	}
	
	
}
