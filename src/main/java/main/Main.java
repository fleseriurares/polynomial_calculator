package main;

import controller.CalculatorController;
import view.CalculatorView;

import javax.swing.*;

public class Main { 
    public static void main(String[] args) {

                try {
                    UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[1].getClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                SwingUtilities.invokeLater(() -> {
                    CalculatorView view = new CalculatorView();
                    CalculatorController controller = new CalculatorController(view);
                    view.setVisible(true);
                });
            }
        }



