package co.com.bancopichincha.opencart.stepdefinitions;

import co.com.bancopichincha.opencart.constants.CheckoutConstants;
import co.com.bancopichincha.opencart.tasks.AddProductToCart;
import co.com.bancopichincha.opencart.tasks.CompleteGuestCheckout;
import co.com.bancopichincha.opencart.tasks.ConfirmOrder;
import co.com.bancopichincha.opencart.tasks.ProceedToCheckout;
import co.com.bancopichincha.opencart.tasks.ViewShoppingCart;
import co.com.bancopichincha.opencart.ui.CartPage;
import co.com.bancopichincha.opencart.ui.OrderSuccessPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenCartGuestCheckoutStepDefinitions {

    @Dado("que el comprador invitado ingresa a la tienda")
    public void queElCompradorInvitadoIngresaALaTienda() {
        OnStage.theActorCalled(CheckoutConstants.ACTOR_NAME)
                .attemptsTo(Open.url(CheckoutConstants.BASE_URL));
    }

    @Cuando("agrega los dos productos al carrito")
    public void agregaLosDosProductosAlCarrito() {
        actor().attemptsTo(
                AddProductToCart.named(CheckoutConstants.PRODUCTS.get(0), 1),
                AddProductToCart.named(CheckoutConstants.PRODUCTS.get(1), 2)
        );
    }

    @Cuando("visualiza el carrito de compras")
    public void visualizaElCarritoDeCompras() {
        actor().attemptsTo(ViewShoppingCart.now());
    }

    @Entonces("debe ver ambos productos en el carrito")
    public void debeVerAmbosProductosEnElCarrito() {
        Collection<String> cartProducts = actor().asksFor(Text.ofEach(CartPage.PRODUCT_NAMES));

        assertAll(
                () -> assertEquals(CheckoutConstants.PRODUCTS.size(), cartProducts.size(),
                        "El carrito debe contener exactamente dos productos"),
                () -> CheckoutConstants.PRODUCTS.forEach(product ->
                        assertTrue(
                                cartProducts.stream().anyMatch(item -> item.contains(product)),
                                "El carrito debe incluir el producto " + product
                        ))
        );
    }

    @Cuando("completa el checkout como invitado")
    public void completaElCheckoutComoInvitado() {
        actor().attemptsTo(
                ProceedToCheckout.now(),
                CompleteGuestCheckout.withDefaultData(),
                ConfirmOrder.now()
        );
    }

    @Entonces("la orden se completa con el mensaje de confirmacion final")
    public void laOrdenSeCompletaConElMensajeDeConfirmacionFinal() {
        String confirmationTitle = actor().asksFor(Text.of(OrderSuccessPage.CONFIRMATION_TITLE));

        assertEquals(CheckoutConstants.CONFIRMATION_MESSAGE, confirmationTitle,
                "La orden debe finalizar con el mensaje esperado");
    }

    private Actor actor() {
        return OnStage.theActorInTheSpotlight();
    }
}
