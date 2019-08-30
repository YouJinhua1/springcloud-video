在catalina.bat中的第二行，@echo off的下面加上：
JAVA_OPTS="-server -Xms256m -Xmx512m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=256m"
-Xms:默认是物理内存的64分之1，最大要超过80%
-Xmx:建议设置为物理内存的一半
-XX:MetaspaceSize：默认是21m
-XX:MaxMetaspaceSize：默认是无上限的

http://cache.baiducontent.com/c?m=9f65cb4a8c8507ed19fa950d100b92235c438014648c83493e8ed45f93130a1c187ba1a62128145780ce2a6750a84356feb56b32610c61f5db93d41fcabae27971d56062671df65663a00edfcc5153c637e02cfeaf68a5eca4&p=c660c64ad4d217ff57efdf6250&newp=8057d616d9c111a05aae8c344e53d8224216ed643dddc44324b9d71fd325001c1b69e7be27291202d3c7766004ab4d5cebf63478341766dada9fca458ae7c4&user=baidu&fm=sc&query=springcloud%CA%B5%D5%BD+pdf&qid=f69e0acb0006e0aa&p1=2


http://www.java1234.com/a/javabook/yun/2018/1220/12605.html

