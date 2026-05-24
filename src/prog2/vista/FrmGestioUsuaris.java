package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioUsuaris extends JDialog {
    /**
     * Atributs privats de la finestra de gestio d'usuaris
     */
    private JPanel pnlGestioUsuaris;
    private JButton btnAfegirUsuari;
    private JButton btnVisualitzarUsuaris;
    private JButton btnSortir;
    private final Adaptador adaptador;

    /**
     * Constructor de la finestra de gestio d'usuaris
     */
    public FrmGestioUsuaris(JDialog parent, Adaptador adaptador) {
        this.adaptador =adaptador;
        setTitle("Usuaris");
        setContentPane(pnlGestioUsuaris);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        /**
         * El btnSortir tanca la finestra de dades i torna a la finestra de gestions
         */
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        /**
         * El btnAfegirUsuari obra la finestra per afegir un usuari
         */
        btnAfegirUsuari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirUsuari ventana = new FrmAfegirUsuari(FrmGestioUsuaris.this, adaptador);
                ventana.setVisible(true);
            }
        });
        /**
         * El btnVisualitzarUsuaris obra la finestra per visualitzar els usuaris registrats
         */
        btnVisualitzarUsuaris.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVisualitzarUsuaris ventana = new FrmVisualitzarUsuaris(FrmGestioUsuaris.this, adaptador);
                ventana.setVisible(true);
            }
        });
    }
}
