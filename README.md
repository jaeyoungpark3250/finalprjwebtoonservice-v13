# 
## Model
www.msaez.io/#/48427782/storming/finalprjwebtoonservice-v13

## MSA 아키텍처 구성도
![MSA_architecture](https://github.com/user-attachments/assets/042c13d9-0686-4db3-a4d0-f63c5f682fa9)

1. Pointer Service - 고객의 포인트 충전/환불 등을 담당
2. WebToon Service - 웹툰의 업로드/업데이트/읽음 요청을 담당
3. Payment Service - 고객의 웹툰 구매/취소 등을 담당
4. Purchase Service - 고객의 결제/환불 등의 요청을 담당
5. History Service - 웹툰 서비스의 결제 기록/열람 기록 등을 담당


## 이벤트 스토밍   
![이벤트스토밍](https://github.com/user-attachments/assets/36aa9006-eaf3-4f3d-8731-e6dd125d932f)


##########################################################################################################
###########################################클라우드 네이티브 개발###########################################
##########################################################################################################

## 분산 트랜잭션(PUB/SUB)
##########################################################################################################
KAFKA DATA 연동 후, 마이크로 서비스간의 통신에서 이벤트 메세지를 Pub/Sub 수행

1. WEBTOON 서비스 전체 목록 확인
   
![웹툰전체데이터확인](https://github.com/user-attachments/assets/fbdc5dc6-a94e-41e1-b249-43fd420eddde)

2. 고객 WEBTOON 서비스 열람 수행
   
![웹툰서비스등록](https://github.com/user-attachments/assets/a66a1a09-38c5-4e83-824c-b57eb5505b59)

3. 해당 고객 WEBTOON 포인트 구매 후, 잔여 포인트 확인
   
![히스토리내역확인](https://github.com/user-attachments/assets/7ccfdb08-1d4a-4c12-9cad-b6cde27790ca)

##########################################################################################################

## 단일 진입점(GATEWAY)
##########################################################################################################
- API Gateway를 사용하여 마이크로 서비스들의 엔드포인트 단일화

1. 게이트웨이 내, 각 서비스별 설정
 
![gateway설정](https://github.com/user-attachments/assets/eb0b4a72-90ae-4ed3-a671-1c04afa6498f)

2. 게이트웨이 8088 포트 실행

![게이트웨이실행](https://github.com/user-attachments/assets/eee0688c-ad74-4c86-b5b1-260df6eecd09)

3. 웹툰 서비스 API 조회(게이트웨이 8088포트 연결)

![웹툰서비스8088](https://github.com/user-attachments/assets/7fcea97a-f0c7-493b-93e4-6d86c5bc9728)

4. 히스토리 서비스 API 조회(게이트웨이 8088포트 연결)

![히스토리내역8088](https://github.com/user-attachments/assets/ce09a56f-350d-4227-bed3-583bc940a7b7)

##########################################################################################################

## 보상 처리(COMPENSATION)
##########################################################################################################

[시나리오] 고객이 충전한 포인트로 웹툰 구매/열람 수행

CASE 1) 정상 프로세스
- 100 point 짜리 niceguy 웹툰 구매 수행 후,  잔여 포인트 500 point 확인 

![정상적인취소완료처리프로세스](https://github.com/user-attachments/assets/457923eb-9ea4-4bd6-bc9f-3e5985285c36)


![정상취소완료_kafka확인_data조회](https://github.com/user-attachments/assets/97eb41a7-5c1e-4cf4-8ccb-e421cdb93a88)


CASE 2) 보상 처리 프로세스
- 600 point 짜리 niceguy 웹툰 구매 시도하였으나, 잔여 포인트 200 point로 구매 실패하여 mypoint 차감 미 수행

![포인트초과취소실패보상처리](https://github.com/user-attachments/assets/c9af49d6-a941-4a25-a279-3de2beba58d9)

![포인트초과취소실패_kafka확인_data조회](https://github.com/user-attachments/assets/77ea610c-fdce-4efd-b472-32a208b305e9)

##########################################################################################################

## CQRS
##########################################################################################################

- 히스토리 서비스 내, 회원 가입/포인트 충전 등 시나리오에 Query 모델(Materialized View)을 설계

[Read Model CRUD 상세설계]

![histories_redis_model](https://github.com/user-attachments/assets/41f8a7dc-e8b4-4c6e-a745-bf3643e1cf33)


1. 회원 정보 생성 후, userId/status 확인 - histories 조회

![redis_DATA_신규회원CREATE](https://github.com/user-attachments/assets/a44d7b61-8f73-4308-b930-1972aa219399)

2. 회원 포인트 충전 후, mypoint 정보 확인 - histories 조회

![redis_DATA_포인트결제충전](https://github.com/user-attachments/assets/48285e73-475c-4dd0-96e3-a8a0519e942b)

##########################################################################################################
###########################################클라우드 네이티브 운영###########################################
##########################################################################################################

## 클라우드 배포
##########################################################################################################

- 도커 빌드&Push / 클러스터 배포 / kfakf 메세지 확인

1. 도커 로그인 후, 도커 이미지 빌드 및 Push 수행 (각 서비스별 수행)

![도커컨테이너_빌드_and_푸시](https://github.com/user-attachments/assets/da614329-0816-47e7-8c7e-13dc6a121d5f)

(Docker Hub 이미지 전체 목록)
![도커허브_이미지목록](https://github.com/user-attachments/assets/bfb21a1b-0977-4015-bbd2-22a665750ef7)


2. 쿠버네티스 전체 서비스 배포 현황 확인

![쿠버네티스_전체배포현황](https://github.com/user-attachments/assets/822037d8-e8d8-4c24-a844-a639ad1ecac1)

3. gateway 호출 및 kafka 메세지 확인

![gateway_호출결과](https://github.com/user-attachments/assets/5b8758b5-baca-47b4-8909-8f2a4c26ca7c)

![kafka_메세지_확인](https://github.com/user-attachments/assets/5b1dd4cf-a1db-460e-bcf4-428d9fd9f493)

##########################################################################################################

## 컨테이너 자동 확장
##########################################################################################################

- 히스토리서비스 오토스케일링 적용&배포 후, 시즈로 API 호출하며 히스토리서비스 pod 자동 확장 확인

1. 히스토리서비스 오토스케일링 배포 및 확인

![오토스케일_확인](https://github.com/user-attachments/assets/9f473748-f6fd-4148-bd40-658f73516786)

![오토스케일_재배포](https://github.com/user-attachments/assets/34f2f1c6-b88a-4f4e-8732-5bf26d3cfa38)


2. 시즈로 API 호출

![시즈결과확인](https://github.com/user-attachments/assets/56ff28d3-8116-4a84-a2d3-cb74cf22e731)

3. pod 오토스케일링 결과 확인

![pod_오토스케일링확인](https://github.com/user-attachments/assets/a479495a-2a8a-4519-92f7-0f6763fbce13)

##########################################################################################################

## configmap
##########################################################################################################

- configmap 생성 후, 히스토리 서비스에 객체 전달 확인 

1. configmap 생성

![configmap생성_확인](https://github.com/user-attachments/assets/35a55c42-88ff-49d1-ada5-669e2fba7004)

2. 히스토리 서비스 객체 전달 확인 

![객체전달확인](https://github.com/user-attachments/assets/a601c3dc-903a-4103-a368-9a6713e0b3e4)

![컨테이너 로그 확인](https://github.com/user-attachments/assets/ec9d727a-3b12-467d-8d0e-f7cdf8d169c2)

##########################################################################################################

## 셀프 힐링 / 무 정지 배포
##########################################################################################################

CASE 1) 서비스 순단 시, 순단 현상 확인

1. 순단 현상

![중간순단현상](https://github.com/user-attachments/assets/a8d3ab58-0c58-47ad-8146-be155519d265)

2. 결과 확인

![순단 시 정지시간 발생](https://github.com/user-attachments/assets/3643128c-cd68-4ef7-b122-12b834c119e4)


CASE 2) 무 정지 배포

1. Liveness probe 확인

![Liveness Probe 확인](https://github.com/user-attachments/assets/65c850fa-826e-4fbe-97d3-643133ecb371)

2. 결과 확인(무 정지)

![무정지배포_정지시간없음](https://github.com/user-attachments/assets/f7109e3a-74ed-4e29-92ed-f1496c05f24c)

##########################################################################################################

## Service Mesh
##########################################################################################################

- istio system 이용한 kiali / keyclock 생성

1. istio system 설치 확인

![istio_system_설치확인](https://github.com/user-attachments/assets/3d91a1c0-8cd2-43a4-b361-5d62e944d2cb)

2. kiali / keyclock 생성

![kiali_접속](https://github.com/user-attachments/assets/da4c3f26-55f7-4e1b-9d03-d0d35f92ab2e)

![keyclock생성확인](https://github.com/user-attachments/assets/db679486-f749-452b-a3d6-d1eafdfb5087)

##########################################################################################################

## 통합 모니터링
##########################################################################################################

- Loki 설치 및 Grafana 활용

1. 로키 설치/구성

![loki설치및구성](https://github.com/user-attachments/assets/dc98d7cf-5b7f-46c8-9207-c0390f24f015)

![Loki_데이터소스_확인까지만](https://github.com/user-attachments/assets/f8a554c3-e62a-4849-bde6-ee9dff32392e)

2. Grafana UI 연동

![grafana_UI](https://github.com/user-attachments/assets/96e09d1f-db67-4493-ba33-54127fcd1b82)

##########################################################################################################

## CI/CD
##########################################################################################################

1. Azure Jenkins 설치 및 azure credentials 발급

![azure_shell_젠킨스설치확인](https://github.com/user-attachments/assets/cdce13a7-fc0e-4ac4-8143-e52e75ab1275)

![azure credentials](https://github.com/user-attachments/assets/bf9f3e79-77cd-4e2f-a9a8-05c5b9c890b1)

-----BEGIN RSA PRIVATE KEY-----
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
-----END RSA PRIVATE KEY-----

2. github 내 jenkins 파일 설정

![github_jenkins_적용](https://github.com/user-attachments/assets/73a53172-8c56-4a5f-825f-ddd75cd42448)

3. jenkins 빌드 수행

![젠킨스초기화면](https://github.com/user-attachments/assets/af5c3035-57f5-4759-893b-0dcfd3d7f9ef)

![젠킨스빌드서공](https://github.com/user-attachments/assets/f7aff918-e8e9-44ca-b942-f5c0ba9f9dc7)




## 클라우드 아키텍처 구성도
![cloud_architecture_PJY](https://github.com/user-attachments/assets/3db43b49-5773-49b4-ae73-7b0a75d2e545)

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- pointerservice
- paymentservice
- historyservice
- webtoonmanagementservice
- purchaseservice


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- pointerservice
```
 http :8088/pointers id="id" point="point" 
```
- paymentservice
```
 http :8088/payments id="id" point="point" userId="userId" price="price" status="status" 
```
- historyservice
```
 http :8088/histories id="id" userId="userId" point="point" price="price" webtoonId="webtoonId" myPoint="myPoint" status="status" 
```
- webtoonmanagementservice
```
 http :8088/webtoons id="id" webtoonId="webtoonId" title="title" author="author" point="point" episode="episode" status="status" 
```
- purchaseservice
```
 http :8088/purchases id="id" userId="userId" point="point" myPoint="myPoint" webtoonId="webtoonId" status="status" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

