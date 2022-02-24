let wrapper = document.querySelector(".wrapper");
let box = document.querySelector('.box');
let data = [];
for (let i = 0; i < 5; i++) {
    data.push({
        src:""
    })
}

let pageSize = 1;
let allPage = Math.ceil(data.length / pageSize);

let obj = new TurnPage({
    currentPage: 1,
    allPage: allPage,
    wrap: wrapper,
    changePage: function (page) {
        console.log(page);
        let fillerData = data.filter(function (item, index){
            return index >= (page - 1) * pageSize && index < page * pageSize
        });
        renderDom(fillerData)
    }
});
obj.init();

function renderDom(data) {
    box.innerHTML = ''
    data.forEach(function (){
        let oDiv = document.createElement('iframe');
        oDiv.setAttribute("src","https://www.youtube.com/embed/_y97VF5UJcc");
        oDiv.setAttribute("style","height:600px; width:100%");
        oDiv.setAttribute("allowfullscreen","true");
        oDiv.innerHTML = '';
        box.appendChild(oDiv)
    })
}
renderDom(data.filter(function (item, index){
    return index < 1;
}))
