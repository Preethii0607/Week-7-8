class LibraryItem:
    def __init__(self, title):
        self.title = title

    def get_due_date(self, current_date):
        pass

class Book(LibraryItem):
    def get_due_date(self, current_date):
        return current_date + timedelta(days=14)

class DVD(LibraryItem):
    def get_due_date(self, current_date):
        return current_date + timedelta(days=7)

class Magazine(LibraryItem):
    def get_due_date(self, current_date):
        return current_date + timedelta(days=3)

def main():
    import sys
    input_data = sys.stdin.read().splitlines()
    if not input_data:
        return
    n = int(input_data[0])
    current_date = datetime.strptime("2023-10-26", "%Y-%m-%d")

    for i in range(1, n + 1):
        if i >= len(input_data):
            break
        parts = input_data[i].split(" ", 1)
        item_type = parts[0]
        title = parts[1].strip('"')

        item = None
        if item_type == "BOOK":
            item = Book(title)
        elif item_type == "DVD":
            item = DVD(title)
        elif item_type == "MAGAZINE":
            item = Magazine(title)

        if item:
            due_date = item.get_due_date(current_date)
            print(f"{item.title}: {due_date.strftime('%Y-%m-%d')}")

if __name__ == "__main__":
    main()