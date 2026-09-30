#!/usr/bin/python3

import os
import subprocess


def main() -> None:
    for root, _, files in os.walk('.'):
        for filename in files:
            if not filename.endswith(".java"):
                continue

            fullpath = os.path.join(root, filename)
            subprocess.call(["javac", fullpath])
            
    
if __name__ == "__main__":
    main()