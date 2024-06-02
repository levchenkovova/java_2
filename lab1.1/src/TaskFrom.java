import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;   //Підключаємо пакет для форматування цифр

public class TaskFrom extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton countTaskButton;
    private JPanel MainPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    public static void main(String[] args) {
        new TaskFrom();
    }

    public TaskFrom() {
        JFrame frame = new JFrame();
        frame.setTitle("Form");
        frame.setSize(350, 300);

        frame.add(MainPanel);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        frame.setVisible(true);

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
}