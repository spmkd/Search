package com.javelingroup.data;

public class Data {

    String[] fields;

    public Data(String line) {

        fields = line.split("/");

    }

    public String[] getData() {
        return fields;
    }

}
