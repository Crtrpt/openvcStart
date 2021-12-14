@echo off

javac -h . HelloJNI.java
mkdir build
cd build
cmake --build .  --target HelloJNI

cd ..