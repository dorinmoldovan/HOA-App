package com.hoa_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {

    public static KeyAdapter addKeyAdapterForDigits() {
        KeyAdapter keyAdapter = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if((c < '0') && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
                if((c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        };
        return keyAdapter;
    }

    public static void addComponentsToPane(Container pane) {
        pane.setLayout(null);

        JLabel horsesLabel = new JLabel("Number of horses (N):");
        pane.add(horsesLabel);

        final JTextField horsesField = new JTextField(10);
        horsesField.addKeyListener(addKeyAdapterForDigits());
        pane.add(horsesField);

        JLabel numberOfIterationsLabel = new JLabel("Number of iterations (I):");
        pane.add(numberOfIterationsLabel);

        final JTextField iterationsField = new JTextField(10);
        iterationsField.addKeyListener(addKeyAdapterForDigits());
        pane.add(iterationsField);

        JLabel numberOfDimensionsLabel = new JLabel("Number of dimensions (D):");
        pane.add(numberOfDimensionsLabel);

        final JTextField numberOfDimensionsField = new JTextField(10);
        numberOfDimensionsField.addKeyListener(addKeyAdapterForDigits());
        pane.add(numberOfDimensionsField);

        JLabel dspLabel = new JLabel("Dominant stallions percent (DSP):");
        pane.add(dspLabel);

        final JTextField dspField = new JTextField(10);
        dspField.addKeyListener(addKeyAdapterForDigits());
        pane.add(dspField);

        JLabel sspLabel = new JLabel("Single stallions percent (SSP):");
        pane.add(sspLabel);

        final JTextField sspField = new JTextField(10);
        sspField.addKeyListener(addKeyAdapterForDigits());
        pane.add(sspField);

        JLabel hdrLabel = new JLabel("Horse distribution rate (HDR):");
        pane.add(hdrLabel);

        final JTextField hdrField = new JTextField(10);
        hdrField.addKeyListener(addKeyAdapterForDigits());
        pane.add(hdrField);

        JLabel hmpLabel = new JLabel("Horse memory pool (HMP):");
        pane.add(hmpLabel);

        final JTextField hmpField = new JTextField(10);
        hmpField.addKeyListener(addKeyAdapterForDigits());
        pane.add(hmpField);

        JLabel reorganizationFrequencyLabel = new JLabel("Reorganization frequency (M):");
        pane.add(reorganizationFrequencyLabel);

        final JTextField reorganizationFrequencyField = new JTextField(10);
        reorganizationFrequencyField.addKeyListener(addKeyAdapterForDigits());
        pane.add(reorganizationFrequencyField);

        final JLabel ofLabel = new JLabel("Objective function (OF):");
        pane.add(ofLabel);

        String[] ofs = {"", "OF 1", "OF 2", "OF 3", "OF 4", "OF 5", "OF 6", "OF 7", "OF 8", "OF 9"};
        final JComboBox ofsComboBox = new JComboBox(ofs);
        pane.add(ofsComboBox);

        final JTextArea textArea = new JTextArea(22, 48);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        pane.add(scrollPane);

        Insets insets = pane.getInsets();

        Dimension size = horsesLabel.getPreferredSize();
        horsesLabel.setBounds(25 + insets.left, 25 + insets.top,
                size.width, size.height);

        size = horsesField.getPreferredSize();
        horsesField.setBounds(250 + insets.left, 25 + insets.top,
                size.width, size.height);

        size = numberOfIterationsLabel.getPreferredSize();
        numberOfIterationsLabel.setBounds(25 + insets.left, 50 + insets.top,
                size.width, size.height);

        size = iterationsField.getPreferredSize();
        iterationsField.setBounds(250 + insets.left, 50 + insets.top,
                size.width, size.height);

        size = numberOfDimensionsLabel.getPreferredSize();
        numberOfDimensionsLabel.setBounds(25 + insets.left, 75 + insets.top,
                size.width, size.height);

        size = numberOfDimensionsField.getPreferredSize();
        numberOfDimensionsField.setBounds(250 + insets.left, 75 + insets.top,
                size.width, size.height);

        size = dspLabel.getPreferredSize();
        dspLabel.setBounds(25 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = dspField.getPreferredSize();
        dspField.setBounds(250 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = sspLabel.getPreferredSize();
        sspLabel.setBounds(25 + insets.left, 125 + insets.top,
                size.width, size.height);

        size = sspField.getPreferredSize();
        sspField.setBounds(250 + insets.left, 125 + insets.top,
                size.width, size.height);

        size = hdrLabel.getPreferredSize();
        hdrLabel.setBounds(25 + insets.left, 150 + insets.top,
                size.width, size.height);

        size = hdrField.getPreferredSize();
        hdrField.setBounds(250 + insets.left, 150 + insets.top,
                size.width, size.height);

        size = hmpLabel.getPreferredSize();
        hmpLabel.setBounds(25 + insets.left, 175 + insets.top,
                size.width, size.height);

        size = hmpField.getPreferredSize();
        hmpField.setBounds(250 + insets.left, 175 + insets.top,
                size.width, size.height);

        size = reorganizationFrequencyLabel.getPreferredSize();
        reorganizationFrequencyLabel.setBounds(25 + insets.left, 200 + insets.top,
                size.width, size.height);

        size = reorganizationFrequencyField.getPreferredSize();
        reorganizationFrequencyField.setBounds(250 + insets.left, 200 + insets.top,
                size.width, size.height);

        size = ofLabel.getPreferredSize();
        ofLabel.setBounds(25 + insets.left, 225 + insets.top,
                size.width, size.height);

        size = ofsComboBox.getPreferredSize();
        ofsComboBox.setBounds(250 + insets.left, 225 + insets.top,
                size.width, size.height);

        size = scrollPane.getPreferredSize();
        scrollPane.setBounds(420 + insets.left, 25 + insets.top,
                size.width, size.height);

        JButton simulationButton = new JButton("Start Simulation");
        pane.add(simulationButton);
        simulationButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int N = Integer.parseInt(horsesField.getText());
                int I = Integer.parseInt(iterationsField.getText());
                int D = Integer.parseInt(numberOfDimensionsField.getText());
                int DSP = Integer.parseInt(dspField.getText());
                int SSP = Integer.parseInt(sspField.getText());
                int HDR = Integer.parseInt(hdrField.getText());
                int HMP = Integer.parseInt(hmpField.getText());
                int M = Integer.parseInt(reorganizationFrequencyField.getText());
                String OF = (String) ofsComboBox.getSelectedItem();

                textArea.setText(null);

                textArea.append("  ------------------------------------------------------------\n");
                textArea.append("  NEW SIMULATION\n");
                textArea.append("  ------------------------------------------------------------\n");

                textArea.append("  Number of horses (N) = " + N + "\n");
                textArea.append("  Number of iterations (I) = " + I + "\n");
                textArea.append("  Number of dimensions (D) = " + D + "\n");
                textArea.append("  Dominant stallions percent (DSP) = " + DSP + "\n");
                textArea.append("  Single stallions percent (SSP) = " + SSP + "\n");
                textArea.append("  Horse distribution rate (HDR) = " + HDR + "\n");
                textArea.append("  Horse memory pool (HMP) = " + HMP + "\n");
                textArea.append("  Reorganization frequency (M) = " + M + "\n");
                textArea.append("  Objective function (OF) = " + OF + "\n");
            }
        });

        size = simulationButton.getPreferredSize();
        simulationButton.setBounds(25 + insets.left, 400 + insets.top,
                size.width + 215, size.height + 10);
    }

    public static void main(String args[]){
        JFrame frame = new JFrame("HOA App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        addComponentsToPane(frame.getContentPane());
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
