# 스프링부트,마리아DB,인텔리제이,mybatis3 

<h1>실행법</h1>
<h3> http://localhost:8080/</h3>
<h3> src/main/java/com/mariadb/test/Main.java 실행</h3>


<h5> 
    implementation 'org.springframework.boot:spring-boot-starter-web'<br />
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'<br />
    implementation 'org.mariadb.jdbc:mariadb-java-client:2.7.2'  // MariaDB JDBC 드라이버<br />
    implementation 'com.fasterxml.jackson.core:jackson-databind:2.12.3'<br />
    implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0'<br />
    implementation 'com.fasterxml.jackson.core:jackson-databind:2.12.3'<br />
    testImplementation 'org.springframework.boot:spring-boot-starter-test'<br />
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'<br />
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'<br />
    annotationProcessor 'org.projectlombok:lombok:1.18.20'  // Lombok 종속성 추가<br />
    compileOnly 'org.projectlombok:lombok:1.18.20'  // Lombok 종속성 추가<br />
</h5> <br />

<h5>
Insert   <br />
http://localhost:8080/TestInsert  <br />
{ <br />
  "pid": "5", <br />
  "pt_nm":"Bob3" <br />
} <br />
Read <br />
http://localhost:8080/TestSelectSearch <br />
 <br />
{}  <br />
Update <br />
http://localhost:8080/TestUpdate  <br />
{ <br />
  "pid": "5", <br />
  "pt_nm":"Bob4" <br />
} <br />
 <br />
Delete  <br />
http://localhost:8080/TestDelete <br />
{"pid":"5"}  <br />
</h5>
