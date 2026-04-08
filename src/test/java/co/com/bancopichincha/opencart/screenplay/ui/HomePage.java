package co.com.bancopichincha.opencart.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    private HomePage() {
    }

    public static final Target CART_TOTAL = Target.the("total del carrito")
            .locatedBy("//span[@id='cart-total']");

    public static final Target SUCCESS_ALERT = Target.the("alerta de exito")
            .locatedBy("//div[contains(@class,'alert-success')]");

    public static final Target PRODUCT_CARD = Target.the("tarjeta del producto {0}")
            .locatedBy("//div[contains(@class,'product-thumb')][.//h4/a[normalize-space()='{0}']]");

    public static final Target ADD_TO_CART_BUTTON = Target.the("boton agregar al carrito del producto {0}")
            .locatedBy("//div[contains(@class,'product-thumb')][.//h4/a[normalize-space()='{0}']]//button[contains(@onclick,'cart.add')]");
}
