package Utilities;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Actions extends InitializeDriver {

    public void clickOnElement(By element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        getDriver().findElement(element).click();
    }

    public String getMessage(By element) {
        return getDriver().findElement(element).getText();
    }

    public WebElement findElement(By element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return getDriver().findElement(element);
    }

    public void isElementsDisplayed(By element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        List<WebElement> visibleElement = getDriver().findElements(element);
        int size = visibleElement.size();

        for (int i = 0; i < size; i++) {
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(visibleElement.get(i).findElement(element))).isDisplayed());
        }
    }

    public Boolean isElementDisplayed(By element) {
        return findElement(element).isDisplayed();
    }
    public void openUrl(String url){
        getDriver().get(url);
    }
    public void type(By element,String text){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        getDriver().findElement(element).sendKeys(text);
    }
    public void checkBox(By element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(element));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
    public List saveResultInList(By element){
       List<WebElement> results = getDriver().findElements(element);
        return results;
    }
    public void scrollDownPage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            // Scroll down to bottom
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Wait for page to load (adjust time if needed)
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Calculate new scroll height and compare with last scroll height
            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                // If heights are the same, all content loaded
                break;
            }
            lastHeight = newHeight;
        }
    }
    public void closeDriver(){
        quitDriver();
    }
}

