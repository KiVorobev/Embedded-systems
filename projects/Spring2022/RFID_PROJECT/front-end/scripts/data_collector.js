document.getElementById('edit_user_button').addEventListener('click', function () {
    userEdit();
});

document.getElementById('add_scanner_button').addEventListener('click', function () {
    addScanner();
});

document.getElementById('delete_scanner_button').addEventListener('click', function () {
    deleteScanner();
});

document.getElementById('clear_history_button').addEventListener('click', function () {
    clearActivityHistory();
});

document.getElementById('delete_user').addEventListener('click', function () {
    deleteUser();
});

document.getElementById('search_button').addEventListener('click', function () {
    search();
});

function setRole(role) {
    if (role === "USER") {
        document.getElementById('user').setAttribute('selected', true);
    } else {
        if (role === "ADMIN") {
            document.getElementById('admin').setAttribute('selected', true);
        } else {
            document.getElementById('choose').setAttribute('selected', true);
        }
    }
}

function userEdit() {
    let id = document.getElementById('user_id').value;
    let surname = document.getElementById('surname').value;
    let name = document.getElementById('name').value;
    let patronymic = document.getElementById('patronymic').value;
    let role = document.getElementById('role_select').value;
    sendUserEdit(id, surname, name, patronymic, role);
}

function addScanner() {
    let id = document.getElementById('add_scanner_input').value;
    let role = document.getElementById('scanner_role_select').value;
    sendAddScanner(id, role);
}

function deleteScanner() {
    let id = document.getElementById('delete_scanner_input').value;
    sendDeleteScanner(id);
}

function clearActivityHistory() {
    let id = document.getElementById('user_id').value;
    sendClearActivityHistory(id);
}

function deleteUser() {
    let id = document.getElementById('user_id').value;
    sendDeleteUser(id);
}

function search() {
    let text = document.getElementById('search_input').value;
    sendSearch(text);
}