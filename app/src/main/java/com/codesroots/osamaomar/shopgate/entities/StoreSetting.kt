package com.codesroots.osamaomar.shopgate.entities

class StoreSetting {


    /**
     * success : true
     * data : [{"id":1,"model_id":1,"exam_status":"1","next":"0","shipping":"إذا الشراء يصل ل 20 ريال عماني فالشحن مجاني داخل السلطنةإذا أقل يكون سعر الشحن 2 ريالخارج السلطنة إذا الشراء ب 100 ريال يكون مجاني إذا أقل يكون ب 7 ريال","shippingPrice":20,"shipping_en":"if the order reach to 20 omani rial  so shipping free inside oman if less than so shipping is 2 omani rial  outside oman if the order equal 100 omani rial so shipping free if less shipping equal 7 omani rial  ","outoman":200,"inoman":100}]
     * pagination : {"page_count":1,"current_page":1,"has_next_page":false,"has_prev_page":false,"count":1,"limit":null}
     */

    var isSuccess: Boolean = false
    var data: List<DataBean>? = null


    class DataBean {
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

        var id: Int = 0
        var model_id: Int = 0
        var exam_status: String? = null
        var next: String? = null
        var shipping: String? = null
        var shippingPrice: Int = 0
        var shipping_en: String? = null
        var outoman: Int = 0
        var inoman: Int = 0
    }
}
