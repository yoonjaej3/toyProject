# toyProject


### 목표
- 객체 지향적인 코드
- 통합 테스트
- git 버전 관리
- 무중단 배포
- api 문서 작성

 <br>

### 개발 스펙
- Gradle
- Spring Boot 2.x
- Spring Data JPA
- H2
- RESTful API
- QueryDSL

### git 규칙
- feat : 새로운 기능에 대한 커밋
- fix : 버그 수정에 대한 커밋
- build : 빌드 관련 파일 수정에 대한 커밋
- chore : 그 외 자잘한 수정에 대한 커밋
- ci : CI 관련 설정 수정에 대한 커밋
- docs : 문서 수정에 대한 커밋
- style : ui 스타일에 관한 커밋
- refactor : 코드 리팩토링에 대한 커밋
- test : 테스트 코드 수정에 대한 커밋
- init : 프로젝트 시작에 대한 커밋
- release: 릴리즈에 대한 커밋
- plus : add dependency
- minus : remove dependency

# [목차](#index) <a name = "index"></a>

- [요구사항](#requirement)
- [아키텍처](#structure)
- [결과물](#outputs)
- [ERD](#erd)  
- [테스트](#test)
- [왜 이 기술을 사용했는가?](#why)
- [리팩토링 & 성능 개선](#refactoring)
- [Spring Rest Docs](#api)



# 요구사항 <a name = "requirement"></a>
https://silly-trollius-4c0.notion.site/35e0187b938342bfb5e4ba42b88f8d00?v=20c32ec8e33f48ada83cfb4e490a7e4f

# ERD  <a name = "erd"></a>
https://www.erdcloud.com/p/3buW4CcLNQGx3w6y8

# 왜 이 기술을 사용했는가? <a name = "why"></a>



### QueryDsl

* Spring 환경에서 JPA를 사용하기 위해선 JPQL을 작성하게 됩니다. Spring Data JPA가 기본적으로 제공해주는 CRUD 메서드 및 쿼리 메서드 기능을 사용하더라도, 원하는 조건의 데이터를 수집하기 위해서는 필연적으로 JPQL을 작성하게 됩니다. 간단한 로직을 작성하는 데 큰 문제는 없으나 복잡한 로직의 경우 개행이 다수 포함되고 쿼리 문자열이 길어집니다. 이때 JPQL은 문법 오류가 나더라도 컴파일 시점에는 알 수 없고 런타임 시점에 에러가 발생합니다.

* 장점
    1) 문자열이 아닌 코드를 사용함으로써 컴파일 시점에 문법 오류를 확인할 수 있습니다.
    2) 자동 완성 등 IDE의 도움을 받아 편리하게 작성할 수 있습니다.
    3) 동적 쿼리 작성이 매우 편리해집니다.
    4) 조건, 중복 내용 등을 메서드 추출하고 재사용하여 객체 지향적으로 코드를 작성할 수 있습니다.

![image](https://user-images.githubusercontent.com/57666307/219553786-7ec7fae0-6b22-4064-8e47-bc3f04221d53.png)

![image](https://user-images.githubusercontent.com/57666307/219553807-cef9a73b-4ce4-4463-b61e-8c81f6f399f6.png)



### DTO 분리 

![image](https://user-images.githubusercontent.com/57666307/219554349-23f8aac9-bad8-4d17-8620-aa5167da10d2.png)

* Entity는 DTO에 의존해서는 안되기 때문에 파라미터에 DTO 를 넘겨줬습니다.
* RequsetDto, ResponseDto 를 사용해서 요청과 응답 시 이를 반환했고, 기능 재사용성을 위해 Dto들은 Service단에서 엔티티로 변환 됩니다.
* 엔티티 접근은 데이터베이스와의 상호작용을 캡슐화하고, 객체-관계 매핑을 통해 데이터를 검색, 저장, 업데이트하는 데 중점을 둡니다. 
  반면에 DTO 분리는 데이터 전송을 위한 구조적 패턴이며, 클라이언트와 서버 사이의 데이터 전송을 쉽게 만들기 위해 사용됩니다.
* DTO 분리의 이점은 필요한 데이터만 전송할 수 있습니다. 이는 네트워크 부하를 줄이고, 불필요한 데이터 유출을 방지하여 보안을 강화할 수 있습니다.
  
  
  
### @Setter 사용 지양

<img width="465" alt="image" src="https://user-images.githubusercontent.com/57666307/219940366-eaced257-5a6d-424a-81a9-8f032cc82355.png">

<img width="354" alt="image" src="https://user-images.githubusercontent.com/57666307/219940629-bf467821-71c5-4c72-b6a7-ae3e019e1abf.png">

<img width="489" alt="image" src="https://user-images.githubusercontent.com/57666307/219940678-42a72491-1c42-4b42-b10d-078e94ab63d4.png">


* JPA에서는 엔티티 클래스에서 Setter 메서드를 사용하지 않는 것이 좋습니다. 
  대신에, 생성자를 이용하여 객체를 생성하고, 필요한 데이터를 초기화하고, getter 메서드를 이용하여 데이터를 조회합니다.
  @Buillder를 통해 생성자를 생성하거나 메쏘드를 이용하여 객체의 상태를 변경했습니다.
  
  
  
### 일급컬랙션(변수) 사용

<img width="509" alt="image" src="https://user-images.githubusercontent.com/57666307/219940928-1759622d-bcc7-49f1-88f4-7ff87c627719.png">

<img width="438" alt="image" src="https://user-images.githubusercontent.com/57666307/219940917-344b8904-4d5e-46b7-9d39-705723306a14.png">

* Amount 클래스는 Orders 객체를 필드로 가지고 있고, Orders 객체의 필드를 이용하여 결제 금액을 계산하여 새로운 Orders 객체를 생성하는 일급컬렉션 개념을 사용했습니다.
* 일급 컬렉션을 사용한 이유는 관련 로직을 캡슐화하여 추상화 수준을 높일 수 있고, 코드의 가독성과 유지보수성을 향상시킬 수 있어서 객체지향적으로 개발하기 위해 사용했습니다.


  

# 리팩토링 & 성능 개선  <a name = "refactoring"></a>

- 리펙토링 전

![image](https://user-images.githubusercontent.com/57666307/219549152-694a8bc6-1fde-405d-a5fb-f043fd9150d1.png)

- 리펙토링 내용

1) 메소드명 수정 
> findSeqById -> findMemberById Input/Ouput을 메쏘드에 명시해줬습니다. ex) input = Id / output = member

2) 중복 제거
>Optional을 사용하여 order 객체의 item 필드를 체크하는 부분이 있습니다. 
 하지만 이 부분은 orderRequestDto 객체의 toEntity() 메소드에서 체크할 수 있어서 삭제 했고 의미를 명확하게 하기 위해서 checkRequiredFields 메쏘드를 만들었습니다.
 
3) 일급 변수 사용 및 최소
> 지불방식이 현금 또는 카드 일때 수수료 측정을 위해 Amount 라는 일급 변수를 사용 했습니다. Order 타입의 객체를 받아서 Order 타입의 객체로 리턴해주는 형태인데 아래와 같은 코드형태를 객체선언을 최소화하기 위해 리팩토링 했습니다.

```
        Amount commission = new Amount(order);

        Orders orderByCommission = commission.getOrder();
```

```
        Amount commission = new Amount(order);

        order.setCommission(commission.getOrder().getAmount());
```
    
- 리펙토링 후

![image](https://user-images.githubusercontent.com/57666307/219549233-cd7ac36b-f912-4210-bd86-b5196e67550e.png)

![image](https://user-images.githubusercontent.com/57666307/219549395-b40dbec5-fd19-4774-9d2c-3a3160b4992f.png)

![image](https://user-images.githubusercontent.com/57666307/219549420-f6860a52-a557-4286-b88f-d72ed5565014.png)


![image](https://user-images.githubusercontent.com/57666307/219549313-74923dea-b658-4b7b-b546-59066f25596e.png)



 
