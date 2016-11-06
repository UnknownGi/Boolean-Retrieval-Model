# Boolean Retrieval Model

### Information Retrieval and Text Mining

Boolean Retrieval Model belongs to the field of IR, which uses simple techniques of fetching documents from a collection relevant to the user. Our goal is to fetch as relevant document as possible from our collection.

Information retrieval (IR) is the activity of obtaining information resources relevant to an information need from a collection of information resources. Searches are on full-text files know as corpus.

### About this Model

The boolean model takes a collection of documents ***Quran Translation.txt*** and other files named **1-15** (In this Project) and converts it into **Inverted Index** and **Positional Index** for Query Processing.

Each verse of the Quran [x:y] is treated as a document. 

**3 Documents Example:**
```
[1:1]
In the name of God, Most Gracious, Most Merciful.
[1:2]
Praise be to God, the Cherisher and Sustainer of the world;
[1:3]
Most Gracious, Most Merciful;
```

**Inverted Index Format:**
```
term document_frequency -> [ document_numbers ];

Example:
sustainer 5 -> 2 864 1104 1486 1510 1839 
master 3 -> 4 1869 2100 4238
assurance 8 -> 11 276 457 1094 1274 3303 3383 3615 4661 
....
```

**Positional Index Format:**
```
<term, document_frequency
[ document_number ] -> [ document_position ]
...
>

Example:
<coral, 5
D5087: 7 19 22
D5123: 5 11
>
<flame, 5
D5100: 9 
D6402: 6 12 13
D6404: 8 
>
<defence, 3
D5100: 18 21 29 
>
...
```

### Platform 

This project is created on Java Programming Language on Netbeans IDE. Its a simple Java Application Program that doesn't require anything extra. 

### How To Run/Install

- Download the Files
- Paste then in any directory
- Run Netbeans
- Click File>Open Project
- Select the Downloaded Project
- Click Run to view Results

### Objectives / Project Flow 

(EXP) Stands for AND/OR/NOT.

- [x] Construct ***Inverted Index***
- [x] Construct ***Positional Index***
- [x] Remove ***Stopwords***
- [x] ***Boolean Query Processing*** (t EXP k)
- [x] ***Proximity Queries Processing*** (t EXP k /y) : where y is the positional difference between t and k term
- [x] ***Phrase Queries Processing*** (t where t consists of t1 t2 t3 ... tn terms)
- [x] Designing an ***Interface on jSwing***

### Screenshots

- ***When Project is Built and Run***

![Build](http://i.imgur.com/yDPzdxS.png)

- ***Project Interface***

![Interface](http://i.imgur.com/h5XkC9f.png)

- ***Result Set Size***

![ResultSetSize](http://i.imgur.com/C6zPfhz.png)

- ***Document Result as a Dropdown Combo Box***

![QueryResult](http://i.imgur.com/lKZEGAf.png)

- ***Highlighted Document Content to Confirm From Query***

![Highlighter](http://i.imgur.com/RLBfXQf.png)


### Contact

For any query contact @
- gmail: ***k132089@nu.edu.pk***
- facebook: ***facebook.com/fuNkyBRO1***

Report any request so that it may be solved. 

### Further Work

This is as far as a I go for this project. I see no room for improvement. 

Clone this project for improving it from your side.
