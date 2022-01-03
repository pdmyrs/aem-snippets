# Adobe's WKND Reference Site

## How to Build and Deploy WKND to your local AEM instance

1. Download the Release src code from Adobe's GitHub repo:  https://github.com/adobe/aem-guides-wknd/releases
2. Change the parent pom.xml to use my versions of uberjar and core components. 

example :

```
        <core.wcm.components.version>2.12.2</core.wcm.components.version>
        <uber.jar.version>6.5.7</uber.jar.version>
```

3. Fix build error in the `core/pom.xml` file:

```
                <dependency>
                    <groupId>com.adobe.aem</groupId>
                    <artifactId>uber-jar</artifactId>
                    <version>${uber.jar.version}</version>
                    <!-- <classifier>apis</classifier> -->
                    <scope>provided</scope>
                </dependency>
```

4. Delete `core/src/test` directory. These tests fail.

5. Build and deploy with `-Pclassic` switch:

```
$ mvn clean install -PautoInstallSinglePackage -Pclassic
```
