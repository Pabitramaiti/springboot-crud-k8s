# springboot-crud-k8s
Run &amp; Deploy Spring Boot CRUD Application With MySQL on K8S in local

https://www.youtube.com/watch?v=pIPji3_rYPY&list=PLVz2XdJiJQxybsyOxK7WFtteH42ayn5i9&index=8
https://github.com/Java-Techie-jt/springboot-crud-k8s

> docker context use default
> kubectl apply -f mysql-pv.yaml
> kubectl apply -f mysql-secrets.yaml
> kubectl apply -f mysql-configMap.yaml
> kubectl apply -f db-deployment.yaml

> docker build -t pabitramaiti/springboot-crud-k8s:latest .
> docker build --no-cache -t pabitramaiti/springboot-crud-k8s:latest .
> docker scout quickview
> docker push pabitramaiti/springboot-crud-k8s:latest

> kubectl get pods
> kubectl exec -it POD_NAME -- bash		# it -> integrated terminal
OR//
> kubectl exec -it mysql-67d79b5974-x45f5 -- bash
OR//
> kubectl exec -it mysql-67d79b5974-x45f5 bash

bash-5.1#> mysql -h mysql -u pabitra -p
		   Enter password: Welcome@01

mysql> show databases;

+--------------------+
| Database           |
+--------------------+
| information_schema |
| javatechie         |
| performance_schema |
+--------------------+

mysql> use javatechie;
mysql> show tables;
mysql> exit
bash-5.1> exit

> kubectl apply -f app-deployment.yaml
> kubectl get pods
> kubectl logs -f springboot-crud-deployment-7f9d8fc54b-2cj4f
> kubectl get svc
NAME                  TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
kubernetes            ClusterIP   10.96.0.1       <none>        443/TCP          28h
mysql                 NodePort    10.100.118.82   <none>        3306:30006/TCP   12m
springboot-crud-svc   NodePort    10.103.85.13    <none>        8080:31659/TCP   26h

> minikube service springboot-crud-svc --url

http://127.0.0.1:64982
❗  Because you are using a Docker driver on windows, the terminal needs to be open to run it.

Service Endpoins:-
===================
http://127.0.0.1:64982/ready

> kubectl get endpoints

> minikube ip
W0520 00:29:16.781879   40844 main.go:291] Unable to resolve the current Docker CLI context "default": context "default": context not found: open C:\Users\pabit\.docker\contexts\meta\37a8eec1ce19687d132fe29051dca629d164e2c4958ba141d5f4133a33f0688f\meta.json: The system cannot find the path specified.
192.168.49.2

Service Endpoins (Not Working):-
================================
http://192.168.49.2:31659/orders/addorder (POST)
