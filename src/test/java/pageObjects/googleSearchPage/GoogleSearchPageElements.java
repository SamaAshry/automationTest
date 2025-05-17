package pageObjects.googleSearchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleSearchPageElements {
    By searchTextField = By.xpath("//textarea[@name='q']");
    By searchList = By.cssSelector("div.tF2Cxc");
    By nextPage = By.cssSelector(".oeN89d");
}
