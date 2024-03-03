package ca.ruofan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Main {

    String filePath;
    String linkedinLink;
    List<String> dictionary = new ArrayList<String>();

    public Main(){
        Scanner userInput = new Scanner(System.in);

        System.out.print("**********Enter Dictionary Path:**********\n");
        this.filePath = userInput.nextLine();
        //System.out.println(this.filePath);

        try{
            File file = new File(this.filePath);
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()) {
                this.dictionary.add(readFile.nextLine());
            }
            readFile.close();
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }

        /*
        for(int i = 0; i < this.dictionary.size(); i++){
            System.out.println(this.dictionary.get(i));
        }
        */
        
        System.out.print("**********Enter Linkedin Link:**********\n");
        this.linkedinLink = userInput.nextLine();
        //System.out.println(linkedinLink);
        userInput.close();
    }
    
    public void get() {
        //FirefoxOptions option = new FirefoxOptions();
        //option.addArguments("--headless");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com/");
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.get();
    }
}