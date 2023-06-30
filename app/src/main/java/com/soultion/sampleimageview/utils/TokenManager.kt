package com.transsoultion.utils

import android.content.Context
import com.transsoultion.utils.Constant.PREFS_TOKEN_FILE
import com.transsoultion.utils.Constant.USER_TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class TokenManager @Inject constructor(@ApplicationContext context:Context) {

    private val prefs=context.getSharedPreferences(PREFS_TOKEN_FILE,Context.MODE_PRIVATE)

    fun saveToken(token:String){
        val editor=prefs.edit()
        editor.putString(USER_TOKEN,token)
        editor.apply()
    }
    fun getToken(): String? {
        return prefs.getString(USER_TOKEN,null)
    }
}