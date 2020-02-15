package ti.dam.mobilee_learning;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {

        CDT.cancel();

        final AlertDialog.Builder builder;

        builder = new AlertDialog.Builder(TestActivity.this);

        builder.setTitle("Warning !!")
                .setMessage("you can't go back once you started\n you must finish your tast")
                .setPositiveButton("cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        CDT.start();

                        dialog.cancel();

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    int nbrOfQeustion;
    CountDownTimer CDT;

    TextView timer;
    TextView question;
    TextView propo1;
    TextView propo2;
    TextView propo3;
    TextView total_nbr_question;
    TextView nbr_question;
    TextView points;
    RadioGroup propositions;
    RadioButton answer;

    MyDbHelper myDbHelper;

    ArrayList<Qcm> qcms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final SharedPreferences mpreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);

        long id_student = mpreferences.getLong("user_id",0);

        timer = findViewById(R.id.time);
        question = findViewById(R.id.question);
        propo1 = findViewById(R.id.radio_prop1);
        propo2 = findViewById(R.id.radio_prop2);
        propo3 = findViewById(R.id.radio_prop3);
        total_nbr_question = findViewById(R.id.total_nbr_questions);
        nbr_question = findViewById(R.id.nbr_question);
        points = findViewById(R.id.points);
        propositions = findViewById(R.id.propositions);

        myDbHelper = new MyDbHelper(this);

        final Button next_btn = findViewById(R.id.next_btn);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        long id_cour = bundle.getLong("id_cour");

        long id_module = bundle.getLong("id_module");

        qcms = myDbHelper.findAllQcms(id_cour,id_module);


        if (qcms.size()>0){

              nbrOfQeustion = 0;

              final Test test = new Test();

              final String[] answers = new String[3];

              test.setIdCourse(id_cour);

              test.setIdModule(id_module);

              test.setIdQcm(qcms.get(nbrOfQeustion).getId());

              test.setIdStudent(id_student);

        AlertDialog.Builder builder;

        builder = new AlertDialog.Builder(TestActivity.this);

        builder.setTitle("Be careful !!")
                .setMessage("you only have 20 seconds for each question in order to answer, if you dont answer a null answer will be selected\n good luck ;)")
                .setPositiveButton("Start Test", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        startQcm();

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = findViewById(propositions.getCheckedRadioButtonId());

                if (answer == null){

                    Toast.makeText(TestActivity.this, "please choose an answer", Toast.LENGTH_SHORT).show();
                }else{

                    if (nbrOfQeustion < qcms.size()){

                        if (answer.getText().toString().equals("")){

                            answers[nbrOfQeustion] = "aucune reponse";

                        }else {

                            answers[nbrOfQeustion] = answer.getText().toString();
                        }

                        CDT.cancel();

                        startQcm();

                    }else {

                        CDT.cancel();

                        test.setAnswers(answers);

                        myDbHelper.addTest(test);

                        AlertDialog.Builder builder;

                        builder = new AlertDialog.Builder(TestActivity.this);

                        builder.setTitle("Good Job !!")
                                .setMessage("you just finished your test\n qeep up the good work ;)")
                                .setPositiveButton("Finish", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {


                                        TestActivity.this.finish();

                                    }
                                })
                                .setIcon(R.drawable.check)
                                .show();
                    }
                }

                nbrOfQeustion++;
            }
        });
        }else {

            AlertDialog.Builder builder;

            builder = new AlertDialog.Builder(TestActivity.this);

            builder.setTitle("(-_-)")
                    .setMessage("there is no test for this course\n comme back later.")
                    .setPositiveButton("Finish", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {


                            TestActivity.this.finish();

                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }

    }

    public void startQcm(){

        total_nbr_question.setText(String.valueOf(qcms.size()));

        nbr_question.setText(String.valueOf(nbrOfQeustion + 1));

        question.setText(qcms.get(nbrOfQeustion).getQuestion());

        propo1.setText(qcms.get(nbrOfQeustion).getProp1());

        propo2.setText(qcms.get(nbrOfQeustion).getProp2());

        propo3.setText(qcms.get(nbrOfQeustion).getProp3());

        CDT = new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {

                if (millisUntilFinished / 1000 >= 10) {

                    timer.setTextColor(Color.parseColor("#32CD32"));

                    points.setTextColor(Color.parseColor("#32CD32"));

                } else if (millisUntilFinished / 1000 > 5) {

                    timer.setTextColor(Color.parseColor("#FFC107"));

                    points.setTextColor(Color.parseColor("#FFC107"));

                } else {

                    timer.setTextColor(Color.parseColor("#D32F2F"));

                    points.setTextColor(Color.parseColor("#D32F2F"));

                }

                timer.setText("" + millisUntilFinished / 1000);

            }

            public void onFinish() {
                timer.setText("done!");
            }

        }.start();
    }

}
