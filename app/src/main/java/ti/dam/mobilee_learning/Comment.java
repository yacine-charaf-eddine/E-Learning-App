package ti.dam.mobilee_learning;

public class Comment {

    private String nom,prenom,comment,nomCour,typeCour,date,userType;
    private Long id;
    private long id_Personne;

    public Comment(){}
    public Comment(long id_Personne,String nom, String prenom, String nomCour, String comment,String typeCour){

        this.id_Personne = id_Personne;
        this.nom = nom;
        this.prenom = prenom;
        this.nomCour = nomCour;
        this.typeCour = typeCour;
        this.comment = comment;
    }

    public String getNom() { return nom; }

    public String getPrenom() { return prenom; }

    public String getComment() { return comment; }

    public String getNomCour() { return nomCour; }

    public String getTypeCour() { return typeCour; }

    public String getUserType() { return userType; }

    public long getId_Personne() { return id_Personne; }

    public String getDate() { return date; }

    public Long getId() { return id; }

    public void setNom(String nom) { this.nom = nom; }

    public void setDate(String date) { this.date = date; }

    public void setUserType(String userType) { this.userType = userType; }

    public void setPrenom(String prenom) { this.prenom = prenom; }

    public void setComment(String comment) { this.comment = comment; }

    public void setNomCour(String nomCour) { this.nomCour = nomCour; }

    public void setTypeCour(String typeCour) { this.typeCour = typeCour; }

    public void setId_Personne(long id_Personne) { this.id_Personne = id_Personne; }

    public void setId(Long id) { this.id = id; }
}
