# prof-java-dev
Seminar paper for the college.

# Setup
The project was developed with Windows.
If you run the application under Linux you have to adjust some paths.
## pom.xml
The descriptor path of the maven-assembly-plugin has to be changed to src/assembly/dep.xml
## dep.xml
The output directory nodes have to be changed to /

The directory under fileSet has to be ${project.build.directory}/site

# Code checks
You can run the following commands to check the code:
mvn checkstyle:check
mvn pmd:check
mvn findbugs:check

#Running the application
Start the Jetty server with the command mvn jetty:run.

Navigate to http://localhost:8080/prof-java-dev.

You will get an user interface which provides the possibility of a location and country input.

Or you are able to navigate directly on the servlet by http://localhost:8080/prof-java-dev/WeatherServlet?location=albstadt&country=de

Of course you can pass other URL parameters.
