package vn.testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AppTest{
    //Khai bao cac thuoc tinh
    WebDriver driver;

    @Before
    public void starting(){
        //Thiet lap Chrome
        WebDriverManager.edgedriver().setup();
        //Khoi tao driver
        this.driver = new EdgeDriver();
        //Mo trang web muon test
        this.driver.get("https://fado.vn/dang-nhap");
        //Phong to browser
        this.driver.manage().window().maximize();
    }

    @Test
    //Scenario username va pass đúng
    public void test_login_with_valid_user(){
        WebElement txtUserName = this.driver.findElement(By.id("auth-block__form-group__email"));
        WebElement txtPassword = this.driver.findElement(By.name("password"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        WebElement lbMessage = this.driver.findElement(By.xpath("//*[@id=\"user-info__dropdown\"]/div[1]/span[1]"));

        //Nhap du lieu
        new Actions(driver).moveToElement(txtUserName).perform();
        txtUserName.sendKeys("anhlt.soict@gmail.com");
        txtPassword.sendKeys("mB123456");
        btnLogin.click();

        //Ghi nhan ket qua kiem thu
        Assert.assertEquals("Le Anh", lbMessage.getText());
    }

    @Test
    //Scenario login khong co password
    public void test_login_with_no_password(){
        WebElement txtUserName = this.driver.findElement(By.id("auth-block__form-group__email"));
        WebElement txtPassword = this.driver.findElement(By.name("password"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        WebElement lbMessage = this.driver.findElement(By.xpath("/html/body/section/div/div[2]/div/form/div[2]/div[2]/label"));

        //Nhap du lieu
        new Actions(driver).moveToElement(txtUserName).perform();
        txtUserName.sendKeys("anhlt.soict@gmail.com");
        txtPassword.sendKeys("");
        btnLogin.click();

        //Ghi nhan ket qua kiem thu
        Assert.assertEquals("Vui lòng nhập dữ liệu", lbMessage.getText());
    }

    @Test
    //Scenario login voi password sai
    public void test_login_with_wrong_password(){
        WebElement txtUserName = this.driver.findElement(By.id("auth-block__form-group__email"));
        WebElement txtPassword = this.driver.findElement(By.name("password"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("#auth-block__login-form > div.auth-block__btn-group > button"));
        WebElement lbMessage = this.driver.findElement(By.xpath("//*[@id=\"auth-block__login-form\"]/div[1]/br"));

        //Nhap du lieu
        new Actions(driver).moveToElement(txtUserName).perform();
        txtUserName.sendKeys("anhlt.soict@gmail.com");
        txtPassword.sendKeys("123456");
        btnLogin.click();

        //Ghi nhan ket qua kiem thu
        Assert.assertEquals("- Mật khẩu không đúng, vui lòng kiểm tra lại", lbMessage.getText());
    }

    @Test
    //Scenario login voi username sai
    public void test_login_with_wrong_username(){
        WebElement txtUserName = this.driver.findElement(By.id("auth-block__form-group__email"));
        WebElement txtPassword = this.driver.findElement(By.name("password"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        WebElement lbMessage = this.driver.findElement(By.xpath("//*[@id=\"auth-block__form-group__email-error\"]"));

        //Nhap du lieu
        new Actions(driver).moveToElement(txtUserName).perform();
        txtUserName.sendKeys("anhlt.soict");
        txtPassword.sendKeys("mB123456");
        btnLogin.click();

        //Ghi nhan ket qua kiem thu
        Assert.assertEquals("Vui lòng nhập Email đúng định dạng", lbMessage.getText());
    }

    @After
    public void endTest(){
        //Dong trinh duyet
        //this.driver.quit();
    }
}
