<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>RFID System</title>
    <style type="text/css">
        <#include "../styles/index.css">
        <#include "../styles/header.css">
        <#include "../styles/user_edit.css">
    </style>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        <#include "../scripts/navigator.js">
        <#include "../scripts/role_converter.js">
        <#include "../scripts/validator.js">
        <#include "../scripts/sender.js">
        <#include "../scripts/data_collector.js">
    </script>
</head>
<body>
<header>
    <div onclick=goTo('start')>Главная страница</div>
    <div onclick=goTo('user/put')>Добавить пользователя</div>
    <div onclick=goTo('scanners')>Считыватели</div>
    <div onclick=goTo('user/search')>Поиск</div>
</header>
<main>
    <div id="left">
        <div id="user_id">
            <div class="topic">ID:
                <text class="content" id="idText">${user.userId}</text>
            </div>
        </div>
        <label id="role_label" for="role_select">Роль:</label>
        <select id="role_select">
            <option disabled id="choose">Выберите роль</option>
            <#if user.role == 'USER'>
                <option selected id="user">Пользователь</option>
                <option id="admin">Админ</option>
            <#else>
                <option id="user">Пользователь</option>
                <option selected id="admin">Админ</option>
            </#if>
        </select>
    </div>

    <div id="right">
        <div class="inputs">
            <label id="surname_label" for="surname">Фамилия:</label>
            <input id="surname" type="text" placeholder="Введите фамилию" value="${user.surname}"/>
        </div>

        <div class="inputs">
            <label id="name_label" for="name">Имя:</label>
            <input id="name" type="text" placeholder="Введите имя" value="${user.name}"/>
        </div>

        <div class="inputs">
            <label id="patronymic_label" for="patronymic">Отчество:</label>
            <input id="patronymic" type="text" placeholder="Введите отчество" value="${user.patronymic}"/>
        </div>

        <button id="clear_history_button" onclick=clearActivityHistory()>Очистить историю активности</button>

        <button id="delete_user" onclick="deleteUser()">Удалить пользователя</button>

        <div id="edit_user_buttons">
            <button onclick="goTo('start')">Отмена</button>
            <button id="edit_user_button" onclick="userEdit()">Сохранить</button>
        </div>
    </div>
</main>
</body>
</html>