package co.com.bancopichincha.opencart.screenplay.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public record CheckoutTestData(String baseUrl, List<String> products, GuestCheckoutData guest) {

    public static CheckoutTestData load() {
        Properties properties = new Properties();

        try (InputStream inputStream = CheckoutTestData.class.getClassLoader()
                .getResourceAsStream("checkout-data.properties")) {
            if (inputStream == null) {
                throw new IllegalStateException("No se encontro el archivo checkout-data.properties");
            }
            properties.load(inputStream);
        } catch (IOException exception) {
            throw new IllegalStateException("No fue posible cargar los datos de prueba", exception);
        }

        List<String> products = Arrays.stream(required(properties, "app.products").split(","))
                .map(String::trim)
                .toList();

        GuestCheckoutData guest = new GuestCheckoutData(
                required(properties, "guest.first.name"),
                required(properties, "guest.last.name"),
                required(properties, "guest.email"),
                required(properties, "guest.telephone"),
                required(properties, "guest.address.1"),
                properties.getProperty("guest.address.2", ""),
                required(properties, "guest.city"),
                required(properties, "guest.postcode"),
                required(properties, "guest.country"),
                required(properties, "guest.region")
        );

        return new CheckoutTestData(required(properties, "app.base.url"), products, guest);
    }

    private static String required(Properties properties, String key) {
        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Falta la propiedad obligatoria: " + key);
        }

        return value.trim();
    }
}
