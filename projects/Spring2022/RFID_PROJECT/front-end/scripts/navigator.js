function goTo(link) {
    let port = getPort();
    console.log('http://localhost:'+port +'/'+ link);
    window.location.href = 'http://localhost:'+port +'/'+ link;
}

function getPort(){
    let port = "${port}";
    let string_port = port.toString().replace(/\s/g, '');
    return string_port;
}