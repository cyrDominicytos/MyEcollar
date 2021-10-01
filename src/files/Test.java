package files;

import java.net.InetAddress;
import java.security.CryptoPrimitive;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Test {
static Scanner lire = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String end = DonneeStatiques.dbformat2.format(new Date());
		String dt = LocalDate.now().plusDays(14).toString();
		end = dt+" "+end;
		System.out.println(end);
		//System.out.print("J'e suis a la home".replaceAll("'", "\\\\'"));
		
		
		/*InetAddress ip;
		try {
			
		}catch(UnknownHost)*/
		
	}

}
