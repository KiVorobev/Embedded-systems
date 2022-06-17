function goTo(link) {
    $.ajax({
        url: "http://localhost:" + getPort() + "/" + link,
        type: "GET",
        success: function () {
            console.log('OK');
        },
        error: function (response) {
            console.log(this.url)
            alert(response);
        }
    })
}

function getPort(){
    let port = "${port}";
    let string_port = port.toString().replace(/\s/g, '');
    return string_port;
}