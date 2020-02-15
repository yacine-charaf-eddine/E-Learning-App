package ti.dam.mobilee_learning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ModulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        final SharedPreferences mpreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);

        MyDbHelper myDbHelper = new MyDbHelper(ModulesActivity.this);

        final long specialite_user = mpreferences.getLong("user_specialite_id",-1);

        final ArrayList<Module> modules = myDbHelper.findAllModules(specialite_user);

        final ModuleAdapter moduleAdapter = new ModuleAdapter(ModulesActivity.this,modules);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(moduleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ModulesActivity.this, CourActivity.class);

                intent.putExtra("module",moduleAdapter.getItem(position));

                startActivity(intent);

            }
        });

    }

}
