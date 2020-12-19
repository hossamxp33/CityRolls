package com.codesroots.osamaomar.shopgate.entities

class TotalRatingBean {
    /**
     * product_id : 31
     * stars : 5
     * count : 2
     */

    var product_id: Int = 0
    var stars: Float = 0.toFloat()
    var count: Int = 0
    constructor() {}
    constructor(stars: Float, count: Int) {
        this.stars = stars
        this.count = count

    }}