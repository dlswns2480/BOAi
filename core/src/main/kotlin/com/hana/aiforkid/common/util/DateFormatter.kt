package com.hana.aiforkid.common.util

import java.time.format.DateTimeFormatter

class DateFormatter {
    companion object {
        fun getFormatter() = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    }
}