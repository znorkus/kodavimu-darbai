//1

function daysToHoursAndMinutes(days) {
  const hours = days * 24;
  const minutes = hours * 60;
  return `${days} Days is ${hours} Hours or ${minutes} Minutes`;
}
const days = 5;
const result = daysToHoursAndMinutes(days);
console.log(result);

//2

function mathCalculation(x) {
  const y = Math.pow(16 * x, 4) + 2 * x;
  console.log(y);
}
let x = 2;
mathCalculation(x);

//3

function oddOrEven(num) {
  if (num % 2 === 0) {
    return `Number ${num} is even`;
  } else {
    return `Number ${num} is odd`;
  }
}
console.log(oddOrEven(5));
