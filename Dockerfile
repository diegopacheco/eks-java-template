FROM jetty:9.4.12-alpine
ADD build/libs/eks-java-template-1.0.war /var/lib/jetty/webapps/root.war
EXPOSE 8080
