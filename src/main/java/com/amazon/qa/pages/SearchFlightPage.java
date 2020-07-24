package com.amazon.qa.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class SearchFlightPage extends TestBase {
	
	
	@FindBy(xpath = "(//input[@class='query origWithLabel'])[1]")
	WebElement from;
	
	@FindBy(xpath = "(//input[@class='query destWithLabel'])[1]")
	WebElement to;
	
	@FindBy(xpath = "(//span[contains(@class,'ui_icon calendar')])[1]")
	WebElement calender;
	
	@FindBy(xpath = "//span[@data-date='2020-7-30']")
	WebElement Date;
	
	@FindBy(xpath = "(//span[@class='submit_text'])[1]")
	WebElement Finfflight;
	
	
	@FindBy(xpath = "//*[@class=\"_2Mo0rVsZ\"]")
	WebElement result;
	
	
	
	//    //*[@class="_2Mo0rVsZ"]
	public SearchFlightPage() {
		PageFactory.initElements(driver, this);
	}

	public void  SercheFlight(String from1, String To1) throws Throwable {
	Action.type(from, from1);
	Thread.sleep(3000);
	Action.type(to, To1);
	Thread.sleep(3000);
	Action.click(driver, calender);
	Thread.sleep(3000);
	Action.click(driver, Date);
	Action.click(driver, Finfflight);
	Thread.sleep(30000);
	}
	
	
	public void countFight() {
		
		 List<WebElement> elements = driver.findElements(By.xpath("//*[@class=\"_2Mo0rVsZ\"]"));
		    System.out.println("Number of elements:" +elements.size());
		    for (int i=0; i<elements.size();i++){
		        System.out.println("Name Flight" + elements.get(i).getText());
		      }

	}
	
	
	

}
