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
    <link rel="stylesheet" type="text/css" href="../styles/user_edit.css">
    <script src="../scripts/navigator.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../scripts/sender.js"></script>
    <script src="../scripts/data_collector.js"></script>
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
        <label id="role_label" for="role_select">Роль:</label>
        <select id="role_select">
            <option selected disabled>Выберите роль</option>
            <option>Пользователь</option>
            <option>Администратор</option>
        </select>
    </div>

    <div id="right">
        <label id="surname_label" for="surname">Фамилия:</label>
        <input id="surname" type="text" placeholder="Введите фамилию" value="${surname}"/>
        <br/>
        <label id="name_label" for="name">Имя:</label>
        <input id="name" type="text" placeholder="Введите имя" value="${name}"/>
        <br/>
        <label id="patronymic_label" for="patronymic">Отчество:</label>
        <input id="patronymic" type="text" placeholder="Введите отчество" value="${patronymic}"/>

        <button id="clear_history_button">Очистить историю активности</button>

        <button id="delete_user">Удалить пользователя</button>

        <div id="edit_user_buttons">
            <button onclick="goTo('user.html')">Отмена</button>
            <button id="edit_user_button">Сохранить</button>
        </div>
    </div>
</main>
</body>
</html>