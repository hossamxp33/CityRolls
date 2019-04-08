package com.example.osamaomar.shopgate.entities;

import java.util.List;

public class StoreSetting {


    /**
     * success : true
     * data : [{"id":1,"model_id":1,"exam_status":"1","next":"0","shipping":"إذا الشراء يصل ل 20 ريال عماني فالشحن مجاني داخل السلطنة\nإذا أقل يكون سعر الشحن 2 ريال\nخارج السلطنة إذا الشراء ب 100 ريال يكون مجاني إذا أقل يكون ب 7 ريال","shippingPrice":20}]
     * pagination : {"page_count":1,"current_page":1,"has_next_page":false,"has_prev_page":false,"count":1,"limit":null}
     */

    private boolean success;
    private PaginationBean pagination;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public PaginationBean getPagination() {
        return pagination;
    }

    public void setPagination(PaginationBean pagination) {
        this.pagination = pagination;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class PaginationBean {
        /**
         * page_count : 1
         * current_page : 1
         * has_next_page : false
         * has_prev_page : false
         * count : 1
         * limit : null
         */

        private int page_count;
        private int current_page;
        private boolean has_next_page;
        private boolean has_prev_page;
        private int count;
        private Object limit;

        public int getPage_count() {
            return page_count;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public boolean isHas_next_page() {
            return has_next_page;
        }

        public void setHas_next_page(boolean has_next_page) {
            this.has_next_page = has_next_page;
        }

        public boolean isHas_prev_page() {
            return has_prev_page;
        }

        public void setHas_prev_page(boolean has_prev_page) {
            this.has_prev_page = has_prev_page;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Object getLimit() {
            return limit;
        }

        public void setLimit(Object limit) {
            this.limit = limit;
        }
    }

    public static class DataBean {
        /**
         * id : 1
         * model_id : 1
         * exam_status : 1
         * next : 0
         * shipping : إذا الشراء يصل ل 20 ريال عماني فالشحن مجاني داخل السلطنة
         إذا أقل يكون سعر الشحن 2 ريال
         خارج السلطنة إذا الشراء ب 100 ريال يكون مجاني إذا أقل يكون ب 7 ريال
         * shippingPrice : 20
         */

        private int id;
        private int model_id;
        private String exam_status;
        private String next;
        private String shipping;
        private float shippingPrice;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getModel_id() {
            return model_id;
        }

        public void setModel_id(int model_id) {
            this.model_id = model_id;
        }

        public String getExam_status() {
            return exam_status;
        }

        public void setExam_status(String exam_status) {
            this.exam_status = exam_status;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public String getShipping() {
            return shipping;
        }

        public void setShipping(String shipping) {
            this.shipping = shipping;
        }

        public float getShippingPrice() {
            return shippingPrice;
        }

        public void setShippingPrice(int shippingPrice) {
            this.shippingPrice = (float) shippingPrice;
        }
    }
}
