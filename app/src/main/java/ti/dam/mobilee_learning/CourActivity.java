package ti.dam.mobilee_learning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cour);

        final SharedPreferences mpreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);

        final long id_student = mpreferences.getLong("user_id",0);

        final String nomStudent = mpreferences.getString("user_nom","null");

        final String prenomStudent = mpreferences.getString("user_prenom","null");

        final String type = mpreferences.getString("user_type","null");

        Intent intent = getIntent();

        final Module module = (Module) intent.getSerializableExtra("module");

        MyDbHelper myDbHelper = new MyDbHelper(CourActivity.this);

        ArrayList<Week> weeks = myDbHelper.findAllWeeks(module.getId());


        CourAdapter courAdapter = new CourAdapter(CourActivity.this,weeks);

        ListView listView = findViewById(R.id.listCour);

        listView.setAdapter(courAdapter);


        // declaring variables

        TextView accronyme,name,credit;

        RelativeLayout  message;

        // getting views from xml

        accronyme = findViewById(R.id.accronyme);
        name = findViewById(R.id.name);
        credit = findViewById(R.id.nbrCredit);
        message = findViewById(R.id.relativeMessage);


        // assingning values to variables

        accronyme.setText(module.getAccronym());
        name.setText(module.getName());
        credit.setText(String.valueOf(module.getCredit()));

        // setting listners

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MessageTo messageTo = new MessageTo(

                        CourActivity.this,

                        module.getAccronym(),

                        id_student,

                        nomStudent,

                        prenomStudent,

                        type);

                messageTo.show();
            }
        });
    }
}
