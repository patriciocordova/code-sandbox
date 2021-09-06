def count_letters(word):
    count = dict()
    for letter in word:
        count[letter] = count.get(letter, 0) + 1
    return count

def find_word(scrambled, words):
    scrambled_letters = count_letters(scrambled)
    word_found = None
    for word in words:
        word_letters = count_letters(word)
        found = True
        for letter, count in word_letters.items():
            if letter not in scrambled_letters or scrambled_letters[letter] < count:
                found = False
                break
        if found:
            word_found = word
            break
    return word_found
    
words = ["cat", "baby", "dog", "bird", "car", "ax"]
string1 = "tcabnihjs"
string2 = "tbcanihjs"
string3 = "baykkjl"
string4 = "bbabylkkj"
string5 = "ccc"
string6 = "breadmaking"
print(find_word(string1, words))
print(find_word(string2, words))
print(find_word(string3, words))
print(find_word(string4, words))
print(find_word(string5, words))
print(find_word(string6, words))
