package prog2.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestio extends JDialog {

    private JPanel panel2;
    private JButton usuarisButton;
    private JButton exemplarsButton;
    private JButton prestecsButton;
    private JButton sortirButton;

    public FrmGestio(JFrame parent) {
        setContentPane(panel2);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        usuarisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gesUsuaris ventana = new gesUsuaris(FrmGestio.this);
                ventana.setVisible(true);
            }
        });
    }

}
