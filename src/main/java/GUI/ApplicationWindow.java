package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import org.example.ObchodImpl;
import org.example.Kosik;
import org.example.Polozka;
import org.example.Zbozi;

public class ApplicationWindow extends JFrame {
    JTextArea text;

    public ApplicationWindow() {
        super("Hlavni okno aplikace");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGui();
        initModel();
        lstKosik.setListData(kosik.asStringArray());
        lstNabidka.setListData(obchod.nabidkaAsStringArray());
    }

    private void initModel() {
        this.obchod = new ObchodImpl(new ArrayList<Zbozi>(), "Beda Travnicek");

        this.kosik = new Kosik();


    }

    private void initGui() {
//        pnlCenterEtched.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        setLayout(new GridLayout(2,2));
//        JLabel jLabObchod = new JLabel("Offline obchod KupSiCoChces",SwingConstants.LEADING);

        pEditor = new JPanel();
        pEditor.setLayout(new GridLayout(0,2));
        pEditor.setBorder(BorderFactory.createTitledBorder("Editor Zbozi"));

        labNazev = new JLabel("Nazev");
        pEditor.add(labNazev);
        tfNazev = new JTextField("",8);
        pEditor.add(tfNazev);
        labMnozstvi = new JLabel("Jednotkove mnozstvi");
        pEditor.add(labMnozstvi);
        tfMnozstvi = new JTextField("",8);
        pEditor.add(tfMnozstvi);
        labCena = new JLabel("Jednotkova cena");
        pEditor.add(labCena);
        tfCena = new JTextField("",8);
        pEditor.add(tfCena);
        labBaleni = new JLabel("Počet kusů v balení: ");
        pEditor.add(labBaleni);
        tfBaleni = new JTextField("",8);
        pEditor.add(tfBaleni);

        labJednotka = new JLabel("Jednotka");
        pEditor.add(labJednotka);

        cbJednotka = new JComboBox();
        cbJednotka.setModel(new DefaultComboBoxModel<>(new String[] { "g", "ks", "kg", "l" }));
        pEditor.add(cbJednotka);
        btPridatZbozi = new JButton("Pridat zbozi");
        pEditor.add(btPridatZbozi);
        pEditor.setPreferredSize(new Dimension(80,60));
        add(pEditor);

        pKosik = new JPanel();
        pKosik.setLayout(new BorderLayout());
        labKosik = new JLabel("Nakupni kosik");
        pKosik.add(labKosik,BorderLayout.NORTH);

        pNabidka = new JPanel();
        pNabidka.setLayout(new BorderLayout());
        labNabidka = new JLabel("Nabidka obchodu");
        pNabidka.add(labNabidka,BorderLayout.NORTH);

        lstNabidka = new JList();
        scNabidka = new JScrollPane(lstNabidka);
        scNabidka.setSize(60,60);
        pNabidka.add(scNabidka,BorderLayout.CENTER);

        pTlacitkaNabidka = new JPanel(new GridLayout(0,1));
        pTlacitkaNabidka.setSize(new Dimension(40, 60));
        btNacist = new JButton("Nacist");
        pTlacitkaNabidka.add(btNacist);
        btUlozit = new JButton("Ulozit");
        pTlacitkaNabidka.add(btUlozit);
        btVymazat = new JButton("Vyprazdni");
        pTlacitkaNabidka.add(btVymazat);
        btOdstran = new JButton("Odstran polozku");
        pTlacitkaNabidka.add(btOdstran);
        pNabidka.add(pTlacitkaNabidka,BorderLayout.EAST);
        add(pNabidka);

        lstKosik = new JList();
        scKosik = new JScrollPane(lstKosik);
        scKosik.setSize(60,60);
        pKosik.add(scKosik,BorderLayout.CENTER);

        pTlacitkaKosik = new JPanel(new GridLayout(0,1));
        pTlacitkaKosik.setSize(new Dimension(40, 60));
        btKoupit = new JButton("Koupit");
        pTlacitkaKosik.add(btKoupit);
        btBaleni = new JButton("Koupit celé balení");
        pTlacitkaKosik.add(btBaleni);
        btPlus = new JButton("+");
        pTlacitkaKosik.add(btPlus);
        btMinus = new JButton("-");
        pTlacitkaKosik.add(btMinus);
        btVyprazdni = new JButton("Vyprazdni");
        pTlacitkaKosik.add(btVyprazdni);
        pKosik.add(pTlacitkaKosik,BorderLayout.EAST);

        btTiskni = new JButton("Tiskni uctenku");
        pKosik.add(btTiskni,BorderLayout.SOUTH);
        add(pKosik);

//        pText = new JPanel();
//        pText.setBorder(BorderFactory.createTitledBorder("Vystupni okno"));
        vystup = new JTextArea(50,80);
//        vystup.setColumns(20);
//        vystup.setRows(5);
        scText = new JScrollPane(vystup);
        scText.setBorder(BorderFactory.createTitledBorder("Vystupni okno"));
        scText.setViewportView(vystup);
//        scText.setSize(80,60);
        add(scText);

        setSize(640, 480);

        btKoupit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKoupitActionPerformed();
            }
        });
        btPridatZbozi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPridatZboziActionPerformed(evt);
            }
        });
        btNacist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNacistNabidkuActionPerformed(evt);
            }
        });
        btVymazat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVyprazdniNabidkuActionPerformed(evt);
            }
        });
        btMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMinusActionPerformed(evt);
            }
        });

        btPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlusActionPerformed();
            }
        });
        btBaleni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBaleniActionPerformed(evt);}

        });
        btTiskni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTisknoutUctenkuActionPerformed(evt);
            }
        });

    }

    private Polozka zajistiPolozku (Zbozi selectedZbozi) {
            int indexPolozkyVKosiku = kosik.indexPolozky(selectedZbozi);

            if (indexPolozkyVKosiku == -1)
            {
                Polozka novaPolozka = kosik.pridejPolozku(selectedZbozi, 0);
                vystup.setText("Zboží přidáno do košíku");

                return novaPolozka;
            }

            return kosik.getPolozka(indexPolozkyVKosiku);
    }

    /**
     * Analyzuje lstKosik a lstNabidka. Pokud jeden z nich ma vybranou polozku tak vrazi informaci o danem zbozi
     */
    private Zbozi getSelectedZbozi () throws Exception {
        int k = lstKosik.getSelectedIndex(); // dostane index toho zbozi, ktere je označené uživatelem
        int n = lstNabidka.getSelectedIndex();

        if (k >= 0 && k < kosik.size()) {
            return kosik.getPolozka(k).getZbozi();
        } else if (n >= 0 && n < obchod.getNabidka().size()) {
            return obchod.getNabidka().get(n);
        }

        throw new Exception("Není vybrána žádná položka.");
    }

    private void zvysMnozstvi(Zbozi vybraneZbozi, int pocet) {
        zajistiPolozku(vybraneZbozi);

        kosik.zvysMnozstvi(kosik.indexPolozky(vybraneZbozi), pocet);

        lstKosik.setListData(kosik.asStringArray()); //prepisu items v kosiku na novy items s novym mnozstvim

        zachovejVyber();
    }

    private void zachovejVyber () {
        int k = lstKosik.getSelectedIndex(); // dostane index toho zbozi, ktere je označené uživatelem
        int n = lstNabidka.getSelectedIndex();
        lstKosik.setSelectedIndex(k);
        lstNabidka.setSelectedIndex(n);
    }

    private void btBaleniActionPerformed(ActionEvent evt) {
        try {
            Zbozi vybraneZbozi = this.getSelectedZbozi();
            Polozka polozka = zajistiPolozku(vybraneZbozi);

            zvysMnozstvi(vybraneZbozi, polozka.getZbozi().getBaleni());
        } catch (Exception error) {
            vystup.setText(error.getMessage() + "\n");
        }
    }
    private void btKoupitActionPerformed() {
        try {
            Zbozi vybraneZbozi = this.getSelectedZbozi();

            zvysMnozstvi(vybraneZbozi, 1);
        } catch (Exception error) {
            vystup.setText(error.getMessage() + "\n");
        }
    }

    private void btPlusActionPerformed() {
        this.btKoupitActionPerformed();
    }
    private void btMinusActionPerformed(ActionEvent evt) {
        int index = lstKosik.getSelectedIndex();
        try
        {
            int size = lstKosik.getModel().getSize();
            kosik.snizMnozstvi(index);
            lstKosik.setListData(kosik.asStringArray());
            if (lstKosik.getModel().getSize() == size)
                lstKosik.setSelectedIndex(index);
            vystup.setText("Zboží odebráno z košíku");
        }
        catch(IndexOutOfBoundsException e)
        {
            vystup.setText("V košíku není vybrána žádná položka.\n");
        }
    }



    private void btTisknoutUctenkuActionPerformed(java.awt.event.ActionEvent evt) {
        vystup.setText(obchod.sestavUctenku(kosik));
    }
    private void btVyprazdniNabidkuActionPerformed(java.awt.event.ActionEvent evt) {
        obchod.vymazNabidku();
        lstNabidka.setModel(new DefaultListModel()); //co je tohle??? huh
        vystup.setText("Nabídka obchodu vymazána.\n");
    }
    private void btPridatZboziActionPerformed(java.awt.event.ActionEvent evt) {
        String nazev = tfNazev.getText();
        int jednotkoveMnozstvi = Integer.parseInt(tfMnozstvi.getText());
        double jednotkovaCena = Double.parseDouble(tfCena.getText());
        String jednotka = (String) cbJednotka.getSelectedItem();
        int baleni = Integer.parseInt(tfBaleni.getText());

        obchod.pridejZbozi(new Zbozi(nazev, jednotka,  jednotkoveMnozstvi, jednotkovaCena, baleni));
        lstNabidka.setListData(obchod.nabidkaAsStringArray());
        vystup.setText("Zboží přidáno do nabídky.");
    }

    private void btNacistNabidkuActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fch = new JFileChooser();
        fch.setCurrentDirectory(new File(System.getProperty("user.dir")));
        if (fch.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            boolean commence = true;

            if (lstNabidka.getModel().getSize() > 0)
            {
                int response = JOptionPane.showConfirmDialog(this, "Aktuální seznam zboží není prázdný, pokračovat s načítáním?", "Načíst seznam zboží", JOptionPane.YES_NO_CANCEL_OPTION);
                if (response != JOptionPane.YES_OPTION)
                    commence = false;
            }
            if (commence)
                obchod.nactiNabidku(String.valueOf(fch.getSelectedFile()));
        }
        lstNabidka.setListData(obchod.nabidkaAsStringArray());
        vystup.setText("");
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
    private ObchodImpl obchod;
    private Kosik kosik;

    private JPanel pEditor, pKosik, pNabidka, pTlacitkaNabidka, pTlacitkaKosik, pText;
    private JScrollPane scNabidka, scKosik, scText;
    private JList lstNabidka, lstKosik;
    private JComboBox cbJednotka;
    private JLabel labNazev, labCena, labMnozstvi, labJednotka, labKosik, labNabidka, labBaleni;
    private JTextArea vystup;
    private JTextField tfNazev, tfMnozstvi, tfCena, tfBaleni;
    private JButton btKoupit, btPridatZbozi, btNacist, btUlozit, btVymazat, btOdstran, btPlus, btMinus, btVyprazdni, btTiskni, btBaleni;
}
