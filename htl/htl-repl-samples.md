
Insert the follow HTL ane JS code into the HTL REPL:</br>
http://localhost:4502/editor.html/content/repl.html


```html
<!DOCTYPE html>

<html>
<head>
    <title>${currentPage.title}</title>
    <meta charset="utf-8">
</head>
<body>
    
<!--/****************** Expressions ******************/-->
    
  <!--/* Expressions are used to calculate the values of HTML attributes or HTML elements. */-->
  <div>${currentPage.path}</div>   
  <div class="${resource.path}"></div> 
    
  <!--/* The calculated value of an Expression can depend on conditions called Options. */-->
  <!--/* Basic syntax is ${myVar @ optOne=someVar}                                      */-->  
  <a href="${resource.path @ extension='html'}">Path to this resource</a>
  
  <!--/* Options can replace the enumerated placeholders, {n}, with the values          */-->
  <div>${'Page {0} of {1}' @ format=[50, 100]} </div>
  
  
  <!--/* Expressions containing only Options are called Parametric Expressions.         */--> 
  <!--/* Basic syntax is ${@ optOne, optTwo=bar}                                        */-->  
  <!--/* They can be used to send parameters to         */--> 
 

<!--/****************** templates ******************/-->
  <!--/* Template blocks can be used like function calls: in their declaration they can get parameters, */-->
  <!--/*  which can then be passed when calling them.                                                   */-->
  <!--/*          */-->          
<template data-sly-template.foo="${@ x, y, z}">
     Value of x = ${x}, y= ${y}, z= ${z}
</template>

  <!--/* Call the template with params using data-sly-call */-->
<div data-sly-call="${foo @ x=1, y=2, z=3}"></div>
    
    
<!--/* Templats do not have to have parameters */-->
<template data-sly-template.bar>
    <pre>bar has no parameters</pre>
</template>

<div data-sly-call="${bar}"></div>


<!--/* Change HTML tag with data-sly-element */-->
<div data-sly-element="h1">Lorem ipsum</div>

<!--/* Change HTML tag value with data-sly-text */-->
<div data-sly-text="Hello HTL">Lorem ipsum</div>


<!--/* data-sly-use */-->
<!--/* A HTL script can make use of objects generated on the AEM server.      */-->
<!--/* They can have the form of JSON, Java Objects or OSGi Services          */-->
<div data-sly-use.myObject="logic.js">
    <p>Value of b = ${myObject.b}</p>
</div>
<!--/* Scope: The identifier set by the data-sly-use block element is global  */-->
<!--/* to the script and can be used anywhere after its declaration.          */-->
<!--/* You can also call function on the use object                           */-->       
<div>
    <p>Return value of function f()= ${myObject.f}</p>
</div>

    
<div data-sly-use.myObjectWithParams="${'logic.js' @ param='World'}">${myObjectWithParams.g}</div>    
    
    
    

</body>
</html>
```

### JavaScript

```JavaScript
use(function (param) {
    
    var fooObject = {
        
        // data
        a: true,
        b: 'two',
        c: 3,
        d: param,
        
        // functions
        f() {
           return 'bar';
        },
        
        g(param) {
            var val = "Hello " + param;
            return val;
        }
        
    };
    
    return fooObject;
    
});
```