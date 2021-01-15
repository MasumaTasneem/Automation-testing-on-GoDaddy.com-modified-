/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package godaddy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Masuma Tasneem
 */
public class Wait {
    
    public static void Insertkey(WebDriver driver, WebElement TextBar, int i, String key) throws InterruptedException  {
       
        new WebDriverWait(driver, i).until(ExpectedConditions.visibilityOf(TextBar));
        TextBar.sendKeys(key);
    }    
    
    
    public static void clickOnSearch(WebDriver driver, WebElement SearchButton, int i) throws InterruptedException  {
       
        new WebDriverWait(driver, i).until(ExpectedConditions.elementToBeClickable(SearchButton));
        SearchButton.click();
    }
    
    public static void clickOnCard(WebDriver driver, WebElement addToCard, int i) throws InterruptedException  {
       
        new WebDriverWait(driver, i).until(ExpectedConditions.elementToBeClickable(addToCard));
        addToCard.click();
    }
    
    public static String waitForCard(WebDriver driver, String selector, int i) throws InterruptedException  {
        
        
        WebElement AddedToCard = new WebDriverWait(driver, i).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
        String text = AddedToCard.getText();
        return text;
    }
    
}
