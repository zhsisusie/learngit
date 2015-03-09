package com.zhsi.maven.selenium.SeleniumTest;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.internal.seleniumemulation.JavascriptLibrary;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Selenium;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@org.junit.Test
	public void testSelenium(){
		/*System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		WebDriver driver=new FirefoxDriver();*/
		System.getProperties().setProperty("webdriver.chrome.driver", "D:/startupPackage/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		/*driver.get("http://www.google.com");
		//按名称找到输入元素
		WebElement element=driver.findElement(By.name("q"));
		//键入要搜索的文本
		element.sendKeys("Cheese!");
		//提交窗体，WebDriver会找到元素所属的窗体
		element.submit();
		//检查页面标题
		System.out.println("Page title is:"+driver.getTitle());
		//Google搜索用JavaScript动态绘制
		//等待页面被装载,10秒后超时
		(new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
				return d.getTitle().toLowerCase().startsWith("cheese");
			}
		});
		
		System.out.println("Page title is:"+driver.getTitle());
		*/
		
		/*driver.get("http://huaban.com/");
		//选取根元素html
		WebElement webElement=driver.findElement(By.xpath("/html"));
		//outerHTML:得出调用该方法的节点及该节点下的HTML代码
		System.out.println(webElement.getAttribute("outerHTML"));
		driver.quit();*/
		
		/*driver.get("http://list.jd.com/9987-653-655-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-33.html");
		WebElement webElement=driver.findElement(By.xpath("//div[@id='plist']"));
		System.out.println(webElement.getAttribute("outerHTML"));
		WebElement li=webElement.findElement(By.xpath("//li[@index='1']"));
		String name=li.findElement(By.xpath("//li[@index='1']//div[@class='p-name']/a")).getText();
		System.out.println("商品名:"+name);
		String price=li.findElement(By.xpath("//li[@index='1']//div[@class='p-price']/strong")).getText();
		System.out.println("价格:"+price);
		
		String eva=li.findElement(By.xpath("//li[@index='1']//span[@class='evaluate']/a[@target='_blank']")).getText();
		System.out.println("评价："+eva);*/
		/**
		 * 根据关键字查找
		 */
		/*// 通过判断 title 内容等待搜索页面加载完毕，间隔10秒
				WebDriverWait wait=new WebDriverWait(driver,30);
				wait.until(new ExpectedCondition<WebElement>(){
					public WebElement apply(WebDriver d){
						return d.findElement(By.id("txtValue"));
					}
				});
		driver.get("http://www.cnki.net/");
		System.out.println("1 Page title is:"+driver.getTitle());
		WebElement element=driver.findElement(By.id("txt_1_value1"));
		//输入关键字
		element.sendKeys("麻杏石甘汤");
		element.submit();
		
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().endsWith("中国知网");
            }
        });
        // 显示搜索结果页面的 title
        System.out.println("2 Page title is: " + driver.getTitle());
         WebElement element_1=driver.findElement(By.xpath("//a[@class='reclassname']"));
         System.out.println(element_1.getText());
         String response=driver.getPageSource();
         System.out.println(response);*/
		
		
		
		
		
        /**
         * 在花瓣网中查找
         * 下面是执行成功的代码，根据关键字查找可以得到渲染后的页面元素
         */
        /*driver.get("http://huaban.com/");
        WebElement webElement=driver.findElement(By.xpath("/html"));
       // WebDriverWait wait=new WebDriverWait(driver,200);
        wait.until(new ExpectedCondition<WebElement>(){

			public WebElement apply(WebDriver d) {
				System.out.println("感受");
				return d.findElement(By.xpath("//div[@class='recommend_container']"));
			}
        });
        
        
        //将图片的url抓取下来,该url是经过渲染之后出现的
        webElement=driver.findElement(By.xpath("//div[@id=\"recommend_container\"]/div[1]/div[1]/a[1]/img"));
        String p1=webElement.getAttribute("src");
        System.out.println("p1:"+p1);
        webElement=driver.findElement(By.xpath("//div[@id=\"recommend_container\"]/div[2]/div[2]/a[1]/img"));
        String p2=webElement.getAttribute("src");
        System.out.println("p2："+p2);
      
        
        webElement=driver.findElement(By.id("query"));
        webElement.sendKeys("食物");
        webElement.submit();
        System.out.println("食物");
      //*[@id="waterfall"]/div[2]/a/img//请求成功
      //*[@id="waterfall"]/div[3]/a/img//请求成功，因为瀑布流布局的div是动态是生成的，所以每次请求获得的ur可能不一样
        webElement=driver.findElement(By.xpath("//div[@id=\"waterfall\"]/div[3]/a/img"));
        if(webElement!=null){
        	System.out.println("第二次请求成功");
        }else{
        	System.out.println("第二次请求失败");
        }
        String p3=webElement.getAttribute("src");
        		//*[@id="waterfall"]/div[1]
        		//*[@id="waterfall"]/div[1]/a/img
      //*[@id="waterfall"]/div[11]/a/img
        System.out.println("p3:"+p3);	
		driver.close();*/
		
		/**
		 * WebDriver执行js代码
		 */
		/**
		 * 模拟点击按钮
		 */
		driver.get("http://www.cnki.net/");
		WebElement element=driver.findElement(By.id("txt_1_value1"));
		element.sendKeys("麻杏石甘汤");
		element.submit();
		//*[@id="ctl00"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d) {
				WebElement e2=d.findElement(By.id("iframeResult"));//这里的iframeResult需要点击才能获取的到
				return e2;
			}
		}).click();
		WebElement e1=driver.findElement(By.id("iframeResult"));
		if(e1!=null){
			System.out.println("find");
		}
		driver.switchTo().frame("iframeResult");//注意需要加上这一句后面的form表单便可以找到了，id为ct100
		wait.until(new ExpectedCondition<WebElement>(){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
			public WebElement apply(WebDriver d) {
				WebElement e2=d.findElement(By.xpath("//form[@id=\"ctl00\"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/a"));//这里的iframeResult需要点击才能获取的到
				return e2;
			}
		}).click();////*[@id="ctl00"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a
		//*//*[@id="ctl00"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/a
		//*[@id="ctl00"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a   标题1
		//*[@id="ctl00"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/a   作者1
		//*[@id="ctl00"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/a   标题2
		//*[@id="ctl00"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]/a[1] //作者2，但是有多个作者
		WebElement e3=driver.findElement(By.xpath("//form[@id=\"ctl00\"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/a"));
		if(e3!=null){
			System.out.println(e3.getText());
			System.out.println("yeah");		
		}
		 driver.close();
	}
	}
		
	

