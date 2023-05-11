# CBA Brainstormers

# Availability Chat Application
---
<a href = "#Overview">Overview</a>
```Technical :
- Back-end:
  + Spring boot
  + C++
  + Spring security :
    + JWT -- OAuth2 -> Generate a new token Bearer attached on Headers --> Make the authorization when accessed into API
    + Socket IO --> An avalability in handling connection errors, stability, and reliability between client and server. An essential tools making multiple channels and managing data over channels
- Front-end:
  + ReactJS
  + Redux
  + Material-ui
  + React-router-dom
- Docker
- Kubernates
  ```
---
<a href = "#First Working Building Flow">MVC Working Architecture Flow</a>
---
![MVC Architecture drawio](https://user-images.githubusercontent.com/86148510/224954783-26169469-2691-4e88-8a1a-a148193b9829.png)
- MVC (Model-View-Controller) Architecture is the basic structure project where the requests sent by client and server will handle it
- Implementation CRUD methods and Socket IO are added which enhance application can multiple channels handling, as well as optimize speed of performance
- MVC is the Data Structure handling web server where the logic is seperate and manipulate interaction between them.
  + Model: An Object or List (Collection) of Objects which works with database
  + View: An User Interface, display user data. The view model is only just show the data are handled by Model
  + Controller: Get the requests from client through View model, process and update View or Model requests
---
<a href = "#Software">Software Architecture Working Flow</a>
---
![MSA](https://github.com/anhdung2k1/likelion_bootcam/assets/86148510/b5d889a1-d7d3-46d5-a69f-021fb521d2dc)
- The main purpose of making microservices is to follow rules Singleton which makes each service has an independent process and less dependent on others.
- Cloud is also applied to develop <strong>distributed applications</strong> that make each module can be written with many types of language. For this Project, we are using Java (Spring Boot) to config all processes of validation and make configurations and C++ to perform Chat Applications with respective mean time delay.
- Also, each module can communicate with the other by making API call.
- Every attempt in need needs to be validated by Gateway. It means that any requests from the client need pass through Gateway first.
- In microservices, simply because we do not care about a domain of services, we call API of the gateway after that the navigation will automatically exact the service.
- <strong>Cloud Config Server</strong> working based on <strong>Client - Server</strong> in centralized on a <strong>Back-end System</strong>. For Example: <strong>Git repository, File System, Vault,etc</strong>
- This <strong>Cloud Config Server</strong> will provide to property HTTP resource-based API (HTTP METHOD: GET)
---
<a href = "#Detail Flow">Software Working MSA (Microservices Architectures) Flow</a>
---
![Availability Chat Application drawio](https://user-images.githubusercontent.com/86148510/224934339-8b90e4ab-f940-4d42-a2fb-9807f3c290b1.png)
- <strong>MSA</strong> implementations solve a difficult task in which tradional Architecture Client Server problems such as:
  + Hard to maintain
  + Dependent on another service, overlap with each other
  + Hard to understand task due to scale up of the project
- Some hardcore problems must deal with after
  + Context Limitation: The project can extend more and more, and services following increase when met new features
  + Scalability and Scale Down: User traffics can be extended on holiday and less on a normal day --> Need to limit those services that are working which reduce resource are using
  + Stack Of Cards: Because <strong>MSA</strong> have services that are running independently when one of those is cracked --> Effect to others
- Base of MSA's flow:
  + Working as a client-server side, MSA inherit and extend more application in use
  + Clients sent requests to the server which is only going through <strong>Gateway</strong> to authenticate the requests whether are valid or not.
  + Only if the token response underlined multiple processes Token is Valid then API requests will be sent to another module based on the direction of <strong>Gateway</strong>
   + To ensure <strong>Chat Application</strong> remains a real-time property, Kafka will help the process is smooth
  + Each process will be stored in Database
  + Config Server in Cloud
  + Monitoring the traffic by <strong>ZIPKIN which is an open-source for developers derived from Twitter to help visualize the status and traffic used in application</strong>
---
<a href = "#Security Config">Security Filter</a>
---
![Security Filter](https://user-images.githubusercontent.com/86148510/224912027-665ba86e-5839-44af-b328-d3375adf848b.jpeg)
- The Requests as a mentioned before, will go through <strong>Gateway</strong> that will filter the requests whether are validation or not.
- First stage, the request authenticate will be checked on <strong>JWTAuthFilter</strong> to <strong>validate the Token</strong>
- If it is successfully checked, the <strong>Gateway</strong> will allow the requests go to service modules and return <strong>HTTP Successful State Code(200)</strong>
- Else, it is will throw Exception and return <strong>HTTP Error Status Code (403)</strong>
---
<a href = "#Kafka Architecture">Kafka Architecture</a>
---
![Kafka Architecture](https://user-images.githubusercontent.com/86148510/224912248-0fa3b5c9-0ac4-4503-8953-fa21babe8708.png)
<a href = "#Partition Store Topics">Partition Stored Topics</a>
---
![Partition Store Topics](https://user-images.githubusercontent.com/86148510/224912501-5923b0e0-db96-40cf-85f3-8df395937ee4.png)

---
<a href = "#K8S">Kubernetes Documentation</a>
---
```
1. Overview
2. Kubernetes Architecture
3. Working flow
4. How to use
```
1. <strong>Overview</strong>
- Kubernetes is a portable, extensible, open source platform for managing containerized workloads and services, that facilitates both declarative configuration and automation. It has large, rapidly growing ecosystem. K8s services, support, and tools are widely available
- K8s adapted for every demands that availability chat application needs. It has all characteristics:
- <strong>Service discovery and load balancing</strong> K8s can expose a container using the DNS name or using their own IP address. If traffic to a container is high, K8s is able to load balance and distribute the network traffic --> ensure the deployment is stable.
- <strong>Storage orchestration</strong> K8s allows automatically mount a storage system of your choice (localstorage, public cloud providers, ...)
- <strong>Self-healing</strong> K8s restarts containers that fail, replace containers, kill containers that don't response to your user-defined health check, and does'nt advertise them to client until they are ready to serve.
- <strong>Secret and configuration management</strong>K8s storage and manage sensitive information, such as password, OAuth token, and SSH keys. You can deploy and update secrets and application configuration without rebuilding your container images, and without exposing secrets in your stack configuration.
2. Kubernetes Architecture
![1](https://user-images.githubusercontent.com/86148510/233285997-19cc7648-4050-41ae-913b-d6e65d4db65d.png)
3. Working flow
![2](https://user-images.githubusercontent.com/86148510/233289026-73d05e95-eff7-4fef-8dcc-588f29235a06.jpg)
4. How to use
- Create new namespace used for the project
```
$ kubectl create namespace cba
```
- Set up configuration YAML <a href="http://192.168.122.20/lambda_2u/cba-brainstormers/tree/master/k8s-configuration">FILE CONFIG</a> file and used kubectl apply changes and deploy it to k8s
```
$ kubectl -n cba apply -f ${file_config.yml}
```
- Or used bash script to deploy all at once. Navigate to folder contains YAML files
```
$ for f in $(ls); do kubectl -n cba apply -f $f; done
```
- After finished, check whether pods, services, and deployments are available or not>
```
$ kubectl -n cba get po
$ kubectl -n cba get svc
$ kubectl -n cba get deploy
```
- Variation types of connections can be used on K8s, but in this scope, defined two scope network are currently using:
- NodePort: Exposes the Service on each Node's IP at a static port (NodePort).
- ClusterIP: When K8s needs to assign a virtual IP address for a Service that happens one of two ways:
- <strong>dynamically</strong>: the cluster's control plane automatically picks a free IP address from within the configured IP range for <strong>type: ClusterIP</strong> Services
- <strong>statically</strong>: specify an IP address of your choice, withing the configured IP range for Services.
--> ClusterIP will remain and not change whether it is crashed or not. Expose the Service on a cluster-internal IP.

