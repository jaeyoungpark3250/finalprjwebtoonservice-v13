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

