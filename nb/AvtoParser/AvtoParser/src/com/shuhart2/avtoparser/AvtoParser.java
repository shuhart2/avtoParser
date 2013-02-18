/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuhart2.avtoparser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



/**
 *
 * @author newx
 */
public class AvtoParser {    
    public static void main(String[] args){
        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.get("http://ya.ru/");
        WebElement element = driver.findElement(By.id("text"));
        element.sendKeys("tits");
        element.submit();
    }
    
}
