def is_full_contain(s1: int, e1: int, s2: int, e2: int) -> bool:
    return (s1 <= s2 and e2 <= e1) or (s2 <= s1 and e1 <= e2)


def is_not_overlap(s1: int, e1: int, s2: int, e2: int) -> bool:
    return e1 < s2 or e2 < s1


with open("../inputs/day4.txt") as f:
    inputs = f.readlines()

# Part 1
count_full_contains = 0
# Part 2
count_not_overlap = 0

for input in inputs:
    [s1, e1], [s2, e2] = map(lambda i: map(int, i.split("-")), input.strip().split(","))
    # Part 1
    if is_full_contain(s1, e1, s2, e2):
        count_full_contains += 1
    # Part 2
    if is_not_overlap(s1, e1, s2, e2):
        count_not_overlap += 1

# Part 1
print(count_full_contains)
# Part 2
print(len(inputs) - count_not_overlap)
