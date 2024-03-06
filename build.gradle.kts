plugins {
	java
	war
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.blog"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")

	// thymeleaf
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	// DB연결을 위한 JDBC
	implementation("org.springframework.boot:spring-boot-starter-jdbc")

	/* Mybatis
	 * https://shanepark.tistory.com/466
	 * implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.2.2")
	 */
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")

	/* 암호화 처리
	 * https://mvnrepository.com/artifact/com.github.ulisesbocchio/jasypt-spring-boot-starter
	 */
	implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")

	//runtimeOnly("com.mysql:mysql-connector-j") 			// Mysql Connector
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")    // mariadb connector

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	//providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.junit.jupiter:junit-jupiter-api")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
