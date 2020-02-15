package ti.dam.mobilee_learning;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MessageTo extends Dialog{

    private String Module, nom, prenom, type, receverNom, receverPrenom;
    private long idSender, idRecever;

    public MessageTo(Context context, String Module, long idSender, String nom, String prenom, String type, String receverNom, String receverPrenom, long idRecever){

        super(context);

        this.idSender = idSender;

        this.Module = Module;

        this.nom = nom;

        this.prenom = prenom;

        this.type = type;

        this.receverNom = receverNom;

        this.receverPrenom = receverPrenom;

        this.idRecever = idRecever;
    }

    public MessageTo(Context context, String Module, long idSender, String nom, String prenom, String type){

        super(context);

        this.idSender = idSender;

        this.Module = Module;

        this.nom = nom;

        this.prenom = prenom;

        this.type = type;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_to_professor);


        final MyDbHelper myDbHelper = new MyDbHelper(getContext());

        Button send = findViewById(R.id.sendMessageBtn);

        final EditText object = findViewById(R.id.objectValue);

        final EditText message = findViewById(R.id.messageValue);

        final Spinner spinner = (Spinner) findViewById(R.id.professor_spinner);

        final ArrayList<Personne> professors = myDbHelper.findAllProfessors(Module);

        final ArrayList<String> Names;
        ArrayAdapter<String> adapter;


        if (type.equals ("student")){


             Names = new ArrayList<String>();


            for (Personne p: professors) {
                Names.add(p.getNom()+" "+p.getPrenom());
            }

            adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Names );

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);


        }else {

            Names = new ArrayList<String>();
            Names.add(receverNom+" "+receverPrenom);

            adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Names );

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);
        }







        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (spinner.getSelectedItem() == null || object.getText().length() == 0 || message.getText().length() == 0) {

                    Toast.makeText(getContext(), "please fill all the fields", Toast.LENGTH_SHORT).show();

                } else {

                    Message msg = new Message();

                    msg.setIdEtudiant(idSender);
                    msg.setObjet(object.getText().toString());
                    msg.setMessage(message.getText().toString());
                    msg.setModule(Module);
                    msg.setNomSender(nom);
                    msg.setPrenomSender(prenom);

                    if (type.equals("student")){

                        msg.setIdProfessor(professors.get(spinner.getSelectedItemPosition()).getId());

                    }else {
                        msg.setIdProfessor(idRecever);
                    }


                    long done = myDbHelper.addMessage(msg);

                    if (done == -1){
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(getContext(), "message hes been sent successfully", Toast.LENGTH_SHORT).show();

                    MessageTo.this.dismiss();

                }
            }
        });


    }
}

