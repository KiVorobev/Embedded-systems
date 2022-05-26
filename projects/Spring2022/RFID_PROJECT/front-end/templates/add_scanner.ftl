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
    <link rel="stylesheet" type="text/css" href="../styles/add_scanner.css">
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
    <label id="id_label" for="add_scanner_input">ID:</label>
    <input id="add_scanner_input" type="text"/>

    <label id="role_label" for="role_select">Роль:</label>
    <select id="role_select">
        <option selected disabled>Выберите роль</option>
        <option>Пользователь</option>
        <option>Администратор</option>
    </select>

    <div id="add_scanner_buttons">
        <button onclick="goTo('scanners.ftl')">Отмена</button>
        <button id="add_scanner_button">Добавить</button>
    </div>
</main>
</body>
</html>