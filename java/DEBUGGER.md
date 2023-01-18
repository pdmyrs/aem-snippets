
## How to step through the Java debugger in VSCode

1. Install the VSCode Extension Pack for Java

https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack

2. Use the __maven-dependency-plugin__ to download source files

     core/pom.xml snippet

```
<!-- Added by pdmyrs for Java debugging           -->
<!--                                              -->
<!-- Use the maven-dependency-plugin to           -->
<!-- download source code for the debugger        -->
<!--                                              -->
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

3. Add dependencies for the jars you want to step through

## Useful Sling packages

1. Sling Engine

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


2. Sling ResourceResolver

```

<!-- Added by pdmyrs for sling request debugging  -->
<!--                                              -->
<!--   org.apache.sling.resourceresolver          -->
<!--                                              -->
<!--  A resource resolver provides various        -->
<!--  methods to manage resources.                -->
<!--  All changes are transient and require to    -->
<!--  commit them at the end.                     -->
<dependency>
   <groupId>org.apache.sling</groupId>
   <artifactId>org.apache.sling.resourceresolver</artifactId>
   <version>1.7.0</version>
   <scope>provided</scope>
</dependency>

```





