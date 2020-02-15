package ti.dam.mobilee_learning;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChooseTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_test);

        final SharedPreferences mpreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);

        final MyDbHelper myDbHelper = new MyDbHelper(ChooseTestActivity.this);

        final long specialite_user = mpreferences.getLong("user_specialite_id",-1);

        final ArrayList<Module> modules = myDbHelper.findAllModules(specialite_user);

        final ModuleAdapterTest moduleAdapterTest = new ModuleAdapterTest(modules);

        RecyclerView recyclerView = findViewById(R.id.recycle);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(moduleAdapterTest);

        moduleAdapterTest.setItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();

                Module module = modules.get(viewHolder.getAdapterPosition());

                ArrayList<Week> weeks = myDbHelper.findAllWeeks(module.getId());

                CourAdapterTest courAdapterTest = new CourAdapterTest(ChooseTestActivity.this,weeks);

                ListView listView = findViewById(R.id.list_test);

                listView.setAdapter(courAdapterTest);
            }
        });

    }
}
