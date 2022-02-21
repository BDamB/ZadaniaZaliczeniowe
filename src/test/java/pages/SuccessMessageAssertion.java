package pages;

import org.openqa.selenium.*;

import java.util.List;

public class SuccessMessageAssertion {
    private WebDriver driver;

    public String successMessageAssert(){
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"content-hook_order_confirmation\"]/div/div/div/h3"));
        return successMessage.getText();

    }
}
