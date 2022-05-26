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
        <th>Role</th>
        <th>scanner</th>
        <th>activity</th>
    </tr>
    </thead>
    <tbody>
    <#list activities as activity>
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.patronymic}</td>
            <td>${user.role}</td>
            <td>${activity.scanner.innerId}</td>
            <td>${activity.enterActivity}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>