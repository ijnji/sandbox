#!/bin/bash
rm epi/*.class; javac -Xlint:unchecked epi/$1.java; java epi.$1;
