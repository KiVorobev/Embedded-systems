<#include "../templates/main_template.ftl"/>
<#include "../templates/full_name_form.ftl"/>
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

        <@form/>

        <@buttons leftFunction="goTo('start')" rightFunction="addUser()" leftName="Отмена" rightName="Сохранить"/>
    </div>
</#macro>

<@main page="add_user"/>