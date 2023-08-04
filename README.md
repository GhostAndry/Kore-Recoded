# Kore

A great plugin for all the functions needed for a minecraft server

## Info

Native version: 1.20

Tested versions: 1.8, 1.9, 1.10, 1.11. 1.12, 1.13, 1.14, 1.15, 1.16, 1.17, 1.18, 1.19, 1.20

## Commands

(mandatory) [optional]
- /kore (help|reload|info)
- /gamemode (gamemode) [player]
- /gmc [player]
- /gms [player]
- /gma [player]
- /gmsp [player]
- /fly [player]
- /teleport /tp (player| x y z) [player| x y z]
- /heal [player]
- /god [player]
- /vanish /v [player]
- /setspawn
- /spawn [player]
- /trash /disposal
- /orbitalcannon (player | x y z)
- /smite (player)
- /kill [player]
- /warp (add|remove) (name)
- /warp (name) [player]
- /home [set|remove]
- /speed (value) [player] [type]
- /killmobs
- /spawnmob (mob) [number]

## Permissions

- kore.gamemode.adventure
- kore.gamemode.spectator
- kore.gamemode.creative
- kore.gamemode.survival
- kore.orbitalcannon
- kore.chatbypass
- kore.warp.admin
- kore.gamemode.*
- kore.teleport
- kore.gamemode
- kore.setspawn
- kore.killmobs
- kore.godmode
- kore.reload
- kore.vanish
- kore.spawn
- kore.trash
- kore.smite
- kore.speed
- kore.heal
- kore.kill
- kore.warp
- kore.home
- kore.tp
- kore.*

## Placeholders

### [FOR PLACEHOLDERS NEED PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/)

- %kore_vanished%
- %kore_flying%
- %kore_godmode%

