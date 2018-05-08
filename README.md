# Blockchain-java

## 1. Introduce
    . Blockchain-java는 Bitcoin header를 java로 해석하여 구현되었음


## 2. Source Code
### 2.1. block/util/CommonUtil.java
    . 데이터간 형변환을 위한 기본적인 method 구현

### 2.2. block/util/SHA256.java
    . byte 배열을 sha256 hash로 encoding해주는 함수(외부 소스 참조)

### 2.3. block/core/Block.java
    . Bitcoin block에 기반한 java converting block Class
    . version, previousblockHash, merkleHash, time, bits, nonce 등 6개 field 정보 포함
    . Genesis Block 생성 함수

### 2.4. block/core/Mining.java
    . Mining을 위한 기본 함수 구현
    . Block 값을 이용한 sha256 encoding hash를 이용해 difficulty를 충족시키는 hash를 생성
    . Difficulty 만족시 새로운 block 생성


## 3. Plan
    . getDifficulty 함수 구현(현재 단순 int 값 return 형식으로 되어있음)
    . Mining 시 Difficulty 충족된 경우 다른 Mining하는 Node에 현재 block에 대해 추가적인 Mining을 멈추고 다음 block에 대해 Mining하도록 알려주는 socket 통신 
