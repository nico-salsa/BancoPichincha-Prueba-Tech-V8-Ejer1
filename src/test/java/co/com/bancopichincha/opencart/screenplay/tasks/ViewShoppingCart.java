package co.com.bancopichincha.opencart.screenplay.tasks;

import co.com.bancopichincha.opencart.screenplay.ui.CartPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ViewShoppingCart {

    private ViewShoppingCart() {
    }

    public static Performable now() {
        return Task.where(
                "{0} visualiza el carrito de compras",
                Open.url("http://opencart.abstracta.us/index.php?route=checkout/cart"),
                WaitUntil.the(CartPage.PRODUCT_NAMES, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(15).seconds()
        );
    }
}
