
import re


def read_file_data() -> str:
    filename = "input.txt"
    with open(filename) as file:
        return file.read()


def find_instances(input_data: str) -> list:
    pattern: str = r"(?:mul\(\d{1,3},\d{1,3}\)|do\(\))|don't\(\)"
    pattern: str = r"(?:mul\((\d+),(\d+)\)|do\(\))|don't\(\)"
    pattern: str = r"(?:mul\((\d+),(\d+)\))|(do\(\)|don't\(\))"

    match_list = re.findall(pattern, input_data)

    return match_list


def process_match(match: tuple) -> int:
    return int(match[0]) * int(match[1])


def main():
    is_active: bool = True
    total_calc: int = 0
    input_data: str = read_file_data()

    matches: list = find_instances(input_data)

    # print(matches)

    for match in matches:
        if match[2] == "" and is_active:
            total_calc += process_match(match)
            print(total_calc)
        else:
            if match[2] == "do()":
                is_active = True
            else:
                is_active = False


if __name__ == "__main__":
    main()
