package ti.dam.mobilee_learning;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CourAdapterTest extends ArrayAdapter<Week> {

    public CourAdapterTest(Context context, ArrayList<Week> weeks){

        super(context,0,weeks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        MyDbHelper myDbHelper = new MyDbHelper(getContext());

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_cour_test, parent, false);
        }

        Week week = getItem(position);

        final Course course = myDbHelper.findCour(week.getId());



        TextView numCour = (TextView) listItemView.findViewById(R.id.cour_number);

        numCour.setText(course.getType());


        TextView nomCour = listItemView.findViewById(R.id.cour_nom);

        nomCour.setText(course.getName());

        LinearLayout img_test = listItemView.findViewById(R.id.img_test);

        img_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),TestActivity.class);

                Bundle bundle = new Bundle();

                bundle.putLong("id_cour",course.getId());

                bundle.putLong("id_module",course.getId_module());

                intent.putExtras(bundle);

                getContext().startActivity(intent);


            }
        });


        return listItemView;

    }
}
