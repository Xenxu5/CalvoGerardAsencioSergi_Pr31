package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestions extends JDialog {
    /**
     * Atributs privats de la finestra de gestions
     */
    private JPanel pnlGestions;
    private JButton btnUsuaris;
    private JButton btnExemplars;
    private JButton btnPrestecs;
    private JButton btnSortir;
    private final Adaptador adaptador;

    /**
     * Constructor de la finestra de gestions
     */
    public FrmGestions(JFrame parent, Adaptador adaptador) {

        this.adaptador = adaptador;
        setTitle("Gestions");
        setContentPane(pnlGestions);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        /**
         * El btnSortir tanca la finestra de dades i torna a la principal
         */
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        /**
         * El btnUsuaris obra la finestra per a les gestions d'usuaris
         */
        btnUsuaris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioUsuaris ventana = new FrmGestioUsuaris(FrmGestions.this, adaptador);
                ventana.setVisible(true);
            }
        });
        /**
         * El btnExemplar obra la finestra per a les gestions d'exemplars
         */
        btnExemplars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioExemplars ventana = new FrmGestioExemplars(FrmGestions.this, adaptador);
                ventana.setVisible(true);
            }
        });
    }

}
