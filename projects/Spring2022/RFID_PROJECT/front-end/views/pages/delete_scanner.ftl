<#include "../templates/main_template.ftl"/>
<#include "../templates/buttons.ftl"/>

<#macro content>
    <div id="input-block">
        <label for="delete_scanner_input">ID:</label><input id="delete_scanner_input" type="text"/>
    </div>

    <@buttons leftFunction="goTo('scanners')" rightFunction="deleteScanner()" leftName="Отмена" rightName="Удалить"/>
</#macro>

<@main page="delete_scanner"/>