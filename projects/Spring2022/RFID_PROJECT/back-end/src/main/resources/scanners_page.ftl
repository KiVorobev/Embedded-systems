<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<table>
    <thead>
    <tr>
        <th>№</th>
        <th>ID</th>
        <th>ROLE</th>
    </tr>
    </thead>
    <tbody>
    <#list scanners as scanner>
        <tr>
            <td>${scanner.id}</td>
            <td>${scanner.innerId}</td>
            <td>${scanner.role}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>