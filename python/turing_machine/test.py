from unittest import TestCase
from turing_machine import TuringMachine


table = {
    0: {
        'a': (1, 'a', 0),
        'b': (1, 'b', 0),
        ' ': ('y', ' ', 0)
    },
    1: {
        'a': (1, 'b', 1),
        'b': (1, 'a', 1),
        ' ': ('y', ' ', 0)
    }
}

table1 = {
    0: {
        'a': (1, ' ', 1),
        'b': (5, ' ', 1),
        ' ': ('y', 'a', 0)
    },
    1: {
        'a': (1, 'a', 1),
        'b': (1, 'b', 1),
        ' ': (2, ' ', -1)
    },
    2: {
        'a': (3, ' ', -1),
        'b': (4, ' ', -1),
        ' ': ('y', 'a', 0)
    },
    3: {
        'a': (3, 'a', -1),
        'b': (3, 'b', -1),
        ' ': (0, ' ', 1)
    },
    4: {
        'a': (4, ' ', -1),
        'b': (4, ' ', -1),
        ' ': ('n', ' ', 0)
    },
    5: {
        'a': (5, 'a', 1),
        'b': (5, 'b', 1),
        ' ': (6, ' ', -1)
    },
    6: {
        'a': (4, ' ', -1),
        'b': (3, ' ', -1),
        ' ': ('y', 'a', 0)
    }
}
dictionary = ["a", "b"]
first = TuringMachine(dictionary, table, None, None)
first.start("aaab")


# class TestTuringMachine(TestCase):
#     def test_first_task(self):
#         table = {
#             0: {
#                 'a': (1, 'a', 0),
#                 'b': (1, 'b', 0),
#                 ' ': ('y', ' ', 0)
#             },
#             1: {
#                 'a': (1, 'b', 1),
#                 'b': (1, 'a', 1),
#                 ' ': ('y', ' ', 0)
#             }
#         }
#         dictionary = ["a", "b"]
#
#         first_task = TuringMachine(dictionary, table, None, " ")
#         self.assertEqual(first_task.start("aaaa"), "bbbb")
