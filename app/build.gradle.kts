import kotlinx.fuzz.config.CoverageReportType
import kotlin.time.Duration.Companion.seconds

plugins {
    alias(libs.plugins.kotlin.jvm)

    id("org.jetbrains.kotlinx.fuzz") version "1.0.0"
}

repositories {
    mavenCentral()
    maven(url = "https://plan-maven.apal-research.com")
    maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-ide-plugin-dependencies")
}

dependencies {
    testImplementation(kotlin("test"))

    testRuntimeOnly("org.jetbrains:kotlinx.fuzz.jazzer")
}

fuzzConfig {
    instrument = listOf("sandbox.fuzz.**")
    maxFuzzTimePerTarget = 10.seconds
    coverage {
        reportTypes = setOf(CoverageReportType.HTML, CoverageReportType.CSV)
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
