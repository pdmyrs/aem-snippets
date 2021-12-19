
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
<!-- Added by pdmyrs for sling request debugging -->
<dependency>
    <groupId>org.apache.sling</groupId>
    <artifactId>org.apache.sling.engine</artifactId>
    <version>2.6.18</version>
    <scope>provided</scope>
</dependency>

<!-- Added by pdmyrs for sling resource debugging -->
<!-- <dependency>  -->
<!-- 	<groupId>org.apache.sling</groupId> -->
<!-- 	<artifactId>org.apache.sling.api</artifactId> -->
<!-- 	<version>2.16.4</version> -->
<!-- 	<scope>provided</scope> -->
<!-- </dependency>       -->
<dependency>
   <groupId>org.apache.sling</groupId>
   <artifactId>org.apache.sling.resourceresolver</artifactId>
   <version>1.5.34</version>
   <scope>provided</scope>
</dependency>
```
