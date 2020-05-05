def kmp(str, substr):
    pi = _create_pi_array(substr)
    i = 0
    j = 0
    while i < len(str):
        if str[i] == substr[j] and j == len(substr) - 1:
            return i - j
        elif str[i] == substr[j]:
            i += 1
            j += 1
        elif str[i] != substr[j] and j == 0:
            i += 1
        else:
            j = pi[j-1]
    return -1


def _create_pi_array(substr):
    pi = [0]
    i = 1
    j = 0
    while i < len(substr):
        if substr[i] == substr[j]:
            pi.append(j+1)
            i += 1
            j += 1
        elif substr[i] != substr[j] and j == 0:
            pi.append(j)
            i += 1
        else:
            j = pi[j-1]
    return pi
