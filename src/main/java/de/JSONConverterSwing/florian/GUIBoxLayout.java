package de.JSONConverterSwing.florian;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.awt.*;



public class GUIBoxLayout {
    
    private void configureTextArea(JTextArea textArea) {
    textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
    textArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200)); // Höhe anpassen nach Bedarf
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
}
    
    // 1.CardLayout Object
    CardLayout cardLayout;

    //2. JPanel als Hauptkartenpanel setzen
    JPanel kartenPanel;

    // Kartenkonstanten
    final static String KARTE_1 = "allgemeiner JSON";
    final static String KARTE_2 = "Data Base";
    final static String KARTE_3 = "Blog Idee";
    final static String KARTE_4 = "Rollen basierter Prompt";

    public GUIBoxLayout() {
        JFrame frame = new JFrame("JSON Converter Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setVisible(true);

        //Mainpanel für Frame aufteilung
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        frame.add(mainPanel);
        //Karte 1 Layout
        JPanel allgemeinesJson = new JPanel();
        allgemeinesJson.setLayout(new BoxLayout(allgemeinesJson, BoxLayout.Y_AXIS));
        allgemeinesJson.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        allgemeinesJson.setAlignmentY(Component.TOP_ALIGNMENT);
        allgemeinesJson.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Auswahlpanel
        JPanel auswahlPanel = new JPanel();
        auswahlPanel.setLayout(new BoxLayout(auswahlPanel, BoxLayout.Y_AXIS));
        auswahlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        auswahlPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        auswahlPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel auswahlLabel = new JLabel("Wähle eine Vorlage");
        auswahlLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        auswahlLabel.setMaximumSize(new  Dimension(Integer.MAX_VALUE, auswahlLabel.getPreferredSize().height));

        auswahlPanel.add(auswahlLabel);

        //RadioButtons
        JRadioButton customizedJRadioButton = new JRadioButton("Allgemeiner Input, der in ein JSON-Format umgewandelt wird");
        customizedJRadioButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        customizedJRadioButton.setMaximumSize(new  Dimension(Integer.MAX_VALUE, customizedJRadioButton.getPreferredSize().height));
        JRadioButton dataBasedJRadioButton = new JRadioButton("Vorlage Datenbankabfragen - dataBase JSON");
        dataBasedJRadioButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        dataBasedJRadioButton.setMaximumSize(new  Dimension(Integer.MAX_VALUE, dataBasedJRadioButton.getPreferredSize().height));
        JRadioButton blogIdeeJRadioButton = new JRadioButton("Vorlage Blogs/Social Media oder Prompts mit mehreren Schritten - blogIdee JSON");
        blogIdeeJRadioButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        blogIdeeJRadioButton.setMaximumSize(new  Dimension(Integer.MAX_VALUE, blogIdeeJRadioButton.getPreferredSize().height));
        JRadioButton rollenbasiertJRadioButton = new JRadioButton("Vorlage Rollen basierter Prompts - roleBased JSON");
        rollenbasiertJRadioButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        rollenbasiertJRadioButton.setMaximumSize(new  Dimension(Integer.MAX_VALUE, rollenbasiertJRadioButton.getPreferredSize().height));

        // Buttongroup
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(customizedJRadioButton);
        buttonGroup.add(dataBasedJRadioButton);
        buttonGroup.add(blogIdeeJRadioButton);
        buttonGroup.add(rollenbasiertJRadioButton);
        auswahlPanel.add(customizedJRadioButton);
        auswahlPanel.add(dataBasedJRadioButton);
        auswahlPanel.add(blogIdeeJRadioButton);
        auswahlPanel.add(rollenbasiertJRadioButton);

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
        rollenbasiertJRadioButton.addActionListener(e -> {
            if (rollenbasiertJRadioButton.isSelected()) {
                cardLayout.show(kartenPanel, KARTE_4);
            }
        });



        // Karte 1 Inhalte
        JLabel setzeTask = new JLabel("Was ist die Aufgabe/der Task?");
        setzeTask.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(setzeTask);
        JTextField setzeTaskField = new JTextField("z.B. Recherche, Coding, CV Erstellung");
        setzeTaskField.setAlignmentX(Component.LEFT_ALIGNMENT);
        //setzeTaskField.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(setzeTaskField);
        JLabel setzeTopic = new JLabel("Über welches Thema geht es?");
        setzeTopic.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(setzeTopic);
        JTextField setzeTopicField = new JTextField("z.B. Java, Python, Kochen, KI");
        setzeTopicField.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(setzeTopicField);
        JLabel setzeStyle = new JLabel("In welchem Stil soll der Output erfolgen?");
        setzeStyle.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(setzeStyle);
        JTextField setzeStyleField = new JTextField("z.B. Blog Post, Gedicht, Zusammenfassung");
        setzeStyleField.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(setzeStyleField);
        JLabel  setzeLenght = new JLabel("Wie lang soll der Output sein (in Zeichen)?");
        setzeLenght.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(setzeLenght);
        JTextField setzeLenghtField = new JTextField("z.B. 400 Zeichen");
        setzeLenghtField.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(setzeLenghtField);
        JLabel setzeOutputFormat = new JLabel("Spezifiziere das Output-Format");
        setzeOutputFormat.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(setzeOutputFormat);
        JTextField setzeOutputFormatField = new JTextField("JSON, Text, Tabelle");
        setzeOutputFormatField.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(setzeOutputFormatField);
        JLabel doNotDoLabel = new JLabel("Was soll vermieden werden?");
        doNotDoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(doNotDoLabel);
        JTextField doNotDoField = new JTextField("z.B. keine Fachbegriffe, keine Aufzählungen");
        doNotDoField.setAlignmentX(Component.LEFT_ALIGNMENT);
        allgemeinesJson.add(doNotDoField);

        JButton speichernAllgemeinesJson = new JButton("JSON generieren ");
        allgemeinesJson.add(speichernAllgemeinesJson);

        JTextArea jsonFromatted = new JTextArea("");
        configureTextArea(jsonFromatted);
        allgemeinesJson.add(jsonFromatted);
        String appendString1 = "\n\nAusdrücke für JSON-Path Abfragen: \n" +
                "$.task | $.topic | $.style | $.length | $.output_format | $.doNotDo \n";
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
            String doNotDo = doNotDoField.getText();

            customizeJson customizedJson = new customizeJson(task, topic, style, maxLenght, outputFormat, doNotDo);
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
        dataBasePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Karte 2 Inhalte
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dataBasePanel.add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        dataBasePanel.add(nameField);
        JLabel idLabel = new JLabel("User ID:");
        idLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dataBasePanel.add(idLabel);
        JTextField idField = new JTextField();
        idField.setAlignmentX(Component.LEFT_ALIGNMENT);
        dataBasePanel.add(idField);
        JLabel dataFieldsLabel = new JLabel("Welche Felder sollen abgefragt werden (Bitte mit Komma trennen)?");
        dataFieldsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dataBasePanel.add(dataFieldsLabel);
        JTextField dataFieldsField = new JTextField();
        dataFieldsField.setAlignmentX(Component.LEFT_ALIGNMENT);
        dataBasePanel.add(dataFieldsField);
        JLabel doNotDoDataBaseLabel = new JLabel("Was soll vermieden werden?");
        doNotDoDataBaseLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dataBasePanel.add(doNotDoDataBaseLabel);
        JTextField doNotDoDataBaseField = new JTextField("z.B. keine Fachbegriffe, keine Aufzählungen");
        doNotDoDataBaseField.setAlignmentX(Component.LEFT_ALIGNMENT);
        dataBasePanel.add(doNotDoDataBaseField);

        // Button zum Speichern
        JButton dataBaseButton = new JButton("JSON generieren ");
        dataBasePanel.add(dataBaseButton);



        JTextArea dataBaseTextArea = new JTextArea("");
        configureTextArea(dataBaseTextArea);
        dataBasePanel.add(dataBaseTextArea);

        //String für Keys
        String appendString2 = "\n\nAusdrücke für JSON-Path Abfragen: \n" +
                "$.name | $.userId | \n " +
                "$.fields (gesamtes Array) \n " +
                "$.fields[*] (alle Elemente im Array) \n " +
                "$.fields[0] (erstes Elemente im Array) \n " +
                "$.fields[1] (zweites Elemente im Array) \n " +
                "$.fields[-1] (letztes Elemente im Array) \n " +
                "$.doNotDo \n";


        dataBaseButton.addActionListener(e -> {
            String name = nameField.getText();
            String userId = idField.getText();
            String fieldsString = dataFieldsField.getText();
            String[] fields = fieldsString.split(",");
            String doNotDo = doNotDoDataBaseField.getText();
            actionDatabase actionDatabase = new actionDatabase(name, userId, fields, doNotDo);
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
        blog.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel blogLabel = new JLabel("Was soll das Tool tun? / Enter your Tasks:");
        blogLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(blogLabel);
        JTextField blogFieldTask1 = new JTextField("1.");
        blogFieldTask1.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(blogFieldTask1);
        JTextField blogFieldTask2 = new JTextField("2. ");
        blogFieldTask2.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(blogFieldTask2);
        JTextField blogFieldTask3 = new JTextField("3. ");
        blogFieldTask3.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(blogFieldTask3);
        JLabel topicsLabel = new JLabel("Topic / Thema:");
        topicsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(topicsLabel);
        JTextField topicsField = new JTextField();
        topicsField.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(topicsField);
        JLabel targetAudienceLabel = new JLabel("Target Audience / Zielgruppe:");
        targetAudienceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(targetAudienceLabel);
        JTextField targetAudienceField = new JTextField();
        targetAudienceField.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(targetAudienceField);
        JLabel quantityLabel = new JLabel("Wieviele Versionen sollen bereitgestellt werden?");
        quantityLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(quantityLabel);
        JTextField quantityField = new JTextField();
        quantityField.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(quantityField);
        JLabel outputFormatLabel = new JLabel("Output Format:");
        outputFormatLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(outputFormatLabel);
        JTextField outputFormatField = new JTextField();
        outputFormatField.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(outputFormatField);
        JLabel doNotDoBlogLabel = new JLabel("Was soll vermieden werden?");
        doNotDoBlogLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(doNotDoBlogLabel);
        JTextField doNotDoBlogField = new JTextField("z.B. keine Fachbegriffe, keine Aufzählungen");
        doNotDoBlogField.setAlignmentX(Component.LEFT_ALIGNMENT);
        blog.add(doNotDoBlogField);

        // Speichern Button
        JButton outputBlogFormatButton = new JButton("JSON generieren ");
        blog.add(outputBlogFormatButton);
        JTextArea outputFormatTextArea = new JTextArea("");
        configureTextArea(outputFormatTextArea);
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
                "$.tasks.* (Alle Werte innerhalb von Tasks als Array []) \n" +
                "$.tasks..* (Alle Werte innerhalb von Tasks, auch bei tieferer Verschachtelung) \n" +
                "$.doNotDo \n";
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
                String doNotDo = doNotDoBlogField.getText();
                //String für JSON Keys

                // Calling the Constructor
                BlogIdeaPrompt blogIdeaPrompt = new BlogIdeaPrompt(task1, task2, task3, topic, targetAudience, quantity, outputFormat, doNotDo);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonOutput = gson.toJson(blogIdeaPrompt);
                String finalOutputFormat = jsonOutput + appendString3;
                outputFormatTextArea.setText(finalOutputFormat);

        });

        // Karte 4 Layout
        JPanel roleBasedPanel = new JPanel();
        roleBasedPanel.setLayout(new BoxLayout(roleBasedPanel, BoxLayout.Y_AXIS));
        roleBasedPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        roleBasedPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        roleBasedPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        


        //3. CardLayout initialisieren
        cardLayout = new CardLayout();
        //4. Hauptkartenpanel erstellen und Cardlayout zuweisen
        kartenPanel = new JPanel(cardLayout);
        kartenPanel.setAlignmentX(Component.LEFT_ALIGNMENT);  
        kartenPanel.setAlignmentY(Component.TOP_ALIGNMENT); 
        kartenPanel.add(allgemeinesJson, KARTE_1);
        kartenPanel.add(dataBasePanel, KARTE_2);
        kartenPanel.add(blog, KARTE_3);
        kartenPanel.add(roleBasedPanel, KARTE_4);


        // MainPanel
        mainPanel.add(auswahlPanel);
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
        descriptionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextArea descriptionTextArea = new JTextArea("\n  1. Wähle eine Vorlage \n" +
                "  2. Fülle die Vorlage, Textfelder können auch leer sein \n" +
                "  3. Drücke \"JSON generieren\", um im unteren Textfeld deinen Prompt im JSON-Format zu sehen\n" +
                "  4. Kopiere den Prompt und nutze ihn mit einem KI Modell deiner Wahl\n" +
                "  5. Ganz unten siehst du Kurzbefehle, um Teile deines JSON abzufragen");
        descriptionTextArea.setPreferredSize(new Dimension(600, 100));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionPanel.add(descriptionTextArea);
        mainPanel.add(descriptionPanel);
        mainPanel.add(kartenPanel);

    }
}
