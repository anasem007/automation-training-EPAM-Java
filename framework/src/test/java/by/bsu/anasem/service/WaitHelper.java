package by.bsu.anasem.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    public static void waitUntil(WebDriver webDriver, int time, By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void clickAndSend(WebElement element, String sendText) {
        element.click();
        element.sendKeys(sendText);
    }

    public static String clickAndUpdate(WebElement calendar, By byButton, By bySpan) {
        calendar.findElement(byButton).click();
        return calendar.findElement(bySpan).getText();
    }
}