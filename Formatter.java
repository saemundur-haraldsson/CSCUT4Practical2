import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Formatter {
	public static String titleCaseConverter(String s) 
	{
		if (s == null || s.isEmpty()) {
			return s;
		}
		
		StringBuilder titleCase = new StringBuilder();
		boolean Capitalize = true;
		for (char ch : s.toCharArray()) {
			if (Character.isSpaceChar(ch)) {
				Capitalize = true;
			} else if (Capitalize) {
				ch = Character.toTitleCase(ch);
				Capitalize = false;
			} else {
				ch = Character.toLowerCase(ch);
			}
			titleCase.append(ch);
		}
		return titleCase.toString();
	}
	public static String titleCaseConverterM(String s) 
	{
		if (s == null || s.isEmpty()) {
			return s;
		}
		
		StringBuilder titleCase = new StringBuilder();
		boolean Capitalize = true;
		for (char ch : s.toCharArray()) {
			if (Character.isSpaceChar(ch)) {
				Capitalize = true;
			} else if (Capitalize) {
				ch = Character.toTitleCase(ch);
				Capitalize = false;
			} else {
				ch = Character.toLowerCase(ch);
			}
			titleCase.append(ch);
		}
		
		String fullName = titleCase.toString();
		String[] nameComponent = fullName.split(" ");
		String titleCaseM = "";
		if (nameComponent.length == 3) {
			nameComponent[1] = nameComponent[1] + ".";
		}
		for (int i = 0; i < nameComponent.length; i++) {
			titleCaseM = titleCaseM + nameComponent[i] + " ";
		}
		return titleCaseM.trim();
	}
	public static String titleCaseConverterMU(String s) 
	{
		if (s == null || s.isEmpty()) {
			return s;
		}
		
		String fullNameU = s.toUpperCase();
		String[] nameComponent = fullNameU.split(" ");
		String titleCaseMU = "";
		if (nameComponent.length == 3) {
			nameComponent[1] = nameComponent[1] + ".";
		}
		for (int i = 0; i < nameComponent.length; i++) {
			titleCaseMU = titleCaseMU + nameComponent[i] + " ";
		}
		return titleCaseMU.trim();
	}
	
	public static String dateConverter (String s)
	{
		if (s == null || s.isEmpty()) {
			return s;
		}
		
		SimpleDateFormat parser = new SimpleDateFormat("ddMMYYYY");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYY");
		try {
			Date date = parser.parse(s);
			String dateInString = formatter.format(date);
			return dateInString;
		} catch (ParseException e) {e.printStackTrace();}
		return s;
	}
	
}
