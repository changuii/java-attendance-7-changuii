# java-attendance-precourse

## 기능 목록

### 입력

- [x]  사용자에게 기능을 입력받는다
    - [x]  1, 2, 3, Q 이외의 값이 입력된 경우, 예외가 발생한다.

```
오늘은 12월 13일 금요일입니다. 기능을 선택해 주세요.
1. 출석 확인
2. 출석 수정
3. 크루별 출석 기록 확인
4. 제적 위험자 확인
Q. 종료
1 | 2 | 3 | Q
```

- [x]  사용자에게 닉네임을 입력받는다.
    - [ ]  닉네임에 해당하는 크루원이 없다면, 예외가 발생한다.

```
닉네임을 입력해 주세요.
출석을 수정하려는 크루의 닉네임을 입력해 주세요.
이든
```

- [x]  사용자에게 등교 시간을 입력받는다.
    - [x]  [시간]:[분]의 형태가 아니라면, 예외가 발생한다.

```
등교 시간을 입력해 주세요.
언제로 변경하겠습니까?
09:59
```

- [x]  수정하려는 날짜를 입력받는다.
    - [x]  1 ~ 31 사이의 값이 아니라면, 예외가 발생한다.

```
수정하려는 날짜(일)를 입력해 주세요.
3
```

### 출력

- [ ]  기능 선택을 입력받기 위한 메시지를 출력한다.
    - [ ]  오늘 날짜를 출력한다.

```
오늘은 12월 13일 금요일입니다. 기능을 선택해 주세요.
1. 출석 확인
2. 출석 수정
3. 크루별 출석 기록 확인
4. 제적 위험자 확인
Q. 종료
```

- [ ]  닉네임을 입력받기 위한 메시지를 출력한다.

```
닉네임을 입력해 주세요.
```

- [ ]  등교 시간을 입력받기 위한 메시지를 출력한다.

```
등교 시간을 입력해 주세요.
```

- [ ]  출석 수정 닉네임을 입력받기 위한 메시지를 출력한다.

```
출석을 수정하려는 크루의 닉네임을 입력해 주세요.
```

- [ ]  수정하려는 타겟 날짜를 입력받기 위한 메시지를 출력한다.

```
수정하려는 날짜(일)를 입력해 주세요.
```

- [ ]  수정하려는 타겟 날짜를 수정할 시간을 입력을 받기 위한 메시지를 출력한다.

```
언제로 변경하겠습니까?
```

- [ ]  닉네임에 해당하는 출석 안내 메시지를 출력한다.

```
이번 달 빙티의 출석 기록입니다.
```

- [ ]  날짜별 출석 내역을 출력한다.

```
12월 02일 월요일 13:00 (출석)
12월 03일 화요일 09:58 (출석)
12월 04일 수요일 10:02 (출석)
12월 05일 목요일 10:06 (지각)
12월 06일 금요일 10:01 (출석)
12월 09일 월요일 --:-- (결석)
12월 10일 화요일 10:08 (지각)
12월 11일 수요일 --:-- (결석)
12월 12일 목요일 --:-- (결석)
```

- [ ]  총 출석 기록을 합산하여 출력한다.

```
출석: 4회
지각: 2회
결석: 3회
```

- [ ]  재적 위험자를 출력하기 위한 안내 메시지를 출력한다.

```
제적 위험자 조회 결과
```

- [ ]  재적 위험자를 출력한다.

```
- 빙티: 결석 3회, 지각 2회 (면담)
- 이든: 결석 2회, 지각 4회 (면담)
- 쿠키: 결석 2회, 지각 2회 (경고)
- 빙봉: 결석 1회, 지각 5회 (경고)
```

### 실행 결과 예시

```
오늘은 12월 13일 금요일입니다. 기능을 선택해 주세요.
1. 출석 확인
2. 출석 수정
3. 크루별 출석 기록 확인
4. 제적 위험자 확인
Q. 종료
1

닉네임을 입력해 주세요.
이든
등교 시간을 입력해 주세요.
09:59

12월 13일 금요일 09:59 (출석)

오늘은 12월 13일 금요일입니다. 기능을 선택해 주세요.
1. 출석 확인
2. 출석 수정
3. 크루별 출석 기록 확인
4. 제적 위험자 확인
Q. 종료
2

출석을 수정하려는 크루의 닉네임을 입력해 주세요.
빙티
수정하려는 날짜(일)를 입력해 주세요.
3
언제로 변경하겠습니까?
09:58

12월 03일 화요일 10:07 (지각) -> 09:58 (출석) 수정 완료!

오늘은 12월 13일 금요일입니다. 기능을 선택해 주세요.
1. 출석 확인
2. 출석 수정
3. 크루별 출석 기록 확인
4. 제적 위험자 확인
Q. 종료
3

닉네임을 입력해 주세요.
빙티

이번 달 빙티의 출석 기록입니다.

12월 02일 월요일 13:00 (출석)
12월 03일 화요일 09:58 (출석)
12월 04일 수요일 10:02 (출석)
12월 05일 목요일 10:06 (지각)
12월 06일 금요일 10:01 (출석)
12월 09일 월요일 --:-- (결석)
12월 10일 화요일 10:08 (지각)
12월 11일 수요일 --:-- (결석)
12월 12일 목요일 --:-- (결석)

출석: 4회
지각: 2회
결석: 3회

면담 대상자입니다.

오늘은 12월 13일 금요일입니다. 기능을 선택해 주세요.
1. 출석 확인
2. 출석 수정
3. 크루별 출석 기록 확인
4. 제적 위험자 확인
Q. 종료
4

제적 위험자 조회 결과
- 빙티: 결석 3회, 지각 2회 (면담)
- 이든: 결석 2회, 지각 4회 (면담)
- 쿠키: 결석 2회, 지각 2회 (경고)
- 빙봉: 결석 1회, 지각 5회 (경고)

오늘은 12월 13일 금요일입니다. 기능을 선택해 주세요.
1. 출석 확인
2. 출석 수정
3. 크루별 출석 기록 확인
4. 제적 위험자 확인
Q. 종료
Q
```

