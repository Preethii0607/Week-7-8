import sys

class Question:
    def __init__(self, text, correct, student, points):
        self.text = text
        self.correct = correct
        self.student = student
        self.points = float(points)

    def grade(self):
        pass

class MCQ(Question):
    def grade(self):
        return self.points if self.student.strip() == self.correct.strip() else 0.0

class TF(Question):
    def grade(self):
        return self.points if self.student.strip().lower() == self.correct.strip().lower() else 0.0

class Essay(Question):
    def grade(self):
        keywords = [kw.strip().lower() for kw in self.correct.split(",")]
        student_text = self.student.lower()
        matched = sum(1 for kw in keywords if kw in student_text)
        if matched >= 2:
            return self.points * 0.75
        elif matched == 1:
            return self.points * 0.50
        return 0.0

def main():
    input_data = sys.stdin.read().strip().split('\n')
    if not input_data or input_data[0] == '':
        return
    n = int(input_data[0])
    total_score = 0.0

    import re
    for i in range(1, n + 1):
        if i >= len(input_data):
            break
        line = input_data[i]
        parts = re.findall(r'(""".*?"""|".*?"|\S+)', line)
        # Simplified token parser based on space/quotes separation
        tokens = []
        current = ""
        in_quotes = False
        for char in line:
            if char == '"':
                in_quotes = not in_quotes
            elif char.isspace() and not in_quotes:
                if current:
                    tokens.append(current.strip('"'))
                    current = ""
                continue
            current += char
        if current:
            tokens.append(current.strip('"'))

        q_type = tokens[0]
        q_text = tokens[1]
        correct = tokens[2]
        student = tokens[3]
        points = float(tokens[4])

        q = None
        if q_type == "MCQ":
            q = MCQ(q_text, correct, student, points)
            print("MCQ: ", end="")
        elif q_type == "TF":
            q = TF(q_text, correct, student, points)
            print("TF: ", end="")
        elif q_type == "ESSAY":
            q = Essay(q_text, correct, student, points)
            print("ESSAY: ", end="")

        score = q.grade()
        total_score += score
        print(f"{score:.2f}")

    print(f"Total Score: {total_score:.2f}")

if __name__ == "__main__":
    main()