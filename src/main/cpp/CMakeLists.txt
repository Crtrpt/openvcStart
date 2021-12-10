cmake_minimum_required(VERSION 3.16)
project(HelloJNI VERSION 0.1 LANGUAGES C CXX ASM_MASM)

include_directories("D:\\jdk11\\include")
include_directories("D:\\jdk11\\include\\win32")
set(CMAKE_CXX_STANDARD 20)

add_library(HelloJNI SHARED HelloJNI.cpp HelloJNI.h)





