function hiddenPass(element) {
    //동작하는지 확인 > alert("동작완료");
    
    //비밀번호가 가려지지 않고 그대로 보이게 하는
    var c = element.checked;
    if(c == true) {
        document.getElementById("id_pass").type = "text";
    } else {
        document.getElementById("id_pass").type = "password";
        }
    }

function requiredItem(element) {
    
}