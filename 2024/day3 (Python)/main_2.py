
import re


class PatternMatch:
    def __init__(self, pattern: str, input_data: str) -> None:
        self.pattern: str = pattern
        self.input_data: str = input_data
        self.start_loc = self.find_start()
        self.end_loc = self.find_end()

    def find_start(self):
        match = re.search(self.pattern, self.input_data)
        if match:
            return match.start()
        else:
            return -1

    def find_end(self):
        match = re.search(self.pattern, self.input_data)
        return match.end() if match else - 1

    def get_matching_text(self):
        match = re.search(self.pattern, self.input_data)
        return match.group()


def read_file_data() -> str:
    filename = "input.txt"
    with open(filename) as file:
        return file.read()


def find_instances(input_data: str) -> list:
    """
    1. while loop
        a. var is_active: boolean
        b. var match_list: list
        c. var match_loc: int
        d. var do_loc: int
        e. var dont_loc: int
    2. break if no *do()* *don't* or *mul()* are found in the string
    3. find index of *do()* *don't* or *mul()*
    4. if *do()* is first set is_active to True and string=substring
    5. if *don't()* is first set is_active to False and string=substring
    6. if *mul()* is first then add to matches list
    """
    is_active: bool = True
    match_list: list = []

    mul_pattern: str = r"mul\(\d{1,3},\d{1,3}\)"
    do_pattern: str = r"do\(\)"
    dont_pattern: str = r"don't\(\)"

    while True:
        mul_match = PatternMatch(mul_pattern, input_data)
        do_match = PatternMatch(do_pattern, input_data)
        dont_match = PatternMatch(dont_pattern, input_data)

        # print(match_list)
        print(is_active)

        if mul_match.start_loc == -1:
            break

        # TODO something is going wrong in this if condition
        # it cuts off with this "don't"
        # mul(742,92)<(]},select()[%^when()don't()

        if (do_match.start_loc < dont_match.start_loc
                and do_match.start_loc < mul_match.start_loc):
            is_active = True
            input_data = input_data[do_match.end_loc:]
            break

        elif (dont_match.start_loc < do_match.start_loc
              and dont_match.start_loc < mul_match.start_loc):
            is_active = False
            input_data = input_data[dont_match.end_loc:]
            continue

        elif (mul_match.start_loc < do_match.start_loc
                and mul_match.start_loc < dont_match.start_loc):
            if is_active:
                match_list.append(mul_match.get_matching_text())
            input_data = input_data[mul_match.end_loc:]

    return match_list


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
