![header](https://capsule-render.vercel.app/api?type=Rounded&color=0:FA8072,100:FA8072&height=160&text=강남%20맛집%20추천&fontColor=FFFFFF&fontSize=40&width=700&fontAlignY=50)


<br />

# 👋 소개

> 강남 맛집 추천 사이트에 오신 것을 환영합니다! <br />
> 이 사이트는 맛집을 종류별, 지역별로 구분하여 쉽게 찾을 수 있도록 도와줍니다. <br />
> 회원 가입 후에는 직접 맛집 리뷰를 작성하고, 맛집을 신청하거나 저장할 수 있는 기능도 제공됩니다. <br />

<br />

# 🧑‍🤝‍🧑 팀원 소개

- **유영현 (팀장)** : 형상 관리 및 사용자 페이지 기능 구현 담당
- **박일규** : 관리자 페이지 UI/UX 디자인 및 기능 구현 담당
- **이혜민** : 사용자 페이지 UI/UX 디자인 및 전체 프론트엔드 디자인 담당
- **[한상지](https://github.com/SangjiHan)** : 데이터베이스 설계 및 연동, 리뷰/검색/가게 리스트 기능 구현 담당
  
<br />

# 프로젝트 기간
> 2024.07 ~ 2024.08

<br />

# 개발 도구
- 개발 언어 <img src="https://img.shields.io/badge/HTML5-F16529?style=for-the-badge&logo=html5&logoColor=white" alt="HTML5 badge"> <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white" alt="CSS3 badge"> <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=000000" alt="JavaScript badge"> <img src="https://img.shields.io/badge/JAVA-F7E03C?style=for-the-badge&logo=java&logoColor=000000" alt="JAVA badge"><img src="https://img.shields.io/badge/JSP-red?style=for-the-badge&logo=jsp&logoColor=gray" alt="JSP badge"> <br />
- 개발 환경 <img src="https://img.shields.io/badge/STS4-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Tool Suite 4 badge"> <br />
- 데이터베이스 <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white&color=4479A1" alt="MySQL badge"> <br />
- 빌드 <img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white&color=02303A" alt="Gradle badge"> <br />
- 형상 관리 <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white&color=F05032" alt="Git badge"> <br />
- 프레임워크 : <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot badge"> <img src="https://img.shields.io/badge/JPA-0074CC?style=for-the-badge&logo=java&logoColor=white" alt="JPA badge"> <img src="https://img.shields.io/badge/MyBatis-00205B?style=for-the-badge&logo=mybatis&logoColor=white" alt="MyBatis badge"> <br />
 <br />


# 파일 설치 가이드
- 프로젝트의 모든 파일을 다운로드하여 로컬 환경에 저장합니다. <br />
- [Spring Tool Suite 4 공식 웹사이트](https://spring.io/tools)에서 STS4를 다운로드하고 설치합니다. <br />
- [JDK 17 다운로드 페이지](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)에서 JDK 17을 다운로드하여 설치합니다. <br />
- JDK 설치 후, 환경변수 JAVA_HOME을 JDK가 설치된 경로로 설정합니다. <br />
- [Lombok 공식 웹사이트](https://projectlombok.org/)에서 Lombok JAR 파일을 다운로드합니다. <br />
- 다운로드한 Lombok JAR 파일을 STS4의 dropins 폴더에 복사합니다. (예: C:\Program Files\SpringToolSuite4\dropins) <br />
- [MySQL 공식 웹사이트](https://dev.mysql.com)에서 MySQL을 다운로드하여 설치합니다. <br />
- MySQL 설치 후, yummy라는 사용자와 yummy라는 데이터베이스를 생성합니다. 사용자 yummy의 비밀번호를 1234로 설정합니다. <br />
- 설치가 완료된 STS4를 실행합니다. <br />
- 웹 브라우저를 열고 http://localhost:8085를 입력하여 애플리케이션이 정상적으로 실행되는지 확인합니다. <br />
<br />

# 프로젝트 소개

## 시스템 구조도
> ![그림1](https://github.com/user-attachments/assets/3820996c-70b3-4ed2-9f1f-7a64c10787cf) <br />
> - 퍼블릭 페이지: 로그인이 필요 없는 공개 페이지로, 누구나 접근할 수 있습니다. <br />
> - 사용자 페이지: 사용자 전용 페이지로, 로그인 후에만 접근 가능하며, 개인화된 기능을 제공합니다. <br />
> - 관리자 페이지: 관리자가 시스템을 운영하고 관리할 수 있는 페이지로, 사용자와 데이터 관리를 위한 기능을 포함합니다. <br />


<br />

## 데이터 베이스
> ![그림2](https://github.com/user-attachments/assets/5aca5ecb-a7b9-4cfa-966a-70319036adc3) <br />
> - CUID 형식: 데이터베이스는 CUID(Compact Unique Identifier) 형식을 사용하여 고유한 식별자를 생성합니다. <br />
> - 기본키 및 외래키: 테이블 간의 관계를 정의하고 데이터의 무결성을 유지하기 위해 기본키와 외래키를 설정했습니다. <br />
> - 연동과 무결성: 테이블 간의 연동이 용이하며, 데이터 무결성을 효과적으로 유지하도록 설계되었습니다. <br />

<br />

## 주요 기능 살펴보기 
### 1. 회원가입
> ![그림4](https://github.com/user-attachments/assets/1fc15fe7-dc66-46c2-96f5-202a07483af7) <br />
> - 유효성 검사: 회원가입 시 입력된 값에 대해 유효성 검사를 진행하여 올바른 형식과 범위 내의 값만 허용합니다. <br />
> - 중복 확인: 사용자가 입력한 값(예: 이메일, 사용자 이름 등)의 중복 여부를 확인하여 이미 등록된 정보와의 충돌을 방지합니다. <br />

<br />

### 2. 메인 화면
>  ![그림3](https://github.com/user-attachments/assets/3e9e2237-e2d1-44e6-9409-66293fd773f4) <br />
> - 검색 기능: 사용자는 가게명, 지역별, 업종별로 맛집을 검색할 수 있습니다. 이를 통해 원하는 맛집을 쉽게 찾을 수 있습니다. <br />
> - 메인 배너: 홍보용 사진이 슬라이드 효과로 표시되며, 주요 정보나 이벤트를 시각적으로 강조합니다.  <br />
> - 맛집 랜덤 추천: 랜덤으로 맛집 리스트가 제공되며, 리스트에서 맛집을 클릭하면 해당 맛집의 상세 정보를 확인할 수 있습니다. <br />
<br />


### 3. 리뷰 작성
> ![그림5](https://github.com/user-attachments/assets/6eb70294-9515-4500-80d0-ea06a1d854ff) <br />
> - 리뷰 작성: 사용자는 맛집에 대한 리뷰를 작성할 수 있으며, 별점을 통해 자신의 평가를 남길 수 있습니다. <br />
> - 사진 업로드: AddMvcConfiguration을 사용하여 리뷰에 관련된 사진을 실시간으로 업로드할 수 있으며, 업로드된 사진은 리뷰와 함께 표시됩니다. <br />
<br />

### 4. 가게 리스트 
> ![그림12](https://github.com/user-attachments/assets/1a26f490-80e5-4dfb-b6cb-966ca02ebf7b) <br />
> - 가게 리스트: 검색 결과로 나타난 가게들의 리스트를 확인할 수 있으며, 각 가게의 기본 정보와 함께 표시됩니다. <br />
> - 지도 기능: 선택한 가게의 위치가 지도에 표시되어, 사용자가 가게의 위치를 시각적으로 확인할 수 있습니다. <br />
<br />

### 5. 나의 맛집
> ![그림7](https://github.com/user-attachments/assets/9369f6c8-9931-4f1b-a94d-72a174bab3d8)  <br />
> - 맛집 컬렉션: 사용자가 관심 있는 맛집을 저장하여 나만의 맛집 컬렉션을 만들 수 있습니다. 저장한 맛집은 쉽게 접근하고 관리할 수 있습니다.  <br />
> - 리뷰 리스트: 사용자가 작성한 리뷰를 확인할 수 있으며, 리뷰를 수정하거나 삭제할 수 있는 기능이 제공됩니다. 이를 통해 리뷰를 업데이트하거나 필요에 따라 제거할 수 있습니다.  <br />
 <br />

### 6. 맛집 신청
> ![그림9](https://github.com/user-attachments/assets/b8a7e3e6-d440-4c13-873c-cadfe39268c8)  <br />
> - 맛집 신청: 사용자가 자신만의 맛집 정보를 시스템에 제출하여 공유할 수 있는 기능입니다. 이를 통해 새로운 맛집을 추천하고, 다른 사용자와 정보를 공유할 수 있습니다. <br />
<br />

### 7. 관리자 페이지
>![그림10](https://github.com/user-attachments/assets/5bbf6ed1-84e7-4870-afa1-914e46512e6e) <br />
> - 관리자 페이지: 관리자는 사용자, 리뷰, 가게 정보를 수정하거나 삭제할 수 있는 기능을 제공합니다. 이를 통해 시스템의 데이터를 효율적으로 관리할 수 있습니다. <br />
> - 맛집 신청 관리: 사용자로부터 제출된 맛집 신청 내역을 확인하고, 필요한 경우 가게 정보를 등록하거나 거절할 수 있는 기능을 제공합니다. <br />
> - 리스트 페이지네이션: 리스트는 페이지네이션 기능을 사용하여 한 페이지에 10개의 항목을 표시합니다. 관리자는 페이지를 넘기면서 항목을 효율적으로 탐색할 수 있습니다. <br />
<br />

