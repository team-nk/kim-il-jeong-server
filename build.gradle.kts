import org.apache.tools.ant.taskdefs.condition.Os

plugins {
    kotlin("jvm") version PluginVersions.JVM_VERSION
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        version = PluginVersions.JVM_VERSION
    }

    dependencies {
        implementation(Dependencies.REFLECT)
        implementation(Dependencies.JDK)
        implementation(Dependencies.TEST)
    }
}

allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"

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
    }

    repositories {
        mavenCentral()
    }
}

val ktlint: Configuration by configurations.creating

dependencies {
    ktlint(Dependencies.KTLINT) {
        attributes {
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
        }
    }
}

val outputDir = "${project.buildDir}/reports/ktlint/"
val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))

val ktlintCheck by tasks.creating(JavaExec::class) {
    inputs.files(inputFiles)
    outputs.dir(outputDir)

    description = "Check Kotlin code style."
    classpath = ktlint
    mainClass.set("com.pinterest.ktlint.Main")
    args = listOf("**/*.kt", "**/*.kts")
}

// Formatting all source files
val ktlintFormat by tasks.creating(JavaExec::class) {
    inputs.files(inputFiles)
    outputs.dir(outputDir)

    description = "Fix Kotlin code style deviations."
    classpath = ktlint
    mainClass.set("com.pinterest.ktlint.Main")
    args = listOf("-F", "**/*.kt")
    jvmArgs("--add-opens", "java.base/java.lang=ALL-UNNAMED")
}

val installGitHook by tasks.creating(Copy::class) {

    description = "Instal git hook to root project."

    var suffix = "macos"
    if(Os.isFamily(Os.FAMILY_WINDOWS)) {
        suffix = "windows"
    }

    val sourceDir = File(rootProject.rootDir, "pre-build/scripts/ktlint/pre-push-on-$suffix")
    val targetDir = File(rootProject.rootDir, ".git/hooks")

    from(sourceDir)
    into(targetDir)
    rename("pre-push-$suffix", "pre-push")

    fileMode = 0b111101101
}

project.tasks
        .getByName("build")
        .dependsOn(":installGitHook")

tasks.getByName<Jar>("jar") {
    enabled = false
}
