import java.util.Scanner;

public class UrlParser {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		 String url = scan.nextLine();
		 scan.close();
		  int protocolIndex = url.indexOf("://");
		  String protocol = "";
		  if (protocolIndex > 0)  {
		   protocol = url.substring(0, protocolIndex);
		  }
		  
		  int resourceIndex = url.indexOf("/", protocolIndex + 3);
		  String server = "";
		  String resource = "";
		  if (resourceIndex > 0)  {
		   server = url.substring(protocolIndex + 3, protocolIndex + 3 + resourceIndex - protocolIndex - 3);
		   resource = url.substring(resourceIndex + 1);
		  }
		  else if (protocolIndex > 0) 
		  {
		   server = url.substring(protocolIndex + 3);
		  }
		  else   {
		   server = url.substring(protocolIndex + 1);
		  }		 
		  System.out.println(String.format("[protocol] = \"%s\"", protocol));
		  System.out.println(String.format("[server] = \"%s\"", server));
		  System.out.println(String.format("[resource] = \"%s\"", resource));

		  
		 }
	}

