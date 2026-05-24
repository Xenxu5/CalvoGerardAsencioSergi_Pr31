package prog2.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import prog2.adaptador.Adaptador;

public class AppBiblioUB extends JFrame{
    /**
     * Atributs privats de AppBiblioUb (finestra principal)
     */
    private JPanel pnlPrincipal;
    private JButton btnDades;
    private JButton btnSortir;
    private JButton btnGestions;
    // Atribut per conectar la part de l'app amb l'adaptador del programa principal.
    private final Adaptador adaptador;
    /**
     * Constructor de AppBiblioUB
     */
    public AppBiblioUB() {

        adaptador = new Adaptador();
        setTitle("Biblioteca UB");  // Títol que apareix amunt de la finestra
        setContentPane(pnlPrincipal); //Assigna el JPanel (creat al dissenyador visual) com a contingut central de la finestra
        setSize(400, 300); // Estableix la mida de la finestra
        setLocationRelativeTo(null); // Centra la finestra al mig de la pantalla en obrir-se
        setDefaultCloseOperation (EXIT_ON_CLOSE); // S'encarrega d'aturar l'execució si es tanca la finestra per la creu
        /**
         * El btnSortir tanca directament l'aplicació
         */
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /**
         * El btnGestions redirigeix a la finestra de l'apartat de gestions
         */
        btnGestions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestions ventana = new FrmGestions(AppBiblioUB.this, adaptador);
                ventana.setVisible(true);

            }
        });
        /**
         * El btnGestions redirigeix a la finestra de l'apartat de dades
         */
        btnDades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmDades ventana = new FrmDades(AppBiblioUB.this, adaptador);
                ventana.setVisible(true);
            }
        });
    }

    /**
     * Mostra la finestra principal de l'aplicació.
     */
    public void go() {
        this.setVisible(true);
    }

    /**
     * Metode que incia l'app
     * @param args
     */

    public static void main(String[] args) {
        AppBiblioUB app = new AppBiblioUB();
        app.go();
    }
}
