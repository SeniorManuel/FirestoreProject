package org.example;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        org.example.FirestoreConnection fs = new org.example.FirestoreConnection();
        org.example.GUI gui = new org.example.GUI();

        gui.submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                     int raw = Integer.parseInt(gui.rawField.getText());
                     int total = Integer.parseInt(gui.totalField.getText());
                     fs.addScoreToEmmanuel(raw, total);
                 } catch (NumberFormatException ex) {
                     System.out.println("Invalid number input.");
                 }
            }
        });
    }
}

//        gui.loadButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                loadDataFromFirestore(fs, gui);
//            }
//        });

//    private static void loadDataFromFirestore(org.example.FirestoreConnection fs, org.example.GUI gui) {
//        ArrayList<org.example.Person> persons = fs.getAllPersons();
//
//        DefaultTableModel model = (DefaultTableModel) gui.table.getModel();
//
//        model.setRowCount(0);
//
//        for (org.example.Person person : persons) {
//            model.addRow(new Object[]{person.getFirstName(), person.getLastName()});
//        }
//    }