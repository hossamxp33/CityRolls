package com.example.osamaomar.shopgate.entities;

import java.util.List;

public class MainView {


    /**
     * sliders : [{"photo":"http://shopgate.codesroots.com/library/attachment/1545749814.jpg"},{"photo":"http://shopgate.codesroots.com/library/attachment/1545749814.jpg"},{"photo":"http://shopgate.codesroots.com/library/attachment/15529230351164512480.jpg"},{"photo":"http://shopgate.codesroots.com/library/attachment/15567417902050734348.jpg"},{"photo":"http://shopgate.codesroots.com/library/attachment/1556745687541572806.png"},{"photo":"http://shopgate.codesroots.com/library/attachment/15567457131529091758.png"}]
     * category : [{"id":22,"name":"منتجات البشرة والجلد","name_en":"Skin Products","created":"2019-05-01T16:59:38+0000","photo":"http://shopgate.codesroots.com/library/attachment/1556744378990961308.jpg","modified":"2019-05-01T16:59:38+0000","subcats":[{"name":"الأقنعة وتنظيف الوجه","category_id":22,"id":11,"photo":"http://shopgate.codesroots.com/library/attachment/15567450491791302463.jpg"},{"name":"الفيتامينات والسيروم","category_id":22,"id":12,"photo":"http://shopgate.codesroots.com/library/attachment/15567452991678824842.jpg"},{"name":"تفتيح البشرة","category_id":22,"id":13,"photo":"http://shopgate.codesroots.com/library/attachment/15567453361176756685.jpg"},{"name":"منتجات الكولاجين","category_id":22,"id":14,"photo":"http://shopgate.codesroots.com/library/attachment/15567453851628468128.jpg"}]},{"id":23,"name":"أجهزة العناية بالجلد والبشرة","name_en":"Skin care devices","created":"2019-05-01T17:00:03+0000","photo":"http://shopgate.codesroots.com/library/attachment/15567444031367893693.jpg","modified":"2019-05-01T17:00:03+0000","subcats":[]},{"id":24,"name":"منتجات العناية بالجسم","name_en":"Body care product","created":"2019-05-01T17:00:42+0000","photo":"http://shopgate.codesroots.com/library/attachment/1556744442184412904.jpg","modified":"2019-05-01T17:00:42+0000","subcats":[]},{"id":25,"name":"منتجات العناية بالأسنان","name_en":"Dental Care Products","created":"2019-05-01T17:02:07+0000","photo":"http://shopgate.codesroots.com/library/attachment/1556744527137180950.jpg","modified":"2019-05-01T17:02:07+0000","subcats":[]},{"id":26,"name":"المنتجات الكورية","name_en":"Korean product","created":"2019-05-01T17:02:40+0000","photo":"http://shopgate.codesroots.com/library/attachment/1556744560367163778.jpg","modified":"2019-05-01T17:02:40+0000","subcats":[]},{"id":27,"name":"منتجات العناية بالشعر","name_en":"Hair care product","created":"2019-05-01T17:03:35+0000","photo":"http://shopgate.codesroots.com/library/attachment/1556744615289128042.jpg","modified":"2019-05-01T17:03:35+0000","subcats":[{"name":"منتجات العناية بالشعر","category_id":27,"id":15,"photo":"http://shopgate.codesroots.com/library/attachment/15567454251850000501.jpg"},{"name":"أجهزة العناية بالشعر","category_id":27,"id":16,"photo":"http://shopgate.codesroots.com/library/attachment/15567454541175397731.jpg"}]},{"id":28,"name":"منتجات الرشاقة والتخسيس","name_en":"Fitness & Slimming","created":"2019-05-01T17:04:02+0000","photo":"http://shopgate.codesroots.com/library/attachment/1556744642209198696.jpg","modified":"2019-05-01T17:04:02+0000","subcats":[]}]
     * productsbyrate : [{"id":18,"total_result":"5","name":"منتج تبييض الأسنان","description":"منتج تبييض الأسنان","total_rating":[{"product_id":18,"stars":5,"count":1}],"productphotos":[{"product_id":18,"id":59,"photo":"http://shopgate.codesroots.com/library/attachment/15567465531278776543.jpg"}],"_matchingData":{"Productsizes":{"start_price":15}}},{"id":24,"total_result":"4","name":"كريم الكولاجين","description":"كريم الكولاجين","total_rating":[{"product_id":24,"stars":4,"count":1}],"productphotos":[{"product_id":24,"id":65,"photo":"http://shopgate.codesroots.com/library/attachment/1556747295732838734.jpg"}],"_matchingData":{"Productsizes":{"start_price":7}}},{"id":11,"total_result":"0","name":"الكولاجين البحري","description":"الكولاجين البحري","total_rating":[],"productphotos":[{"product_id":11,"id":52,"photo":"http://shopgate.codesroots.com/library/attachment/15567459991500084080.jpg"}],"_matchingData":{"Productsizes":{"start_price":12}}},{"id":13,"total_result":"0","name":"ايفوري كابس لتفتيح البشرة","description":"ايفوري كابس لتفتيح البشرة","total_rating":[],"productphotos":[{"product_id":13,"id":54,"photo":"http://shopgate.codesroots.com/library/attachment/1556746141723798761.jpg"}],"_matchingData":{"Productsizes":{"start_price":55}}},{"id":17,"total_result":"0","name":"المجموعة الأفريقية للجسم","description":"المجموعة الأفريقية للجسم","total_rating":[],"productphotos":[{"product_id":17,"id":58,"photo":"http://shopgate.codesroots.com/library/attachment/15567464562061772768.jpg"}],"_matchingData":{"Productsizes":{"start_price":25}}},{"id":20,"total_result":"0","name":"فيتامين سيروم","description":"فيتامين سيروم","total_rating":[],"productphotos":[{"product_id":20,"id":61,"photo":"http://shopgate.codesroots.com/library/attachment/15567469291867741597.jpg"}],"_matchingData":{"Productsizes":{"start_price":8}}},{"id":22,"total_result":"0","name":"زيت الأفوكادو","description":"زيت الأفوكادو","total_rating":[],"productphotos":[{"product_id":22,"id":63,"photo":"http://shopgate.codesroots.com/library/attachment/15567471491903297956.jpg"}],"_matchingData":{"Productsizes":{"start_price":15}}},{"id":25,"total_result":"0","name":"الصابونة الأفريقية","description":"الصابونة الأفريقية","total_rating":[],"productphotos":[{"product_id":25,"id":66,"photo":"http://shopgate.codesroots.com/library/attachment/15567473801577915129.jpg"}],"_matchingData":{"Productsizes":{"start_price":5}}},{"id":15,"total_result":"0","name":"كريم الأفوكادو","description":"كريم الأفوكادو","total_rating":[],"productphotos":[{"product_id":15,"id":56,"photo":"http://shopgate.codesroots.com/library/attachment/15567462461715265887.jpg"}],"_matchingData":{"Productsizes":{"start_price":null}}},{"id":9,"total_result":"0","name":"بودرة الكولاجين","description":"بودرة الكولاجين","total_rating":[],"productphotos":[{"product_id":9,"id":50,"photo":"http://shopgate.codesroots.com/library/attachment/15567457991223780712.jpg"}],"_matchingData":{"Productsizes":{"start_price":12}}},{"id":10,"total_result":"0","name":"كبسولات الكولاجين","description":"كبسولات الكولاجين","total_rating":[],"productphotos":[{"product_id":10,"id":51,"photo":"http://shopgate.codesroots.com/library/attachment/1556745947207533111.jpg"}],"_matchingData":{"Productsizes":{"start_price":15}}},{"id":12,"total_result":"0","name":"ايفوري كابس لتفتيح البشرة","description":"ايفوري كابس لتفتيح البشرة","total_rating":[],"productphotos":[{"product_id":12,"id":53,"photo":"http://shopgate.codesroots.com/library/attachment/1556746088389474257.jpg"}],"_matchingData":{"Productsizes":{"start_price":20}}},{"id":14,"total_result":"0","name":"ايفوري كابس لتفتيح البشرة","description":"ايفوري كابس لتفتيح البشرة","total_rating":[],"productphotos":[{"product_id":14,"id":55,"photo":"http://shopgate.codesroots.com/library/attachment/15567461891897081063.jpg"}],"_matchingData":{"Productsizes":{"start_price":55}}},{"id":19,"total_result":"0","name":"فيتامين سيروم","description":"فيتامين سيروم","total_rating":[],"productphotos":[{"product_id":19,"id":60,"photo":"http://shopgate.codesroots.com/library/attachment/15567468531593194308.jpg"}],"_matchingData":{"Productsizes":{"start_price":12}}},{"id":21,"total_result":"0","name":"فرشاة الشعر كوتور باريس","description":"فرشاة الشعر كوتور باريس","total_rating":[],"productphotos":[{"product_id":21,"id":62,"photo":"http://shopgate.codesroots.com/library/attachment/15567470861423564449.jpg"}],"_matchingData":{"Productsizes":{"start_price":24}}},{"id":23,"total_result":"0","name":"زيت اللوز","description":"زيت اللوز","total_rating":[],"productphotos":[{"product_id":23,"id":64,"photo":"http://shopgate.codesroots.com/library/attachment/15567472121807677322.jpg"}],"_matchingData":{"Productsizes":{"start_price":14}}},{"id":26,"total_result":"0","name":"كولاجين الفواكه","description":"كولاجين الفواكه","total_rating":[],"productphotos":[{"product_id":26,"id":67,"photo":"http://shopgate.codesroots.com/library/attachment/1556747527814367472.jpg"}],"_matchingData":{"Productsizes":{"start_price":18}}},{"id":16,"total_result":"0","name":"شامبو الكيراتين","description":"شامبو الكيراتين","total_rating":[],"productphotos":[{"product_id":16,"id":57,"photo":"http://shopgate.codesroots.com/library/attachment/1556746321352533925.jpg"}],"_matchingData":{"Productsizes":{"start_price":null}}}]
     * currency : {"id":1,"name":"dollar","value":18,"basic_value":1,"name_ar":"دولار"}
     * randproducts : [{"id":18,"name":"منتج تبييض الأسنان","description":"منتج تبييض الأسنان","total_rating":[{"product_id":18,"stars":5,"count":1}],"productphotos":[{"id":59,"photo":"http://shopgate.codesroots.com/library/attachment/15567465531278776543.jpg","main":"","created":"2019-05-01T17:35:53+0000","modified":"2019-05-01T17:35:53+0000","product_id":18}],"productsizes":[{"id":126,"product_id":18,"size":"1","created":"2019-05-01T17:36:04+0000","modified":"2019-05-01T17:36:04+0000","current_price":15,"start_price":15,"amount":20}]},{"id":22,"name":"زيت الأفوكادو","description":"زيت الأفوكادو","total_rating":[],"productphotos":[{"id":63,"photo":"http://shopgate.codesroots.com/library/attachment/15567471491903297956.jpg","main":"","created":"2019-05-01T17:45:49+0000","modified":"2019-05-01T17:45:49+0000","product_id":22}],"productsizes":[{"id":130,"product_id":22,"size":"473 ml","created":"2019-05-01T17:46:12+0000","modified":"2019-05-01T17:46:12+0000","current_price":15,"start_price":15,"amount":3}]},{"id":13,"name":"ايفوري كابس لتفتيح البشرة","description":"ايفوري كابس لتفتيح البشرة","total_rating":[],"productphotos":[{"id":54,"photo":"http://shopgate.codesroots.com/library/attachment/1556746141723798761.jpg","main":"","created":"2019-05-01T17:29:01+0000","modified":"2019-05-01T17:29:01+0000","product_id":13}],"productsizes":[{"id":123,"product_id":13,"size":"60 ","created":"2019-05-01T17:29:14+0000","modified":"2019-05-01T17:29:14+0000","current_price":55,"start_price":55,"amount":10}]},{"id":23,"name":"زيت اللوز","description":"زيت اللوز","total_rating":[],"productphotos":[{"id":64,"photo":"http://shopgate.codesroots.com/library/attachment/15567472121807677322.jpg","main":"","created":"2019-05-01T17:46:52+0000","modified":"2019-05-01T17:46:52+0000","product_id":23}],"productsizes":[{"id":131,"product_id":23,"size":"473 ml","created":"2019-05-01T17:47:04+0000","modified":"2019-05-01T17:47:04+0000","current_price":14,"start_price":14,"amount":5}]},{"id":11,"name":"الكولاجين البحري","description":"الكولاجين البحري","total_rating":[],"productphotos":[{"id":52,"photo":"http://shopgate.codesroots.com/library/attachment/15567459991500084080.jpg","main":"","created":"2019-05-01T17:26:39+0000","modified":"2019-05-01T17:26:39+0000","product_id":11}],"productsizes":[{"id":121,"product_id":11,"size":"120 كبسولة","created":"2019-05-01T17:26:57+0000","modified":"2019-05-01T17:26:57+0000","current_price":12,"start_price":12,"amount":10}]},{"id":25,"name":"الصابونة الأفريقية","description":"الصابونة الأفريقية","total_rating":[],"productphotos":[{"id":66,"photo":"http://shopgate.codesroots.com/library/attachment/15567473801577915129.jpg","main":"","created":"2019-05-01T17:49:40+0000","modified":"2019-05-01T17:49:40+0000","product_id":25}],"productsizes":[{"id":133,"product_id":25,"size":"1","created":"2019-05-01T17:49:49+0000","modified":"2019-05-01T17:49:49+0000","current_price":5,"start_price":5,"amount":12}]},{"id":10,"name":"كبسولات الكولاجين","description":"كبسولات الكولاجين","total_rating":[],"productphotos":[{"id":51,"photo":"http://shopgate.codesroots.com/library/attachment/1556745947207533111.jpg","main":"","created":"2019-05-01T17:25:47+0000","modified":"2019-05-01T17:25:47+0000","product_id":10}],"productsizes":[{"id":120,"product_id":10,"size":"250","created":"2019-05-01T17:25:57+0000","modified":"2019-05-01T17:25:57+0000","current_price":15,"start_price":15,"amount":10}]},{"id":17,"name":"المجموعة الأفريقية للجسم","description":"المجموعة الأفريقية للجسم","total_rating":[],"productphotos":[{"id":58,"photo":"http://shopgate.codesroots.com/library/attachment/15567464562061772768.jpg","main":"","created":"2019-05-01T17:34:16+0000","modified":"2019-05-01T17:34:16+0000","product_id":17}],"productsizes":[{"id":125,"product_id":17,"size":"5","created":"2019-05-01T17:34:29+0000","modified":"2019-05-01T17:34:29+0000","current_price":25,"start_price":25,"amount":5}]},{"id":19,"name":"فيتامين سيروم","description":"فيتامين سيروم","total_rating":[],"productphotos":[{"id":60,"photo":"http://shopgate.codesroots.com/library/attachment/15567468531593194308.jpg","main":"","created":"2019-05-01T17:40:53+0000","modified":"2019-05-01T17:40:53+0000","product_id":19}],"productsizes":[{"id":127,"product_id":19,"size":"60 ml","created":"2019-05-01T17:41:24+0000","modified":"2019-05-01T17:41:24+0000","current_price":12,"start_price":12,"amount":5}]},{"id":9,"name":"بودرة الكولاجين","description":"بودرة الكولاجين","total_rating":[],"productphotos":[{"id":50,"photo":"http://shopgate.codesroots.com/library/attachment/15567457991223780712.jpg","main":"","created":"2019-05-01T17:23:19+0000","modified":"2019-05-01T17:23:19+0000","product_id":9}],"productsizes":[{"id":119,"product_id":9,"size":"198 g","created":"2019-05-01T17:24:15+0000","modified":"2019-05-01T17:24:15+0000","current_price":12,"start_price":12,"amount":10}]}]
     * productsbysales : [{"total_result":6,"id":132,"start_price":7,"product_id":24,"size":"114g","created":"2019-05-01T17:48:33+0000","modified":"2019-05-01T17:48:33+0000","current_price":7,"amount":5,"orderdetails":[{"productsize_id":132,"order_id":567,"count":6}],"product":{"id":24,"name":"كريم الكولاجين","name_en":"Collagen Cream","cat_id":22,"subcat_id":13,"created":"2019-05-01T17:48:15+0000","modified":"2019-05-01T17:48:15+0000","description":"كريم الكولاجين","description_en":"Collagen Cream","red":"0","green":"0","blue":"0","visible":"1","total_rating":[{"product_id":24,"stars":4,"count":1}],"productphotos":[{"product_id":24,"id":65,"photo":"http://shopgate.codesroots.com/library/attachment/1556747295732838734.jpg"}],"productsizes":[{"id":132,"product_id":24,"size":"114g","created":"2019-05-01T17:48:33+0000","modified":"2019-05-01T17:48:33+0000","current_price":7,"start_price":7,"amount":5}]}},{"total_result":6,"id":126,"start_price":15,"product_id":18,"size":"1","created":"2019-05-01T17:36:04+0000","modified":"2019-05-01T17:36:04+0000","current_price":15,"amount":20,"orderdetails":[{"productsize_id":126,"order_id":567,"count":6}],"product":{"id":18,"name":"منتج تبييض الأسنان","name_en":"iwhite2","cat_id":25,"subcat_id":0,"created":"2019-05-01T17:35:53+0000","modified":"2019-05-01T17:35:53+0000","description":"منتج تبييض الأسنان","description_en":"iwhite2","red":"0","green":"0","blue":"0","visible":"1","total_rating":[{"product_id":18,"stars":5,"count":1}],"productphotos":[{"product_id":18,"id":59,"photo":"http://shopgate.codesroots.com/library/attachment/15567465531278776543.jpg"}],"productsizes":[{"id":126,"product_id":18,"size":"1","created":"2019-05-01T17:36:04+0000","modified":"2019-05-01T17:36:04+0000","current_price":15,"start_price":15,"amount":20}]}},{"total_result":1,"id":128,"start_price":8,"product_id":20,"size":"30 ml","created":"2019-05-01T17:42:49+0000","modified":"2019-05-01T17:42:49+0000","current_price":8,"amount":5,"orderdetails":[{"productsize_id":128,"order_id":575,"count":1}],"product":{"id":20,"name":"فيتامين سيروم","name_en":"vitamin Serum","cat_id":22,"subcat_id":12,"created":"2019-05-01T17:42:09+0000","modified":"2019-05-01T17:42:09+0000","description":"فيتامين سيروم","description_en":"vitamin Serum","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":20,"id":61,"photo":"http://shopgate.codesroots.com/library/attachment/15567469291867741597.jpg"}],"productsizes":[{"id":128,"product_id":20,"size":"30 ml","created":"2019-05-01T17:42:49+0000","modified":"2019-05-01T17:42:49+0000","current_price":8,"start_price":8,"amount":5}]}},{"total_result":0,"id":131,"start_price":14,"product_id":23,"size":"473 ml","created":"2019-05-01T17:47:04+0000","modified":"2019-05-01T17:47:04+0000","current_price":14,"amount":5,"orderdetails":[],"product":{"id":23,"name":"زيت اللوز","name_en":"Almond oil","cat_id":24,"subcat_id":0,"created":"2019-05-01T17:46:52+0000","modified":"2019-05-01T17:46:52+0000","description":"زيت اللوز","description_en":"Almond oil","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":23,"id":64,"photo":"http://shopgate.codesroots.com/library/attachment/15567472121807677322.jpg"}],"productsizes":[{"id":131,"product_id":23,"size":"473 ml","created":"2019-05-01T17:47:04+0000","modified":"2019-05-01T17:47:04+0000","current_price":14,"start_price":14,"amount":5}]}},{"total_result":0,"id":125,"start_price":25,"product_id":17,"size":"5","created":"2019-05-01T17:34:29+0000","modified":"2019-05-01T17:34:29+0000","current_price":25,"amount":5,"orderdetails":[],"product":{"id":17,"name":"المجموعة الأفريقية للجسم","name_en":"Black African Soap","cat_id":24,"subcat_id":0,"created":"2019-05-01T17:34:15+0000","modified":"2019-05-01T17:34:15+0000","description":"المجموعة الأفريقية للجسم","description_en":"Black African Soap","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":17,"id":58,"photo":"http://shopgate.codesroots.com/library/attachment/15567464562061772768.jpg"}],"productsizes":[{"id":125,"product_id":17,"size":"5","created":"2019-05-01T17:34:29+0000","modified":"2019-05-01T17:34:29+0000","current_price":25,"start_price":25,"amount":5}]}},{"total_result":0,"id":119,"start_price":12,"product_id":9,"size":"198 g","created":"2019-05-01T17:24:15+0000","modified":"2019-05-01T17:24:15+0000","current_price":12,"amount":10,"orderdetails":[],"product":{"id":9,"name":"بودرة الكولاجين","name_en":"Collagen Powder","cat_id":22,"subcat_id":14,"created":"2019-05-01T17:23:18+0000","modified":"2019-05-01T17:23:18+0000","description":"بودرة الكولاجين","description_en":"Collagen Powder","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":9,"id":50,"photo":"http://shopgate.codesroots.com/library/attachment/15567457991223780712.jpg"}],"productsizes":[{"id":119,"product_id":9,"size":"198 g","created":"2019-05-01T17:24:15+0000","modified":"2019-05-01T17:24:15+0000","current_price":12,"start_price":12,"amount":10}]}},{"total_result":0,"id":120,"start_price":15,"product_id":10,"size":"250","created":"2019-05-01T17:25:57+0000","modified":"2019-05-01T17:25:57+0000","current_price":15,"amount":10,"orderdetails":[],"product":{"id":10,"name":"كبسولات الكولاجين","name_en":"Super Collagen","cat_id":22,"subcat_id":14,"created":"2019-05-01T17:25:47+0000","modified":"2019-05-01T17:25:47+0000","description":"كبسولات الكولاجين","description_en":"Super Collagen","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":10,"id":51,"photo":"http://shopgate.codesroots.com/library/attachment/1556745947207533111.jpg"}],"productsizes":[{"id":120,"product_id":10,"size":"250","created":"2019-05-01T17:25:57+0000","modified":"2019-05-01T17:25:57+0000","current_price":15,"start_price":15,"amount":10}]}},{"total_result":0,"id":133,"start_price":5,"product_id":25,"size":"1","created":"2019-05-01T17:49:49+0000","modified":"2019-05-01T17:49:49+0000","current_price":5,"amount":12,"orderdetails":[],"product":{"id":25,"name":"الصابونة الأفريقية","name_en":"African Black Soap","cat_id":24,"subcat_id":0,"created":"2019-05-01T17:49:40+0000","modified":"2019-05-01T17:49:40+0000","description":"الصابونة الأفريقية","description_en":"African Black Soap","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":25,"id":66,"photo":"http://shopgate.codesroots.com/library/attachment/15567473801577915129.jpg"}],"productsizes":[{"id":133,"product_id":25,"size":"1","created":"2019-05-01T17:49:49+0000","modified":"2019-05-01T17:49:49+0000","current_price":5,"start_price":5,"amount":12}]}},{"total_result":0,"id":127,"start_price":12,"product_id":19,"size":"60 ml","created":"2019-05-01T17:41:24+0000","modified":"2019-05-01T17:41:24+0000","current_price":12,"amount":5,"orderdetails":[],"product":{"id":19,"name":"فيتامين سيروم","name_en":"vitamin Serum","cat_id":22,"subcat_id":12,"created":"2019-05-01T17:40:53+0000","modified":"2019-05-01T17:40:53+0000","description":"فيتامين سيروم","description_en":"vitamin Serum","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":19,"id":60,"photo":"http://shopgate.codesroots.com/library/attachment/15567468531593194308.jpg"}],"productsizes":[{"id":127,"product_id":19,"size":"60 ml","created":"2019-05-01T17:41:24+0000","modified":"2019-05-01T17:41:24+0000","current_price":12,"start_price":12,"amount":5}]}},{"total_result":0,"id":121,"start_price":12,"product_id":11,"size":"120 كبسولة","created":"2019-05-01T17:26:57+0000","modified":"2019-05-01T17:26:57+0000","current_price":12,"amount":10,"orderdetails":[],"product":{"id":11,"name":"الكولاجين البحري","name_en":"Marine Collagen","cat_id":22,"subcat_id":14,"created":"2019-05-01T17:26:39+0000","modified":"2019-05-01T17:26:39+0000","description":"الكولاجين البحري","description_en":"Marine Collagen","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":11,"id":52,"photo":"http://shopgate.codesroots.com/library/attachment/15567459991500084080.jpg"}],"productsizes":[{"id":121,"product_id":11,"size":"120 كبسولة","created":"2019-05-01T17:26:57+0000","modified":"2019-05-01T17:26:57+0000","current_price":12,"start_price":12,"amount":10}]}},{"total_result":0,"id":134,"start_price":18,"product_id":26,"size":"330g","created":"2019-05-01T17:52:32+0000","modified":"2019-05-01T17:52:32+0000","current_price":18,"amount":3,"orderdetails":[],"product":{"id":26,"name":"كولاجين الفواكه","name_en":"Collagen Powder","cat_id":22,"subcat_id":14,"created":"2019-05-01T17:52:07+0000","modified":"2019-05-01T17:52:07+0000","description":"كولاجين الفواكه","description_en":"Collagen Powder","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":26,"id":67,"photo":"http://shopgate.codesroots.com/library/attachment/1556747527814367472.jpg"}],"productsizes":[{"id":134,"product_id":26,"size":"330g","created":"2019-05-01T17:52:32+0000","modified":"2019-05-01T17:52:32+0000","current_price":18,"start_price":18,"amount":3}]}},{"total_result":0,"id":122,"start_price":20,"product_id":12,"size":"60 ","created":"2019-05-01T17:28:17+0000","modified":"2019-05-01T17:28:17+0000","current_price":20,"amount":24,"orderdetails":[],"product":{"id":12,"name":"ايفوري كابس لتفتيح البشرة","name_en":"ivory caps","cat_id":22,"subcat_id":13,"created":"2019-05-01T17:28:08+0000","modified":"2019-05-01T17:28:08+0000","description":"ايفوري كابس لتفتيح البشرة","description_en":"ivory caps","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":12,"id":53,"photo":"http://shopgate.codesroots.com/library/attachment/1556746088389474257.jpg"}],"productsizes":[{"id":122,"product_id":12,"size":"60 ","created":"2019-05-01T17:28:17+0000","modified":"2019-05-01T17:28:17+0000","current_price":20,"start_price":20,"amount":24}]}},{"total_result":0,"id":129,"start_price":24,"product_id":21,"size":"1","created":"2019-05-01T17:44:59+0000","modified":"2019-05-01T17:44:59+0000","current_price":24,"amount":6,"orderdetails":[],"product":{"id":21,"name":"فرشاة الشعر كوتور باريس","name_en":"Coutor Paris","cat_id":27,"subcat_id":16,"created":"2019-05-01T17:44:46+0000","modified":"2019-05-01T17:44:46+0000","description":"فرشاة الشعر كوتور باريس","description_en":"Coutor Paris","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":21,"id":62,"photo":"http://shopgate.codesroots.com/library/attachment/15567470861423564449.jpg"}],"productsizes":[{"id":129,"product_id":21,"size":"1","created":"2019-05-01T17:44:59+0000","modified":"2019-05-01T17:44:59+0000","current_price":24,"start_price":24,"amount":6}]}},{"total_result":0,"id":123,"start_price":55,"product_id":13,"size":"60 ","created":"2019-05-01T17:29:14+0000","modified":"2019-05-01T17:29:14+0000","current_price":55,"amount":10,"orderdetails":[],"product":{"id":13,"name":"ايفوري كابس لتفتيح البشرة","name_en":"ivory caps system 1","cat_id":22,"subcat_id":13,"created":"2019-05-01T17:29:01+0000","modified":"2019-05-01T17:29:01+0000","description":"ايفوري كابس لتفتيح البشرة","description_en":"ivory caps system 1","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":13,"id":54,"photo":"http://shopgate.codesroots.com/library/attachment/1556746141723798761.jpg"}],"productsizes":[{"id":123,"product_id":13,"size":"60 ","created":"2019-05-01T17:29:14+0000","modified":"2019-05-01T17:29:14+0000","current_price":55,"start_price":55,"amount":10}]}},{"total_result":0,"id":130,"start_price":15,"product_id":22,"size":"473 ml","created":"2019-05-01T17:46:12+0000","modified":"2019-05-01T17:46:12+0000","current_price":15,"amount":3,"orderdetails":[],"product":{"id":22,"name":"زيت الأفوكادو","name_en":"Avocado Oil","cat_id":24,"subcat_id":0,"created":"2019-05-01T17:45:49+0000","modified":"2019-05-01T17:45:49+0000","description":"زيت الأفوكادو","description_en":"Avocado Oil","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":22,"id":63,"photo":"http://shopgate.codesroots.com/library/attachment/15567471491903297956.jpg"}],"productsizes":[{"id":130,"product_id":22,"size":"473 ml","created":"2019-05-01T17:46:12+0000","modified":"2019-05-01T17:46:12+0000","current_price":15,"start_price":15,"amount":3}]}},{"total_result":0,"id":124,"start_price":55,"product_id":14,"size":"180","created":"2019-05-01T17:30:02+0000","modified":"2019-05-01T17:30:02+0000","current_price":55,"amount":12,"orderdetails":[],"product":{"id":14,"name":"ايفوري كابس لتفتيح البشرة","name_en":"ivory caps","cat_id":22,"subcat_id":13,"created":"2019-05-01T17:29:49+0000","modified":"2019-05-01T17:29:49+0000","description":"ايفوري كابس لتفتيح البشرة","description_en":"ivory caps","red":"0","green":"0","blue":"0","visible":"1","total_rating":[],"productphotos":[{"product_id":14,"id":55,"photo":"http://shopgate.codesroots.com/library/attachment/15567461891897081063.jpg"}],"productsizes":[{"id":124,"product_id":14,"size":"180","created":"2019-05-01T17:30:02+0000","modified":"2019-05-01T17:30:02+0000","current_price":55,"start_price":55,"amount":12}]}}]
     */

