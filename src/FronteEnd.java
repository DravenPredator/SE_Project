import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class FronteEnd {

    private JFrame frmDdeCharacter;
    private JTextField txtPlayerName;
    private JTextField txtCharName;
    private JLabel lblRace;
    private JLabel lblClass;
    private JComboBox comBoxClass;
    private JComboBox comboLevel;
    private JComboBox comBoxRace;
    private JComboBox comboDex;
    private JComboBox comboStr;
    private JComboBox comboInt;
    private JComboBox comboCon;
    private JComboBox comboWis;
    private JComboBox comboCha;
    private JLabel lblLvl;

    private Character character = new Character();

    private int charStr = 10;
    private int charDex = 10;
    private int charCon = 10;
    private int charInt = 10;
    private int charWis = 10;
    private int charCha = 10;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FronteEnd window = new FronteEnd();
                    window.frmDdeCharacter.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public FronteEnd() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmDdeCharacter = new JFrame();
        frmDdeCharacter.setTitle("D&D 5e Character Manager");
        frmDdeCharacter.setBounds(100, 100, 450, 530);
        frmDdeCharacter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPlayerName = new JLabel("Player Name: ");

        txtPlayerName = new JTextField();
        lblPlayerName.setLabelFor(txtPlayerName);
        txtPlayerName.setColumns(10);

        JLabel lblCharacterName = new JLabel("Character Name: ");

        txtCharName = new JTextField();
        lblCharacterName.setLabelFor(txtCharName);
        txtCharName.setColumns(10);

        lblRace = new JLabel("Race: ");

        comBoxRace = new JComboBox();
        lblRace.setLabelFor(comBoxRace);
        comBoxRace.setModel(new DefaultComboBoxModel(new String[]{"Select Race", "Dwarf", "Elf", "Halfling", "Human", "Dragonborn", "Gnome", "Half-Elf", "Half-Orc", "Tiefling"}));

        lblClass = new JLabel("Class: ");

        comBoxClass = new JComboBox();
        lblClass.setLabelFor(comBoxClass);
        comBoxClass.setModel(new DefaultComboBoxModel(new String[]{"Select Class", "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"}));

        lblLvl = new JLabel("Level: ");

        JButton btnExportExistingCharacter = new JButton("Export Existing Character");
        btnExportExistingCharacter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ExportCharacter cDialog = new ExportCharacter();
                cDialog.setVisible(true);
            }
        });

        JButton btnSubmitCharacter = new JButton("Submit Character");
        btnSubmitCharacter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                character.setcName(txtCharName.getText());
                character.setpName(txtPlayerName.getText());
                character.setRace(comBoxRace.getSelectedItem().toString());
                character.setcClass(comBoxClass.getSelectedItem().toString());
                character.setLvl(comboLevel.getSelectedItem().toString());
                character.setStr(Integer.parseInt(comboStr.getSelectedItem().toString()));
                character.setDex(Integer.parseInt(comboDex.getSelectedItem().toString()));
                character.setCon(Integer.parseInt(comboCon.getSelectedItem().toString()));
                character.setInte(Integer.parseInt(comboInt.getSelectedItem().toString()));
                character.setWis(Integer.parseInt(comboWis.getSelectedItem().toString()));
                character.setCha(Integer.parseInt(comboCha.getSelectedItem().toString()));

                CharacterDAO cDAO = new CharacterDAO(character);


                cDAO.writeCharacterToDatabase();
                System.out.println("Character ID: " + cDAO.getID());
                try {
                    cDAO.exportToFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        comboLevel = new JComboBox();
        lblLvl.setLabelFor(comboLevel);
        comboLevel.setModel(new DefaultComboBoxModel(new String[]{"Select Level", "1", "2", "3", "4", "5"}));

        JLabel lblStr = new JLabel("Strength: ");

        JLabel lblDex = new JLabel("Dexterity: ");

        JLabel lblInt = new JLabel("Intelligence: ");

        JLabel lblCon = new JLabel("Consitution:");

        JLabel lblWis = new JLabel("Wisdom: ");

        comboStr = new JComboBox();
        lblStr.setLabelFor(comboStr);
        comboStr.setModel(new DefaultComboBoxModel(new String[]{"Select Strength Number", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"}));

        JLabel lblCha = new JLabel("Charisma: ");

        comboDex = new JComboBox();
        lblDex.setLabelFor(comboDex);
        comboDex.setModel(new DefaultComboBoxModel(new String[]{"Select Dexterity Number", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"}));

        comboCon = new JComboBox();
        lblCon.setLabelFor(comboCon);
        comboCon.setModel(new DefaultComboBoxModel(new String[]{"Select Consitution Number", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"}));

        comboInt = new JComboBox();
        lblInt.setLabelFor(comboInt);
        comboInt.setModel(new DefaultComboBoxModel(new String[]{"Select Intelligence Number", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"}));

        comboWis = new JComboBox();
        lblWis.setLabelFor(comboWis);
        comboWis.setModel(new DefaultComboBoxModel(new String[]{"Select Wisdom Number", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"}));

        comboCha = new JComboBox();
        lblCha.setLabelFor(comboCha);
        comboCha.setModel(new DefaultComboBoxModel(new String[]{"Select Charisma Number", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"}));
        GroupLayout groupLayout = new GroupLayout(frmDdeCharacter.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(lblDex)
                                                .addContainerGap(372, Short.MAX_VALUE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(lblInt)
                                                .addContainerGap(362, Short.MAX_VALUE))
                                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                                .addComponent(lblCha)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(comboCha, 0, 318, Short.MAX_VALUE))
                                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                                .addComponent(lblPlayerName)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(txtPlayerName, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                                .addComponent(lblCharacterName)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(txtCharName, 224, 224, 224))
                                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                                .addComponent(lblLvl)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(comboLevel, 0, 337, Short.MAX_VALUE))
                                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                                .addComponent(lblClass)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(comBoxClass, 0, 337, Short.MAX_VALUE))
                                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                                .addComponent(lblRace)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(comBoxRace, 0, 338, Short.MAX_VALUE))
                                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                                .addComponent(lblStr)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(comboDex, 0, 320, Short.MAX_VALUE)
                                                                        .addComponent(comboStr, 0, 320, Short.MAX_VALUE)))
                                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                                .addComponent(lblCon)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(comboInt, 0, 311, Short.MAX_VALUE)
                                                                        .addComponent(comboCon, 0, 311, Short.MAX_VALUE)))
                                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                                .addComponent(lblWis)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(comboWis, 0, 325, Short.MAX_VALUE)))
                                                .addGap(51))))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(30)
                                .addComponent(btnExportExistingCharacter)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnSubmitCharacter)
                                .addContainerGap(128, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap(11, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblPlayerName)
                                        .addComponent(txtPlayerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblCharacterName)
                                        .addComponent(txtCharName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblRace)
                                        .addComponent(comBoxRace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblClass)
                                        .addComponent(comBoxClass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblLvl)
                                        .addComponent(comboLevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblStr)
                                        .addComponent(comboStr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblDex)
                                        .addComponent(comboDex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblCon)
                                        .addComponent(comboCon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblInt)
                                        .addComponent(comboInt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblWis)
                                        .addComponent(comboWis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblCha)
                                        .addComponent(comboCha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(36)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnExportExistingCharacter)
                                        .addComponent(btnSubmitCharacter))
                                .addGap(87))
        );
        frmDdeCharacter.getContentPane().setLayout(groupLayout);
    }
}
