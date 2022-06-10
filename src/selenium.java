import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class selenium {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","/Users/mervegurleyen/Desktop/BrowserDrivers/chromedriver-3");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");


        driver.manage().window().maximize();

        String actualTitle = driver.getTitle();
        String expectedTitle ="Welcome to Duotify!";
        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(2000);
        driver.findElement(By.id("hideLogin")).click();


        WebElement userName= driver.findElement(By.name("username"));
        WebElement firstName= driver.findElement(By.name("firstName"));
        WebElement lastName= driver.findElement(By.name("lastName"));
        WebElement email= driver.findElement(By.name("email"));
        WebElement confMail= driver.findElement(By.name("email2"));
        Thread.sleep(2000);
        WebElement password= driver.findElement(By.name("password"));
        WebElement confPassword= driver.findElement(By.name("password2"));

        int randomUser= (int) (4 +Math.random()*999);

        userName.sendKeys("mervemio"+randomUser);
        firstName.sendKeys("Merve");
        lastName.sendKeys("Gurleyen");
        int random2= (int) (4 +Math.random()*999);
        email.sendKeys("merve"+random2+"gurleyeen"+random2+"@gmail.com");
        confMail.sendKeys("merve"+random2+"gurleyeen"+random2+"@gmail.com");
        password.sendKeys("merveG57");
        confPassword.sendKeys("merveG57");
        driver.findElement(By.name("registerButton")).click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        Assert.assertEquals(expectedUrl, actualUrl);

        String str=driver.findElement(By.id("nameFirstAndLast")).getText();
        Assert.assertTrue(str.contains("Merve Gurleyen"));
        Thread.sleep(2000);

        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(2000);

        str= driver.findElement(By.className("userInfo")).getText();
        Assert.assertTrue(str.contains("Merve Gurleyen"));
        Thread.sleep(2000);
       // driver.findElement(By.id("rafael")).click();
        driver.findElement(By.id("rafael")).click();

        actualUrl=driver.getPageSource();
        expectedUrl="http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php";
        Assert.assertFalse(actualUrl.contains(expectedUrl));
        Thread.sleep(2000);

        driver.findElement(By.id("loginUsername")).sendKeys("mervemio"+randomUser);
        driver.findElement(By.id("loginPassword")).sendKeys("merveG57");

        driver.findElement(By.name("loginButton")).click();
        Thread.sleep(2000);

        driver.getPageSource().contains("You Might Also Like");
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("rafael")).click();
        driver.quit();






    }
}
