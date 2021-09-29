# MinecraftFTP
A file manager accessed from in-game. Useful in Minecraft server management.

## What this project is _not_
It's **NOT** an FTP server that runs as a Minecraft plugin. If you want to have an FTP server, configure it yourself. It's trivial to do on Linux-based hosting and probably equally easy on Windows Server. If you have Minecraft-only hosting (ie. not a whole cloud webserver with admin-level OS access, like you'd get on [AWS](https://aws.amazon.com/), [GCP](https://console.cloud.google.com/home/), [Azure](https://azure.microsoft.com/) or [Linode](https://www.linode.com/), where you'd need a special FTP app running), you probably have FTP configured already, as that's the most common way to get files in and out of a Minecraft-only server. If not - go find a better hosting! Seriously, what the hell are you using?! FTP is the most basic functionality that all Minecraft-centered hosting services should provide. The only more basic functionality I could think of is running the Minecraft server itself. There are tons upon tons of Minecraft host that provide FTP, [some of which even offer their services for free](server.pro).

## But what _is_ it, then?
As I said earlier, MinecraftFTP is a plugin that adds a file manager accessible from the game. In most (if not all) cases, you'd have to manage your files externally - whether that's tools build into your OS (for example, File Explorer on WinServer or `cd` on Linux), file manager provided by your hosting service, Filezilla, `scp` via SSH, or an FTP server. With MinecraftFTP, you can now manage your files using in-game tools, namely: commands. (We're also planning a companion mod that would add an actual graphical file explorer, uploader and editor, but that's coming way, _waaayy_ later - if ever (I can't promise anything).)
 
## Supported features
Currently, you can:

* Navigate across your server filesystem
* Get file contents
* Download files from the web (only synchronously at the moment)
* Manage files and directories (copying, deleting, moving, etc.)

More about those in [the wiki](https://github.com/GuzioMG/MinecraftFTP/wiki).

### Planned features
* Async file download
* An API
* The aforementioned companion mod (not quite "planned", more like "possible in a faraway future")
* Only rendering user-selected lines when using the `/cat` command (would allow us to show longer files)
* Line numbering for the `/cat` command (a workaround Minecraft's pesky, un-disable-able line wrap)
* Modifying files:
  - Line-by-line
  - Special treatment of YAML, TOML and JSON files with internal URI-based editing. (ie. altering individual properties)

## License
This project is licensed under the GPL version 2.0 license.

Why not the newest GPL version? Well... I believe in developer's freedom. If one doesn't like how their code is used, they should not allow their code to be used this way. What do I mean by that? Retracting commits. Can this be used to sabotage the project? Absolutely! Is the freedom given to the devs worth the risk? Absolutely, too! But still... the risk of someone purposely sabotaging the project after they choose to leave is there. That's why, as far as I know, the last GPL version that allows such behaviour is GPL 2.0. If I recall correctly, retracting one's own commits without the permission of the project maintainer is not permitted under GPL 3.0, so this project is stuck under 2.0

## How to get this project?
Currently - you can't. It's still under development.
_It's obviously possible to self-compile the code_
