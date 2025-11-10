package de.JSONConverterSwing.florian;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class roleBased {
    //initalie Variablen
    private String role;
    private String objective;
    private String task;
    private String style;
    private String length;
    private String output_format; // Namenskonvention an JSON angepasst
    private String doNotDo;

    // Constructor
    public roleBased(String role, String objective, String task, String style, int maxLength, String output_format, String doNotDo) {
        this.role = role;
        this.objective = objective;
        this.task = task;
        this.style = style;
        this.length = "unter " + maxLength + " Zeichen";
        this.output_format = output_format;
        this.doNotDo = doNotDo;
    }

    //Getter und Setter
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getObjective() {
        return objective;
    }
    public void setObjective(String objective) {
        this.objective = objective;
    }
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public String getLength() {
        return length;
    }
    public void setLength(String length) {
        this.length = length;
    }
    public String getOutput_format() {
        return output_format;
    }
    public void setOutput_format(String output_format) {
        this.output_format = output_format;
    }
    public String getDoNotDo() {
        return doNotDo;
    }
    public void setDoNotDo(String doNotDo) {
        this.doNotDo = doNotDo;
    }
}