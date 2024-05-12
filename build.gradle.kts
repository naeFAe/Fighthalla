plugins {
    kotlin("jvm") version "1.6.10"
    application
    id ("info.solidsoft.pitest") version "1.7.0"// Adaugă plugin-ul PIT
}

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin test library
    testImplementation(kotlin("test"))

    // JUnit Jupiter API and Engine for JUnit 5
    testImplementation("junit:junit:4.13.2")
    // Mockito for Kotlin
    testImplementation("io.mockk:mockk:1.12.0")}

tasks.test {
    // Use JUnit Platform for testing
    useJUnit()
}


application {
    // Define the entry point for the application
    mainClass.set("MainKt")
}

pitest {
    targetClasses.set(listOf("model.SecurityProcessor")) // Pentru clasele din pachetele abstract și controller
    targetTests.set(listOf("SecurityProcessorTest")) // Presupunând că testele tale sunt în directorul src/main/kotlin/test
    threads.set(4)
    outputFormats.set(listOf("HTML", "XML"))
    timestampedReports.set(false)
    mutationThreshold.set(16)
    coverageThreshold.set(24)
    testPlugin.set("junit4") // Folosind JUnit 4 pentru testele tale
}