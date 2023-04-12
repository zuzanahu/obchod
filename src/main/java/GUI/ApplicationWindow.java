package GUI;

import javax.swing.*;
import java.awt.*;

public class ApplicationWindow extends JFrame {
    JTextArea text;

    public ApplicationWindow() {
        super("Hlavni okno aplikace");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initGui();
    }

    private void initGui() {
   //     JPanel pnlCenterEtched = new JPanel();
     //   add(pnlCenterEtched, BorderLayout.CENTER);
       // pnlCenterEtched.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        JPanel pnlNorthTitled = new JPanel();
        add(pnlNorthTitled,BorderLayout.NORTH);
        pnlNorthTitled.setBorder(BorderFactory.createTitledBorder("Titulek"));

        JTextArea textArea = new JTextArea(40,20);
        add(new JScrollPane(text), BorderLayout.WEST);
        JPanel tlacitka = new JPanel();

        tlacitka.setLayout(new BoxLayout(tlacitka, BoxLayout.Y_AXIS));

        add(tlacitka,BorderLayout.CENTER);
        tlacitka.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        JButton btn = new JButton("+");
        btn.setPreferredSize(new Dimension(60, 40));
        tlacitka.add(btn);
        tlacitka.add(new JButton("+ ghjjjjjjjjjjjjjjjjjjjjjjjjj"));
        tlacitka.add(new JButton("-"));

        add(textArea,BorderLayout.WEST);

        textArea.add(new JButton("West"));

        setSize(640, 480);
    }

    /**
     * spousteci metoda
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ApplicationWindow().setVisible(true);
            }
        });
    }
}
