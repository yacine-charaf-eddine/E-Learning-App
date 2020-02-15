package ti.dam.mobilee_learning;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MessageAdapter extends ArrayAdapter<Message> {

    String nom, prenom, type;
    long id;

    public MessageAdapter(Context context, ArrayList<Message> messages, String nom, String prenom, long id, String type){

        super(context,0,messages);

        this.nom = nom;

        this.prenom = prenom;

        this.id = id;

        this.type = type;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.message_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Message message = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nomV = (TextView) listItemView.findViewById(R.id.nom);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nomV.setText(message.getNomSender());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView prenomV = (TextView) listItemView.findViewById(R.id.prenom);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        prenomV.setText(message.getPrenomSender());


        TextView module = listItemView.findViewById(R.id.module);

        module.setText(message.getModule());

        TextView object = listItemView.findViewById(R.id.objet);

        object.setText(message.getObjet());

        ImageView img = listItemView.findViewById(R.id.typeimg);

        LinearLayout linearLayout = listItemView.findViewById(R.id.replyLinear);

        try {

            if (message.getNomSender().equals(nom) && message.getPrenomSender().equals(prenom)){

                img.setImageResource(R.drawable.sent);
                linearLayout.setVisibility(View.INVISIBLE);

            }else {
                img.setImageResource(R.drawable.receved);
                linearLayout.setVisibility(View.VISIBLE);
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        MessageTo messageTo = new MessageTo(getContext(),message.getModule(),id,nom,prenom,type,message.getNomSender(),message.getPrenomSender(),message.getIdEtudiant());
                        messageTo.show();
                    }
                });


            }

        }catch (Exception e){
            Toast.makeText(getContext(), ""+e.toString(), Toast.LENGTH_SHORT).show();
        }

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView


        return listItemView;
    }
}