자세한 출력 예시는 실행 결과 예시를 참고하며, 각 상황에 대한 예외 메시지는 아래와 같다.

- [ ]  기능 선택 항목, 날짜 또는 시간을 잘못된 형식으로 입력한 경우

```
[ERROR] 잘못된 형식을 입력하였습니다.

```

- [ ]  등록되지 않은 닉네임을 입력한 경우

```
[ERROR] 등록되지 않은 닉네임입니다.

```

- [ ]  주말 또는 공휴일에 출석을 확인하거나 수정하는 경우

```
[ERROR] 12월 14일 토요일은 등교일이 아닙니다.

```

- [ ]  미래 날짜로 출석을 수정하는 경우

```
[ERROR] 아직 수정할 수 없습니다.

```

- [ ]  등교 시간이 캠퍼스 운영 시간이 아닌 경우

```
[ERROR] 캠퍼스 운영 시간에만 출석이 가능합니다.

```

- [ ]  이미 출석을 하였는데 다시 출석 확인을 하는 경우

```
[ERROR] 이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요.
```

### 기능

- [x]  attemdances.csv파일을 읽어와라
- [ ]  출석 확인 기능
    - [ ]  사용자를 찾아, 오늘 날짜, 등교 시간으로 출석처리한다.
    - [ ]  사용자의 출석 내역을 출력한다.
    - [ ]  이미 출석한 경우, 수정을 사용하도록 안내한다.
        - [ ]  주말 및 공휴일에는 출석을 받지 않는다.
        - [ ]  캠퍼스 운영 시간은 매일 08:00~23:00이다.
        - [ ]  해당 요일의 시작 시각으로부터 5분 초과는 지각으로 간주한다.
        - [ ]  해당 요일의 시작 시각으로부터 30분 초과는 결석으로 간주한다.
- [ ]  출석 수정 기능
    - [ ]  닉네임, 날짜, 해당하는 출석을 입력받은 시간으로 변경한다.
    - [ ]  변경 전과 후의 기록을 출력한다.
- [ ]  **크루별 출석 기록 확인**
    - [ ]  닉네임에 해당하는 출석 기록을 모두 확인한다.
        - [ ]  등교하지 않아 출석 기록이 없는 날은 결석으로 간주한다.
- [ ]  제적 위험자 확인
    - [ ]  제적 위험자는 제적 대상자, 면담 대상자, 경고 대상자순으로 출력하며, 대상 항목별 정렬 순서는 지각을 결석으로 간주하여 내림차순한다. 출석 상태가 같으면 닉네임으로 오름차순 정렬한다.
    - [ ]  지각 3회는 결석 1회로 간주한다.
        - 경고 대상자: 결석 2회 이상
        - 면담 대상자: 결석 3회 이상
        - 제적 대상자: 결석 5회 초과
- [ ]  프로그램은 사용자가 종료할 때까지 종료되지 않으며, 해당 기능을 수행한 후 초기 화면으로 돌아간다.
    - [ ]  사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 메시지와 함께 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 실행 흐름

- 기능을 선택받는다.
    - 1인 경우, 출석 확인을 실행한다.
        - 닉네임을 입력받고, 이를 검증한다.
        - 등교 시간을 입력받고, 이를 검증한다.
        - 닉네임에 해당하는 [인원]을 [등교 시간]에 출석처리한다.
    - 2인 경우, 출석 수정을 실행한다.
        - 닉네임을 입력받고, 이를 검증한다.
        - 날짜를 입력받고, 이를 검증한다.
        - 변경하려는 시간을 입력받고, 이를 검증한다.
        - 닉네임에 해당하는 [인원]의 [등교 시간]을 변경하려는 시간으로 변경한다.
    - 3인 경우, 크루별 출석 기록을 확인한다.
        - 닉네임을 입력받고, 이를 검증한다.
        - 이번달의 전날까지의 기록을 출력한다.
    - 4인 경우, 제적 위험자를 확인한다.
        - 제적 위험자는 제적 대상자, 면담 대상자, 경고 대상자순으로 출력하며, 대상 항목별 정렬 순서는 지각을 결석으로 간주하여 내림차순한다. 출석 상태가 같으면 닉네임으로 오름차순 정렬한다.
    - Q인 경우, 서비스를 종료한다.
- 예외 발생시 종료한다.

### 예외 상황

1. 시간은 24시간 형식만 사용한다.
2. 교육 시간은
    - 월요일, 13:00 ~ 18:00
    - 화요일~금요일은 10:00 ~ 18:00이다.
3. 캠퍼스 운영 시간은 매일 08:00~23:00이다.
    - 주말 및 공휴일에는 출석을 받지 않는다.