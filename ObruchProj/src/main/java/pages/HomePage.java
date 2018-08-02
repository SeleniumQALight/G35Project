package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//*[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpare;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarPresent(){
       return actionWithOurElements.isElementDisplayed(avatar);
    }

    public void clickOnMenuDictionary() {
        actionWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares(){
        actionWithOurElements.clickOnElement(subMenuSpare);
    }
}
