 // REFERENCE: https://developer.mozilla.org/en-US/docs/Learn/Forms/Form_validation
    //     Web Applications - 3B Web Functionality: DOM

    //function for validating first name using custom validity messages when user attempts to submit
    function validate_fname() {
    //declaring variables of inputs by using their names
    const fName = document.getElementById('first_name');

    const validityState = fName.validity;

    if (fName.validity !== undefined) {
    //checking name is valid (>= 2 characters for a name)
    if (validityState.tooShort) {
    fName.setCustomValidity('Please enter a valid name longer than 2 characters.');
    //checking pattern mismatch error (using alphabet only)
} else if (validityState.patternMismatch) {
    fName.setCustomValidity('Please only enter alphabetical characters.');
} else {
    //if the input is valid -  set validity to empty string i.e it is valid
    fName.setCustomValidity('');
}
    //returns true if input is valid
    fName.reportValidity();
}
}
    //similar to function for first name
    function validate_lname() {
    const lName = document.getElementById('last_name');
    const validityState = lName.validity

    if (lName.validity !== undefined) {
    if (validityState.tooShort) {
    lName.setCustomValidity('Please enter a valid name longer than 2 characters.');
    //checking pattern mismatch error (using alphabet only)
} else if (validityState.patternMismatch) {
    lName.setCustomValidity('Please only enter alphabetical characters.');
} else {
    //if the input is valid -  set validity to empty string i.e it is valid
    lName.setCustomValidity('');
}
    lName.reportValidity();
}
}
    //displays custom message if email is too short
    function validate_email() {
    const rEmail = document.getElementById('recipient_email');
    const validityState = rEmail.validity

    if (rEmail.validity !== undefined) {
    if (validityState.tooShort) {
    rEmail.setCustomValidity('Please enter a valid email containing [@] with at least 6 characters.')
}
}
    rEmail.reportValidity();
}

    //displays custom message if user hasn't checked the box
    function validate_checkbox() {
    const signupCheckbox = document.getElementById('newsletter-checkbox')

    if (signupCheckbox.checked !== true) {
    signupCheckbox.setCustomValidity('Please agree to our terms in order to proceed.')
}

    signupCheckbox.reportValidity();
}