# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.12

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/nicko/.local/share/JetBrains/Toolbox/apps/CLion/ch-0/182.5107.21/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /home/nicko/.local/share/JetBrains/Toolbox/apps/CLion/ch-0/182.5107.21/bin/cmake/linux/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/nicko/Documents/CLionProjects/adimnPacMan

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/nicko/Documents/CLionProjects/adimnPacMan/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/adimnPacMan.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/adimnPacMan.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/adimnPacMan.dir/flags.make

CMakeFiles/adimnPacMan.dir/main.c.o: CMakeFiles/adimnPacMan.dir/flags.make
CMakeFiles/adimnPacMan.dir/main.c.o: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/nicko/Documents/CLionProjects/adimnPacMan/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/adimnPacMan.dir/main.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/adimnPacMan.dir/main.c.o   -c /home/nicko/Documents/CLionProjects/adimnPacMan/main.c

CMakeFiles/adimnPacMan.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/adimnPacMan.dir/main.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/nicko/Documents/CLionProjects/adimnPacMan/main.c > CMakeFiles/adimnPacMan.dir/main.c.i

CMakeFiles/adimnPacMan.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/adimnPacMan.dir/main.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/nicko/Documents/CLionProjects/adimnPacMan/main.c -o CMakeFiles/adimnPacMan.dir/main.c.s

CMakeFiles/adimnPacMan.dir/client.c.o: CMakeFiles/adimnPacMan.dir/flags.make
CMakeFiles/adimnPacMan.dir/client.c.o: ../client.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/nicko/Documents/CLionProjects/adimnPacMan/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building C object CMakeFiles/adimnPacMan.dir/client.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/adimnPacMan.dir/client.c.o   -c /home/nicko/Documents/CLionProjects/adimnPacMan/client.c

CMakeFiles/adimnPacMan.dir/client.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/adimnPacMan.dir/client.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/nicko/Documents/CLionProjects/adimnPacMan/client.c > CMakeFiles/adimnPacMan.dir/client.c.i

CMakeFiles/adimnPacMan.dir/client.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/adimnPacMan.dir/client.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/nicko/Documents/CLionProjects/adimnPacMan/client.c -o CMakeFiles/adimnPacMan.dir/client.c.s

CMakeFiles/adimnPacMan.dir/cJSON.c.o: CMakeFiles/adimnPacMan.dir/flags.make
CMakeFiles/adimnPacMan.dir/cJSON.c.o: ../cJSON.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/nicko/Documents/CLionProjects/adimnPacMan/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building C object CMakeFiles/adimnPacMan.dir/cJSON.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/adimnPacMan.dir/cJSON.c.o   -c /home/nicko/Documents/CLionProjects/adimnPacMan/cJSON.c

CMakeFiles/adimnPacMan.dir/cJSON.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/adimnPacMan.dir/cJSON.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/nicko/Documents/CLionProjects/adimnPacMan/cJSON.c > CMakeFiles/adimnPacMan.dir/cJSON.c.i

CMakeFiles/adimnPacMan.dir/cJSON.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/adimnPacMan.dir/cJSON.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/nicko/Documents/CLionProjects/adimnPacMan/cJSON.c -o CMakeFiles/adimnPacMan.dir/cJSON.c.s

CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.o: CMakeFiles/adimnPacMan.dir/flags.make
CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.o: ../cJSON_Utils.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/nicko/Documents/CLionProjects/adimnPacMan/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building C object CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.o   -c /home/nicko/Documents/CLionProjects/adimnPacMan/cJSON_Utils.c

CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/nicko/Documents/CLionProjects/adimnPacMan/cJSON_Utils.c > CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.i

CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/nicko/Documents/CLionProjects/adimnPacMan/cJSON_Utils.c -o CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.s

CMakeFiles/adimnPacMan.dir/json_builder.c.o: CMakeFiles/adimnPacMan.dir/flags.make
CMakeFiles/adimnPacMan.dir/json_builder.c.o: ../json_builder.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/nicko/Documents/CLionProjects/adimnPacMan/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building C object CMakeFiles/adimnPacMan.dir/json_builder.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/adimnPacMan.dir/json_builder.c.o   -c /home/nicko/Documents/CLionProjects/adimnPacMan/json_builder.c

CMakeFiles/adimnPacMan.dir/json_builder.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/adimnPacMan.dir/json_builder.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/nicko/Documents/CLionProjects/adimnPacMan/json_builder.c > CMakeFiles/adimnPacMan.dir/json_builder.c.i

CMakeFiles/adimnPacMan.dir/json_builder.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/adimnPacMan.dir/json_builder.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/nicko/Documents/CLionProjects/adimnPacMan/json_builder.c -o CMakeFiles/adimnPacMan.dir/json_builder.c.s

# Object files for target adimnPacMan
adimnPacMan_OBJECTS = \
"CMakeFiles/adimnPacMan.dir/main.c.o" \
"CMakeFiles/adimnPacMan.dir/client.c.o" \
"CMakeFiles/adimnPacMan.dir/cJSON.c.o" \
"CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.o" \
"CMakeFiles/adimnPacMan.dir/json_builder.c.o"

# External object files for target adimnPacMan
adimnPacMan_EXTERNAL_OBJECTS =

adimnPacMan: CMakeFiles/adimnPacMan.dir/main.c.o
adimnPacMan: CMakeFiles/adimnPacMan.dir/client.c.o
adimnPacMan: CMakeFiles/adimnPacMan.dir/cJSON.c.o
adimnPacMan: CMakeFiles/adimnPacMan.dir/cJSON_Utils.c.o
adimnPacMan: CMakeFiles/adimnPacMan.dir/json_builder.c.o
adimnPacMan: CMakeFiles/adimnPacMan.dir/build.make
adimnPacMan: CMakeFiles/adimnPacMan.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/nicko/Documents/CLionProjects/adimnPacMan/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Linking C executable adimnPacMan"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/adimnPacMan.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/adimnPacMan.dir/build: adimnPacMan

.PHONY : CMakeFiles/adimnPacMan.dir/build

CMakeFiles/adimnPacMan.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/adimnPacMan.dir/cmake_clean.cmake
.PHONY : CMakeFiles/adimnPacMan.dir/clean

CMakeFiles/adimnPacMan.dir/depend:
	cd /home/nicko/Documents/CLionProjects/adimnPacMan/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/nicko/Documents/CLionProjects/adimnPacMan /home/nicko/Documents/CLionProjects/adimnPacMan /home/nicko/Documents/CLionProjects/adimnPacMan/cmake-build-debug /home/nicko/Documents/CLionProjects/adimnPacMan/cmake-build-debug /home/nicko/Documents/CLionProjects/adimnPacMan/cmake-build-debug/CMakeFiles/adimnPacMan.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/adimnPacMan.dir/depend

