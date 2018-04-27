package interviewQ;
// credit karma past interview q:
// Capitalize first word of a sentence in a string with multiple sentences
// String s="this is a.line is .over "
public class CapitalizeFirstWordOfSentences {
	public static String capitalize(String text) {
		if (text == null || text.length() == 0) return "";
		int pos = 0;
		boolean capitalize = true;
		StringBuilder sb = new StringBuilder(text);
		while (pos < sb.length()) {
			char c = sb.charAt(pos);
			if (c == '.' || c == '!' || c == '?')
				capitalize = true;
			else if (capitalize && !Character.isWhitespace(c)) {
				sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
				capitalize = false;
			}
			pos++;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(capitalize("this is.  a line. hello!")); //This is.  A line. Hello!

	}

}
