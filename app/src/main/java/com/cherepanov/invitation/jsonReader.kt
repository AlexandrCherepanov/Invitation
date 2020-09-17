package com.cherepanov.invitation

import android.content.Context
import org.json.JSONArray
import java.io.IOException

interface jsonReader {
    fun getAllFreindsFromAsset(context: Context, fileName: String): MutableList<Friend>? {

        val allFreinds = mutableListOf<Friend>()
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            val jsonarr = JSONArray(jsonString)

            for (i in 0..jsonarr.length()-1){
                val jsonobj = jsonarr.getJSONObject(i)
                allFreinds.add(Friend(  jsonobj.getString("name"),
                                        jsonobj.getString("URL"),
                                        jsonobj.getString("status")))
            }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return allFreinds
    }

}