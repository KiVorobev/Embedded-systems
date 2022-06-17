<#include "../templates/main_template.ftl"/>
<#include "../templates/full_name_form.ftl"/>

<#macro content>
    <div id="left">
        <label id="role_label" for="role_select">Роль:</label>
        <select id="role_select">
            <option selected disabled>Выберите роль</option>
            <option>Пользователь</option>
            <option>Админ</option>
        </select>
    </div>

    <div id="right">
        <div class="inputs">
            <label id="id_label" for="card_id">ID карты:</label>
            <input id="card_id" type="text" placeholder="Введите ID карты"/>
        </div>

        <@form/>

        <div id="add_user_buttons">
            <button onclick="goTo('start')">Отмена</button>
            <button id="add_user_button" onclick="addUser()">Сохранить</button>
        </div>
    </div>
</#macro>

<@main page="add_user"/>