function sendUserEdit(id, surname, name, patronymic, role) {
    $.ajax({
        url: "http://localhost:" + getPort() + "/user/update",
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
            alert("Пользователь обновлен!");
        },
        error: function (response) {
            alert(response);
        }
    });
}

function sendAddScanner(id, role) {
    $.ajax({
        url: "http://localhost:" + getPort() + "/scanner/add",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            hardwareNumber: id,
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

function sendAddUser(cardId, surname, name, patronymic, role) {
    $.ajax({
        url: "http://localhost:" + getPort() + "/user/add",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            cardId: cardId,
            surname: surname,
            name: name,
            patronymic: patronymic,
            role: role,
        }),
        success: function () {
            alert("Пользователь добавлен!");
        },
        error: function (response) {
            alert(response);
        }
    });
}

function sendDeleteScanner(id) {
    $.ajax({
        url: "http://localhost:" + getPort() + "/scanner/delete/" + id,
        type: "DELETE",
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
        url: "http://localhost:" + getPort() + "/user/delete/activities/" + id,
        type: "DELETE",
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
        url: "http://localhost:" + getPort() + "/user/delete/" + id,
        type: "DELETE",
        success: function () {
            console.log('OK');
        },
        error: function (response) {
            console.log(this.url)
            alert(response);
        }
    });
}

function sendSearch(cardId) {
    $.ajax({
        url: "http://localhost:" + getPort() + "/user/search/",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            cardId: cardId,
        }),
        success: function () {
            console.log('OK');
        },
        error: function (response) {
            alert(response);
        }
    });
}