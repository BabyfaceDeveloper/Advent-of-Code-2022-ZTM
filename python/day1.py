with open("./input-day1.txt", "r") as f:
    line = f.readline()
    max_calory, total_calories = -1, 0
    while line:
        if line.strip().isdigit():
            total_calories += int(line)
        else:
            if max_calory < total_calories:
                max_calory = total_calories
            total_calories = 0
        line = f.readline()
print(max_calory)
