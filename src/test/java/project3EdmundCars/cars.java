package project3EdmundCars;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class cars {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//  1. Navigate to https://www.edmunds.com/
//  2. Click on Shop Used
        driver.get("https://www.edmunds.com/");
        driver.findElement(By.linkText("Shop Used")).click();


//3. In the next page, clear the zipcode field and enter 22031
        driver.findElement(By.name("zip")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE, "22031");
Thread.sleep(500);









//5. Choose Tesla for a make

WebElement addModelDropdown = driver.findElement(By.id("usurp-make-select"));

        new Select(driver.findElement(By.name("make"))).selectByValue("Tesla");

 //4. Check the following checkbox " Only show local listings"
        WebElement checkbox =  driver.findElement(By.xpath( "//div[@class='usurp-filter-checkbox']//label[@data-tracking-value='deliveryType~local~Only show local listings']//span[@class='checkbox checkbox-icon size-18 icon-checkbox-unchecked3 text-gray-form-controls'] "));
        JavascriptExecutor js = ( JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", checkbox);

//6.  Verify that the default selected option in Models dropdown is Any Model for Model
//dropdown. And the default years are 2012 and 2023 in year input fields.

        String models = new Select(driver.findElement(By.name("model"))).getFirstSelectedOption().getText();
        Assert.assertEquals(models,"Add Model");

String yearMin = driver.findElement(By.name("min-value-input")).getAttribute("value");
String yearMax = driver.findElement(By.name("max-value-input")).getAttribute("value");
Assert.assertEquals(yearMin, "2013");
Assert.assertEquals(yearMax, "2023");


//7. Verify that Model dropdown options are [Any Model, Model 3, Model S, Model X,
//Model Y, Cybertruck, Roadster]

   List<String> expectedModelsDropdown = List.of("Any Model, Model 3, Model S, Model X, Model Y, Cybertruck, Roadster");

   List <WebElement> actualModelsDropdown =  new Select(driver.findElement(By.xpath("//div[@class='styled-select chevron']//select[@id='usurp-model-select']//option[not(@text()='Add Model')] "))).getOptions();
        System.out.println(actualModelsDropdown);

//   List <String> actual = actualModelsDropdown.stream()
//            .map(s -> s.getText())
//            .collect(Collectors.toList());
//        System.out.println(actual);
//Assert.assertEquals(actual, expectedModelsDropdown);


 // 8. In Models dropdown, choose Model 3



        }
    }

