<#include "../templates/main_template.ftl"/>
<#include "../templates/table.ftl"/>

<#macro thead>
    <th>№ карты</th>
    <th>№ считывателя</th>
    <th>Дата и время</th>
</#macro>

<#macro tbody>
    <#list activities as activity>
        <tr>
            <td>${activity.cardId}</td>
            <td>${activity.scannerHardwareNum}</td>
            <td>${activity.formattedEnterActivity}</td>
        </tr>
    </#list>
</#macro>

<#macro content>
    <script>
        setInterval(goTo('start'), 1000);
    </script>
    <@table caption="Отклоненные запросы"/>
</#macro>

<@main page="main_page"/>