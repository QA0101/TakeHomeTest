package selenium.hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TeachableTakeHome {

    public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "chromedriver 4");

            WebDriver driver = new ChromeDriver();
            driver.get("https://takehome.zeachable.com/");
            driver.manage().window().maximize();

            WebElement loginPage = driver.findElement(By.xpath("//a[@class='navbar-link fedora-navbar-link']"));

            //Verifying login button on the page or not

            System.out.println(loginPage.isDisplayed());


            loginPage.click();
            Thread.sleep(4000);


            //Verify the URL
            String actualUrl = driver.getCurrentUrl();
            System.out.println(actualUrl);

            String expectedUrl = "https://sso.zeachable.com/secure/123/identity/login";
            Assert.assertEquals(actualUrl, expectedUrl);

            // Login in with valid email and password
            WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
            email.sendKeys("takehome@test.com");

            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("Teachable");

            WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn-primary button p-v-2-xs p-h-5-xs m-v-3-xs col-12-xs']"));
            loginButton.click();

            //Verify the title
            String actualTitle = driver.getTitle();
            String expectedTitle = "takehome";

            if (actualTitle.equalsIgnoreCase(expectedTitle)) {
                System.out.println("test is passed");
            } else {
                System.out.println("test is not passed");
            }

            WebElement logOut = driver.findElement(By.className("gravatar"));
            logOut.click();
            Thread.sleep(4000);
            WebElement logOutButton = driver.findElement(By.className("user-signout"));
            logOutButton.click();
            driver.close();

        }


    @Test
    public void teachable2() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver 4");
        WebDriver driver = new ChromeDriver();
        driver.get("https://takehome.zeachable.com");
        driver.manage().window().maximize();

        //Log in without providing password

        WebElement loginPage = driver.findElement(By.xpath("//a[@class='navbar-link fedora-navbar-link']"));
        loginPage.click();

        Thread.sleep(4000);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("takehome@test.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn-primary button p-v-2-xs p-h-5-xs m-v-3-xs col-12-xs']"));
        loginButton.click();

        String actualErrorMessage = "Your email or password is incorrect.";

        WebElement exp = driver.findElement(By.xpath("//div[@class='bodySmall m-b-3-xs text-center-xs auth-flash-error']"));
        String expectedErrorMessage = exp.getText();

        if (actualErrorMessage.equalsIgnoreCase(expectedErrorMessage)){
            System.out.println("test is passed");
        }else{
            System.out.println("test is not passed");
        }
    }
@Test
public void teachable3() throws InterruptedException {

       // Sign Up page test
        System.setProperty("webdriver.chrome.driver", "chromedriver 4");
        WebDriver driver = new ChromeDriver();
        driver.get("https://takehome.zeachable.com/");
        driver.manage().window().maximize();

        WebElement signUpButton= driver.findElement(By.id("header-sign-up-btn"));
        signUpButton.click();

        //Verifying the sign-up button on the page or not

        System.out.println(signUpButton.isDisplayed());

       signUpButton.click();
       Thread.sleep(4000);

       //Verify the URL

       String actualUrl = driver.getCurrentUrl();
       System.out.println(actualUrl);

       String expectedUrl ="https://sso.zeachable.com/secure/123/identity/sign_up/with_email";
       Assert.assertEquals(actualUrl,expectedUrl);

      //Sign-Up with full-name valid email and password

      WebElement fullName = driver.findElement(By.id("user_name"));
      fullName.sendKeys("james jack");

      WebElement email = driver.findElement(By.id("user_email"));
      email.sendKeys("james@gmail.com");

      WebElement password = driver.findElement(By.id("password"));
      password.sendKeys(String.valueOf(123456));

     //verifying to allow marketing emails or not

      WebElement checkBox = driver.findElement(By.id("allow_marketing_emails"));
      checkBox.click();

      System.out.println(checkBox.isSelected());

      WebElement singUp = driver.findElement(By.xpath("//input[@class='button btn-primary col-10-xs p-v-2-xs p-h-5-xs m-v-3-xs']"));
      singUp.click();
      driver.close();


    }
    //verifying sign up without entering password
@Test
public void teachable4() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver 4");
        WebDriver driver = new ChromeDriver();
        driver.get("https://takehome.zeachable.com/");
        driver.manage().window().maximize();

        WebElement signUpButton= driver.findElement(By.id("header-sign-up-btn"));
        signUpButton.click();

    //verifying sign up without entering password

    Thread.sleep(4000);

    WebElement fullName = driver.findElement(By.id("user_name"));
    fullName.sendKeys("james jack");

    WebElement email = driver.findElement(By.id("user_email"));
    email.sendKeys("james@gmail.com");

    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("");

    WebElement singUp = driver.findElement(By.xpath("//input[@class='button btn-primary col-10-xs p-v-2-xs p-h-5-xs m-v-3-xs']"));
    singUp.click();

    //verifying the error message when we sign up without password

    String actualErrorMessage = "Our apologies! We were unable to process your request";

    WebElement exp = driver.findElement(By.className("page-error"));
    String expectedErrorMessage = exp.getText();

    if (actualErrorMessage.equalsIgnoreCase(expectedErrorMessage)){
        System.out.println("test is passed");
    }else{
        System.out.println("test is not passed");
    }
    driver.close();

    }

}
