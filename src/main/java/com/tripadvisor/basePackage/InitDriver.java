package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.Constants;

public class InitDriver {
	
	public static  WebDriver driver = null;
	
	static Properties prop;
	File src;
	FileInputStream fis;
	static String url;
	static String browser =null;
	
	
	public InitDriver() {
		
		try {
			
			src = new File(Constants.PROPERTIESFILE);
			fis = new FileInputStream(src);
			prop  = new Properties();
			prop.load(fis);
			
			 url = prop.getProperty("url");
			 browser = prop.getProperty("broswer");
			 

				if(browser.equalsIgnoreCase("chrome")) {
					
					System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER);
					driver = new ChromeDriver();
				}
				else if(browser.equalsIgnoreCase("Firefox")) {

					System.setProperty("webdriver.gecko.driver", Constants.GEKODRIVER);
					driver = new FirefoxDriver();
				}
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Constants.IMPLICITWAIT, TimeUnit.SECONDS);
				driver.get(url);
				//System.out.println(driver.getTitle());
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
