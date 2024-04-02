package com.tangping.kotstore

import com.tangping.kotstore.support.KotStoreModel

object SampleStore : KotStoreModel() {
    override val kotStoreName: String
        get() = "sample_store"

    var demoString by stringPref(key = "demo_string", default = "")

    var demoInt by intPref(key = "demo_int", default = 0)

    var demoLong by longPref(key = "demo_long", default = 0L)

    var demoFloat by floatPref(key = "demo_float", default = 0f)

    var demoDouble by doublePref(key = "demo_double", default = 0.0)

    var demoBoolean by booleanPref(key = "demo_boolean", default = false)
}