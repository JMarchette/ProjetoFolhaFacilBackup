import java.awt.Color;
import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Eventos implements FocusListener {

    
    private String defaultText;
    private Color defaultColor;
    
    public Eventos(String defaultText, Color defaultColor) {
        this.defaultText = defaultText;
        this.defaultColor = defaultColor;
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        JTextField textField = (JTextField) e.getComponent();
        if (textField.getText().equals(defaultText)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField textField = (JTextField) e.getComponent();
        if (textField.getText().isEmpty()) {
            textField.setForeground(defaultColor);
            textField.setText(defaultText);
        }
    }
}
