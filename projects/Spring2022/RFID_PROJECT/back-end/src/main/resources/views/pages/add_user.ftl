<#include "../templates/main_template.ftl"/>
<#include "../templates/buttons.ftl"/>


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

        <div class="inputs">
            <label id="surname_label" for="surname">Фамилия:</label>
            <input id="surname" type="text" placeholder="Введите фамилию"/>
        </div>

        <div class="inputs">
            <label id="name_label" for="name">Имя:</label>
            <input id="name" type="text" placeholder="Введите имя"/>
        </div>

        <div class="inputs">
            <label id="patronymic_label" for="patronymic">Отчество:</label>
            <input id="patronymic" type="text" placeholder="Введите отчество"/>
        </div>

        <@buttons leftFunction="goTo('start')" rightFunction="addUser()" leftName="Отмена" rightName="Сохранить"/>
    </div>
</#macro>

<@main page="add_user"/>