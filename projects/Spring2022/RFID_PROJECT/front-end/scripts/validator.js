function addScannerValidation(id, role) {
    let idValid = lengthValidation(id)
    let roleValid = roleValidation(role)
    addRedShadowIfInvalid(idValid, 'add_scanner_input')
    addRedShadowIfInvalid(roleValid, 'scanner_role_select')
    return idValid && roleValid
}

function addUserValidation(cardId, surname, name, role) {
    let cardIdValid = lengthValidation(cardId)
    let surnameValid = lengthValidation(surname)
    let nameValid = lengthValidation(name)
    let roleValid = roleValidation(role)
    addRedShadowIfInvalid(cardIdValid, 'card_id')
    addRedShadowIfInvalid(surnameValid, 'surname')
    addRedShadowIfInvalid(nameValid, 'name')
    addRedShadowIfInvalid(roleValid, 'role_select')
    return cardIdValid && surnameValid && nameValid && roleValid
}

function userEditValidation(surname, name, role) {
    let surnameValid = lengthValidation(surname)
    let nameValid = lengthValidation(name)
    let roleValid = roleValidation(role)
    addRedShadowIfInvalid(surnameValid, 'surname')
    addRedShadowIfInvalid(nameValid, 'name')
    addRedShadowIfInvalid(roleValid, 'role_select')
    return surnameValid && nameValid && roleValid
}

function deleteScannerValidation(id) {
    let idValid = lengthValidation(id)
    addRedShadowIfInvalid(idValid, 'delete_scanner_input')
    return idValid
}

function searchValidation(cardId) {
    let cardIdValid = lengthValidation(cardId)
    addRedShadowIfInvalid(cardId, 'search_input')
    return cardIdValid
}

function addRedShadowIfInvalid(valid, elementId) {
    if (valid) {
        document.getElementById(elementId).style.boxShadow = ''
    } else {
        document.getElementById(elementId).style.boxShadow = '0 0 5px 1px red'
    }
}

function lengthValidation(id) {
    if (id.length > 0) {
        return true
    } else {
        return false
    }
}

function roleValidation(role) {
    if (role === 'ADMIN' || role === 'USER') {
        return true
    } else {
        return false
    }
}