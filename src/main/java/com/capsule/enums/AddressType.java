package com.capsule.enums;

public enum AddressType {
    HOME("Home"), POSTAL("Postal"), OFFICE("Office");

    private String value;

    AddressType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
