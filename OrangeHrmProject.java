package seleniumProject1;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtilities.JavaUtility;
import genericUtilities.PropertyUtility;
import objectRepository.AddEmployeePage;
import objectRepository.OrangeHRMLoginpage;

public class OrangeHrmProject {
	
	
	@Test(priority = 1)
		public void loginPage() throws Throwable{
		PropertyUtility pu = new PropertyUtility();
		 String browser =pu.toReadDataFromJson("browser");
         String  url = pu.toReadDataFromJson("url");
        
        
		WebDriver driver = null;
		
	    if ( browser.equalsIgnoreCase("chrome")) {
	    	driver = new ChromeDriver();
	    	}
	    else if (browser.equalsIgnoreCase("edge")) {
	    	driver = new EdgeDriver();
	    }
	    else {
	    	driver = new FirefoxDriver();
	}
	     driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	     driver.get(url);
         OrangeHRMLoginpage op = new OrangeHRMLoginpage(driver);
         
         
        
         String un = pu.toReadDataFromJson("un");
         String pwd = pu.toReadDataFromJson("pwd");
         op.userLogin(un, pwd);
	}
	@Test(priority = 2 ) 
	public void Addemp1() throws Throwable {
		PropertyUtility pu = new PropertyUtility();
		 String browser =pu.toReadDataFromJson("browser");
	WebDriver driver = null;
		
	    if ( browser.equalsIgnoreCase("chrome")) {
	    	driver = new ChromeDriver();
	    	}
	    else if (browser.equalsIgnoreCase("edge")) {
	    	driver = new EdgeDriver();
	    }
	    else {
	    	driver = new FirefoxDriver();
	}
		
		 JavaUtility jlib = new JavaUtility();
		 AddEmployeePage emp = new AddEmployeePage(null);
         String fn=pu.toReadDataFromFile("fn");
         String ln=pu.toReadDataFromFile("ln"); 
    //     String file = "D:\\Screenshot 2026-03-12 165450.png";
    	 String usn="arun"+jlib.randomNumber();
         String pass=pu.toReadDataFromFile("pass");
         String cnpwd=pu.toReadDataFromFile("cnpwd");
         Thread.sleep(2000);
         emp.Addemp(fn,ln,usn,pass,cnpwd);
         
      //   emp.addPic(file);
      //   Thread.sleep(9000);
         
	}
}

