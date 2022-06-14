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
    <button onclick=goTo('start')>Главная страница</button>
    <button onclick=goTo('user/put')>Добавить пользователя</button>
    <button onclick=goTo('scanners')>Считыватели</button>
    <button onclick=goTo('user/search')>Поиск</button>
</header>
<main>
    <img src="../img/404.png" alt="error"/>
</main>
</body>
</html>