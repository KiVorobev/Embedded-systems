<#include "main_template.ftl"/>

<#macro content>
    <ul>
        <div id="main_activity_table">
            <div id="scroll-table">
                <table>
                    <caption>Последняя активность:</caption>
                    <thead>
                    <tr>
                        <th>№ считывателя</th>
                        <th>Дата и время</th>
                        <th>ФИО</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div id="scroll-table-body">
                <table>
                    <tbody>
                    <#list activities as activity>
                        <tr>
                            <td>${activity.scannerHardwareNum}</td>
                            <td>${activity.formattedEnterActivity}</td>
                            <td onclick="goTo('user/get/${activity.userId}')">${activity.user.surname} ${activity.user.name} ${activity.user.patronymic}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </ul>
</#macro>

<@main page="main_page"/>