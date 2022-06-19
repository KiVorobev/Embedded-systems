function userEdit() {
    let id = document.getElementById('idText').innerHTML
    let surname = document.getElementById('surname').value
    let name = document.getElementById('name').value
    let patronymic = document.getElementById('patronymic').value
    let role = convertRole(document.getElementById('role_select').value)
    let cardId = document.getElementById('card_id').value
    if (userEditValidation(surname, name, role)) {
        sendUserEdit(id, surname, name, patronymic, role, cardId)
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
    let id = document.getElementById('idText').innerHTML
    sendClearActivityHistory(id)
}

function deleteUser() {
    let id = document.getElementById('idText').innerHTML
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
    if (searchValidation(cardId)) {
        sendSearch(cardId)
    }
}