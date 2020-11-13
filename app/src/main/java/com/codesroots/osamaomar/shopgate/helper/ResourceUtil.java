package com.codesroots.osamaomar.shopgate.helper;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.codesroots.osamaomar.shopgate.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static android.content.ContentValues.TAG;

public class ResourceUtil {
    private static Locale myLocale;

    private static String[] STORAGE_PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private static String[] CALL_PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    private static String[] CALL_PERMISSIONS1 = {
            Manifest.permission.CALL_PHONE
    };


//    public static void showAlertCall(final Context context, final String number) {
//        try {
//            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(context);
//            dlgAlert.setMessage(number);
//            dlgAlert.setTitle(context.getString(R.string.pop_call_title));
//            dlgAlert.setPositiveButton(context.getString(R.string.pop_call_call), new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    callNumber(number, context);
//                }
//            });
//            dlgAlert.setNegativeButton(context.getString(R.string.pop_cancel), null);
//            dlgAlert.setCancelable(true);
//            dlgAlert.create().show();
//        } catch (Exception e) {
//            Log.v("ERROR", e.getMessage());
//        }
//    }


    public static void openWhatsApp(String smsNumber,Context context,Activity activity) {
//        Intent sendIntent = new Intent(Intent.ACTION_SEND);
////        sendIntent.setType("text/plain");
////        sendIntent.putExtra(Intent.EXTRA_TEXT,context.getResources().getString(R.string.sendreq));
////        sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
////        sendIntent.setPackage("com.whatsapp");
////        if (sendIntent.resolveActivity(context.getPackageManager()) == null) {
////            Toast.makeText(context, "Error/n" , Toast.LENGTH_SHORT).show();
////            return;
////        }
////        context.startActivity(sendIntent);


        if (!contactExists(context,smsNumber))
        {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
            builder1.setMessage(context.getString(R.string.notexists));
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    context.getResources().getString(R.string.register),
                    (dialog, id) -> {
                        Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
                        contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                        contactIntent.putExtra(ContactsContract.Intents.Insert.NAME, context.getString(R.string.app_name))
                                .putExtra(ContactsContract.Intents.Insert.PHONE, smsNumber);
                        activity.startActivityForResult(contactIntent, 1);
                        dialog.cancel();
                    });

            builder1.setNegativeButton(
                    context.getResources().getString(R.string.no),
                    (dialog, id) -> dialog.cancel());
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
        else
            openWhats(context,smsNumber.substring(1));
    }

    public static boolean  contactExists(Context context, String number) {

        Uri lookupUri = Uri.withAppendedPath(
                ContactsContract.PhoneLookup.CONTENT_FILTER_URI,
                Uri.encode(number));
        String[] mPhoneNumberProjection = { ContactsContract.PhoneLookup._ID, ContactsContract.PhoneLookup.NUMBER, ContactsContract.PhoneLookup.DISPLAY_NAME };
        Cursor cur = context.getContentResolver().query(lookupUri,mPhoneNumberProjection, null, null, null);
        try {
            if (cur.moveToFirst()) {
                return true;
            }
        } finally {
            if (cur != null)
                cur.close();
        }
        return false;
    }

    private static void openWhats(Context context, String smsNumber) {
       // String smsNumber = "95597021"; // E164 format without '+' sign
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, context.getString(R.string.send));
        sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
        sendIntent.setPackage("com.whatsapp");
        if (sendIntent.resolveActivity(context.getPackageManager()) == null) {
            Toast.makeText(context, "Error/n" , Toast.LENGTH_SHORT).show();
            return;
        }
        context.startActivity(sendIntent);
    }
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Log.d(TAG, "isNetworkAvailable: True");
            return true;
        }
        Log.d(TAG, "isNetworkAvailable: False");
        return false;
    }

    public static void shareText(Context context, String text) {

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");// Plain format text

        sharingIntent.putExtra(Intent.EXTRA_TEXT, text);
        context.startActivity(Intent.createChooser(sharingIntent, "Share Text Using " +
                context.getString(R.string.app_name)));
    }


    public static void hideKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    public static void changeLang(String lang, Context context) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        saveLocale(lang, context);
    //    if (!mOld.equals(lang)) {
//            Intent i = getPackageManager()
//                    .getLaunchIntentForPackage(getPackageName());
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(i);
    //    }
    }


    public static void saveLocale(String lang, Context context) {
        String langPref = context.getPackageName() + "App_Language";
        SharedPreferences prefs = context.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }


    public static String getCurrentLanguage(Context context) {
        String langPref = context.getPackageName() + "App_Language";
        SharedPreferences prefs = context.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        String old = prefs.getString(langPref, "ar");
        return old;
    }


//    public static void changeMenuFont(NavigationView navigationView, Context context) {
//        Menu m = navigationView.getMenu();
//        for (int i = 0; i < m.size(); i++) {
//            MenuItem mi = m.getItem(i);
//
//            //for aapplying a font to subMenu ...
//            SubMenu subMenu = mi.getSubMenu();
//            if (subMenu != null && subMenu.size() > 0) {
//                for (int j = 0; j < subMenu.size(); j++) {
//                    MenuItem subMenuItem = subMenu.getItem(j);
//                    applyFontToMenuItem(subMenuItem, context);
//                }
//            }
//
//            //the method we have create in activity
//            applyFontToMenuItem(mi, context);
//
//        }
//
//    }


