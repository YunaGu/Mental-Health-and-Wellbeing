// function to validate the DeleteForm located in DeletePractitioner.html
function formValidation(myForm,inputName) {
    //fetch ID field from the form
    let temp = document.forms[myForm][inputName].value;
    if (temp == "") {
        alert("Practitioner ID field must be filled");
        return false;
    }
    // check the length of input texts. it must be less than 10 characters
    if(inputSizeIsGreat(temp,10)){
        alert("Please enter less than 10 characters.");
        return false;
    }
}
//-----------------------------------------------------------------
//function to validate the AddForm located in AddPractitioner.html
function addFormValidation(){
    //fetch all the inputs from the form
    let firstName = document.forms["AddForm"]["firstName"].value;
    let lastName = document.forms["AddForm"]["lastName"].value;
    let email = document.forms["AddForm"]["email"].value;
    let status = document.forms["AddForm"]["status"].value;

    if (firstName == "" || lastName == "" || email == "" || status == "" ) {
        alert("Fields with * must be filled");
        return false;
    }

    if (!(status == "True" || status == "False")) {
        alert("Enter True or False for the field status. ");
        return false;
    }

    // check the length of input texts
    if(inputSizeIsGreat(firstName,30)){
        alert("Please enter less than 30 characters for Name.");
        return false;
    }
    if(inputSizeIsGreat(lastName,30)){
        alert("Please enter less than 30 characters for Surname.");
        return false;
    }
    if(inputSizeIsGreat(email,40)){
        alert("Please enter less than 40 characters for email.");
        return false;
    }
}
//-------------------------------------------------------------------
//function to validate the bookSession form that is located in bookSession.html
function bookSessionFormValidation() {
    //fetch all the inputs from the form
    let email = document.forms["sendEmailForm"]["email"].value;
    let date = document.forms["sendEmailForm"]["date"].value;
    let time = document.forms["sendEmailForm"]["time"].value;


    if (email == "" || date == "" || time == "") {
        alert("Fields with * sign must be filled.");
        return false;
    }

    // check the length of input texts
    if(inputSizeIsGreat(email,30)){
        alert("Please enter less than 30 characters for email.");
        return false;
    }
    if(inputSizeIsGreat(date,20)){
        alert("Please enter less than 20 characters for date.");
        return false;
    }
    if(inputSizeIsGreat(time,30)){
        alert("Please enter less than 30 characters for hour.");
        return false;
    }

}
//---------------------------------------------------------------------
//function to check the size of input characters
function inputSizeIsGreat(inputText,x) {
    if (inputText.length > x) {
        return true;
    }
}
//----------------------------------------------------------------
/*
function to show a hidden form(SendSroty) that is located in SendForm.html
 when the checkbox(myCheckbox) is checked
*/
function showSendStroryForm() {
    // Get the checkbox
    let checkBox = document.getElementById("myCheckbox");
    // Get the output form
    let form = document.getElementById("SendSroty");

    // If the checkbox is checked, display the output form
    if (checkBox.checked == true){
        form.style.display = "block";
    } else {
        form.style.display = "none";
    }
}
//------------------------------------------------------------------
//function to validate the SendStory form that is located in SendStory.html
//-------------------------------------------------------------------
function sendStoryFormValidation() {
    //fetch all the inputs from the form
    let email = document.forms["SendSroty"]["email"].value;
    let date = document.forms["SendSroty"]["birth"].value;
    let link = document.forms["SendSroty"]["link"].value;
    let name = document.forms["SendSroty"]["name"].value;

    //don not enter null for required fields
    if (email == "" || date == "" || link == "" || name == "") {
        alert("Fields with * sign must be filled.");
        return false;
    }
    // check the length of input texts and create alarm if the size of input is large
    if (inputSizeIsGreat(email, 30)) {
        alert("Please enter less than 30 characters for email.");
        return false;
    }
    if (inputSizeIsGreat(name, 30)) {
        alert("Please enter less than 30 characters for name.");
        return false;
    }
    if (inputSizeIsGreat(date, 30)) {
        alert("Please enter less than 30 characters for date.");
        return false;
    }
    if (inputSizeIsGreat(link, 100)) {
        alert("Please enter less than 100 characters for link.");
        return false;
    }
}
//--------------------------------------------------------------------------------
//function to change the source of an iframe located in session.html file.
// The new src is located in a input text called iframeNewLink.
//----------------------------------------------------------------------------
function changeIframeSource(iframe,iForm){
    //check the the validity of the form before change
    iframeFormValidation(iForm);
    let link = document.forms[iForm]["newLink"].value;
    document.getElementById(iframe).src = link;
}
//--------------------------------------------------------------------------------
//function to toggle the situation of a form(show/hide)
//----------------------------------------------------------------------------
function showIframeEditForm(iForm) {
    let X = document.getElementById(iForm);
    if (X.style.display == "none") {
        X.style.display = "block";
    } else {
        X.style.display = "none";
    }
}
//------------------------------------------------------------------
// function to validate the iframe edit form located in session.html
//-------------------------------------------------------------------
function iframeFormValidation(iForm) {
    //fetch newLink field from the form
    let temp = document.forms[iForm]["newLink"].value;
    if (temp == "") {
        alert("link must be filled before submit.");
        return false;
    }
    // check the length of input texts. it must be less than 100 characters
    if(inputSizeIsGreat(temp,100)){
        alert("Please enter less than 100 characters.");
        return false;
    }
}



