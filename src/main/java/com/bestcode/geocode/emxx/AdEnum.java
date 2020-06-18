package com.bestcode.geocode.emxx;

public enum AdEnum {
    COUNTRY("china"),
    PROVINCE("province"),
    CITY("city"),
    COUNTY("county");

    private String name;
    AdEnum(String name) {
        this.name = name;
    }
}
