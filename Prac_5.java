package com.mycompany.prac_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prac_5 extends JFrame implements ActionListener {

    JLabel title;
    JLabel nameLbl, genderLbl, dobLbl, emailLbl, phoneLbl;
    JLabel addressLbl, educationLbl, skillsLbl, summaryLbl;

    JTextField nameField, dobField, emailField, phoneField;
    JTextArea addressArea, summaryArea;

    JRadioButton male, female, other;
    ButtonGroup genderGroup;

    JCheckBox javaSkill, pythonSkill, cppSkill;

    JComboBox<String> educationBox;

    JButton submitBtn, clearBtn;

    public Prac_5() {

        setTitle("My Resume (S078)");
        setSize(600, 700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(204, 255, 204));

        title = new JLabel("My Resume (S078)");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(180, 20, 300, 30);
        add(title);

        nameLbl = new JLabel("Full Name:");
        nameLbl.setBounds(40, 80, 120, 25);
        add(nameLbl);

        nameField = new JTextField();
        nameField.setBounds(180, 80, 320, 25);
        add(nameField);

        genderLbl = new JLabel("Gender:");
        genderLbl.setBounds(40, 120, 120, 25);
        add(genderLbl);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        male.setBounds(180, 120, 70, 25);
        female.setBounds(260, 120, 80, 25);
        other.setBounds(350, 120, 80, 25);

        male.setBackground(new Color(204,255,204));
        female.setBackground(new Color(204,255,204));
        other.setBackground(new Color(204,255,204));

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        add(male);
        add(female);
        add(other);

        dobLbl = new JLabel("Date of Birth (dd/mm/yyyy):");
        dobLbl.setBounds(40,160,150,25);
        add(dobLbl);

        dobField = new JTextField();
        dobField.setBounds(180,160,320,25);
        add(dobField);

        emailLbl = new JLabel("Email:");
        emailLbl.setBounds(40,200,120,25);
        add(emailLbl);

        emailField = new JTextField();
        emailField.setBounds(180,200,320,25);
        add(emailField);

        phoneLbl = new JLabel("Phone Number:");
        phoneLbl.setBounds(40,240,120,25);
        add(phoneLbl);

        phoneField = new JTextField();
        phoneField.setBounds(180,240,320,25);
        add(phoneField);

        addressLbl = new JLabel("Address:");
        addressLbl.setBounds(40,280,120,25);
        add(addressLbl);

        addressArea = new JTextArea();
        JScrollPane sp1 = new JScrollPane(addressArea);
        sp1.setBounds(180,280,320,60);
        add(sp1);

        educationLbl = new JLabel("Education:");
        educationLbl.setBounds(40,360,120,25);
        add(educationLbl);

        String[] edu = {
                "High School",
                "Diploma",
                "Graduate",
                "Post Graduate"
        };

        educationBox = new JComboBox<>(edu);
        educationBox.setBounds(180,360,320,25);
        add(educationBox);

        skillsLbl = new JLabel("Skills:");
        skillsLbl.setBounds(40,400,120,25);
        add(skillsLbl);

        javaSkill = new JCheckBox("Java");
        pythonSkill = new JCheckBox("Python");
        cppSkill = new JCheckBox("C++");

        javaSkill.setBounds(180,400,70,25);
        pythonSkill.setBounds(260,400,80,25);
        cppSkill.setBounds(350,400,70,25);

        javaSkill.setBackground(new Color(204,255,204));
        pythonSkill.setBackground(new Color(204,255,204));
        cppSkill.setBackground(new Color(204,255,204));

        add(javaSkill);
        add(pythonSkill);
        add(cppSkill);

        summaryLbl = new JLabel("Resume Summary:");
        summaryLbl.setBounds(40,440,140,25);
        add(summaryLbl);

        summaryArea = new JTextArea();
        JScrollPane sp2 = new JScrollPane(summaryArea);
        sp2.setBounds(180,440,320,80);
        add(sp2);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(150,560,120,35);
        submitBtn.addActionListener(this);
        add(submitBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(320,560,120,35);
        clearBtn.addActionListener(this);
        add(clearBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitBtn) {

            String gender = "";

            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";
            else if (other.isSelected())
                gender = "Other";

            String skills = "";

            if (javaSkill.isSelected())
                skills += "Java ";

            if (pythonSkill.isSelected())
                skills += "Python ";

            if (cppSkill.isSelected())
                skills += "C++ ";

            String message =
                    "Resume Submitted Successfully!\n\n" +
                    "Name: " + nameField.getText() + "\n" +
                    "DOB: " + dobField.getText() + "\n" +
                    "Gender: " + gender + "\n" +
                    "Email: " + emailField.getText() + "\n" +
                    "Phone: " + phoneField.getText() + "\n" +
                    "Address: " + addressArea.getText() + "\n" +
                    "Education: " + educationBox.getSelectedItem() + "\n" +
                    "Skills: " + skills + "\n" +
                    "Summary: " + summaryArea.getText();

            JOptionPane.showMessageDialog(
                    this,
                    message,
                    "Resume Submitted",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        if (e.getSource() == clearBtn) {

            nameField.setText("");
            dobField.setText("");
            emailField.setText("");
            phoneField.setText("");
            addressArea.setText("");
            summaryArea.setText("");

            genderGroup.clearSelection();

            javaSkill.setSelected(false);
            pythonSkill.setSelected(false);
            cppSkill.setSelected(false);

            educationBox.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Prac_5();
            }
        });

    }
}