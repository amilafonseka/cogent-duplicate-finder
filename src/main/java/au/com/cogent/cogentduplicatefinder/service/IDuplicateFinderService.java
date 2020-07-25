package au.com.cogent.cogentduplicatefinder.service;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface IDuplicateFinderService {

	List<String> getFilePathsWithDuplicates(
			Map<String, List<String>> fileList, File directory);
	
}
