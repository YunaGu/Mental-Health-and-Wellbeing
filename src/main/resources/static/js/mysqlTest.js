//using node.js
//actually this file doesn't work, I finally use ajax but you can read as amplify
let mysql = require('mysql');
let connection = mysql.createConnection({
    host     : 'localhost',
    user     : 'root',
    password : '12345678',
    database : 'client'
});
connection.connect(function (err) {
    if (err) throw err;
    console.log("connected!");
    // connection.query("INSERT INTO client.quiz (score) VALUES (scores)");
    connection.query("SELECT * FROM client.quiz;", function (err, result) {
        if (err) throw err;
        console.log(result);
    });
});
