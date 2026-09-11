# TabList (Fabric)

A Minecraft mod to customize the player tab list. Originally a NeoForge mod, ported to **Fabric 1.21.11**.

## Features

- Customizable tab list **header** and **footer**
- Full support for Minecraft color codes (`&a`, `&l`, etc.)
- Placeholders:

| Placeholder      | Description                          |
| ---------------- | ------------------------------------ |
| `#TPS`           | Server TPS (5s window)               |
| `#MSPT`          | Millis per tick (10s window)         |
| `#PLAYERCOUNT`   | Number of players online             |
| `#PING`          | Player ping                          |
| `#N`             | Newline                              |

> **Note:** `#TPS` and `#MSPT` require [Spark](https://spark.lucko.me/) to be installed on the server. Without it, these placeholders display `0`.

## Requirements

- Minecraft **1.21.11**
- [Fabric Loader](https://fabricmc.net/) >= 0.16.0
- [Fabric API](https://modrinth.com/mod/fabric-api) (any version for 1.21.11)
- Java 21+
- *(Optional)* Spark for TPS/MSPT placeholders

## Installation

1. Install [Fabric](https://fabricmc.net/use/) for your server platform.
2. Drop `tablist-1.0.2.jar` and Fabric API into the `mods` folder.

## Configuration

The config file is generated at `config/tablist.json` on first launch:

```json
{
  "header": "#N             &a&lYOUR SERVER           #N&a&l&m    #N",
  "footer": "#N&f\u73a9\u5bb6: &e#PLAYERCOUNT &f| \u5ef6\u8fdf: &e#PING#N&fTPS: &e#TPS &f| MSPT: &e#MSPT#N"
}
```

Edit the strings and restart (or reload) the server. The tab list updates every 32 ticks.

## Building from source

```bash
git clone https://github.com/INORACLE/Tab-List.git
cd Tab-List
./gradlew build
```

The built jar will be in `build/libs/`.

## License

[MIT](LICENSE)