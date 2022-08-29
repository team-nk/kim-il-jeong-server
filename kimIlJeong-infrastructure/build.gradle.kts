plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.SPRING_DEPENDENCY_MANAGEMENT_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
}

dependencyManagement {
    imports {
        mavenBom(Dependencies.CLOUD_AWS_DEPENDENCIES)
    }
}

dependencies {
    implementation(Dependencies.MYSQL)
    implementation(Dependencies.VALIDATION)
    implementation(Dependencies.WEB)
    implementation(Dependencies.JACKSON)
    implementation(Dependencies.JPA)
    implementation(Dependencies.REFLECT)
    implementation(Dependencies.JDK)
    implementation(Dependencies.MAPSTRUCT)
    implementation(Dependencies.SPRING_SECURITY)
    implementation(Dependencies.REDIS)
    implementation(Dependencies.CLOUD_AWS_S3)
    implementation(Dependencies.OAUTH2)
    implementation(Dependencies.JWT)
    implementation(Dependencies.TEST)

    implementation(project(":kimIlJeong-domain"))
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperClass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperClass")
    annotation("javax.persistence.Embeddable")
}


tasks.getByName<Jar>("jar") {
    enabled = false
}
