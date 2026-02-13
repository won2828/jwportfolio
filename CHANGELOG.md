# Changelog

## 2026-02-13

- **Phase 4: 상세 페이지 추가**
  - DetailController: GET /detail?id=, PortfolioService로 작품 조회, 없으면 홈 redirect
  - 이전/다음 작품 네비게이션 (전체 리스트 기준)
  - 제목, 이미지들(수직 40px 간격), 프로젝트 정보(Client/Duration/Description, 선택 표시)
  - Back to Gallery → 해당 카테고리 갤러리로 이동
  - 갤러리와 동일 헤더, 반응형

- **Phase 3: 갤러리 페이지 추가**
  - GalleryController: GET /gallery, category 파라미터로 필터링
  - 상단 sticky 메뉴: illustrate | animation | design | SNS (선택 시 진하게+밑줄)
  - 작품 그리드: 5열→3열→2열 반응형, 썸네일 1:1, 호버 시 scale 1.05
  - 카드 클릭 시 /detail?id={id} 이동, 이미지 로딩 실패 시 placeholder

- **Phase 2: 메인 페이지 추가**
  - HomeController: GET "/" → index.html
  - 메인 페이지 구조: 상단 헤더(로고, Info), 중앙 히어로 영역(100vh), 하단 메뉴(illustrate, animation, design, SNS)
  - Thymeleaf 템플릿 및 미니멀 CSS 스타일 추가
  - 반응형 대응 (모바일 패딩/폰트 조정)
