package Prototype;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operations implements LockedmeUI {

	
private Directory dir = new Directory();
	
	private ArrayList<String> options = new ArrayList<>();

    public void FileOptionsScreen() {
    	
    	options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
        
    }
    
    @Override
    public void Display() {
    	System.out.println("File Options Menu");
        for (String s : options) {
            System.out.println(s);
        }

    }

    public void UserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.Navigation(selectedOption);
        }
    }

    @Override
    public void Navigation(int option) {
    	// Setting operations based on User input. Can use while loop but using switch() method instead 
        
    	switch(option) {

            case 1: // Add File
                this.AddFile();
                
                this.Display();
                break;
            case 2: // Delete File
                this.DeleteFile();
                
                this.Display();
                break;
            case 3: // Search File
                this.SearchFile();
                this.Display();
                break;
            default:
                System.out.println("Invalid Input");
                break;
                
                
        }

    }
    
    //Adding User requested file 

    public void AddFile() {
        System.out.println("Please Enter the File name:");

        String fileName = this.getInputString();

        System.out.println("Adding the file: " + fileName);
        
		try {
			Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
			File file = new File(dir.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	  dir.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("File already exists");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    //Deleting User requested file 
    
    public void DeleteFile() {
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("Deleting the file: " + fileName);
       
        
		Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());
	    	  dir.getFiles().remove(file);
	      } else {
	        System.out.println("Failed to delete file:" + fileName + ", file was not found.");
	      }
    }
    
    
    //Searching User requested file 
    
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are searching for a file named: " + fileName);
        
       
        ArrayList<File> files = dir.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("File not found");
        }
    }
    
    private String getInputString() {

        try (Scanner input = new Scanner(System.in)) {
			return(input.nextLine());
		}

    }
    
    private int getOption() {
        try (Scanner input = new Scanner(System.in)) {
			int returnOption = 0;
			try {
			    returnOption = input.nextInt();
			}
			catch (InputMismatchException ex) {
				System.out.println("Invalid input");
			}
			return returnOption;
		}

    }
}

