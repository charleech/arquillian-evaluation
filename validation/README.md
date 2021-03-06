validation
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

The JBoss Arquillian evaluation: The JBoos Seam Validation Integration

This is a project which provides example for integrating with the JBoss
Seam Valiation module and the Arquillian for demonstrating.

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

