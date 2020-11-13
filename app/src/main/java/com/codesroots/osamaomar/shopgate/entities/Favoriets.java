package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class Favoriets {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3
         * user_id : 2
         * product_id : 31
         * product : {"id":31,"name":"zzzz","name_en":"salt","total_rating":[{"product_id":31,"stars":3,"count":1}],"productsizes":[{"id":3,"size":"100","product_id":31,"amount":1,"start_price":"1"}],"productphotos":[{"id":20,"photo":"http://shopgate.codesroots.com/library/attachment/1550745371906943104.jpg","product_id":31}]}
         */

        private int id;
        private int user_id;
        private int product_id;
        private ProductBean product;

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

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public ProductBean getProduct() {
            return product;
        }

        public void setProduct(ProductBean product) {
            this.product = product;
        }

        public static class ProductBean {
            /**
             * id : 31
             * name : zzzz
             * name_en : salt
             * total_rating : [{"product_id":31,"stars":3,"count":1}]
             * productsizes : [{"id":3,"size":"100","product_id":31,"amount":1,"start_price":"1"}]
             * productphotos : [{"id":20,"photo":"http://shopgate.codesroots.com/library/attachment/1550745371906943104.jpg","product_id":31}]
             */

            private int id;
            private String name;
            private String name_en;
            private String img;
            private List<TotalRatingBean> total_rating;
            private List<ProductsizesBean> productsizes;
            private List<ProductphotosBean> productphotos;

            public void setImg(String img) {
                this.img = img;
            }

            public String getImg() {
                return img;
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

            public List<TotalRatingBean> getTotal_rating() {
                return total_rating;
            }

            public void setTotal_rating(List<TotalRatingBean> total_rating) {
                this.total_rating = total_rating;
            }

            public List<ProductsizesBean> getProductsizes() {
                return productsizes;
            }

            public void setProductsizes(List<ProductsizesBean> productsizes) {
                this.productsizes = productsizes;
            }

            public List<ProductphotosBean> getProductphotos() {
                return productphotos;
            }

            public void setProductphotos(List<ProductphotosBean> productphotos) {
                this.productphotos = productphotos;
            }

            public static class TotalRatingBean {
                /**
                 * product_id : 31
                 * stars : 3
                 * count : 1
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

            public static class ProductsizesBean {
                /**
                 * id : 3
                 * size : 100
                 * product_id : 31
                 * amount : 1
                 * start_price : 1
                 */

                private int id;
                private String size;
                private int product_id;
                private int amount;
                private String start_price;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }

                public int getAmount() {
                    return amount;
                }

                public void setAmount(int amount) {
                    this.amount = amount;
                }

                public String getStart_price() {
                    return start_price;
                }

                public void setStart_price(String start_price) {
                    this.start_price = start_price;
                }
            }

            public static class ProductphotosBean {
                /**
                 * id : 20
                 * photo : http://shopgate.codesroots.com/library/attachment/1550745371906943104.jpg
                 * product_id : 31
                 */

                private int id;
                private String photo;
                private int product_id;

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

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }
            }
        }
    }
}
