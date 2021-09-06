def neighbors(pos, grid):
    deltas = [ (0, 1), (1, 0) ]
    res = []
    for delta in deltas:
        new_pos = (pos[0] + delta[0], pos[1] + delta[1])
        print(new_pos)
        if new_pos[0] < 0 or new_pos[0] >= len(grid) or new_pos[1] < 0 or new_pos[1] >= len(grid[0]):
            continue
        res.append(new_pos)
    return res

# naive
def word_search_findone_helper(grid, word, start_pos):
    # assume grid[start_pos] matches word[0]
    if len(word) == 1:
        return [ start_pos ]
        
    r = neighbors(start_pos, grid)
    print(">", start_pos)
    print(">>", r)
    for next_pos in neighbors(start_pos, grid):
        new_word = word[1:]
        print(new_word)
        if grid[next_pos[0]][next_pos[1]] != new_word[0]:
            continue
        path = word_search_findone_helper(grid, new_word, next_pos)
        if path is not None:
            return [ start_pos ] + path
                
    return None
    
def word_search_findone(grid, word):
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == word[0]:
                print("x",i,j)
                res = word_search_findone_helper(grid, word, (i, j))
                if res is not None:
                    return res
                    
    return None

grid1 = [
    ['c', 'c', 'x', 't', 'i', 'b'],
    ['c', 'c', 'a', 't', 'n', 'i'],
    ['a', 'c', 'n', 'n', 't', 't'],
    ['t', 'c', 's', 'i', 'p', 't'],
    ['a', 'o', 'o', 'o', 'a', 'a'],
    ['o', 'a', 'a', 'a', 'o', 'o'],
    ['k', 'a', 'i', 'c', 'k', 'i'],
]
word1 = "catnip"
word2 = "cccc"
word3 = "s"
word4 = "bit"
word5 = "aoi"
word6 = "ki"
word7 = "aaa"
word8 = "ooo"

word_search_findone(grid1,word1)
