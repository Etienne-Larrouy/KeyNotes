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
    
    //Constructor with multiple keywords
    public Keywords(String...kw){
    	for(int i = 0; i<kw.length;i++){
    		this.addKeywords(kw[i]);
    	}
    }
    
    //Add keyword to the observable map
	public void addKeywords(String kw) {
		if(this.observableMap.containsKey(kw)){
			this.observableMap.put(kw, this.observableMap.get(kw)+1);
		}
		else{
			this.observableMap.put(kw, 0);
		}
	}

	public ObservableMap<String, Integer> getObservableList() {
		return observableMap;
	}

}
