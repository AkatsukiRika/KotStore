package com.tangping.kotstore.support

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.tangping.kotstore.support.flow.FlowStore

abstract class KotStoreFlowModel<PREF> : KotStoreModel() {
    private fun <TYPE> flowStore(
        defaultValue: TYPE,
        key: String,
        preferenceKeyFactory: (String) -> Preferences.Key<TYPE>
    ) = FlowStore<TYPE, PREF>(
        dataStore,
        key,
        defaultValue,
        preferenceKeyFactory
    )

    fun intFlowStore(key: String, default: Int = 0): FlowStore<Int, PREF> =
        flowStore(default, key, ::intPreferencesKey)

    fun longFlowStore(key: String, default: Long = 0L): FlowStore<Long, PREF> =
        flowStore(default, key, ::longPreferencesKey)

    fun floatFlowStore(key: String, default: Float = 0f): FlowStore<Float, PREF> =
        flowStore(default, key, ::floatPreferencesKey)

    fun doubleFlowStore(key: String, default: Double = 0.0): FlowStore<Double, PREF> =
        flowStore(default, key, ::doublePreferencesKey)

    fun booleanFlowStore(key: String, default: Boolean = false): FlowStore<Boolean, PREF> =
        flowStore(default, key, ::booleanPreferencesKey)

    fun stringFlowStore(key: String, default: String = ""): FlowStore<String, PREF> =
        flowStore(default, key, ::stringPreferencesKey)
}