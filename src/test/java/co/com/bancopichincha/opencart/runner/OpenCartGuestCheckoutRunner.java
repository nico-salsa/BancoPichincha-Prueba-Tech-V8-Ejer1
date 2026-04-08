package co.com.bancopichincha.opencart.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features/opencart_guest_checkout.feature",
        glue = "co.com.bancopichincha.opencart.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class OpenCartGuestCheckoutRunner {
}
