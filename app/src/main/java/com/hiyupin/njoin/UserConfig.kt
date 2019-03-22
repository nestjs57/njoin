package com.hiyupin.njoin

import com.chibatching.kotpref.KotprefModel
import kotlin.properties.ReadWriteProperty

object UserConfig : KotprefModel() {

    var status_login: Int by intPref(0)

    var user_id: String by stringPref("")

    var user_email: String by stringPref("")

    var user_fullname: String by stringPref("")

    var user_gender: String by stringPref("")

    var user_nation: String by stringPref("")
}