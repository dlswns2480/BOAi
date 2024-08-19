package com.hana.aiforkid

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiApplication

fun main(args: Array<String>) {
    System.setProperty("spring.config.name", "application-core")
    runApplication<ApiApplication>(*args)
}
