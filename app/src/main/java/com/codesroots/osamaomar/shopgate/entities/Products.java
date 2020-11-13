package com.codesroots.osamaomar.shopgate.entities;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Products {


    private List<ProductsbycategoryBean> data;

    public List<ProductsbycategoryBean> getProductsbycategory() {
        return data;
    }

    public void setProductsbycategory(List<ProductsbycategoryBean> productsbycategory) {
        this.data = productsbycategory;
    }

    public static class ProductsbycategoryBean {
        public ProductsbycategoryBean(int id) {
            this.id = id;
        }

        /**
         * id : 30
         * name : zzzz
         * name_en : salt
         * productsizes : [{"id":2,"product_id":30,"size":"100","created":"2019-02-19T07:00:10+0000","modified":"2019-02-19T07:00:10+0000","current_price":"1","start_price":"1","amount":1,"total_rating":[{"productsize_id":2,"stars":5,"count":2}]}]
         * favourites : [{"product_id":30,"id":5,"user_id":4}]
         * productphotos : [{"product_id":30,"id":1,"photo":"http://shopgate.codesroots.com/library/attachment/pds.jpg"},{"product_id":30,"id":2,"photo":"http://shopgate.codesroots.com/library/attachment/pds3.jpg"}]
         */


        private int id;
        private String name;
        private String name_en;
        private float price;
        private String img;

        private List<ProductsizesBean> productsizes;
        private List<FavouritesBean> favourites;
        private List<ProductphotosBean> productphotos;
        private List<TotalRatingBean> total_rating = new ArrayList<>();

        public void setImg(String img) {
            this.img = img;
        }

        public String getImg() {
            return img;
        }
        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public List<ProductsizesBean> getProductsizes() {
            return productsizes;
        }

        public void setProductsizes(List<ProductsizesBean> productsizes) {
            this.productsizes = productsizes;
        }

        public List<FavouritesBean> getFavourites() {
            return favourites;
        }

        public void setFavourites(List<FavouritesBean> favourites) {
            this.favourites = favourites;
        }

        public List<ProductphotosBean> getProductphotos() {
            return productphotos;
        }

        public void setProductphotos(List<ProductphotosBean> productphotos) {
            this.productphotos = productphotos;
        }

        public static class ProductsizesBean implements Comparable<ProductsizesBean>{
            /**
             * id : 2
             * product_id : 30
             * size : 100
             * created : 2019-02-19T07:00:10+0000
             * modified : 2019-02-19T07:00:10+0000
             * current_price : 1
             * start_price : 1
             * amount : 1
             * total_rating : [{"productsize_id":2,"stars":5,"count":2}]
             */

            private int id;
            private int product_id;
            private String size;
            private String created;
            private String modified;
            private String current_price;
            private String start_price;
            private int amount;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getModified() {
                return modified;
            }

            public void setModified(String modified) {
                this.modified = modified;
            }

            public String getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(String current_price) {
                this.current_price = current_price;
            }

            public String getStart_price() {
                return start_price;
            }

            public void setStart_price(String start_price) {
                this.start_price = start_price;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }



            @Override
            public int compareTo(@NonNull ProductsizesBean o) {
                return Float.valueOf(start_price).compareTo(Float.valueOf(o.start_price));
            }


        }
        public List<TotalRatingBean> getTotal_rating() {
            if (total_rating.size()==0)
                total_rating.add(new TotalRatingBean(0,0));
            return total_rating;
        }

        public void setTotal_rating(List<TotalRatingBean> total_rating) {
            this.total_rating = total_rating;
        }
        public static class TotalRatingBean {

            public TotalRatingBean() {
            }

            public TotalRatingBean(float stars, int count) {
                this.stars = stars;
                this.count = count;
            }

            /**
             * productsize_id : 2
             * stars : 5
             * count : 2
             */


            private int productsize_id;
            private float stars = 0;
            private int count=0;

            public int getProductsize_id() {
                return productsize_id;
            }

            public void setProductsize_id(int productsize_id) {
                this.productsize_id = productsize_id;
            }

            public float getStars() {
                return stars;
            }

            public void setStars(float stars) {
                this.stars = stars;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
        public static class FavouritesBean {
            public FavouritesBean(int id) {
                this.id = id;
            }

            /**
             * product_id : 30
             * id : 5
             * user_id : 4
             */


            private int product_id;
            private int id;
            private int user_id;

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }
        }

        public static class ProductphotosBean {
            /**
             * product_id : 30
             * id : 1
             * photo : http://shopgate.codesroots.com/library/attachment/pds.jpg
             */

            private int product_id;
            private int id;
            private String photo;

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }
    }
}
