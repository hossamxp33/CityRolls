package com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.Sidemenu;
import java.util.List;

public class AllDepartsAdapter extends RecyclerView.Adapter<AllDepartsAdapter.ViewHolder>  {

    private Context context;
    private List<Sidemenu.CategoryBean> categories;

    public AllDepartsAdapter(Context mcontext, List<Sidemenu.CategoryBean> category) {
        context = mcontext;
        categories = category;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.depart_item_in_navigation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.subDeparts.setAdapter(new AllSubDepartsAdapter(context,categories.get(position).getSubcats()));
        holder.text.setText(categories.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        private TextView text;
        private RecyclerView subDeparts;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            subDeparts = mView.findViewById(R.id.subdeparts);
            text = mView.findViewById(R.id.name);
        }
    }
}