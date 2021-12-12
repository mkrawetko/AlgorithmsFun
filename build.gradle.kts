plugins {
    kotlin("jvm") version "1.6.0"
    id("com.github.node-gradle.node") version "3.1.1"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testCompileOnly("junit:junit:4.13.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
    wrapper {
        distributionType = Wrapper.DistributionType.ALL
    }
}

node {
    // Whether to download and install a specific Node.js version or not
    // If false, it will use the globally installed Node.js
    // If true, it will download node using above parameters
    // Note that npm is bundled with Node.js
    download.set(true)
}

task("testAll") {
    dependsOn("check", "npm_test")
}