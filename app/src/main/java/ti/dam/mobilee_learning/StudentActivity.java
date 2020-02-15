package ti.dam.mobilee_learning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        final SharedPreferences mpreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);

        MyDbHelper myDbHelper = new MyDbHelper(this);

        String userSpecialite = myDbHelper.findSpecialite(mpreferences.getLong("user_specialite_id",-1)).getNom();

        // declaring variables

        final CardView cours,test,chat_room,log_out,inbox;
        final TextView nom,prenom,specialite;

        // setting views

        cours = findViewById(R.id.cours);
        test = findViewById(R.id.test);
        chat_room = findViewById(R.id.chat_room);
        log_out = findViewById(R.id.log_out);
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        specialite = findViewById(R.id.specialite);
        inbox = findViewById(R.id.inbox);

        // setting variables

        nom.setText(mpreferences.getString("user_nom",null));
        prenom.setText(mpreferences.getString("user_prenom",null));
        specialite.setText(userSpecialite);


        // setting listners

        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StudentActivity.this,ModulesActivity.class);

                startActivity(intent);


            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StudentActivity.this,ChooseTestActivity.class);

                startActivity(intent);
            }
        });

        chat_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StudentActivity.this,InboxActivity.class);

                startActivity(intent);
            }
        });

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mpreferences.edit().putBoolean("isLoged",false).apply();

                mpreferences.edit().remove("user_nom").apply();
                mpreferences.edit().remove("user_prenom").apply();
                mpreferences.edit().remove("user_type").apply();
                mpreferences.edit().remove("user_id").apply();
                mpreferences.edit().remove("inscription_number").apply();
                mpreferences.edit().remove("user_specialite_id").apply();
                mpreferences.edit().remove("user_departement").apply();


                Intent intent = new Intent(StudentActivity.this,LoginActivity.class);

                startActivity(intent);

                StudentActivity.this.finish();

            }
        });
    }
}
