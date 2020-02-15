package ti.dam.mobilee_learning;

import java.io.Serializable;
import java.util.ArrayList;

public class Specialite implements Serializable{

    private Long id;
    private String nom,departement,description;
    private ArrayList<Module> modules = new ArrayList<Module>();

    // Description de chaque module de chaque specialite

    //----------------------TI-------------------------//
    final String DESC_DAM = "Le module de \"Développement d’Applications Mobiles\" est destiné essentiellement aux étudiants de\n" +
            "Licences 3, en informatique. Son objectif est l’acquisition par tout étudiant, des connaissances et des" +
            "compétences pour le développement des applications mobiles sous l’OS Android, ainsi que la maîtrise des" +
            "outils nécessaires pour ce type de développement.";

    final String DESC_DAW ="Apprendre à l’étudiant à identifier les objets du Web : Page web dynamique,document Web, …..\n" +
            "Apprendre une approche pour le développement Web : MVC….\n" +
            "Apprendre un langage dynamique : PHP";

    final String DESC_BDM ="Ce cours est destiné essentiellement aux étudiants de Licence en" +
            "informatique. Son objectif est de fournir à l’étudiant des bases théoriques et pratiques sur la" +
            "conception, l’exploitation et l'administration des bases de données. Dans ce" +
            "module, c’est le système de gestion de base de données relationnelle (SGBDR)" +
            "Oracle DB qui sera enseigné afin de donner aux étudiants les capacités et la" +
            "maîtrise nécessaire pour répondre aux besoins du monde professionnel.";

    final String DESC_ACS ="Apprendre à analyser et concevoir une application informatique au sein " +
            "d’une entreprise, qui répond effectivement aux besoins des utilisateurs ,en prévoyant à l’avance ses" +
            " fonctionnalités principales et en vérifiant qu’elle fait bien ce qui a été prévu";

    final String DESC_TEC ="Le module de TEC est un niveau avancé par rapport aux deux niveaux précédants. Les" +
            "cours sont présentés en exclusivité sur le site de l’Université de Abdelhamid Mehri dans le cadre du projet de" +
            "l’enseignement à distance des matières transversales proposées dans les offres de formations des différentes" +
            "filières enseignées au sein de l’Université.";

    //----------------------SCI-----------------------//
    final String DESC_SE2 = "SE2";

    final String DESC_SI ="SI";

    final String DESC_RIP ="RIP";

    final String DESC_ABD ="description ABD";

    final String DESC_COMP ="description COMP";

    //---------------------------GL--------------------------//

    final String DESC_TQL = "description TQL";

    final String DESC_GL2 ="description GL2";

    final String DESC_GPL ="description GPL";

    final String DESC_DAC ="description DAC";

    final String DESC_TABD ="description TABD";

    //-------------------------SI----------------------------//

    final String DESC_POA = "description POA";

    final String DESC_EAB ="description EAB";

    final String DESC_GPI ="description GPI";

    final String DESC_UPD ="description UPD";

    final String DESC_OMC ="description OMC";

    public Specialite (String nom){
        this.nom = nom;

        if (nom.equals("TI")){
            modules.add((new Module("DAM","Developpement d'Application Mobile",DESC_DAM,5,R.drawable.dam)));

            modules.add((new Module("DAW","Developpement d'Application Web",DESC_DAW,4,R.drawable.web)));

            modules.add((new Module("BDM","Base de Donnees et Multimedia",DESC_BDM,4,R.drawable.bdm)));

            modules.add((new Module("ACS","Analyse et Conception des Systemes",DESC_ACS,3,R.drawable.acs)));

            modules.add((new Module("TEC","Techniques d'Expresion et de Communication",DESC_TEC,1,R.drawable.tec)));

        }else if (nom.equals("SCI")){
            modules.add((new Module("SE2","Systeme d'Exploitation 2",DESC_SE2,5,R.drawable.dam)));

            modules.add((new Module("SI","Systemes d'Information",DESC_SI,4,R.drawable.dam)));

            modules.add((new Module("RIP","nom de module RIP",DESC_RIP,4,R.drawable.dam)));

            modules.add((new Module("ABD","nom de odule ABD",DESC_ABD,3,R.drawable.dam)));

            modules.add((new Module("COMP","Compilation",DESC_COMP,1,R.drawable.dam)));

        }else if (nom.equals("GL")){
            modules.add((new Module("TQL","Test et Qualite des Logiciels",DESC_TQL,5,R.drawable.dam)));

            modules.add((new Module("GL2","Genie Logiciel 2",DESC_GL2,4,R.drawable.dam)));

            modules.add((new Module("GPL","nom de module GPL",DESC_GPL,4,R.drawable.dam)));

            modules.add((new Module("DAC","nom de module DAC",DESC_DAC,3,R.drawable.dam)));

            modules.add((new Module("TABD","nom de module TABD",DESC_TABD,1,R.drawable.dam)));

        }else if (nom.equals("SI")){
            modules.add((new Module("POA","nom de odule POA",DESC_POA,5,R.drawable.dam)));

            modules.add((new Module("EAB","nom de odule EAB",DESC_EAB,4,R.drawable.dam)));

            modules.add((new Module("BPI","nom de odule BPI",DESC_GPI,4,R.drawable.dam)));

            modules.add((new Module("UPD","nom de odule UPD",DESC_UPD,3,R.drawable.dam)));

            modules.add((new Module("OMC","nom de odule OMC",DESC_OMC,1,R.drawable.dam)));

        }
    }

