# eks-java-template

eks-java-template: Java 8 + Jetty 9 + Guice Docker + Kubernetes + EKS + Gradle + Rest Template. By Diego Pacheco(diegopacheco.github.io)

## Clean Build - Run local
```bash
./gradlew clean build
./gradlew appRun
curl http://localhost:8080/rest/datetime
```

## Build with Docker
```bash
docker build -t diegopacheco/javajetty . --no-cache
```

## Run with Docker
```bash
docker run diegopacheco/javajetty
```

## Deploy Docker hub
```bash
docker push diegopacheco/javajetty
```

## Deploy & Run Kubernetes (local)
```bash
minikube start

kubectl apply -f specs/
kubectl get all
mypod=$(kubectl get pods -l app=javajetty --output=jsonpath={.items..metadata.name})
kubectl port-forward $mypod 8080:8080
curl http://localhost:8080/rest/datetime
minikube stop
```

## Deploy & Run EKS (AWS)
```bash
eksctl create cluster --name javajetty --nodes=1 --region=us-west-2 --ssh-public-key=~/.ssh/kp_devpoc_k8s.pub

aws eks --region us-west-2 update-kubeconfig --name javajetty

kubectl apply -f specs/
kubectl get all
mypod=$(kubectl get pods -l app=javajetty --output=jsonpath={.items..metadata.name})
kubectl port-forward $mypod 8080:8080
curl http://localhost:8080/rest/datetime

eksctl delete cluster javajetty
```

More on: http://diego-pacheco.blogspot.com/2019/02/running-k8s-on-eks.html <BR/>
         http://diego-pacheco.blogspot.com/search?q=kubernetes