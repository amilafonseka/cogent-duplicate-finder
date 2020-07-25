package au.com.cogent.cogentduplicatefinder;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		if (args.length < 1) {
			
			System.out.println("Please enter a directory path");
			return;
			
		}
		
		File directory = new File(args[0]);
		
		if(!directory.isDirectory()) {
			
			System.out.println("Entered directory does not exist");
			return;
			
		}
		
		Map<String, List<String>> lists = new HashMap<String, List<String>>();
		
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
