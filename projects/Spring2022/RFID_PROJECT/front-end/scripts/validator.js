function addScannerValidation(id, role) {
    let idValid = idValidation(id)
    let roleValid = roleValidation(role)
    if (idValid) {
        document.getElementById('add_scanner_input').style.boxShadow = ''
    } else {
        document.getElementById('add_scanner_input').style.boxShadow = '0 0 5px 1px red'
    }
    if (roleValid) {
        document.getElementById('scanner_role_select').style.boxShadow = ''
    } else {
        document.getElementById('scanner_role_select').style.boxShadow = '0 0 5px 1px red'
    }
    return idValid && roleValid
}

function idValidation(id) {
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