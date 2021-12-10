package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminPage extends BasePage{
	
	public final static By bySearchUserName = findBy("//input[@id='searchSystemUser_userName']");
	public final static By byUserRole = findBy("//select[@id='searchSystemUser_userType']");
	public final static By bySearchButton = findBy("//input[@id='searchBtn']");
	public final static By byStatus = findBy("//select[@id='searchSystemUser_status']");
	public final static By byAddButton = findBy("//input[@id='btnAdd']");
	public final static By byAddEmployeeName = findBy("//input[@id='systemUser_employeeName_empName']");
	public final static By byAddUserName = findBy("//input[@id='systemUser_userName']");
	public final static By byAddPassword = findBy("//input[@id='systemUser_password']");
	public final static By byAddConfirmPassword = findBy("//input[@id='systemUser_confirmPassword']");
	public final static By bySaveButton = findBy("//input[@id='btnSave']");
	static String addUserName;

	public static void clickAdminTab(String data) {
		clickElement(findBy("//a[@id='menu_admin_"+data+"']"), data);
	}
	
	public static String getTotalUsers() {
		String users = null;
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='resultTable']/thead/following-sibling::tbody/tr/td[2]"));
		for(WebElement ele : list) {
			users = ele.getText();
			System.out.println(users);
		}
		return users;
	}
	
	public static void setSearchUserName() {
		setText(bySearchUserName, "User name", "Aravind");
	}
	
	public static void clickUserRole() throws InterruptedException {
		clickElement(byUserRole, "User Role");
		Thread.sleep(2000);
	}
	
	public static void selectUserRole() throws InterruptedException {
		WebElement ele = (WebElement) byUserRole;
		Select sel = new Select(ele);
		sel.selectByVisibleText("All");
		Thread.sleep(2000);	
	}
	
	public static void selectStatus() throws InterruptedException {
		WebElement ele = (WebElement) byStatus;
		Select sel = new Select(ele);
		sel.selectByVisibleText("Enabled");
		Thread.sleep(2000);	
	}
	
	public static void clickSearchButton() {
		clickElement(bySearchButton, "Search Button");
	}
	
	public static void clickOnAddButton() {
		clickElement(byAddButton, "Add Button");
	}
	
	public static void setUserDetails() throws IOException, InterruptedException {
		File src = new File(path +"/TestData.xlsx");		
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		String rndstring = getRandomString(5);
		
		for(int i=1; i<=rowCount; i++) {
			
			for(int j=0; j<=3; j++) {
				
				if(j==0) 
				{
				String empName = sheet.getRow(i).getCell(j).getStringCellValue();
				setText(byAddEmployeeName, "Employee Name", empName);
				Thread.sleep(2000);
				}
				if(j==1) 
				{
				addUserName = sheet.getRow(i).getCell(j).getStringCellValue();
				setText(byAddUserName, "User Name", addUserName+rndstring);
				Thread.sleep(2000);
				}
				if(j==2) 
				{
				String password = sheet.getRow(i).getCell(j).getStringCellValue();
				setText(byAddPassword, "Password", password);
				Thread.sleep(2000);
				}
				if(j==3) 
				{
				String confirmPass = sheet.getRow(i).getCell(j).getStringCellValue();
				setText(byAddConfirmPassword, "Confirm Password", confirmPass);
				Thread.sleep(2000);
				clickElement(bySaveButton, "Save Button");
				Thread.sleep(2000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				
				List<WebElement> list = driver.findElements(By.xpath("//table[@id='resultTable']/thead/following-sibling::tbody/tr/td[2]"));
				Iterator<WebElement> itr = list.iterator();
				while(itr.hasNext()) {
					String uName = itr.next().getText();
					if(uName.equals(addUserName+rndstring)) {
						wb.getSheet("EmpDetails").getRow(i).createCell(4).setCellValue("PASS");
						FileOutputStream outputStream = new FileOutputStream(path +"/TestData1.xlsx");
						wb.write(outputStream);
					}
				}
			}
		}
			clickOnAddButton();
			Thread.sleep(2000);
	  }
	}
}
