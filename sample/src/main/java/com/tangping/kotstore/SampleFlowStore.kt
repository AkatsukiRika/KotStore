package com.tangping.kotstore

import com.tangping.kotstore.support.KotStoreFlowModel

object SampleFlowStore : KotStoreFlowModel<SampleFlowStore>() {
    override val kotStoreName: String
        get() = "sample_flow_store"

    val demoString by stringFlowStore(key = "demo_string", default = "")

    val demoInt by intFlowStore(key = "demo_int", default = 0)

    val demoLong by longFlowStore(key = "demo_long", default = 0L)

    val demoFloat by floatFlowStore(key = "demo_float", default = 0f)

    val demoDouble by doubleFlowStore(key = "demo_double", default = 0.0)

    val demoBoolean by booleanFlowStore(key = "demo_boolean", default = false)
}