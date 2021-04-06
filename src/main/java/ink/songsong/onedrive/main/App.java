package ink.songsong.onedrive.main;

import ink.songsong.onedrive.graphtutorial.Authentication;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Java Graph Tutorial");
        System.out.println();

        Scanner input = new Scanner(System.in);
        // Load OAuth settings
//        final Properties oAuthProperties = new Properties();
//        try {
//            oAuthProperties.load(App.class.getResourceAsStream("oAuth.properties"));
//        } catch (IOException e) {
//            System.out.println("Unable to read OAuth configuration. Make sure you have a properly formatted oAuth.properties file. See README for details.");
//            return;
//        }

//        final String appId = oAuthProperties.getProperty("app.id");
        final String appId = "99a536ce-0388-4028-85f1-386eddba61fb";
//        final String[] appScopes = oAuthProperties.getProperty("app.scopes").split(",");
        final String[] appScopes = "User.Read,MailboxSettings.Read,Calendars.ReadWrite".split(",");

        // Get an access token
        Authentication.initialize(appId);
        final String accessToken = Authentication.getUserAccessToken(appScopes);

        int choice = -1;

        while (choice != 0) {
            System.out.println("Please choose one of the following options:");
            System.out.println("0. Exit");
            System.out.println("1. Display access token");
            System.out.println("2. View this week's calendar");
            System.out.println("3. Add an event");

            try {
                choice = input.nextInt();
            } catch (InputMismatchException ex) {
                // Skip over non-integer input
            }

            input.nextLine();

            // Process user choice
            switch(choice) {
                case 0:
                    // Exit the program
                    System.out.println("Goodbye...");
                    break;
                case 1:
                    // Display access token
                    System.out.println("Access token: " + accessToken);
                    break;
                case 2:
                    // List the calendar
                    break;
                case 3:
                    // Create a new event
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        input.close();
    }
}
