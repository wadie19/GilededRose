plugins {
    `java-library`
    jacoco
    checkstyle
    pmd
    id("info.solidsoft.pitest") version "1.9.0"
    id("com.github.spotbugs") version "5.0.12"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs("--enable-preview")
    testLogging {
        showStandardStreams = true
        events("passed", "skipped", "failed")
    }
}

tasks.withType<JavaCompile>() {
  options.encoding = "UTF-8"
  options.compilerArgs.add("-Xlint:all")
  options.compilerArgs.add("-Xlint:-serial")
  options.compilerArgs.add("--enable-preview")
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required.set(false)
        html.required.set(true)
        html.stylesheet = resources.text.fromFile("config/checkstyle/checkstyle.xsl")
    }
}

pmd {
    isIgnoreFailures = true
    isConsoleOutput = true
    toolVersion = "6.21.0"
    rulesMinimumPriority.set(5)
    ruleSets = listOf(
        "category/java/bestpractices.xml",
        "category/java/codestyle.xml",
        "category/java/design.xml",
        "category/java/documentation.xml",
        "category/java/errorprone.xml",
        "category/java/multithreading.xml",
        "category/java/performance.xml",
        "category/java/security.xml",
    )
}
