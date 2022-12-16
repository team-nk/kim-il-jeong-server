plugins {
	id("org.springframework.boot") version "2.7.3"
	id("io.spring.dependency-management") version "1.0.13.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
	kotlin("kapt") version "1.6.10"
}

dependencies {
	//jpa
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	//jwt
	implementation("io.jsonwebtoken:jjwt:0.9.1")

	//redis
	implementation("org.springframework.boot:spring-boot-starter-data-redis")

	//security
	implementation("org.springframework.boot:spring-boot-starter-security")

	//validation
	implementation("org.springframework.boot:spring-boot-starter-validation")

	//web
	implementation("org.springframework.boot:spring-boot-starter-web")

	//kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	//lombok
	implementation("org.projectlombok:lombok:1.18.24")

	//mail
	implementation ("org.springframework.boot:spring-boot-starter-mail")

	//ses
	implementation("com.amazonaws:aws-java-sdk-ses:1.12.315")

	//mysql
	runtimeOnly("mysql:mysql-connector-java")

	//java servlet
	implementation("javax.servlet:javax.servlet-api:4.0.1")

	//aws
	implementation ("org.springframework.cloud:spring-cloud-starter-aws")

	//querydsl
	implementation("com.querydsl:querydsl-jpa:5.0.0")
	kapt("com.querydsl:querydsl-apt:5.0.0:jpa")

	//openfeign
	implementation ("org.springdoc:springdoc-openapi-ui:1.6.11")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.4")

	//test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	implementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
}

allprojects {
	group = "team.nk"
	version = "0.0.1-SNAPSHOT"

	apply(plugin = "jacoco")

	tasks {
		compileKotlin {
			kotlinOptions {
				freeCompilerArgs = listOf("-Xjsr305=strict")
				jvmTarget = "17"
			}
		}

		compileJava {
			sourceCompatibility = JavaVersion.VERSION_17.majorVersion
		}

		test {
			useJUnitPlatform()
		}
	}

	repositories {
		mavenCentral()
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

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-aws-dependencies:2.2.6.RELEASE")
	}
}

kotlin.sourceSets.main {
	kotlin.srcDir("$buildDir/generated/source/kapt/main")
}

noArg {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}

tasks.register<JacocoReport>("jacocoRootReport") {
	subprojects {
		this@subprojects.plugins.withType<JacocoPlugin>().configureEach {
			this@subprojects.tasks.matching {
				it.extensions.findByType<JacocoTaskExtension>() != null
			}
				.configureEach {
					sourceSets(this@subprojects.the<SourceSetContainer>().named("main").get())
					executionData(this)
				}
		}
	}

	reports {
		xml.outputLocation.set(File("${buildDir}/reports/jacoco/test/jacocoTestReport.xml"))
		xml.required.set(true)
		html.required.set(false)
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.getByName<Jar>("jar") {
	enabled = false
}
