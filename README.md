# 42OAuth

### 42 Cadet정보 조회기능을 구현해봤습니다.

```
git clone https://github.com/ghkdwlgns612/42OAuth.git
```



java/ouath/OAuth/Application.java에서 main run하여 서버 가동.

![image](https://user-images.githubusercontent.com/68694844/127135281-bdc2ad63-dd3d-48fb-95ee-0a15e5f1eaa7.png)



localhost:8080접속 후 가운데 LoginBox클릭
![image](https://user-images.githubusercontent.com/68694844/127135499-c8982ab8-3165-4e90-9b6d-05da7009b0bb.png)



클릭 후 로그인 or 로그인 되있으면 바로 다음 페이지로 감. 인증 거부 시 초기 화면 렌더링.
![image](https://user-images.githubusercontent.com/68694844/127135676-1f9e060b-3b3a-4d9c-9832-26b91348c30a.png)



42서버로부터 인증 코드 발급완료 후 Post요청으로 AccessToken생성.
![image](https://user-images.githubusercontent.com/68694844/127135815-1f1d40ad-8ef4-4f1a-8a4d-a325dfb970e6.png)



Intra ID입력하여 Cadet정보 조회.
![image](https://user-images.githubusercontent.com/68694844/127136090-2e239644-cd60-4dc3-af64-c5467ca415f0.png)



### <결과>
![image](https://user-images.githubusercontent.com/68694844/127136176-05ee801b-3c02-4e6f-9b9d-8c1505ca67ff.png)


