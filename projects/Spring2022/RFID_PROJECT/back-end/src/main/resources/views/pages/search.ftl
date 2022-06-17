<#include "../templates/main_template.ftl"/>

<#macro content>
    <input type="text" id="search_input" placeholder="Введите ID карты"/>
    <button id="search_button" onclick="search()">Поиск</button>
</#macro>

<@main page="search"/>