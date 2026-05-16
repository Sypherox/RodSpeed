# 🎣 RodSpeed

A lightweight Minecraft plugin that lets you customize the fishing rod projectile speed with a simple multiplier, which is fully configurable via `config.yml`, including messages, permission node and command name.

## Features

- **Customizable Rod Speed** ⇾ Adjust rod projectile velocity with a decimal multiplier
- **Real-time Configuration** ⇾ `/rodspeed reload` applies changes instantly, no restart needed
- **Fully Customizable Messages** ⇾ Every message editable in `config.yml` with color code support
- **Configurable Permission Node** ⇾ Change the permission string without touching the code
- **Tab Completion** ⇾ Common multiplier presets auto-complete in chat
- **Persistent Settings** ⇾ Multiplier saved automatically on every change
- **Lightweight** ⇾ Minimal performance impact, no dependencies

## Requirements

- **Minecraft Server**: Spigot / Paper 1.8.9+
- **Java**: 8 or higher

## Installation

1. Download the latest `RodSpeed.jar` from the [Releases](https://github.com/Sypherox/RodSpeed/releases) page
2. Place the JAR in your server's `plugins/` folder
3. Restart the server (or use a plugin manager to load it)
4. Edit `plugins/RodSpeed/config.yml` to your liking

## Commands

| Command | Description | Permission |
|---------|-------------|------------|
| `/rodspeed <multiplier>` | Set the rod speed multiplier | `rodspeed.use` |
| `/rodspeed reload` | Reload the config live | `rodspeed.use` |

**Examples:**
- `/rodspeed 1.5` — Fishing rods 50% faster
- `/rodspeed 0.5` — Fishing rods 50% slower
- `/rodspeed 1.0` — Default speed
- `/rodspeed reload` — Reload config without restart

## Permissions

| Permission | Description | Default |
|------------|-------------|---------|
| `rodspeed.use` | Use `/rodspeed` and `/rodspeed reload` | `op` |

> The permission node is configurable in `config.yml` under `permission:`.

## Configuration (`config.yml`)

```yaml
# ──────────────────────────────────────────────
#  RodSpeed Configuration
#  GitHub: https://github.com/Sypherox/RodSpeed
# ──────────────────────────────────────────────

# The speed multiplier applied to the fishing rod projectile on launch.
#
# How it works:
#   The velocity vector of the fishing hook is multiplied by this value
#   the moment it is thrown. Values above 1.0 make it faster,
#   values below 1.0 make it slower.
#
# Examples:
#   0.5  → half speed (very slow, floats lazily)
#   1.0  → default Minecraft rod speed (no change)
#   1.5  → 50% faster than normal
#   2.0  → double speed (noticeably snappy)
#   3.0  → extremely fast, barely visible arc
#
# Accepted values: any positive decimal number (e.g. 0.1, 1.0, 2.5)
# Note: Very high values (5.0+) may cause the hook to overshoot or clip through blocks.
# This value is updated live via /rodspeed <multiplier>, no reload needed!
rod-multiplier: 1.0

# ──────────────────────────────────────────────

# The name of the command players use in-game.
#
# Example: if set to "rs", the command becomes /rs <multiplier>
#
# IMPORTANT: Changing this requires a full server restart to take effect,
# because commands are registered during plugin startup.
# The plugin.yml must also be updated manually if you rename the command.
command-name: rodspeed

# ──────────────────────────────────────────────

# The permission node required to use the /rodspeed command.
#
# You can set this to any string, e.g. "admin.rodspeed" or "myplugin.rod"
# Players/groups must have this permission assigned (via LuckPerms, etc.)
# to be able to run the command.
#
# Default: rodspeed.use (also defined in plugin.yml with default: op)
# Changes to this value take effect after /rodspeed reload.
permission: rodspeed.use

# ──────────────────────────────────────────────
# Messages
# ──────────────────────────────────────────────
#
# All messages support Minecraft color codes using the & symbol.
# Color code reference:
#   &0 Black    &1 Dark Blue   &2 Dark Green  &3 Dark Aqua
#   &4 Dark Red &5 Dark Purple &6 Gold        &7 Gray
#   &8 Dark Gray &9 Blue       &a Green       &b Aqua
#   &c Red      &d Light Purple &e Yellow     &f White
#
# Formatting codes:
#   &l Bold   &o Italic   &n Underline   &m Strikethrough   &r Reset
#
# Available placeholders (only where noted):
#   {cmd}   → replaced with the current command name (see command-name above)
#   {value} → replaced with the multiplier value that was just set
#
messages:

  # Shown when a player runs the command without the required permission.
  # No placeholders available.
  no-permission: "&cYou don't have permission to use this command."

  # Shown when the command is used incorrectly (wrong number of arguments).
  # Placeholder: {cmd} → the command name
  usage: "&cUsage: /{cmd} <multiplier>  |  /{cmd} reload"

  # Shown when the multiplier is successfully changed.
  # Placeholder: {value} → the new multiplier value
  set: "&aRod multiplier set to &e{value}&a."

  # Shown when the player provides a non-numeric argument (e.g. /rodspeed abc).
  # No placeholders available.
  invalid-number: "&cInvalid number. Please provide a valid decimal (e.g. 1.5)."

  # Shown when /rodspeed reload is executed successfully.
  # No placeholders available.
  reloaded: "&aRodSpeed config reloaded successfully."
```

## License

This project is licensed under the MIT License ⇾ see the [LICENSE](LICENSE) file for details.

## Support

- Open an [Issue](https://github.com/Sypherox/RodSpeed/issues)
- Join my [Discord Server](https://sypherox.dev/discord)

***

⭐ If you find this plugin useful, please consider giving it a star!