//    private static void applyFontToMenuItem(MenuItem mi, Context context) {
//        Typeface font = Typeface.createFromAsset(context.getAssets(), "font.ttf");
//        SpannableString mNewTitle = new SpannableString(mi.getTitle());
//        mNewTitle.setSpan(new CustomTypefaceSpan("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        mi.setTitle(mNewTitle);
//    }


    public static void setTapFont(TabLayout tabLayout, Context context) {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();

        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);

            int tabChildsCount = vgTab.getChildCount();

            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {

                    ((TextView) tabViewChild).setTypeface(Typeface.createFromAsset(context.getAssets(), "font.ttf"));
                    ((TextView) tabViewChild).setTextSize(8.0f);
                    ((TextView) tabViewChild).setGravity(Gravity.BOTTOM);
                    ((TextView) tabViewChild).setPadding(0, 8, 0, 0);
                }
            }
        }
    }


    public static void setSpinnerCustomAdubter(Spinner spinner, ArrayList<String> list, int layId, Context context) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                context.getApplicationContext(), layId, list);
        adapter.setDropDownViewResource(layId);
        spinner.setAdapter(adapter);
    }


    public static void callNumber(String number, Context context) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        context.startActivity(callIntent);
    }




    public static void verifyPermissions(Activity context) {
        int permissionCall = ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionExternal = ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION);

        if (permissionCall != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context,
                    CALL_PERMISSIONS,
                    0);
        }


        if (permissionExternal != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context,
                    CALL_PERMISSIONS,
                    0);
        }

    }

    public static void verifyPermissions1(Activity context) {
        int permissionCall = ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE);
        // int permissionExternal = ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionCall != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context,
                    CALL_PERMISSIONS1,
                    1);
        }

    }

//    public static void changebottomnavagationFont(BottomNavigationView navigationView, Context context) {
//        Menu m = navigationView.getMenu();
//        for (int i = 0; i < m.size(); i++) {
//            MenuItem mi = m.getItem(i);
//
//            //for aapplying a font to subMenu ...
//            SubMenu subMenu = mi.getSubMenu();
//            if (subMenu != null && subMenu.size() > 0) {
//                for (int j = 0; j < subMenu.size(); j++) {
//                    MenuItem subMenuItem = subMenu.getItem(j);
//                    applyFontToMenuItem(subMenuItem, context);
//                }
//            }
//
//            //the method we have create in activity
//            applyFontToMenuItem(mi, context);
//
//        }
//
//    }


    public static boolean getNotification(Context c) {
        String notiPref = "App_Notification1";
        SharedPreferences prefs = c.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        boolean isLogin = prefs.getBoolean(notiPref, true);
        return isLogin;
    }

    public static void saveNotification(boolean val, Context c) {
        String notiPref = "App_Notification1";
        SharedPreferences prefs = c.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(notiPref, val);
        editor.commit();
    }


    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    public static String getDate(long timeStamp) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "xx";
        }
    }

    public static String getCompleteDate(long timeStamp) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH);
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "xx";
        }
    }


    public static void saveToken(String token, Context context) {
        String langPref = context.getPackageName() + "Token";
        SharedPreferences prefs = context.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, token);
        editor.commit();
    }


    public static String getToken(Context context) {
        String langPref = context.getPackageName() + "Token";
        SharedPreferences prefs = context.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        String old = prefs.getString(langPref, "");
        return old;
    }


//    public static void showAlertLogin(final BaseActivity context) {
//        try {
//            final AlertDialog.Builder dlgAlert = new AlertDialog.Builder(context);
//            dlgAlert.setMessage(context.getString(R.string.showlogin));
//            dlgAlert.setTitle(context.getString(R.string.M_title));
//            dlgAlert.setCancelable(false);
//            dlgAlert.setPositiveButton(context.getString(R.string.M_go), new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Intent intent = new Intent(context, LoginActivity.class);
//                    context.startActivityForResult(intent, 1);
//                }
//            });
//            dlgAlert.setNegativeButton(context.getString(R.string.M_no), new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//
//
//                }
//            });
//
//            dlgAlert.create().show();
//        } catch (Exception e) {
//            Log.v("ERROR", e.getMessage());
//        }
//
//
//    }


//    public static void showAlertLogout(final BaseActivity activity) {
//        try {
//            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(activity);
//            dlgAlert.setMessage(activity.getString(R.string.pop_logout_message));
//            dlgAlert.setTitle(activity.getString(R.string.pop_logout));
//            dlgAlert.setPositiveButton(activity.getString(R.string.pop_logout), new DialogInterface.OnClickListener() {
//                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    SharedPrefManager.getInstance(activity).logout();
//                    activity.finishAffinity();
//                    activity.startActivity(new Intent(activity, MainActivity.class));
//                }
//            });
//            dlgAlert.setNegativeButton(activity.getString(R.string.pop_cancel), null);
//            dlgAlert.setCancelable(true);
//            dlgAlert.create().show();
//        } catch (Exception e) {
//            Log.v("ERROR", e.getMessage());
//        }
//    }


    public static void saveRegionId(int id, Context context) {
        String langPref = "regionId";
        SharedPreferences prefs = context.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(langPref, id);
        editor.commit();
    }


    public static int getRegionId(Context context) {
        String langPref = "regionId";
        SharedPreferences prefs = context.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        int id = prefs.getInt(langPref, 0);
        return id;
    }


    public static void saveResturantId(int id, Context context) {
        String langPref = "ResturantId";
        SharedPreferences prefs = context.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(langPref, id);
        editor.commit();
    }


    public static int getResturantId(Context context) {
        String langPref = "ResturantId";
        SharedPreferences prefs = context.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        int id = prefs.getInt(langPref, 0);
        return id;
    }


    public static void saveRegionName(String name, Context context) {
        String langPref = "RegionName";
        SharedPreferences prefs = context.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, name);
        editor.commit();
    }


    public static String getRegionName(Context context) {
        String langPref = "RegionName";
        SharedPreferences prefs = context.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        String name = prefs.getString(langPref, "");
        return name;
    }

}