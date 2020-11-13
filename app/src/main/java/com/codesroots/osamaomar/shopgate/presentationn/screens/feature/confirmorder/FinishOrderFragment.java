package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.confirmorder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.myorders.MyOrdersFragment;
import java.util.Objects;

public class FinishOrderFragment extends Fragment {
    public FinishOrderFragment() {
        // Required empty public constructor
    }

    TextView gotodelivery;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.first_finish_order, container, false);
        ((MainActivity)Objects.requireNonNull(getActivity())).head_title.setText(getText(R.string.finish_order));
        gotodelivery = view.findViewById(R.id.gotodelivery);
        gotodelivery.setOnClickListener(v ->
         getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new MyOrdersFragment()).addToBackStack(null).commit()
        );
        return view;
    }


}
