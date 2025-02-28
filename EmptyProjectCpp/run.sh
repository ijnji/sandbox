#!/bin/bash

if [ -d build/ ]; then
    rm -Rf build > /dev/null
fi
mkdir build/
cd build/
cmake ..
if [ $? -eq 0 ]; then
    make
fi
if [ $? -eq 0 ]; then
    ./main
fi
