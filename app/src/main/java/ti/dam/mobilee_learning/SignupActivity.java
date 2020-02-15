package ti.dam.mobilee_learning;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SignupActivity extends AppCompatActivity {

    Boolean techerPresssed = false;
    Boolean studentPresssed = false;
    RadioButton departementButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);

            // declaring variables

            final ImageView teacherImg,studentImg,techerCheck,studentCheck;
            final Button signUpBtn;
            final EditText nom,prenom,pass;
            final RadioGroup departement;


            // getting views from xml

            teacherImg = findViewById(R.id.teacher);
            studentImg = findViewById(R.id.student);
            studentCheck = findViewById(R.id.studentCheck);
            techerCheck = findViewById(R.id.teacherCheck);
            nom = findViewById(R.id.nominput);
            prenom = findViewById(R.id.prenominput);
            departement = findViewById(R.id.radioDepartement);
            pass = findViewById(R.id.passinput);
            final RelativeLayout teacherContainer = findViewById(R.id.techerContainer);
            final RelativeLayout studenContainer = findViewById(R.id.studentContainer);
            signUpBtn = findViewById(R.id.signup);

            // setting variables

            techerCheck.setVisibility(View.INVISIBLE);
            studentCheck.setVisibility(View.INVISIBLE);

            // setting listners

            teacherImg.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (!techerPresssed ){

                        if (studentPresssed) {

                            techerPresssed = true;
                            studentPresssed = false;
                            techerCheck.setVisibility(View.VISIBLE);
                            studentCheck.setVisibility(View.INVISIBLE);
                            teacherContainer.setBackground(getDrawable(R.drawable.background_border));
                            studenContainer.setBackgroundResource(0);

                        }else{

                            techerPresssed = true;
                            techerCheck.setVisibility(View.VISIBLE);
                            teacherContainer.setBackground(getDrawable(R.drawable.background_border));
                        }


                    }else {

                        techerPresssed = false;
                        techerCheck.setVisibility(View.INVISIBLE);
                        teacherContainer.setBackgroundResource(0);
                    }
                }
            });

            studentImg.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (!studentPresssed ){

                        if (techerPresssed){

                            techerPresssed = false;
                            studentPresssed = true;
                            studentCheck.setVisibility(View.VISIBLE);
                            techerCheck.setVisibility(View.INVISIBLE);
                            studenContainer.setBackground(getDrawable(R.drawable.background_border));
                            teacherContainer.setBackgroundResource(0);


                        }else{

                            studentPresssed = true;
                            studentCheck.setVisibility(View.VISIBLE);
                            studenContainer.setBackground(getDrawable(R.drawable.background_border));

                        }

                    }else {

                        studentPresssed = false;
                        studentCheck.setVisibility(View.INVISIBLE);
                        studentCheck.setBackgroundResource(0);
                        studenContainer.setBackgroundResource(0);
                    }
                }
            });

            signUpBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    departementButton = findViewById(departement.getCheckedRadioButtonId());


                    if (nom.getText().toString().equals("") || prenom.getText().toString().equals("")|| departementButton == null ||pass.getText().toString().equals("") ||(!studentPresssed && !techerPresssed)){

                        if (nom.getText().toString().equals("")){

                            nom.setError("nom is missing");

                        }else if (prenom.getText().toString().equals("")){

                            prenom.setError("prenom is missing");

                        }else if (pass.getText().toString().equals("")){

                            pass.setError("password is missing");
                        }else if (!studentPresssed && !techerPresssed){
                            Toast.makeText(SignupActivity.this, "please choose your acount type ", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(SignupActivity.this, "please choose your departement ", Toast.LENGTH_SHORT).show();
                        }

                    }else if (!nom.getText().toString().equals("") && !prenom.getText().toString().equals("") && departementButton != null && !pass.getText().toString().equals("")){

                        if (studentPresssed || techerPresssed){

                            Personne personne = new Personne();

                            MyDbHelper myDbHelper = new MyDbHelper(SignupActivity.this);

                            if (studentPresssed){
                                personne.setType("student");

                            }else{
                                personne.setType("teacher");
                            }

                                personne.setNom(nom.getText().toString());

                                personne.setPrenom(prenom.getText().toString());

                                personne.setDepartement(departementButton.getText().toString());


                                personne.setPass(pass.getText().toString());

                                Random random = new Random();

                                int numInscription = random.nextInt(99999 - 10000) + 10000;

                                personne.setNumInscription(numInscription);

                                myDbHelper.addPersonne(personne);

                                AlertDialog.Builder builder;

                                builder = new AlertDialog.Builder(SignupActivity.this);

                                builder.setTitle("Your account has been created successfully")
                                        .setMessage("inscription number: "+numInscription+"\n"
                                        +"use it with your password in order to connect.")
                                        .setPositiveButton("connect", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {

                                                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);

                                                startActivity(intent);

                                                SignupActivity.this.finish();
                                            }
                                        })
                                        .setIcon(R.drawable.check)
                                        .show();
                        }

                    }




            }
        });
    }
}
