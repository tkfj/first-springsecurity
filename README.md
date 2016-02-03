first-springsecurity
====================

概要
----

TERASOLUNAガイドラインの[Spring Securityチュートリアル](http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/Security/Tutorial.html)

実行
----

Linux

    MAVEN_OPTS="-javaagent:springloaded-1.2.5.RELEASE.jar -noverify" mvn clean tomcat7:run

Windows

    set MAVEN_OPTS=-javaagent:springloaded-1.2.5.RELEASE.jar -noverify
    mvn clean tomcat7:run

リモートデバッグ
----------------

Eclipseからリモートデバッグでアタッチする場合は`MAVEN_OPTS`を修正する。

Linux

    MAVEN_OPTS="-javaagent:springloaded-1.2.5.RELEASE.jar -noverify -agentlib:jdwp=transport=dt_socket,address=10000,server=y,suspend=n" mvn clean tomcat7:run

Windows

    set MAVEN_OPTS=-javaagent:springloaded-1.2.5.RELEASE.jar -noverify -agentlib:jdwp=transport=dt_socket,address=10000,server=y,suspend=n
    mvn clean tomcat7:run

以下、Eclipseで

  1. 実行(Run) -> デバッグの構成(Debug Configrations)
  2. リモートJavaアプリケーション(Remote Java Application) で右クリック -> 新規(New)
  3. プロジェクトを選択（XXX-web, XXX-domain など)
  4. ポートは`MAVEN_OPTS`で設定した`address`の値を入力

動作確認
--------

[http://localhost:8080/first-springsecurity/](http://localhost:8080/first-springsecurity/)

