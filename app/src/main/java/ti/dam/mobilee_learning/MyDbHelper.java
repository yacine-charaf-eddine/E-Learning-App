package ti.dam.mobilee_learning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Contacts;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "LearnApp";// database name
    private static final int DATABASE_VERSION = 1;// database version
    //table names
    private static final String TABLE_MODULE = "MODULE";
    private static final String TABLE_WEEK = "WEEK";
    private static final String TABLE_COUR = "COUR";
    private static final String TABLE_PERSONNE = "PERSONNE";
    private static final String TABLE_SPECIALITE = "SPECIALITE";
    private static final String TABLE_COMMENT = "COMMENT";
    private static final String TABLE_QCM = "QCM";
    private static final String TABLE_TEST = "TEST";
    private static final String TABLE_MESSAGE = "MESSAGE";
    //coloumns names
    private static final String UID = "ID";// coloumn for all tables
    private static final String ACCRONYME = "ACCRONYME";// coloumn table Module
    private static final String NAME = "NAME";// coloumn table Module and Cour and personne and specialite and comment
    private static final String PRENOM = "PRENOM";// coloumn table personne and comment
    private static final String COMMENT = "COMMENT";// coloumn table  comment
    private static final String nom_COUR_COMMENT = "nom_COUR";// coloumn table  comment
    private static final String type_COUR_COMMENT = "type_COUR";// coloumn table  comment
    private static final String id_PERSONNE = "id_PERSONNE";// coloumn table  comment
    private static final String CREDIT = "CREDIT";// coloumn table Module
    private static final String DESCRIPTION = "DESCRIPTION";// coloumn table Module and Week and specialite
    private static final String BEGIN_DATE = "BEGINDATE";// coloumn table Week
    private static final String END_DATE = "ENDDATE";// coloumn table Week
    private static final String TYPE = "TYPE";// coloumn table Week and personne
    private static final String USER_TYPE = "USER_TYPE";// coloumn table comment
    private static final String NUM_INSCRIPTION = "NUM_INSCRIPTION";// coloumn table personne
    private static final String DEPARTEMENT = "DEPARTEMENT";// coloumn table personne and specialite
    private static final String PASS = "PASS";// coloumn table personne
    private static final String LINK = "LINK";// coloumn table Week
    private static final String id_SPECIALITE_ETUDIANT = "id_SPECIALITE_ETUDIANT";// coloumn table personne
    private static final String id_SPECIALITE_MODULE = "id_SPECIALITE_MODULE";// coloumn table module
    private static final String id_MODULE = "id_MODULE";// coloumn table week and test and personne
    private static final String id_WEEK = "id_WEEK";// coloumn table cour and QCM
    private static final String id_COUR_MODULE = "id_COUR_MODULE";// coloumn table cour
    private static final String BACKGROUND = "BACKGROUND";// coloumn table module
    private static final String QUESTION = "QUESTION";// coloumn table qcm
    private static final String PROP1 = "PROPOSITION_1";// coloumn table qcm
    private static final String PROP2 = "PROPOSITION_2";// coloumn table qcm
    private static final String PROP3 = "PROPOSITION_3";// coloumn table qcm
    private static final String ANSWER = "ANSWER";// coloumn table qcm
    private static final String id_COUR = "id_COUR";// coloumn table qcm and test
    private static final String id_Qcm = "id_QCM";// coloumn table test
    private static final String id_STUDENT = "id_STUDENT";// coloumn table test and message
    private static final String ANSWER1 = "ANSWER1";// coloumn table test
    private static final String ANSWER2 = "ANSWER2";// coloumn table test
    private static final String ANSWER3 = "ANSWER3";// coloumn table test
    private static final String TIME = "TIME";// coloumn table comment
    private static final String NOM_MODULE = "MODULE";// coloumn table comment and message
    private static final String id_PROFESSOR = "id_PROFESSOR";// coloumn table message
    private static final String OBJECT = "OBJECT";// coloumn table message
    private static final String MSG = "MESSAGE";// coloumn table message
    private static final String SENDERSNAME = "SENDER_NAME";// coloumn table message
    private static final String SENDERSPRENOM = "SENDER_PRENOM";// coloumn table message

    // tables creation statements
    private static final String CREATE_TABLE_MODULE = "CREATE TABLE "+TABLE_MODULE+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ACCRONYME+" VARCHAR(255), "+NAME+" VARCHAR(255), "+DESCRIPTION+" VARCHAR(255), "+CREDIT+" INTEGER, "+id_SPECIALITE_MODULE+" VARCHAR(255), "+BACKGROUND+" VARCHAR(255));";
    private static final String CREATE_TABLE_Week = "CREATE TABLE "+TABLE_WEEK+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+DESCRIPTION+" VARCHAR(255), "+BEGIN_DATE+" VARCHAR(255), "+END_DATE+" VARCHAR(255), "+id_MODULE+" VARCHAR(255));";
    private static final String CREATE_TABLE_COUR = "CREATE TABLE "+TABLE_COUR+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+TYPE+" VARCHAR(255), "+LINK+" VARCHAR(255), "+id_WEEK+" VARCHAR(255), "+id_COUR_MODULE+" VARCHAR(255));";
    private static final String CREATE_TABLE_PERSONNE = "CREATE TABLE "+TABLE_PERSONNE+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NUM_INSCRIPTION+" INTEGER, "+TYPE+" VARCHAR(255), "+NAME+" VARCHAR(255), "+PRENOM+" VARCHAR(255), "+DEPARTEMENT+" VARCHAR(255), "+id_SPECIALITE_ETUDIANT+" VARCHAR(255), "+NOM_MODULE+" VARCHAR(255), "+PASS+" VARCHAR(255));";
    private static final String CREATE_TABLE_SPECIALITE = "CREATE TABLE "+TABLE_SPECIALITE+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+DEPARTEMENT+" VARCHAR(255), "+DESCRIPTION+" VARCHAR(255));";
    private static final String CREATE_TABLE_COMMENT = "CREATE TABLE "+TABLE_COMMENT+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+nom_COUR_COMMENT+" VARCHAR(255), "+type_COUR_COMMENT+" VARCHAR(255), "+id_PERSONNE+" VARCHAR(255), "+NAME+" VARCHAR(255), "+PRENOM+" VARCHAR(255), "+COMMENT+" VARCHAR(255), "+TIME+" VARCHAR(255), "+USER_TYPE+" VARCHAR(255));";
    private static final String CREATE_TABLE_QCM = "CREATE TABLE "+TABLE_QCM+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+id_MODULE+" VARCHAR(255), "+id_COUR+" VARCHAR(255), "+QUESTION+" VARCHAR(255), "+PROP1+" VARCHAR(255), "+PROP2+" VARCHAR(255), "+PROP3+" VARCHAR(255), "+ANSWER+" VARCHAR(255));";
    private static final String CREATE_TABLE_TEST = "CREATE TABLE "+TABLE_TEST+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+id_STUDENT+" VARCHAR(255), "+id_MODULE+" VARCHAR(255), "+id_COUR+" VARCHAR(255), "+id_Qcm+" VARCHAR(255), "+ANSWER1+" VARCHAR(255), "+ANSWER2+" VARCHAR(255), "+ANSWER3+" VARCHAR(255));";
    private static final String CREATE_TABLE_MESSAGE = "CREATE TABLE "+TABLE_MESSAGE+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+id_STUDENT+" VARCHAR(255), "+id_PROFESSOR+" VARCHAR(255), "+NOM_MODULE+" VARCHAR(255), "+OBJECT+" VARCHAR(255), "+MSG+" VARCHAR(255), "+SENDERSNAME+" VARCHAR(255), "+SENDERSPRENOM+" VARCHAR(255));";
    // tables droping statements
    private static final String DROP_TABLE_MODULE = "DROP TABLE IF EXISTS "+TABLE_MODULE;
    private static final String DROP_TABLE_WEEK = "DROP TABLE IF EXISTS "+TABLE_WEEK;
    private static final String DROP_TABLE_COUR = "DROP TABLE IF EXISTS "+TABLE_COUR;
    private static final String DROP_TABLE_PERSONNE = "DROP TABLE IF EXISTS "+TABLE_PERSONNE;
    private static final String DROP_TABLE_SPECIALITE = "DROP TABLE IF EXISTS "+TABLE_SPECIALITE;
    private static final String DROP_TABLE_COMMENT = "DROP TABLE IF EXISTS "+TABLE_COMMENT;
    private static final String DROP_TABLE_QCM = "DROP TABLE IF EXISTS "+TABLE_QCM;
    private static final String DROP_TABLE_TEST = "DROP TABLE IF EXISTS "+TABLE_TEST;
    private static final String DROP_TABLE_MESSAGE = "DROP TABLE IF EXISTS "+TABLE_MESSAGE;
    private Context context;


    public MyDbHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       try {
           db.execSQL(CREATE_TABLE_MODULE);
           db.execSQL(CREATE_TABLE_Week);
           db.execSQL(CREATE_TABLE_COUR);
           db.execSQL(CREATE_TABLE_PERSONNE);
           db.execSQL(CREATE_TABLE_SPECIALITE);
           db.execSQL(CREATE_TABLE_COMMENT);
           db.execSQL(CREATE_TABLE_QCM);
           db.execSQL(CREATE_TABLE_TEST);
           db.execSQL(CREATE_TABLE_MESSAGE);
       }catch (Exception e){
           Log.e(""+context,""+e);
       }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            db.execSQL(DROP_TABLE_MODULE);
            db.execSQL(DROP_TABLE_WEEK);
            db.execSQL(DROP_TABLE_COUR);
            db.execSQL(DROP_TABLE_PERSONNE);
            db.execSQL(DROP_TABLE_SPECIALITE);
            db.execSQL(DROP_TABLE_COMMENT);
            db.execSQL(DROP_TABLE_QCM);
            db.execSQL(DROP_TABLE_TEST);
            db.execSQL(DROP_TABLE_MESSAGE);
            onCreate(db);
        }catch (Exception e){
            Log.e(""+context,""+e);
        }

    }

    public void addModule(Module module, long id_specialite_module){

        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();

        Values.put(MyDbHelper.ACCRONYME,module.getAccronym());

        Values.put(MyDbHelper.NAME,module.getName());

        Values.put(MyDbHelper.DESCRIPTION,module.getDescription());

        Values.put(MyDbHelper.CREDIT,module.getCredit());

        Values.put(MyDbHelper.id_SPECIALITE_MODULE,id_specialite_module);

        Values.put(MyDbHelper.BACKGROUND,module.getBackground());

        long id = Db.insert(MyDbHelper.TABLE_MODULE,null,Values);



        for (Week w : module.getWeeks()) {

                addWeek(w,id);
        }

        Db.close();

    }

    public void addWeek(Week week, long id_module){

        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();

        Values.put(MyDbHelper.DESCRIPTION,week.getDescription());

        Values.put(MyDbHelper.BEGIN_DATE,week.getBeginDate());

        Values.put(MyDbHelper.END_DATE,week.getEndDate());

        Values.put(MyDbHelper.id_MODULE,id_module);

        long id = Db.insert(MyDbHelper.TABLE_WEEK,null,Values);


        for (Course c : week.getCources()) {

            addCour(c,id,id_module);
        }

        Db.close();
    }

    public void addCour(Course cour, long id_week, long id_cour_module){

        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();

        Values.put(MyDbHelper.NAME,cour.getName());

        Values.put(MyDbHelper.TYPE,cour.getType());

        Values.put(MyDbHelper.LINK,cour.getLink());

        Values.put(MyDbHelper.id_WEEK,id_week);

        Values.put(MyDbHelper.id_COUR_MODULE,id_cour_module);

        long id = Db.insert(MyDbHelper.TABLE_COUR,null,Values);

        for (Qcm q: cour.getQcms()) {

            addQcm(q,id,id_cour_module);
        }

        Db.close();
    }


    public void addQcm(Qcm qcm, long id_cour, long id_module){

        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();

        Values.put(MyDbHelper.id_MODULE,id_module);

        Values.put(MyDbHelper.id_COUR,id_cour);

        Values.put(MyDbHelper.QUESTION,qcm.getQuestion());

        Values.put(MyDbHelper.PROP1,qcm.getProp1());

        Values.put(MyDbHelper.PROP2,qcm.getProp2());

        Values.put(MyDbHelper.PROP3,qcm.getProp3());

        Values.put(MyDbHelper.ANSWER,qcm.getReponce());

        Db.insert(MyDbHelper.TABLE_QCM,null,Values);

        Db.close();
    }

    public void addTest(Test test){

        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();

        Values.put(MyDbHelper.id_MODULE,test.getIdModule());

        Values.put(MyDbHelper.id_COUR,test.getIdCourse());

        Values.put(MyDbHelper.id_STUDENT,test.getIdStudent());

        Values.put(MyDbHelper.id_Qcm,test.getIdQcm());

        Values.put(MyDbHelper.ANSWER1,test.getAnswers()[0]);

        Values.put(MyDbHelper.ANSWER2,test.getAnswers()[1]);

        Values.put(MyDbHelper.ANSWER3,test.getAnswers()[2]);

        Db.insert(MyDbHelper.TABLE_TEST,null,Values);

        Db.close();
    }


    public void addPersonne(Personne personne){

        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();

        Values.put(MyDbHelper.TYPE,personne.getType());

        Values.put(MyDbHelper.NUM_INSCRIPTION,personne.getNumInscription());

        Values.put(MyDbHelper.NAME,personne.getNom());

        Values.put(MyDbHelper.PRENOM,personne.getPrenom());

        Values.put(MyDbHelper.PASS,personne.getPass());

        Values.put(MyDbHelper.DEPARTEMENT,personne.getDepartement());

        Values.put(MyDbHelper.id_SPECIALITE_ETUDIANT,personne.getId_specialite());

        Values.put(MyDbHelper.NOM_MODULE,personne.getModule());

        Db.insert(MyDbHelper.TABLE_PERSONNE,null,Values);

        Db.close();
    }

    public long addMessage(Message message){

        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();

        Values.put(MyDbHelper.id_STUDENT,message.getIdEtudiant());

        Values.put(MyDbHelper.id_PROFESSOR,message.getIdProfessor());

        Values.put(MyDbHelper.NOM_MODULE,message.getModule());

        Values.put(MyDbHelper.OBJECT,message.getObjet());

        Values.put(MyDbHelper.MSG,message.getMessage());

        Values.put(MyDbHelper.SENDERSNAME,message.getNomSender());

        Values.put(MyDbHelper.SENDERSPRENOM,message.getPrenomSender());

        long done = Db.insert(MyDbHelper.TABLE_MESSAGE,null,Values);

        Db.close();

        return done;
    }

    public Long addComment(Comment comment){

        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();

        Values.put(MyDbHelper.nom_COUR_COMMENT,comment.getNomCour());

        Values.put(MyDbHelper.type_COUR_COMMENT,comment.getTypeCour());

        Values.put(MyDbHelper.id_PERSONNE,comment.getId_Personne());

        Values.put(MyDbHelper.NAME,comment.getNom());

        Values.put(MyDbHelper.PRENOM,comment.getPrenom());

        Values.put(MyDbHelper.COMMENT,comment.getComment());

        Values.put(MyDbHelper.TIME,comment.getDate());

        Values.put(MyDbHelper.USER_TYPE,comment.getUserType());

        return Db.insert(MyDbHelper.TABLE_COMMENT,null,Values);

    }

    public Long addSpecialite(Specialite specialite){

        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();

        Values.put(MyDbHelper.NAME,specialite.getNom());

        Values.put(MyDbHelper.DEPARTEMENT,specialite.getDepartement());

        Values.put(MyDbHelper.DESCRIPTION,specialite.getDescription());

        long id = Db.insert(MyDbHelper.TABLE_SPECIALITE,null,Values);

        for (Module m: specialite.getModules()) {

            addModule(m,id);
        }

        Db.close();

        return id;
    }

    public int updateModule(Module module){
        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();

        Values.put(MyDbHelper.ACCRONYME,module.getAccronym());

        Values.put(MyDbHelper.NAME,module.getName());

        Values.put(MyDbHelper.DESCRIPTION,module.getDescription());

        Values.put(MyDbHelper.CREDIT,module.getCredit());

        String[] Id = new String[] {module.getId()+""};

        return Db.update(MyDbHelper.TABLE_MODULE, Values, " id=",Id);

    }

    public void updatePersonne(Personne personne){

        SQLiteDatabase Db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();

        Values.put(MyDbHelper.NUM_INSCRIPTION,personne.getNumInscription());

        Values.put(MyDbHelper.TYPE,personne.getType());

        Values.put(MyDbHelper.NAME,personne.getNom());

        Values.put(MyDbHelper.PRENOM,personne.getPrenom());

        Values.put(MyDbHelper.DEPARTEMENT,personne.getDepartement());

        Values.put(MyDbHelper.id_SPECIALITE_ETUDIANT,personne.getId_specialite());

        Values.put(MyDbHelper.NOM_MODULE,personne.getModule());

        Values.put(MyDbHelper.PASS,personne.getPass());

        String[] Id = new String[] {personne.getId()+""};

        Db.update(MyDbHelper.TABLE_PERSONNE, Values, " id=?",Id);

        Db.close();
    }

    public void deleteModule(Module module){

        SQLiteDatabase Db = this.getWritableDatabase();

        String[] Id = new String[] {module.getId()+""};

        Db.delete(MyDbHelper.TABLE_MODULE," id=",Id);

        Db.close();

        for (Week w : module.getWeeks()) {

            deleteWeek(w);
        }
    }

    public void deleteWeek(Week week){

        SQLiteDatabase Db = this.getWritableDatabase();

        String[] Id = new String[] {week.getId()+""};

        Db.delete(MyDbHelper.TABLE_WEEK," id=",Id);

        Db.close();

        for (Course c : week.getCources()) {

            deleteCoure(c);
        }
    }

    public void deleteCoure(Course course){

        SQLiteDatabase Db = this.getWritableDatabase();

        String[] Id = new String[] {course.getId()+""};

        Db.delete(MyDbHelper.TABLE_COUR," id=",Id);

        Db.close();

    }

    public void deleteSpecialite(Specialite specialite){

        SQLiteDatabase Db = this.getWritableDatabase();

        String[] Id = new String[] {specialite.getId()+""};

        Db.delete(MyDbHelper.TABLE_SPECIALITE," id=",Id);

        Db.close();

        for (Module m : specialite.getModules()) {

            deleteModule(m);
        }
    }

    public Module findModule(long id){ // input parametre changed from String accronyme to long id

        Module module = new Module();

        Cursor cursor;

        SQLiteDatabase Db = this.getReadableDatabase();

        String querry = "SELECT * FROM "+TABLE_MODULE+" WHERE "+UID+" = "+id;

        cursor = Db.rawQuery(querry,null);

        if (cursor != null && cursor.moveToFirst()){

            module.setId(cursor.getLong(cursor.getColumnIndex(MyDbHelper.UID)));
            module.setAccronym(cursor.getString(cursor.getColumnIndex(MyDbHelper.ACCRONYME)));
            module.setName(cursor.getString(cursor.getColumnIndex(MyDbHelper.NAME)));
            module.setDescription(cursor.getString(cursor.getColumnIndex(MyDbHelper.DESCRIPTION)));
            module.setCredit(cursor.getInt(cursor.getColumnIndex(MyDbHelper.CREDIT)));

            cursor.close();


        }

        return module;
    }

    public Personne findPersonne(int inscriptionNumber){

        Personne personne = new Personne();

        Cursor cursor;

        SQLiteDatabase Db = this.getReadableDatabase();

        String querry = "SELECT * FROM "+TABLE_PERSONNE+" WHERE "+NUM_INSCRIPTION+" = "+inscriptionNumber;

        cursor = Db.rawQuery(querry,null);

        if (cursor != null && cursor.moveToFirst()){

            personne.setId(cursor.getLong(cursor.getColumnIndex(MyDbHelper.UID)));
            personne.setNom(cursor.getString(cursor.getColumnIndex(MyDbHelper.NAME)));
            personne.setPrenom(cursor.getString(cursor.getColumnIndex(MyDbHelper.PRENOM)));
            personne.setType(cursor.getString(cursor.getColumnIndex(MyDbHelper.TYPE)));
            personne.setPass(cursor.getString(cursor.getColumnIndex(MyDbHelper.PASS)));
            personne.setNumInscription(cursor.getInt(cursor.getColumnIndex(MyDbHelper.NUM_INSCRIPTION)));
            personne.setId_specialite(cursor.getLong(cursor.getColumnIndex(MyDbHelper.id_SPECIALITE_ETUDIANT)));
            personne.setDepartement(cursor.getString(cursor.getColumnIndex(MyDbHelper.DEPARTEMENT)));

            cursor.close();

        }else {
            return null;
        }

        return personne;
    }

    public Specialite findSpecialite(long specialiteId){

        Specialite specialite = new Specialite("");

        Cursor cursor;

        SQLiteDatabase Db = this.getReadableDatabase();

        String querry = "SELECT * FROM "+TABLE_SPECIALITE+" WHERE "+UID+" = "+specialiteId;

        cursor = Db.rawQuery(querry,null);

        if (cursor != null && cursor.moveToFirst()){

            specialite.setId(cursor.getLong(cursor.getColumnIndex(MyDbHelper.UID)));
            specialite.setNom(cursor.getString(cursor.getColumnIndex(MyDbHelper.NAME)));
            specialite.setDepartement(cursor.getString(cursor.getColumnIndex(MyDbHelper.DEPARTEMENT)));
            specialite.setDescription(cursor.getString(cursor.getColumnIndex(MyDbHelper.DESCRIPTION)));
            cursor.close();

        }else {
            return null;
        }

        return specialite;
    }

    public Course findCour(long weekId){

        Course course = new Course();

        Cursor cursor;

        SQLiteDatabase Db = this.getReadableDatabase();

        String querry = "SELECT * FROM "+TABLE_COUR+" WHERE "+id_WEEK+" = "+weekId;

        cursor = Db.rawQuery(querry,null);

        if (cursor != null && cursor.moveToFirst()){

            course.setId(cursor.getLong(cursor.getColumnIndex(MyDbHelper.UID)));
            course.setName(cursor.getString(cursor.getColumnIndex(MyDbHelper.NAME)));
            course.setType(cursor.getString(cursor.getColumnIndex(MyDbHelper.TYPE)));
            course.setLink(cursor.getString(cursor.getColumnIndex(MyDbHelper.LINK)));
            course.setId_module(cursor.getLong(cursor.getColumnIndex(MyDbHelper.id_COUR_MODULE)));
            cursor.close();

        }else {
            return null;
        }

        return course;
    }

    public ArrayList<Module> findAllModules(long idSpecialiteModule){

        ArrayList<Module> modules = new ArrayList<Module>();



        SQLiteDatabase Db = this.getReadableDatabase();

        String querry = "SELECT * FROM "+TABLE_MODULE+" WHERE "+id_SPECIALITE_MODULE+" = "+idSpecialiteModule;

        Cursor cursor = Db.rawQuery(querry,null);


        if (cursor != null && cursor.moveToFirst()){

            while (!cursor.isAfterLast()) {

                Module module = new Module();

                module.setId(cursor.getLong(cursor.getColumnIndex(MyDbHelper.UID)));
                module.setId_specialite_module(cursor.getLong(cursor.getColumnIndex(MyDbHelper.id_SPECIALITE_MODULE)));
                module.setCredit(cursor.getInt(cursor.getColumnIndex(MyDbHelper.CREDIT)));
                module.setAccronym(cursor.getString(cursor.getColumnIndex(MyDbHelper.ACCRONYME)));
                module.setName(cursor.getString(cursor.getColumnIndex(MyDbHelper.NAME)));
                module.setDescription(cursor.getString(cursor.getColumnIndex(MyDbHelper.DESCRIPTION)));
                module.setBackground(cursor.getInt(cursor.getColumnIndex(MyDbHelper.BACKGROUND)));

                modules.add(module);

                module = null;

                cursor.moveToNext();

            }
            cursor.close();
        }


        Db.close();

        return modules;
    }

    public ArrayList<Message> findAllMessagesByProfessor(long idProfessor){

        ArrayList<Message> messages = new ArrayList<Message>();



        SQLiteDatabase Db = this.getReadableDatabase();

        String querry = "SELECT * FROM "+TABLE_MESSAGE+" WHERE "+id_PROFESSOR+" = "+idProfessor;

        Cursor cursor = Db.rawQuery(querry,null);


        if (cursor != null && cursor.moveToFirst()){

            while (!cursor.isAfterLast()) {

                Message message = new Message();

                message.setId(cursor.getLong(cursor.getColumnIndex(MyDbHelper.UID)));
                message.setIdEtudiant(cursor.getLong(cursor.getColumnIndex(MyDbHelper.id_STUDENT)));
                message.setIdProfessor(cursor.getLong(cursor.getColumnIndex(MyDbHelper.id_PROFESSOR)));
                message.setObjet(cursor.getString(cursor.getColumnIndex(MyDbHelper.OBJECT)));
                message.setMessage(cursor.getString(cursor.getColumnIndex(MyDbHelper.MSG)));
                message.setMessage(cursor.getString(cursor.getColumnIndex(MyDbHelper.SENDERSNAME)));
                message.setMessage(cursor.getString(cursor.getColumnIndex(MyDbHelper.SENDERSPRENOM)));

                messages.add(message);

                message = null;

                cursor.moveToNext();

            }
            cursor.close();
        }


        Db.close();

        return messages;
    }

    public ArrayList<Message> findAllMessagesByStudent(long idstudent){

        ArrayList<Message> messages = new ArrayList<Message>();



        SQLiteDatabase Db = this.getReadableDatabase();

        String querry = "SELECT * FROM "+TABLE_MESSAGE+" WHERE "+id_STUDENT+" = "+id_STUDENT;

        Cursor cursor = Db.rawQuery(querry,null);


        if (cursor != null && cursor.moveToFirst()){

            while (!cursor.isAfterLast()) {

                Message message = new Message();

                message.setId(cursor.getLong(cursor.getColumnIndex(MyDbHelper.UID)));
                message.setIdEtudiant(cursor.getLong(cursor.getColumnIndex(MyDbHelper.id_STUDENT)));
                message.setIdProfessor(cursor.getLong(cursor.getColumnIndex(MyDbHelper.id_PROFESSOR)));
                message.setObjet(cursor.getString(cursor.getColumnIndex(MyDbHelper.OBJECT)));
                message.setMessage(cursor.getString(cursor.getColumnIndex(MyDbHelper.MSG)));
                message.setNomSender(cursor.getString(cursor.getColumnIndex(MyDbHelper.SENDERSNAME)));
                message.setPrenomSender(cursor.getString(cursor.getColumnIndex(MyDbHelper.SENDERSPRENOM)));
                message.setModule(cursor.getString(cursor.getColumnIndex(MyDbHelper.NOM_MODULE)));

                messages.add(message);

                message = null;

                cursor.moveToNext();

            }
            cursor.close();
        }


        Db.close();

        return messages;
    }

    public ArrayList<Week> findAllWeeks(long idModule){

        ArrayList<Week> weeks = new ArrayList<Week>();

        SQLiteDatabase Db = this.getReadableDatabase();

        String querry = "SELECT * FROM "+TABLE_WEEK+" WHERE "+id_MODULE+" = "+idModule;

        Cursor cursor = Db.rawQuery(querry,null);


        if (cursor != null && cursor.moveToFirst()){

            while (!cursor.isAfterLast()) {

                Week week = new Week();

                week.setId(cursor.getLong(cursor.getColumnIndex(MyDbHelper.UID)));
                week.setBeginDate(cursor.getString(cursor.getColumnIndex(MyDbHelper.BEGIN_DATE)));
                week.setEndDate(cursor.getString(cursor.getColumnIndex(MyDbHelper.END_DATE)));
                week.setId_module(idModule);

                weeks.add(week);

                week = null;

                cursor.moveToNext();

            }
            cursor.close();
        }


        Db.close();

        return weeks;
    }

    public ArrayList<Comment> findAllComments(String nom, String type){

        ArrayList<Comment> comments = new ArrayList<Comment>();

        SQLiteDatabase Db = this.getReadableDatabase();

        String querry = "SELECT * FROM "+TABLE_COMMENT+" WHERE "+nom_COUR_COMMENT+" = "+"'"+nom+"'"+" AND "+type_COUR_COMMENT+" = "+"'"+type+"'";

        try {
            Cursor cursor = Db.rawQuery(querry,null);


            if (cursor != null && cursor.moveToFirst()){

                while (!cursor.isAfterLast()) {

                    Comment comment = new Comment();

                    comment.setId(cursor.getLong(cursor.getColumnIndex(MyDbHelper.UID)));
                    comment.setNom(cursor.getString(cursor.getColumnIndex(MyDbHelper.NAME)));
                    comment.setPrenom(cursor.getString(cursor.getColumnIndex(MyDbHelper.PRENOM)));
                    comment.setComment(cursor.getString(cursor.getColumnIndex(MyDbHelper.COMMENT)));
                    comment.setDate(cursor.getString(cursor.getColumnIndex(MyDbHelper.TIME)));
                    comment.setUserType(cursor.getString(cursor.getColumnIndex(MyDbHelper.USER_TYPE)));

                    comments.add(comment);

                    comment = null;

                    cursor.moveToNext();

                }
                cursor.close();
            }


            Db.close();

            return comments;
        }catch (Exception e){
            return comments;
        }

    }

    public ArrayList<Qcm> findAllQcms(long id_cour, long id_module){

        ArrayList<Qcm> qcms = new ArrayList<Qcm>();



        SQLiteDatabase Db = this.getReadableDatabase();

        String querry = "SELECT * FROM "+TABLE_QCM+" WHERE "+id_MODULE+" = "+"'"+id_module+"'"+" AND "+id_COUR+" = "+"'"+id_cour+"'";

        Cursor cursor = Db.rawQuery(querry,null);


        if (cursor != null && cursor.moveToFirst()){

            while (!cursor.isAfterLast()) {

                Qcm qcm = new Qcm();

                qcm.setId(cursor.getLong(cursor.getColumnIndex(MyDbHelper.UID)));
                qcm.setQuestion(cursor.getString(cursor.getColumnIndex(MyDbHelper.QUESTION)));
                qcm.setProp1(cursor.getString(cursor.getColumnIndex(MyDbHelper.PROP1)));
                qcm.setProp2(cursor.getString(cursor.getColumnIndex(MyDbHelper.PROP2)));
                qcm.setProp3(cursor.getString(cursor.getColumnIndex(MyDbHelper.PROP3)));

                qcms.add(qcm);

                qcm = null;

                cursor.moveToNext();

            }
            cursor.close();
        }


        Db.close();

        return qcms;
    }

    public ArrayList<Personne> findAllProfessors(String Module){

        ArrayList<Personne> personnes = new ArrayList<Personne>();

        SQLiteDatabase Db = this.getReadableDatabase();

        String querry = "SELECT * FROM "+TABLE_PERSONNE+" WHERE "+NOM_MODULE+" = '"+Module+"'";

        Cursor cursor = Db.rawQuery(querry,null);


        if (cursor != null && cursor.moveToFirst()){

            while (!cursor.isAfterLast()) {

                Personne personne = new Personne();

                personne.setNom(cursor.getString(cursor.getColumnIndex(MyDbHelper.NAME)));
                personne.setPrenom(cursor.getString(cursor.getColumnIndex(MyDbHelper.PRENOM)));
                personne.setId(cursor.getLong(cursor.getColumnIndex(MyDbHelper.UID)));

                personnes.add(personne);

                personne = null;

                cursor.moveToNext();

            }
            cursor.close();
        }


        Db.close();

        return personnes;
    }



    public  void closeDb(){

        SQLiteDatabase Db = this.getReadableDatabase();

        if (Db != null && Db.isOpen()){
            Db.close();
        }
    }
}
