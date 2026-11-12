#!/usr/bin/env bash
cd src
javac -d ../bin draw/*.java draw/*/*.java
java -cp ../bin draw.Main