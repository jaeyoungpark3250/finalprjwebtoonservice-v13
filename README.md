# 
## Model
www.msaez.io/#/48427782/storming/finalprjwebtoonservice-v13

## 클라우드 아키텍처 구성도
![cloud_architecture_PJY](https://github.com/user-attachments/assets/3db43b49-5773-49b4-ae73-7b0a75d2e545)

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

