# java-for-web-cap3-hibernate-examples
01-08-2020
Incio - Cria��o do projeto com maven no eclipse
1. File > New > Other
2. Maven project
3. Select option "Create a simple project..."


Problema encontrados ao utilizar o hibernate 4.3.4.Final :
eclipse maven project missing artifact

Soluca��o :
  Maven -> Update Maven Dependencies and check the option for "Force Update of Snapshot/Releases".
  
hibernate.cfg.xml, problemas enontrados  

Localiza��o do banco de dados, no livro : <property name="connection.url">jdbc:mysql//localhost/agenda</property>
Devido a utiliza��o de uma porta diferente da padrao, deve ficar :
<property name="connection.url">jdbc:mysql://localhost:3307/agenda</property>
mesmo assim ainda ocorreu o problema anterior de time-zone :

Cria��o inicial do objeto SessionFactory falhou. 
Erro : org.hibernate.HibernateException: Unable to make JDBC Connection [jdbc:mysql:3307//localhost/agenda]Exception in thread "main" 

Solu��o : adicionar novamente o parametro serverTimezone=UTC
<property name="connection.url">jdbc:mysql://localhost:3307/agenda?serverTimezone=UTC</property>