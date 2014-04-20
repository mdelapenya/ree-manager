package es.gme.ree.manager;

/**
 * Example App
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 */
public class App {

	public static void main(String[] args) {
		ValidationResult validationResult = _validate(args);

		if (!validationResult.getResult()) {
			_printUsage();

			System.exit(1);
		}

		ReeManager reeManager = new ReeManagerImpl(validationResult.getMonth(), validationResult.getYear());

		reeManager.process();
	}

	private static void _printUsage() {
		System.err.println("Usage: ");
		System.err.println("\tYear: a valid year");
		System.err.println("\tMonth: a valid month");
	}

	private static ValidationResult _validate(String[] args) {
		if (args.length != 2) {
			return new ValidationResult();
		}

		String strYear = args[0];
		String strMonth = args[1];

		try {
			int year = Integer.parseInt(strYear);

			int month = Integer.parseInt(strMonth);

			if (month < 1 || month > 12) {
				return new ValidationResult();
			}

			return new ValidationResult(month, year);
		}
		catch (NumberFormatException nfe) {
			return new ValidationResult();
		}
	}

	private static class ValidationResult {
		public ValidationResult() {
			_result = false;
		}

		public ValidationResult(int month, int year) {
			_result = true;
			_month = month;
			_year = year;
		}

		public int getMonth() {
			return _month;
		}

		public boolean getResult() {
			return _result;
		}

		public int getYear() {
			return _year;
		}

		private int _month;
		private boolean _result;
		private int _year;
	}

}