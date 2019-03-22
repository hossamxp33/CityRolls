package com.example.osamaomar.shopgate.domain;

import com.example.osamaomar.shopgate.entities.DefaultAdd;
import com.example.osamaomar.shopgate.entities.AddToFavModel;
import com.example.osamaomar.shopgate.entities.CartItems;
import com.example.osamaomar.shopgate.entities.Favoriets;
import com.example.osamaomar.shopgate.entities.MainView;
import com.example.osamaomar.shopgate.entities.MyOrders;
import com.example.osamaomar.shopgate.entities.ProductDetails;
import com.example.osamaomar.shopgate.entities.ProductRate;
import com.example.osamaomar.shopgate.entities.Products;
import com.example.osamaomar.shopgate.entities.Sidemenu;
import com.example.osamaomar.shopgate.entities.SubCategriesWithProducts;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServerGateway {

    @GET("Productsizes/mainpage.json")
    Observable<MainView> getMainViewData();

    @GET("Categories/allcategories.json")
    Observable<Sidemenu> getSideMenuData();

    @GET("Productsizes/productdetails/{product_id}/{user_id}.json")
    Observable<ProductDetails> getProductDetails(
            @Path("product_id") int product_id,
            @Path("user_id") int user_id
    );



    @GET("Subcats/getsubcats/{cat_id}/{user_id}.json")
    Observable<SubCategriesWithProducts> getSubCatswithProducts(
            @Path("cat_id") int cat_id,
            @Path("user_id") int user_id
    );


    @GET("Productsizes/getallproducts/{subcat_id}/{type}/{user_id}.json")
    Observable<Products> getProducts(
            @Path("subcat_id") int cat_id,
            @Path("type") int type,
            @Path("user_id") int user_id
    );


    @FormUrlEncoded
    @POST("Favourites/addfavourite.json")
        Observable<AddToFavModel> addToFave(
            @Field("user_id") int user_id,
            @Field("product_id") int product_id
    );


    @GET("Favourites/delete/{favid}.json")
    Observable<DefaultAdd> DeleteFav(
            @Path("favid") int favid
    );


    @GET("Favourites/getproductsfav/{userid}.json")
    Observable<Favoriets> getFavProducts(
            @Path("userid") int userid
    );


    @FormUrlEncoded
    @POST("Products/viewproduct.json")
    Observable<CartItems> getCartProducts(
            @Field("arrayofid[]") ArrayList<Integer> ids
    );


    @GET("orders/getuserorder/{userid}.json")
    Observable<MyOrders> retrieveUserOrders(
            @Path("userid") int userid
    );


    @GET("Products/ratedetails/{product_id}.json")
    Observable<ProductRate> getProductRates(
            @Path("product_id") int product_id
    );

    @FormUrlEncoded
    @POST("Productrates/addrate.json")
    Observable<DefaultAdd> addProductRate(
            @Field("user_id") int user_id,
            @Field("product_id") int product_id,
            @Field("rate") float rate,
            @Field("comment") String comment
    );

}
