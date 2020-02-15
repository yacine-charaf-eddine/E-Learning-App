package ti.dam.mobilee_learning;

public class Message {

    String module, objet, message, nomSender, prenomSender;
    long id, idEtudiant, idProfessor;

    public Message(){}

    public String getModule() {
        return module;
    }

    public String getNomSender() {
        return nomSender;
    }

    public String getPrenomSender() {
        return prenomSender;
    }

    public long getId() {
        return id;
    }

    public long getIdEtudiant() {
        return idEtudiant;
    }

    public long getIdProfessor() {
        return idProfessor;
    }

    public String getMessage() {
        return message;
    }

    public String getObjet() {
        return objet;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIdEtudiant(long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public void setIdProfessor(long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public void setNomSender(String nomSender) {
        this.nomSender = nomSender;
    }

    public void setPrenomSender(String prenomSender) {
        this.prenomSender = prenomSender;
    }
}
