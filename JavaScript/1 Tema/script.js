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
//arba
// const x = 5;
// const result = mathCalculation(x)

//3

function oddOrEven(num) {
  if (num % 2 === 0) {
    return `Number ${num} is even`;
  } else {
    return `Number ${num} is odd`;
  }
}
console.log(oddOrEven(5));

//4

function whichNumberIsBigger(num1, num2) {
  if (num1 > num2 && num1 != num2) {
    return num1;
  } else {
    return num2;
  }
}
console.log(whichNumberIsBigger(5, 8));

//5

function gradeCounter(points) {
  if (points <= 29) {
    console.log("Failed");
  } else if (points > 29 && points <= 34) {
    console.log("Your Grade is 1");
  } else if (points > 34 && points <= 39) {
    console.log("Your Grade is 2");
  } else if (points > 39 && points <= 44) {
    console.log("Your Grade is 3");
  } else if (points > 44 && points <= 49) {
    console.log("Your Grade is 4");
  } else {
    console.log("Your Grade is 5");
  }
}
