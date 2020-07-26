package au.com.cogent.cogentduplicatefinder;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.cogent.cogentduplicatefinder.exception.ArgumentFormatException;
import au.com.cogent.cogentduplicatefinder.service.DuplicateFinderInputValidationServiceImpl;
import au.com.cogent.cogentduplicatefinder.service.DuplicateFinderServiceImpl;

/**
 * Entry point to the application
 * 
 * @author amilasembunaidelage
 *
 */
public class CogentDuplicateFinderApplication {

	public static void main(String[] args) {
		
		DuplicateFinderServiceImpl duplicateFinder = 
				new DuplicateFinderServiceImpl();
		
		DuplicateFinderInputValidationServiceImpl validationService = 
				new DuplicateFinderInputValidationServiceImpl();

		try {
			
			validationService.validateDuplicateFinderArgumentInput(args);
			
		} catch (ArgumentFormatException e) {
			
			System.out.println(e.getMessage());
			return;
		}
		
		File directory = new File(args[0]);
		
		Map<String, List<String>> lists = new HashMap<>();
		
		duplicateFinder.getFilePathsWithDuplicates(lists, directory);
		
		for ( List<String> list : lists.values()) {
			
			if ( list.size() > 1 ) {
				
				System.out.println("\n");
				for(String file : list) {
					
					System.out.println(file);
					
				}
				
			}
		}
		
		System.out.println("\n");

	}

}
