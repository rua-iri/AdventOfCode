with open("input.txt") as file:
    FILE_DATA: list = file.read().strip().split("\n")
SEARCH_HEIGHT: int = len(FILE_DATA)
SEARCH_WIDTH: int = len(FILE_DATA[0])
TARGET_WORD: str = "XMAS"


def generate_all_directions():
    all_directions = []

    for coord_x in range(-1, 2):
        for coord_y in range(-1, 2):
            if coord_x != 0 or coord_y != 0:
                all_directions.append((coord_x, coord_y))

    return all_directions


def check_letter_solutions(row_index, col_index, directions) -> int:
    direction_x, direction_y = directions

    for xmas_index, xmas_letter in enumerate("XMAS"):
        match_row_index = row_index + xmas_index * direction_x
        match_col_index = col_index + xmas_index * direction_y
        if not (
            0 <= match_row_index < SEARCH_HEIGHT and 0 <= match_col_index < SEARCH_WIDTH
        ):
            return 0
        if FILE_DATA[match_row_index][match_col_index] != xmas_letter:
            return 0

    return 1


def main():
    total_count: int = 0
    all_directions: list = generate_all_directions()

    for row_index in range(SEARCH_HEIGHT):
        for col_index in range(SEARCH_WIDTH):
            for direction in all_directions:
                total_count += check_letter_solutions(row_index, col_index, direction)

            print(total_count)


if __name__ == "__main__":
    main()
