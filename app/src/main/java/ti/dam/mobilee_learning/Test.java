package ti.dam.mobilee_learning;

import java.util.ArrayList;

public class Test {

    private long id, idStudent, idModule, idCourse, idQcm;
    private String[] answers = new String[3];

    public Test(long idStudent, long idModule, long idCourse, long idQcm){

        this.idStudent = idStudent;
        this.idModule = idModule;
        this.idCourse = idCourse;
        this.idQcm = idQcm;
    }

    public Test(){}

    public long getId() { return id; }

    public long getIdStudent() { return idStudent; }

    public long getIdModule() { return idModule; }

    public long getIdCourse() { return idCourse; }

    public long getIdQcm() { return idQcm; }

    public String[] getAnswers() { return answers; }

    public void setId(long id) { this.id = id; }

    public void setIdStudent(long idStudent) { this.idStudent = idStudent; }

    public void setIdModule(long idModule) { this.idModule = idModule; }

    public void setIdCourse(long idCourse) { this.idCourse = idCourse; }

    public void setIdQcm(long idQcm) { this.idQcm = idQcm; }

    public void setAnswers(String[] answers) { this.answers = answers; }
}
