package co.com.bancopichincha.opencart.screenplay.tasks;

import co.com.bancopichincha.opencart.screenplay.ui.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class AddProductToCart {

    private AddProductToCart() {
    }

    public static Performable named(String productName, int expectedItemsInCart) {
        String expectedCartText = expectedItemsInCart + " item(s)";

        return Task.where(
                "{0} agrega el producto " + productName + " al carrito",
                WaitUntil.the(HomePage.PRODUCT_CARD.of(productName), WebElementStateMatchers.isVisible())
                        .forNoMoreThan(15).seconds(),
                Scroll.to(HomePage.ADD_TO_CART_BUTTON.of(productName)),
                Click.on(HomePage.ADD_TO_CART_BUTTON.of(productName)),
                WaitUntil.the(HomePage.SUCCESS_ALERT, WebElementStateMatchers.containsText(productName))
                        .forNoMoreThan(15).seconds(),
                WaitUntil.the(HomePage.CART_TOTAL, WebElementStateMatchers.containsText(expectedCartText))
                        .forNoMoreThan(15).seconds()
        );
    }
}
