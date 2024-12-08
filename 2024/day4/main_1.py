
TARGET_WORD: str = "xmas"


def read_file_contents() -> list:
    with open("input.txt") as file:
        file_data = file.readlines()

    return file_data


def check_letter_solutions() -> int:
    pass


def main():
    file_data: list = read_file_contents()

    search_height: int = len(file_data)
    search_width: int = len(file_data[0])

    for y in range(search_height):
        for x in range(search_width):
            pass


if __name__ == "__main__":
    main()
