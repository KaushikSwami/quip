package project11.quip;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Data {

	
	public static int i,j;
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://issues.labcollab.net/login.jsp");
		
		
		
		XSSFWorkbook wbook = new XSSFWorkbook("./data/data.xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		for (i = 1; i <= rowCount; i++)
		{
			XSSFRow row =sheet.getRow(i);
			String username_value=row.getCell(0).getStringCellValue();
			String password_value=row.getCell(1).getStringCellValue();
			
			
				WebElement username = driver.findElementById("login-form-username");
				username.sendKeys(username_value);
				
				WebElement password = driver.findElementById("login-form-password");
				password.sendKeys(password_value);
				
				
				WebElement sign_in = driver.findElementById("login-form-submit");
				sign_in.click();
				
				System.out.println("logged jira");
				
				Thread.sleep(4000);
				WebElement find_issues = driver.findElementByXPath("//a[@id='find_link']");
				Thread.sleep(2000);
				find_issues.click();
		    
				Thread.sleep(2000);
				WebElement search_issues = driver.findElementById("issues_new_search_link_lnk");
				search_issues.click();
				
				WebElement click_advanced = driver.findElementByLinkText("Advanced");
				if(click_advanced.isDisplayed())
				{
					
					click_advanced.click();
				}
				/*WebElement click_advanced = driver.findElementByLinkText("Advanced");
				click_advanced.click();*/
				
				WebElement advanched_search_area = driver.findElementByXPath("//textarea[@id='advanced-search']");
				advanched_search_area.click();
				advanched_search_area.sendKeys("abcde");
			
				
				System.out.println("all done");
			
		
		}
		
		
		
	}
}
