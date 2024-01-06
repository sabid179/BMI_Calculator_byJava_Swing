import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI_Frame extends JFrame {
    UI_Frame() {
        this.setTitle("BMI Calculator");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);

        cnt = this.getContentPane();
        cnt.setLayout(null);
        cnt.setBackground(new Color(255, 255, 255));
    }
    public void launch() {
        JLabel weightLabel = new JLabel();
        weightLabel.setText("Enter weight(KG): ");
        weightLabel.setLocation(20, 30);
        weightLabel.setSize(210, 40);
        weightLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
        cnt.add(weightLabel);

        weight = new JTextField();
        weight.setLocation(230, 30);
        weight.setSize(140, 40);
        weight.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        weight.setHorizontalAlignment(SwingConstants.CENTER);
        cnt.add(weight);

        JLabel heightLabel = new JLabel();
        heightLabel.setText("Enter height(M): ");
        heightLabel.setLocation(20, 100);
        heightLabel.setSize(210, 40);
        heightLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
        cnt.add(heightLabel);

        height = new JTextField();
        height.setLocation(230, 100);
        height.setSize(140, 40);
        height.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        height.setHorizontalAlignment(SwingConstants.CENTER);
        cnt.add(height);

        generate = new JButton();
        generate.setText("Generate BMI");
        generate.setLocation(100, 180);
        generate.setSize(187, 40);
        generate.setFont(new Font(Font.MONOSPACED, Font.BOLD + Font.ITALIC, 19));
        generate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cnt.add(generate);

        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == generate) {
                    try {
                        double t_weight = Double.parseDouble(weight.getText());
                        double t_height = Double.parseDouble(height.getText());
                        if (t_height == 0) throw new ArithmeticException();
                        double bmi = t_weight / (Math.pow(t_height, 2));
                        JOptionPane.showMessageDialog(null, "BMI is    " + bmi,
                                "BMI", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Error Casting to Double!",
                                "Exception caught", JOptionPane.WARNING_MESSAGE);
                    } catch (ArithmeticException ame) {
                        JOptionPane.showMessageDialog(null, "Height Cannot be ZERO!",
                                "Exception caught", JOptionPane.WARNING_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Unknown Exception Occurred!",
                                "Exception caught", JOptionPane.WARNING_MESSAGE);
                    }
                    weight.setText("");
                    height.setText("");
                }
            }
        });
    }
    private final Container cnt;
    private JTextField weight, height;
    private JButton generate;
}
