package ti.dam.mobilee_learning;

public class Qcm {

    private String question, prop1,prop2,prop3,reponce;

    private long id;



    public Qcm(String question, String prop1, String prop2, String prop3, String reponce){

        this.question = question;

        this.prop1 = prop1;

        this.prop2 = prop2;

        this.prop3 = prop3;

        this.reponce = reponce;
    }

    public Qcm(){}

    public long getId() { return id; }

    public String getProp1() { return prop1; }

    public String getProp2() { return prop2; }

    public String getProp3() { return prop3; }

    public String getQuestion() { return question; }

    public String getReponce() { return reponce; }

    public void setId(long id) { this.id = id; }

    public void setProp1(String prop1) { this.prop1 = prop1; }

    public void setProp2(String prop2) { this.prop2 = prop2; }

    public void setProp3(String prop3) { this.prop3 = prop3; }

    public void setQuestion(String question) { this.question = question; }

    public void setReponce(String reponce) { this.reponce = reponce; }
}
