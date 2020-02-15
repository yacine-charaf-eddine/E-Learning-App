package ti.dam.mobilee_learning;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CourAdapter extends ArrayAdapter<Week> {

    public CourAdapter(Context context, ArrayList<Week> weeks){

        super(context,0,weeks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        MyDbHelper myDbHelper = new MyDbHelper(getContext());

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_cour, parent, false);
        }

         Week week = getItem(position);

        final Course course = myDbHelper.findCour(week.getId());

        TextView courTxt,commentTxt;

        courTxt = listItemView.findViewById(R.id.eyeTxt);

        courTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = course.getLink();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try {
                    if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                        v.getContext().startActivity(intent);
                    }
                } catch (ActivityNotFoundException ex) {

                    intent.setPackage(null);
                    if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                        v.getContext().startActivity(intent);
                    }
                }
            }
        });

        commentTxt = listItemView.findViewById(R.id.commentTxt);

        commentTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CommentDialog commentDialog = new CommentDialog(getContext(),course.getType(),course.getName());
                commentDialog.show();
            }
        });

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView numCour = (TextView) listItemView.findViewById(R.id.numCour);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        numCour.setText(course.getType());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView beginDate = (TextView) listItemView.findViewById(R.id.dateDebut);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        beginDate.setText(week.getBeginDate());

        TextView endDate = (TextView) listItemView.findViewById(R.id.dateFin);

        endDate.setText(week.getEndDate());

/*
        RelativeLayout relative = (RelativeLayout) listItemView.findViewById(R.id.relative);

        relative.setBackgroundResource(module.getBackground());
        */


        TextView nomCour = listItemView.findViewById(R.id.name);

        nomCour.setText(course.getName());


        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
