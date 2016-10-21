# Boolean Retrieval Model

### Information Retrieval and Text Mining

Boolean Retrieval Model belongs to the field of IR, which uses simple techniques of fetching documents from a collection relevant to the user. Our goal is to fetch as relevant document as possible from our collection.

Information retrieval (IR) is the activity of obtaining information resources relevant to an information need from a collection of information resources. Searches are on full-text files know as corpus.

### About this Model

The boolean model takes a collection of documents ***Quran Translation.txt*** (In this Project) and converts it into **Inverted Index** and **Positional Index** for Query Processing.

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

### Platform 

This project is created on Java Programming Language on Netbeans IDE. Its a simple Java Application Program that doesn't require anything extra. 

### How To Run/Install

- Download the Files
- Paste then in ***Documents/NetBeansProject/..*** or any directory
- Run Netbeans
- Click File>Open Project
- Select the Downloaded Project
- Project will be imported by now
- Click Run to view Results

### Objectives / Project Flow 

(EXP) Stands for AND/OR/NOT.

- [x] Construct Inverted Index
- [x] Construct Positional Index
- [ ] Remove Stopwords
- [ ] Boolean Query Processing (t EXP k)
- [ ] Proximity Queries (t EXP k /y) : where y is the positional difference between t and k term
- [ ] Phrase Queries (t where t consists of t1 t2 t3 ... tn terms)
- [ ] Designing an Interface on jSwing