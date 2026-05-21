package prog2.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import prog2.adaptador.Adaptador;

public class AppBiblioUB extends JFrame{
    private JPanel panel1;
    private JButton btnDades;
    private JButton btnSortir;
    private JButton btnGestio;

    private final Adaptador adaptador;

    public AppBiblioUB() {

        adaptador = new Adaptador();
        setTitle("Biblioteca UB");
        setContentPane(panel1);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnGestio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AzGestio ventana = new AzGestio(AppBiblioUB.this, adaptador);
                ventana.setVisible(true);

            }
        });
        btnDades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AzDades ventana = new AzDades(AppBiblioUB.this, adaptador);
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
