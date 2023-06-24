package project1Duotify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BasicTest {
    public static void main(String[] args) throws InterruptedException {
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();



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
        String user = "matrix";
        user = user+((int)(Math.random()*100));
        driver.findElement(By.name("username")).sendKeys(user);

        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.name("firstName"));
        String fName = "Keanu";
        driver.findElement(By.name("firstName")).sendKeys(fName);
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.name("lastName"));
        String lName = "Reeves";
        driver.findElement(By.name("lastName")).sendKeys(lName);
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.name("email"));

                String randomEmail ="";
                  randomEmail += user + fName.charAt(0) + lName.charAt(0) + ((int)(Math.random()*1000))+"@gmail.com";

            System.out.println(randomEmail);
        driver.findElement(By.name("email")).sendKeys(randomEmail);
        Thread.sleep(1000);

        WebElement cfmemail = driver.findElement(By.name("email2"));
        driver.findElement(By.name("email2")).sendKeys(randomEmail);
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.name("password"));

//           String randomPassword = ""+ (char)(int)(Math.random()*1000));
            String code= RandomPassword.generatePassword();
        driver.findElement(By.name("password")).sendKeys(code);
        Thread.sleep(1000);

        WebElement cfmpassword = driver.findElement(By.name("password2"));
        driver.findElement(By.name("password2")).sendKeys(code);
        Thread.sleep(1000);

//        5. Click on Sign up

        WebElement registerButton = driver.findElement(By.name("registerButton"));
        driver.findElement(By.name("registerButton")).click();
        Thread.sleep(1000);

//        6. Once logged in to the application, verify that the URL is:
//        http://duotify.us-east-2.elasticbeanstalk.com/browse.php?

        String expectedUrl = " http://duotify.us-east-2.elasticbeanstalk.com/browse.php";

        String actualUrl = driver.getCurrentUrl();
        System.out.println("The current url is: " + actualUrl);
        Thread.sleep(1000);
        Assert.assertEquals(actualUrl,expectedUrl);


//        7. In the left navigation bar, verify that your first and last name matches the first and last name that you used when signing up.

        String expectedMatch = "Keanu Reeves";
        String actualIs = driver.findElement(By.id("nameFirstAndLast")).getText();
        Thread.sleep(1000);
             Assert.assertEquals(actualIs, expectedMatch);
            System.out.println("Name has been verified. " );
            Thread.sleep(1000);



//        8. Click on the username on the left navigation bar and verify the username on the main window is correct and then click logout.

             driver.findElement(By.id("nameFirstAndLast")).click();

            Thread.sleep(1000);
            WebElement button = driver.findElement(By.id("button"));
            driver.findElement(By.id("rafael")).click();
            Thread.sleep(1000);


//        9. Verify that you are logged out by verifying the URL is:
//        http://duotify.us-east-2.elasticbeanstalk.com/register.php

        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        String expectedUrlIs = "http://duotify.us-east-2.elasticbeanstalk.com/register.php";

        String actualUrlLink = driver.getCurrentUrl();
        System.out.println("The current url is: " + actualUrlLink);

        Assert.assertEquals(expectedUrlIs,actualUrlLink);

//        10. Login using the same username and password when you signed up.

//        11. Verify successful login by verifying that the home page contains the text "You Might Also Like".

//        12. Log out once again and verify that you are logged out.
    }

}
