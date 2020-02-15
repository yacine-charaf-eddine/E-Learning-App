package ti.dam.mobilee_learning;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable{
    private long id, id_week, id_cour_module;
    private String name, type, link, module, week;
    private ArrayList<Qcm> qcms = new ArrayList<Qcm>();

    // -------- module DAM -------------

    // QSM 1

    private String QSM1_question_dam = "what sdk stands for ?";
    private String QSM1_prop1_dam = "Software Development Kit";
    private String QSM1_prop2_dam = "System Development Kit";
    private String QSM1_prop3_dam = "Software Data Kit";
    private String QSM1_reponce = QSM1_prop1_dam;

    // QSM 2

    private String QSM2_question_dam = "name of the virtual machine used in android ?";
    private String QSM2_prop1_dam = "Dalvik VM";
    private String QSM2_prop2_dam = "JAVA VM";
    private String QSM2_prop3_dam = "android VM";
    private String QSM2_reponce = QSM2_prop1_dam;

    // QSM 3

    private String QSM3_question_dam = "first method called in an activity lifecycle ?";
    private String QSM3_prop1_dam = "onCreate()";
    private String QSM3_prop2_dam = "onStart()";
    private String QSM3_prop3_dam = "onResume()";
    private String QSM3_reponce = QSM3_prop1_dam;


    public Course (String name, String type, String link, String module, String week) {
        this.name = name;
        this.type = type;
        this.link = link;
        this.module = module;
        this.week = week;

        if (module.equals("DAM")) {
            switch (week) {
                case "week1":
                    qcms.add(new Qcm(QSM1_question_dam,QSM1_prop1_dam,QSM1_prop2_dam,QSM1_prop3_dam,QSM1_reponce));
                    qcms.add( new Qcm(QSM2_question_dam,QSM2_prop1_dam,QSM2_prop2_dam,QSM2_prop3_dam,QSM2_reponce));
                    qcms.add( new Qcm(QSM3_question_dam,QSM3_prop1_dam,QSM3_prop2_dam,QSM3_prop3_dam,QSM3_reponce));
                    break;

                case "week2":
                    qcms.add(new Qcm(QSM1_question_dam,QSM1_prop1_dam,QSM1_prop2_dam,QSM1_prop3_dam,QSM1_reponce));
                    qcms.add( new Qcm(QSM2_question_dam,QSM2_prop1_dam,QSM2_prop2_dam,QSM2_prop3_dam,QSM2_reponce));
                    qcms.add( new Qcm(QSM3_question_dam,QSM3_prop1_dam,QSM3_prop2_dam,QSM3_prop3_dam,QSM3_reponce));
                    break;

            }
        }
    }

    public Course(){}

    public long getId() {
        return id;
    }

    public long getId_week() { return id_week; }

    public long getId_module() { return id_cour_module; }

    public String getName() { return name; }

    public String getType() { return type; }

    public String getLink() { return link; }

    public String getModule() { return module; }

    public String getWeek() { return week; }

    public ArrayList<Qcm> getQcms() { return qcms; }

    public void setType(String type) { this.type = type; }

    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setId_week(long id_week) { this.id_week = id_week; }

    public void setLink(String link) { this.link = link; }

    public void setId_module(long id_module) { this.id_cour_module = id_module; }

    public void setModule(String module) { this.module = module; }

    public void setWeek(String week) { this.week = week; }

    public void setQcms(ArrayList<Qcm> qcms) { this.qcms = qcms; }
}
