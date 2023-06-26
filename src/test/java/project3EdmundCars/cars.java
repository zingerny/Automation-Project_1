package project3EdmundCars;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class cars {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//  1. Navigate to https://www.edmunds.com/
//  2. Click on Shop Used
        driver.get("https://www.edmunds.com/");
        driver.findElement(By.linkText("Shop Used")).click();


//3. In the next page, clear the zipcode field and enter 22031
        driver.findElement(By.name("zip")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE, "22031");


//4. Check the following checkbox " Only show local listings"
        //WebElement localListings = driver.findElement(By.xpath("Only show local listings"));

//5. Choose Tesla for a make

WebElement addModelDropdown = driver.findElement(By.id("usurp-make-select"));
Select select = new Select(addModelDropdown);
        new Select(driver.findElement(By.name("make"))).selectByValue("Tesla");



    }
}
