def get_priority(item: str) -> int:
    # 96 for lower case ascii, 38 = 26 - 64 (upper case)
    return ord(item[0]) - (96 if item[0].islower() else 38)


with open("../inputs/day3.txt") as f:
    sacks = f.readlines()

sum_priorities = 0

for sack in sacks:
    first_compartments = set(sack[: len(sack) // 2])
    second_compartments = set(sack[len(sack) // 2 :])
    sum_priorities += get_priority(
        first_compartments.intersection(second_compartments).pop()
    )

print(sum_priorities)
