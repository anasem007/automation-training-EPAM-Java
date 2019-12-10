package by.bsu.anasem.page;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarSelectionPage extends AbstractPage {

    private final String CAR_SELECTION_PAGE_URL = "https://www.rentalcars.com/SearchResults.do";
    private final Logger logger = LogManager.getRootLogger();

    protected CarSelectionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(CAR_SELECTION_PAGE_URL);
        logger.info("Car selection page opened");
        return this;
    }
}
