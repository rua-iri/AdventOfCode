
with open("input.txt") as file:
    FILE_DATA: list = file.readlines()
SEARCH_HEIGHT: int = len(FILE_DATA)
SEARCH_WIDTH: int = len(FILE_DATA[0])
TARGET_WORD: str = "XMAS"


def generate_all_directions():
    all_directions = []

    for coord_x in range(-1, 2):
        for coord_y in range(-1, 2):
            if coord_x != 0 and coord_y != 0:
                all_directions.append((coord_x, coord_y))

    return all_directions


def check_letter_solutions(row_index, col_index, directions) -> int:
    direction_x, direction_y = directions

    dx, dy = directions
    for k, x in enumerate("XMAS"):
        ii = row_index + k * dx
        jj = col_index + k * dy
        if not (0 <= ii < SEARCH_HEIGHT and 0 <= jj < SEARCH_WIDTH):
            return False
        if FILE_DATA[ii][jj] != x:
            return False
    return True


def main():

    total_count: int = 0
    all_directions: list = generate_all_directions()

    for row_index in range(SEARCH_HEIGHT):
        for col_index in range(SEARCH_WIDTH):
            for direction in all_directions:
                total_count += check_letter_solutions(
                    row_index, col_index, direction)

            print(total_count)


if __name__ == "__main__":
    main()
