package org.kalbeka;

import org.openqa.selenium.By;

public enum Buttons {
    THREE("digit_3"),
    NINE("digit_9"),
    PLUS("op_add"),
    SUBS ("op_sub"),
    MULT("op_mul"),
    DIV("op_div"),
    EQUAL("eq"),

    RESULT("result_final");

    public String title;
    public By locator;

    Buttons(String title) {
        this.title = title;
        this.locator = By.id(String.format("com.google.android.calculator:id/%s", title));
    }
}
