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
	public void testValidateArgumentInput_Null() {
		
		Throwable exception = assertThrows(ArgumentFormatException.class, 
				() -> validationService.validateDuplicateFinderArgumentInput(null));
		
		assertEquals("Argument text is NULL", exception.getMessage());
		
	}
	
	@Test
	public void testValidateArgumentInput_Empty() {
		
		Throwable exception = assertThrows(ArgumentFormatException.class,
				() -> validationService.validateDuplicateFinderArgumentInput(""));
		
		assertEquals("Argument text is empty", exception.getMessage());
		
	}

}
