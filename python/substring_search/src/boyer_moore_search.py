from util import file_reader

def boyer_moore(str, substr):
    mismatch_shifts_table = _mismatch_shifts(substr)
    str_length = len(str)
    substr_length = len(substr)
    i = 0
    while i <= str_length - substr_length:
        number_of_skips = 0
        for j in reversed(range(substr_length)):
            if not substr[j] == str[i+j]:
                if j < substr_length - 1:
                    number_of_skips = mismatch_shifts_table[substr[substr_length - 1]]
                elif mismatch_shifts_table.get(str[i+j]) is not None:
                    number_of_skips = mismatch_shifts_table[str[i+j]]
                    break
                else:
                    number_of_skips = substr_length
                    break
        if number_of_skips == 0:
            return i
        i += number_of_skips
    return -1


def _mismatch_shifts(substr):
    mismatch_shifts_table = {}
    for i in range(len(substr)):
        if i == len(substr) - 1:
            if mismatch_shifts_table.get(substr[i]) is None:
                shift = len(substr)
            else:
                break
        else:
            shift = len(substr) - i - 1
        mismatch_shifts_table[substr[i]] = shift
    return mismatch_shifts_table


if __name__ == '__main__':
    content = file_reader("data.txt")
    print(boyer_moore(content, 'А табаку-то вчера дал? То-то, брат. Ну, на, Бог с тобой'))
