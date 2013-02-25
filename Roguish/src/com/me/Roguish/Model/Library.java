package com.me.Roguish.Model;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.OrderedMap;

public class Library implements Serializable {
	private Map<Integer,Integer> library;
	
    public Library(){
        library = new HashMap<Integer,Integer>();
    }
    
    public Map<Integer,Integer> getLibrary(){
        return library;
    }
    
    public int getCardAmount(int cardNo){
        if( library == null ) return 0;
        Integer amount = library.get(cardNo);
        return (library == null ? 0 : amount);
    }

    @Override
    public void read(
        Json json,
        OrderedMap<String,Object> jsonData )
    {
        // libgdx handles the keys of JSON formatted HashMaps as Strings, but we
        // want it to be an integer instead (levelId)
        Map<String,Integer> library = json.readValue("library", HashMap.class, Integer.class, jsonData);
        for( String cardNoAsString : library.keySet() ) {
            int cardNo = Integer.valueOf(cardNoAsString);
            Integer amount = library.get(cardNoAsString);
            this.library.put(cardNo, amount);
        }
    }

	@Override
	public void write(Json json) {
		json.writeValue( "library", library );
		
	}    
}
