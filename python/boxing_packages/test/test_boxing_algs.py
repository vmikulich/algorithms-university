from unittest import TestCase
from src import boxing_algs


class TestBoxing(TestCase):
    def test_next_fit(self):
        test_data = [
            {
                'data': [1, 3, 4, 10, 7, 3, 2],
                'expected': [[0.1, 0.3, 0.4], [1], [0.7, 0.3], [0.2]]
            },
            {
                'data': [1, 1, 1, 1, 1],
                'expected': [[1], [1], [1], [1], [1]]
            },
            {
                'data': [],
                'expected': []
            }
        ]
        for test in test_data:
            self.assertSequenceEqual(test['expected'], boxing_algs.next_fit(test['data']))

    def test_first_fit(self):
        test_data = [
            {
                'data': [1, 10, 2, 6, 8, 10, 1, 5],
                'expected': [[0.1, 0.2, 0.6, 0.1], [1], [0.8], [1], [0.5]]
            },
            {
                'data': [10, 10, 10, 10, 10],
                'expected': [[1], [1], [1], [1], [1]]
            },
            {
                'data': [],
                'expected': []
            }
        ]
        for test in test_data:
            self.assertSequenceEqual(test['expected'], boxing_algs.first_fit(test['data']))

    def test_best_fit(self):
        test_data = [
            {
                'data': [5, 8, 10, 1, 6, 4],
                'expected': [[0.5], [0.8, 0.1], [1], [0.6, 0.4]]
            },
        ]
        for test in test_data:
            self.assertSequenceEqual(test['expected'], boxing_algs.best_fit(test['data']))
