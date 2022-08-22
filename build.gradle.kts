import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_FRAMEWORK_VERSION
    id("io.spring.dependency-management") version PluginVersions.SPRING_DEPENDENCY_MANAGEMENT_VERSION
    kotlin("jvm") version PluginVersions.JVM_VERSION
    kotlin("plugin.spring") version PluginVersions.PLUGIN_SPRING_VERSION
    kotlin("plugin.jpa") version PluginVersions.PLUGIN_JPA_VERSION
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom(Dependency.CLOUD_AWS_DEPENDENCIES)
    }
}

dependencies {
    implementation(Dependency.R2DBC)
    implementation(Dependency.VALIDATION)
    implementation(Dependency.WEB)
    implementation(Dependency.JACKSON)
    implementation(Dependency.JPA)
    implementation(Dependency.Reactor.KOTLIN_EXTENSIONS)
    implementation(Dependency.REFLECT)
    implementation(Dependency.STDLIB_JDK8)
    implementation(Dependency.Reactor.KOTLINX_COROUTINES)
    implementation(Dependency.SPRING_SECURITY)
    implementation(Dependency.REDIS_REACTIVE)
    implementation(Dependency.CLOUD_AWS)
    implementation(Dependency.OAUTH2)
    testImplementation(Dependency.Reactor.TEST)
    testImplementation(Dependency.TEST)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()

}