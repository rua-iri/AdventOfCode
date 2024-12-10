with open("input.txt") as file:
    FILE_DATA: list = file.read().strip().split("\n")
SEARCH_HEIGHT: int = len(FILE_DATA)
SEARCH_WIDTH: int = len(FILE_DATA[0])
TARGET_WORD: str = "XMAS"


def check_letter_solutions(row_index, col_index) -> int:

    if not (
            1 <= row_index < SEARCH_HEIGHT - 1
            and 1 <= col_index < SEARCH_WIDTH - 1):
        return 0

    if FILE_DATA[row_index][col_index] != "A":
        return 0

    diagonal_1: str = (
        FILE_DATA[row_index-1][col_index-1] +
        FILE_DATA[row_index+1][col_index+1]
    )
    diagonal_2: str = (
        FILE_DATA[row_index-1][col_index+1] +
        FILE_DATA[row_index+1][col_index-1]
    )

    if diagonal_1 in ["MS", "SM"] and diagonal_2 in ["MS", "SM"]:
        return 1

    print(diagonal_1)
    print(diagonal_2)
    return 0

    # for xmas_index, xmas_letter in enumerate("XMAS"):
    #     match_row_index = row_index + xmas_index * direction_x
    #     match_col_index = col_index + xmas_index * direction_y
    #     if not (
    #         0 <= match_row_index < SEARCH_HEIGHT
    #         and 0 <= match_col_index < SEARCH_WIDTH
    #     ):
    #         return False
    #     if FILE_DATA[match_row_index][match_col_index] != xmas_letter:
    #         return False

    # return 1


def main():
    total_count: int = 0

    for row_index in range(SEARCH_HEIGHT):
        for col_index in range(SEARCH_WIDTH):
            total_count += check_letter_solutions(row_index, col_index)
            print(total_count)


if __name__ == "__main__":
    main()
