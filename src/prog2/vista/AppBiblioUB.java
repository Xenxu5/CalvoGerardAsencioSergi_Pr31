package prog2.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import prog2.adaptador.Adaptador;

public class AppBiblioUB extends JFrame{
    private JPanel pnlPrincipal;
    private JButton btnDades;
    private JButton btnSortir;
    private JButton btnGestions;

    private final Adaptador adaptador;

    public AppBiblioUB() {

        adaptador = new Adaptador();
        setTitle("Biblioteca UB");
        setContentPane(pnlPrincipal);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnGestions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestions ventana = new FrmGestions(AppBiblioUB.this, adaptador);
                ventana.setVisible(true);

            }
        });
        btnDades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmDades ventana = new FrmDades(AppBiblioUB.this, adaptador);
                ventana.setVisible(true);
            }
        });
    }
    public void go() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        AppBiblioUB app = new AppBiblioUB();
        app.go();
    }
}
