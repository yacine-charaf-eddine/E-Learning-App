package ti.dam.mobilee_learning;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CommentAdapter extends ArrayAdapter<Comment> {


    public CommentAdapter(Context context, ArrayList<Comment> comments){
        super(context,0,comments);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.comment_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Comment comment = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nom = (TextView) listItemView.findViewById(R.id.nom);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nom.setText(comment.getNom());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView prenom = (TextView) listItemView.findViewById(R.id.prenom);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        prenom.setText(comment.getPrenom());


        TextView commentTxt = listItemView.findViewById(R.id.commentTxt);

        commentTxt.setText(comment.getComment());

        TextView userType = listItemView.findViewById(R.id.userType);

        userType.setText(comment.getUserType());

        TextView time = listItemView.findViewById(R.id.commentTime);

        time.setText(comment.getDate());


        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView


        return listItemView;

    }
}
