function getId() {
    console.log(document.getElementById("username"));
    console.log(document.getElementById("password")); //중복 요소 인 경우 맨 위가 로그됨
}

function getName() {
    console.log(document.getElementsByName("username")[0]);//인덱스로 위치 확인
    console.log(document.getElementsByName("password")[0]);
    console.log(document.getElementsByName("password")[1]);
}

function getTagName() {
    console.log(document.getElementsByTagName("input")[6]);
    console.log(document.getElementsByTagName("input")[7]);
    console.log(document.getElementsByTagName("input")[8]);
}

function getClass() {
    console.log(document.getElementsByClassName("input-form")[0]);
    console.log(document.getElementsByClassName("input-form")[1]);
    console.log(document.getElementsByClassName("input-form")[2]);

}

function getSelector() {
    console.log(document.querySelector("input"));
    console.log(document.querySelector("input").value);

    console.log(document.querySelector("password"));
    console.log(document.querySelector("password").value);

}

function getSelectorAll() {
    console.log(document.querySelectorAll("input"));
    console.log(document.querySelectorAll("#password"));
    console.log(document.querySelectorAll(".input-form"));


}