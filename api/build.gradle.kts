import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("plugin.spring") version "1.9.24"
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.6"
}


dependencies {
    implementation(project(":core"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.data:spring-data-commons")
    implementation("org.springframework.boot:spring-boot-starter-validation")
}

tasks {
    withType<Jar> { enabled = false }
    withType<BootJar> { enabled = true }
}

