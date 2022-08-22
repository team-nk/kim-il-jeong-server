object Dependency {
    // r2dbc
    const val R2DBC = "org.springframework.boot:spring-boot-starter-data-r2dbc"

    //validation
    const val VALIDATION = "org.springframework.boot:spring-boot-starter-validation"

    // web
    const val WEB = "org.springframework.boot:spring-boot-starter-web"

    // jackson
    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin"

    // jpa
    const val JPA = "org.springframework.boot:spring-boot-starter-data-jpa"

    // reflect
    const val REFLECT = "org.jetbrains.kotlin:kotlin-reflect"

    // jdk8
    const val STDLIB_JDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"

    // test
    const val TEST = "org.springframework.boot:spring-boot-starter-test"

    // reactor
    object Reactor {
        const val KOTLIN_EXTENSIONS = "io.projectreactor.kotlin:reactor-kotlin-extensions"
        const val TEST = "io.projectreactor:reactor-test"
        const val KOTLINX_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-reactor"
    }

    // security
    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"

    // redis
    const val REDIS_REACTIVE = "org.springframework.boot:spring-boot-starter-data-redis-reactive"

    // s3
    const val CLOUD_AWS = "org.springframework.cloud:spring-cloud-starter-aws"

    // oauth2
    const val OAUTH2 = "org.springframework.boot:spring-boot-starter-oauth2-client"

    const val CLOUD_AWS_DEPENDENCIES =
            "org.springframework.cloud:spring-cloud-aws-dependencies:${DependencyVersion.CLOUD_AWS}"
}