​
[BStats](https://bstats.org/plugin/bukkit/Kore/18653)

​
[FOR ANY ISUES GO TO DISCORD FORUM](https://discord.gg/sR5QTmHQ2U)

## Configs and Languages

### Config.yml
```yaml
gamemode:
    enabled: true
fly:
    enabled: true
teleport:
    enabled: true
godmode:
    enabled: true
heal:
    enabled: true
vanish:
    enabled: true
spawn:
    enabled: true
    on-join: true
trash:
    enabled: true
orbitalcannon:
    enabled: true
    tell-to-victim: true
smite:
    enabled: true
kill:
    enabled: true
warp:
    enabled: true
home:
    enabled: true
speed:
    enabled: true
killmobs:
    enabled: true
    async: true #recomanded: true
spawnmob:
    enabled: true
chat:
    enabled: true
    format: "%sender%: %message%"
    blacklist-words:
        - fuck
        - shit

messages: en

```

### lang/it.yml

```yaml
prefix: "&b&lKore&f:"
no-permissions: "%prefix% &cNon hai permessi."
only-players: "%prefix% &cSolo giocatori possono eseguire questo commando!"
command-disabled: "%prefix% &cQuesto commando è disabilitato!"
invalid-target: "%prefix% &cGiocatore non trovato."
lang-name: "Italiano"
messages:
    successfully-set: "%prefix% &aLingua del file cambiata con successo in %lang%"
    not-exist: "%prefix% &cImpossibile caricare le lingue perché il file non esiste!"
reload:
    success: "%prefix% &aReload eseguito con successo!"
    error: "%prefix% &cErrore interno. Guarda la console per errori."
gamemode:
    changed: "%prefix% &aLa tua Gamemode è stata cambiata in &e&o%gamemode%"
    changed-other: "%prefix% &aLa gamemode di %player% è stata cambiata in &e&o%gamemode%"
    usage:
        console: "%prefix% &cUso: /gamemode <gamemode> <player>"
        player: "%prefix% &cUso: /gamemode <gamemode> &1[player]"
fly:
    enabled: "%prefix% &aFly abilitata."
    disabled: "%prefix% &cFly disabilitata."
    enabled-other: "%prefix% &aFly abilitata per %player%."
    disabled-other: "%prefix% &cFly disabilitata per %player%."
    usage:
        console: "%prefix% &cUso: /fly <player>"
        player: "%prefix% &cUso: /fly &1[player]"
teleport:
    teleported: "%prefix% &aTeletrasportato a %loc%"
    teleported-other: "%prefix% &aTeletrasportato %player% a %loc%"
    usage:
        player: "%prefix% &cUso: /teleport <player| x y z > &1[player| x y z ]"
        console: "%prefix% &cUso: /teleport <player| x y z > <player| x y z >"
god:
    enabled: "%prefix% &aGodmode abilitata."
    disabled: "%prefix% &cGodmode disabilitata."
    enabled-other: "%prefix% &aGodmode abilitata per %player%."
    disabled-other: "%prefix% &cGodmode disabilitata per %player%."
    usage:
        player: "%prefix% &cUso: /god &1[player]"
        console: "%prefix% &cUso: /god <player>"
heal:
    healed: "%prefix% &aCurato!"
    healed-other: "%prefix% &a%player% è stato Curato!"
    usage:
        player: "%prefix% &cUso: /heal &1[player]"
        console: "%prefix% &cUso: /heal <player>"
vanish:
    enabled: "%prefix% &aVanish abilitata."
    disabled: "%prefix% &aVanish disabilitata."
    enabled-other: "%prefix% &aVanish abilitata per &e&o%player%."
    disabled-other: "%prefix% &aVanish disabilitata per &e&o%player%."
    usage:
        player: "%prefix% &cUso: /vanish &1[player]"
        console: "%prefix% &cUso: /vanish <player>"
spawn:
    set: "%prefix% &aSpawn settato a %x% %y% %z%."
    teleported: "%prefix% &aTeletrasportato allo Spawn!"
    teleported-other: "%prefix% &aTeletrasportato %player% allo spawn"
    nonexistent: "%prefix% &cLo spawn point non è creato"
    usage:
        admin: "%prefix% &cUso: /setspawn"
        player: "%prefix% &cUso: /spawn &1[player]"
        console: "%prefix% &cUso: /spawn <player>"
orbitalcannon:
    shoot: "%prefix% &aIl cannone orbitale sparato a %coords%."
    tell: "%prefix% &c&lSei stato colpito dal cannone orbitale!"
    usage: "%prefix% &cUso: /orbitalcannon <player | x y z>"
smite:
    smited-player: "%prefix% &aHai fulminato %player%"
    usage: "%prefix% &cUso: /smite <player>"
kill:
    killed: "%prefix% &aHai Ucciso %player%."
    usage:
        player: "%prefix% &cUso: /kill &1[player]"
        console: "%prefix% &cUso: /kill <player>"
warp:
    warped: "%prefix% &aSei stato teletrasportato al warp %warp%"
    warped-other: "%prefix% &aHai teletrasportato %player% al warp %warp%"
    not-found: "%prefix% &cWarp non trovato."
    admin:
        added: "%prefix% &aWarp %warp% creato con successo."
        already-exist: "%prefix% &cWarp %warp% esiste gia"
        removed: "%prefix% &aWarp %warp% eliminato con successo."
    usage:
        player: "%prefix% &cUso: /warp <name> &1[player]"
        console: "%prefix% &cUso: /warp <name> <player>"
        admin:
            add: "%prefix% &cUso: /warp add <name>"
            remove: "%prefix% &cUso: /warp remove <name>"
home:
    teleported: "%prefix% &aSei stato teletrasportato nella tua casa."
    teleported-other: "%prefix% &aHai teletrasportato %player% alla sua casa."
    not-set: "%prefix% &cNon hai impostato la tua casa."
    set: "%prefix% &aLa tua Casa è stata impostata nella tua posizione."
    removed: "%prefix% &cLa tua Casa è stata rimossa."
    usage: "%prefix% &cUso:67/home &1[set|remove]"
speed:
    set: "%prefix% &aLa tua Velocita è stata imposta a %speed%"
    set-other: "%prefix% &aLa Velocita di %player% è stata imposta a %speed%"
    invalid-value: "%prefix% &cVelocita Imposta Invalida."
    invalid-type:
        "%prefix% &cTipo di Velocita Imposta è Invalida. Ci sono Queste Velocita: Walk or Walking, Fly
        or Flight"
    usage:
        player: "%prefix% &cUso: /speed <value> &1[player] [type]"
        console: "%prefix% &cUso: /speed <value> <player> <type>"
killmobs:
    killed: "%prefix% &aUcciso tutti i mobs ostili"
    usage: "%prefix% &cUso: /killmobs"
```

### lang/en.yml

```yaml
prefix: "&b&lKore&f:"
no-permissions: "%prefix% &cYou don't have permissions."
only-players: "%prefix% &cOnly players can run this command!"
command-disabled: "%prefix% &cThis command is disabled"
invalid-target: "%prefix% &cPlayer not found."
lang-name: "English"
messages:
    successfully-set: "%prefix% &aSuccessfully changed language file to %lang%"
    not-exist: "%prefix% &cImpossible to load the languages because the file doesn't exist!"
reload:
    success: "%prefix% &aSuccessfully reloaded!"
    error: "%prefix% &cInternal error. Check the console for more info."
gamemode:
    changed: "%prefix% &aYour gamemode was changed to &e&o%gamemode%"
    changed-other: "%prefix% &a%player%'s gamemode was changed to &e&o%gamemode%"
    usage:
        console: "%prefix% &cUsage: /gamemode <gamemode> <player>"
        player: "%prefix% &cUsage: /gamemode <gamemode> &1[player]"
fly:
    enabled: "%prefix% &aFly enabled."
    disabled: "%prefix% &cFly disabled."
    enabled-other: "%prefix% &aFly enabled for %player%."
    disabled-other: "%prefix% &cFly disabled for %player%."
    usage:
        console: "%prefix% &cUsage: /fly <player>"
        player: "%prefix% &cUsage: /fly &1[player]"
teleport:
    teleported: "%prefix% &aTeleported to %loc%"
    teleported-other: "%prefix% &aTeleported %player% to %loc%"
    usage:
        player: "%prefix% &cUsage: /teleport <player| x y z > &1[player| x y z ]"
        console: "%prefix% &cUsage: /teleport <player| x y z > <player| x y z >"
god:
    enabled: "%prefix% &aGodmode enabled."
    disabled: "%prefix% &cGodmode disabled."
    enabled-other: "%prefix% &aGodmode enabled for %player%."
    disabled-other: "%prefix% &cGodmode disabled for %player%."
    usage:
        player: "%prefix% &cUsage: /god &1[player]"
        console: "%prefix% &cUsage: /god <player>"
heal:
    healed: "%prefix% &aHealed!"
    healed-other: "%prefix% &a%player% has been healed!"
    usage:
        player: "%prefix% &cUsage: /heal &1[player]"
        console: "%prefix% &cUsage: /heal <player>"
vanish:
    enabled: "%prefix% &aVanish turned on."
    disabled: "%prefix% &aVanish turned off."
    enabled-other: "%prefix% &aVanish turned on for &e&o%player%."
    disabled-other: "%prefix% &aVanish turned off for &e&o%player%."
    usage:
        player: "%prefix% &cUsage: /vanish &1[player]"
        console: "%prefix% &cUsage: /vanish <player>"
spawn:
    set: "%prefix% &aSpawn has been set to %x% %y% %z%."
    teleported: "%prefix% &aTeleported to spawn"
    teleported-other: "%prefix% &aTeleported %player% to spawn"
    nonexistent: "%prefix% &cSpawn point wasn't set yet"
    usage:
        admin: "%prefix% &cUsage: /setspawn"
        player: "%prefix% &cUsage: /spawn &1[player]"
        console: "%prefix% &cUsage: /spawn <player>"
orbitalcannon:
    shoot: "%prefix% &aThe Orbital Cannon fired a shot at %coords%."
    tell: "%prefix% &c&lYou've been hit by an orbital cannon shot!"
    usage: "%prefix% &cUsage: /orbitalcannon <player | x y z>"
smite:
    smited-player: "%prefix% &aSmited %player%"
    usage: "%prefix% &cUsage: /smite <player>"
kill:
    killed: "%prefix% &aKilled %player%."
    usage:
        player: "%prefix% &cUsage: /kill &1[player]"
        console: "%prefix% &cUsage: /kill <player>"
warp:
    warped: "%prefix% &aYou have been warped to %warp%"
    warped-other: "%prefix% &aYou have warped %player% to %warp%"
    not-found: "%prefix% &cWarp not found."
    admin:
        added: "%prefix% &a%warp% was successfully added."
        already-exist: "%prefix% &c%warp% already exist"
        removed: "%prefix% &a%warp% was successfully removed."
    usage:
        player: "%prefix% &cUsage: /warp <name> &1[player]"
        console: "%prefix% &cUsage: /warp <name> <player>"
        admin:
            add: "%prefix% &cUsage: /warp add <name>"
            remove: "%prefix% &cUsage: /warp remove <name>"
home:
    teleported: "%prefix% &aYou have been teleported to your home."
    teleported-other: "%prefix% &aYou have teleported %player% to his house."
    not-set: "%prefix% &cYou haven't set your home yet."
    set: "%prefix% &aYour home has been set to your position."
    removed: "%prefix% &cYour home has been removed."
    usage: "%prefix% &cUsage /home &1[set|remove]"
speed:
    set: "%prefix% Your speed was set to %speed%"
    set-other: "%prefix% %player%'s speed was set to %speed%"
    invalid-value: "%prefix% &cInvalid speed value"
    invalid-type:
        "%prefix% &cInvalid speed type. Speed types: Walk or Walking, Fly
        or Flight"
    usage:
        player: "%prefix% &cUsage: /speed <value> &1[player] [type]"
        console: "%prefix% &cUsage: /speed <value> <player> <type>"
killmobs:
    killed: "%prefix% &aKilled all hostile mobs"
    usage: "%prefix% &cUsage: /killmobs"
```
