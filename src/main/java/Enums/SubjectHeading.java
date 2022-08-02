package Enums;

public enum SubjectHeading {

    CUSTOMER_SERVICE("Customer service"),
    WEBMASTER("Webmaster");

    private String value;

    SubjectHeading(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}