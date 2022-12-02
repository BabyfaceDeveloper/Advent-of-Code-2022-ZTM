calories = []
with open("../inputs/day1.txt", "r") as f:
    line, total_calories = f.readline(), 0
    while line:
        temp_l = line.strip()
        if temp_l.isdigit():
            total_calories += int(temp_l)
        else:
            calories.append(total_calories)
            total_calories = 0
        line = f.readline()

calories.sort()
# part 1
print(calories[-1])
# part 2
print(sum(calories[-3:]))
