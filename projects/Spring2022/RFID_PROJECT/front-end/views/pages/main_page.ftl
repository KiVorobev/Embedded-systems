<#include "../templates/main_template.ftl"/>
<#include "../templates/table.ftl"/>

<#macro thead>
    <th>№ считывателя</th>
    <th>Дата и время</th>
    <th>ФИО</th>
</#macro>

<#macro tbody>
    <#list activities as activity>
        <tr>
            <td>${activity.scannerHardwareNum}</td>
            <td>${activity.formattedEnterActivity}</td>
            <td onclick="goTo('user/get/${activity.userId}')">${activity.user.surname} ${activity.user.name} ${activity.user.patronymic}</td>
        </tr>
    </#list>
</#macro>

<#macro content>
    <@table caption="Последняя активность"/>
    <button onclick="goTo('rejected')">Отклоненные запросы</button>
</#macro>

<@main page="main_page"/>