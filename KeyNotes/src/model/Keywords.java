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
    		this.addKeyword(kw[i]);
    	}
    }
    
    //Add keyword to the observable map
	public void addKeyword(String kw) {
		
		if(this.observableMap.containsKey(kw)){

			int nb = this.observableMap.get(kw);
			this.observableMap.put(kw, nb+1);
			
		}
		else{
			this.observableMap.put(kw, 1);
		}
	}
	
	  
    //Remove keyword to the observable map
	public void removeKeyword(String kw) {
		if(this.observableMap.get(kw).intValue() > 1){
			int nb = this.observableMap.get(kw);
			this.observableMap.put(kw, nb-1);
		}
		else{
			this.observableMap.remove(kw);
		}
	}

	public ObservableMap<String, Integer> getObservableMap() {
		return observableMap;
	}

}
