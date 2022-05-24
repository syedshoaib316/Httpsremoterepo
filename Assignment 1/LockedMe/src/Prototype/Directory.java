package Prototype;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Directory {
	
	//Directory 
	
	   public static final String name = "src/main/directory/";

	   
	    private ArrayList<File> folders = new ArrayList<File>();
	    
	    Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
	    
	    File files = path.toFile();
	       
	    public String getName() {
	        return name;
	    }
	    
	    public void print() {
	    	System.out.println("Existing Files: ");
	    	folders.forEach(f -> System.out.println(f));
	    }

	    public ArrayList<File> putFiles() {
	    	
	        
			File[] directoryFiles = files.listFiles();
	        
	        
	        
	    	folders.clear();
	    	for (int i = 0; i < directoryFiles.length; i++) {
	    		if (directoryFiles[i].isFile()) {
	    			folders.add(directoryFiles[i]);
	    		}
	    	}
	    	
	    	Collections.sort(folders);
	    	return folders;
	    }

	    public ArrayList<File> getFiles() {
	    	
	    	putFiles();
	    	return folders;      
	    
	    public void mergeSort() {
	    	
	    }
	    
}

