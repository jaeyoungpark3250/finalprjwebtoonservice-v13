# 
## Model
www.msaez.io/#/48427782/storming/finalprjwebtoonservice-v13

## 클라우드 아키텍처 구성도

## MSA 아키텍처 구성도
![MSA_architecture](https://github.com/user-attachments/assets/042c13d9-0686-4db3-a4d0-f63c5f682fa9)

1. Purchase Service - 고객의 결제/환불 요청을 담당
2. WebToon Service - 웹툰의 업로드/삭제/읽음 요청을 담당
3. User Service - 결제애 사용하는 포인트를 담당
4. History Service - 웹툰의 결제 기록/소비 기록을 담당




















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

