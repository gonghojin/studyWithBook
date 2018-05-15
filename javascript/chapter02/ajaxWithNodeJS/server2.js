// 모듈 추출
var express = require("express");
var bodyParser = require("body-parser");
var mysql = require("mysql");

// DB 연결
var client = mysql.createConnection({
    user : "selfStudy",
    password : "selfStudyPw",
    database : "Company"
});

// 웹서버 생성
var app = express();
app.use(express.static("public2"));
app.use(bodyParser.urlencoded({ extended : false }));// 일반적인 url 인코딩 요청으로 오는 데이터를
                                                    // 자동분해하는 함수를 리턴
app.get("/products", function(request, response) {
    //데이터베이스 요청
    client.query("SELECT * FROM products", function(error, data) {
        response.send(data);
    });
});

app.get("/products/:id", function(request, response) {
    var id = Number(request.params.id);

    client.query("SELECT * FROM products WHERE id=?", [id], function(error, data) {
        response.send(data);
    });
});

app.post("/products", function(request, response) {
    var name = request.body.name;
    var modelnumber = request.body.modelnumber;
    var series = request.body.series;

    client.query("INSERT INTO products(name, modelnumber, series) VALUES(?, ?, ?)", [name, modelnumber, series], function(error, data) {
        response.send(data);
    });

});

app.put("/products/:id", function(request, response) {
    var id = Number(request.params.id);
    var name = request.body.name;
    var modelnumber = request.body.modelnumber;
    var series = request.body.series;
    var query = "UPDATE products SET"

    if (name) { query += " name='" + name + "',"; }
    if (modelnumber) { query += " modelnumber='" + modelnumber + "',"; }
    if (series) { query += " series='" + series + "'"; }
    query += " WHERE id=" + id;

    console.info(query);
    client.query(query, function(error, data) {
        response.send(data);
    });
});

app.del("/products/:id", function(request, response) {});

app.listen(52273, function() {
    console.info("Servier Running at http:://localhost:52273");
});