package com.aichenwei.selenium;

import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * 通过直接部署的方式测试Selenium Grid
 */
public class TestSeleniumGridRaw {

    /**
     * 测试启动谷歌浏览器
     *
     * @throws Exception
     */
    @Test
    public void testChrome() throws Exception {
        // 需要下载chromedriver到本地，确保driver的版本与chrome的版本一致
        // 下载地址：https://chromedriver.storage.googleapis.com/index.html
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("chrome"); // 设置浏览器为谷歌浏览器
        capability.setPlatform(Platform.WINDOWS);

        WebDriver driver = new RemoteWebDriver(new URL("http://10.0.75.1:4444/wd/hub"), capability);
        driver.get("http://www.baidu.com");

        System.in.read();
    }

    /**
     * 测试docker版本的
     *
     * @throws Exception
     */
    @Test
    public void testDocker() throws Exception {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("chrome"); // 设置浏览器为谷歌浏览器

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        driver.get("http://www.baidu.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());

        driver.close();
        driver.quit();
    }

}
