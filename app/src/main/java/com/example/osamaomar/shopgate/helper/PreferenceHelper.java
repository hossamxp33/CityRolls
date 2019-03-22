package com.example.osamaomar.shopgate.helper;

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
    private static String Language = "language";
    private static final String USER_GROUP_ID = "USERGROUPID";
    private final static String USER_NAME = "USERNAME";
    private final static String CART_ARRAY = "CART_ARRAY";
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

    public static  void removeItemFromCart(int product_id)
    {
        Set<String> set = app_prefs.getStringSet(CART_ARRAY, null);
        set.remove(String.valueOf(product_id));
        arrPackage.clear();
        arrPackage.addAll(set);
    }

    public static  void clearCart()
    {
        arrPackage.clear();
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
        return app_prefs.getInt(UserId, 0);
    }

    public void setLanguage(String language) {
        Editor edit = app_prefs.edit();
        edit.putString(Language, language);
        edit.commit();
    }

    public String getLanguage() {
        return app_prefs.getString(Language, null);
    }


    public void setUserId(int user_id) {
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
