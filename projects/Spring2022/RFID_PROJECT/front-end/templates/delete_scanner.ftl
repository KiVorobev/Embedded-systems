<#include "main_template.ftl"/>

<#macro content>
    <div id="input-block">
        <label for="delete_scanner_input">ID:</label><input id="delete_scanner_input" type="text"/>
    </div>

    <div id="delete_scanner_buttons">
        <button onclick=goTo('scanners')>Отмена</button>
        <button id="delete_scanner_button" onclick=deleteScanner()>Удалить</button>
    </div>
</#macro>

<@main page="delete_scanner"/>