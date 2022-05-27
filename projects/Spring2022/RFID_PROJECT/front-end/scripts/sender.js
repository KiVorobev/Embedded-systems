function sendUserEdit(id, surname, name, patronymic, role) {
    $.ajax({
        url: "file.java",
        type: "POST",
        data: {'id': id, 'surname': surname, 'name': name, 'patronymic': patronymic, 'role': role},
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
        data: {'id': id, 'role': role},
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
        data: {'id': id},
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
        data: {'id': id},
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
        data: {'id': id},
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
        data: {'text': text},
        success: function () {
            console.log('OK');
        },
        error: function (response) {
            alert(response);
        }
    });
}