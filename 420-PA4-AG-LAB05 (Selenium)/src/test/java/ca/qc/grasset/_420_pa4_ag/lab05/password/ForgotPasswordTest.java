package ca.qc.grasset._420_pa4_ag.lab05.password;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.qc.grasset._420_pa4_ag.lab05.commons.AbstractFunctionalTest;

public final class ForgotPasswordTest

    extends AbstractFunctionalTest {

    public ForgotPasswordTest() {

        super();

    }

    @Test

    public void test() {

        getDriver().get("http://the-internet.herokuapp.com/");

        getDriver().findElement(By.linkText("Forgot Password"))

            .click();

        getDriver().findElement(By.id("email"))

            .click();

        getDriver().findElement(By.id("email"))

            .clear();

        getDriver().findElement(By.id("email"))

            .sendKeys("igncio@gmail.com");

        getDriver().findElement(By.id("form_submit"))

            .click();

        validate();

    }

    protected void validate() {

        WebElement element = getDriver().findElement(By.xpath("//*[@id=\"content\"]"));

        String actualMessage = element.getText();

        Assert.assertTrue("Your e-mail's been sent!".equals(actualMessage));

    }

}
