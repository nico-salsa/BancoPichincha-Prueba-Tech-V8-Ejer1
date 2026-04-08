package co.com.bancopichincha.opencart.screenplay.tasks;

import co.com.bancopichincha.opencart.screenplay.model.GuestCheckoutData;
import co.com.bancopichincha.opencart.screenplay.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class CompleteGuestCheckout {

    private CompleteGuestCheckout() {
    }

    public static Performable withData(GuestCheckoutData guest) {
        return Task.where(
                "{0} completa el checkout como invitado",
                WaitUntil.the(CheckoutPage.GUEST_CHECKOUT_OPTION, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),
                Click.on(CheckoutPage.GUEST_CHECKOUT_OPTION),
                Click.on(CheckoutPage.ACCOUNT_CONTINUE_BUTTON),
                WaitUntil.the(CheckoutPage.PAYMENT_FIRST_NAME, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),
                Enter.theValue(guest.firstName()).into(CheckoutPage.PAYMENT_FIRST_NAME),
                Enter.theValue(guest.lastName()).into(CheckoutPage.PAYMENT_LAST_NAME),
                Enter.theValue(guest.email()).into(CheckoutPage.PAYMENT_EMAIL),
                Enter.theValue(guest.telephone()).into(CheckoutPage.PAYMENT_TELEPHONE),
                Enter.theValue(guest.addressLine1()).into(CheckoutPage.PAYMENT_ADDRESS_1),
                Enter.theValue(guest.addressLine2()).into(CheckoutPage.PAYMENT_ADDRESS_2),
                Enter.theValue(guest.city()).into(CheckoutPage.PAYMENT_CITY),
                Enter.theValue(guest.postcode()).into(CheckoutPage.PAYMENT_POSTCODE),
                SelectFromOptions.byVisibleText(guest.country()).from(CheckoutPage.PAYMENT_COUNTRY),
                WaitUntil.the(CheckoutPage.PAYMENT_ZONE_OPTION.of(guest.region()), WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),
                SelectFromOptions.byVisibleText(guest.region()).from(CheckoutPage.PAYMENT_ZONE),
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
