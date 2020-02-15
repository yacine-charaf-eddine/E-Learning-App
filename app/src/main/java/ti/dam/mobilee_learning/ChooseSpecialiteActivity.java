package ti.dam.mobilee_learning;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseSpecialiteActivity extends AppCompatActivity {

    Boolean specialite1Presssed = false;
    Boolean specialite2Presssed = false;
    private Boolean backButtonPressedOnce = false;
    Specialite TI,SCI,GL,SI;

    @Override
    public void onBackPressed() {


        if (backButtonPressedOnce) {

            moveTaskToBack(true);
        }
        backButtonPressedOnce = true;

        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backButtonPressedOnce = false;
            }
        },2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_specialite);

        //declaring variables

        final ImageView specialite1,specialite2,specialite1Check,specialite2Check;
        final RelativeLayout specialite1Contaner,specialite2Contaner;
        final Button nextBtn;
        final TextView specialite1txt,nbrModule1;
        final TextView specialite2txt,nbrModule2;
        final Personne personne;


        //getting views from xml

        specialite1 = findViewById(R.id.code);
        specialite2 = findViewById(R.id.ai);
        specialite1Check = findViewById(R.id.specialite1Check);
        specialite2Check = findViewById(R.id.specialite2Check);
        specialite1Contaner = findViewById(R.id.specialite1Container);
        specialite2Contaner = findViewById(R.id.specialite2Container);
        nextBtn = findViewById(R.id.nextBtn);
        specialite1txt = findViewById(R.id.specialite1_accronyme);
        specialite2txt = findViewById(R.id.specialite2_accronyme);
        nbrModule1 = findViewById(R.id.floatingValue1);
        nbrModule2 = findViewById(R.id.floatingValue2);

        personne = new Personne();
        TI = new Specialite("TI");
        SCI = new Specialite("SCI");
        GL = new Specialite("GL");
        SI = new Specialite("SI");

        //setting variables

        specialite1Check.setVisibility(View.INVISIBLE);
        specialite2Check.setVisibility(View.INVISIBLE);

        // setting specialities

        final SharedPreferences mpreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);

        final MyDbHelper myDbHelper = new MyDbHelper(ChooseSpecialiteActivity.this);

        int inscriptionNumber = mpreferences.getInt("inscription_number",0);

        if (inscriptionNumber !=0){

            personne.setId(myDbHelper.findPersonne(inscriptionNumber).getId());
            personne.setNom(myDbHelper.findPersonne(inscriptionNumber).getNom());
            personne.setPrenom(myDbHelper.findPersonne(inscriptionNumber).getPrenom());
            personne.setType(myDbHelper.findPersonne(inscriptionNumber).getType());
            personne.setPass(myDbHelper.findPersonne(inscriptionNumber).getPass());
            personne.setNumInscription(myDbHelper.findPersonne(inscriptionNumber).getNumInscription());
            personne.setDepartement(myDbHelper.findPersonne(inscriptionNumber).getDepartement());

            if (personne != null){


                if (personne.getDepartement().equals("IFA")){

                     TI.setDepartement(personne.getDepartement());
                     TI.setDescription("description specialite TI");

                     SCI.setDepartement(personne.getDepartement());
                     SCI.setDescription("description specialite SCI");


                    specialite1txt.setText(TI.getNom());
                    specialite2txt.setText(SCI.getNom());

                    specialite1.setImageResource(R.drawable.code);
                    specialite2.setImageResource(R.drawable.artificial_intelligence);

                    nbrModule1.setText(String.valueOf(TI.getModules().size()));
                    nbrModule2.setText(String.valueOf(SCI.getModules().size()));

                }else if (personne.getDepartement().equals("TLSI")){

                    GL.setDepartement(personne.getDepartement());
                    GL.setDescription("description specialite GL");

                    SI.setDepartement(personne.getDepartement());
                    SI.setDescription("description specialite SI");

                    specialite1txt.setText(GL.getNom());
                    specialite2txt.setText(SI.getNom());

                    specialite1.setImageResource(R.drawable.genie_logiciel);
                    specialite2.setImageResource(R.drawable.systeme_information);

                    nbrModule1.setText(String.valueOf(GL.getModules().size()));
                    nbrModule2.setText(String.valueOf(SI.getModules().size()));

                }
            }
        }
        // settion views


        //setting listners

        specialite1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!specialite1Presssed ){

                    if (specialite2Presssed) {

                        specialite1Presssed = true;
                        specialite2Presssed = false;
                        specialite1Check.setVisibility(View.VISIBLE);
                        specialite2Check.setVisibility(View.INVISIBLE);
                        specialite1Contaner.setBackground(getDrawable(R.drawable.background_border));
                        specialite2Contaner.setBackgroundResource(0);

                    }else{

                        specialite1Presssed = true;
                        specialite1Check.setVisibility(View.VISIBLE);
                        specialite1Contaner.setBackground(getDrawable(R.drawable.background_border));
                    }


                }else {

                    specialite1Presssed = false;
                    specialite1Check.setVisibility(View.INVISIBLE);
                    specialite1Contaner.setBackgroundResource(0);
                }
            }
        });

        specialite2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!specialite2Presssed ){

                    if (specialite1Presssed){

                        specialite1Presssed = false;
                        specialite2Presssed = true;
                        specialite2Check.setVisibility(View.VISIBLE);
                        specialite1Check.setVisibility(View.INVISIBLE);
                        specialite2Contaner.setBackground(getDrawable(R.drawable.background_border));
                        specialite1Contaner.setBackgroundResource(0);


                    }else{

                        specialite2Presssed = true;
                        specialite2Check.setVisibility(View.VISIBLE);
                        specialite2Contaner.setBackground(getDrawable(R.drawable.background_border));

                    }

                }else {

                    specialite2Presssed = false;
                    specialite2Check.setVisibility(View.INVISIBLE);
                    specialite2Contaner.setBackgroundResource(0);
                }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!specialite1Presssed && !specialite2Presssed){
                    Toast.makeText(ChooseSpecialiteActivity.this, "Please choose a specialite", Toast.LENGTH_SHORT).show();
                }else {

                    AlertDialog.Builder builder;

                    builder = new AlertDialog.Builder(ChooseSpecialiteActivity.this);

                    builder.setTitle("Be careful")
                            .setMessage("Once you choose this specialite you can't go back and change it unless you have a time machine")
                            .setPositiveButton("I understand", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {


                                    if (specialite1Presssed){

                                        if (personne.getDepartement().equals("IFA")){

                                            personne.setSpecialite(TI);
                                            personne.setId_specialite(myDbHelper.addSpecialite(TI));

                                            SharedPreferences.Editor editor = mpreferences.edit();
                                            editor.putLong("user_specialite_id", personne.getId_specialite());
                                            editor.apply();

                                            myDbHelper.updatePersonne(personne);


                                            SI = null;
                                            SCI = null;
                                            GL = null;
                                            TI = null;


                                        }else if (personne.getDepartement().equals("TLSI")){

                                            personne.setSpecialite(GL);
                                            personne.setId_specialite(myDbHelper.addSpecialite(GL));

                                            SharedPreferences.Editor editor = mpreferences.edit();
                                            editor.putLong("user_specialite_id", personne.getId_specialite());
                                            editor.apply();

                                            myDbHelper.updatePersonne(personne);

                                            TI = null;
                                            SCI = null;
                                            SI = null;
                                            GL = null;

                                        }


                                    }else if (specialite2Presssed){

                                        if (personne.getDepartement().equals("IFA")){

                                            personne.setSpecialite(SCI);
                                            personne.setId_specialite(myDbHelper.addSpecialite(SCI));

                                            SharedPreferences.Editor editor = mpreferences.edit();
                                            editor.putLong("user_specialite_id", personne.getId_specialite());
                                            editor.apply();

                                            myDbHelper.updatePersonne(personne);


                                            TI = null;
                                            SI = null;
                                            GL = null;
                                            SCI = null;

                                        }else if (personne.getDepartement().equals("TLSI")){

                                            personne.setSpecialite(SI);
                                            personne.setId_specialite(myDbHelper.addSpecialite(SI));

                                            SharedPreferences.Editor editor = mpreferences.edit();
                                            editor.putLong("user_specialite_id", personne.getId_specialite());

                                            editor.apply();

                                            myDbHelper.updatePersonne(personne);


                                            TI = null;
                                            SCI = null;
                                            GL = null;

                                            SI = null;



                                        }
                                    }

                                    if (personne.getType().equals("student")){

                                        Intent intent = new Intent(ChooseSpecialiteActivity.this,StudentActivity.class);

                                        startActivity(intent);

                                        ChooseSpecialiteActivity.this.finish();

                                    }else{

                                        Intent intent = new Intent(ChooseSpecialiteActivity.this,ChooseModuleActivity.class);

                                        startActivity(intent);

                                        ChooseSpecialiteActivity.this.finish();
                                    }
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    dialog.cancel();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }

            }
        });
    }

}
