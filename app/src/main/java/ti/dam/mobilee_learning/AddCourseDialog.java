package ti.dam.mobilee_learning;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AddCourseDialog extends Dialog{

    private long idModule;
    private DatePickerDialog.OnDateSetListener BeginDateSetListener;
    private DatePickerDialog.OnDateSetListener EndDateSetListener;

    public AddCourseDialog(Context context, long idModule){

        super(context);

        this.idModule = idModule;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_course);

        // declaring variables

        final TextView beginDate,endDate;
        final Button addBtn;
        final EditText name,link;

        final MyDbHelper myDbHelper = new MyDbHelper(getContext());

        final ArrayList<Week> weeks =  myDbHelper.findAllWeeks(idModule);


        // assigning views to variables

        beginDate = findViewById(R.id.beginValue);
        endDate = findViewById(R.id.endValue);
        addBtn = findViewById(R.id.addCourBtn);
        name = findViewById(R.id.nameValue);
        link = findViewById(R.id.linkValue);


        //setting Listners

        beginDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();

                int month = cal.get(Calendar.MONTH);

                int day = cal.get(Calendar.DAY_OF_MONTH);

                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(getContext(),android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth,BeginDateSetListener,year,month,day);


                dialog.show();
            }

        });

        BeginDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker,int year , int month, int day) {

                month = month + 1;

                String date = day + "/" + month + "/" + year ;

                beginDate.setText(date);
                beginDate.setTextColor(Color.parseColor("#000000"));
            }
        };

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();

                int month = cal.get(Calendar.MONTH);

                int day = cal.get(Calendar.DAY_OF_MONTH);

                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(getContext(),android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth,EndDateSetListener,year,month,day);


                dialog.show();
            }

        });

        EndDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker,int year , int month, int day) {

                month = month + 1;

                String date = day + "/" + month + "/" + year ;

                endDate.setText(date);
                endDate.setTextColor(Color.parseColor("#000000"));
            }
        };

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().length()==0 || link.getText().length()==0 || beginDate.getText().length()==0 || endDate.getText().length()==0){

                    Toast.makeText(getContext(), "fill missing text fields !!", Toast.LENGTH_SHORT).show();

                }else {

                    Week week = new Week();

                    int nbr = weeks.size() + 1;

                    week.setDescription("week"+nbr);
                    week.setBeginDate(beginDate.getText().toString());
                    week.setEndDate(endDate.getText().toString());
                    week.setId_module(idModule);
                    weeks.add(week);


                    Course course = new Course();

                    course.setName(name.getText().toString());
                    course.setLink(link.getText().toString());
                    course.setType("cour "+weeks.size());

                    week.getCources().add(course);

                    myDbHelper.addWeek(week,idModule);


                    AddCourseDialog.this.cancel();


                }
            }
        });


    }

}
