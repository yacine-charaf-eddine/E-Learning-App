package ti.dam.mobilee_learning;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddCourseActivity extends Activity {

    CourAdapter courAdapter;
    ArrayList<Week> weeks;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        final MyDbHelper myDbHelper = new MyDbHelper(AddCourseActivity.this);

        final SharedPreferences mpreferences = getApplicationContext().getSharedPreferences("Login", MODE_PRIVATE);

        final long idModule = mpreferences.getLong("user_module_id", 0);

        Module module = myDbHelper.findModule(idModule);

        weeks = myDbHelper.findAllWeeks(idModule);


        courAdapter = new CourAdapter(AddCourseActivity.this, weeks);

        listView = findViewById(R.id.listCour);

        listView.setAdapter(courAdapter);

        // declaring variables

        TextView accronyme, name, credit;

        FloatingActionButton fab, refresh;

        // getting views from xml

        accronyme = findViewById(R.id.accronyme);
        name = findViewById(R.id.name);
        credit = findViewById(R.id.nbrCredit);
        fab = findViewById(R.id.fab);
        refresh = findViewById(R.id.refresh);

        // assingning values to variables

        accronyme.setText(module.getAccronym());
        name.setText(module.getName());
        credit.setText(String.valueOf(module.getCredit()));

        // setting listners

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddCourseDialog addCourseDialog = new AddCourseDialog(AddCourseActivity.this,idModule);
                addCourseDialog.show();


            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                courAdapter = null;
                weeks = myDbHelper.findAllWeeks(idModule);
                courAdapter = new CourAdapter(AddCourseActivity.this, weeks);
                listView.setAdapter(courAdapter);

            }
        });


    }

}
