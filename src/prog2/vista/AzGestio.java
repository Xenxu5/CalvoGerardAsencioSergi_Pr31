package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AzGestio extends JDialog {

    private JPanel panel2;
    private JButton usuarisButton;
    private JButton exemplarsButton;
    private JButton prestecsButton;
    private JButton sortirButton;
    private Adaptador adaptador;

    public AzGestio(JFrame parent, Adaptador adaptador) {

        this.adaptador = adaptador;
        setTitle("Gestions");
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
                gesUsuaris ventana = new gesUsuaris(AzGestio.this, adaptador);
                ventana.setVisible(true);
            }
        });
    }

}
