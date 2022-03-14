[NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

## 기능 요구 사항
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

## Todo list

### 1. 문제 생성
- 3자리 서로 다른 숫자를 난수로 생성  

### 2. 플레이어가 제출한 숫자와 컴퓨터가 생성한 숫자를 비교
- 스트라이크
  - 숫자의 인덱스와 값이 모두 일치하는 경우
- 볼
  - 숫자의 인덱스가 다르고, 값만 일치하는 경우
- 낫싱
  - 아무것도 일치하지 않는 경우

### 3. 비교한 값을 출력
- 볼 스트라이크, 볼, 스트라이크, 낫싱, 정답 메시지

### 4. 정답을 맞출 시 재시작 혹은 종료 선택
- 3스트라이크일 때 선택지 부여
- 재시작 혹은 종료

## 인지 과정
강사님 말씀대로 우선 테스트하기 쉬운 것부터 건드려야겠다. 2번에 해당한다.


## 구현 과정
- 스트라이크, 볼, 낫싱을 판단한다.