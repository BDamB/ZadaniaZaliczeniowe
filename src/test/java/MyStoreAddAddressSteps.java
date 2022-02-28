import Helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.NewAddressForm;

public class MyStoreAddAddressSteps {

    private WebDriver driver;
    NewAddressForm newAddressForm;


    @Given("user is on the My Store website and user has a register account")
    public void userIsOnTheMyStoreWebsiteAndUserHasARegisterAccount() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(10);
        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @When("user clicks Sign in button")
    public void userClicksSignInButton() {
        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span")).click();
    }

    @And("user inputs correct email , password and clicks sign in button below")
    public void userInputsCorrectEmailPasswordAndClicksSignInButtonBelow() {
        driver.findElement(By.name("email")).sendKeys("jankowski@jan.com");
        driver.findElement(By.name("password")).sendKeys("jankowski");
        driver.findElement(By.id("submit-login")).click();
    }

    @And("user clicks on Addresses section button")
    public void userClicksOnAddressesSectionButton() {

        driver.findElement(By.id("addresses-link")).click();
    }

    @And("user clicks +Create new address")
    public void userClicksCreateNewAddress() {
        driver.findElement(By.cssSelector("#content > div.addresses-footer > a > span")).click();
    }

    @And("user inputs field {string} , {string}, {string}, {string}, {string} , {string} and clicks Save button")
    public void userInputsFieldAndClicksSaveButton(String alias, String address, String city, String zip, String country, String phone) {
        newAddressForm = new NewAddressForm(driver);
        newAddressForm.fillTheForm(alias, address, city, zip, country, phone);

    }


    @Then("new address has been added and success message is displayed")
    public void newAddressHasBeenAddedAndSuccessMessageIsDisplayed() {
        Assertions.assertEquals("Address successfully added!",newAddressForm.getSuccessAddMessage());
    }
}
