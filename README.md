Project Overview:

In the ICS-202 Lab Project, our team designed and implemented a Dictionary data structure based on the AVL Tree data structure. We chose AVL trees due to their balanced binary search tree properties, ensuring O(logn) worst-case time complexity for search, insertion, and deletion operations. AVL trees are particularly suitable for scenarios where there are frequent lookups for data required, such as in-memory sorts of sets and dictionaries, as well as in database applications.

Project Components:

Dictionary Data Structure Class:

We extended the AVL Tree class to create a new class for the Dictionary data structure.
The Dictionary class provides constructors for initializing the dictionary from a string, an empty AVL tree, or a file containing words.
It implements methods for adding, finding, and deleting words, as well as finding similar words and saving the dictionary to a file.

Exceptions:

We created custom exceptions, WordAlreadyExistsException and WordNotFoundException, to handle cases where a word is already present in the dictionary or not found during operations.

Driver Class:

The Driver class serves as the main entry point to test the functionality of our dictionary.
It prompts users for operations such as checking, adding, and removing words, finding similar words, and saving the updated dictionary to a file.

Methods Implemented:

addWord(String s):

Adds a new word to the dictionary if it does not already exist.

findWord(String s):

Finds and indicates whether a word exists in the dictionary.

deleteWord(String s):

Deletes a word from the dictionary if it exists.

findSimilar(String s):

Finds words similar to the input word by adding, removing, or replacing one character and returns an array of similar words.

saveDictionary(String fileName):

Saves the updated dictionary to a file specified by the user.

Output:

The output of the Driver (main) class demonstrates the functionality of the dictionary, including word checking, addition, removal, finding similar words, and saving the dictionary.
