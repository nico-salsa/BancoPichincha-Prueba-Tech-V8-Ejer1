package co.com.bancopichincha.opencart.features;

import co.com.bancopichincha.opencart.screenplay.model.CheckoutTestData;
import co.com.bancopichincha.opencart.screenplay.tasks.AddProductToCart;
import co.com.bancopichincha.opencart.screenplay.tasks.CompleteGuestCheckout;
import co.com.bancopichincha.opencart.screenplay.tasks.ConfirmOrder;
import co.com.bancopichincha.opencart.screenplay.tasks.ProceedToCheckout;
import co.com.bancopichincha.opencart.screenplay.tasks.ViewShoppingCart;
import co.com.bancopichincha.opencart.screenplay.ui.CartPage;
import co.com.bancopichincha.opencart.screenplay.ui.OrderSuccessPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
class PurchaseAsGuestTest {

    private final CheckoutTestData testData = CheckoutTestData.load();

    @CastMember(name = "Comprador invitado")
    Actor shopper;

    @Test
    @DisplayName("Completa una compra guest checkout con dos productos")
    void shouldCompletePurchaseAsGuest() {
        shopper.attemptsTo(
                Open.url(testData.baseUrl()),
                AddProductToCart.named(testData.products().get(0), 1),
                AddProductToCart.named(testData.products().get(1), 2),
                ViewShoppingCart.now()
        );

        Collection<String> cartProducts = shopper.asksFor(Text.ofEach(CartPage.PRODUCT_NAMES));

        assertAll(
                () -> assertEquals(testData.products().size(), cartProducts.size(),
                        "El carrito debe contener exactamente dos productos"),
                () -> testData.products().forEach(product ->
                        assertTrue(
                                cartProducts.stream().anyMatch(item -> item.contains(product)),
                                "El carrito debe incluir el producto " + product
                        ))
        );

        shopper.attemptsTo(
                ProceedToCheckout.now(),
                CompleteGuestCheckout.withData(testData.guest()),
                ConfirmOrder.now()
        );

        String confirmationTitle = shopper.asksFor(Text.of(OrderSuccessPage.CONFIRMATION_TITLE));

        assertEquals("Your order has been placed!", confirmationTitle,
                "La orden debe finalizar con el mensaje esperado");
    }
}
