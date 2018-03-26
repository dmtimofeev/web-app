<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css"/>
</head>

<body>
<div class="main-signin">
    <div class="main-signin__head">
        <p>АВТОРИЗАЦИЯ</p>
    </div>
    <div class="main-signin__middle">
        <form action="${pageContext.request.contextPath}/login.do" method="post" class="middle__form">
            <div style="text-align: center;color: white;">
                <input type="radio" id="i_am_hacker" name="hacker_ф" value="yes">
                <label for="i_am_hacker">Я хакер)</label>

                <input type="radio" id="i_am_not_hacker" name="hacker_ф" value="no">
                <label for="i_am_not_hacker">Я не хакер!!!</label>
            </div>
            <input type="submit" value="Подтвердить">
        </form>
    </div>
    <div class="main-signin__foot">
        <div class="foot__left">
            <p>Зайти через:</p>
        </div>
        <div class="foot__right">
            <div class="twit"><a href="#"></a></div>
            <div class="face"><a href="#"></a></div>
        </div>
    </div>
</div>

</body>
</html>
