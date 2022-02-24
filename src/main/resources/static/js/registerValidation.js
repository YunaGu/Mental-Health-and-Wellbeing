//declaring variables
const signupForm = document.getElementById('RegisterForm');
const username = document.getElementById('username');
const password = document.getElementById('password');
const confirmpass = document.getElementById('confirm-password');
const username_msg = document.getElementById('username-message');
const confirm_msg = document.getElementById('confirm-message');
const password_msg = document.getElementById('password-regex-message');
//pattern for a valid password - >8 characters, 1 uppercase, 1 lowercase
const password_regex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
//patter for a valid username - any english character, any number and be between 4-20 characters
const username_regex = /^(?=.{4,20}$)[a-zA-Z0-9]+$/;


//event listener that prevents user submitting form if form is invalid
signupForm.addEventListener('submit', function validateRegistration(e) {
    checkUsername(e);
    checkPassword(e);
    checkConfirmedPassword(e);
});
//function that checks username is valid
//uses conditional if statements that display an error message on invalid input
let checkUsername = function (e) {
    //if username is not empty - check validity using custom regex (only containing numbers & letters & between 4-20 characters) else show error & prevent submit
    if (username.value !== "") {
        if (!username_regex.test(username.value)) {
            username_msg.style.color = '#FF0000';
            username_msg.innerHTML = 'Username Must Contain:' + "<br>" + 'Only letters & numbers' +"<br>" + 'Between 4 and 20 characters';
            e.preventDefault();
        } else {
            username_msg.innerHTML = '';
        }
    } else {
        username_msg.style.color = '#FF0000';
        username_msg.innerHTML = 'Username Field Cannot Be Empty';
        e.preventDefault();
    }
}

// function that checks password matches confirmed password
// displays red error message for non-matching passwords & green success message if they match
let checkConfirmedPassword = function (e) {
    if (password.value !== confirmpass.value) {
        confirm_msg.style.color = '#FF0000';
        confirm_msg.innerHTML = 'Passwords Do Not Match';
        e.preventDefault();
    } else {
        confirm_msg.innerHTML = '';
    }

}
//function that checks password is in correct format
let checkPassword = function (e) {
    if (password.value !== '') {
        if (!password_regex.test(password.value)) {
            password_msg.style.color = '#FF0000';
            password_msg.innerHTML = 'Password Must Contain:' + " <br>" + 'At Least 1 Number' + "<br>" + 'At Least 1 Uppercase' + "<br>" + 'At Least 8 Characters';
            e.preventDefault();
        } else {
            password_msg.innerHTML = '';
            alert("Successfully registered. \n Thank you for signing up to TidyButt's website.")
        }
    } else {
        password_msg.style.color = '#FF0000';
        password_msg.innerHTML = 'Password Cannot Be Empty';
        e.preventDefault();
    }
}