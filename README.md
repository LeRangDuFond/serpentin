# Serpentin

[![Join the chat at https://gitter.im/LeRangDuFond/Lobby](https://badges.gitter.im/LeRangDuFond/Lobby.svg)](https://gitter.im/LeRangDuFond/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge) [![Build Status](https://travis-ci.org/LeRangDuFond/serpentin.svg?branch=travis)](https://travis-ci.org/LeRangDuFond/serpentin)

## Introduction

A Snake game powered by the Lille game framework.

## Requirements

* Git
* Java 1.7 or higher (Oracle or OpenJDK recommended).
* Maven.

## Installation and Running

Start by cloning this repository, the "Lille Game Framework" is added as a sub-module so you will have to use this command:

`git clone --recursive git://github.com:LeRangDuFond/serpentin.git`.

If you have already cloned this repository or the command above isn't working:

```
git clone git://github.com:LeRangDuFond/serpentin.git
cd serpentin
git submodule update --init --recursive
```

Compiling the framework and the game is done with the `mvn test` command at the root of this repository.

To play the game, just type `java -jar serpentin-game/target/serpentin-1.0-SNAPSHOT.jar` (if you are under Windows, replace the slashes by backslashes), if you are already in the `serpentin-game` directory, remove it from the command.

Enjoy playing our prototype!

## Authors

* Robin Bossart
* Francois Masson
* Joël Troch
