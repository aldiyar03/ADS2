 My Custom Data Structures
This project is a custom implementation of basic data structures in Java without using java.util.* classes (except Iterator).

The following structures were implemented:

📂 Physical Data Structures
MyArrayList<T> — dynamic array-based list.

MyLinkedList<T> — doubly linked list.

Both structures implement a custom interface MyList<T> that defines basic operations like add, remove, sort, indexOf, etc.

📂 Logical Data Structures
MyStack<T> — based on MyArrayList.

MyQueue<T> — based on MyLinkedList.

MyMinHeap<T> — based on MyArrayList.

🛠 Technologies
Java 17

No external libraries (except Iterator)

🧠 How It Works
Data Structure	Based On	Why
MyStack	MyArrayList	Fast access and modification at the end
MyQueue	MyLinkedList	Easy add to end and remove from start
MyMinHeap	MyArrayList	Binary heap fits perfectly into arrays
🚀 How to Run
Clone this repository

Open the project in your IDE

Run the Main.java to see how each structure works

Example:

bash
Копировать
Редактировать
git clone https://github.com/your-username/your-repository.git
cd your-repository
# Open in IDE and run Main.java
✅ Tasks Done
Implemented MyArrayList with dynamic resizing

Implemented MyLinkedList with bidirectional nodes

Created MyStack, MyQueue, and MyMinHeap

Tested all structures manually

Added GitHub commits

Documented the project

✍️ Author
Amangaliyev Aldiyar SE - 2403

