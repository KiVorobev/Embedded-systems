function convertRole(role) {
    if (role === 'Админ') {
        return 'ADMIN'
    } else if (role === 'Пользователь') {
        return 'USER'
    } else {
        return 'CHOOSE'
    }
}