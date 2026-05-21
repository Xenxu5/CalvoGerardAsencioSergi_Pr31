package prog2.vista;

import javax.swing.*;

public class AfegirUsu extends JDialog {

    private JPanel afegusu;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JCheckBox siCheckBox;
    private JButton acceptarButton;
    private JButton cancelarButton;

    public AfegirUsu(JDialog parent){
        setContentPane(afegusu);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
    }
}
