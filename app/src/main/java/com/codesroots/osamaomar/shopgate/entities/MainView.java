package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class MainView {

    private List<CategoryBean> category;

    private CurrencyBean currency;

    private  List<Newdata> newdata;
    private List<Offerproducts> offernew;
    private List<Productsbysales> productsbysales;

    private List<SlidersBean> sliders;





    public CurrencyBean getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
    }

    public List<SlidersBean> getSliders() {
        return sliders;
    }

    public void setSliders(List<SlidersBean> sliders) {
        this.sliders = sliders;
    }

    public List<CategoryBean> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryBean> category) {
        this.category = category;
    }

    public List<Newdata> getProductsbyrate() {
        return newdata;
    }

    public void setProductsbyrate(List<Newdata> productsbyrate) {
        this.newdata = productsbyrate;
    }

    public List<Offerproducts> getOfferproducts() {
        return offernew;
    }

    public void setOfferproducts(List<Offerproducts> randproducts) {
        this.offernew = randproducts;
    }

    public List<Productsbysales> getProductsbysales() {
        return productsbysales;
    }

    public void setProductsbysales(List<Productsbysales> productsbysales) {
        this.productsbysales = productsbysales;
    }

    public static class CurrencyBean {
        /**
         * id : 1
         * name : dollar
         * value : 18
         * basic_value : 1
         * name_ar : دولار
         */

        private int id;
        private String name;
        private float value;
        private int basic_value;
        private String name_ar;

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

        public float getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getBasic_value() {
            return basic_value;
        }

        public void setBasic_value(int basic_value) {
            this.basic_value = basic_value;
        }

        public String getName_ar() {
            return name_ar;
        }

        public void setName_ar(String name_ar) {
            this.name_ar = name_ar;
        }
    }

    public static class SlidersBean {
        /**
         * photo : http://shopgate.codesroots.com/library/attachment/1545749814.jpg
         */

        private String photo;

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }

    public static class CategoryBean {
        private int id;
        private String name;
        private String name_en;
        private String created;
        private int number;
        private String photo;
        private String modified;
        private List<SubcatsBean> subcats;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.id = number;
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

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public List<SubcatsBean> getSubcats() {
            return subcats;
        }

        public void setSubcats(List<SubcatsBean> subcats) {
            this.subcats = subcats;
        }

        public static class SubcatsBean {
            /**
             * name : الأقنعة وتنظيف الوجه
             * category_id : 22
             * id : 11
             * photo : http://shopgate.codesroots.com/library/attachment/15567450491791302463.jpg
             */

            private String name;
            private int category_id;
            private int id;
            private String photo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
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

    public static class Newdata {

        private int id;
        private int cat_id;
        private String name_en;
        private String name;
        private String description;
        private String description_en;
        private String img;
        private String blue;
        private String created;
        private  List<ProductsizesBean> productsizes;

        private int store_id;
        private int subcat_id;
        private String visible;




        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCat_id() {
            return cat_id;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }

        public String getBlue() {
            return blue;
        }

        public void setBlue(String blue) {
            this.blue = blue;
        }

        public String getName_en() {
            return name_en;
        }

        public void setTotal_result(String total_result) {
            this.name_en = total_result;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getName() {
            return name;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getImg() {
            return img;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription_en() {
            return description_en;
        }

        public void setDescription_en(String description_en) {
            this.description_en = description_en;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        //
        public int getStore_id() {
            return store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }

        public int getSubcat_id() {
            return subcat_id;
        }

        public void setSubcat_id(int subcat_id) {
            this.subcat_id = subcat_id;
        }
//        public MatchingDataBean get_matchingData() {
//            return _matchingData;
//        }
//
//        public void set_matchingData(MatchingDataBean _matchingData) {
//            this._matchingData = _matchingData;
//        }


        public  List<ProductsizesBean> getProductsizes() {
            return productsizes;
        }

        public void setProductsizes( List<ProductsizesBean> Productsizes) {
            this.productsizes = Productsizes;
        }





        public static class ProductsizesBean {
            /**
             * start_price : 15
             */
//            val amount: Int,
//            val created: String,
//            val current_price: Int,
//            val id: Int,
//            val modified: String,
//            val product_id: Int,
//            val size: String,
//            val start_price: Int


            private int start_price;
            private int amount;
            private String created;
            private int current_price;
            private int id;
            private int product_id;
            private String size;





            public int getStart_price() { return start_price; }

            public void setStart_price(int start_price) {
                this.start_price = start_price;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public int getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(int current_price) {
                this.current_price = current_price;
            }
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
        }


    }

    public static class Offerproducts {
//        val created: String,
//        val end_date: String,
//        val id: Int,
//        val percentage: String,
//        val product: Product,
//        val product_id: Int,
//        val start_date: String

        private int id;
        private ProductBean product;
        private int product_id;
        private String percentage;

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }
        public int getId() {
            return id;
        }

        public ProductBean getProduct() {
            return product;
        }
        public void setProduct(ProductBean product) {
            this.product = product;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPercentage() {
            return percentage;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }


        public static class ProductBean {

            private int id;
            private String name;
            private String name_en;
            private  String img;
            private List<Offer> offers;
            private List<ProductsizesBean> productsizes;
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

            public List<ProductsizesBean> getProductsizes() {
                return productsizes;
            }

            public void setProductsizes(List<ProductsizesBean> productsizes) {
                this.productsizes = productsizes;
            }
            public static class ProductsizesBean {
//                val amount: Int,
//                val created: String,
//                val current_price: Int,
//                val id: Int,
//                val modified: String,
//                val product_id: Int,
//                val size: String,
//                val start_price: Int

                private int id;
                private int product_id;
                private String size;
                private String created;
                private String modified;
                private double current_price;
                private int start_price;
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

                public double getCurrent_price() {
                    return current_price;
                }

                public void setCurrent_price(double current_price) {
                    this.current_price = current_price;
                }

                public int getStart_price() {
                    return start_price;
                }

                public void setStart_price(int start_price) {
                    this.start_price = start_price;
                }

                public int getAmount() {
                    return amount;
                }

                public void setAmount(int amount) {
                    this.amount = amount;
                }

            }

            public static class Offer {
//                val created: String,
//                val end_date: String,
//                val percentage: String,
//                val product_id: Int,
//                val start_date: String

                private int product_id;
                private String created;
                private String start_date;
                private  String percentage;


                public void setPercentage(String percentage) {
                    this.percentage = percentage;
                }

                public String getPercentage() {
                    return percentage;
                }

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }

                public String getCreated() {
                    return created;
                }

                public void setCreated(String created) {
                    this.created = created;
                }

                public String getStart_date() {
                    return start_date;
                }

                public void setStart_date(String start_date) {
                    this.start_date = start_date;
                }





            }



        }
    }

    public static class Productsbysales {
//        val amount: Int,
//        val created: String,
//        val current_price: Int,
//        val id: Int,
//        val modified: String,
//        val orderdetails: List<Orderdetail>,
//        val product: ProductX,
//        val product_id: Int,
//        val size: String,
//        val start_price: Int,
//        val total_result: Int

        private int total_result;
        private int id;
        private int start_price;
        private int product_id;
        private String size;
        private String created;
        private String modified;
        private double current_price;
        private int amount;
        private ProductBean product;
        private List<OrderdetailsBean> orderdetails;

        public int getTotal_result() {
            return total_result;
        }

        public void setTotal_result(int total_result) {
            this.total_result = total_result;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStart_price() {
            return start_price;
        }

        public void setStart_price(int start_price) {
            this.start_price = start_price;
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

        public double getCurrent_price() {
            return current_price;
        }

        public void setCurrent_price(double current_price) {
            this.current_price = current_price;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public ProductBean getProduct() {
            return product;
        }

        public void setProduct(ProductBean product) {
            this.product = product;
        }

        public List<OrderdetailsBean> getOrderdetails() {
            return orderdetails;
        }

        public void setOrderdetails(List<OrderdetailsBean> orderdetails) {
            this.orderdetails = orderdetails;
        }

        public static class ProductBean {
            private int id;
            private String name;
            private String name_en;
            private int cat_id;
            private int subcat_id;
            private String created;
            private String modified;
            private String description;
            private String description_en;
            private String red;
            private String green;
            private String blue;
            private String visible;

            private List<TotalRatingBeanXX> total_rating;
            private List<ProductphotosBeanXX> productphotos;
            private List<ProductsizesBean> productsizes;
            private  String img;
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

            public int getCat_id() {
                return cat_id;
            }

            public void setCat_id(int cat_id) {
                this.cat_id = cat_id;
            }

            public int getSubcat_id() {
                return subcat_id;
            }

            public void setSubcat_id(int subcat_id) {
                this.subcat_id = subcat_id;
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

            public String getRed() {
                return red;
            }

            public void setRed(String red) {
                this.red = red;
            }

            public String getGreen() {
                return green;
            }

            public void setGreen(String green) {
                this.green = green;
            }

            public String getBlue() {
                return blue;
            }

            public void setBlue(String blue) {
                this.blue = blue;
            }

            public String getVisible() {
                return visible;
            }

            public void setVisible(String visible) {
                this.visible = visible;
            }

            public List<TotalRatingBeanXX> getTotal_rating() {
                return total_rating;
            }

            public void setTotal_rating(List<TotalRatingBeanXX> total_rating) {
                this.total_rating = total_rating;
            }

            public List<ProductphotosBeanXX> getProductphotos() {
                return productphotos;
            }

            public void setProductphotos(List<ProductphotosBeanXX> productphotos) {
                this.productphotos = productphotos;
            }

            public List<ProductsizesBean> getProductsizes() {
                return productsizes;
            }

            public void setProductsizes(List<ProductsizesBean> productsizes) {
                this.productsizes = productsizes;
            }

            public static class TotalRatingBeanXX {
                /**
                 * product_id : 24
                 * stars : 4
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

            public static class ProductphotosBeanXX {
                /**
                 * product_id : 24
                 * id : 65
                 * photo : http://shopgate.codesroots.com/library/attachment/1556747295732838734.jpg
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

            public static class ProductsizesBean {
//                val amount: Int,
//                val created: String,
//                val current_price: Int,
//                val id: Int,
//                val modified: String,
//                val product_id: Int,
//                val size: String,
//                val start_price: Int

                private int id;
                private int product_id;
                private String size;
                private String created;
                private String modified;
                private double current_price;
                private int start_price;
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

                public double getCurrent_price() {
                    return current_price;
                }

                public void setCurrent_price(double current_price) {
                    this.current_price = current_price;
                }

                public int getStart_price() {
                    return start_price;
                }

                public void setStart_price(int start_price) {
                    this.start_price = start_price;
                }

                public int getAmount() {
                    return amount;
                }

                public void setAmount(int amount) {
                    this.amount = amount;
                }
            }
        }

        public static class OrderdetailsBean {
            /**
             * productsize_id : 132
             * order_id : 567
             * count : 6
             */

            private int productsize_id;
            private int order_id;
            private int count;

            public int getProductsize_id() {
                return productsize_id;
            }

            public void setProductsize_id(int productsize_id) {
                this.productsize_id = productsize_id;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
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
