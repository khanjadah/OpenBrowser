package driverPractice;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenBrowser2 {

	WebDriver driver;

	@Test
	public void pokeBrowser() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://demoqa.com/");
		driver.findElement(By.xpath("//h5[text()='Elements']")).click();

		driver.findElement(By.xpath("//span[text()='Text Box']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Hurayra");

		driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys("khanjada@hotmail.com");

		driver.findElement(By.xpath("//textarea[@placeholder='Current Address']")).sendKeys("123 main st");

		driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("456 main st");

		driver.findElement(By.xpath("//button[@id='submit']")).click();

		validateText("Name:Hurayra", "//p[@id='name']");
		validateText("Email:khanjada@hotmail.com", "//p[@id='email']");
		validateText("Current Address :123 main st", "//p[@id='currentAddress']");
		validateText("Permananet Address :456 main st", "//p[@id='permanentAddress']");
		
		driver.findElement(By.xpath("//span[text()='Check Box']")).click();
		driver.findElement(By.xpath("//span[text()='Home']")).click();
		
		driver.findElement(By.xpath("//span[text()='Radio Button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='yesRadio']")).click();
		driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();
		boolean x = driver.findElement(By.xpath("//label[@for='noRadio']")).isEnabled();
		
		System.out.println(x);
		
		
		
		

		Thread.sleep(5000);
		driver.quit();

	}

	public void validateText(String expected, String locator) {

		String actual = driver.findElement(By.xpath(locator)).getText();

		if (expected.equals(actual)) {

			System.out.println("Expected text matches Actual text...");
		} else {

			System.out.println("Expected text does not matches the actual text");

			System.out.println("Expected :" + expected);

			System.out.println("Actual  :" + actual);
		}
	}

}
//String nameText = driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).getText();
//System.out.println(nameText);
//String nameCheckBx = driver.findElement(By.xpath("//span[contains(text(),'Check Box')]")).getText();
//System.out.println(nameCheckBx);
//String nameRadioBtn = driver.findElement(By.id("item-2")).getText();
//System.out.println(nameRadioBtn);
//String nameWebTab = driver.findElement(By.id("item-3")).getText();
//System.out.println(nameWebTab);
//String nameBtn = driver.findElement(By.id("item-4")).getText();
//System.out.println(nameBtn);