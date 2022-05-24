package Prototype;

public class Pageoperations {

	
	public static WelcomePage WelcomeScreen = new WelcomePage();
    public static WelcomePage FileOptionsScreen = new Operations();
    
    

    public static WelcomePage CurrentScreen = WelcomeScreen;

    
    public static WelcomePage getCurrentScreen() {
        return CurrentScreen;
    }
    public static void setCurrentScreen(WelcomePage currentScreen) {
        CurrentScreen = currentScreen;
    }
    
   }

	