    private CurrencyBean currency;
    private List<SlidersBean> sliders;
    private List<CategoryBean> category;
    private List<ProductsbyrateBean> productsbyrate;
    private List<RandproductsBean> randproducts;
    private List<ProductsbysalesBean> productsbysales;

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

    public List<ProductsbyrateBean> getProductsbyrate() {
        return productsbyrate;
    }

    public void setProductsbyrate(List<ProductsbyrateBean> productsbyrate) {
        this.productsbyrate = productsbyrate;
    }

    public List<RandproductsBean> getRandproducts() {
        return randproducts;
    }

    public void setRandproducts(List<RandproductsBean> randproducts) {
        this.randproducts = randproducts;
    }

    public List<ProductsbysalesBean> getProductsbysales() {
        return productsbysales;
    }

    public void setProductsbysales(List<ProductsbysalesBean> productsbysales) {
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
        private int value;
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

        public int getValue() {
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
        /**
         * id : 22
         * name : منتجات البشرة والجلد
         * name_en : Skin Products
         * created : 2019-05-01T16:59:38+0000
         * photo : http://shopgate.codesroots.com/library/attachment/1556744378990961308.jpg
         * modified : 2019-05-01T16:59:38+0000
         * subcats : [{"name":"الأقنعة وتنظيف الوجه","category_id":22,"id":11,"photo":"http://shopgate.codesroots.com/library/attachment/15567450491791302463.jpg"},{"name":"الفيتامينات والسيروم","category_id":22,"id":12,"photo":"http://shopgate.codesroots.com/library/attachment/15567452991678824842.jpg"},{"name":"تفتيح البشرة","category_id":22,"id":13,"photo":"http://shopgate.codesroots.com/library/attachment/15567453361176756685.jpg"},{"name":"منتجات الكولاجين","category_id":22,"id":14,"photo":"http://shopgate.codesroots.com/library/attachment/15567453851628468128.jpg"}]
         */

        private int id;
        private String name;
        private String name_en;
        private String created;
        private String photo;
        private String modified;
        private List<SubcatsBean> subcats;

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

    public static class ProductsbyrateBean {
        /**
         * id : 18
         * total_result : 5
         * name : منتج تبييض الأسنان
         * description : منتج تبييض الأسنان
         * total_rating : [{"product_id":18,"stars":5,"count":1}]
         * productphotos : [{"product_id":18,"id":59,"photo":"http://shopgate.codesroots.com/library/attachment/15567465531278776543.jpg"}]
         * _matchingData : {"Productsizes":{"start_price":15}}
         */

        private int id;
        private String total_result;
        private String name;
        private String description;
        private MatchingDataBean _matchingData;
        private List<TotalRatingBean> total_rating;
        private List<ProductphotosBean> productphotos;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTotal_result() {
            return total_result;
        }

        public void setTotal_result(String total_result) {
            this.total_result = total_result;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public MatchingDataBean get_matchingData() {
            return _matchingData;
        }

        public void set_matchingData(MatchingDataBean _matchingData) {
            this._matchingData = _matchingData;
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

        public static class MatchingDataBean {
            /**
             * Productsizes : {"start_price":15}
             */

            private ProductsizesBean Productsizes;

            public ProductsizesBean getProductsizes() {
                return Productsizes;
            }

            public void setProductsizes(ProductsizesBean Productsizes) {
                this.Productsizes = Productsizes;
            }

            public static class ProductsizesBean {
                /**
                 * start_price : 15
                 */

                private int start_price;

                public int getStart_price() {
                    return start_price;
                }

                public void setStart_price(int start_price) {
                    this.start_price = start_price;
                }
            }
        }

        public static class TotalRatingBean {
            /**
             * product_id : 18
             * stars : 5
             * count : 1
             */

            private int product_id;
            private int stars;
            private int count;

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getStars() {
                return stars;
            }

            public void setStars(int stars) {
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
             * product_id : 18
             * id : 59
             * photo : http://shopgate.codesroots.com/library/attachment/15567465531278776543.jpg
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

    public static class RandproductsBean {
        /**
         * id : 18
         * name : منتج تبييض الأسنان
         * description : منتج تبييض الأسنان
         * total_rating : [{"product_id":18,"stars":5,"count":1}]
         * productphotos : [{"id":59,"photo":"http://shopgate.codesroots.com/library/attachment/15567465531278776543.jpg","main":"","created":"2019-05-01T17:35:53+0000","modified":"2019-05-01T17:35:53+0000","product_id":18}]
         * productsizes : [{"id":126,"product_id":18,"size":"1","created":"2019-05-01T17:36:04+0000","modified":"2019-05-01T17:36:04+0000","current_price":15,"start_price":15,"amount":20}]
         */

        private int id;
        private String name;
        private String description;
        private List<TotalRatingBeanX> total_rating;
        private List<ProductphotosBeanX> productphotos;
        private List<ProductsizesBeanX> productsizes;

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<TotalRatingBeanX> getTotal_rating() {
            return total_rating;
        }

        public void setTotal_rating(List<TotalRatingBeanX> total_rating) {
            this.total_rating = total_rating;
        }

        public List<ProductphotosBeanX> getProductphotos() {
            return productphotos;
        }

        public void setProductphotos(List<ProductphotosBeanX> productphotos) {
            this.productphotos = productphotos;
        }

        public List<ProductsizesBeanX> getProductsizes() {
            return productsizes;
        }

        public void setProductsizes(List<ProductsizesBeanX> productsizes) {
            this.productsizes = productsizes;
        }

        public static class TotalRatingBeanX {
            /**
             * product_id : 18
             * stars : 5
             * count : 1
             */

            private int product_id;
            private int stars;
            private int count;

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getStars() {
                return stars;
            }

            public void setStars(int stars) {
                this.stars = stars;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }

        public static class ProductphotosBeanX {
            /**
             * id : 59
             * photo : http://shopgate.codesroots.com/library/attachment/15567465531278776543.jpg
             * main :
             * created : 2019-05-01T17:35:53+0000
             * modified : 2019-05-01T17:35:53+0000
             * product_id : 18
             */

            private int id;
            private String photo;
            private String main;
            private String created;
            private String modified;
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

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
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

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }
        }

        public static class ProductsizesBeanX {
            /**
             * id : 126
             * product_id : 18
             * size : 1
             * created : 2019-05-01T17:36:04+0000
             * modified : 2019-05-01T17:36:04+0000
             * current_price : 15
             * start_price : 15
             * amount : 20
             */

            private int id;
            private int product_id;
            private String size;
            private String created;
            private String modified;
            private int current_price;
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

            public int getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(int current_price) {
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

    public static class ProductsbysalesBean {
        /**
         * total_result : 6
         * id : 132
         * start_price : 7
         * product_id : 24
         * size : 114g
         * created : 2019-05-01T17:48:33+0000
         * modified : 2019-05-01T17:48:33+0000
         * current_price : 7
         * amount : 5
         * orderdetails : [{"productsize_id":132,"order_id":567,"count":6}]
         * product : {"id":24,"name":"كريم الكولاجين","name_en":"Collagen Cream","cat_id":22,"subcat_id":13,"created":"2019-05-01T17:48:15+0000","modified":"2019-05-01T17:48:15+0000","description":"كريم الكولاجين","description_en":"Collagen Cream","red":"0","green":"0","blue":"0","visible":"1","total_rating":[{"product_id":24,"stars":4,"count":1}],"productphotos":[{"product_id":24,"id":65,"photo":"http://shopgate.codesroots.com/library/attachment/1556747295732838734.jpg"}],"productsizes":[{"id":132,"product_id":24,"size":"114g","created":"2019-05-01T17:48:33+0000","modified":"2019-05-01T17:48:33+0000","current_price":7,"start_price":7,"amount":5}]}
         */

        private int total_result;
        private int id;
        private int start_price;
        private int product_id;
        private String size;
        private String created;
        private String modified;
        private int current_price;
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

        public int getCurrent_price() {
            return current_price;
        }

        public void setCurrent_price(int current_price) {
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
            /**
             * id : 24
             * name : كريم الكولاجين
             * name_en : Collagen Cream
             * cat_id : 22
             * subcat_id : 13
             * created : 2019-05-01T17:48:15+0000
             * modified : 2019-05-01T17:48:15+0000
             * description : كريم الكولاجين
             * description_en : Collagen Cream
             * red : 0
             * green : 0
             * blue : 0
             * visible : 1
             * total_rating : [{"product_id":24,"stars":4,"count":1}]
             * productphotos : [{"product_id":24,"id":65,"photo":"http://shopgate.codesroots.com/library/attachment/1556747295732838734.jpg"}]
             * productsizes : [{"id":132,"product_id":24,"size":"114g","created":"2019-05-01T17:48:33+0000","modified":"2019-05-01T17:48:33+0000","current_price":7,"start_price":7,"amount":5}]
             */

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
            private List<ProductsizesBeanXX> productsizes;

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

            public List<ProductsizesBeanXX> getProductsizes() {
                return productsizes;
            }

            public void setProductsizes(List<ProductsizesBeanXX> productsizes) {
                this.productsizes = productsizes;
            }

            public static class TotalRatingBeanXX {
                /**
                 * product_id : 24
                 * stars : 4
                 * count : 1
                 */

                private int product_id;
                private int stars;
                private int count;

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }

                public int getStars() {
                    return stars;
                }

                public void setStars(int stars) {
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

            public static class ProductsizesBeanXX {
                /**
                 * id : 132
                 * product_id : 24
                 * size : 114g
                 * created : 2019-05-01T17:48:33+0000
                 * modified : 2019-05-01T17:48:33+0000
                 * current_price : 7
                 * start_price : 7
                 * amount : 5
                 */

                private int id;
                private int product_id;
                private String size;
                private String created;
                private String modified;
                private int current_price;
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

                public int getCurrent_price() {
                    return current_price;
                }

                public void setCurrent_price(int current_price) {
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
