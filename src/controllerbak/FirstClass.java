package controllerbak;

import java.util.Arrays;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/details")
public class FirstClass {
	
//	@GET
//	@Path("/getDetails")
//	public String getDetails()
//	{
//		return "Hello Sudarshan";
//	}

	
	public  static void main(String...strings) {
		Scanner s = new Scanner(System.in);
        String ca = s.nextLine();   
        int res = 0;
        String vowels = "AEIOUaeiou";
        int cases = Integer.parseInt(ca);
        while(cases > 0){
            char[] line1 = s.nextLine().toCharArray(); 
            for(char v:line1){
                if(vowels.contains(v+"")) {
                	res+=1;
                }
            }
             System.out.println(res);
            
        }
	}
}
