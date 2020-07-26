package au.com.cogent.cogentduplicatefinder.service;

import au.com.cogent.cogentduplicatefinder.exception.ArgumentFormatException;

/**
 * Interface of argument input validation service
 * 
 * @author amilasembunaidelage
 *
 */
public interface IDuplicateFinderInputValidationService {

	void validateDuplicateFinderArgumentInput(String argument)
		throws ArgumentFormatException;
	
}
