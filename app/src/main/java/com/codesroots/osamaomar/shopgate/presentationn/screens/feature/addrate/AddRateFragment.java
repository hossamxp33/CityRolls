package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.addrate;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;

import static com.codesroots.osamaomar.shopgate.entities.names.PRODUCT_ID;
import static com.codesroots.osamaomar.shopgate.entities.names.PRODUCT_NAME;
import static com.codesroots.osamaomar.shopgate.entities.names.PRODUCT_PHOTO;


public class AddRateFragment extends Fragment {

    private AddRateViewModel mViewModel;
    private int product_id;
    private String product_photo,product_name;
    private ImageView productphoto;
    private TextView addRate,product_of;
    private FrameLayout progress;
    private RatingBar ratingBar;
    private EditText comment;
    private int userid = PreferenceHelper.getUserId(); // TODO change userid : 20/03/2019


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_rate_fragment, container, false);
        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(AddRateViewModel.class);
        addRate = view.findViewById(R.id.ratesend);
        ratingBar = view.findViewById(R.id.ratingBar);
        comment = view.findViewById(R.id.ratecomment);
        progress = view.findViewById(R.id.progress);
        product_of = view.findViewById(R.id.product_of);
        product_id = getArguments().getInt(PRODUCT_ID, 0);
        product_photo = getArguments().getString(PRODUCT_PHOTO);
        product_name = getArguments().getString(PRODUCT_NAME);
        productphoto = view.findViewById(R.id.item_rateimg);
        product_of.setText(product_of.getText().toString()+" "+product_name);
        Glide.with(getActivity()).load(product_photo).placeholder(R.drawable.product).dontAnimate().into(productphoto);

        mViewModel.AddRateMutableLiveData.observe(getActivity(), addRateResonse ->
                {
                    addRate.setText(getText(R.string.sendrate));
                    addRate.setEnabled(true);
                    if (addRateResonse)
                    { Toast.makeText(getActivity(),getText(R.string.addratesuccess),Toast.LENGTH_SHORT).show();
                        getActivity().getSupportFragmentManager().popBackStack();

                    }
                    else
                        Toast.makeText(getActivity(),getText(R.string.error_tryagani),Toast.LENGTH_SHORT).show();
                }
        );

        mViewModel.throwableMutableLiveData.observe(getActivity(), throwable -> {
            addRate.setText(getText(R.string.sendrate));
            addRate.setEnabled(true);
            Toast.makeText(getActivity(),throwable.toString(),Toast.LENGTH_SHORT).show();
        });


        addRate.setOnClickListener(v -> {
            if (!comment.getText().toString().matches("")) {
                mViewModel.AddRateToProduct(userid, product_id, ratingBar.getRating(), comment.getText().toString());
                addRate.setText(getText(R.string.wait));
                addRate.setEnabled(false);
            }
            else
                comment.setError(getText(R.string.addcomment));
        });

        return view;
    }

    private AddRatesViewModelFactory getViewModelFactory() {
        return new AddRatesViewModelFactory(getActivity().getApplication());
    }

}
