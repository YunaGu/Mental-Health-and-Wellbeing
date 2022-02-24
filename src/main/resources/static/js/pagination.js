//Encapsulate a page-turning constructor, store the data of the page-turning instance, and create a page-turning structure

/*
options：Data of the current page
currentPage：current page
allPage：all page
wrap：The position where the current page turning instance is inserted
changePage: Callback function for switching page numbers
 */

function TurnPage(options) {
    this.currentPage = options.currentPage || 1;
    this.allPage = options.allPage || 1;
    this.wrap = options.wrap || document.body;
    this.changePage = options.changePage || function () {};
    //return this
}
//initial method
TurnPage.prototype.init = function (){
    this.fillHTML();
    this.bindEvent();
}
//Fill the structure of the page turning
TurnPage.prototype.fillHTML = function () {
    this.wrap.innerHTML = '';
    let turnpageWrapper = document.createElement('ul');
    turnpageWrapper.className = 'turn-page-wrapper';
    //add the button of the first page
    if (this.currentPage > 1){
        //create structure of previous page
        let oLi = document.createElement('li');
        oLi.innerText = "Previous";
        oLi.className = "prev";
        turnpageWrapper.appendChild(oLi);
    }
    //add the button of the first page
    let oLi = document.createElement('li');
    oLi.innerText = 1;
    oLi.className = "num";
    //if current page is the first page, add the class name
    if (this.currentPage == 1){
        oLi.classList.add('current-page');
    }
    turnpageWrapper.appendChild(oLi);

    //insert "..."
    if (this.currentPage - 2 > 2){
        let oSpan = document.createElement('span');
        oSpan.innerText="...";
        turnpageWrapper.appendChild(oSpan);
    }

    //the 5 pages in the middle
    for (let i = this.currentPage - 2; i<= this.currentPage + 2; i++) {
        if (i > 1 && i < this.allPage){
            let oLi = document.createElement('li');
            oLi.innerText = i;
            oLi.className = "num";
            if (this.currentPage == i){
                oLi.classList.add('current-page');
            }
            turnpageWrapper.appendChild(oLi);
        }
    }

    //insert "..." in the end
    if (this.currentPage + 2 < this.allPage - 1){
        let oSpan = document.createElement('span');
        oSpan.innerText="...";
        turnpageWrapper.appendChild(oSpan);
    }

    //add the last page
    if (this.allPage != 1){
        let lastLi = document.createElement('li');
        lastLi.innerText = this.allPage;
        lastLi.className = "num";
        //last add class
        if (this.currentPage == this.allPage){
            lastLi.classList.add('current-page');
        }
        turnpageWrapper.appendChild(lastLi);
    }


    //add "next" button
    if (this.currentPage < this.allPage) {
        let oLi = document.createElement('li');
        oLi.innerText = "next";
        oLi.className = "next";
        turnpageWrapper.appendChild(oLi);
    }

    //insert the whole component into the page
    this.wrap.appendChild(turnpageWrapper)
}

//bind event
TurnPage.prototype.bindEvent = function () {
    let self = this;
    //给当前翻页区域绑定事件
    this.wrap.onclick = function (e){
        //e.target
        if(e.target.classList.contains('prev')){
            self.currentPage --;
            self.fillHTML()
            self.changePage(self.currentPage)
        } else if (e.target.classList.contains('next')){
            self.currentPage ++;
            self.fillHTML()
            self.changePage(self.currentPage)
        } else if (e.target.classList.contains('num')){
            let page = parseInt(e.target.innerText);
            self.currentPage = page;
            self.fillHTML()
            self.changePage(self.currentPage)
        }
    }
}
