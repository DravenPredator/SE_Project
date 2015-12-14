import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Draven on 12/11/2015.
 */
public class Character {
    private String cName;
    private String pName;
    private String race;
    private String cClass;
    private String lvl;
    private Integer str;
    private Integer con;
    private Integer dex;
    private Integer wis;
    private Integer cha;
    private Integer inte;
    private Integer classID;
    private Integer raceID;
    private ArrayList inventoryID;
    private ArrayList spellBookID;
    private Integer abilityScoreID;

    public Character() {
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    public void setInte(int inte) {
        this.inte = inte;
    }

    public void setClassID(Integer classID) {
        this.classID = classID;
    }

    public void setRaceID(Integer raceID) {
        this.raceID = raceID;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public void setInventoryID(String inventoryID, ArrayList inventoryID_2) {
        if (inventoryID == null && inventoryID_2 == null)
            this.inventoryID = null;
        else {
            if (inventoryID_2 != null) {
                this.inventoryID = inventoryID_2;
            } else {
                String[] inventory = inventoryID.split(",");
                ArrayList inventoryID_3 = new ArrayList(2);

                for (int x = 0; x < inventory.length; x++) {
                    inventoryID_3.add(inventory[x]);
                }

                this.inventoryID = inventoryID_3;
            }
        }

    }

    public void setSpellBookID(String spellBookID, ArrayList spellBookID_2) {
        if (spellBookID == null && spellBookID_2 == null)
            this.spellBookID = null;
        else if (spellBookID_2 != null)
            this.spellBookID = spellBookID_2;
        else {
            String[] spellBook = spellBookID.split(",");
            ArrayList spellBook_2 = new ArrayList(2);

            for (int x = 0; x < spellBook.length; x++) {
                spellBook_2.add(spellBook[x]);
            }

            this.spellBookID = spellBook_2;
        }
    }

    public void setAbilityScoreID(Integer abilityScoreID) {
        this.abilityScoreID = abilityScoreID;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setcClass(String cClass) {
        this.cClass = cClass;
    }

    public String getcClass() {
        return cClass;
    }

    public String getRace() {
        return race;
    }

    public String getCName() {
        return cName;
    }

    public String getPName()
    {
        return pName;
    }

    public int getStr()
    {
        return str;
    }

    public int getCon()
    {
        return con;
    }

    public int getDex()
    {
        return dex;
    }

    public int getWis()
    {
        return wis;
    }

    public int getInte()
    {
        return inte;
    }

    public int getCha() {
        return cha;
    }

    public int getClassID()
    {
        return classID;
    }

    public int getRaceID()
    {
        return raceID;
    }

    public String getInvetoryID()
    {
        String iID = "";

        if (inventoryID == null)
            return null;
        else {
            for (int x = 0; x < inventoryID.size(); x++) {
                iID += (inventoryID.get(x) + ",");
            }
        }
        return iID;
    }

    public String getSpellBookID()
    {
        String sbID = "";
        if (spellBookID == null)
            return null;
        else {

            for (int x = 0; x < spellBookID.size(); x++) {
                sbID += (spellBookID.get(x) + ",");
            }
        }
        return sbID;
    }

    public int getAbilityScoreID()
    {
        return abilityScoreID;
    }

    public String getLvl() {
        return lvl;
    }
}
