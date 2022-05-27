function sendUserEdit(id, surname, name, patronymic, role) {
    $.ajax({
        url: "file.java",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            id: id,
            surname: surname,
            name: name,
            patronymic: patronymic,
            role: role,
        }),
        success: function () {
            console.log('OK');
        },
        error: function (response) {
            alert(response);
        }
    });
}

function sendAddScanner(id, role) {
    $.ajax({
        url: "file.java",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            id: id,
            role: role,
        }),
        success: function () {
            console.log('OK');
        },
        error: function (response) {
            alert(response);
        }
    });
}

function sendDeleteScanner(id) {
    $.ajax({
        url: "file.java",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            id: id,
        }),
        success: function () {
            console.log('OK');
        },
        error: function (response) {
            alert(response);
        }
    });
}

function sendClearActivityHistory(id) {
    $.ajax({
        url: "file.java",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            id: id,
        }),
        success: function () {
            console.log('OK');
        },
        error: function (response) {
            alert(response);
        }
    });
}

function sendDeleteUser(id) {
    $.ajax({
        url: "file.java",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            id: id,
        }),
        success: function () {
            console.log('OK');
        },
        error: function (response) {
            alert(response);
        }
    });
}

function sendSearch(text) {
    $.ajax({
        url: "file.java",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            text: text,
        }),
        success: function () {
            console.log('OK');
        },
        error: function (response) {
            alert(response);
        }
    });
}