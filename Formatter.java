import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * A collection of different methods that format names or dates.
 */
public class Formatter {
	// Formats a name to title case. Works with middle initials.
	public static String titleCaseConverter(String s) 
	{
		if (s == null || s.isEmpty()) {
			return s;
		}
		
		// Declare a new StringBuilder object.
		StringBuilder titleCase = new StringBuilder();
		
		// Declare and initialize Capitalize.
		boolean Capitalize = true;
		for (char ch : s.toCharArray()) {
			if (Character.isSpaceChar(ch)) {
			// Check for whitespace to indicate new word.
				Capitalize = true;
			} else if (Capitalize) {
			// Sets character to upper case and sets Capitalize to false.
				ch = Character.toTitleCase(ch);
				Capitalize = false;
			} else {
			// Sets character to lower case.
				ch = Character.toLowerCase(ch);
			}
			// Appends character to titleCase.
			titleCase.append(ch);
		}
		
		// Splits full name into an array using whitespace as the delimiter.
		String formattedName = titleCase.toString();
		String[] nameComponent = formattedName.split(" ");
		
		
		switch (nameComponent.length) {
			// Check for middle initials.
			case 3:
				// Add a full stop to the middle initial.
				nameComponent[1] = nameComponent[1] + ".";
				
				// Rebuild the full name.
				formattedName = "";
				for (String nameC : nameComponent) {
					formattedName = formattedName + nameC + " ";
				}
				
				// Return the formatted name.
				return formattedName.trim();
			default:
				// Return the formatted name.
				return formattedName;
		}
	}
	
	// Formats name with -u flag.
	public static String titleCaseConverterU(String s) 
	{
		if (s == null || s.isEmpty()) {
			return s;
		}
		
		// Format name to all upper case.
		String formattedName = s.toUpperCase();
		
		// Splits full name into an array using whitespace as the delimiter.
		String[] nameComponent = formattedName.split(" ");
		
		switch (nameComponent.length) {
		// Check for middle initials.
		case 3:
			// Add a full stop to the middle initial.
			nameComponent[1] = nameComponent[1] + ".";
			
			// Rebuild the full name.
			formattedName = "";
			for (String nameC : nameComponent) {
				formattedName = formattedName + nameC + " ";
			}
			
			// Return the formatted name.
			return formattedName.trim();
		default:
			// Return the formatted name.
			return formattedName;
		}
	}
	
	// Formats date to dd/MM/yyyy format.
	public static String dateConverter (String s)
	{
		if (s == null || s.isEmpty()) {
			return s;
		}
		
		// Set the pattern for the parser.
		SimpleDateFormat parser = new SimpleDateFormat("ddMMyyyy");
		// Set the pattern for formatting.
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			// Parse the date.
			Date date = parser.parse(s);
			// Format the date.
			String dateInString = formatter.format(date);
			// Return the formatted date.
			return dateInString;
		} catch (ParseException e) {e.printStackTrace();}
		return null;
	}
	
}
