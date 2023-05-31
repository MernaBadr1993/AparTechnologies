package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(id = "name-lite")
    private WebElement litePackage;

    @FindBy(id = "name-classic")
    private WebElement classicPackage;

    @FindBy(id = "name-premium")
    private WebElement premiumPackage;

    @FindBy(xpath = "//div[@id='currency-lite']//b")
    private WebElement litePrice;

    @FindBy(xpath = "//div[@id='currency-classic']//b")
    private WebElement classicPrice;

    @FindBy(xpath = "//div[@id='currency-premium']//b")
    private WebElement premiumPrice;

    @FindBy(xpath = "//div[@id='currency-lite']//i")
    private WebElement liteCurrency;

    @FindBy(xpath = "//div[@id='currency-classic']//i")
    private WebElement classicCurrency;

    @FindBy(xpath = "//div[@id='currency-premium']//i")
    private WebElement premiumCurrency;

    @FindBy(id = "country-btn")
    private WebElement countryButton;

    @FindBy(id = "eg")
    private WebElement egyptSelection;

    @FindBy(id = "ae")
    private WebElement uaeSelection;

    @FindBy(id = "dz")
    private WebElement algeriaSelection;

    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }

    public boolean isLitePackageAvailable(){
        wait.until(ExpectedConditions.visibilityOf(litePackage));
        return litePackage.isDisplayed();
    }

    public boolean isClassicPackageAvailable(){
        wait.until(ExpectedConditions.visibilityOf(classicPackage));
        return classicPackage.isDisplayed();
    }

    public boolean isPremiumPackageAvailable(){
        wait.until(ExpectedConditions.visibilityOf(premiumPackage));
        return premiumPackage.isDisplayed();
    }

    public String getLitePackagePrice(){
        wait.until(ExpectedConditions.visibilityOf(litePrice));
        return litePrice.getText();
    }

    public String getClassicPackagePrice(){
        wait.until(ExpectedConditions.visibilityOf(classicPrice));
        return classicPrice.getText();
    }

    public String getPremiumPackagePrice(){
        wait.until(ExpectedConditions.visibilityOf(premiumPrice));
        return premiumPrice.getText();
    }

    public String getLitePackageCurrency(){
        wait.until(ExpectedConditions.visibilityOf(liteCurrency));
        return liteCurrency.getText();
    }

    public String getClassicPackageCurrency(){
        wait.until(ExpectedConditions.visibilityOf(classicCurrency));
        return classicCurrency.getText();
    }

    public String getPremiumPackageCurrency(){
        wait.until(ExpectedConditions.visibilityOf(premiumCurrency));
        return premiumCurrency.getText();
    }

    public void selectEgypt(){
        countryButton.click();
        egyptSelection.click();
    }

    public void selectUae(){
        countryButton.click();
        uaeSelection.click();
    }

    public void selectAlgeria(){
        countryButton.click();
        algeriaSelection.click();
    }


}
