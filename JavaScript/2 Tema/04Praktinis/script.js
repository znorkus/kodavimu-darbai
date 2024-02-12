// const newH3 = document.createElement("h3");
// newH3.textContent = "h3 element";
// const h2 = document.querySelector("h2");
// const parent = document.querySelector("header");
// parent.insertBefore(newH3, h2);

const btn = document.getElementById("okButton");
const someHeader = document.getElementById("appearHeader");

btn.addEventListener("click", function () {
  appearHeader.textContent = "Pastraipos pavadinimas";
});
