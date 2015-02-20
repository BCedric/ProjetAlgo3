#!/bin/bash

javac src/AVL.java src/CClasseUnion.java src/Dictionnaire.java src/Dictionnaire.java src/Livre.java src/Main.java src/Mot.java src/Page.java -d bin/
cd bin/
java Main 4 ../dico.txt ../P1.txt ../P2.txt ../P3.txt ../P4.txt ../P5.txt ../P6.txt ../P7.txt ../P8.txt ../P9.txt ../P10.txt ../P11.txt ../P12.txt ../P13.txt


exit 0
