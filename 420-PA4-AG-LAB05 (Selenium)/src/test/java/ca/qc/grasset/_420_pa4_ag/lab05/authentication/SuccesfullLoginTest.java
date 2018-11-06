package ca.qc.grasset._420_pa4_ag.lab05.authentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.qc.grasset._420_pa4_ag.lab05.commons.AbstractFunctionalTest;

public final class SuccesfullLoginTest

    extends AbstractFunctionalTest {

    public SuccesfullLoginTest() {

        super();

    }

    @Test
    public void test() {

        getDriver().get("http://the-internet.herokuapp.com/");

        getDriver().findElement(By.linkText("Form Authentication"))

            .click();

        getDriver().findElement(By.id("username"))

            .click();

        getDriver().findElement(By.id("username"))

            .clear();

        getDriver().findElement(By.id("username"))

            .sendKeys("tomsmith");

        getDriver().findElement(By.id("password"))

            .click();

        getDriver().findElement(By.id("password"))

            .clear();

        getDriver().findElement(By.id("password"))

            .sendKeys("SuperSecretPassword!");

        getDriver().findElement(

            By.xpath(

                "(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::button[1]"))

            .click();

    }

    @Override

    protected void validate() {

        WebElement element = getDriver().findElement(By.xpath("//*[@id=\"content\"]"));

        String actualMessage = element.getText();

        Assert.assertTrue("You logged into a secure area!".equals(actualMessage));

    }

}
