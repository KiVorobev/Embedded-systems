<#include "../templates/main_template.ftl"/>
<#include "../templates/buttons.ftl"/>

<#macro content>
    <div id="id-block">
        <label id="id_label" for="add_scanner_input">ID:</label>
        <input id="add_scanner_input" type="text"/>
    </div>

    <div id="role-block">
        <label id="role_label" for="scanner_role_select">Роль:</label>
        <select id="scanner_role_select">
            <option selected disabled>Выберите роль</option>
            <option>Пользователь</option>
            <option>Админ</option>
        </select>
    </div>

    <@buttons leftFunction="goTo('scanners')" rightFunction="addScanner()" leftName="Отмена" rightName="Добавить"/>
</#macro>

<@main page="add_scanner"/>