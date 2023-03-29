## 1. 문자열 덧셈 계산기
###  요구사항
- : 또는 ,를 구분자로 한다.  `Separator#separate`
- 커스텀 구분자를 지정할 수 있다.
    1. //와 \n 사이에 입력한 값이 커스텀 구분자가 된다.  -> //로 시작하면 \n만날 때까지 값을 구분자에 저장한다. `Separator#getCustomSeparator`
    2. //&\n1&2&3 -> 1+2+3 =  6 -> (커스텀)구분자 이용해서 덧셈 진행 -> `Calculator#plus`
- 숫자이외의 값 혹은 음수를 입력할 경우 RuntimeException을 던진다. -> `Calculator#isCorrectNumeric`

<추가 제한 사항>
- 커스텀 지정한 경우 입력 시, 지정 커스텀으로만 구성한다.
- 커스텀은 한글자이어야 한다.

## 2. 자동차 경주 게임
### 요구사항
1. 자동차에 이름을 부여할 수 있는데, 5자를 초과할 수 없다. `Car#isNameUnderFive`
2. 전진하는 자동차 출력 시 자동차 이름을 함께 출력한다.  `Car#printMovingCarName`
3. 자동차 이름은 쉼표(,)를 기준으로 구분한다. `Car#separateCarName`
4. 자동차 전진 조건 : 0~9 사이에서 랜덤값 구한 후 랜덤값이 4 이상일 경우 전진 가능하다. `GamePlayer#getRendomNumber`, `Car#moveCar`
5. 자동차 경주 게임 완료 후, 누가 우승했는지 알려준다. 우승자는 1명 이상일 수 있다. `Car#getGameWinner`

- 시도할 횟수를 입력받은 만큼 실행한 후 게임을 종료한다. `GamePlayer#play`
- 진행 사항을 알려주는 방법 : '-'  `GamePlayer#getProgress`


### 프로그래밍 요구사항
- 모든 원시 값과 문자열을 포장한다.
- 일급 컬렉션을 쓴다.

---
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
