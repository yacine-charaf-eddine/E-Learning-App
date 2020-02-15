package ti.dam.mobilee_learning;

import java.io.Serializable;
import java.util.ArrayList;

public class Week implements Serializable{
    private long id, id_module;
    private String description;
    private String beginDate, endDate,module;// String background removed
    private ArrayList<Course> cources = new ArrayList<Course>();

    public Week (String description, String beginDate, String endDate,String module){

        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.module = module;

    //-----------------------------------TI-------------------------------//
        if (module.equals("DAM")){
            switch (description){
                case "week1": cources.add(new Course("chapitre 1: Vers une informatique ambiante", "cour 1","https://drive.google.com/file/d/1zAEASTtPVAagjYxDheFV_fdhtqrA1nIk/view",module,description));
                    break;
                case "week2": cources.add(new Course("chapitre 2: Programmation mobile sous Android", "cour 2","https://drive.google.com/file/d/1WfEZDNJpcOQFZ3jyWQ18ifmdZrbhVkc0/view",module,description));
                    break;
                case "week3": cources.add(new Course("chapitre 3: Outil de développement", "cour 3","https://drive.google.com/file/d/1GgewvsfcP6_Wwyt7wwtRjGhk7gVm2fkD/view",module,description));
                    break;
                case "week4": cources.add(new Course("chapitre 4:  Langage Java et programmation orienté objet 1", "cour 4","https://drive.google.com/file/d/1unChIEv67VO6I_k4MUcLZbF7Kk0l4Z5V/view",module,description));
                    break;
                case "week5": cources.add(new Course("chapitre 4:  Langage Java et programmation orienté objet 2", "cour 5  ","https://drive.google.com/file/d/12lkER7BRiWfmnFV4mg6lcx9PPWWAOv0z/view",module,description));
                    break;

            }
        }else if (module.equals("DAW")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1: Introduction au Développement d’Applications Web", "cour 1", "https://drive.google.com/open?id=1A6PB9m-_rH_bNax2q8cZ5NeiRfQnoE6v",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 1: Introduction au Développement d’Applications Web", "cour 2", "https://drive.google.com/open?id=1A6PB9m-_rH_bNax2q8cZ5NeiRfQnoE6v",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 2: Transmettre les données sous PHP", "cour 3", "https://drive.google.com/open?id=1kvOOBYvvz3ME1WRJhA7eeNxJ1RGLWk-3",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 2: Transmettre les données sous PHP", "cour 4", "https://drive.google.com/open?id=1kvOOBYvvz3ME1WRJhA7eeNxJ1RGLWk-3",module,description));
                    break;
                case "week5":
                    cources.add(new Course("Chapitre 3; Gestion et Administration des BD en PHP OO", "cour 5", "https://drive.google.com/open?id=1hDJ4sVHo4A1R65x__9gUPtx9UDPNP81Q",module,description));
                    break;
            }
        }else if (module.equals("BDM")){
            switch (description) {
                case "week1":
                    cources.add(new Course("chapitre 1: Language PL/SQL", "cour 1", "https://drive.google.com/open?id=1lgfr8wNfDF9TnDNjPC2XOLpMv87FnNX8",module,description));
                    break;
                case "week2":
                    cources.add(new Course("chapitre 2: Vues", "cour 2", "https://drive.google.com/open?id=19HuIHKtLQLQ1iti9AZ4x37iOd-fgRVi4",module,description));
                    break;
                case "week3":
                    cources.add(new Course("chapitre 3: Bases de donnes objet", "cour 3", "https://drive.google.com/open?id=1btNWt57f1esVxFQZp6qXadshSPxni_ja",module,description));
                    break;
                case "week4":
                    cources.add(new Course("chapitre 4:  Transaction", "cour 4", "https://drive.google.com/open?id=1BvCwI1JuummXtCEF4Buh34mG6rfqNDzd",module,description));
                    break;

            }
        }else if (module.equals("ACS")){
            switch (description) {
                case "week1":
                    cources.add(new Course("chapitre 1: Introduction à UML et diagrammes CU description textuelle", "cour 1", "https://drive.google.com/open?id=1L0I4Cxz3bLX31de5oARrYOQQB5GH9XC0",module,description));
                    break;
                case "week2":
                    cources.add(new Course("chapitre 2: diagrammes de classes", "cour 2", "https://drive.google.com/open?id=1Nl-UMPft5nYiA2NZu23ou0uYtWmVK_60",module,description));
                    break;
                case "week3":
                    cources.add(new Course("chapitre 3: Diagrammes dactivités", "cour 3", "https://drive.google.com/open?id=1TAEhSc79PH1GF2uUitBw6juHLukWmOsk",module,description));
                    break;
                case "week4":
                    cources.add(new Course("chapitre 4: Diagrammes d_interaction", "cour 4", "https://drive.google.com/open?id=1fBEfO037foolz_FhwxgEiT2Q0fJ06L6d",module,description));
                    break;
                case "week5":
                    cources.add(new Course("chapitre 4: stéréotypes de jaccobson", "cour 5", "https://drive.google.com/open?id=1akc9SweNX_kQQgCIoUT3hhvxXVsaB3vj",module,description));
                    break;
            }
        }else if(module.equals("TEC")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1 : Savoir comment se présenter", "cour 1", "https://drive.google.com/file/d/0BxbN40osPbqfZWVnU3cyNUk5X28/view",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2 : Techniques rédactionnelles", "cour 2", "https://drive.google.com/file/d/0BxbN40osPbqfTHB2c09Wbkc5X2M/view",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3 : L’exposé écrit et oral", "cour 3", "https://drive.google.com/file/d/1F_Ajh9C4t3x6avHAsAjltk6pmHvTBIcV/view",module,description));
                case "week4":
                    cources.add(new Course("Chapitre 3 : L’exposé écrit et oral", "cour 4", "https://drive.google.com/file/d/1DofqlGtxoqk8TTqfUCJ8nwRRmrmMp4OA/view",module,description));
                    break;

            }
        }
        //----------------------------------SCI--------------------------------//

        else if(module.equals("SE2")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("SI")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("RIP")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("ABD")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("COMP")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }
        //----------------------------------GL--------------------------------//

        else if(module.equals("TQL")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("GL2")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("GPL")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("DAC")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("TABD")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }
        //----------------------------------SI--------------------------------//

        else if(module.equals("POA")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("EAB")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("BPI")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("UPD")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }else if(module.equals("OMC")){
            switch (description) {
                case "week1":
                    cources.add(new Course("Chapitre 1", "cour 1", "",module,description));
                    break;
                case "week2":
                    cources.add(new Course("Chapitre 2", "cour 2", "",module,description));
                    break;
                case "week3":
                    cources.add(new Course("Chapitre 3", "cour 3", "",module,description));
                    break;
                case "week4":
                    cources.add(new Course("Chapitre 3", "cour 4", "",module,description));
                    break;

            }
        }

    }

    public Week(){

    }

    public long getId() { return id; }

    public long getId_module() { return id_module; }

    public String getDescription() {
        return description;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public ArrayList<Course> getCources() {
        return cources;
    }

    public void setId_module(long id_module) { this.id_module = id_module; }

    public void setDescription(String description) { this.description = description; }

    public void setBeginDate(String beginDate) { this.beginDate = beginDate; }

    public void setCources(ArrayList<Course> cources) { this.cources = cources; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public void setId(long id) { this.id = id; }

}
