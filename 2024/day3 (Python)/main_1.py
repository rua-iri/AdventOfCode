
import re


def read_file_data() -> str:
    filename = "input.txt"
    with open(filename) as file:
        return file.read()


def find_instances(input_data: str) -> list:
    pattern: str = r"mul\(\d{1,3},\d{1,3}\)"
    matches = re.findall(pattern, input_data)

    return matches


def process_match(match: str) -> int:
    print(match)
    sanitised_match: str = match.replace("mul(", "")
    sanitised_match = sanitised_match.replace(")", "")
    num_1, num_2 = sanitised_match.split(",")
    num_1, num_2 = int(num_1), int(num_2)
    return num_1 * num_2


def main():
    total_calc = 0
    input_data = read_file_data()

    matches = find_instances(input_data)

    for match in matches:
        total_calc += process_match(match)
        print(total_calc)


if __name__ == "__main__":
    main()
