




typedef int ElementType;

typedef unsigned int Index;

struct ListNode;

typedef struct ListNode *Position;

struct HashTbl;

typedef struct HashTable *HashTable;

Index Hash(const int key, int TableSize);

HashTable init(int TableSize);

void Insert(ElementType element, HashTable hashTable);

ElementType getElement(Index index, HashTable hashTable);


