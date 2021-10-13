x = 10; //전역변수
console.log(x);
fun1();
console.log(x);

function fun1() { //메소드 안에서 지역변수
    x = 20; // var를 붙여야 지역변수로 간주한다. 안그럼 전역변수로 간주되기도 함.
    console.log(x);
}

y = 30;
console.log(y);
fun2();
console.log(y);

function fun2() {
    var y = 40; //var 붙여서 지역변수임을 알려주기
    z = 50; 
    console.log(y);
    console.log(z);

}

function f1(){
    document.getElementById("res1").innerHTML = typeof("문자열");
}

function f2(){
    document.getElementById("res2").innerHTML = typeof(123);
}

function f3(){
    document.getElementById("res3").innerHTML = typeof(true);
}

function f4(){
    document.getElementById("res4").innerHTML = typeof(object);
} //객체가 없기 때문에 값이 없는 걸로 나온다.