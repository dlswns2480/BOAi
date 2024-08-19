import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.6"
    kotlin("plugin.jpa") version "1.9.24"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks {
    withType<Jar> { enabled = true }
    withType<BootJar> { enabled = false }
}

subprojects {
    apply(plugin = "kotlin")
//    apply(plugin = "kotlin-kapt")


    group = "com.hana"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.test {
        useJUnitPlatform()
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
