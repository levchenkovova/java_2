import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;   //Підключаємо пакет для форматування цифр

public class GeoForm extends JFrame {

    private JPanel mainPanel;
    private JLabel pointA;
    private JTextField textfieldAlong;
    private JTextField textFieldlan;
    private JLabel pointB;
    private JTextField textFieldBlong;
    private JTextField textFieldBlan;
    private JButton buttonClear;
    private JButton buttonSolve;
    private JLabel result;
    private JTextField textResult;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton countTaskButton;

    public static void main(String[] args) {
        new GeoForm();                                  //викликаємо нашу форму
    }

    public GeoForm() {
        JFrame frame = new JFrame();
        frame.setTitle("Form");
        frame.setSize(350, 300);

        frame.add(mainPanel);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        frame.setVisible(true);

        buttonSolve.addActionListener(new ActionListener() {      //додаємо обробник подій клавіші Solve
            @Override                                             //Переоприділяємо метод
            public void actionPerformed(ActionEvent e) {
                calculateD();
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfieldAlong.setText("");
                textFieldlan.setText("");
                textFieldBlong.setText("");
                textFieldBlan.setText("");
                textResult.setText("");
            }
        });
        countTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer firstValue = Integer.parseInt(textField1.getText());
                Integer secondValue = Integer.parseInt(textField2.getText());
                Integer sum = firstValue + secondValue;
                textField3.setText(sum.toString());
            }
        });
    }

    private double laInRad(double lat) {         //Превід широти із градусів в радіани
        double pi = Math.PI;
        return lat * (pi / 180);
    }

    private double deltaLanRad(double lan1, double lan2) {           //розраховуємо різницю довготи в радіанах
        double pi = Math.PI;
        return (lan2 - lan1) * (pi / 180);
    }

    private void calculateD()
    {
        double Along = Double.parseDouble(textfieldAlong.getText());
        double Alan = Double.parseDouble(textFieldlan.getText());
        double Blong = Double.parseDouble(textFieldBlong.getText());
        double Blan = Double.parseDouble(textFieldBlan.getText());
        double R = 6371;
        double D = R * Math.acos((Math.sin(laInRad(Along)) * Math.sin(laInRad(Blong))) + (Math.cos(laInRad(Along)) * Math.cos(laInRad(Blong)) * Math.cos(deltaLanRad(Alan, Blan))));
        DecimalFormat f = new DecimalFormat("##.00");           //форматуємо число до двох знаків після коми
        String roundedD=f.format(D);
        textResult.setText(roundedD);
    }
}