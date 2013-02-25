package com.me.Roguish.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.me.Roguish.Model.Library;

public class LibraryService {
	private static final String CLASS_DATA_FILE = ".roguish/class.json";
	private Library classLibrary;
	private static final String RACE_DATA_FILE = ".roguish/race.json";
	private Library raceLibrary;
	
	public LibraryService(){
		
	}
	
	private Library retrieveLibrary(Library lib, String libfile){
		if( lib != null ) return lib;
		
		FileHandle libDataFile = Gdx.files.external(libfile);
		Json json = new Json();
		
		if(libDataFile.exists()){
			try{
				String libAsCode = libDataFile.readString();
                String libAsText = Base64Coder.decodeString(libAsCode);
                lib = json.fromJson(Library.class, libAsText);
			}catch(Exception e){ 
                lib = new Library(); // create new library
                persist(lib, libfile);
			}
		}else {
            // create a new library data file
            lib = new Library();
            persist(lib, libfile);
        }
		
		return lib;
	}
	
	public Library retrieveClassLibrary(){
		return retrieveLibrary(classLibrary, CLASS_DATA_FILE);
	}
	
	public Library retrieveRaceLibrary(){
		return retrieveLibrary(raceLibrary, RACE_DATA_FILE);
	}
	
    protected void persist(Library lib, String libfile)
    {
    	if(lib != null){
     		Json json = new Json();
    	
    		// create the handle for the profile data file
    		FileHandle libDataFile = Gdx.files.external(libfile);
    	
    		// convert the given profile to text
    		String libAsText = json.toJson(lib);
    	
    		// encode the text
    		String libAsCode = Base64Coder.encodeString(libAsText);
    	
    		// write the profile data file
    		libDataFile.writeString(libAsCode, false );
    	}
    }	
    
    
}