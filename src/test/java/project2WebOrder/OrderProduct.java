package project2WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class OrderProduct {
    public static void main(String[] args) {
//        1. Launch Chrome browser.

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


//        2. Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

//        3. Login using username Tester and password test

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

//        4. Click on Order link
       driver.findElement(By.xpath("//a[@ href='Process.aspx']")).click();


//        5. Enter a random product quantity between 1 and 100

        Random random = new Random();
        int randomKey = random.nextInt(100);
        System.out.println(randomKey);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Keys.BACK_SPACE, String.valueOf(randomKey) );




//        6. Click on Calculate and verify that the Total value is as expected.
//        Price per unit is 100.  The discount of 8 % is applied to quantities of 10+.
//        So for example, if the quantity is 8, the Total should be 800.
//        If the quantity is 20, the Total should be 1840.
//        If the quantity is 77, the Total should be 7084. And so on.
//
//        6. Generate and enter random first name and last name.
//        7. Generate and Enter random street address
//        8. Generate and Enter random city
//        9. Generate and Enter random state
//        10. Generate and Enter a random 5 digit zip code
//        11. Select the card type randomly. On each run your script should select a random type.
//        12. Generate and enter the random card number:
//        If Visa is selected, the card number should start with 4.
//        If MasterCard is selected, card number should start with 5.
//        If American Express is selected, card number should start with 3.
//        Card numbers should be 16 digits for Visa and MasterCard, 15 for American Express.
//        13. Enter a valid expiration date (newer than the current date)
//        14. Click on Process
//        15. Verify that “New order has been successfully added” message appeared on the page.
//        16. Click on View All Orders link.
//        17. The placed order details appears on the first row of the orders table. Verify that the entire information contained on the row (Name, Product, Quantity, etc) matches the previously entered information in previous steps.
//        18. Log out of the application.

    }
}
