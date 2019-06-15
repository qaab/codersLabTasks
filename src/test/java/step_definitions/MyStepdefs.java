package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.sele
nium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MyStepdefs {

    private WebDriver driver;
    private String nipBox;



//    private String getEmail() {
//        String emailName = randomAlphanumeric(5);
//        String subDomain = randomAlphanumeric(5);
//        String domain = randomAlphanumeric(3);
//        return String.format("%s@s%s.%s", emailName, subDomain, domain);
//
//
//    }



    @Given("browser displays registration page")
    public void browserDisplaysRegistrationPage() {
        System.setProperty("webdriver.chrome.driver","/home/cmok/chromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://men-men-s-01.codersguru.pl/");

    }


    @When("user clicks registration button")
    public void userClicksRegistrationButton() {

        driver.findElement(By.cssSelector(".link.main-page-top__email-input-sent")).click();

    }

    @Then("user opens registration site")
    public void userOpensRegistrationSite() {
        String assertText = driver.findElement(By.className("registration_header")).getText();
        assertEquals(assertText,"Zarejestruj sie");                        // wprowadzic polskie znaki


    }


    @When("user fills fields up with values:")
    public void userFillsFieldsUpWithValues(List<String> inputValues) {

        driver.findElement(By.name("first_name")).sendKeys(inputValues.get(0));
        driver.findElement(By.name("last_name")).sendKeys(inputValues.get(1));
        driver.findElement(By.name("email")).sendKeys(inputValues.get(2));
        driver.findElement(By.name("user_name")).sendKeys(inputValues.get(3));
        driver.findElement(By.name("address1")).sendKeys(inputValues.get(4));
        driver.findElement(By.name("city")).sendKeys(inputValues.get(5));
        driver.findElement(By.name("prov")).sendKeys(inputValues.get(6));
        driver.findElement(By.name("zip")).sendKeys(inputValues.get(7));
        driver.findElement(By.name("password")).sendKeys(inputValues.get(8));

    }

    @And("user is logged in")
    public void userIsLoggedIn() {
        String text = driver.findElement(By.xpath("//a [@href='/reservations']")).getText();
        System.out.println(text);
        assertEquals("Moja rezerwacje", text);
    }

    @Then("close page")
    public void closePage() {
        driver.close();
        driver.quit();
    }


}
