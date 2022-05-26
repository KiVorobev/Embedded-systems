<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Surame</th>
        <th>Patronymic</th>
        <th>scanner</th>
        <th>activity</th>
    </tr>
    </thead>
    <tbody>
    <#list activities as activity>
        <tr>
            <td>${activity.user.name}</td>
            <td>${activity.user.surname}</td>
            <td>${activity.user.patronymic}</td>
            <td>${activity.scannerId}</td>
            <td>${activity.enterActivity}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>