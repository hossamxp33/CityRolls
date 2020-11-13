package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class StoreSetting {


    /**
     * success : true
     * data : [{"id":1,"model_id":1,"exam_status":"1","next":"0","shipping":"إذا الشراء يصل ل 20 ريال عماني فالشحن مجاني داخل السلطنةإذا أقل يكون سعر الشحن 2 ريالخارج السلطنة إذا الشراء ب 100 ريال يكون مجاني إذا أقل يكون ب 7 ريال","shippingPrice":20,"shipping_en":"if the order reach to 20 omani rial  so shipping free inside oman if less than so shipping is 2 omani rial  outside oman if the order equal 100 omani rial so shipping free if less shipping equal 7 omani rial  ","outoman":200,"inoman":100}]
     * pagination : {"page_count":1,"current_page":1,"has_next_page":false,"has_prev_page":false,"count":1,"limit":null}
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


    public static class DataBean {
        /**
         * id : 1
         * model_id : 1
         * exam_status : 1
         * next : 0
         * shipping : إذا الشراء يصل ل 20 ريال عماني فالشحن مجاني داخل السلطنةإذا أقل يكون سعر الشحن 2 ريالخارج السلطنة إذا الشراء ب 100 ريال يكون مجاني إذا أقل يكون ب 7 ريال
         * shippingPrice : 20
         * shipping_en : if the order reach to 20 omani rial  so shipping free inside oman if less than so shipping is 2 omani rial  outside oman if the order equal 100 omani rial so shipping free if less shipping equal 7 omani rial
         * outoman : 200
         * inoman : 100
         */

        private int id;
        private int model_id;
        private String exam_status;
        private String next;
        private String shipping;
        private int shippingPrice;
        private String shipping_en;
        private int outoman;
        private int inoman;

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

        public int getShippingPrice() {
            return shippingPrice;
        }

        public void setShippingPrice(int shippingPrice) {
            this.shippingPrice = shippingPrice;
        }

        public String getShipping_en() {
            return shipping_en;
        }

        public void setShipping_en(String shipping_en) {
            this.shipping_en = shipping_en;
        }

        public int getOutoman() {
            return outoman;
        }

        public void setOutoman(int outoman) {
            this.outoman = outoman;
        }

        public int getInoman() {
            return inoman;
        }

        public void setInoman(int inoman) {
            this.inoman = inoman;
        }
    }
}
