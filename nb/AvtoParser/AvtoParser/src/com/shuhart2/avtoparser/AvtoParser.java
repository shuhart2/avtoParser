/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuhart2.avtoparser;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


/**
 *
 * @author newx
 */
public class AvtoParser {    
    public static void main(String[] args) throws Exception{
        Logger logger = Logger.getLogger ("");
        //logger.setLevel (Level.OFF);
        String login = "pavel_f@66.ru";
        String password = "ewHJdsU54G";
        String phone = "+71234567890";
        
        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);
        //WebDriver driver =new FirefoxDriver();
        driver.get("http://avito.ru/");
        driver.findElements(By.cssSelector(".logon > a")).get(1).click();//Нажимаем вход
        
        driver.findElement(By.id("user_name")).sendKeys(login);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("quick_expire")).click();
        driver.findElement(By.id("quick_expire")).submit();
        
        driver.findElement(By.cssSelector(".first>a")).click();
        
        driver.findElement(By.id("fld_phone")).sendKeys(phone);
        driver.findElement(By.id("select-region")).click();
        
        driver.findElements(By.cssSelector("#location_select>.loc")).get(0).findElement(By.cssSelector("option[value='621590']")).click();
        
        driver.findElements(By.cssSelector("#location_select>.loc")).get(1).findElement(By.cssSelector("option[value='621630']")).click();        
        driver.findElement(By.id("apply_region")).click();
        
        driver.findElement(By.cssSelector("#fld_category_id option[value='11']")).click();
        
        driver.findElement(By.cssSelector("#flt_param_7 option[value='27']")).click();
        driver.findElement(By.id("fld_title")).sendKeys("Продам");
        driver.findElement(By.id("fld_description")).sendKeys("Все продам!");
        driver.findElement(By.id("fld_price")).sendKeys(Keys.BACK_SPACE, "10000");
        driver.findElement(By.id("fld_images")).sendKeys("/tmp/cats.jpg");
        Thread.sleep(9000);
        driver.findElement(By.id("fld_images")).sendKeys("/tmp/cats2.jpg");
        Thread.sleep(9000);
        driver.findElement(By.id("vas_free")).click();
        
        driver.findElement(By.id("form_submit")).click();
        
        System.out.println(driver.findElement(By.id("captcha_image")).getAttribute("src"));
        driver.quit();
    }
    
}
