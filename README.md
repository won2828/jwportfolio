# JW Portfolio

Spring Boot 기반 포트폴리오 웹 사이트입니다. 일러스트, 애니메이션, 디자인 등 작품을 갤러리와 상세 페이지로 보여줍니다.

## 기술 스택

- **Java 17**
- **Spring Boot 3.2.5**
- **Thymeleaf** (서버 사이드 템플릿)
- **Gradle** (빌드)
- **Lombok**

## 프로젝트 구조

```
src/main/java/com/jwportfolio/
├── PortfolioApplication.java    # 메인 애플리케이션
├── controller/
│   ├── HomeController.java      # 메인(/) 페이지
│   ├── GalleryController.java   # 갤러리(/gallery), 카테고리 필터
│   ├── DetailController.java    # 작품 상세(/detail?id=)
│   └── TestController.java      # API 테스트(/api/test/...)
├── service/
│   └── PortfolioService.java    # portfolio.json 로드 및 조회
└── dto/
    └── Portfolio.java           # 작품 데이터 모델

src/main/resources/
├── application.yml
├── data/
│   └── portfolio.json           # 포트폴리오 작품 데이터
├── static/css/
│   └── style.css
└── templates/
    ├── index.html               # 메인
    ├── gallery.html             # 갤러리
    └── detail.html              # 작품 상세
```

## 실행 방법

### 요구 사항

- JDK 17 이상
- Gradle (또는 프로젝트 내 Gradle Wrapper 사용)

### 로컬 실행

```bash
# Gradle Wrapper로 실행 (Windows)
.\gradlew.bat bootRun

# Gradle Wrapper로 실행 (Linux / macOS)
./gradlew bootRun
```

실행 후 브라우저에서 **http://localhost:8080** 으로 접속합니다.

### JAR 빌드 후 실행

```bash
.\gradlew.bat bootJar
java -jar build/libs/jwportfolio-0.0.1-SNAPSHOT.jar
```

## 주요 기능

- **메인 페이지** (`/`)  
  포트폴리오 소개 및 진입점

- **갤러리** (`/gallery`)  
  전체 작품 목록 표시  
  - 카테고리 필터: `?category=illustration` / `animation` / `design`

- **작품 상세** (`/detail?id=1`)  
  단일 작품 상세 정보 및 이미지  
  - 이전/다음 작품 네비게이션

- **테스트 API** (`/api/test`)  
  JSON 응답: `/api/test/all`, `/api/test/illustration`, `/api/test/animation`, `/api/test/design`

## 데이터

작품 데이터는 `src/main/resources/data/portfolio.json` 에서 로드됩니다.  
필드: `id`, `title`, `category`, `thumbnailUrl`, `images`, `description`, `client`, `duration`

카테고리 예: `illustration`, `animation`, `design`

## 설정

- **포트**: 기본 8080 (`application.yml` 의 `server.port` 로 변경 가능)
- **Thymeleaf**: 개발 시 캐시 비활성화 (`spring.thymeleaf.cache: false`)

## README 유지보수

README.md는 **자동으로 갱신되지 않습니다.**  
코드·설정·기능을 수정할 때는 README도 함께 수정해 주세요. (새 API, 페이지, 의존성, 실행 방법 변경 등)

## 라이선스

프로젝트 소유자에 따릅니다.
