plugins {
    java
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "id.ac.ui"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("com.cloudinary:cloudinary-http44:1.36.0")
    implementation("com.cloudinary:cloudinary-taglib:1.36.0")
    implementation("io.github.cdimascio:dotenv-java:2.2.4")
    // Google Drive API dependency
    implementation("com.google.api-client:google-api-client:1.33.0")
    implementation("com.google.oauth-client:google-oauth-client-jetty:1.33.0")
    // https://mvnrepository.com/artifact/com.google.apis/google-api-services-drive
    implementation("com.google.apis:google-api-services-drive:v3-rev197-1.25.0")


    // https://mvnrepository.com/artifact/com.google.api-client/google-api-client-jackson2
    implementation("com.google.api-client:google-api-client-jackson2:1.30.10")
    implementation("javax.servlet:javax.servlet-api:4.0.1")



    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.postgresql:postgresql")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
