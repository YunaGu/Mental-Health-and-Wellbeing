function submit() {
    let checkOne = false;                    //if checked
    let scores = 0;
    let checkednum = 0;

    let checkBox = $('input[class = option]'); //get those checkboxes
    let el = document.getElementsByClassName("options");
    // for (let v = 1; v < el.length; v++){
    //     let checkBox = $('input[name = "v"]'); //get those checkboxes
    //     for (let i = 0; i < checkBox.length; i++) {
    //         //if at least one checked
    //         if (checkBox[i].checked) {
    //             checkOne = true;
    //             scores += parseInt(checkBox[i].value);
    //         }
    //     }
    //
    //     if (checkOne) {
    //         console.log("your score is：" + scores);
    //         localStorage.setItem("SCORES",scores);
    //     } else {
    //         console.log("sorry! at least one!");
    //     };
    //     console.log(checkBox[v]);
    //
    // }
    // let checkBox = $('input[name = "+v+"]'); //get those checkboxes
    for (let i = 0; i < checkBox.length; i++) {
        //if at least one checked
        if (checkBox[i].checked) {
            checkOne = true;
            checkednum++;
            scores += parseInt(checkBox[i].value);
        }
    }

    if (checkOne && (checkednum == el.length)) {
        // console.log("your score is：" + scores);
        localStorage.setItem("SCORES",scores);
        function jump() {
            window.location.href = "/score.html"
        }
        jump();
    } else {
        alert("sorry! Please make every choice first.");
    };
    // let data = {}
    // data.scores = scores;
    // let json_data = JSON.stringify(data)
    // $.ajax({
    //     url: "http://localhost:8080/quizList",
    //     type: "post",
    //     data: scores,
    //     dataType: "text",
    //     contentType: "application/json;charset=UTF-8",
    //     success: function (reps) {
    //         if (reps === "success") {
    //             // console.log(data.scores);
    //             window.location.href = "/score.html"
    //         } else {
    //             alert("error")
    //         }
    //     }
    // })
}
