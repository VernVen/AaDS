//на python
import sys

def main():
data = {}

        for line in sys.stdin:
line = line.strip()
        if not line:
        continue
parts = line.split()
        if len(parts) != 3:
        continue
buyer, product, count_str = parts
        try:
count = int(count_str)
except ValueError:
        continue

        if buyer not in data:
data[buyer] = {}
        if product not in data[buyer]:
data[buyer][product] = 0
data[buyer][product] += count

    for buyer in sorted(data.keys()):
print(f"{buyer}:")
        for product in sorted(data[buyer].keys()):
print(product, data[buyer][product])

if __name__ == '__main__':
main()