    public Specialite(String nom, String departement, String description){
        this.nom = nom;
        this.departement = departement;
        this.description = description;

        if (nom.equals("TI")){
            modules.add((new Module("DAM","Developpement d'Application Mobile",DESC_DAM,5,R.drawable.dam)));

            modules.add((new Module("DAW","Developpement d'Application Web",DESC_DAW,4,R.drawable.web)));

            modules.add((new Module("BDM","Base de Donnees et Multimedia",DESC_BDM,4,R.drawable.bdm)));

            modules.add((new Module("ACS","Analyse et Conception des Systemes",DESC_ACS,3,R.drawable.acs)));

            modules.add((new Module("TEC","Techniques d'Expresion et de Communication",DESC_TEC,1,R.drawable.tec)));

        }else if (nom.equals("SCI")){
            modules.add((new Module("SE2","Systeme d'Exploitation 2",DESC_SE2,5,R.drawable.dam)));

            modules.add((new Module("SI","Systemes d'Information",DESC_SI,4,R.drawable.dam)));

            modules.add((new Module("RIP","nom de module RIP",DESC_RIP,4,R.drawable.dam)));

            modules.add((new Module("ABD","nom de odule ABD",DESC_ABD,3,R.drawable.dam)));

            modules.add((new Module("COMP","Compilation",DESC_COMP,1,R.drawable.dam)));

        }else if (nom.equals("GL")){
            modules.add((new Module("TQL","Test et Qualite des Logiciels",DESC_TQL,5,R.drawable.dam)));

            modules.add((new Module("GL2","Genie Logiciel 2",DESC_GL2,4,R.drawable.dam)));

            modules.add((new Module("GPL","nom de module GPL",DESC_GPL,4,R.drawable.dam)));

            modules.add((new Module("DAC","nom de module DAC",DESC_DAC,3,R.drawable.dam)));

            modules.add((new Module("TABD","nom de module TABD",DESC_TABD,1,R.drawable.dam)));

        }else if (nom.equals("SI")){
            modules.add((new Module("POA","nom de odule POA",DESC_POA,5,R.drawable.dam)));

            modules.add((new Module("EAB","nom de odule EAB",DESC_EAB,4,R.drawable.dam)));

            modules.add((new Module("BPI","nom de odule BPI",DESC_GPI,4,R.drawable.dam)));

            modules.add((new Module("UPD","nom de odule UPD",DESC_UPD,3,R.drawable.dam)));

            modules.add((new Module("OMC","nom de odule OMC",DESC_OMC,1,R.drawable.dam)));

        }
    }

   // public int getNbrModules() { return nbrModules; }

    public String getNom() { return nom; }

    public ArrayList<Module> getModules() { return modules; }

    public String getDepartement() { return departement; }

    public Long getId() { return id; }

    public String getDescription() { return description; }

    public void setNom(String nom) { this.nom = nom; }

    public void setDepartement(String departement) { this.departement = departement; }

    public void setDescription(String description) { this.description = description; }

    public void setId(Long id) { this.id = id; }

    public void setModules(ArrayList<Module> modules) { this.modules = modules; }
}
