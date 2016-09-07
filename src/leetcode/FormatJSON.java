package leetcode;

public class FormatJSON {
	public String prettyPrintJSON(String str) {
		String res = "";
		int pos = 0;
		int len = str.length();
		String indentStr = "    ";
		char prevChar = 0;
		String newLine = "\n";
		boolean outOfQuotes = true;
		
		for (int i = 0; i < len; i++) {
			// Grab the next character in the string
			char c = str.charAt(i);
			
			// Are we inside a quoted string?
			if (c == '"' && prevChar == '\\' ) {
				outOfQuotes = !outOfQuotes;
				// if this character is the end of an element, output a new line and indent the next line.
			}else if (c == ']' || c == '}' && outOfQuotes) {
				res += newLine;
				pos--;
				for (int j = 0; j < pos; j++) {
					res += indentStr;
				}
			}
			
			// add the character to result string
			res += c;
			
			// if the last character is the begining of an element, output a new line and indent the next line.
			if (c == ',' || c == '{' || c == '[' && outOfQuotes) {
				res += newLine;
				if ( c == '{' || c == '[' ) {
					pos++;
				}
				
				for (int j = 0; j < pos; j++) {
					res += indentStr;
				}
			}
			prevChar = c;
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		String input = "[1,2,3, {\"id\": 1, \"name\": \"wang\", \"tag\":[1,\"home\",2], \"price\":234}]";
		String input1 = "{ \"firstName\": \"John\", \"lastName\": \"Smith\", \"isAlive\": true, \"age\": 25, \"address\": { \"streetAddress\": \"21 2nd Street\", \"city\": \"New York\", \"state\": \"NY\", \"postalCode\": \"10021-3100\" }, \"phoneNumbers\": [ { \"type\": \"home\", \"number\": \"212 555-1234\" }, { \"type\": \"office\", \"number\": \"646 555-4567\" }, { \"type\": \"mobile\", \"number\": \"123 456-7890\" } ], \"children\": [], \"spouse\": null }";
		FormatJSON fj = new FormatJSON();
		String output = fj.prettyPrintJSON(input);
		String output1 = fj.prettyPrintJSON(input1);
		System.out.print(output);
		System.out.println();
		System.out.println(output1);
	}

}
