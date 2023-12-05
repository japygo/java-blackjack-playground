## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

---

## 기능 목록

### 블랙잭 게임
- 플레이어의 이름을 입력한다.
    - 쉼표로 구분한다.
- 결과를 계산한다.
    - 딜러와 플레이어가 모두 동시에 블랙잭인 경우 플레이어는 베팅한 금액을 돌려받는다.
    - 처음 두 장의 카드 합이 21일 경우 블랙잭이 되면 베팅 금액의 1.5 배를 딜러에게 받는다.
- 최종 수익을 계산한다.

### 딜러
- 딜러와 플레이어들은 카드 2장을 받는다.
- 딜러는 합계가 16이하면 카드 1장을 추가로 받는다.
    - 딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리해 베팅 금액을 받는다.

### 플레이어
- 플레이어는 배팅 금액을 입력한다.
- 딜러와 플레이어들은 카드 2장을 받는다.
- 플레이어는 카드를 추가로 받을지 선택한다.
    - 카드의 합이 21을 넘지 않을 경우 계속 받을 수 있다.
    - 카드의 합이 21을 넘을 경우 배팅 금액을 모두 잃는다.

### 카드
- 카드 종류는 다이아몬드, 클로버, 하트, 스페이드가 있다.
- 카드 숫자는 종류별로 Ace(1 또는 11), 2 ~ 9, King, Queen, Jack은 10으로 계산한다.