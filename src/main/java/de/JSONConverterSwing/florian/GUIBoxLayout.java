package de.JSONConverterSwing.florian;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.awt.*;



public class GUIBoxLayout {
    // 1.CardLayout Object
    CardLayout cardLayout;

    //2. JPanel als Hauptkartenpanel setzen
    JPanel kartenPanel;

    // Kartenkonstanten
    final static String KARTE_1 = "allgemeiner JSON";
    final static String KARTE_2 = "Data Base";
    final static String KARTE_3 = "Blog Idee";

    public GUIBoxLayout() {
        JFrame frame = new JFrame("JSON Converter Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setVisible(true);

        //Mainpanel für Frame aufteilung
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);
        //Karte 1 Layout
        JPanel allgemeinesJson = new JPanel();
        allgemeinesJson.setLayout(new BoxLayout(allgemeinesJson, BoxLayout.Y_AXIS));
        allgemeinesJson.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        allgemeinesJson.setAlignmentY(Component.TOP_ALIGNMENT);

        //Auswahlpanel
        JPanel auswahlPanel = new JPanel();
        auswahlPanel.setLayout(new BoxLayout(auswahlPanel, BoxLayout.Y_AXIS));
        auswahlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        auswahlPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel auswahlLabel = new JLabel("Wähle eine Vorlage");

        auswahlPanel.add(auswahlLabel);

        //RadioButtons
        JRadioButton customizedJRadioButton = new JRadioButton("Allgemeiner Input, der in ein JSON-Format umgewandelt wird");
        JRadioButton dataBasedJRadioButton = new JRadioButton("Vorlage Datenbankabfragen - dataBase JSON");
        JRadioButton blogIdeeJRadioButton = new JRadioButton("Vorlage Blogs/Social Media oder Prompts mit mehreren Schritten - blogIdee JSON");
        // Buttongroup
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(customizedJRadioButton);
        buttonGroup.add(dataBasedJRadioButton);
        buttonGroup.add(blogIdeeJRadioButton);
        auswahlPanel.add(customizedJRadioButton);
        auswahlPanel.add(dataBasedJRadioButton);
        auswahlPanel.add(blogIdeeJRadioButton);

        //Auswahllogik
        customizedJRadioButton.addActionListener(e -> {
            if (customizedJRadioButton.isSelected()) {
                cardLayout.show(kartenPanel, KARTE_1);
            }
        });

        dataBasedJRadioButton.addActionListener(e -> {
            if (dataBasedJRadioButton.isSelected()) {
                cardLayout.show(kartenPanel, KARTE_2);
            }
        });
        blogIdeeJRadioButton.addActionListener(e -> {
            if (blogIdeeJRadioButton.isSelected()) {
                cardLayout.show(kartenPanel, KARTE_3);
            }
        });



        // Karte 1 Inhalte
        JLabel setzeTask = new JLabel("Was ist die Aufgabe/der Task?");
        allgemeinesJson.add(setzeTask);
        JTextField setzeTaskField = new JTextField("z.B. Recherche, Coding, CV Erstellung");
        allgemeinesJson.add(setzeTaskField);
        JLabel setzeTopic = new JLabel("Über welches Thema geht es?");
        allgemeinesJson.add(setzeTopic);
        JTextField setzeTopicField = new JTextField("z.B. Java, Python, Kochen, KI");
        allgemeinesJson.add(setzeTopicField);
        JLabel setzeStyle = new JLabel("In welchem Stil soll der Output erfolgen?");
        allgemeinesJson.add(setzeStyle);
        JTextField setzeStyleField = new JTextField("z.B. Blog Post, Gedicht, Zusammenfassung");
        allgemeinesJson.add(setzeStyleField);
        JLabel  setzeLenght = new JLabel("Wie lang soll der Output sein (in Zeichen)?");
        allgemeinesJson.add(setzeLenght);
        JTextField setzeLenghtField = new JTextField("z.B. 400 Zeichen");
        allgemeinesJson.add(setzeLenghtField);
        JLabel setzeOutputFormat = new JLabel("Spezifiziere das Output-Format");
        allgemeinesJson.add(setzeOutputFormat);
        JTextField setzeOutputFormatField = new JTextField("JSON, Text, Tabelle");
        allgemeinesJson.add(setzeOutputFormatField);

        JButton speichernAllgemeinesJson = new JButton("Speichern ");
        allgemeinesJson.add(speichernAllgemeinesJson);

        JTextArea jsonFromatted = new JTextArea("");
        allgemeinesJson.add(jsonFromatted);
        String appendString1 = "\n\nAusdrücke für JSON-Path Abfragen: \n" +
                "$.task | $.topic | $.style | $.length | $.output_format";
        speichernAllgemeinesJson.addActionListener(e ->  {
            String task = setzeTaskField.getText();
            String topic = setzeTopicField.getText();
            String style = setzeStyleField.getText();
            int maxLenght;  try {
                maxLenght = Integer.parseInt(setzeLenghtField.getText());
            } catch (NumberFormatException exception){
                maxLenght = 100;
                JOptionPane.showMessageDialog(null, "Bitte Zahlen verwenden in Outputlänge!");
            }
            String outputFormat = setzeOutputFormatField.getText();

            customizeJson customizedJson = new customizeJson(task, topic, style, maxLenght, outputFormat);
            //Wandelt je nach Input und Userwahl den entsprechenden JSON String um
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(customizedJson);
            String finalJsonOutput1 = jsonOutput + appendString1;
            jsonFromatted.setText(finalJsonOutput1);
        });

        // Karte 2 Layout
        JPanel dataBasePanel = new JPanel();
        dataBasePanel.setLayout(new BoxLayout(dataBasePanel, BoxLayout.Y_AXIS));
        dataBasePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        dataBasePanel.setAlignmentY(Component.TOP_ALIGNMENT);

        // Karte 2 Inhalte
        JLabel nameLabel = new JLabel("Name:");
        dataBasePanel.add(nameLabel);
        JTextField nameField = new JTextField();
        dataBasePanel.add(nameField);
        JLabel idLabel = new JLabel("User ID:");
        dataBasePanel.add(idLabel);
        JTextField idField = new JTextField();
        dataBasePanel.add(idField);
        JLabel dataFieldsLabel = new JLabel("Welche Felder sollen abgefragt werden (Bitte mit Komma trennen)?");
        dataBasePanel.add(dataFieldsLabel);
        JTextField dataFieldsField = new JTextField();
        dataBasePanel.add(dataFieldsField);

        // Button zum Speichern
        JButton dataBaseButton = new JButton("Speichern");
        dataBasePanel.add(dataBaseButton);



        JTextArea dataBaseTextArea = new JTextArea("");

        dataBasePanel.add(dataBaseTextArea);

        //String für Keys
        String appendString2 = "\n\nAusdrücke für JSON-Path Abfragen: \n" +
                "$.name | $.userId | \n " +
                "$.fields (gesamtes Array) \n " +
                "$.fields[*] (alle Elemente im Array) \n " +
                "$.fields[0] (erstes Elemente im Array) \n " +
                "$.fields[1] (zweites Elemente im Array) \n " +
                "$.fields[-1] (letztes Elemente im Array) \n ";


        dataBaseButton.addActionListener(e -> {
            String name = nameField.getText();
            String userId = idField.getText();
            String fieldsString = dataFieldsField.getText();
            String[] fields = fieldsString.split(",");
            actionDatabase actionDatabase = new actionDatabase(name, userId, fields);
            //Wandelt je nach Input und Userwahl den entsprechenden JSON String um
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(actionDatabase);
            String finalJsonOutput2 = jsonOutput + appendString2;
            dataBaseTextArea.setText(finalJsonOutput2);
        });

        //KARTE 3
        JPanel blog = new JPanel();
        blog.setLayout(new BoxLayout(blog, BoxLayout.Y_AXIS));
        blog.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        blog.setAlignmentY(Component.TOP_ALIGNMENT);

        JLabel blogLabel = new JLabel("Was soll das Tool tun? / Enter your Tasks:");
        blog.add(blogLabel);
        JTextField blogFieldTask1 = new JTextField("1.");
        blog.add(blogFieldTask1);
        JTextField blogFieldTask2 = new JTextField("2. ");
        blog.add(blogFieldTask2);
        JTextField blogFieldTask3 = new JTextField("3. ");
        blog.add(blogFieldTask3);
        JLabel topicsLabel = new JLabel("Topic / Thema:");
        blog.add(topicsLabel);
        JTextField topicsField = new JTextField();
        blog.add(topicsField);
        JLabel targetAudienceLabel = new JLabel("Target Audience / Zielgruppe:");
        blog.add(targetAudienceLabel);
        JTextField targetAudienceField = new JTextField();
        blog.add(targetAudienceField);
        JLabel quantityLabel = new JLabel("Wieviele Versionen sollen bereitgestellt werden?");
        blog.add(quantityLabel);
        JTextField quantityField = new JTextField();
        blog.add(quantityField);
        JLabel outputFormatLabel = new JLabel("Output Format:");
        blog.add(outputFormatLabel);
        JTextField outputFormatField = new JTextField();
        blog.add(outputFormatField);

        // Speichern Button
        JButton outputBlogFormatButton = new JButton("Speichern");
        blog.add(outputBlogFormatButton);
        JTextArea outputFormatTextArea = new JTextArea("");
        //JScrollPane outputFormatScrollPane = new JScrollPane(outputFormatTextArea);
        blog.add(outputFormatTextArea);
        // String für JSON Keys
        String appendString3 = "\n\nAusdrücke für JSON-Path Abfragen: \n" +
                "$.topic | $.targetAudience | \n" +
                "$.quantity \n" +
                "$.outputFormat \n" +
                "$.tasks (gibt das gesamte Tasks-Objekt aus {}) \n" +
                "Abfragen für das verschachtelte Objekt: \n" +
                "$.tasks.task1 (Wert Task 1) \n" +
                "$.tasks.task2 (Wert Task 2) \n" +
                "$.tasks.task3 (Wert Task 3) \n" +
                "$.tasks.* (Alle Werte innerhalb von Tasks als Array []) \n";
        outputBlogFormatButton.addActionListener(e -> {
                String task1 = blogFieldTask1.getText();
                String task2 = blogFieldTask2.getText();
                String task3 = blogFieldTask3.getText();
                String topic = topicsField.getText();
                String targetAudience = targetAudienceField.getText();
                int quantity;
                try {
                    quantity = Integer.parseInt(quantityField.getText());
                } catch (NumberFormatException exception) {
                    quantity = 1;
                    JOptionPane.showMessageDialog(null, "Bitte Zahlen bei Versionen verwenden!");
                }
                String outputFormat = outputFormatField.getText();
                //String für JSON Keys

                // Calling the Constructor
                BlogIdeaPrompt blogIdeaPrompt = new BlogIdeaPrompt(task1, task2, task3, topic, targetAudience, quantity, outputFormat);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonOutput = gson.toJson(blogIdeaPrompt);
                String finalOutputFormat = jsonOutput + appendString3;
                outputFormatTextArea.setText(finalOutputFormat);

        });

        //3. CardLayout initialisieren
        cardLayout = new CardLayout();
        //4. Hauptkartenpanel erstellen und Cardlayout zuweisen
        kartenPanel = new JPanel(cardLayout);
        kartenPanel.add(allgemeinesJson, KARTE_1);
        kartenPanel.add(dataBasePanel, KARTE_2);
        kartenPanel.add(blog, KARTE_3);


        // MainPanel
        mainPanel.add(auswahlPanel);
        JPanel descriptionPanel = new JPanel(new FlowLayout());
        JTextArea descriptionTextArea = new JTextArea("1. Wähle eine Vorlage \n" +
                "2. Fülle die Vorlage, Textfelder können auch leer sein \n" +
                "3. Drücke Speichern, um im unteren Textfeld deinen Prompt im JSON-Format zu sehen\n" +
                "4. Kopiere den Prompt und nutze ihn mit einem KI Modell deiner Wahl\n" +
                "5. Ganz unten siehst du Kurzbefehle, um Teile deines JSON abzufragen");
        descriptionTextArea.setPreferredSize(new Dimension(600, 100));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionPanel.add(descriptionTextArea);
        mainPanel.add(descriptionPanel);
        mainPanel.add(kartenPanel);

    }
}
