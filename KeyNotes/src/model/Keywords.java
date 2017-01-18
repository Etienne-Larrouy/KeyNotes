package model;

import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class Keywords {
	
	// Use Java Collections to create the List.
    private Map<String, Integer> keywords = new HashMap<String, Integer>();

    // Now add observability by wrapping it with ObservableMap.
    private ObservableMap<String, Integer> observableMap = FXCollections.observableMap(keywords);

	public void addKeywords(String kw) {
		this.observableMap.put(kw, 0);
	}

	public ObservableMap<String, Integer> getObservableList() {
		return observableMap;
	}

}
