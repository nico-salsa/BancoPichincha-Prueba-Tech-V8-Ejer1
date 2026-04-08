package co.com.bancopichincha.opencart.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    private CartPage() {
    }

    public static final Target PRODUCT_NAMES = Target.the("productos visibles en el carrito")
            .locatedBy("//div[@id='checkout-cart']//table[contains(@class,'table-bordered')]//td[@class='text-left']/a[contains(@href,'route=product/product')]");
}
