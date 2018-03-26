# web-app

Сервер приложений: apache-tomee-webprofile-7.0.2
прописать в pom адрес до сервера: папка webapps, переменная tomee.deploy.path
 настройки запуска под debug:
 
 добавить в начало
 
 set JPDA_ADDRESS=8000
  
 set JPDA_TRANSPORT=dt_socket

 изменить
 call "%EXECUTABLE%" start %CMD_LINE_ARGS%
 
 на
 call "%EXECUTABLE%" jpda start %CMD_LINE_ARGS%

  <role rolename="admin-gui"/>
  <role rolename="tomee-admin"/>
  <role rolename="manager-gui"/>
  <user password="tomee" roles="tomee-admin,manager-gui,admin-gui" username="tomee"/>


 Что почитать
 
    https://javaee.github.io/tutorial/toc.html
    https://github.com/javaee/tutorial-examples

    // сервлеты
    https://o7planning.org/ru/10395/java-servlet-filter-tutorial

    //  JSP + JSTL
    https://o7planning.org/ru/10263/java-jsp-tutorial#a38711
    https://o7planning.org/ru/10429/java-jsp-standard-tag-library-jstl-tutorial
    // пример JSP+JDBC
    https://o7planning.org/ru/10285/create-a-simple-java-web-application-using-servlet-jsp-and-jdbc