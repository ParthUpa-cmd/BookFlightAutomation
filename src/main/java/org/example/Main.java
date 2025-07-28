package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();
        driver.get("https://www.booking.com/flights");

        driver.findElement(By.xpath("//input[@id='search_type_option_ONEWAY']/following-sibling::label")).click();
        //Click Source button
        driver.findElement(By.xpath("//button[@data-ui-name='input_location_from_segment_0']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        //click source input box
        driver.findElement(By.xpath("//input[@data-ui-name='input_text_autocomplete']")).click();
        //click backspace at input box
        driver.findElement(By.xpath("//input[@data-ui-name='input_text_autocomplete']")).sendKeys(Keys.BACK_SPACE);
        //Enter source name in input box
        driver.findElement(By.xpath("//input[@data-ui-name='input_text_autocomplete']")).sendKeys("Delhi International Airport");
        //Select the checkbox
        driver.findElement(By.xpath("//ul[@id='flights-searchbox_suggestions']")).click();
        //Click destination location button
        driver.findElement(By.xpath("//button[@data-ui-name='input_location_to_segment_0']")).click();
        //Click on input box
        driver.findElement(By.xpath("//input[@data-ui-name='input_text_autocomplete']")).click();
        //Enter destination on input box
        driver.findElement(By.xpath("//input[@data-ui-name='input_text_autocomplete']")).sendKeys("Devi Ahilya Bai Holkar Airport");


    }
}