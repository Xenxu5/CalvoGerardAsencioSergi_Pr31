package prog2.vista;

import javax.swing.*;

public class FrmDades extends JDialog {
    private JPanel jpanel;
    public FrmDades(JFrame parent) {
        setContentPane(jpanel);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
    }

}
