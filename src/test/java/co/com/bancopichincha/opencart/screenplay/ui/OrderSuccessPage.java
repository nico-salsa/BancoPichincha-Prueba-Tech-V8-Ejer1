package co.com.bancopichincha.opencart.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class OrderSuccessPage {

    private OrderSuccessPage() {
    }

    public static final Target CONFIRMATION_TITLE = Target.the("titulo de confirmacion de la orden")
            .locatedBy("//div[@id='content']/h1");
}
