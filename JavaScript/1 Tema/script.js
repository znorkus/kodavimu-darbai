//1

function daysToHoursAndMinutes(days) {
  let hours = days * 24;
  let minutes = hours * 60;
  return `${days} Days is ${hours} Hours or ${minutes} Minutes`;
}
let days = 5;
let result = daysToHoursAndMinutes(days);
console.log(result);

//2
