n = 14
clg = rlh = 0
cld = rlb = n
iterations = 0
row = col = 0

directions = ['right','down','left','up']
direction = 'right'
with open("pos.txt","w") as fpos:
    for i in range(100):
        fpos.write(f'({row},{col})\n')
        rlb = n - 2*(iterations // 3)
        rlh = 2*(iterations // 3)
        cld = n - 2*(iterations // 3)
        clg =  2*(iterations // 3)

        if direction == 'right':
            if (col > cld - 1):
                iterations+=1
                direction = 'down'
                row += 1
            else: col += 1
        elif direction == 'down':
            if (row > rlb - 1):
                iterations+=1
                direction = 'left'
                col -= 1
            else: row += 1
        elif direction == 'left':
            if (col < clg + 1):
                iterations+=1
                direction = 'up'
                row -= 1
            else: col -= 1
        elif direction == 'up':
            if (row < rlh + 1):
                iterations+=1
                direction = 'right'
                col += 1
            else: row -= 1
