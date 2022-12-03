def calculate_my_score(oponent_choice: int, my_choice: int) -> int:
    win_bonus = 6
    draw_bonus = 3
    diff = my_choice - oponent_choice
    # win case
    if diff == 1 or diff == -2:
        return my_choice + win_bonus
    # draw case
    if diff == 0:
        return my_choice + draw_bonus
    # lose case
    return my_choice


with open("../inputs/day2.txt") as f:
    rounds = f.readlines()

# Part 1
def decode_part_1(choices: list) -> tuple:
    # Rock = A or X <=> 1
    # Paper = B or Y <=> 2
    # Scissors = C or Z <=> 2
    return (ord(choices[0]) - 64, ord(choices[1]) - 87)


rounds_part_1 = [decode_part_1(round.split()) for round in rounds]

print(
    sum(
        calculate_my_score(oponent_choice, my_choice)
        for (oponent_choice, my_choice) in rounds_part_1
    )
)

# Part 2
def decode_part_2(choices: list) -> tuple:
    oponent_choice, my_choice = decode_part_1(choices)
    # X = 1, Y = 2, Z = 3
    # X means lose, Y means draw and Z means win
    match my_choice:
        case 1:
            my_choice = oponent_choice - 1 if oponent_choice > 1 else 3
        case 2:
            my_choice = oponent_choice
        case 3:
            my_choice = oponent_choice + 1 if oponent_choice < 3 else 1

    return (oponent_choice, my_choice)


rounds_part_2 = [decode_part_2(round.split()) for round in rounds]

print(
    sum(
        calculate_my_score(oponent_choice, my_choice)
        for (oponent_choice, my_choice) in rounds_part_2
    )
)
