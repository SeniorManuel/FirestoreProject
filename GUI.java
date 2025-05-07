package org.example;

import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUI extends JFrame {
    JLabel firstNameLabel, lastNameLabel, rscoreLabel, tscoreLabel;
    JTextField firstNameField, lastNameField, rscoreField, tscoreField, rawField, totalField;
    JButton submit, loadButton;
    JTable table;
    DefaultTableModel model;

    public GUI() {
        setTitle("Firestore Data");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rscoreLabel = new JLabel("RawScore: ");
        tscoreLabel = new JLabel("TotalScore: ");
        rawField = new JTextField(10);
        totalField = new JTextField(10);
        submit = new JButton("Save button");

//        loadButton = new JButton("Load Data");

//        model = new DefaultTableModel();
//        model.addColumn("First Name");
//        model.addColumn("Last Name");
//        table = new JTable(model);
//        JScrollPane scrollPane = new JScrollPane(table);

        add(firstNameLabel);
        add(lastNameField);
        add(lastNameLabel);
        add(firstNameField);
//        add(rscoreLabel);
//        add(rawField);
//        add(tscoreLabel);
//        add(totalField);
        add(submit);
//        add(loadButton);
//        add(scrollPane);

        setSize(800, 100);
        setVisible(true);
    }
}


