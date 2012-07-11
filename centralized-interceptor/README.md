deployment
==========

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/3.0/">
    <img alt="Creative Commons License" style="border-width:0"
    src="http://i.creativecommons.org/l/by-nc-sa/3.0/88x31.png" />
</a><br />
<span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">
   Charlee@GitHub
</span> by
<a xmlns:cc="http://creativecommons.org/ns#"
   href="https://github.com/charleech"
   property="cc:attributionName"
   rel="cc:attributionURL">
   Charlee Chitsuk
</a>
is licensed under a
<a rel="license"
   href="http://creativecommons.org/licenses/by-nc-sa/3.0/">
   Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
</a>.

The CDI interceptor evaluation

This is a project which provides the centralized CDI interceptors for testing
with the Arquillian.

Please feel free and do not hesitate to join, fork, share or keep improving it.

Note for Eclipse IDE.
====================
Since the Eclipse/JUnit does not integrated to the mavan-surefure-plugin,
then the java endorsed dirs is not existed.

The Eclipse/JUnit should be set the **"java.endorsed.dirs"** explicitly.
It can be done by setting the jvm.

1. Go to "**Run**" ---> "**Run Configuration**".
2. Choose **the test case**
3. Go to "**Arguments**" tab.
4. Go to "**VM arguments**" text box and enter the following: -
   * -Djava.endorsed.dirs=PATH/TO/ARQUILLIAN_GF_ROOT/modules/endorsed
   * e.g.
   -Djava.endorsed.dirs=c:/myprj/local-glassfish-embedded-312/modules/endorsed

Note for logging
================

1. The JUnit logging configuration is at
**_src/test/resources/logback-test.xml_**. It is a logback configuration.

2. The Glassfish embedded logging configuration is at
**_src/test/resources/arquillian/gf/gf-log.properties_**. It is a Java
Util Logger (JUL) configuration.

3. The EAR/EJB logging configuration is at
**_src/test/resources/arquillian/logback-test.xml_**. It is a logback
configuration.

Note for limitation #1, The issue #23
=====================================

https://github.com/charleech/arquillian-evaluation/issues/23

The **_class-loader delegation false_** cause the problem at production,
the web service, EJB cannot deployed since the related library could not be
found at the **_WEB-INF/lib_** or **_EAR/lib_**..

## The solution is as the following: -

### Arquillian unit testing
Provide the beans.xml with interceptor at the top of test classpath,
 **_src/test/resources/META-INF/beans.xml_**

### Production
Provide the beans.xml with interceptor at the top of Glassfish domain classpath,
 **_[domain]/lib/classes/META-INF/beans.xml_**
##### Caution
1. The enabled interceptors must be existed at the class path, e.g. global
classpath, ear lib, web lib, if not the application cannot be started as
null pointer exception.

2. There may be a chance that 2 application require different interceptor, e.g.
   * App1 requires Interceptor1, Interceptor2
      * The interceptor1 is in app1 lib
      * The interceptor2 is in app1 lib
   * App2 requires Interceptor1, Interceptor3
      * The interceptor1 is in app2 lib
      * The interceptor3 is in app2 lib
   * The enabled interceptor at  **_[domain]/lib/classes/META-INF/beans.xml_**
      * Interceptor1
      * Interceptor2
      * Interceptor3
   * When App1 is started, it will be failure as null pointer exception,
     since the enabled interceptor 3 cannot be found.
   * When App2 is started, it will be failure as null pointer exception,
     since the enabled interceptor 2 cannot be found.
