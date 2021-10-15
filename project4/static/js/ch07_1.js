function f1() {
var n = document.getElementById("v1").value;
    var arr = new Array();
    if (n < 1 || n > 19) {
        document.getElementById("alert1").className = "error";
        return;
    } else {
        document.getElementById("alert1").className = "hidden";
    }
    for(var i = 1; i <= 19; i++) {
        arr[i - 1] = n * i;
    }
    var col = 0;
    document.getElementById("res1").innerHTML = "";

    var s = "";
    s += "<table border='1'><tr>";
    for(var i of arr) {
        s += "<td>" + n + " x " + (arr.indexOf(i) + 1) + " = " + i + "</td>";
        if(col % 5 == 4) {
            s += "</tr><tr>";
        }
        col++;
    }
     // 모자란 <td> 를 채우기 위한 작업 추가.
     if (col % 5 != 0) {
        for(var i = 5 - col % 5; i > 0; i--) {
            s += "<td></td>";
        }
    }
    s += "</table>";
    document.getElementById("res1").innerHTML = s;
}


function f2() {
    var lot = new Array(6);
    for (var i = 0; i < lot.length;) {
                        //6개 길이만큼까지
    var r1 = Math.floor(Math.random() * 45 + 1); //1부터 생성되게끔
        //소수점 뒤에 버리기
      if(lot.indexOf(r1) == -1) {
        lot[i] = r1;
        i++;
    }
}
 // 정렬
    // lot.sort(function(x, y) {
    //     return x - y; // 오름차순
    //     // return y - x; // 내림차순
    // });
    lot.sort(asc);
    var s = "";
    var lotColor = ["num1to10", "num11to20", "num21to30", "num31to40", "num41to45"]
    for(var n of lot) {
        s += "<span class='lot " + lotColor[Math.floor((n - 1) / 10)] + "'>" + n + "</span>";
    }
    document.getElementById("res2").innerHTML = s;
}

function asc(x, y) {
    return x - y;
}
function desc(x, y) {
    return y - x;
}