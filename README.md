# 42OAuth

### 42 Cadet정보 조회기능을 구현해봤습니다.

```
git clone https://github.com/ghkdwlgns612/42OAuth.git
```

![image](https://user-images.githubusercontent.com/68694844/127138681-73297c3b-af47-450a-b6ab-0482bc9bd38e.png)


### 1. java/ouath/OAuth/Application.java에서 main run하여 서버 가동.

![image](https://user-images.githubusercontent.com/68694844/127135281-bdc2ad63-dd3d-48fb-95ee-0a15e5f1eaa7.png)



### 2. localhost:8080접속 후 가운데 LoginBox클릭

![image](https://user-images.githubusercontent.com/68694844/127135499-c8982ab8-3165-4e90-9b6d-05da7009b0bb.png)



### 3. 클릭 후 로그인 or 로그인 되있으면 바로 다음 페이지로 감. 인증 거부 시 초기 화면 렌더링.

![image](https://user-images.githubusercontent.com/68694844/127136692-59cb6d31-ca1d-410b-834e-9061736ec6d4.png)


### 4. 42서버로부터 인증 코드 발급완료 후 Post요청으로 AccessToken생성.

![image](https://user-images.githubusercontent.com/68694844/127136783-f2cd19ae-1fb5-4da7-b693-ebf77da07601.png)



### 5. Intra ID입력하여 Cadet정보 조회.

![image](https://user-images.githubusercontent.com/68694844/127136840-9e07c6ff-34de-47b8-8e88-2cc875edc838.png)



### <결과>

![image](https://user-images.githubusercontent.com/68694844/127136885-781440aa-4c6e-407e-aef5-d34d5f66e6b4.png)


