package com.codesroots.osamaomar.shopgate.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class PreferenceHelper {

    private static SharedPreferences app_prefs;
    private static String app_ref = "userdetails";
    private static String photo = "photo";
    private static String Token = "token";
    private static String UserId = "userid";
    private static String FirstForCountry = "FirstForCountry";
    private static String Language = "language";
    private static String CURRENCY = "CURRENCY";
    private static String CURRENCY_ARABIC = "CURRENCY_ARABIC";
    private static String CURRENCY_VALUE = "CURRENCY_VALUE";
    private static final String USER_GROUP_ID = "USERGROUPID";
    private static final String COUNTRY_ID = "COUNTRY_ID";
    private final static String USER_NAME = "USERNAME";
    private final static String CART_ARRAY = "CART_ARRAY";
    private final static String Doller_value = "Doller_value";
    private final static String IN_OMAN = "IN_OMAN";
    private final static String OUT_OMAN = "OUT_OMAN";
    private final static String MIN_CHIPPING = "MIN_CHIPPING";

    private final static  ArrayList arrPackage = new ArrayList<>();
    private Context context;

    public PreferenceHelper(Context context) {
        this.context = context;
        try {
            app_prefs = context.getSharedPreferences(app_ref,
                    Context.MODE_PRIVATE);
        } catch (NullPointerException e) {
        }
    }

    public static void setUSER_GROUP_ID(int group) {
        Editor edit = app_prefs.edit();
        edit.putInt(USER_GROUP_ID, group);
        edit.apply();
    }

    public static void setCountryId(int countryId) {
        Editor edit = app_prefs.edit();
        edit.putInt(COUNTRY_ID, countryId);
        edit.apply();
    }

    public static void setCURRENCY_VALUE(float value) {
        Editor edit = app_prefs.edit();
        edit.putFloat(CURRENCY_VALUE, value);
        edit.apply();
    }


    public static void setFirstForCountry(Boolean value) {
        Editor edit = app_prefs.edit();
        edit.putBoolean(FirstForCountry, value);
        edit.apply();
    }

    public static void setCURRENCY(String currency) {
        Editor edit = app_prefs.edit();
        edit.putString(CURRENCY, currency);
        edit.apply();
    }

    public static void setDoller_value(float doller_value) {
        Editor edit = app_prefs.edit();
        edit.putFloat(Doller_value, doller_value);
        edit.apply();
    }


    public static void setInOman(float value) {
        Editor edit = app_prefs.edit();
        edit.putFloat(IN_OMAN, value);
        edit.apply();
    }



    public static void setMinChipping(float value) {
        Editor edit = app_prefs.edit();
        edit.putFloat(MIN_CHIPPING, value);
        edit.apply();
    }


    public static void setOutOman(float value) {
        Editor edit = app_prefs.edit();
        edit.putFloat(OUT_OMAN, value);
        edit.apply();
    }

    public static void setCURRENCYArabic(String Currencyar) {
        Editor edit = app_prefs.edit();
        edit.putString(CURRENCY_ARABIC, Currencyar);
        edit.apply();
    }

    public static float getDoller() {
        return app_prefs.getFloat(Doller_value, 1);
    }

    public static float getMIM_CHIPPING() {
        return app_prefs.getFloat(MIN_CHIPPING, 0);
    }

    public static int getCOUNTRY_ID() {
        return app_prefs.getInt(COUNTRY_ID, 1);
    }

    public static Boolean getFirstForCountry() {
        return app_prefs.getBoolean(FirstForCountry,true);
    }

    public static float getCurrencyValue() {
        return app_prefs.getFloat(CURRENCY_VALUE, 0);
    }
    public static float getIN_OMAN() {
        return app_prefs.getFloat(IN_OMAN, 0);
    }

    public static float getOUT_OMAN() {
        return app_prefs.getFloat(OUT_OMAN, 0);
    }


    public static String getCurrencyArabic() {
        return app_prefs.getString(CURRENCY_ARABIC,null);
    }

    public static String getCurrency() {
        return app_prefs.getString(CURRENCY, null);
    }




    public static void addItemtoCart(int product_id)
    {
        Set<String> set ;
        set = app_prefs.getStringSet(CART_ARRAY, null);
        if (set==null)
            set = new HashSet<String>();
        set.add(String.valueOf(product_id));
        Editor editor = app_prefs.edit();
        editor.putStringSet(CART_ARRAY, set);
        editor.apply();
    }

    public static ArrayList retriveCartItemsValue() {
        Set<String> set = app_prefs.getStringSet(CART_ARRAY, null);
        if (set == null)
            return null;
            else
        arrPackage.addAll(set);
        return arrPackage;
    }

    public static int  retriveCartItemsSize() {
        Set<String> set = app_prefs.getStringSet(CART_ARRAY, null);
        if (set == null)
            return 0;
        else
        return set.size();
    }


    public static  void removeItemFromCart(int product_id)
    {
        Set<String> set = app_prefs.getStringSet(CART_ARRAY, null);
        set.remove(String.valueOf(product_id));
        arrPackage.clear();
        arrPackage.addAll(set);
    }

    public static  void clearCart()
    {
        Set<String> set = app_prefs.getStringSet(CART_ARRAY, null);
        set.clear();
        arrPackage.clear();
        Editor editor = app_prefs.edit();
        editor.putStringSet(CART_ARRAY, set);
        editor.apply();
    }

    public static int getUSER_GROUP_ID() {
        return app_prefs.getInt(USER_GROUP_ID, 0);
    }

    public static void setUserName(String name) {
        Editor edit = app_prefs.edit();
        edit.putString(USER_NAME, name);
        edit.apply();
    }

    public static String getUserName() {
        return app_prefs.getString(USER_NAME,null);
    }



    public static void setToken(String API_TOKEN) {
        Editor edit = app_prefs.edit();
        edit.putString(Token, API_TOKEN);
        edit.commit();
    }

    public static int getUserId() {
        if (app_prefs!=null)
        return app_prefs.getInt(UserId, 0);
        else
            return 0;
    }

    public void setLanguage(String language) {
        Editor edit = app_prefs.edit();
        edit.putString(Language, language);
        edit.commit();
    }

    public String getLanguage() {
        return app_prefs.getString(Language, null);
    }


    public static void setUserId(int user_id) {
        Editor edit = app_prefs.edit();
        edit.putInt(UserId, user_id);
        edit.apply();
    }


    public void Logout() {
        setToken(null);
        setUserId(0);
    }

    public void clearRequestData() {
    }

}
