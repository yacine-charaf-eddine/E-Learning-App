package ti.dam.mobilee_learning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Boolean techerPresssed = false;
    Boolean studentPresssed = false;
    private Boolean backButtonPressedOnce = false;

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


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // qeeping information about user loggin

        final SharedPreferences mpreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);

        if (mpreferences.getBoolean("isLoged",false)){

            if (mpreferences.getString("user_type","student").equals("student")) {

                Intent intent = new Intent(this, StudentActivity.class);

                startActivity(intent);

            }else if(mpreferences.getString("user_type","teacher").equals("teacher")){

                Intent intent = new Intent(this, TeacherActivity.class);

                startActivity(intent);

            }
        }

        // declaring variables

        final ImageView teacherImg,studentImg,techerCheck,studentCheck;
        final Button logInBtn,guestBtn;
        final EditText user,pass;
        TextView signup;

        // getting views from xml

        teacherImg = findViewById(R.id.teacher);
        studentImg = findViewById(R.id.student);
        studentCheck = findViewById(R.id.studentCheck);
        techerCheck = findViewById(R.id.teacherCheck);
        user = findViewById(R.id.userinput);
        pass = findViewById(R.id.passinput);
        signup = findViewById(R.id.signup);
        final RelativeLayout teacherContainer = findViewById(R.id.techerContainer);
        final RelativeLayout studenContainer = findViewById(R.id.studentContainer);
        logInBtn = findViewById(R.id.login);
        guestBtn = findViewById(R.id.guest);

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

        guestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this,GuestActivity.class);

                startActivity(intent);

                LoginActivity.this.finish();

            }
        });

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((user.getText().length() == 0 || pass.getText().length() == 0)) {

                    if (user.getText().length() == 0 ){

                        user.setError("missing inscription number");

                    }else {

                        pass.setError("missing inscription number");

                    }

                } else {

                    if (!studentPresssed && !techerPresssed){

                        Toast.makeText(LoginActivity.this, "Please choose account type !!", Toast.LENGTH_SHORT).show();
                    }else {
                        MyDbHelper myDbHelper = new MyDbHelper(LoginActivity.this);

                        Personne personne = myDbHelper.findPersonne(Integer.parseInt(user.getText().toString()));

                        if (personne == null) {

                            Toast.makeText(LoginActivity.this, "Inscription number invalid !!", Toast.LENGTH_SHORT).show();

                        } else {
                            if (personne.getPass().equals(pass.getText().toString())) {

                                    if (studentPresssed && personne.getType().equals("student")){

                                        if (personne.getId_specialite() == 0){

                                            SharedPreferences.Editor editor = mpreferences.edit();

                                            editor.putBoolean("isLoged", true);

                                            editor.putString("user_nom", personne.getNom());
                                            editor.putString("user_prenom", personne.getPrenom());
                                            editor.putString("user_type", personne.getType());
                                            editor.putLong("user_id", personne.getId());
                                            editor.putInt("inscription_number", personne.getNumInscription());
                                            editor.putString("user_departement", personne.getDepartement());

                                            editor.apply();

                                            Intent intent = new Intent(LoginActivity.this, ChooseSpecialiteActivity.class);

                                            startActivity(intent);

                                            LoginActivity.this.finish();

                                        }else {

                                            SharedPreferences.Editor editor = mpreferences.edit();

                                            editor.putBoolean("isLoged", true);

                                            editor.putString("user_nom", personne.getNom());
                                            editor.putString("user_prenom", personne.getPrenom());
                                            editor.putString("user_type", personne.getType());
                                            editor.putLong("user_id", personne.getId());
                                            editor.putInt("inscription_number", personne.getNumInscription());
                                            editor.putString("user_departement", personne.getDepartement());
                                            editor.putLong("user_specialite_id", personne.getId_specialite());

                                            editor.apply();

                                            Intent intent = new Intent(LoginActivity.this, StudentActivity.class);

                                            startActivity(intent);

                                            LoginActivity.this.finish();
                                        }

                                    }else if (techerPresssed && personne.getType().equals("teacher")){

                                        if (personne.getId_specialite() == 0){

                                            SharedPreferences.Editor editor = mpreferences.edit();

                                            editor.putBoolean("isLoged", true);

                                            editor.putString("user_nom", personne.getNom());
                                            editor.putString("user_prenom", personne.getPrenom());
                                            editor.putString("user_type", personne.getType());
                                            editor.putLong("user_id", personne.getId());
                                            editor.putInt("inscription_number", personne.getNumInscription());
                                            editor.putString("user_departement", personne.getDepartement());

                                            editor.apply();

                                            Intent intent = new Intent(LoginActivity.this, ChooseSpecialiteActivity.class);

                                            startActivity(intent);

                                            LoginActivity.this.finish();

                                        }else {
                                            SharedPreferences.Editor editor = mpreferences.edit();

                                            editor.putBoolean("isLoged", true);

                                            editor.putString("user_nom", personne.getNom());
                                            editor.putString("user_prenom", personne.getPrenom());
                                            editor.putString("user_type", personne.getType());
                                            editor.putLong("user_id", personne.getId());
                                            editor.putInt("inscription_number", personne.getNumInscription());
                                            editor.putString("user_departement", personne.getDepartement());
                                            editor.putLong("user_specialite_id", personne.getId_specialite());


                                            editor.apply();

                                            Intent intent = new Intent(LoginActivity.this, TeacherActivity.class);

                                            startActivity(intent);

                                            LoginActivity.this.finish();
                                        }

                                    }else {
                                        Toast.makeText(LoginActivity.this, "wrong account type !!", Toast.LENGTH_SHORT).show();
                                    }

                            } else {
                                Toast.makeText(LoginActivity.this, "Password invalid !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);

                startActivity(intent);
            }
        });
    }

}

