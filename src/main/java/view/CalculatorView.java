package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField2;
    private JButton adunareButton;
    private JButton scadereButton;
    private JButton impartireButton;
    private JButton inmultireButton;
    private JButton integrareButton;
    private JButton derivareButton;
    private JTextField textField4;

    public CalculatorView() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        add(panel1);
        setVisible(true);
    }

    public String getFirstPolynomial() {
        return textField1.getText();
    }

    public String getSecondPolynomial() {
        return textField2.getText();
    }

    public void setFirstPolynomial(String a) {
        textField1.setText(a);
    }

    public void setSecondPolynomial(String a) {
        textField2.setText(a);
    }

    public void setResult(String result) {
        textField3.setText(result);
    }

    public void setRemainder(String remainder) {
        textField4.setText(remainder);
    }

    public void adunareListener(ActionListener listener) {
        adunareButton.addActionListener(listener);
    }

    public void scadereListener(ActionListener listener) {
        scadereButton.addActionListener(listener);
    }

    public void inmultireListener(ActionListener listener) {
        inmultireButton.addActionListener(listener);
    }

    public void impartireListener(ActionListener listener) {
        impartireButton.addActionListener(listener);
    }

    public void derivareListener(ActionListener listener) {
        derivareButton.addActionListener(listener);
    }

    public void integrareListener(ActionListener listener) {
        integrareButton.addActionListener(listener);
    }

    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[1].getClassName());


        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new CalculatorView());
    }

}


