package au.com.cogent.cogentduplicatefinder.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
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

	/**
	 * Test case to test one duplicate in the same directory
	 *
	 */
	@Test
	public void testSameDirectoryWithOneDuplicate() {

		Map<String, List<String>> lists = new HashMap<String, List<String>>();

		File directory = new File("src/test/resources/sameDirectoryWithOneDuplicate");

		duplicateFinder.getFilePathsWithDuplicates(lists, directory);

		//Only 2 lists should be there
		//One containing the duplicates and the one containing the non-duplicate
		assertThat(lists.size(), is(2));

		for (List<String> list : lists.values()) {

			if (list.size() > 1) {

				//Checking whether the list contains the duplicates
				assertTrue(list.stream().anyMatch(
						item -> item.endsWith("src/test/resources/sameDirectoryWithOneDuplicate/s-08369.jpg")));

				assertTrue(list.stream().anyMatch(
						item -> item.endsWith("src/test/resources/sameDirectoryWithOneDuplicate/quite a view.jpg")));

			}

		}

	}

	/**
	 * Test case to test multiple duplicates in the same directory
	 * 
	 */
	@Test
	public void testSameDirectoryWithMultipleDuplicates() {

		Map<String, List<String>> lists = new HashMap<String, List<String>>();

		File directory = new File("src/test/resources/sameDirectoryWithMultipleDuplicates");

		duplicateFinder.getFilePathsWithDuplicates(lists, directory);

		//Only 3 lists should be there
		//Two lists containing the duplicates and the remaining one containing the non-duplicate
		assertThat(lists.size(), is(3));

		List<String> listWithDuplicates = new ArrayList<>();

		for (List<String> list : lists.values()) {

			if (list.size() > 1) {

				//Putting the duplicates into the listWithDuplicates
				list.stream().forEach(item -> listWithDuplicates.add(item));

			}

		}

		//Check in the listWithDuplicates for the 2 duplicates
		assertTrue(listWithDuplicates.stream()
				.anyMatch(item -> item.endsWith("src/test/resources/sameDirectoryWithMultipleDuplicates/s-08369.jpg")));

		assertTrue(listWithDuplicates.stream().anyMatch(
				item -> item.endsWith("src/test/resources/sameDirectoryWithMultipleDuplicates/quite a view.jpg")));

		assertTrue(listWithDuplicates.stream()
				.anyMatch(item -> item.endsWith("src/test/resources/sameDirectoryWithMultipleDuplicates/s-37293.jpg")));

		assertTrue(listWithDuplicates.stream().anyMatch(item -> item
				.endsWith("src/test/resources/sameDirectoryWithMultipleDuplicates/that starfish again.jpg")));

	}
	
	/**
	 * Test case to test no duplicates in the same directory
	 * 
	 */
	@Test
	public void sameDirectoryWithNoDuplicates() {
		
		Map<String, List<String>> lists = new HashMap<String, List<String>>();

		File directory = new File("src/test/resources/sameDirectoryWithNoDuplicates");

		duplicateFinder.getFilePathsWithDuplicates(lists, directory);

		//3 lists should be there. One each for a particular image because there are no
		//duplicates
		assertThat(lists.size(), is(3));

		List<String> listWithDuplicates = new ArrayList<>();
		
		for (List<String> list : lists.values()) {

			if (list.size() > 1) {

				//Putting the duplicates into the listWithDuplicates
				list.stream().forEach(item -> listWithDuplicates.add(item));

			}

		}
		
		//Confirm there are no duplicates
		assertTrue(listWithDuplicates.isEmpty());
		
	}
	
	/**
	 * Test case to test multiple duplicates in multiple directories
	 * 
	 */
	@Test
	public void multipleDirectoriesWithMultipleDuplicates() {
		
		Map<String, List<String>> lists = new HashMap<String, List<String>>();

		File directory = new File("src/test/resources/multipleDirectoriesWithMultipleDuplicates");

		duplicateFinder.getFilePathsWithDuplicates(lists, directory);

		//3 lists should be there. Two for duplicates and one for non-duplicate image
		assertThat(lists.size(), is(3));

		List<String> listWithDuplicates = new ArrayList<>();
		
		for (List<String> list : lists.values()) {

			if (list.size() > 1) {

				//Putting the duplicates into the listWithDuplicates
				list.stream().forEach(item -> listWithDuplicates.add(item));

			}

		}
		
		//Check in the listWithDuplicates for the 2 duplicates
		assertTrue(listWithDuplicates.stream()
				.anyMatch(item -> item.endsWith("src/test/resources/multipleDirectoriesWithMultipleDuplicates/s-08369.jpg")));

		assertTrue(listWithDuplicates.stream().anyMatch(
				item -> item.endsWith("src/test/resources/multipleDirectoriesWithMultipleDuplicates/quite a view.jpg")));

		assertTrue(listWithDuplicates.stream()
				.anyMatch(item -> item.endsWith("src/test/resources/multipleDirectoriesWithMultipleDuplicates/"
						+ "childDirectory/s-37293.jpg")));

		assertTrue(listWithDuplicates.stream().anyMatch(item -> item
				.endsWith("src/test/resources/multipleDirectoriesWithMultipleDuplicates/"
						+ "childDirectory/that starfish again.jpg")));
		
	}
	
	/**
	 * Test case to test no duplicates in the multiple directories
	 * 
	 */
	@Test
	public void multipleDirectoriesWithNoDuplicates() {
		
		Map<String, List<String>> lists = new HashMap<String, List<String>>();

		File directory = new File("src/test/resources/multipleDirectoriesWithNoDuplicates");

		duplicateFinder.getFilePathsWithDuplicates(lists, directory);

		//4 lists should be there. One each for a particular image because there are no
		//duplicates
		assertThat(lists.size(), is(4));

		List<String> listWithDuplicates = new ArrayList<>();
		
		for (List<String> list : lists.values()) {

			if (list.size() > 1) {

				//Putting the duplicates into the listWithDuplicates
				list.stream().forEach(item -> listWithDuplicates.add(item));

			}

		}
		
		//Confirm there are no duplicates
		assertTrue(listWithDuplicates.isEmpty());
		
	}
	
	/**
	 * Test case to test no duplicates in the same level multiple directories
	 * 
	 */
	@Test
	public void sameLevelMultipleDirectoriesWithNoDuplicates() {
		
		Map<String, List<String>> lists = new HashMap<String, List<String>>();

		File directory = new File("src/test/resources/sameLevelMultipleDirectoriesWithNoDuplicates");

		duplicateFinder.getFilePathsWithDuplicates(lists, directory);

		//4 lists should be there. One each for a particular image because there are no
		//duplicates
		assertThat(lists.size(), is(4));

		List<String> listWithDuplicates = new ArrayList<>();
		
		for (List<String> list : lists.values()) {

			if (list.size() > 1) {

				//Putting the duplicates into the listWithDuplicates
				list.stream().forEach(item -> listWithDuplicates.add(item));

			}

		}
		
		//Confirm there are no duplicates
		assertTrue(listWithDuplicates.isEmpty());
		
	}
	
	/**
	 * Test case to test multiple duplicates in same level multiple directories
	 * 
	 */
	@Test
	public void sameLevelMultipleDirectoriesWithMultipleDuplicates() {
		
		Map<String, List<String>> lists = new HashMap<String, List<String>>();

		File directory = new File("src/test/resources/sameLevelMultipleDirectoriesWithMultipleDuplicates");

		duplicateFinder.getFilePathsWithDuplicates(lists, directory);

		//3 lists should be there. Two for duplicates and one for non-duplicate image
		assertThat(lists.size(), is(3));

		List<String> listWithDuplicates = new ArrayList<>();
		
		for (List<String> list : lists.values()) {

			if (list.size() > 1) {

				//Putting the duplicates into the listWithDuplicates
				list.stream().forEach(item -> listWithDuplicates.add(item));

			}

		}
		
		//Check in the listWithDuplicates for the 2 duplicates
		assertTrue(listWithDuplicates.stream()
				.anyMatch(item -> item.endsWith("src/test/resources/"
						+ "sameLevelMultipleDirectoriesWithMultipleDuplicates/sameLevelDirectory1/s-08369.jpg")));

		assertTrue(listWithDuplicates.stream().anyMatch(
				item -> item.endsWith("src/test/resources/"
						+ "sameLevelMultipleDirectoriesWithMultipleDuplicates/sameLevelDirectory1/quite a view.jpg")));

		assertTrue(listWithDuplicates.stream()
				.anyMatch(item -> item.endsWith("src/test/resources/sameLevelMultipleDirectoriesWithMultipleDuplicates/"
						+ "sameLevelDirectory2/s-37293.jpg")));

		assertTrue(listWithDuplicates.stream().anyMatch(item -> item
				.endsWith("src/test/resources/sameLevelMultipleDirectoriesWithMultipleDuplicates/"
						+ "sameLevelDirectory2/that starfish again.jpg")));
		
	}
	
	/**
	 * Test case to test a single directory with no files
	 * 
	 */
	@Test
	public void singleDirectoryWithNoFiles() {
		
		Map<String, List<String>> lists = new HashMap<String, List<String>>();

		File directory = new File("src/test/resources/singleEmptyDirectory");

		duplicateFinder.getFilePathsWithDuplicates(lists, directory);

		//list size shoulb be 0 as there are no files in the directory
		assertThat(lists.size(), is(0));
		
	}

}
