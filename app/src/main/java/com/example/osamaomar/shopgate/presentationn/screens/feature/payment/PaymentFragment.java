package com.example.osamaomar.shopgate.presentationn.screens.feature.payment;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.DragAndDropPermissions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.braintreepayments.api.BraintreeFragment;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.OrderModel;
import com.example.osamaomar.shopgate.helper.AddorRemoveCallbacks;
import com.example.osamaomar.shopgate.presentationn.screens.feature.confirmorder.FinishOrderFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.MainFragment;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

import static android.app.Activity.RESULT_OK;
import static com.example.osamaomar.shopgate.entities.names.ORDER;

public class PaymentFragment extends Fragment {

    private static final  int PAYPAL_REQUEST_CODE = 7171;
    private static PayPalConfiguration configuration = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);
    ImageView paypal,cash;
    OrderModel orderModel;
    float Total ;
    PaymentViewModel paymentViewModel;
     String mAuthorization ="sandbox_tgg4p67v_6vxjwdzh2zj4q267";
    private BraintreeFragment mBraintreeFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_paypal, container, false);
        paypal = view.findViewById(R.id.paypal);
        cash = view.findViewById(R.id.cash);
        Intent intent = new Intent(getActivity(),PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,configuration);
        getActivity().startService(intent);
        orderModel = (OrderModel) getArguments().getSerializable(ORDER);
        assert orderModel != null;
        orderModel.setUser_id(5);
        for (int i = 0; i<orderModel.getOrderdetails().size(); i++)
            Total+=Float.valueOf(orderModel.getOrderdetails().get(i).getTotal());

        paypal.setOnClickListener(v -> processpayment());
        cash.setOnClickListener(v -> processCashpayment());
        paymentViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(PaymentViewModel.class);
        paymentViewModel.myOrdersMutableLiveData.observe(this, aBoolean -> {
            if (aBoolean)
            {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                for (int i1 = 0; i1 < fm.getBackStackEntryCount(); ++i1) {
                    Fragment fragment = fm.findFragmentById(R.id.mainfram);
                    if (!(fragment instanceof MainFragment))
                        fm.popBackStack();
                }
                ((AddorRemoveCallbacks)getActivity()).onClearCart();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new FinishOrderFragment()).addToBackStack(null).commit();
            }
        });
        paymentViewModel.throwableMutableLiveData.observe(this, throwable -> Snackbar.make(view,throwable.getCause().toString(),Snackbar.LENGTH_SHORT).show());
        return view;
    }


    private void processCashpayment() {

        orderModel.setType(getString(R.string.cash));
        orderModel.setPrice(String.valueOf(Total));
        sendRequest();
    }


    private void processpayment()  {

//        try {
//            mBraintreeFragment = BraintreeFragment.newInstance(getActivity(), mAuthorization);
//        } catch (InvalidArgumentException e) {
//            e.printStackTrace();
//        }
        // startActivityForResult(getDropInRequest().getIntent(this), DROP_IN_REQUEST);

        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(Total)),"USD","cairo",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(getActivity(), PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,configuration);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == PAYPAL_REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                PaymentConfirmation payPalConfiguration  = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (payPalConfiguration!=null)
                {
                    try {
                        JSONObject jsonObject = payPalConfiguration.toJSONObject();
                        String state = jsonObject.getJSONObject("response").getString("state");
                        Toast.makeText(getActivity(),state,Toast.LENGTH_SHORT).show();

                        orderModel.setType(getString(R.string.paypal));
                        orderModel.setPrice(String.valueOf(Total));
                        sendRequest();
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            else if (requestCode == Activity.RESULT_CANCELED)
                Toast.makeText(getActivity(),"Cancel",Toast.LENGTH_SHORT).show();

        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID)
            Toast.makeText(getActivity(),"Invalid",Toast.LENGTH_SHORT).show();

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void sendRequest() {
        paymentViewModel.addOrder(orderModel);
    }

    private PaymentViewModelFactory getViewModelFactory() {
        return new PaymentViewModelFactory(this.getActivity().getApplication());
    }
}
