package ideyatech.stringcalc;

public class StringCalculator {

	public int calculate(String input) {
		
		if (input == null)
			return 0;
		else {
			input = input.trim();
			
			if (input.length() != 0) {
				if (input.contains("//")) {
					
					String delimiter = extractDelimiter(input);

					int sum = 0;
					
					input = input.replace("//", "");
					input = input.replace("[" + delimiter + "]", "");
					
					String[] splittedInput = input.split(delimiter);
					
					for (int i = 0; i < splittedInput.length; i++) {
						if (!splittedInput[i].equals("")) {
							if (Integer.parseInt(splittedInput[i]) < 0) {
								throwException();
							} else if (Integer.parseInt(splittedInput[i]) < 1000)
								sum += Integer.parseInt(splittedInput[i]);
						}
					}
					
					return sum;
					
				} else if (input.contains(",")) {
					
					String[] splittedInput = input.split(",");
					int sum = 0;
					
					for (int i = 0; i < splittedInput.length; i++) {
						if (!splittedInput[i].equals("")) {
							if (Integer.parseInt(splittedInput[i]) < 0) {
								throwException();
							} else if (Integer.parseInt(splittedInput[i]) < 1000)
								sum += Integer.parseInt(splittedInput[i]);
						}
					}
					
					return sum;
					
				} else if (Integer.parseInt(input) < 0) {
					
					throwException();
					
				} else if (Integer.parseInt(input) > 1000) {
					return 0;
				} else
					return Integer.parseInt(input);
				
			} else {
				return 0;
			}
		}
		return 0;
		
		//return 2;
	}

	private String extractDelimiter (String input) {

		char[] splittedCharInput = input.toCharArray();
		
		String delimiter = "";
		boolean readDelimiter = false;
		
		if (input.contains("[")) {
			for (int i = 0; i < splittedCharInput.length; i++) {
				
				if (splittedCharInput[i] == ']')
					return delimiter;
				
				if (readDelimiter)
					delimiter += splittedCharInput[i];
				
				if (splittedCharInput[i] == '[')
					readDelimiter = true;
			}
		} else {
			return splittedCharInput[2] + "";
		}
		
		return "";
	}

	private void throwException () {
		IllegalArgumentException e = new IllegalArgumentException();
		
		throw e;
	}
}
