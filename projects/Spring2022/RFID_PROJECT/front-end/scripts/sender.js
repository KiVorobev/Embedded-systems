toastr.options = {
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-top-right",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "300000000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
}

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
            toastr.success('Пользователь успешно обновлен')
        },
        error: function (response) {
            toastr.error(response)
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
            toastr.success('Считыватель успешно добавлен')
        },
        error: function (response) {
            toastr.error(response)
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
            toastr.success('Пользователь успешно добавлен')
        },
        error: function (response) {
            toastr.error(response)
        }
    });
}

function sendDeleteScanner(id) {
    $.ajax({
        url: "http://localhost:" + getPort() + "/scanner/delete/" + id,
        type: "DELETE",
        success: function () {
            toastr.success('Считыватель успешно удален')
        },
        error: function (response) {
            toastr.error(response)
        }
    });
}

function sendClearActivityHistory(id) {
    $.ajax({
        url: "http://localhost:" + getPort() + "/user/delete/activities/" + id,
        type: "DELETE",
        success: function () {
            toastr.success('История активности успешно очищена')
        },
        error: function (response) {
            toastr.error(response)
        }
    });
}

function sendDeleteUser(id) {
    $.ajax({
        url: "http://localhost:" + getPort() + "/user/delete/" + id,
        type: "DELETE",
        success: function () {
            // нужен редирект на стартовую страницу
            toastr.success('Пользователь успешно удален')
        },
        error: function (response) {
            toastr.error(response)
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
        success: function (output, status, xhr) {
            let userId = xhr.getResponseHeader("userId");
            goTo('user/get/' + userId);
        },
        error: function (response) {
            toastr.error(response)
        }
    });
}