const makePictureSmaller = document.querySelector("#makeSmaller");
const makePictureBigger = document.querySelector("#makeBigger");

const image = document.querySelector("#picture");

makePictureBigger.addEventListener("click", function () {
  image.style.width = "50%";
});

makePictureSmaller.addEventListener("click", function () {
  image.style.width = "25%";
});
