<#include "../templates/main_template.ftl"/>
<#include "../templates/full_name_form.ftl"/>
<#include "../templates/buttons.ftl"/>

<#macro content>
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
        <@form/>

        <button id="clear_history_button" onclick=clearActivityHistory()>Очистить историю активности</button>

        <button id="delete_user" onclick="deleteUser()">Удалить пользователя</button>

        <@buttons leftFunction="goTo('user/get/${user.userId}')" rightFunction="userEdit()"
        leftName="Отмена" rightName="Сохранить"/>
    </div>
</#macro>

<@main page="user_edit"/>