from src import kmp_search
from unittest import TestCase


class TestKmpSearch(TestCase):
    def test_kmp(self):
        self.assertEqual(3, kmp_search.kmp('suctestcess', 'test'))
        self.assertEqual(-1, kmp_search.kmp('suctestcess', 'testo'))
        self.assertEqual(2, kmp_search.kmp('lkuutkdsk', 'uut'))
        self.assertEqual(-1, kmp_search.kmp('abababaab', 'uut'))
