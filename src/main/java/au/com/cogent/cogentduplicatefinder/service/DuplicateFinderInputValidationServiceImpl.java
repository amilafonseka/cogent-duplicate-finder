package au.com.cogent.cogentduplicatefinder.service;

import java.io.File;

import au.com.cogent.cogentduplicatefinder.exception.ArgumentFormatException;

/**
 * Validates arguments input
 * 
 * @author amilasembunaidelage
 *
 */
public class DuplicateFinderInputValidationServiceImpl implements IDuplicateFinderInputValidationService {

	/**
	 * Validates the arguments input
	 *
	 * @param argument input
	 * @throws ArgumentFormatException
	 */
	@Override
	public void validateDuplicateFinderArgumentInput(String[] arguments) throws ArgumentFormatException {
		
		checkArgumentsLength(arguments);
		checkThePathIsADirectory(arguments);

	}
	
	private void checkArgumentsLength(String[] arguments) 
			throws ArgumentFormatException {
		
		if (arguments.length < 1) {
		
			throw new ArgumentFormatException("Please enter a directory path");
		
		}
		
	}
	
	private void checkThePathIsADirectory(String[] arguments) 
			throws ArgumentFormatException {
		
		File directory = new File(arguments[0]);
		
		if(!directory.isDirectory()) {
			
			throw new ArgumentFormatException("Entered directory does not exist");
			
		}
		
	}

}
