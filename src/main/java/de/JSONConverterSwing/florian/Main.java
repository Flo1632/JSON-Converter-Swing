package de.JSONConverterSwing.florian;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUIBoxLayout());


        //JSON String, der später gefüllt wird, Platzhalter


        //Wandelt je nach Input und Userwahl den entsprechenden JSON String um
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //String jsonOutput = gson.toJson(json);
    }
}