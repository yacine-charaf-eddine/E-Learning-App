package ti.dam.mobilee_learning;

import java.io.Serializable;
import java.util.ArrayList;

public class Module implements Serializable{

    private long id,id_specialite_module;
    private int credit,background;
    private String accronym,name,description;
    private ArrayList<Week> weeks = new ArrayList<Week>();


    public Module (String accronym, String name, String  description, int credit,int background ){
        this.credit =credit;
        this.accronym = accronym;
        this.name = name;
        this.description = description;
        this.background = background;

        switch (accronym){
            //-----------------------------------TI----------------------------------//
            case "DAM":
                    weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                    weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                    weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                    weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                    weeks.add(new Week("week5","21 Oct","27 Oct",accronym));

                break;
            case "DAW":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                weeks.add(new Week("week5","21 Oct","27 Oct",accronym));

                break;
            case "BDM":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "ACS":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                weeks.add(new Week("week5","21 Oct","27 Oct",accronym));
                break;
            case "TEC":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            //--------------------------------------------SCI-------------------------------------//

            case "SE2":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "SI":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "RIP":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "ABD":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "COMP":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            //----------------------------------------GL---------------------------------------//

            case "TQL":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "GL2":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "GPL":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "DAC":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "TABD":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            //-------------------------------------------SI-----------------------------------------//

            case "POA":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "EAB":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "BPI":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "UPD":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;
            case "OMC":
                weeks.add(new Week("week1","23 Sep","29 Sep",accronym));
                weeks.add(new Week("week2","30 Sep","06 Oct",accronym));
                weeks.add(new Week("week3","07 Oct","13 Oct",accronym));
                weeks.add(new Week("week4","14 Oct","20 Oct",accronym));
                break;

        }


    }


    public Module(){

    }

    public long getId() { return id; }

    public long getId_specialite_module() { return id_specialite_module; }

    public int getCredit() {
        return credit;
    }

    public String getAccronym() {
        return accronym;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getBackground() {
        return background;
    }

    public ArrayList<Week> getWeeks() {
        return weeks;
    }

    public void setAccronym(String accronym) {
        this.accronym = accronym;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setId_specialite_module(long id_specialite_module) { this.id_specialite_module = id_specialite_module; }

    public void setId(long id) { this.id = id; }

    public void setBackground(int background) { this.background = background; }

    public void setWeeks(ArrayList<Week> weeks) { this.weeks = weeks; }
}
