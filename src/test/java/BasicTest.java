import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.SQLOutput;

public class BasicTest {
    public static void main(String[] args) throws InterruptedException {
WebDriver driver = new ChromeDriver();



//        1. Navigate to http://duotify.us-east-2.elasticbeanstalk.com/register.php
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");


//        2. Verify the  title is "Welcome to Duotify!"
        String expected = "Welcome to Duotify!";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expected);
        System.out.println("Expected title: "+expected +"\n"+"Actual Title is : "+ actualTitle);

        Thread.sleep(1000);


//        3. Click on Signup here
driver.findElement(By.id("hideLogin")).click();
        Thread.sleep(1000);


//        4. Fill out the form with the required info
        WebElement username = driver.findElement(By.name("username"));
        driver.findElement(By.name("username")).sendKeys("matrix");

        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.name("firstName"));
        driver.findElement(By.name("firstName")).sendKeys("Keanu");
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.name("lastName"));
        driver.findElement(By.name("lastName")).sendKeys("Reeves");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.name("email"));
        driver.findElement(By.name("email")).sendKeys("matrix_kr@yahoo.com");
        Thread.sleep(1000);

        WebElement cfmemail = driver.findElement(By.name("email2"));
        driver.findElement(By.name("email2")).sendKeys("matrix_kr@yahoo.com");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.name("password"));
        driver.findElement(By.name("password")).sendKeys("3356Pojmn");
        Thread.sleep(1000);

        WebElement cfmpassword = driver.findElement(By.name("password2"));
        driver.findElement(By.name("password2")).sendKeys("3356Pojmn");
        Thread.sleep(1000);

//        5. Click on Sign up

        WebElement registerButton = driver.findElement(By.name("registerButton"));
        driver.findElement(By.name("registerButton")).click();
        Thread.sleep(1000);

//        6. Once logged in to the application, verify that the URL is:
//        http://duotify.us-east-2.elasticbeanstalk.com/browse.php?

        String expectedUrl = " http://duotify.us-east-2.elasticbeanstalk.com/browse.php?";

        String actualUrl = driver.getCurrentUrl();
        System.out.println("The current url is: " + actualUrl);
        Thread.sleep(1000);
        Assert.assertEquals(actualUrl,expectedUrl);


//        7. In the left navigation bar, verify that your first and last name matches the first and last name that you used when signing up.

        String expectedMatch = "Keanu Reeves";
        String actualIs = driver.findElement(By.id("nameFirstAndLast")).getText();
        Thread.sleep(1000);
       Assert.assertEquals(actualIs, expectedMatch);
            Thread.sleep(1000);

//        8. Click on the username on the left navigation bar and verify the username on the main window is correct and then click logout.
//        9. Verify that you are logged out by verifying the URL is:
//        http://duotify.us-east-2.elasticbeanstalk.com/register.php
//        10. Login using the same username and password when you signed up.
//        11. Verify successful login by verifying that the home page contains the text "You Might Also Like".
//        12. Log out once again and verify that you are logged out.
    }
}
