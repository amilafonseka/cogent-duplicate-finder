package au.com.cogent.cogentduplicatefinder.service;

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
	public void validateDuplicateFinderArgumentInput(String argument) throws ArgumentFormatException {
		
		checkNullAndEmpty(argument);

	}
	
	private void checkNullAndEmpty(String argument) 
			throws ArgumentFormatException {
		if(argument == null) {
			throw new ArgumentFormatException("Transaction text is NULL");
		
		} else if(argument.isEmpty()) {
			throw new ArgumentFormatException("Transaction text is empty");
		}
	}

}
