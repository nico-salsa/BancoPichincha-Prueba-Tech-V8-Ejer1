package co.com.bancopichincha.opencart.screenplay.model;

public record GuestCheckoutData(
        String firstName,
        String lastName,
        String email,
        String telephone,
        String addressLine1,
        String addressLine2,
        String city,
        String postcode,
        String country,
        String region
) {
}
