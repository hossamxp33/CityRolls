package com.codesroots.osamaomar.cityrolls.entities




class ProductBean {

    var id: Int = 0
    var name: String? = null
    var name_en: String? = null
    var img: String? = null
    var description: String? = null
    var description_en: String? = null
    var productsizes: List<Productsize>? = null
    var total_rating: List<TotalRatingBean>? = null
    var productphotos: List<ProductphotosBean>? = null
    var offers: List<OffersBean>? = null
    var cat_id: Int = 0
    var subcat_id: Int = 0
    var color_hex: String? = null
    var created: String? = null
    var modified: String? = null
    var red: String? = null
    var green: String? = null
    var blue: String? = null
    var visible: Any? = null
    var favourites: List<SubCategriesWithProducts.ProductsbyrateBean.ProductBean.FavouritesBean>? = null


    class OffersBean {
        /**
         * id : 4
         * percentage : 30
         * product_id : 31
         */

        var id: Int = 0
        var percentage: String? = null
        var product_id: Int = 0
    }


}