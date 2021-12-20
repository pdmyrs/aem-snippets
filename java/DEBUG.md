
Add to the core/pom.xml ...


tell the maven-dependency-plugin to download source files:
```
          <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-dependency-plugin</artifactId>
                <version>3.1.2</version>
                <executions>
                  <execution>
                    <id>download-sources</id>
                    <goals>
                      <goal>sources</goal>
                    </goals>
                    <configuration>
                    </configuration>
                  </execution>
                </executions>
         </plugin>
```

add sling dependencies:

```
<!-- Added by pdmyrs for sling request debugging  -->
<!--                                              -->
<!--          org.apache.sling.engine             -->
<!--                                              -->
<!--  Apache Sling Main Servlet                   -->
<!--   "The Main processor of the Sling framework -->
<!--    controlling all aspects of processing     -->
<!--    requests inside of Sling, namely          -->
<!--    authentication, resource resolution,      -->
<!--    servlet/script resolution and execution   -->
<!--    of servlets and scripts."                 -->
<dependency>
    <groupId>org.apache.sling</groupId>
    <artifactId>org.apache.sling.engine</artifactId>
    <version>2.7.2</version>
    <scope>provided</scope>
</dependency>
```
