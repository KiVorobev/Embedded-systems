<#include "../templates/main_template.ftl"/>
<#include "../templates/table.ftl"/>
<#include "../templates/buttons.ftl"/>

<#macro thead>
    <th>№ считывателя</th>
    <th>ID</th>
    <th>Требуемая роль</th>
</#macro>

<#macro tbody>
    <#list scanners as scanner>
        <tr>
            <td>${scanner.id}</td>
            <td>${scanner.hardwareNumber}</td>
            <td>${scanner.role}</td>
        </tr>
    </#list>
</#macro>

<#macro content>
    <@table caption="Считыватели"/>
    <@buttons leftFunction="goTo('scanner/put')" rightFunction="goTo('scanner/remove')"
    leftName="Добавить считыватель" rightName="Удалить считыватель"/>
</#macro>

<@main page="scanners"/>