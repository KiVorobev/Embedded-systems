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

function addUser() {
    let cardId = document.getElementById('card_id').value;
    let surname = document.getElementById('surname').value;
    let name = document.getElementById('name').value;
    let patronymic = document.getElementById('patronymic').value;
    let role = document.getElementById('role_select').value;
    sendAddUser(cardId, surname, name, patronymic, role);
}

function search() {
    let text = document.getElementById('search_input').value;
    sendSearch(text);
}