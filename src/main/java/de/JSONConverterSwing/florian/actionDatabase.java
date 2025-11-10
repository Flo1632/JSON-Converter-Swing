package de.JSONConverterSwing.florian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class actionDatabase {
    // Initiale Variablen
    String  name;
    String userId;
    String[] fields;
    String doNotDo;

    // Constructor
    public actionDatabase(String name, String userId, String[] fields, String doNotDo) {
        this.name = name;
        this.userId = userId;
        this.fields = fields;
        this.doNotDo = doNotDo;
    }
    // Getter und Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String[] getFields() {
        return fields;
    }
    public void setFields(String[] fields) {
        this.fields = fields;
    }
    public String getDoNotDo() {
        return doNotDo;
    }
    public void setDoNotDo(String doNotDo) {
        this.doNotDo = doNotDo; 
    }
}
