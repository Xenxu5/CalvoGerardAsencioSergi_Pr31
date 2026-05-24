package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmAfegirExemplar extends JDialog {
    /**
     * Atributs privats de la finestra d'afegir exemplars
     */
    private JPanel pnlAfegirExemplar;
    private JCheckBox chkPrestecLlarg;
    private JTextField txtTitol;
    private JTextField txtAutor;
    private JTextField txtId;
    private JButton btnAcceptar;
    private JButton btnCancelar;
    private final Adaptador adaptador;

    /**
     * Constructor de la finestra d'afegir exemplars
     */
    public FrmAfegirExemplar (JDialog parent, Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Afegir exemplar");
        setContentPane(pnlAfegirExemplar);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        btnCancelar.addActionListener(new ActionListener() {
            /**
             * Surt de la finestra actual i torna a la gestió d'exemplars
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        btnAcceptar.addActionListener(new ActionListener() {
            /**
             * Guarda i afegeix la informació dels exemplars.
             * Llença error si no s'omplen tots els camps.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String titol = txtTitol.getText();
                String autor = txtAutor.getText();
                String id = txtId.getText();
                boolean esLlarg = chkPrestecLlarg.isSelected();

                if (titol.isEmpty() || autor.isEmpty() || id.isEmpty()) {
                    JOptionPane.showMessageDialog(FrmAfegirExemplar.this,
                            "Tots els camps són obligatoris");
                    return;
                }
                try {
                    adaptador.afegirExemplar(id, titol, autor, esLlarg);

                    JOptionPane.showMessageDialog(FrmAfegirExemplar.this,
                            "Exemplar afegit correctament"
                    );
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(FrmAfegirExemplar.this, ex.getMessage()
                    );
                }
            }
        });
    }
}
