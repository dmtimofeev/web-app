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


 Что почитать
    https://javaee.github.io/tutorial/toc.html
    https://github.com/javaee/tutorial-examples