
// The function below validates the form for the message length

function validateForm() {
    let message = document.getElementById('message').value;

    if (message.length <= 5 || message.length >= 41 ) {
        alert('Unsuitable message length, please see description!');
        return false;        // Stops the form being submitted if the message length is unsuitable
    } else {
        alert('Form submitted!');
        return true;      // Allows form to be submitted when message length meets criteria
    }
}

