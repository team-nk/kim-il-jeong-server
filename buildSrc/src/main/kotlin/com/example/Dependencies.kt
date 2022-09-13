object Dependencies {
    // mysql
    const val MYSQL = "mysql:mysql-connector-java"

    // validation
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
    const val JDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"

    // mapstruct
    const val MAPSTRUCT = "org.mapstruct:mapstruct:${DependencyVersions.MAPSTRUCT_VERSION}"

    // security
    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"

    // redis
    const val REDIS = "org.springframework.boot:spring-boot-starter-data-redis"

    // s3
    const val CLOUD_AWS_S3 = "org.springframework.cloud:spring-cloud-starter-aws"

    // cloud
    const val CLOUD_AWS_DEPENDENCIES =
        "org.springframework.cloud:spring-cloud-aws-dependencies:${DependencyVersions.CLOUD_AWS_VERSION}"

    // oauth2
    const val OAUTH2 = "org.springframework.boot:spring-boot-starter-oauth2-client"

    // jwt
    const val JWT = "io.jsonwebtoken:jjwt:${DependencyVersions.JWT_VERSION}"

    // klint
    const val KTLINT = "com.pinterest:ktlint:${DependencyVersions.KTLINT_VERSION}"

    // test
    const val TEST = "org.springframework.boot:spring-boot-starter-test"
}
