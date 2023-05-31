import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Tests{
    HomePage home;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void initialize(){
        //driver = initializingDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\JetBrains\\AparTechnologies\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        home = new HomePage(driver);
        driver.get("https://subscribe.jawwy.tv/eg-en?");
    }

    @Test
    public void testCase1_SignUpAndLogin() {
        Assert.assertTrue(home.isLitePackageAvailable());
        Assert.assertTrue(home.isClassicPackageAvailable());
        Assert.assertTrue(home.isPremiumPackageAvailable());
        Assert.assertEquals(home.getLitePackagePrice(),"0.25");
        Assert.assertEquals(home.getLitePackageCurrency(),"USD/month");
        Assert.assertEquals(home.getClassicPackagePrice(),"0.5");
        Assert.assertEquals(home.getClassicPackageCurrency(),"USD/month");
        Assert.assertEquals(home.getPremiumPackagePrice(),"1");
        Assert.assertEquals(home.getPremiumPackageCurrency(),"USD/month");
        home.selectUae();
        Assert.assertEquals(home.getLitePackagePrice(),"5.4");
        Assert.assertEquals(home.getLitePackageCurrency(),"USD/month");
        Assert.assertEquals(home.getClassicPackagePrice(),"10.9");
        Assert.assertEquals(home.getClassicPackageCurrency(),"USD/month");
        Assert.assertEquals(home.getPremiumPackagePrice(),"16.3");
        Assert.assertEquals(home.getPremiumPackageCurrency(),"USD/month");
        home.selectAlgeria();
        Assert.assertEquals(home.getLitePackagePrice(),"2.7");
        Assert.assertEquals(home.getLitePackageCurrency(),"USD/month");
        Assert.assertEquals(home.getClassicPackagePrice(),"5.3");
        Assert.assertEquals(home.getClassicPackageCurrency(),"USD/month");
        Assert.assertEquals(home.getPremiumPackagePrice(),"8");
        Assert.assertEquals(home.getPremiumPackageCurrency(),"USD/month");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
