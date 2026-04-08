package co.com.bancopichincha.opencart.ui;

import net.serenitybdd.screenplay.targets.Target;

public final class CartPage {

    public static final Target PRODUCT_NAMES = Target.the("productos visibles en el carrito")
            .locatedBy("//div[@id='checkout-cart']//table[contains(@class,'table-bordered')]//td[@class='text-left']/a[contains(@href,'route=product/product')]");

    private CartPage() {
    }
}
