# 스프링부트,마리아DB,인텔리제이,mybatis3 

<h1>실행법</h1>
<h3> http://localhost:8080/</h3>
<h3> src/main/java/com/mariadb/test/Main.java 실행</h3>
<h3>DB: test, 사용자: hj1216, 비번: 1216 </h3>

<h5> 
application.properties에 db정보와 아이디와 비번이 적혀있습니다. <br />
mybatis-config.xml 과 mybatis.mapper-locations= mapper/*.xml(매퍼 연결) <br />
설정 정보확인 하십시오
mybatis-config.xml운 비어 있습니다.
build.gradle에 주석 참고
</h5> <br />

<h5> P.S.front와 연결시 cros이슈가 발생해서 컨트롤러에 @CrossOrigin(origins = "http://localhost:3000") 를 추가 하였습니다.</h5> <br />


<h3>전부 postmapping 방식입니다.<br /></h3>
<h5>Insert  <br />
http://localhost:8080/test/insert <br />
{ <br />
  "pid": "5", <br />
  "pt_nm":"Bob3" <br />
} <br />
Read <br />
http://localhost:8080/test/selectSearch <br />
{} <br />
Update <br />
http://localhost:8080/test/update <br />
{ <br />
  "pid": "5", <br />
  "pt_nm":"Bob4" <br />
} <br />
Delete <br />
http://localhost:8080/test/delete <br />
{"pid":"5"}  <br />
</h5>

