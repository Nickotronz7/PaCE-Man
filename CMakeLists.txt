cmake_minimum_required(VERSION 3.12)
project(PaCE_man C)

set(CMAKE_C_STANDARD 99)

add_executable(PaCE_man main.c Game/game.c Game/game.h)