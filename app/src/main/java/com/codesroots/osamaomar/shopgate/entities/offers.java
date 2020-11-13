package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class offers {

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
         * percentage : 20
         * product_id : 41
         * end_date : 04/24/2019
         * product : {"id":41,"name":"dwe","name_en":"petadin","description":"xasxas","description_en":"xasxas","productsizes":[{"id":13,"amount":3,"start_price":"100","product_id":41}],"productphotos":[{"id":13,"photo":"http://shopgate.codesroots.com/library/attachment/pd13.jpg","product_id":41}],"total_rating":[{"product_id":41,"stars":2,"count":1}]}
         */

        private int id;
        private String percentage="1";
        private int product_id;
        private String end_date;
        private ProductBean product;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPercentage() {
            if (percentage.matches(""))
                return "1";
            else
            return percentage;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public String getEnd_date() {
            return end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }

        public ProductBean getProduct() {
            return product;
        }

        public void setProduct(ProductBean product) {
            this.product = product;
        }

        public static class ProductBean {
            /**
             * id : 41
             * name : dwe
             * name_en : petadin
             * description : xasxas
             * description_en : xasxas
             * productsizes : [{"id":13,"amount":3,"start_price":"100","product_id":41}]
             * productphotos : [{"id":13,"photo":"http://shopgate.codesroots.com/library/attachment/pd13.jpg","product_id":41}]
             * total_rating : [{"product_id":41,"stars":2,"count":1}]
             */

            private int id;
            private String name;
            private String img;

            private String name_en;
            private String description;
            private String description_en;
            private List<Products.ProductsbycategoryBean.ProductsizesBean> productsizes;
            private List<ProductphotosBean> productphotos;
            private List<TotalRatingBean> total_rating;
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

            public List<Products.ProductsbycategoryBean.ProductsizesBean> getProductsizes() {
                return productsizes;
            }

            public void setProductsizes(List<Products.ProductsbycategoryBean.ProductsizesBean> productsizes) {
                this.productsizes = productsizes;
            }

            public List<ProductphotosBean> getProductphotos() {
                return productphotos;
            }

            public void setProductphotos(List<ProductphotosBean> productphotos) {
                this.productphotos = productphotos;
            }

            public List<TotalRatingBean> getTotal_rating() {
                return total_rating;
            }

            public void setTotal_rating(List<TotalRatingBean> total_rating) {
                this.total_rating = total_rating;
            }

            public static class ProductsizesBean {
                /**
                 * id : 13
                 * amount : 3
                 * start_price : 100
                 * product_id : 41
                 */

                private int id;
                private int amount;
                private String start_price;
                private int product_id;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
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

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }
            }

            public static class ProductphotosBean {
                /**
                 * id : 13
                 * photo : http://shopgate.codesroots.com/library/attachment/pd13.jpg
                 * product_id : 41
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

            public static class TotalRatingBean {
                /**
                 * product_id : 41
                 * stars : 2
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
        }
    }
}
