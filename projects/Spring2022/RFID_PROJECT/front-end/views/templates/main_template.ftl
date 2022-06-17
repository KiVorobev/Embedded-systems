<#macro main page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>RFID System</title>
        <style type="text/css">
            <#include "../../styles/template_styles/index.css">
            <#include "../../styles/template_styles/header.css">
            <#include "../../styles/template_styles/button.css">
            <#include "../../styles/template_styles/table.css">
            <#include "../styles/${page}.css">
        </style>
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.css">
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
        <script>
            <#include "../../scripts/navigator.js">
            <#include "../../scripts/role_converter.js">
            <#include "../../scripts/validator.js">
            <#include "../../scripts/sender.js">
            <#include "../../scripts/data_collector.js">
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
        <@content/>
    </main>
    </body>
    </html>
</#macro>