<#include "../templates/main_template.ftl"/>
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
        <div class="inputs">
            <label id="surname_label" for="surname">Фамилия:</label>
            <input id="surname" type="text" placeholder="Введите фамилию" value="${user.surname}"/>
        </div>

        <div class="inputs">
            <label id="name_label" for="name">Имя:</label>
            <input id="name" type="text" placeholder="Введите имя" value="${user.name}/>
        </div>

        <div class="inputs">
            <label id="patronymic_label" for="patronymic">Отчество:</label>
            <input id="patronymic" type="text" placeholder="Введите отчество" value="${user.patronymic}/>
        </div>

        <button id="clear_history_button" onclick=clearActivityHistory()>Очистить историю активности</button>

        <button id="delete_user" onclick="deleteUser()">Удалить пользователя</button>

        <@buttons leftFunction="goTo('user/get/${user.userId}')" rightFunction="userEdit()"
        leftName="Отмена" rightName="Сохранить"/>
    </div>
</#macro>

<@main page="user_edit"/>