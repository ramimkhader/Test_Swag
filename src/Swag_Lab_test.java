import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Swag_Lab_test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rami\\Desktop\\chromedriver_win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		String user_neme = "standard_user";
		String password = "secret_sauce";
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(user_neme);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		int expectedItems = 6;

		List<WebElement> myBottons = driver.findElements(By.className("btn"));

		System.out.println(myBottons.size());
		Thread.sleep(2000);
		for (int i = 0; i <= myBottons.size(); i++) {

			myBottons.get(i).click();
		}

		String actulItemsAdd = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getText();

		System.out.println(actulItemsAdd);
		int rNumber = Integer.parseInt(actulItemsAdd);
		Assert.assertEquals(rNumber, expectedItems);
	}
}
