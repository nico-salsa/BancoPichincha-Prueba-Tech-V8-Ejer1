package co.com.bancopichincha.opencart.ui;

import net.serenitybdd.screenplay.targets.Target;

public final class OrderSuccessPage {

    public static final Target CONFIRMATION_TITLE = Target.the("titulo de confirmacion de la orden")
            .locatedBy("//div[@id='content']/h1");

    private OrderSuccessPage() {
    }
}
