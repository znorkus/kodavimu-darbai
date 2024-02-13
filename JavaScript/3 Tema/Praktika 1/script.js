const guessNumberGame = document.forms["form"];
const resultText = document.getElementById("resultText");
const resultCount = document.getElementById("resultCount");
let guess = 0;
let y = Math.floor(Math.random() * 100 + 1);

guessNumberGame.addEventListener("submit", function (e) {
  e.preventDefault();

  const guessedNumber = Number(guessNumberGame["input"].value);

  if (guessedNumber === y) {
    alert("Congratulations!!! You guessed it in " + guess + " Guess ");
    resultText.textContent = `Congratulations!!! The number is ${guessedNumber}.`;
  } else if (guessedNumber > y) {
    guess++;
    alert("Number is too big");
    resultText.textContent = `Number is too big`;
    resultCount.textContent = `You guessed ${guess} times`;
  } else {
    guess++;
    alert("Number is too small");
    resultText.textContent = `Number is too small`;
    resultCount.textContent = `You guessed ${guess} times`;
  }
});
