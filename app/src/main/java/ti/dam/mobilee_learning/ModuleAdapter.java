package ti.dam.mobilee_learning;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {


    public ModuleAdapter(Activity context, ArrayList<Module> modules){

        super(context,0,modules);

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_module, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
         final Module module = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView moduleName = (TextView) listItemView.findViewById(R.id.name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        moduleName.setText(module.getName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView moduleAccroname = (TextView) listItemView.findViewById(R.id.accronyme);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        moduleAccroname.setText(module.getAccronym());

        ImageView dots = listItemView.findViewById(R.id.dots);

        dots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder;

                builder = new AlertDialog.Builder(getContext());

                builder.setTitle(module.getName())
                        .setMessage(module.getDescription())
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                }).show();
            }
        });


        RelativeLayout relative = (RelativeLayout) listItemView.findViewById(R.id.relative);

        relative.setBackgroundResource(module.getBackground());

        TextView credit = listItemView.findViewById(R.id.nbrCredit);

        credit.setText(String.valueOf(String.valueOf(module.getCredit())));


        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

