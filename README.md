# hadoop-job-listener
Simple maven project to serve MR job metadata.  Can...and should...be modified to deliver the data you need.

To use:

** Ensure no application is bound to port 8080 on the node you plan to run this jar on **
** All []'s below are simply options, NOT REQUIRED.  In fact, please set this in the application.properties BEFORE building with Maven **

1.  cd /path/to/project/hadoop-job-listener AND edit src/main/resources/application.properties to your needs
2.  /path/to/maven/bin/mvn clean package
3.  cp target/<name>.jar /desired/path/
4.  cd /desired/path/
5.  /path/to/java1.7/bin/java -jar [-Dserver.port=8080] [-Dconf.files.path=/opt/app/hadoop/conf/] [-Dkerberos.user=username] [-Dkerberos.realm=kerberos password] [-Dkerberos.keytab=/path/to/keytab] [-Djob.history.server.property=mapreduce.jobhistory.address] <name>.jar
6.  Spring should start and you should be able to visit:  http://<host>:8080/
