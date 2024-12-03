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

    let pair_diff = 0;

    // add absolute difference from each pair
    for (let i = 0; i < list_one.length; i++) {
      pair_diff += Math.abs(list_one[i] - list_two[i]);
    }

    console.log(pair_diff);
  });
}

main();
