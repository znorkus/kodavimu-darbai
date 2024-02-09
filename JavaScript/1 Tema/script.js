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
