from util import file_reader


def robin_karp(str, substr, d, q):
    n = len(str)
    m = len(substr)
    h = pow(d, m - 1) % q
    substr_hash = 0
    str_hash = 0
    for s in range(m):
        substr_hash = (d * substr_hash + ord(substr[s])) % q
        str_hash = (d * str_hash + ord(str[s])) % q
    for i in range(n - m + 1):
        if substr_hash == str_hash:
            match = True
            for j in range(m):
                if substr[j] != str[i + j]:
                    match = False
                    break
            if match:
                return i
        if i < n - m:
            str_hash = (d * (str_hash - ord(str[i]) * h) + ord(str[i + m])) % q
            if str_hash < 0:
                str_hash = str_hash + q
    return -1


if __name__ == '__main__':
    content = file_reader("data.txt")
    print(robin_karp(content, 'А табаку-то вчера дал? То-то, брат. Ну, на, Бог с тобой', 256, 101))
