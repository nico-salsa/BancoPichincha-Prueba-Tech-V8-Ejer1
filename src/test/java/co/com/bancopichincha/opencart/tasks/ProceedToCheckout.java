package co.com.bancopichincha.opencart.tasks;

import co.com.bancopichincha.opencart.constants.CheckoutConstants;
import co.com.bancopichincha.opencart.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public final class ProceedToCheckout {

    private ProceedToCheckout() {
    }

    public static Performable now() {
        return Task.where(
                "{0} inicia el checkout desde el carrito",
                Open.url(CheckoutConstants.CHECKOUT_URL),
                WaitUntil.the(CheckoutPage.GUEST_CHECKOUT_OPTION, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds()
        );
    }
}
