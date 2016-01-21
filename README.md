first-springsecurity
====================

概要
----

TERASOLUNAガイドラインの[Spring Securityチュートリアル](http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/Security/Tutorial.html)

[remember-me](http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/Security/Authentication.html#sec-remember-me)を追加

実行
----

    MAVEN_OPTS="-javaagent:springloaded-1.2.5.RELEASE.jar -noverify" mvn clean tomcat7:run

動作確認
--------

[http://localhost:8080/first-springsecurity/](http://localhost:8080/first-springsecurity/)

