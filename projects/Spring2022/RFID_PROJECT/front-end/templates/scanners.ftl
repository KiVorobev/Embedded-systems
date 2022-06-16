<#include "main_template.ftl"/>

<#macro content>
    <ul>
        <div id="main_activity_table">
            <div id="scroll-table">
                <table>
                    <caption>Считыватели:</caption>
                    <thead>
                    <tr>
                        <th>№ считывателя</th>
                        <th>ID</th>
                        <th>Требуемая роль</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div id="scroll-table-body">
                <table>
                    <tbody>
                    <#list scanners as scanner>
                        <tr>
                            <td>${scanner.id}</td>
                            <td>${scanner.hardwareNumber}</td>
                            <td>${scanner.role}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
        <div id="scanner_buttons">
            <button id="add_scanner" onclick="goTo('scanner/put')">Добавить считыватель</button>
            <button id="delete_scanner" onclick="goTo('scanner/remove')">Удалить считыватель</button>
        </div>
    </ul>
</#macro>

<@main page="scanners"/>