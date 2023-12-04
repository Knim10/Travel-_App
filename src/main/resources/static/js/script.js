// src/main/resources/static/js/script.js

document.addEventListener("DOMContentLoaded", function() {
    console.log("Script loaded and DOM is ready");

    // Example of DOM interaction
    const welcomeMessage = document.querySelector(".card h2");

    if (welcomeMessage) {
        welcomeMessage.addEventListener("click", function() {
            alert("Hello! Thanks for using Your Travel App.");
        });
    }
});