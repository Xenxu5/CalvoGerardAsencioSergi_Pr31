package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gesVisualitUsu extends JDialog {

    private JPanel visual;
    private JList listausu;
    private JButton sortir;
    private JScrollPane scroll; //si la llista comença a omplir la finestra apareix un scroll
    private Adaptador adaptador;

    public gesVisualitUsu(JDialog parent, Adaptador adaptador){

        this.adaptador = adaptador;
        setTitle("Visualitzar Usuaris");
        setContentPane(visual);
        setSize(400,700);
        setLocationRelativeTo(parent);
        setModal(true);

        visualitzarUsuaris();

        sortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void visualitzarUsuaris() {

        DefaultListModel<String> model = new DefaultListModel<>();

        int contadorEstudiants = 0;
        int contadorProfessors = 0;

        model.addElement("===== ESTUDIANTS =====");
        model.addElement("");

        for (String usuari : adaptador.recuperaUsuaris()) {

            if (usuari.contains("Estudiant")) {

                contadorEstudiants++;

                model.addElement("ESTUDIANT " + contadorEstudiants + ":");

                String[] linies = usuari.split("\n");

                for (String linia : linies) {
                    model.addElement("   " + linia);
                }
                model.addElement("----------------------");
                model.addElement("");
            }
        }

        model.addElement("===== PROFESSORS =====");
        model.addElement("");

        for (String usuari : adaptador.recuperaUsuaris()) {
            if (usuari.contains("Professor")) {

                contadorProfessors++;

                model.addElement("PROFESSOR " + contadorProfessors + ":");

                String[] linies = usuari.split("\n");

                for (String linia : linies) {
                    model.addElement("   " + linia);
                }

                model.addElement("----------------------");
                model.addElement("");
            }
        }

        listausu.setModel(model);
    }

}
