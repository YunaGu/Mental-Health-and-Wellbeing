// let content = <i className="bi bi-emoji-smile"></i>
let emoji = document.getElementById("emoji")
let more = document.getElementById("recommend");
if (score < 15){
    const newEmoji = document.createElement("div");
    newEmoji.innerHTML = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-emoji-smile\" viewBox=\"0 0 16 16\">\n" +
        "  <path d=\"M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z\"/>\n" +
        "  <path d=\"M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683zM7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z\"/>\n" +
        "</svg>"
    const newCon = document.createTextNode("You are not suffering with an anxiety disorder")
    newEmoji.appendChild(newCon);
    emoji.appendChild(newEmoji);

    const recommend = document.createElement("a");
    recommend.innerHTML = "<a href='http://localhost:8080/nutrition'> Click to find more about nutrition </a>"
    // recommend.innerHTML = "<a href='http://localhost:8080/sleeping'> Click to find more about sleeping </a>"
    more.appendChild(recommend);

    // console.log("test")
} else if (score >= 15 && score < 35) {
    const newEmoji = document.createElement("svg");
    newEmoji.innerHTML = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-emoji-neutral\" viewBox=\"0 0 16 16\">\n" +
        "  <path d=\"M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z\"/>\n" +
        "  <path d=\"M4 10.5a.5.5 0 0 0 .5.5h7a.5.5 0 0 0 0-1h-7a.5.5 0 0 0-.5.5zm3-4C7 5.672 6.552 5 6 5s-1 .672-1 1.5S5.448 8 6 8s1-.672 1-1.5zm4 0c0-.828-.448-1.5-1-1.5s-1 .672-1 1.5S9.448 8 10 8s1-.672 1-1.5z\"/>\n" +
        "</svg>"
    const newCon = document.createTextNode("You may be suffering with an anxiety disorder")
    newEmoji.appendChild(newCon);
    emoji.appendChild(newEmoji);

    const recommend = document.createElement("a");
    // recommend.innerHTML = "<a href='http://localhost:8080/nutrition'> Click to find more about nutrition </a>"
    recommend.innerHTML = "<a href='http://localhost:8080/sleep'> Click to find more about sleeping </a>"
    more.appendChild(recommend);

} else {
    const newEmoji = document.createElement("svg");
    newEmoji.innerHTML = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-emoji-frown\" viewBox=\"0 0 16 16\">\n" +
        "  <path d=\"M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z\"/>\n" +
        "  <path d=\"M4.285 12.433a.5.5 0 0 0 .683-.183A3.498 3.498 0 0 1 8 10.5c1.295 0 2.426.703 3.032 1.75a.5.5 0 0 0 .866-.5A4.498 4.498 0 0 0 8 9.5a4.5 4.5 0 0 0-3.898 2.25.5.5 0 0 0 .183.683zM7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z\"/>\n" +
        "</svg>"
    const newCon = document.createTextNode("You are very likely to be suffering with an anxiety disorder")
    newEmoji.appendChild(newCon);
    emoji.appendChild(newEmoji);

    const recommend = document.createElement("a");
    recommend.innerHTML = "<a href='http://localhost:8080/bookSession'> Click to book a session </a>"
    more.appendChild(recommend);
}