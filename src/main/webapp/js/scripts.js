
function empty() {
    let userNameEl = document.getElementById("userName").value;
    let userPasswordEl = document.getElementById("userPassword").value;
    let userEmailEl = document.getElementById("userEmail").value;
    if (userNameEl == "" || userPasswordEl == "" || userEmailEl == "") {
        alert("Please fill all information");
        return false;
    };
}