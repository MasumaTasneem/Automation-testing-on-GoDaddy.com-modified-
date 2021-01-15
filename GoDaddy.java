/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package godaddy;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.junit.Assert;


/**
 *
 * @author Masuma Tasneem
 */
public class GoDaddy {

    private static WebDriver driver= null;
    
    public static void main(String[] args) throws InterruptedException {
        
        
        //I have used Chrome for test run  
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\NetBeans 8.2\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        
        
        EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
        
        try{
        eventHandler.navigate().to("https://au.godaddy.com/");
        System.out.println("The webpage has loaded");}
        catch(Exception e){
            System.out.println("The webpage could not be loaded due to: "+e);
        }
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Wait waitObj = new Wait();          //Creating object for the 'Wait' class where wait methods are customized
       
        
        
        /***** TASK(1) SENDING VALUE INSIDE SEARCH BOX   ********/
        try{
        WebElement TextBar= driver.findElement(By.cssSelector("input[name='domainToCheck'][type='text']"));
        waitObj.Insertkey(driver, TextBar, 3, ".net");
        System.out.println(".net has been written inside search box");}
        catch(Exception e){
            System.out.println("The path to element can not be reached due to: "+e);
        }     
        
        
        
        
        /***** TASK(2) CLICKING SEARCH BUTTON ********/
        try{
        WebElement SearchButton= driver.findElement(By.cssSelector("button[aria-label='Search Domain'][type='Submit']"));
        waitObj.clickOnSearch(driver, SearchButton,3);
        System.out.println("Search button has been pressed");}
        catch(Exception e){
            System.out.println("The action is not performed due to: "+e);
        }
        
        
        
        java.util.Set<String>handles= driver.getWindowHandles();    //Just in case the search results open up in a new window 
        String winHandle1 = driver.getWindowHandle();               //Incase of this particular project it was not further handled 
        
        
        
        
        /***** TASK(3) ADD TO CARD *********/
        try{
            WebElement addToCard = driver.findElement(By.cssSelector("button[data-cy='dbs-add-to-cart-button']"));
            waitObj.clickOnCard(driver, addToCard, 5);
            System.out.println("The add to card button is pressed");
        }catch(Exception e)
        {
            System.out.println("The action is not performed due to: "+e);
        }
      
        
        
        
        
        /***** TASK(4) CHECK IF PRODUCT WAS ADDED TO THE CARD *********/
      
        String expectedText="Added";
        String selector = "span[class='text-black']";
        
        try{
            
        String changedText = waitObj.waitForCard(driver, selector, 15);
 
     
    
        if (expectedText.equals(changedText)) {
            System.out.println("SUCCESS");
        }
         else {
    
            System.out.println("ERROR");
        
        }
        }
        catch(Exception e){
        System.out.println("The value could not be fetched due to "+e);}
        
        /*
        try{
          Assert.assertEquals(expectedText, changedText);
          System.out.println("SUCCESS");
         }catch(AssertionError e){
          System.out.println("ERROR");

        throw e;
        }  */
        
        
        
        driver.close();
    
}

}
