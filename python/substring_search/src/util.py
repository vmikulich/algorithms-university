import codecs


def file_reader(file_name):
    f = codecs.open("../data/" + file_name, 'r', 'utf8')
    file_content = f.read()
    return file_content
