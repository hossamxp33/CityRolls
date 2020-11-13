package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class CartItems {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4
         * amount : 4
         * product_id : 32
         * start_price : 400
         * product : {"id":32,"name":"zzzz","name_en":"salt","description":"axa","description_en":"xaxa","total_rating":[{"product_id":32,"stars":6,"count":2}],"offers":[{"id":2,"product_id":32,"percentage":"20"}],"productphotos":[{"id":4,"product_id":32,"photo":"http://shopgate.codesroots.com/library/attachment/pd4.jpg"}]}
         */

        private int id;
        private int amount;
        private int product_id;
        private Float start_price;
        private ProductBean product;

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

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public Float getStart_price() {
            return start_price;
        }

        public void setStart_price(Float start_price) {
            this.start_price = start_price;
        }

        public ProductBean getProduct() {
            return product;
        }

        public void setProduct(ProductBean product) {
            this.product = product;
        }

        public static class ProductBean {
            /**
             * id : 32
             * name : zzzz
             * name_en : salt
             * description : axa
             * description_en : xaxa
             * total_rating : [{"product_id":32,"stars":6,"count":2}]
             * offers : [{"id":2,"product_id":32,"percentage":"20"}]
             * productphotos : [{"id":4,"product_id":32,"photo":"http://shopgate.codesroots.com/library/attachment/pd4.jpg"}]
             */

            private int id;
            private String name;
            private String name_en;
            private String img;
            private String description;
            private String description_en;
            private List<TotalRatingBean> total_rating;
            private List<OffersBean> offers;
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

            public List<TotalRatingBean> getTotal_rating() {
                return total_rating;
            }

            public void setTotal_rating(List<TotalRatingBean> total_rating) {
                this.total_rating = total_rating;
            }

            public List<OffersBean> getOffers() {
                return offers;
            }

            public void setOffers(List<OffersBean> offers) {
                this.offers = offers;
            }

            public List<ProductphotosBean> getProductphotos() {
                return productphotos;
            }

            public void setProductphotos(List<ProductphotosBean> productphotos) {
                this.productphotos = productphotos;
            }

            public static class TotalRatingBean {
                /**
                 * product_id : 32
                 * stars : 6
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

            public static class OffersBean {
                /**
                 * id : 2
                 * product_id : 32
                 * percentage : 20
                 */

                private int id;
                private int product_id;
                private String percentage;

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

                public String getPercentage() {
                    return percentage;
                }

                public void setPercentage(String percentage) {
                    this.percentage = percentage;
                }
            }

            public static class ProductphotosBean {
                /**
                 * id : 4
                 * product_id : 32
                 * photo : http://shopgate.codesroots.com/library/attachment/pd4.jpg
                 */

                private int id;
                private int product_id;
                private String photo;

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

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
            }
        }
    }
}
