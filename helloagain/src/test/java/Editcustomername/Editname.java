package Editcustomername;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;


public class Editname {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Initialize capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:deviceName", "RZCW60CJQQM");
        capabilities.setCapability("appium:appPackage", "at.helloagain.hellomemberclub");
        capabilities.setCapability("appium:appActivity", "com.shoutemapp.MainActivity");
        capabilities.setCapability("appium:platformVersion", "14");
        capabilities.setCapability("appium:noReset", true);
        
        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            System.out.println("Application Started");
            
            // 1. Click on Customer Logo
            WebElement logo = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(@content-desc,'Floating Action Button')]")));
            logo.click();
            System.out.println("Clicked on Floating Action Button");
            
            // 2. Click on Dashboard
            WebElement dashboard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(@content-desc,'Open Dashboard')]//android.view.ViewGroup[2]")));
            dashboard.click();
            System.out.println("Clicked on Dashboard");
            
            // 3. Click on Profile Menu
            WebElement profileMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(@text,'Profile Menu') or contains(@content-desc,'Profile Menu')]")));
            profileMenu.click();
            System.out.println("Clicked on Profile Menu");
            
            // 4. Click on Customer Name
            WebElement customerName = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(@text,'Max Mustermann')]")));
            customerName.click();
            System.out.println("Clicked on Customer Name");
            
            // 5. Click on Edit Button
            WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@text=\" Edit\"]")));
            editBtn.click();
            System.out.println("Clicked on Edit Button");
            
            // 6. Locate and Edit First Name Field
            WebElement firstNameField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[@resource-id=\"first_name\"]")));
            
            // Clear existing text and enter new first name
            firstNameField.clear();
            String newFirstName = "Maximilian"; // New first name to set
            firstNameField.sendKeys(newFirstName);
            System.out.println("Edited First Name to: " + newFirstName);
            
            // Hide keyboard if it's open (optional)
            try {
                driver.hideKeyboard();
            } catch (Exception e) {
                System.out.println("Keyboard already hidden or not present");
            }
            
            
            // 7. Click on Save Button
            // Scroll to bottom to Save new data
            driver.findElement(AppiumBy.androidUIAutomator(
            	    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
            	    "new UiSelector().text(\" Save\"))"));
     
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@text=\" Save\"]")));
            saveBtn.click();
            System.out.println("Clicked on Save Button");
            
            // 8. Verification - Check if name was updated successfully
           // Scroll to top to bring updated name into view
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(1)"));

            try {
                WebElement updatedName = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(@text,'" + newFirstName + "')]")));
                System.out.println("Verification Successful! Name updated to: " + updatedName.getText());
            } catch (Exception e) {
                System.out.println("Verification failed - name might not have updated");
            }
            
        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Driver quit successfully");
        }
    }
}