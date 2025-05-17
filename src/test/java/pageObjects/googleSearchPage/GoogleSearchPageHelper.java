package pageObjects.googleSearchPage;

import Utilities.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class GoogleSearchPageHelper extends GoogleSearchPageElements {

    Actions actions = new Actions();


    public void openGoogle(){
        actions.openUrl("https://www.google.com/?hl=en");
    }

    public void typeIntoSearch() throws InterruptedException {
        actions.type(searchTextField,"Mercedes A Class");
        actions.findElement(searchTextField).submit();
    }

    public void searchForSpecificKeyWords() throws InterruptedException {

        Thread.sleep(5000); // wait for the next page to load
        String[] keywords = {"engine", "horsepower", "hp"};

        int paginationCount = 0;
        int resultIndex = 0;
        boolean found = false;

        while (!found) {
            List<WebElement> results = actions.saveResultInList(searchList);

//            System.out.println(results);
            for (int i = 0; i < results.size(); i++) {
                String text = results.get(i).getText().toLowerCase();

                for (String keyword : keywords) {
                    if (text.contains(keyword)) {
                        resultIndex = i + 1;
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            //If not found go to next page
            if (!found) {
                    actions.scrollDownPage();
                    actions.clickOnElement(nextPage);
                    paginationCount++;
                    Thread.sleep(1000); // wait for the next page to load
            }
        }

        // Output the result
        System.out.println("Found keyword in result #" + resultIndex);
        System.out.println("Paginations (Next clicks): " + paginationCount);

        actions.closeDriver();
    }
}
