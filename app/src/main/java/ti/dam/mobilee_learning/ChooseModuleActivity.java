package ti.dam.mobilee_learning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChooseModuleActivity extends AppCompatActivity {

    boolean viewPressed = false;
    Long viewId, module_id;
    String module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_module);


        final Button nextBtn = findViewById(R.id.nextBtn);


        final SharedPreferences mpreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);

        final MyDbHelper myDbHelper = new MyDbHelper(ChooseModuleActivity.this);

        final long specialite_user = mpreferences.getLong("user_specialite_id",-1);

        final int inscriptionNumber = mpreferences.getInt("inscription_number",0);

        final ArrayList<Module> modules = myDbHelper.findAllModules(specialite_user);

        final ModuleAdapter moduleAdapter = new ModuleAdapter(ChooseModuleActivity.this,modules);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(moduleAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (!viewPressed) {

                    view.setBackgroundColor(Color.parseColor("#32CD32"));

                    viewPressed = true;

                    viewId = moduleAdapter.getItemId(position);

                    module = moduleAdapter.getItem(position).getAccronym();

                    module_id = moduleAdapter.getItem(position).getId();


                } else {

                    if (moduleAdapter.getItemId(position) == viewId){

                        view.setBackgroundColor(Color.parseColor("#FFFFFF"));

                        viewPressed = false;

                    }

                }
            }


        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (module == null){

                    Toast.makeText(ChooseModuleActivity.this, "please choose your module", Toast.LENGTH_SHORT).show();
                }else{

                    Personne personne = myDbHelper.findPersonne(inscriptionNumber);

                    personne.setModule(module);

                    myDbHelper.updatePersonne(personne);

                    SharedPreferences.Editor editor = mpreferences.edit();

                    editor.putString("user_module", personne.getModule());

                    editor.putLong("user_module_id", module_id);

                    editor.apply();

                    Intent intent = new Intent(ChooseModuleActivity.this,TeacherActivity.class);

                    startActivity(intent);

                    ChooseModuleActivity.this.finish();
                }

            }
        });
    }
}
