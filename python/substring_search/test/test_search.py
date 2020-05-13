from kmp_search import kmp
from boyer_moore_search import boyer_moore
from robin_karp_search import robin_karp
from src import util
from unittest import TestCase


class TestSearch(TestCase):
    test_data = util.file_reader('data.txt')

    def test_kmp(self):
        self.assertEqual(46824, kmp(self.test_data, 'французы'))
        self.assertEqual(-1, kmp(self.test_data, 'парадигма'))
        self.assertEqual(286021, kmp(self.test_data, 'А табаку-то вчера дал? То-то, брат. Ну, на, Бог с '
                                                     'тобой'))
        self.assertEqual(-1, kmp(self.test_data, 'Википе́дия — общедоступная многоязычная универсальная '
                                                 'интернет-энциклопедия со свободным контентом, '
                                                 'реализованная на принципах вики.'))

    def test_boyer_moore(self):
        self.assertEqual(46824, boyer_moore(self.test_data, 'французы'))
        self.assertEqual(-1, boyer_moore(self.test_data, 'парадигма'))
        self.assertEqual(286021, boyer_moore(self.test_data, 'А табаку-то вчера дал? То-то, брат. Ну, на, Бог с '
                                                             'тобой'))
        self.assertEqual(-1, boyer_moore(self.test_data, 'Википе́дия — общедоступная многоязычная универсальная '
                                                         'интернет-энциклопедия со свободным контентом, '
                                                         'реализованная на принципах вики.'))

    def test_robin_karp(self):
        self.assertEqual(46824, robin_karp(self.test_data, 'французы', 256, 111))
        self.assertEqual(-1, robin_karp(self.test_data, 'парадигма', 256, 111))
        self.assertEqual(286021, robin_karp(self.test_data, 'А табаку-то вчера дал? То-то, брат. Ну, на, Бог с '
                                                            'тобой', 256, 111))
        self.assertEqual(-1, robin_karp(self.test_data, 'Википе́дия — общедоступная многоязычная универсальная '
                                                        'интернет-энциклопедия со свободным контентом, '
                                                        'реализованная на принципах вики.', 256, 111))
