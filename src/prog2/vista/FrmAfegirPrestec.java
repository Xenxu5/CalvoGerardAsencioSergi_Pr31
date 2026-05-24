package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmAfegirPrestec extends JDialog {
    private JPanel pnlAfegirPrestec;
    private JCheckBox chkPrestecLlarg;
    private JComboBox cmbUsuari;
    private JComboBox cmbExemplar;
    private JButton btnAcceptar;
    private JButton btnCancelar;
    private final Adaptador adaptador;

    public FrmAfegirPrestec(JDialog parent, Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Afegir Préstec");
        setContentPane(pnlAfegirPrestec);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);

        // Afegim usuaris i exemplars (he hagut d'adaptar el format visual)
        // Carreguem tots els usuaris al desplegable: Nombre + (Email)
        for (String usuariComplet : adaptador.recuperaUsuaris()) {
            String[] liniesUsuari = usuariComplet.split("\n"); // Formem un array d'Strings
            if (liniesUsuari.length > 2) { // Evitem possibles errors amb usuaris incomplets (tot i que això no hauria de ser possible en el nostre programa)
                // Agafem el nom i l'email
                String nom = liniesUsuari[1].replace("Nom: ", "").trim(); // Només volem que es vegin els valors
                String email = liniesUsuari[2].replace("Email: ", "").trim();

                // Si l'email és molt llarg, establim un màxim (25)
                if (email.length() > 25) {
                    email = email.substring(0, 22) + "..."; // Ex: "gcalvito@correomuylarg..."
                }

                // L'afegim al cmb
                cmbUsuari.addItem(nom + " (" + email + ")");
            } else {  // Si pel que sigui un usuari està incomplet (mai hauria d'entrar a aquest else, ja que no deixem acceptar amb camps buits)
                cmbUsuari.addItem("Usuari Desconegut");
            }
        }

        // Carreguem exemplars: [ID] + Títul
        for (String exemplarComplet : adaptador.recuperaExemplars()) {
            String[] liniesExemplar = exemplarComplet.split("\n");
            if (liniesExemplar.length > 1) {
                // Agafem l'id i el títol
                String id = liniesExemplar[0].replace("Id: ", "").trim();
                String titol = liniesExemplar[1].replace("Títol: ", "").trim();

                // Màxima longitut 25
                if (titol.length() > 25) {
                    titol = titol.substring(0, 22) + "...";
                }

                // L'afegim al cmb
                cmbExemplar.addItem("[" + id + "] " + titol);
            } else {
                cmbExemplar.addItem("Exemplar Desconegut");
            }
        }

        btnCancelar.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        btnAcceptar.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agafem les posicions seleccionades en els cmb
                int usuariPos = cmbUsuari.getSelectedIndex();
                int exemplarPos = cmbExemplar.getSelectedIndex();

                // Comprovem el chk
                boolean esLlarg = chkPrestecLlarg.isSelected();

                // Si l'índex és -1, no ha seleccionat res o no hi ha res a seleccionar
                if (usuariPos == -1 || exemplarPos == -1) {
                    JOptionPane.showMessageDialog(FrmAfegirPrestec.this,
                            "Has de seleccionar un usuari i un exemplar.",
                            "Camps incomplets",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {

                    adaptador.afegirPrestec(exemplarPos, usuariPos, esLlarg);

                    // Si arriba aquí, vol dir que ha passat totes les validacions
                    JOptionPane.showMessageDialog(FrmAfegirPrestec.this,
                            "Préstec afegit correctament"
                    );
                    dispose();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(FrmAfegirPrestec.this,
                            ex.getMessage(),
                            "Error en el Préstec",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }
}
