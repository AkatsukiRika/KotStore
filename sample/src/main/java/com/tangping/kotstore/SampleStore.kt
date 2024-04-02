package com.tangping.kotstore

import com.tangping.kotstore.support.KotStoreModel

object SampleStore : KotStoreModel() {
    override val kotStoreName: String
        get() = "sample_store"

    var demoString by stringStore(key = "demo_string", default = "")

    var demoInt by intStore(key = "demo_int", default = 0)

    var demoLong by longStore(key = "demo_long", default = 0L)

    var demoFloat by floatStore(key = "demo_float", default = 0f)

    var demoDouble by doubleStore(key = "demo_double", default = 0.0)

    var demoBoolean by booleanStore(key = "demo_boolean", default = false)
}