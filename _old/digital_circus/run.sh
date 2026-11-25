#!/usr/bin/env bash
gcc -O3 -Wextra -Wshadow -Wpedantic -Wconversion main.c -o main
./main >> output