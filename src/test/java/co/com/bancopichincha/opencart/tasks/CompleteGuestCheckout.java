package co.com.bancopichincha.opencart.tasks;

import co.com.bancopichincha.opencart.constants.GuestCheckoutConstants;
import co.com.bancopichincha.opencart.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public final class CompleteGuestCheckout {

    private CompleteGuestCheckout() {
    }

    public static Performable withDefaultData() {
        return Task.where(
                "{0} completa el checkout como invitado",
                WaitUntil.the(CheckoutPage.GUEST_CHECKOUT_OPTION, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),
                Click.on(CheckoutPage.GUEST_CHECKOUT_OPTION),
                Click.on(CheckoutPage.ACCOUNT_CONTINUE_BUTTON),
                WaitUntil.the(CheckoutPage.PAYMENT_FIRST_NAME, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),
                Enter.theValue(GuestCheckoutConstants.FIRST_NAME).into(CheckoutPage.PAYMENT_FIRST_NAME),
                Enter.theValue(GuestCheckoutConstants.LAST_NAME).into(CheckoutPage.PAYMENT_LAST_NAME),
                Enter.theValue(GuestCheckoutConstants.EMAIL).into(CheckoutPage.PAYMENT_EMAIL),
                Enter.theValue(GuestCheckoutConstants.TELEPHONE).into(CheckoutPage.PAYMENT_TELEPHONE),
                Enter.theValue(GuestCheckoutConstants.ADDRESS_LINE_1).into(CheckoutPage.PAYMENT_ADDRESS_1),
                Enter.theValue(GuestCheckoutConstants.ADDRESS_LINE_2).into(CheckoutPage.PAYMENT_ADDRESS_2),
                Enter.theValue(GuestCheckoutConstants.CITY).into(CheckoutPage.PAYMENT_CITY),
                Enter.theValue(GuestCheckoutConstants.POSTCODE).into(CheckoutPage.PAYMENT_POSTCODE),
                SelectFromOptions.byVisibleText(GuestCheckoutConstants.COUNTRY).from(CheckoutPage.PAYMENT_COUNTRY),
                WaitUntil.the(CheckoutPage.PAYMENT_ZONE_OPTION.of(GuestCheckoutConstants.REGION), WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),
                SelectFromOptions.byVisibleText(GuestCheckoutConstants.REGION).from(CheckoutPage.PAYMENT_ZONE),
                Scroll.to(CheckoutPage.GUEST_CONTINUE_BUTTON),
                Click.on(CheckoutPage.GUEST_CONTINUE_BUTTON),
                WaitUntil.the(CheckoutPage.SHIPPING_METHOD_OPTION, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),
                Click.on(CheckoutPage.SHIPPING_METHOD_OPTION),
                Click.on(CheckoutPage.SHIPPING_METHOD_CONTINUE_BUTTON),
                WaitUntil.the(CheckoutPage.PAYMENT_METHOD_CASH_ON_DELIVERY, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),
                Click.on(CheckoutPage.PAYMENT_METHOD_CASH_ON_DELIVERY),
                Click.on(CheckoutPage.TERMS_AND_CONDITIONS_CHECKBOX),
                Click.on(CheckoutPage.PAYMENT_METHOD_CONTINUE_BUTTON),
                WaitUntil.the(CheckoutPage.CONFIRM_ORDER_BUTTON, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds()
        );
    }
}
