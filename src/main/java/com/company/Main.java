package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
public class Main {
    private static JList jList;
    private static DefaultListModel model = new DefaultListModel();
    private static JLabel lastNameLabel;
    private static JTextField lastNameText;
    private static JLabel firstNameLabel;
    private static JTextField firstNameText;
    private static JLabel takeOffCityLabel;
    private static JTextField takeOffCityText;
    private static JLabel arrivalCityLabel;
    private static JTextField arrivalCityText;
    private static JButton saveButton;
    private static JButton modifyButton;
    private static JButton deleteButton;
    private static JButton addButton;
    private static JButton updateButton;
    private static JFrame frame;
    private static JPanel panel;

    public static void main(String[] args) {
        frame = new JFrame("BOARDING PASS");
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);


    }

    private static void placeComponents(JPanel panel) {

        jList = new JList(model);
        List <TicketInfo> ticketInfo= (List<List<TicketInfo>>) FileUtility.readFromFile();
        Object ticektInfo;
        for(TicketInfo : ticektInfo)
            model.addElement(ticektInfo);
        panel.add(jList);

        jList.setCellRenderer(createListRenderer());
        jList.setVisible(false);
        panel.setLayout(null);
        jList.setBounds(10, 50, 500, 130);



        JButton addObjectButton = new JButton("Add object");
        addObjectButton.setBounds(0, 0, 100, 25);
        panel.add(addObjectButton);

        JButton displayButton = new JButton("Display object");
        displayButton.setBounds(120, 0, 150, 25);
        panel.add(displayButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(300, 0, 100, 25);
        panel.add(exitButton);

        lastNameText = new JTextField(20);
        lastNameText.setBounds(150, 40, 165, 25);
        panel.add(lastNameText);

        lastNameLabel = new JLabel("Insert last name:");
        lastNameLabel.setBounds(10, 40, 160, 25);
        panel.add(lastNameLabel);

        firstNameText = new JTextField(20);
        firstNameText.setBounds(150, 70, 165, 25);
        panel.add(firstNameText);

        firstNameLabel = new JLabel("Insert first name:");
        firstNameLabel.setBounds(10, 70, 160, 25);
        panel.add(firstNameLabel);

        takeOffCityLabel = new JLabel("Insert take-off city:");
        takeOffCityLabel.setBounds(10, 100, 160, 25);
        panel.add(takeOffCityLabel);

        takeOffCityText = new JTextField(20);
        takeOffCityText.setBounds(150, 100, 165, 25);
        panel.add(takeOffCityText);

        arrivalCityLabel = new JLabel("Insert landing city:");
        arrivalCityLabel.setBounds(10, 130, 160, 25);
        panel.add(arrivalCityLabel);

        arrivalCityText = new JTextField(20);
        arrivalCityText.setBounds(150, 130, 165, 25);
        panel.add(arrivalCityText);

        addButton = new JButton("Add");
        addButton.setBounds(150, 220, 80, 25);
        panel.add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(150, 220, 80, 25);
        panel.add(updateButton);


        modifyButton = new JButton("Modify");
        modifyButton.setBounds(180, 150, 80, 25);
        panel.add(modifyButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(180, 150, 80, 25);
        panel.add(deleteButton);
//-------------------------------------------------------------------------------------------

        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                String firstName = firstNameText.getText();
                String lastName = lastNameText.getText();
                String takeOffCity = takeOffCityText.getText();
                String arrivalCity = arrivalCityText.getText();

                TicketInfo ticketInfo = new TicketInfo(firstName, lastName, takeOffCity, arrivalCity);
                model.addElement(ticketInfo);
                firstNameText.setText(" ");
                lastNameText.setText(" ");
                takeOffCityText.setText(" ");
                arrivalCityText.setText(" ");
                JOptionPane.showMessageDialog(null, "Inregistrarea s-a facut cu succes");
                jList.setVisible(false);
                modifyButton.setVisible(false);
                deleteButton.setVisible(false);
            }
        });

        updateButton.setVisible(false);
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                String firstName = firstNameText.getText();
                String lastName = lastNameText.getText();
                String takeOffCity = takeOffCityText.getText();
                String arrivalCity = arrivalCityText.getText();

                TicketInfo ticketInfo = new TicketInfo(firstName, lastName, takeOffCity, arrivalCity);
                model.set(jList.getSelectedIndex(), ticketInfo);
                firstNameText.setText(" ");
                lastNameText.setText(" ");
                takeOffCityText.setText(" ");
                arrivalCityText.setText(" ");
                modifyButton.setVisible(false);
                deleteButton.setVisible(false);
                JOptionPane.showMessageDialog(null, "Modificarea s-a facut cu succes");
            }
        });

        addObjectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                firstNameLabel.setVisible(true);
                lastNameLabel.setVisible(true);
                takeOffCityLabel.setVisible(true);
                arrivalCityLabel.setVisible(true);
                firstNameText.setVisible(true);
                lastNameText.setVisible(true);
                takeOffCityText.setVisible(true);
                arrivalCityText.setVisible(true);
                addButton.setVisible(true);
                jList.setVisible(false);

            }
        });

        displayButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                firstNameLabel.setVisible(false);
                lastNameLabel.setVisible(false);
                takeOffCityLabel.setVisible(false);
                arrivalCityLabel.setVisible(false);
                firstNameText.setVisible(false);
                lastNameText.setVisible(false);
                takeOffCityText.setVisible(false);
                arrivalCityText.setVisible(false);
                addButton.setVisible(false);
                jList.setVisible(true);
                modifyButton.setVisible(true);
                deleteButton.setVisible(true);
                updateButton.setVisible(false);
            }
        });

        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                List<TicketInfo> ticketInfo= new ArrayList<>();
                for(int i=0;i<model.size();i++)
                    ticketInfo.add( (TicketInfo) model.get(i));
                FileUtility.writeToFile(ticketInfo);
                System.exit(0);
            }
        });
        //---------------------------------------------------------------------------------


        modifyButton.setVisible(false);
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketInfo ticketInfo = (TicketInfo) model.get(jList.getSelectedIndex());
                firstNameLabel.setVisible(true);
                lastNameLabel.setVisible(true);
                takeOffCityLabel.setVisible(true);
                arrivalCityLabel.setVisible(true);
                firstNameText.setVisible(true);
                lastNameText.setVisible(true);
                takeOffCityText.setVisible(true);
                arrivalCityText.setVisible(true);
                addButton.setVisible(false);
                firstNameText.setText(ticketInfo.getLastName());
                lastNameText.setText(ticketInfo.getLastName());
                takeOffCityText.setText(ticketInfo.getTakeOffCity());
                arrivalCityText.setText(ticketInfo.getArrivalCity());
                updateButton.setVisible(true);
                deleteButton.setVisible(false);
                jList.setVisible(false);
            }
        });
        deleteButton.setVisible(true);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jList.getSelectedIndex() != -1)
                    model.remove(jList.getSelectedIndex());
            }
        });
    }

    private static ListCellRenderer<? super TicketInfo> createListRenderer() {
        return new DefaultListCellRenderer() {
            private Color background = new Color(0, 200, 255, 15);
            private Color defaultBackground = (Color) UIManager.get("List background");

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (c instanceof JLabel) {
                    JLabel label = (JLabel) c;
                    TicketInfo ticketInfo = (TicketInfo) value;
                    label.setText(ticketInfo.getFirstName() + " " + ticketInfo.getLastName() + " " + ticketInfo.getTakeOffCity() + " " + ticketInfo.getArrivalCity());
                    if (!isSelected) {
                        label.setBackground(index % 2 == 0 ? background : defaultBackground);
                    }
                }
                return c;
            }
        };
    }

}

//				TicketInfo ticketInfo = new TicketInfo(71, "Plan C");
//				FileUtility.writeToFile(ticketInfo);
//
//				TicketInfo ticketInfo= FileUtility.readFromFile();
//				System.out.println(ticketInfo.toString());
