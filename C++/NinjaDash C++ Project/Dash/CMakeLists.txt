cmake_minimum_required(VERSION 3.17)
project(Dash)

set(CMAKE_CXX_STANDARD 20)

add_executable(Dash src/main.cpp src/main.cpp src/engine.cpp headers/engine.hpp src/player.cpp headers/player.hpp headers/entity.hpp headers/platform.hpp src/platform.cpp headers/death.hpp src/death.cpp src/gamestate.cpp headers/gamestate.hpp src/audio.cpp headers/audio.hpp src/sound.cpp headers/sound.hpp src/score.cpp headers/score.hpp)

include_directories(headers /usr/include c:/SFML/include)

set(SFML_ROOT c:/SFML)
set(CMAKE_MODULE_PATH "${CMAKE_CURRENT_LIST_DIR}/cmake_modules")
find_package(SFML REQUIRED system window graphics network audio)
if (SFML_FOUND)
    include_directories(${SFML_INCLUDE_DIR})
    target_link_libraries(Dash ${SFML_LIBRARIES} ${SFML_DEPENDENCIES})
endif()

file(COPY assets DESTINATION ${CMAKE_BINARY_DIR})

# Copy dlls to build
if(WIN32)
    file(GLOB BINARY_DEP_DLLS "${SFML_INCLUDE_DIR}/../bin/*.dll")
    file(COPY ${BINARY_DEP_DLLS} DESTINATION ${CMAKE_BINARY_DIR})
    file(GLOB MINGW_DEP_DLLS "C:/mingw64/bin/*.dll")
    file(COPY ${MINGW_DEP_DLLS} DESTINATION ${CMAKE_BINARY_DIR})
endif()