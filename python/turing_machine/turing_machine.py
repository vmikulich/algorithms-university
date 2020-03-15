class TuringMachine:
    def __init__(self, dictionary, table, head_tape, tail_tape):
        self.dictionary = [" "] + dictionary
        self.table = table
        self.tape = []
        self.head_tape = head_tape or []
        self.tail_tape = tail_tape or [" "] * 5

    @staticmethod
    def display(tape):
        print(''.join(tape))

    def run(self, state, position):
        self.display(self.tape)
        if state in ('y', 'n'):
            return
        next_state, symbol, move_number = self.table[state][self.tape[position]]
        self.tape[position] = symbol
        position += move_number
        self.run(next_state, position)

    def start(self, word):
        start_position = 0
        current_state = 0
        self.tape = self.head_tape + [c for c in word if c in self.dictionary] + self.tail_tape
        self.run(current_state, start_position)
        self.display(self.tape)
        return ''.join(self.tape)
