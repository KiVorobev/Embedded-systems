function userEdit() {
    let id = document.getElementById('user_id').value
    let surname = document.getElementById('surname').value
    let name = document.getElementById('name').value
    let patronymic = document.getElementById('patronymic').value
    let role = convertRole(document.getElementById('role_select').value)
    if (userEditValidation(surname, name, role)) {
        sendUserEdit(id, surname, name, patronymic, role)
    }
}

function addScanner() {
    let id = document.getElementById('add_scanner_input').value
    let role = convertRole(document.getElementById('scanner_role_select').value)
    if (addScannerValidation(id, role)) {
        sendAddScanner(id, role)
    }
}

function deleteScanner() {
    let id = document.getElementById('delete_scanner_input').value
    if (deleteScannerValidation(id)) {
        sendDeleteScanner(id)
    }
}

function clearActivityHistory() {
    let id = document.getElementById('user_id').value
    sendClearActivityHistory(id)
}

function deleteUser() {
    let id = document.getElementById('user_id').value
    sendDeleteUser(id)
}

function addUser() {
    let cardId = document.getElementById('card_id').value
    let surname = document.getElementById('surname').value
    let name = document.getElementById('name').value
    let patronymic = document.getElementById('patronymic').value
    let role = convertRole(document.getElementById('role_select').value)
    if (addUserValidation(cardId, surname, name, role)) {
        sendAddUser(cardId, surname, name, patronymic, role)
    }
}

function search() {
    let cardId = document.getElementById('search_input').value
    sendSearch(cardId)
}