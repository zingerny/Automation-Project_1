package project2WebOrder;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

public class OrderProduct {
    public static  void main(String[] args) throws InterruptedException {
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
        Thread.sleep(500);

//        5. Enter a random product quantity between 1 and 100

        Random random = new Random();
        int randomQty = random.nextInt(100);
        System.out.println(randomQty);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Keys.BACK_SPACE, String.valueOf(randomQty) );



//        6. Click on Calculate and verify that the Total value is as expected.
        driver.findElement(By.xpath("//input[@value='Calculate']")).click(); // calculated
        Thread.sleep(500);





//        Price per unit is 100.  The discount of 8 % is applied to quantities of 10+.
//        So for example, if the quantity is 8, the Total should be 800.
//        If the quantity is 20, the Total should be 1840.
//        If the quantity is 77, the Total should be 7084. And so on.
//
//        int expected ;
//        int pricePerUnit=100;
//        int discount =8;
//        int actual = Integer.parseInt(driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtTotal")).getText());
//        if(randomQty >= 10){
//            expected= randomQty*100- randomQty * 100 * discount/100;
//            System.out.println("  QTY over 10 pcs Total is expected : " + expected);
//        } else {
//            expected=randomQty*pricePerUnit;
//            System.out.println("Qty under 10 pcs, Total is expected : "+(expected));
//        }
//     Assert.assertEquals(actual, expected);


//        6. Generate and enter random first name and last name.

String fullName = RandomGenerator.generateFakeFullName();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(fullName);
        System.out.println(fullName);
//        7. Generate and Enter random street address
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(RandomGenerator.generateFakeStreet());
//        8. Generate and Enter random city
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(RandomGenerator.generateFakeCity());
//        9. Generate and Enter random state
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(RandomGenerator.generateFakeState());


//        10. Generate and Enter a random 5 digit zip code
driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(RandomGenerator.generateFakeZipCode());
//        String zipCode = "";
//        zipCode =(char)(10 + (int) (Math.random() * 99990));
//        System.out.println(zipCode);
//
//driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zipCode);



//        11. Select the card type randomly. On each run your script should select a random type.
    int cardType = (int)(1+(Math.random()*3));


//        12. Generate and enter the random card number:
                 //        If Visa is selected, the card number should start with 4.
                 //        If MasterCard is selected, card number should start with 5.
                 //        If American Express is selected, card number should start with 3.
                 //        Card numbers should be 16 digits for Visa and MasterCard, 15 for American Express.



            if (cardType ==1) {
                driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

                driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("4"+RandomGenerator.generateCreditCard().substring(1));
            } else if
         (cardType == 2){
              driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();

            driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("5"+RandomGenerator.generateCreditCard().substring(1));
        }
           else if (cardType == 3) {
                driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
                driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("3"+RandomGenerator.generateCreditCard().substring(2));
            }




//        13. Enter a valid expiration date (newer than the current date)
//        14. Click on Process
//        15. Verify that “New order has been successfully added” message appeared on the page.
//        16. Click on View All Orders link.
//        17. The placed order details appears on the first row of the orders table. Verify that the entire information contained on the row (Name, Product, Quantity, etc) matches the previously entered information in previous steps.
//        18. Log out of the application.


    }
}
