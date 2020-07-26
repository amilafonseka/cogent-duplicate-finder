package au.com.cogent.cogentduplicatefinder.service;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import au.com.cogent.cogentduplicatefinder.exception.ArgumentFormatException;

/**
 * This class contains all test cases for testing
 * {@link au.com.cogent.cogentduplicatefinder.service.DuplicateFinderInputValidationServiceImpl}
 * 
 * @author amilasembunaidelage
 *
 */
public class DuplicateFinderInputValidationServiceImpltTest {

	DuplicateFinderInputValidationServiceImpl validationService = 
			new DuplicateFinderInputValidationServiceImpl();
	
	@Test
	public void testValidateArgumentInput_noArguments() {
		
		String[] arguments = new String[0];
		
		Throwable exception = assertThrows(ArgumentFormatException.class, 
				() -> validationService.validateDuplicateFinderArgumentInput(arguments));
		
		assertEquals("Please enter a directory path", exception.getMessage());
		
	}
	
	@Test
	public void testGivenPathIsADirectory() {
		
		String[] arguments = new String[1];
		
		arguments[0] = "src/test/resources/sameDirectoryWithOneDuplicate/s-08369.jpg";
		
		Throwable exception = assertThrows(ArgumentFormatException.class, 
				() -> validationService.validateDuplicateFinderArgumentInput(arguments));
		
		assertEquals("Entered directory does not exist", exception.getMessage());
		
	}

}
