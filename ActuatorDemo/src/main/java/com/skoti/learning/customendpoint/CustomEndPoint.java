package com.skoti.learning.customendpoint;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "release-notes")
public class CustomEndPoint {

	Map<String, List<String>> releaseNotesMap = new LinkedHashMap<>();
	
	@PostConstruct
	public void initNotes() {
		releaseNotesMap.put("version-1.0", Arrays.asList("Home Page created", "Adding new item to form"));
		releaseNotesMap.put("version-2.0", Arrays.asList("Fixed bugs", "User experience improved"));
	}
	
	//@ReadOperation acts as a GetMapping
	@ReadOperation
	public Map<String, List<String>> getReleaseNotes() {
		return releaseNotesMap;
	}
	
	//@Selector acts as a @PathVariable
	@ReadOperation
	public List<String> getNotesByVersion(@Selector String version) {
		return releaseNotesMap.get(version);
	}
	
	@WriteOperation  //acts as PostMapping
	public void addReleaseNotes(@Selector String version, String releaseNotes) {
		releaseNotesMap.put(version, Arrays.stream(releaseNotes.split(",")).collect(Collectors.toList()));
	}
	
	@DeleteOperation  //acts as DeleteMapping
	public void deleteNotes(@Selector String version) {
		releaseNotesMap.remove(version);
	}
}
