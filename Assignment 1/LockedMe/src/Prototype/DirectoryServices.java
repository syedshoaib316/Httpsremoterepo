package Prototype;

import java.io.File;

public class DirectoryServices {
	
    private static Directory fileDirectory = new Directory();
    
    public static void PrintFiles() {
    	
    	fileDirectory.getFiles();

        for (File file : DirectoryServices.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static Directory getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(Directory fileDirectory) {
        DirectoryServices.fileDirectory = fileDirectory;
    }



}
