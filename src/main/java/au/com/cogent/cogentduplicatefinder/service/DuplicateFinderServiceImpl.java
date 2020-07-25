package au.com.cogent.cogentduplicatefinder.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Services finding the duplicates given a directory
 * 
 * @author amilasembunaidelage
 *
 */
public class DuplicateFinderServiceImpl implements IDuplicateFinderService {

	public void getFilePathsWithDuplicates(Map<String, List<String>> fileList, File directory) {

		for (File directoryIteration : directory.listFiles()) {

			// Iterate all sub directories recursively
			if (directoryIteration.isDirectory()) {

				getFilePathsWithDuplicates(fileList, directoryIteration);

			} else {

				try {

					// Read file in bytes
					FileInputStream fileInputStream = new FileInputStream(directoryIteration);

					byte[] fileDataInBytes = new byte[(int) directoryIteration.length()];

					fileInputStream.read(fileDataInBytes);

					fileInputStream.close();

					// Create a unique hash for the current file
					String uniqueHashForFile = new BigInteger(1, 
							MessageDigest.getInstance("SHA-512").digest(fileDataInBytes)).toString(16);
					
					// Create a String list to put the duplicate files
					List<String> duplicateList = fileList.get(uniqueHashForFile);
					
					// If the duplicateList is null, create a new duplicateList
					if(duplicateList == null) {
						
						duplicateList = new LinkedList<String>();
						
					}
					
					// Add the current file path to the duplicateList
					duplicateList.add(directoryIteration.getAbsolutePath());
					
					// Put the newly updated list to the map
					fileList.put(uniqueHashForFile, duplicateList);

				} catch (IOException e) {
					
					throw new RuntimeException("cannot read file " + directoryIteration.getAbsolutePath(), e);
					
				} catch (NoSuchAlgorithmException e) {
					
					throw new RuntimeException("cannot find SHA-512 hash algorithm", e);
					
				}

			}

		}
	}

}
