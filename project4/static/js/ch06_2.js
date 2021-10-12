document.write("<h1 id='title1'> 웹 브라우저 화면에 출력</h1>");
console.log("브라우저 콘솔에 출력")

//함수 쓴다. // 함수이름(매개변수)
function changeTitle() {
 document.getElementById('title1').innerHTML = "태그의 요소를 선택 후 내용 삽입";
}

function activeInput() {
    var userInput = window.prompt("사용자 입력 프롬프트 활성화")//promot : 입력받기
    //입력 받은 값 변수에 저장
    
    console.log(userInput);
    document.getElementById("title1").innerHTML = userInput;
}

function changeValue() {
    var userInput = document.getElementById("user_input").value;
    document.getElementById("title1").innerHTML = userInput;

}