import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchAndAddToCartTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://adnabu-store-assignment1.myshopify.com/");
    }

    @Test
    public void searchAndAddProductToCart() {

        String password = "AdNabuQA";
        login(password);
        String productName = "The Collection Snowboard: Oxygen";
        String partialProductName = "The Collection Snowboard";
        searchProduct(partialProductName);
        selectFromSuggestions(productName);
        addProductToCart();
        verifyProductAdded();
    }

    public void login(String password) {

        By storePassword = By.id("password");
        By enter = By.xpath("//button[text()='Enter']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(storePassword))
                .sendKeys(password);

        driver.findElement(enter).click();
    }

    public void searchProduct(String partialProductName) {

        By searchIcon = By.xpath("//*[local-name()='svg'][*[local-name()='use' and @href='#icon-search']]");
        By searchBox = By.id("Search-In-Modal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchIcon))
                .click();
        driver.findElement(searchBox).sendKeys(partialProductName);
    }

    public void selectFromSuggestions(String productName) {

        By suggestionList = By.cssSelector(".predictive-search__list-item");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestionList));
        List<WebElement> suggestions = driver.findElements(suggestionList);

        for (WebElement item : suggestions) {
            if (item.getText().contains(productName)) {
                item.click();
                break;
            }
        }
    }

    public void addProductToCart() {

        By addToCartBtn = By.cssSelector("button[name='add'][type='submit']");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn))
                .click();
    }

    public void verifyProductAdded() {

        By cartCount = By.className("quantity__input");
        WebElement element = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(cartCount));
        String count=element.getAttribute("value");


        Assert.assertEquals(count, "1", "Product not added successfully.");
        System.out.println("Product added to the cart successfully");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}

