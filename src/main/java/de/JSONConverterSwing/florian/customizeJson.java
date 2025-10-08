package de.JSONConverterSwing.florian;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class customizeJson {
    //initalie Variablen
    private String task;
    private String topic;
    private String style;
    private String length;
    private String output_format; // Namenskonvention an JSON angepasst

    // Constructor
    public customizeJson(String task, String topic, String style, int maxLength, String output_format) {
        this.task = task;
        this.topic = topic;
        this.style = style;
        this.length = "unter " + maxLength + " Zeichen";
        this.output_format = output_format;
    }

    //Getter und Setter
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
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
}
