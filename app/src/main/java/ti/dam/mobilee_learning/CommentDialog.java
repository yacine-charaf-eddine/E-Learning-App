package ti.dam.mobilee_learning;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CommentDialog extends Dialog {

    private String typeCour,nomCour;
    private Context context;

    public CommentDialog(Context context, String typeCour, String nomCour){
        super(context);
        this.typeCour = typeCour;
        this.nomCour = nomCour;
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_dialog);

        final MyDbHelper myDbHelper = new MyDbHelper(context);

        final SharedPreferences mpreferences = context.getSharedPreferences("Login",Context.MODE_PRIVATE);

        final String nom,prenom;

        final long id;

        nom = mpreferences.getString("user_nom","null");
        prenom = mpreferences.getString("user_prenom","null");
        id = mpreferences.getLong("user_id",0);

        final ArrayList<Comment> comments = myDbHelper.findAllComments(nomCour,typeCour);

        final CommentAdapter commentAdapter = new CommentAdapter(context,comments);

        ListView commentsList = findViewById(R.id.listComment);

        commentsList.setAdapter(commentAdapter);

        TextView courTxt = findViewById(R.id.courTxt);

        courTxt.setText(typeCour);

        Button post = findViewById(R.id.post);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText commentTxt = findViewById(R.id.comment);

                String commentValue = commentTxt.getText().toString();

                commentTxt.setText("");

                if(commentValue.equals("")){

                    Toast.makeText(context, "Please write a comment first", Toast.LENGTH_SHORT).show();

                }else{

                    Date currentTime = Calendar.getInstance().getTime();

                    SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy HH:mm");

                    String time = df.format(currentTime);

                    Comment comment = new Comment();

                    comment.setDate(time);
                    comment.setNomCour(nomCour);
                    comment.setTypeCour(typeCour);
                    comment.setNom(nom);
                    comment.setPrenom(prenom);
                    comment.setId_Personne(id);
                    comment.setUserType(mpreferences.getString("user_type","null"));
                    comment.setComment(commentValue);

                    Long id = myDbHelper.addComment(comment);

                    if (id!=-1){

                        comments.add(comment);

                        commentAdapter.notifyDataSetChanged();

                    }else {
                        Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}
