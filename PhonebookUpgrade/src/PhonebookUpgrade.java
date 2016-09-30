import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class PhonebookUpgrade {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
        String input = scan.nextLine();
        LinkedHashMap<String, String> phonebook = new LinkedHashMap<String, String>();
       
      while (!input.equals("END")){
         
          String[] contact = input.split("\\s+");
         
          String phone = "";
          
          if (contact[0].equals("A")){
        	  phone += contact[2].toString();
          	if (phonebook.containsKey(contact[1])){
          	   
               phonebook.put(contact[1], phone);
              }
              else{
               phonebook.put(contact[1], phone);
              }              	
          }
          else if (contact[0].equals("S")){
          	if (!phonebook.containsKey(contact[1])) {            		
          		System.out.println(String.format("Contact %s does not exist.", contact[1]));
              }
              else {
              	System.out.println(String.format("%s -> %s", contact[1], phonebook.get(contact[1])));
              }
          }
          else if (contact[0].equals("ListAll")){
          	Map<String, String> sorted = new TreeMap<String, String>(phonebook);
          	for (String key : sorted.keySet()) {
          		System.out.println(String.format("%s -> %s", key, phonebook.get(key)));
          	}
          }
          input = scan.nextLine();
      }
    scan.close();

	}

}
