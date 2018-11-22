cmake_minimum_required(VERSION 3.10.3)
project(PaCE_man C)

set(CMAKE_C_STANDARD 99)

add_executable(PaCE_man main.c Game/Souces/game.c Game/Headers/game.h JSON/Headers/cJSON.h JSON/Headers/cJSON_Utils.h
        JSON/Headers/json_builder.h JSON/Sources/cJSON.c JSON/Sources/cJSON_Utils.c
        JSON/Sources/json_builder.c Server/Headers/server.h Server/Sources/server.c Pathing/voraz.c Pathing/voraz.h)

set(THREADS_PREFER_PTHREAD_FLAG ON)
find_package(Threads REQUIRED)
find_package(Curses REQUIRED)
include_directories(${CURSES_INCLUDE_DIRS})
target_link_libraries(PaCE_man Threads::Threads)
target_link_libraries(PaCE_man ${CURSES_LIBRARIES})
target_link_libraries(PaCE_man m)