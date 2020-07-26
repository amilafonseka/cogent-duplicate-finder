package au.com.cogent.cogentduplicatefinder.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * This class contains all test cases for testing
 * 
 * @author amilasembunaidelage
 *
 */
public class DuplicateFinderServiceImplTest {

	DuplicateFinderServiceImpl duplicateFinder = new DuplicateFinderServiceImpl();
	
	@Test
	public void testSameDirectoryWithOneDuplicate() {
		
		Map<String, List<String>> lists = new HashMap<String, List<String>>();
		
		File directory = new File("src/test/resources");
		
		duplicateFinder.getFilePathsWithDuplicates(lists, directory);
		
		assertThat(lists.size(), is(2));
		
		for ( List<String> list : lists.values()) {
			
			if ( list.size() > 1 ) {
				
				assertTrue(list.stream().anyMatch(item -> 
					item.endsWith("src/test/resources/sameDirectoryWithOneDuplicate/s-08369.jpg")));
				
				assertTrue(list.stream().anyMatch(item -> 
					item.endsWith("src/test/resources/sameDirectoryWithOneDuplicate/quite a view.jpg")));
				
			}
			
		}
		
	}

}
