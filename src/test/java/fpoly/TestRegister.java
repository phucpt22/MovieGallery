package fpoly;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRegister {
	public WebDriver driver;
	  public UIMap uimap;
	  public UIMap datafile;
	  public String workingDir;
	  
	  HSSFWorkbook workbook;
	  HSSFSheet sheet;
	  Map<String, Object[]> TestNGResults;
	  public static String driverPath = "D:\\selenium-java-3.12.0\\";
	  
	  @Test(description = "Opens the TestNG Demo Website for Login Test",priority = 1)
	  public void LaunchWebsite() throws Exception{
		  try {
			driver.get("http://localhost:8080/AsmJava4/register");
			driver.manage().window().maximize();
			TestNGResults.put("2", new Object[] {1d,"Navigate to demo website", "Site gets opened","Pass"});
		} catch (Exception e) {
			TestNGResults.put("2", new Object[] {1d,"Navigate to demo website", "Site gets opened","Fail"});
			Assert.assertTrue(false);
		}
	  }

	  @Test(description = "Fill the Login Details",priority = 2)
	  public void FillRegisterDetails() throws Exception{
		  try {
			WebElement username = driver.findElement(uimap.getLocator("UsernameRegis_field"));
			username.sendKeys(datafile.getData("userRegister"));
			WebElement password = driver.findElement(uimap.getLocator("PasswordRegis_field"));
			password.sendKeys(datafile.getData("passwordRegister"));
			WebElement cfmpassword = driver.findElement(uimap.getLocator("CfmPasswordRegis_field"));
			cfmpassword.sendKeys(datafile.getData("cfmpasswordRegister"));
			WebElement email = driver.findElement(uimap.getLocator("Email_field"));
			email.sendKeys(datafile.getData("email"));
			Thread.sleep(2000);
			TestNGResults.put("3", new Object[] {2d, "Fill Register from data (Username/password/email)","Register details gets filled","Pass"});
		} catch (Exception e) {
			TestNGResults.put("3", new Object[] {2d, "Fill Register from data (Username/password/email)","Register details gets filled","Fail"});
			Assert.assertTrue(false);
		}
	  }
	  
	  @Test(description = "Perform Login",priority = 3)
	  public void DoRegister() throws Exception{
		  try {
			WebElement login = driver.findElement(uimap.getLocator("Register_button"));
			login.click();
			Thread.sleep(2000);
			TestNGResults.put("4", new Object[] {3d, "Click login and verify welcome message","Login success","Pass"});
		} catch (Exception e) {
			TestNGResults.put("4", new Object[] {3d, "Click login and verify welcome message","Login success","Pass"});
			Assert.assertTrue(false);
		}
	  }
	  
	  @BeforeClass(alwaysRun = true)
	  public void suiteSetup() {
		  workbook = new HSSFWorkbook();
		  sheet = workbook.createSheet("TestNG Result Summary");
		  TestNGResults = new LinkedHashMap<String, Object[]>();
		  TestNGResults.put("1",new Object[] {"Test Step No.", "Action", "Expected Output", "Actual Output"});
		  try {
			workingDir = System.getProperty("user.dir");
			datafile = new UIMap(workingDir+"\\Resourse\\datafile.properties");
			uimap = new UIMap(workingDir+"\\Resourse\\locator.properties");
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new IllegalStateException("Can't start the Chrome web driver",e);
		}
	  }
	  
	  @AfterClass
	  public void suiteTearDown() {
		  Set<String> keyset = TestNGResults.keySet();
		  int rownum = 0;
		  for(String key : keyset) {
			  Row row = sheet.createRow(rownum++);
			  Object[] objArr = TestNGResults.get(key);
			  int cellnum = 0;
			  for(Object obj : objArr) {
				  Cell cell = row.createCell(cellnum++);
				  if(obj instanceof Date) {
					  cell.setCellValue((Date) obj);
				  }else if(obj instanceof Boolean){
					  cell.setCellValue((Boolean) obj);
				  }else if(obj instanceof String){
					  cell.setCellValue((String) obj);
				  }else if(obj instanceof Double){
					  cell.setCellValue((Double) obj);
				  }
			  }
		  }
		  try {
			FileOutputStream out = new FileOutputStream(new File("TestRegister.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		  driver.close();
		  driver.quit();
	  }
}
