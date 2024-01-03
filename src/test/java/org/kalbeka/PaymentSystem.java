package org.kalbeka;

import org.openqa.selenium.By;

public enum PaymentSystem {
    MASTERCARD("mastercard-system"),
    VISA("visa-system"),
    BELKART("belkart-system"),
    MIR("mir-system-ru"),
    MAESTRO("maestro-system");

    public String title;
    public By locator;

    PaymentSystem(String title) {
        this.title = title;
        this.locator = By.xpath(String.format("//img[@src='assets/images/payment-icons/card-types/%s.svg']", title));
    }
}