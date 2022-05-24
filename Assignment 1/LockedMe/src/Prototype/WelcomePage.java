package Prototype;

import Prototype.DirectoryServices;
import Prototype.Pageoperations;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WelcomePage implements LockedmeUI {


    private static final String DirectoryServices = null;
	private String welcomeText = "Welcome to LockedMe Prototype";
    private String developerText = "Name of the developer: Syed Shoaib";

    private ArrayList<String> options = new ArrayList<>();


    public WelcomePage() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }
    
    public void introWS() {
    	System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("\n");
        Display();
    }
    
    
    
    public void Display() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.Navigation(selectedOption);
        }
    }

    public void Navigation(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.DisplayFiles();
                
                this.Display();
                
                break;
                
            case 2: // Show File Options menu
            	Pageoperations.getCurrentScreen(); 
            	Pageoperations.setCurrentScreen(Pageoperations.FileOptionsScreen);
            	
                this.Display();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void DisplayFiles() {

        //TODO: Get the files from the Directory
    	
    	//Finished TODO Task

        System.out.println("List of Files: ");
        

    }
    
    private int getOption() {
        Scanner input = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = input.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }

	public void UserInput() {
		// TODO Auto-generated method stub
		
	}


}
