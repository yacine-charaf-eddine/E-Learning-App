package ti.dam.mobilee_learning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;

public class TeacherActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_teacher);

        final SharedPreferences mpreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);

        MyDbHelper myDbHelper = new MyDbHelper(this);

        String userSpecialite = myDbHelper.findSpecialite(mpreferences.getLong("user_specialite_id",-1)).getNom();


        // declaring variables

        final CardView logOut, addCourse, validateTest, inbox, studentsList;
        final TextView nom,prenom,specialite;


        // setting views

        logOut = findViewById(R.id.log_out);
        addCourse = findViewById(R.id.add_cour);
        validateTest = findViewById(R.id.validate_test);
        inbox = findViewById(R.id.inbox);
        studentsList = findViewById(R.id.student_list);
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        specialite = findViewById(R.id.specialite);


        // setting variables

        nom.setText(mpreferences.getString("user_nom",null));
        prenom.setText(mpreferences.getString("user_prenom",null));
        specialite.setText(userSpecialite);

        // setting listners

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TeacherActivity.this,AddCourseActivity.class);

                startActivity(intent);

            }
        });

        validateTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent intent = new Intent(TeacherActivity.this,ValidateTestActivity.class);

               // startActivity(intent);



            }
        });

        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TeacherActivity.this,InboxActivity.class);

                startActivity(intent);

            }
        });

        studentsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //   Intent intent = new Intent(TeacherActivity.this,StudentListActivity.class);

              //  startActivity(intent);

            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
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


                Intent intent = new Intent(TeacherActivity.this,LoginActivity.class);

                startActivity(intent);

                TeacherActivity.this.finish();

            }
        });

    }
}
