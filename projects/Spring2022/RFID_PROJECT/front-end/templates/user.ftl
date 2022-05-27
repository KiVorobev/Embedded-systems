<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>RFID System</title>
    <link rel="stylesheet" type="text/css" href="../styles/index.css">
    <link rel="stylesheet" type="text/css" href="../styles/header.css">
    <link rel="stylesheet" type="text/css" href="../styles/user.css">
    <script src="../scripts/navigator.js"></script>
</head>
<body>
<header>
    <nav style="width: 100%">
        <p style="margin-left: 2.3%"><a href="main_page.ftl"><span>Главная страница</span></a></p>
        <p><a href="add_user.ftl"><span>Добавить пользователя</span></a></p>
        <p><a href="scanners.ftl"><span>Считыватели</span></a></p>
        <p><a href="search.ftl"><span>Поиск</span></a></p>
    </nav>
</header>
<main>
    <div id="left">
        <div id="name">
            <text>ФИО:</text>
            <text>${user.name}</text>
        </div>
        <div id="role">
            <text>Роль: ${user.role}</text>
        </div>
        <div id="user_id">
            <text>ID: ${user.id}</text>
        </div>
        <button onclick="goTo('user_edit.ftl')">Редактировать профиль</button>
    </div>
    <div id="right">
        <ul>
            <#list activities as activity>
                <table>
                    <caption>Последняя активность:</caption>
                    <thead>
                    <th>№ считывателя</th>
                    <th>Дата и время</th>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${activity.scanner}</td>
                        <td>${activity.date}</td>
                    </tr>
                    </tbody>
                </table>
            </#list>
        </ul>
    </div>
</main>
</body>
</html>