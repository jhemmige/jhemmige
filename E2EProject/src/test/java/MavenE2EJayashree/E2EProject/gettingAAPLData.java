//Just a practice . Needs optimization and refactoring


package MavenE2EJayashree.E2EProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class gettingAAPLData {

	@Test
	public void sixmonthsData() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/jayashreehemmige/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://finance.yahoo.com/");
		driver.findElement(By.xpath("//input[@id='yfin-usr-qry']")).sendKeys("aapl");
		driver.findElement(By.xpath("//button[@id='header-desktop-search-button']")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[contains(text(),'Historical Data')]")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='Pos(r) D(ib) Va(m) Mstart(8px)']/div/div/span")).click();
		//
		
		List<WebElement> months = driver.findElements(By.xpath("//div[@data-test='date-picker-menu']/ul/li"));
		
		
	/**	for (WebElement mypick: months) {
			
			String txt=		mypick.getText();
			System.out.println(txt);	
		
			if (mypick.getText().matches("6M")) {
			
			mypick.click();	
			System.out.println("Ok clicked on 6M");
			break;
		}
			
		}
		driver.findElement(By.xpath("//button[contains(@class,'Py(9px) Fl(end)')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();*/
		
		int mosize = months.size();

		for (int j = 0; j < mosize; j++) {

		String txt = months.get(j).getText();
	
		if (txt.contentEquals("6M")){
	 
	 		months.get(j).click();
	 		
	 		break;
	}
 
		
			// driver.findElement(By.xpath("//span[contains(text(),'3M')]")).click();
			// driver.findElement(By.xpath("//span[contains(text(),'6M')]")).click();
		
		
//List<WebElement> data=	driver.findElements(By.xpath("//table[@class='W(100%) M(0)']/tbody/tr"));

//int ds= data.size();
//
//for (int i=0; i<ds;i++) {
//	
//String dataTxt=	data.get(i).getText();
//System.out.println(dataTxt);
//	
			//driver.close();
		

	}
		
		driver.findElement(By.xpath("//button[contains(@class,'Py(9px) Fl(end)')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
		driver.close();
	}
}


