import Helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;

public class MyStoreShoppingSteps {

    private WebDriver driver;



    @Given("user is on the My Store website and he earlier register an account")
    public void userIsOnTheMyStoreWebsiteAndHeEarlierRegisterAnAccount() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(10);
        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @When("user clicks in Sign in button")
    public void userClicksInSignInButton() {
        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span")).click();
    }

    @And("user inputs email, password to his account and clicks in Sign in button")
    public void userInputsEmailPasswordToHisAccountAndClicksInSignInButton() {
        driver.findElement(By.name("email")).sendKeys("jankowski@jan.com");
        driver.findElement(By.name("password")).sendKeys("jankowski");
        driver.findElement(By.id("submit-login")).click();
    }

    @And("user inputs {string} in search input window and clicks magnifier sign")
    public void userInputsInSearchInputWindowAndClicksMagnifierSign(String product) {
        driver.findElement(By.name("s")).sendKeys(product);
        driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/button/i")).click();
    }


    @And("user clicks in thumbnail of Hummingbird Printed Sweater")
    public void userClicksInThumbnailOfHummingbirdPrintedSweater() {
        driver.findElement(By.cssSelector("#js-product-list > div.products.row > article:nth-child(1) > div > div.product-description > h2 > a")).click();
    }

    @And("user choose {string} , {string}  and user adds product to the cart")
    public void userChooseAndUserAddsProductToTheCart(String size, String quantity) {
        driver.findElement(By.id("group_1")).sendKeys(size);

        WebDriverWait wait  = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.urlToBe("https://mystore-testlab.coderslab.pl/index.php?id_product=2&id_product_attribute=10&rewrite=brown-bear-printed-sweater&controller=product#/2-size-m"));
        WebElement quantityField = driver.findElement(By.cssSelector("#quantity_wanted"));
        quantityField.clear();
        quantityField.sendKeys(quantity);
        driver.findElement(By.cssSelector("#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button")).click();


    }

    @And("user clicks Proceed to checkout button and again clicks Proceed to checkout button in next window")
    public void userClicksProceedToCheckoutButtonAndAgainClicksProceedToCheckoutButtonInNextWindow() {
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")).click();
    }

    @And("user clicks Continue to confirm the address")
    public void userClicksContinueToConfirmTheAddress() {

        driver.findElement(By.name("confirm-addresses")).click();
    }

    @And("user clicks PrestaShop and clicks Continue to confirm")
    public void userClicksPrestaShopAndClicksContinueToConfirm() {
        driver.findElement(By.id("delivery_option_1")).submit();
        driver.findElement(By.name("confirmDeliveryOption")).click();
    }

    @And("user clicks circle button next to Pay by Check and clicks square checkbox to agree to the terms of service and clicks Order With An Obligation To Pay button")
    public void userClicksCircleButtonNextToPayByCheckAndClicksSquareCheckboxToAgreeToTheTermsOfServiceAndClicksOrderWithAnObligationToPayButton() {
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        driver.findElement(By.id("payment-confirmation")).click();
    }

    @Then("user sees the confirmation of success and the screenshot of this site will be taken")
    public void userSeesTheConfirmationOfSuccessAndTheScreenshotOfThisSiteWillBeTaken() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\Damian\\Desktop\\bony./image.png"));

//        driver.quit();
    }

}
