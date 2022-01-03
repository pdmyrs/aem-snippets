# Adobe's WKND Reference Site

## How to Build and Deploy WKND to your local AEM instance

1. Download the Release src code from Adobe's GitHub repo:  https://github.com/adobe/aem-guides-wknd/releases
2. Change the parent pom.xml to use my versions of uberjar and core components. 

example :

```
        <core.wcm.components.version>2.12.2</core.wcm.components.version>
        <uber.jar.version>6.5.7</uber.jar.version>
```

3. build and deploy:

```
$ mvn clean install -PautoInstallSinglePackage -Pclassic
```
