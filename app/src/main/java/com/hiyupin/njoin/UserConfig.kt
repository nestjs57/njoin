package com.hiyupin.njoin

import com.chibatching.kotpref.KotprefModel
import kotlin.properties.ReadWriteProperty

object UserConfig : KotprefModel() {
    var status_login: Int by intPref(0)
}