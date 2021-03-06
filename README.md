Resteasy JAX-RS XOP Multipart Example Deployed as WAR in JBoss 7 with Jersey Client
=====================================================================

Based on the template from https://github.com/jboss-jdf/jboss-as-quickstart/tree/jdf-2.0.0.Final/kitchensink-ear

System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.

The application this project produces is designed to be run on JBoss Enterprise Application Platform 6 or JBoss AS 7.


Start JBoss Enterprise Application Platform 6 or JBoss AS 7 with the Web Profile
-------------------------

1. Open a command line and navigate to the root of the JBoss server directory.
2. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat


Build and Deploy the WAR
-------------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this project.
3. Type this command to build and deploy the archive:

        mvn clean package jboss-as:deploy

4. This will deploy `jersey-resource-war/target/jboss-resource-war.war` to the running instance of the server.


Access the application
---------------------

The application will be running at the following URL: <http://localhost:8080/jboss-resource-war/xop>.

Undeploy the Archive
--------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this project.
3. When you are finished testing, type this command to undeploy the archive:

        mvn jboss-as:undeploy


Jersey Client Console Output
---------------------
You should see messages similar to the following:

    Jan 19, 2013 9:47:03 PM com.sun.jersey.api.client.filter.LoggingFilter log
    INFO: 1 * Client out-bound request
    1 > POST http://localhost:8080/jboss-resource-war/xop/user/aruld
    1 > Content-Type: multipart/related
    --Boundary_1_1121984713_1358668023615
    Content-Type: application/xml

    <?xml version="1.0" encoding="UTF-8" standalone="yes"?><item><username>aruld</username><image>SGVsbG8gWG9wIFdvcmxkIQ==</image></item>
    --Boundary_1_1121984713_1358668023615--


    Jan 19, 2013 9:47:04 PM com.sun.jersey.api.client.filter.LoggingFilter log
    INFO: 1 * Client in-bound response
    1 < 200
    1 < Date: Sun, 20 Jan 2013 07:47:03 GMT
    1 < Content-Length: 123
    1 < Content-Type: application/xml
    1 < Server: Apache-Coyote/1.1
    1 <
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?><userInfo><uid>036f3a8b-87bd-4bad-b36b-7f7a5edc650b</uid></userInfo>

    036f3a8b-87bd-4bad-b36b-7f7a5edc650b

JBoss Server Console Output
--------------------

    21:46:36,963 INFO  [org.jboss.as.server.deployment] (MSC service thread 1-14) JBAS015876: Starting deployment of "jboss-resource-war.war"
    21:46:37,177 INFO  [org.jboss.web] (MSC service thread 1-9) JBAS018210: Registering web context: /jboss-resource-war
    21:46:37,204 INFO  [org.jboss.as.server] (management-handler-thread - 1) JBAS018559: Deployed "jboss-resource-war.war"
    21:47:03,838 INFO  [org.jboss.resteasy.spi.ResteasyDeployment] (http--127.0.0.1-8080-1) Deploying javax.ws.rs.core.Application: class com.aruld.resources.MyApplication
    21:47:04,097 INFO  [stdout] (http--127.0.0.1-8080-1) Received request from # aruld
    21:47:04,098 INFO  [stdout] (http--127.0.0.1-8080-1) XOP # Hello Xop World!

Structure of the WAR
--------------------

jboss-resource-war.war
----------------------
         0 Sat Jan 19 20:51:10 HST 2013 META-INF/
       123 Sat Jan 19 20:51:08 HST 2013 META-INF/MANIFEST.MF
         0 Sat Jan 19 20:51:08 HST 2013 WEB-INF/
         0 Sat Jan 19 20:51:08 HST 2013 WEB-INF/classes/
         0 Sat Jan 19 20:51:08 HST 2013 WEB-INF/lib/
      5197 Sat Jan 19 20:51:08 HST 2013 WEB-INF/lib/jboss-resource-war-1.0-SNAPSHOT.jar
       253 Sat Jan 19 18:59:20 HST 2013 WEB-INF/web.xml