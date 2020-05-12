from src import kmp_search
from src import boyer_moore_search
from src import util
from unittest import TestCase


class TestSearch(TestCase):

    test_data = util.file_reader('data.txt')

    def test_kmp(self):
        self.assertEqual(46824, kmp_search.kmp(self.test_data, 'французы'))
        self.assertEqual(-1, kmp_search.kmp(self.test_data, 'парадигма'))
        self.assertEqual(286021, kmp_search.kmp(self.test_data, 'А табаку-то вчера дал? То-то, брат. Ну, на, Бог с '
                                                                'тобой'))
        self.assertEqual(-1, kmp_search.kmp(self.test_data, 'Википе́дия — общедоступная многоязычная универсальная '
                                                            'интернет-энциклопедия со свободным контентом, '
                                                            'реализованная на принципах вики.'))

    def test_boyer_moore(self):
        self.assertEqual(46824, kmp_search.kmp(self.test_data, 'французы'))
        self.assertEqual(-1, kmp_search.kmp(self.test_data, 'парадигма'))
        self.assertEqual(286021, kmp_search.kmp(self.test_data, 'А табаку-то вчера дал? То-то, брат. Ну, на, Бог с '
                                                                'тобой'))
        self.assertEqual(-1, kmp_search.kmp(self.test_data, 'Википе́дия — общедоступная многоязычная универсальная '
                                                            'интернет-энциклопедия со свободным контентом, '
                                                            'реализованная на принципах вики.'))
