package ti.dam.mobilee_learning;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapterTest extends RecyclerView.Adapter<ModuleAdapterTest.MyViewHolder>  {

    private ArrayList<Module> modules;

    private View.OnClickListener onItemClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout relativeLayout;

        public TextView accronyme;

        public MyViewHolder(View view) {

            super(view);

            view.setTag(this);

            view.setOnClickListener(onItemClickListener);

            relativeLayout = (RelativeLayout) view.findViewById(R.id.relative_test);

            accronyme = (TextView) view.findViewById(R.id.accronyme_module_test);
        }
    }

    public ModuleAdapterTest (ArrayList<Module> modules){
        this.modules = modules;
    }

    public ModuleAdapterTest.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_module_test, parent, false);
        MyViewHolder vh = new MyViewHolder(itemView);
        return vh;

    }

    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final Module module = modules.get(position);

        holder.relativeLayout.setBackgroundResource(module.getBackground());

        holder.accronyme.setText(module.getAccronym());


    }

    public int getItemCount() {
        return modules.size();
    }

    public void setItemClickListener(View.OnClickListener clickListener) {
        onItemClickListener = clickListener;
    }


}
