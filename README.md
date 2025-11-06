
---

# 🎣 RodSpeed

A lightweight Minecraft plugin that allows you to customize the rod projectile speed with a simple multiplier system.

## Features

- **Customizable Rod Speed**: Adjust rod projectile velocity with a simple multiplier
- **Real-time Configuration**: Change settings without server restart
- **Permission-based**: Secure command access with permission nodes
- **Persistent Settings**: Configuration automatically saves and loads
- **Lightweight**: Minimal performance impact

## Requirements

- **Minecraft Server**: Spigot/Paper 1.7.x - 1.21.x
- **Java**: 8 or higher

## Installation

1. Download the latest `RodSpeed.jar` from the [Releases](https://github.com/Sypherox/RodSpeed/releases) page
2. Place the JAR file in your server's `plugins` folder
3. Restart your server or use a plugin manager to load it
4. Configure the plugin (optional) - see [Configuration](#configuration)

## Commands

| Command | Description | Permission | Usage |
|---------|-------------|------------|-------|
| `/rodspeed <multiplier>` | Set the rod speed multiplier | `rodspeed.use` | `/rodspeed 2.0` |

**Examples:**
- `/rodspeed 1.5` - Makes fishing rods 50% faster
- `/rodspeed 0.5` - Makes fishing rods 50% slower
- `/rodspeed 1.0` - Normal fishing rod speed (default)

## Permissions

| Permission | Description | Default |
|------------|-------------|---------|
| `rodspeed.use` | Allows use of the `/rodspeed` command | op |

## Configuration

The plugin creates a `config.yml` file in the `plugins/RodSpeed` folder:

```yaml
rod-multiplier: 1.0
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

If you encounter any issues or have questions:
- Open an [Issue](https://github.com/Sypherox/RodSpeed/issues)
- Join my [Discord Server](https://dsc.gg/sypherox)

***

⭐ If you find this plugin useful, please consider giving it a star!

***
