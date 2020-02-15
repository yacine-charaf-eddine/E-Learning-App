package ti.dam.mobilee_learning;

import java.io.Serializable;
import java.util.ArrayList;

public class Personne implements Serializable{

    private int numInscription;
    private long id, id_specialite;
    private String type,nom,prenom,departement,pass,module;

    private Specialite specialite;

    private ArrayList<Module> modues = new ArrayList<Module>();

    public Personne(){};

    public Personne (String type,String nom, String prenom, String departement, String pass){
        this.type = type;
        this.nom = nom;
        this.prenom = prenom;
        this.departement = departement;
        this.pass = pass;
    }

    public long getId() { return id; }

    public String getType() { return type; }

    public String getNom() { return nom; }

    public String getPrenom() { return prenom; }

    public String getDepartement() { return departement; }

    public String getPass() { return pass; }

    public int getNumInscription() { return numInscription; }

    public Specialite getSpecialite() { return specialite; }

    public long getId_specialite() { return id_specialite; }

    public String getModule() { return module; }

    public ArrayList<Module> getModues() { return modues; }

    public void setId(long id) { this.id = id; }

    public void setType(String type) { this.type = type; }

    public void setNom(String nom) { this.nom = nom; }

    public void setPrenom(String prenom) { this.prenom = prenom; }

    public void setDepartement(String departement) { this.departement = departement; }

    public void setPass(String pass) { this.pass = pass; }

    public void setSpecialite(Specialite specialite) { this.specialite = specialite; }

    public void setId_specialite(long id_specialite) { this.id_specialite = id_specialite; }

    public void setModues(ArrayList<Module> modues) { this.modues = modues; }

    public void setNumInscription(int numInscription) { this.numInscription = numInscription; }

    public void setModule(String module) { this.module = module; }
}
