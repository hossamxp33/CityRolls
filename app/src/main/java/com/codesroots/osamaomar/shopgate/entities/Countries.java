package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class Countries {


    /**
     * success : true
     * data : [{"id":1,"name":"Egypt","name_en":"","created":null,"modified":null},{"id":2,"name":"المغرب","name_en":"maghreb","created":"2019-02-21T07:09:54+0000","modified":"2019-02-21T07:09:54+0000"},{"id":3,"name":"شش","name_en":"ءءش","created":"2019-02-21T07:15:41+0000","modified":"2019-02-21T07:15:41+0000"},{"id":4,"name":"قطر","name_en":"qatar","created":"2019-03-27T07:06:11+0000","modified":"2019-03-27T07:06:11+0000"}]
     * pagination : {"page_count":1,"current_page":1,"has_next_page":false,"has_prev_page":false,"count":4,"limit":null}
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
         * count : 4
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
         * name : Egypt
         * name_en :
         * created : null
         * modified : null
         */

        private int id;
        private String name;
        private String name_en;
        private Object created;
        private Object modified;

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

        public Object getCreated() {
            return created;
        }

        public void setCreated(Object created) {
            this.created = created;
        }

        public Object getModified() {
            return modified;
        }

        public void setModified(Object modified) {
            this.modified = modified;
        }
    }
}
