package ti.dam.mobilee_learning;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class InboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        final SharedPreferences mpreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);

        final long id_student = mpreferences.getLong("user_id",0);

        final String nom = mpreferences.getString("user_nom","null");

        final String prenom = mpreferences.getString("user_prenom","null");

        final String user_type = mpreferences.getString("user_type","null");

        final MyDbHelper myDbHelper = new MyDbHelper(InboxActivity.this);

        ArrayList<Message> messages = myDbHelper.findAllMessagesByStudent(id_student);

        final MessageAdapter messageAdapter = new MessageAdapter(InboxActivity.this,messages,nom,prenom,id_student,user_type);

        ListView listView = findViewById(R.id.listMessages);

        listView.setAdapter(messageAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final AlertDialog.Builder builder;

                builder = new AlertDialog.Builder(InboxActivity.this);

                builder.setTitle(messageAdapter.getItem(position).getNomSender()

                        +" "+messageAdapter.getItem(position).getPrenomSender()
                )
                        .setMessage(messageAdapter.getItem(position).getObjet()
                                +"\n" +
                                messageAdapter.getItem(position).getMessage())

                        .setPositiveButton("cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();
                            }
                        })
                        .setIcon(R.drawable.check)
                        .show();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Message> messages = myDbHelper.findAllMessagesByStudent(id_student);

                final MessageAdapter messageAdapter = new MessageAdapter(InboxActivity.this,messages,nom,prenom,id_student,user_type);

                ListView listView = findViewById(R.id.listMessages);

                listView.setAdapter(messageAdapter);

            }
        });

    }
}
