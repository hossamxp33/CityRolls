package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class ProductDetails {

    private List<ProductdetailsBean> productdetails;
    private List<Related> related;
    private List<Related> product_colors;


    private int cat;
    private int subcat;
    public List<ProductdetailsBean> getProductdetails() {
        return productdetails;
    }
    public List<Related> getRelated() {
        return related;
    }
    public void setRelated (List <Related> related) {
        this.related = related;
    }

    public void setSubcat(int subcat) {
        this.subcat = subcat;
    }
    public int subcat() {
        return subcat;
    }


    public void setCat(int cat) {
        this.cat = cat;
    }
    public int getCat() {
        return cat;
    }


    public void setProductdetails(List<ProductdetailsBean> productdetails) {
        this.productdetails = productdetails;
    }

    public static class ProductdetailsBean {

        private int id;
        private String name;
        private String name_en;
        private String img;
        private String description;
        private String description_en;
        private List<ProductsizesBean> productsizes;
        private List<TotalRatingBean> total_rating;
        private List<ProductphotosBean> productphotos;
        private List<OffersBean> offers;
        private List<FavouritesBean> favourites;

        public int getId() {
            return id;
        }
        public void setImg(String img) {
            this.img = img;
        }

        public String getImg() {
            return img;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription_en() {
            return description_en;
        }

        public void setDescription_en(String description_en) {
            this.description_en = description_en;
        }

        public List<ProductsizesBean> getProductsizes() {
            return productsizes;
        }

        public void setProductsizes(List<ProductsizesBean> productsizes) {
            this.productsizes = productsizes;
        }

        public List<TotalRatingBean> getTotal_rating() {
            return total_rating;
        }

        public void setTotal_rating(List<TotalRatingBean> total_rating) {
            this.total_rating = total_rating;
        }

        public List<ProductphotosBean> getProductphotos() {
            return productphotos;
        }

        public void setProductphotos(List<ProductphotosBean> productphotos) {
            this.productphotos = productphotos;
        }

        public List<OffersBean> getOffers() {
            return offers;
        }

        public void setOffers(List<OffersBean> offers) {
            this.offers = offers;
        }

        public List<FavouritesBean> getFavourites() {
            return favourites;
        }

        public void setFavourites(List<FavouritesBean> favourites) {
            this.favourites = favourites;
        }

        public static class ProductsizesBean {
            /**
             * id : 3
             * product_id : 31
             * start_price : 300
             * amount : 1
             * size : 100
             */

            private int id;
            private int product_id;
            private String current_price;
            private String amount;
            private String size;

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

            public String getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(String start_price) {
                this.current_price = start_price;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }
        }

        public static class TotalRatingBean {
            /**
             * product_id : 31
             * stars : 5
             * count : 2
             */

            private int product_id;
            private float stars;
            private int count;

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
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

        public static class ProductphotosBean {
            /**
             * product_id : 31
             * id : 3
             * photo : http://shopgate.codesroots.com/library/attachment/pd3.jpg
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

        public static class OffersBean {
            /**
             * id : 4
             * percentage : 30
             * product_id : 31
             */

            private int id;
            private int percentage;
            private int product_id;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPercentage() {
                return percentage;
            }

            public void setPercentage(int percentage) {
                this.percentage = percentage;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }
        }

        public static class FavouritesBean {
            /**
             * product_id : 31
             * id : 1
             * user_id : 2
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
    }
    public static class Related {
        private int cat_id;
        private int id;
        private String name;
        private String name_en;
        private String img;
        private String description;
        private String description_en;
        private int store_id;


        private List<ProductsizesBean> productsizes;
        private List<TotalRatingBean> total_rating;
        private List<ProductphotosBean> productphotos;


        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }
        public int getCat_id() {
            return cat_id;
        }


        public int getId() {
            return id;
        }
        public void setImg(String img) {
            this.img = img;
        }

        public String getImg() {
            return img;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }
        public int getStore_id() {
            return store_id;
        }


        public String getDescription_en() {
            return description_en;
        }

        public void setDescription_en(String description_en) {
            this.description_en = description_en;
        }

        public List<ProductsizesBean> getProductsizes() {
            return productsizes;
        }

        public void setProductsizes(List<ProductsizesBean> productsizes) {
            this.productsizes = productsizes;
        }

        public List<TotalRatingBean> getTotal_rating() {
            return total_rating;
        }

        public void setTotal_rating(List<TotalRatingBean> total_rating) {
            this.total_rating = total_rating;
        }

        public List<ProductphotosBean> getProductphotos() {
            return productphotos;
        }

        public void setProductphotos(List<ProductphotosBean> productphotos) {
            this.productphotos = productphotos;
        }




        public static class ProductsizesBean {
            /**
             * id : 3
             * product_id : 31
             * start_price : 300
             * amount : 1
             * size : 100
             */

            private int id;
            private int product_id;
            private String start_price;
            private String amount;
            private String size;

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

            public String getStart_price() {
                return start_price;
            }

            public void setStart_price(String start_price) {
                this.start_price = start_price;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }
        }

        public static class TotalRatingBean {
            /**
             * product_id : 31
             * stars : 5
             * count : 2
             */

            private int product_id;
            private float stars;
            private int count;

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
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

        public static class ProductphotosBean {
            /**
             * product_id : 31
             * id : 3
             * photo : http://shopgate.codesroots.com/library/attachment/pd3.jpg
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

