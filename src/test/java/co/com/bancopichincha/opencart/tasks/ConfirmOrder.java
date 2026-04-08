package co.com.bancopichincha.opencart.tasks;

import co.com.bancopichincha.opencart.constants.CheckoutConstants;
import co.com.bancopichincha.opencart.ui.CheckoutPage;
import co.com.bancopichincha.opencart.ui.OrderSuccessPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public final class ConfirmOrder {

    private ConfirmOrder() {
    }

    public static Performable now() {
        return Task.where(
                "{0} confirma la orden",
                Scroll.to(CheckoutPage.CONFIRM_ORDER_BUTTON),
                JavaScriptClick.on(CheckoutPage.CONFIRM_ORDER_BUTTON),
                WaitUntil.the(OrderSuccessPage.CONFIRMATION_TITLE,
                                WebElementStateMatchers.containsText(CheckoutConstants.CONFIRMATION_MESSAGE))
                        .forNoMoreThan(20).seconds()
        );
    }
}
