def next_fit(data):
    elements = _dividing_to_max_element(data)
    containers = []
    active_container = []
    active_container_sum = 0
    for i in range(len(elements)):
        if active_container_sum + elements[i] <= 1:
            active_container.append(elements[i])
            active_container_sum += elements[i]
        else:
            containers.append(active_container)
            active_container = [elements[i]]
            active_container_sum = elements[i]
            if i == len(elements) - 1:
                containers.append(active_container)
    return containers


def first_fit(elements):
    return _fit_handler(elements, _find_first_fit_container)


def best_fit(elements):
    return _fit_handler(elements, _find_best_fit_container)


def _dividing_to_max_element(data):
    if len(data) == 0:
        return []
    max_element = max(data)
    max_element_list = []
    for i in range(len(data)):
        max_element_list.append(max_element)
    elements_map = map(lambda elem, max_elem: elem / max_elem, data, max_element_list)
    return list(elements_map)


def _find_first_fit_container(element, containers_sum, unfilled_containers):
    for i in unfilled_containers:
        if containers_sum[i] + element <= 1:
            return i
    return None


def _find_best_fit_container(element, containers_sum, unfilled_containers):
    index = None
    for i in unfilled_containers:
        if containers_sum[i] + element <= 1:
            if not index or containers_sum[i] > containers_sum[index]:
                index = i
    return index


def _fit_handler(data, find_fit_container):
    elements = _dividing_to_max_element(data)
    containers = []
    containers_sum = {}
    unfilled_containers = set()
    for element in elements:
        container_index = find_fit_container(element, containers_sum, unfilled_containers)
        if container_index is not None:
            containers[container_index].append(element)
            containers_sum[container_index] += element
        else:
            new_container = [element]
            containers_sum[len(containers)] = element
            container_index = len(containers)
            containers.append(new_container)
        if containers_sum[container_index] != 1:
            unfilled_containers.add(container_index)
        else:
            unfilled_containers.discard(container_index)
    return containers

if __name__ == '__main__':
    print(next_fit([1, 10, 2, 6, 8, 10, 1, 5]))
    print(first_fit([1, 10, 2, 6, 8, 10, 1, 5]))
    print(best_fit([1, 10, 2, 6, 8, 10, 1, 5]))