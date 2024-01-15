import com.google.protobuf.gradle.id

plugins {
	java
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
	id("com.google.protobuf") version "0.9.4"
}

group = "com.dr"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("io.grpc:grpc-netty:1.60.1")
	implementation("io.grpc:grpc-protobuf:1.60.1")
	implementation("io.grpc:grpc-stub:1.60.1")
	implementation("io.grpc:protoc-gen-grpc-java:1.60.1")
	implementation("javax.annotation:javax.annotation-api:1.3.2")


}


protobuf {
	protoc  {
		artifact = "com.google.protobuf:protoc:3.25.0"
	}
	plugins {
		id("grpc") {
			artifact = "io.grpc:protoc-gen-grpc-java:1.60.1"
		}
	}

	generateProtoTasks {
		all().forEach {
			it.plugins {
				id("grpc")
			}
		}
	}
}

sourceSets {
	main {
		java {
			srcDir("build/generated/sources/proto/main/grpc")
			srcDir("build/generated/sources/proto/main/java")
		}
	}
}



tasks.withType<Test> {
	useJUnitPlatform()
}


