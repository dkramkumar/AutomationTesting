package pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.security.SecureRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

	public static WebDriver driver;
	static String path = System.getProperty("user.dir") + "/drivers";

	public static void initialConfig() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", path + "/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void openUrl() throws InterruptedException {
		driver.get(EnvironmentUtils.getConfig().getProperty("url"));
		Thread.sleep(3000);
	}

	public static By findBy(String sLocator) {
		By byElement = null;
		if(sLocator.contains("/")) {
			byElement = By.xpath(sLocator);
		}else {
			byElement = By.id(sLocator);
		}
		return byElement;
	}

	public static WebElement findObject(By ele, String selectorName) {
		WebElement wEle = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wEle = wait.until(ExpectedConditions.presenceOfElementLocated(ele));
		} catch (Exception e) {
			System.out.println("ERROR: Element " +selectorName + "not found");
		}
		return wEle;
	}

	public static List<WebElement> findObjects(By ele, String selectorName) {
		List<WebElement> lEle = null;
		try {
			lEle = driver.findElements(ele);
		} catch (Exception e) {
			System.out.println("ERROR: Element "+ selectorName + " not found");
		}
		return lEle;
	}

	public static List<WebElement> findElements(By ele, String sLocator){
		List<WebElement> lEle = null;
		lEle = driver.findElements(ele);
		if(lEle.size() == 0) {
			System.out.println("ERROR: Element " +sLocator+ " not found" );
		}
		return null;
	}

	public static void clickElement(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
		try {
			Actions act = new Actions(driver);
			act.click(wEle).build().perform();

			System.out.println("INFO: Clicking on " + selector);
		} catch (Exception e) {
			System.out.println("ERROR: Element " + selector + " is unclickable ");
		}
	}

	public static void setText(By ele, String selector, String stext) {
		WebElement wEle = findObject(ele, stext);
		Actions act = new Actions(driver);
		act.sendKeys(wEle, stext).build().perform();
		System.out.println("INFO: Entering text from " +selector+ " is " +stext);
	}

	public static String getText(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
		String text = wEle.getText();
		System.out.println("INFO: Getting text from " +selector+ " is " + text);
		return text;
	}

	public static String getOS() {
		return System.getProperty("os.name");
	}

	public static String todayDate() {
		String date;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		LocalDateTime now = LocalDateTime.now();
		date = dtf.format(now);
		return date;
	}

	public static void setSelectBoxText(By ele, String selector, String stext) {
		WebElement wEle = findObject(ele, selector);
		Select sel = new Select(wEle);
		sel.selectByVisibleText(stext);
		System.out.println("INFO: Selected text is : " +selector);
	}

	public static boolean isElementPresent(By ele, String selectorName) {

		boolean status = false;
		WebElement wEle = findObject(ele, selectorName);
		try {
			status = wEle.isDisplayed();
			System.out.println("INFO: Element " +selectorName+ "is present on the screen");
			return status;
		} catch (Exception e) {
			System.out.println("ERROR: Element " +selectorName+ "is not present on the screen");
		}
		return status;
	}

	public static void waitForPageLoad(int iTimeUnit) {

		driver.manage().timeouts().implicitlyWait(iTimeUnit, TimeUnit.SECONDS);

	}

	public static String getRandomString(int length) {
		final String AB = "abcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();

	}
}

