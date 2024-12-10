

def read_file() -> list:
    with open("input.txt") as file:
        file_data = file.read().strip().split("\n\n")

    return file_data


def gen_allowed_dict(rules_list: list):
    allowed_dict = {}

    for rule in rules_list:
        num1, num2 = rule.split("|")

        if not allowed_dict.get(num2):
            allowed_dict[num2] = [num1]
        else:
            allowed_dict[num2].append(num1)

    return allowed_dict


def calc_score(instruction: str, allowed_dict: dict):
    disallowed_nums: set = set()

    instruction_list = instruction.split(',')

    print(instruction)

    for num in instruction_list:
        if num in disallowed_nums:
            return 0

        print(allowed_dict.get(num))
        disallowed_nums.update(allowed_dict.get(num))

    return int(instruction_list[len(instruction_list)//2])


def main():
    rules, instructions = read_file()
    score = 0

    allowed_dict: dict = gen_allowed_dict(rules.split("\n"))

    for instruction in instructions.split("\n"):
        score += calc_score(instruction, allowed_dict)

    print(score)


if __name__ == "__main__":
    main()
