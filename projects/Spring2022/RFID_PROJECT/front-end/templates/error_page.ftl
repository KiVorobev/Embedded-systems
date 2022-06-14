<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>RFID System</title>
    <style type="text/css">
        <#include "../styles/error_page.css">
    </style>
    <script>
        <#include "../scripts/navigator.js">
    </script>
</head>
<body>
<header>
    <nav style="width: 100%">
        <p style="margin-left: 2.3%"><a onclick=goTo('start')><span>Главная страница</span></a></p>
        <p><a onclick=goTo('user/put')><span>Добавить пользователя</span></a></p>
        <p><a onclick=goTo('scanners')><span>Считыватели</span></a></p>
        <p><a onclick=goTo('user/search')><span>Поиск</span></a></p>
    </nav>
</header>
<main>
    <img src="../img/404.png" alt="error"/>
</main>
</body>
</html>