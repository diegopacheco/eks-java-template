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
mypod=$(kubectl get pods -l app=javajetty --output=jsonpath={.items..metadata.name})
kubectl port-forward $mypod 8080:8080
curl http://localhost:8080/rest/datetime
minikube stop
```

## Deploy & Run EKS (AWS)
```bash
minikube start
kubectl apply -f specs/
mypod=$(kubectl get pods -l app=javajetty --output=jsonpath={.items..metadata.name})
kubectl port-forward $mypod 8080:8080
curl http://localhost:8080/rest/datetime
minikube stop
```