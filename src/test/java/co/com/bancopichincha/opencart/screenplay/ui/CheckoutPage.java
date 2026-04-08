package co.com.bancopichincha.opencart.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    private CheckoutPage() {
    }

    public static final Target GUEST_CHECKOUT_OPTION = Target.the("opcion guest checkout")
            .locatedBy("//input[@name='account' and @value='guest']");

    public static final Target ACCOUNT_CONTINUE_BUTTON = Target.the("boton continuar de tipo de cuenta")
            .locatedBy("//input[@id='button-account']");

    public static final Target PAYMENT_FIRST_NAME = Target.the("nombre de facturacion")
            .locatedBy("//input[@id='input-payment-firstname']");

    public static final Target PAYMENT_LAST_NAME = Target.the("apellido de facturacion")
            .locatedBy("//input[@id='input-payment-lastname']");

    public static final Target PAYMENT_EMAIL = Target.the("correo de facturacion")
            .locatedBy("//input[@id='input-payment-email']");

    public static final Target PAYMENT_TELEPHONE = Target.the("telefono de facturacion")
            .locatedBy("//input[@id='input-payment-telephone']");

    public static final Target PAYMENT_ADDRESS_1 = Target.the("direccion 1 de facturacion")
            .locatedBy("//input[@id='input-payment-address-1']");

    public static final Target PAYMENT_ADDRESS_2 = Target.the("direccion 2 de facturacion")
            .locatedBy("//input[@id='input-payment-address-2']");

    public static final Target PAYMENT_CITY = Target.the("ciudad de facturacion")
            .locatedBy("//input[@id='input-payment-city']");

    public static final Target PAYMENT_POSTCODE = Target.the("codigo postal de facturacion")
            .locatedBy("//input[@id='input-payment-postcode']");

    public static final Target PAYMENT_COUNTRY = Target.the("pais de facturacion")
            .locatedBy("//select[@id='input-payment-country']");

    public static final Target PAYMENT_ZONE = Target.the("region de facturacion")
            .locatedBy("//select[@id='input-payment-zone']");

    public static final Target PAYMENT_ZONE_OPTION = Target.the("opcion de region {0}")
            .locatedBy("//select[@id='input-payment-zone']/option[normalize-space()='{0}']");

    public static final Target GUEST_CONTINUE_BUTTON = Target.the("boton continuar guest checkout")
            .locatedBy("//input[@id='button-guest']");

    public static final Target SHIPPING_METHOD_OPTION = Target.the("opcion de metodo de envio flat rate")
            .locatedBy("//input[@name='shipping_method' and @value='flat.flat']");

    public static final Target SHIPPING_METHOD_CONTINUE_BUTTON = Target.the("boton continuar metodo de envio")
            .locatedBy("//input[@id='button-shipping-method']");

    public static final Target PAYMENT_METHOD_CASH_ON_DELIVERY = Target.the("metodo de pago cash on delivery")
            .locatedBy("//input[@name='payment_method' and @value='cod']");

    public static final Target TERMS_AND_CONDITIONS_CHECKBOX = Target.the("terminos y condiciones")
            .locatedBy("//input[@name='agree']");

    public static final Target PAYMENT_METHOD_CONTINUE_BUTTON = Target.the("boton continuar metodo de pago")
            .locatedBy("//input[@id='button-payment-method']");

    public static final Target CONFIRM_ORDER_BUTTON = Target.the("boton confirmar orden")
            .locatedBy("//*[@id='button-confirm' or (@type='button' and @value='Confirm Order')]");
}
