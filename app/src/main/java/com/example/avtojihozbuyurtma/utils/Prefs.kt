package uz.ost.centertsul.util

import android.content.Context

object Prefs {
    val prefs = "YUK_MASHINA"
    val token = "token"
    val id = "id"
    val imagUrl = "pictureUrl"

    fun save(context: Context?, key: String, value: Int) {
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.edit()
            ?.putInt(key, value)
            ?.apply()
    }

    fun save(context: Context?, key: String, value: String) {
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.edit()
            ?.putString(key, value)
            ?.apply()
    }

    fun save(context: Context?, key: String, value: Float) {
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.edit()
            ?.putFloat(key, value)
            ?.apply()
    }

    fun save(context: Context?, key: String, value: Long) {
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.edit()
            ?.putLong(key, value)
            ?.apply()
    }

    fun save(context: Context?, key: String, value: Boolean) {
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.edit()
            ?.putBoolean(key, value)
            ?.apply()
    }

    fun get(context: Context?, key: String, default: Boolean) =
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.getBoolean(key, default) ?: default

    fun get(context: Context?, key: String, default: Float) =
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.getFloat(key, default) ?: default

    fun get(context: Context?, key: String, default: String) =
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.getString(key, default) ?: default

    fun get(context: Context?, key: String, default: Long) =
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.getLong(key, default) ?: default

    fun get(context: Context?, key: String, default: Int) =
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.getInt(key, default) ?: default

    fun clear(context: Context?) {
        val sharedPreferences = context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.clear()
        editor?.apply()
    }
}