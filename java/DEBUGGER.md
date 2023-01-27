
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
    <version>2.7.8</version>
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


3. Sling Models

Find the installed versions for these by going to the felix console > bundles and searching for "models"

```
<!-- Added by pdmyrs for sling model debugging  -->
<!--                                              -->
     <dependency>
         <groupId>org.apache.sling</groupId>
         <artifactId>org.apache.sling.models.api</artifactId>
         <version>1.3.8</version>
         <scope>provided</scope>
     </dependency>
     <dependency>
         <groupId>org.apache.sling</groupId>
         <artifactId>org.apache.sling.models.impl</artifactId>
         <version>1.4.16</version>
         <scope>provided</scope>
     </dependency>
     <dependency>         
         <groupId>org.apache.sling</groupId>
         <artifactId>org.apache.sling.models.jacksonexporter</artifactId>
         <version>1.0.8</version>
         <scope>provided</scope>
     </dependency>
```
     
4. Sling Auth

```
<!-- Added by pdmyrs for sling auth debugging -->
	<dependency>
		<artifactId>org.apache.sling.auth.core</artifactId> 
		<version>1.4.2</version> 
		<groupId>org.apache.sling</groupId> 
		<scope>provided</scope> 
	</dependency>  
     
     
```


5. HTL

```
<!-- Added by pdmyrs for sling auth debugging -->
             <dependency>
                 <artifactId>org.apache.sling.scripting.core</artifactId>
                 <version>2.0.56</version>
                 <groupId>org.apache.sling</groupId>
                 <scope>provided</scope>
             </dependency>


<!-- Added by pdmyrs for sling auth debugging -->
             <dependency>
                 <artifactId>org.apache.sling.scripting.sightly</artifactId>
                 <version>1.1.2-1.4.0</version>
                 <groupId>org.apache.sling</groupId>
                 <scope>provided</scope>
             </dependency>
 
<!-- Added by pdmyrs for sling auth debugging -->
             <dependency>
                 <groupId>org.apache.sling</groupId>
                 <artifactId>org.apache.sling.scripting.sightly.runtime</artifactId>
                 <version>1.1.0-1.4.0</version>
                 <scope>provided</scope>
             </dependency>

<!-- Added by pdmyrs for sling auth debugging -->
             <dependency>
                 <artifactId>org.apache.sling.scripting.sightly.compiler</artifactId>
                 <version>1.1.2-1.4.0</version>
                 <groupId>org.apache.sling</groupId>
                 <scope>provided</scope>
             </dependency>
```

