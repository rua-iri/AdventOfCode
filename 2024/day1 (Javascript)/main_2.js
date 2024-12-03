const fs = require("node:fs");

function main() {
  fs.readFile("input.txt", "utf-8", (err, data) => {
    if (err) {
      console.error(err);
      return;
    }

    const list_one = [];
    const list_two = [];
    for (let line of data.split("\n")) {
      const items = line.split("   ");

      list_one.push(Number(items[0]));
      list_two.push(Number(items[1]));
    }

    list_one.sort();
    list_two.sort();

    console.log(list_one);
    console.log(list_two);

    let similarityScore = 0;

    // 1. iterate over each number in the first list
    // 2. count number of instances of number in second list
    // 3. multiply the count by the original number and add to total

    // add absolute difference from each pair
    for (let i = 0; i < list_one.length; i++) {
      const item = list_one[i];
      const itemCount = list_two.filter((x) => x === item).length;
      similarityScore += item * itemCount;
      console.log(similarityScore);
    }
  });
}

main();
