package co.com.bancopichincha.opencart.constants;

import java.util.List;

public final class CheckoutConstants {

    public static final String BASE_URL = "http://opencart.abstracta.us/";
    public static final String CART_URL = BASE_URL + "index.php?route=checkout/cart";
    public static final String CHECKOUT_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";
    public static final String ACTOR_NAME = "Comprador invitado";
    public static final String CONFIRMATION_MESSAGE = "Your order has been placed!";
    public static final List<String> PRODUCTS = List.of("MacBook", "iPhone");

    private CheckoutConstants() {
    }
}
