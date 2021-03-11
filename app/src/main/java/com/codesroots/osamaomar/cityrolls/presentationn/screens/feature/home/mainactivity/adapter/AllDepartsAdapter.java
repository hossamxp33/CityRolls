package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainactivity.adapter;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.codesroots.osamaomar.cityrolls.R;
import com.codesroots.osamaomar.cityrolls.entities.Category;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productfragment.ProductsFragment;

import java.util.List;

import static com.codesroots.osamaomar.cityrolls.entities.names.CAT_ID;
import static com.codesroots.osamaomar.cityrolls.entities.names.CAT_TYPE;
import static com.codesroots.osamaomar.cityrolls.entities.names.SUBCATES_NAME;

public class AllDepartsAdapter extends RecyclerView.Adapter<AllDepartsAdapter.ViewHolder>  {

    private Context context;
    private List<Category> categories;

    public AllDepartsAdapter(Context mcontext, List<Category> category) {
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

        holder.subDeparts.setAdapter(new AllSubDepartsAdapter(context,categories.get(position).getItems()));
        holder.text.setOnClickListener(v -> {

            if (!categories.get(position).getItems().isEmpty()) {

                if (holder.subDeparts.getVisibility() == View.VISIBLE) {
                    holder.subDeparts.setVisibility(View.GONE);
                    holder.text.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.plus, 0);
                } else {
                    holder.subDeparts.setVisibility(View.VISIBLE);
                    holder.text.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.minus, 0);
                }
            }else {
                Bundle bundle = new Bundle();
                bundle.putInt(CAT_ID,categories.get(position).getId());
                bundle.putString(SUBCATES_NAME,categories.get(position).getName());
                bundle.putInt(CAT_TYPE,0);
                Fragment fragment  = new ProductsFragment();
                fragment.setArguments(bundle);
                ((FragmentActivity)context)
                        .getSupportFragmentManager()
                        .beginTransaction().replace(R.id.mainfram,fragment)
                        .addToBackStack(null).commit();
                ((MainActivity)context).drawer.closeDrawer(GravityCompat.START);;


            }
        });

        holder.text.setText(categories.get(position).getName());
        if (categories.get(position).getItems().isEmpty()) {
            holder.text.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,0);



        }
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