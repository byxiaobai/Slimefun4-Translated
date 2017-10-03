// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Messages.java

package me.mrCookieSlime.Slimefun.Setup;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Localization;

public class Messages
{

    public static Localization local;

    public Messages()
    {
    }

    public static void setup()
    {
        local.setPrefix("&aSlimefun &7> ");
        local.setDefault("messages.not-researched", new String[] {
            "&4\u4F60\u6CA1\u6709\u8DB3\u591F\u7684\u5B66\u8BC6\u6765\u7406\u89E3\u5B83"
        });
        local.setDefault("messages.not-enough-xp", new String[] {
            "&4\u4F60\u6CA1\u6709\u8DB3\u591F\u7684\u7ECF\u9A8C\u6765\u89E3\u9501\u8FD9\u4E2A\u7814\u7A76"
        });
        local.setDefault("messages.unlocked", new String[] {
            "&b\u4F60\u5DF2\u89E3\u9501\u4E86 &7\"%research%\""
        });
        local.setDefault("messages.fortune-cookie", new String[] {
            "&7\u6551\u6551\u6211! \u6211\u88AB\u56F0\u5728\u4E86\u5E78\u8FD0\u997C\u5E72\u5DE5\u5382\u91CC!", "&7\u4F60\u660E\u5929\u5C06\u4F1A\u6B7B\u4E8E...     \u82E6\u529B\u6015\u7684\u624B\u4E0B!", "&7\u5728\u4F60\u4EBA\u751F\u7684\u67D0\u65F6\u67D0\u523B\u5C06\u4F1A\u6709\u574F\u4E8B\u53D1\u751F!!!", "&7\u4E0B\u5468\u4F60\u5C06\u4F1A\u53D1\u73B0\u4F60\u4E0D\u662F\u5728\u73B0\u5B9E\u4E16\u754C, \u800C\u662F\u5728\u6E38\u620F\u91CC.", "&7\u8FD9\u5757\u66F2\u5947\u5C06\u5728\u51E0\u79D2\u5185\u53D8\u5F97\u597D\u5403", "&\u4F60\u5F88\u5FEB\u5C06\u4F1A\u6B7B\u4EA1\u800C\u4E14\u4F60\u6700\u540E\u542C\u5230\u7684\u8BCD\u5C06\u4F1A\u662F \"\u6BC1\u706D!!!\"", "&7\u65E0\u8BBA\u4F60\u8981\u505A\u4EC0\u4E48, \u4E0D\u8981\u62E5\u62B1\u82E6\u529B\u6015... \u6211\u8BD5\u8FC7\u4E86. \u611F\u89C9\u4E0D\u9519, \u4F46\u4E0D\u503C\u5F97."
        });
        local.setDefault("commands.help", new String[] {
            "\u5C55\u793A\u8FD9\u4E2A\u5E2E\u52A9\u754C\u9762"
        });
        local.setDefault("commands.cheat", new String[] {
            "\u5141\u8BB8\u4F60\u901A\u8FC7\u4F5C\u5F0A\u83B7\u53D6\u7C98\u6DB2\u79D1\u6280\u7269\u54C1"
        });
        local.setDefault("commands.give", new String[] {
            "\u7ED9\u67D0\u4EBA\u7C98\u6DB2\u79D1\u6280\u7269\u54C1"
        });
        local.setDefault("commands.research.desc", new String[] {
            "\u4E3A\u67D0\u4F4D\u73A9\u5BB6\u89E3\u9501\u4E00\u4E2A\u7814\u7A76"
        });
        local.setDefault("commands.guide", new String[] {
            "\u7ED9\u4F60\u81EA\u5DF1\u4E00\u672C\u7C98\u6DB2\u79D1\u6280\u6307\u5357"
        });
        local.setDefault("commands.timings", new String[] {
            "\u5173\u4E8E\u670D\u52A1\u5668\u7684\u5EF6\u8FDF\u4FE1\u606F"
        });
        local.setDefault("commands.teleporter", new String[] {
            "\u770B\u770B\u5176\u4ED6\u73A9\u5BB6\u7684\u8DEF\u5F84\u70B9"
        });
        local.setDefault("commands.versions", new String[] {
            "\u5217\u51FA\u6240\u6709\u5B89\u88C5\u7684 Addons"
        });
        local.setDefault("messages.only-players", new String[] {
            "&4\u8FD9\u4E2A\u6307\u4EE4\u53EA\u80FD\u5728\u6E38\u620F\u5185\u4F7F\u7528"
        });
        local.setDefault("messages.no-permission", new String[] {
            "&4\u4F60\u6CA1\u6709\u8DB3\u591F\u7684\u6743\u9650\u53BB\u505A\u8FD9\u4E2A"
        });
        local.setDefault("messages.usage", new String[] {
            "&4\u4F8B\u5B50: &c%usage%"
        });
        local.setDefault("messages.not-online", new String[] {
            "&4%player% &c\u4E0D\u5728\u7EBF!"
        });
        local.setDefault("messages.not-valid-item", new String[] {
            "&4%item% &c\u4E0D\u662F\u4E00\u4E2A\u7C98\u6DB2\u79D1\u6280\u7269\u54C1!"
        });
        local.setDefault("messages.given-item", new String[] {
            "&b\u4F60\u5DF2\u88AB\u7ED9\u4E88\u4E86\u4E00\u4E2A &7\"%item%\""
        });
        local.setDefault("messages.give-item", new String[] {
            "&b\u4F60\u7ED9\u4E88\u4E86\u73A9\u5BB6 %player% \u4E00\u4E2A &7\"%item%\""
        });
        local.setDefault("messages.not-valid-research", new String[] {
            "&4%research% &c\u4E0D\u662F\u4E00\u4E2A\u6709\u6548\u7684\u7814\u7A76\u540D!"
        });
        local.setDefault("messages.give-research", new String[] {
            "&b\u4F60\u6210\u529F\u89E3\u9501\u4E86\u73A9\u5BB6 %player% \u7684\u7814\u7A76 &7\"%research%\""
        });
        local.setDefault("messages.battery.add", new String[] {
            "&2+ &7%charge% J &8(%machine%)"
        });
        local.setDefault("messages.battery.remove", new String[] {
            "&4- &7%charge% J &8(%machine%)"
        });
        local.setDefault("messages.hungry", new String[] {
            "&c\u4F60\u592A\u997F\u4E86, \u5148\u5403\u70B9\u4E1C\u897F\u518D\u8FD9\u4E48\u505A\u5427!"
        });
        local.setDefault("messages.mode-change", new String[] {
            "&b%device% \u7684\u6A21\u5F0F\u5DF2\u5207\u6362\u81F3: &9%mode%"
        });
        local.setDefault("messages.disabled-in-world", new String[] {
            "&4&l\u8FD9\u4E2A\u7269\u54C1\u5728\u6B64\u4E16\u754C\u5DF2\u88AB\u7981\u7528"
        });
        local.setDefault("messages.talisman.anvil", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u62EF\u6551\u4E86\u4F60\u7684\u5DE5\u5177\u514D\u4E8E\u635F\u574F"
        });
        local.setDefault("messages.talisman.miner", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u53CC\u500D\u6389\u843D\u4E86\u77FF\u7269"
        });
        local.setDefault("messages.talisman.hunter", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u53CC\u500D\u6389\u843D\u4E86\u6389\u843D\u7269"
        });
        local.setDefault("messages.talisman.lava", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u5C06\u4F60\u4ECE\u5CA9\u6D46\u4E2D\u6551\u4E86\u51FA\u6765"
        });
        local.setDefault("messages.talisman.water", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u5C06\u4F60\u4ECE\u6EBA\u6C34\u4E2D\u6551\u4E86\u51FA\u6765"
        });
        local.setDefault("messages.talisman.angel", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u5C06\u4F60\u4ECE\u4FE1\u4EF0\u4E4B\u8DC3\u4E2D\u6551\u4E86\u51FA\u6765"
        });
        local.setDefault("messages.talisman.fire", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u5C06\u4F60\u4ECE\u706B\u7130\u4E2D\u6551\u4E86\u51FA\u6765"
        });
        local.setDefault("messages.talisman.magician", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u8D60\u9001\u4E86\u4F60\u989D\u5916\u7684\u9644\u9B54"
        });
        local.setDefault("messages.talisman.traveller", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u4F7F\u4F60\u8DD1\u8D77\u6765\u66F4\u5FEB\u4E86"
        });
        local.setDefault("messages.talisman.warrior", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u4F7F\u4F60\u5728\u4E00\u6BB5\u65F6\u95F4\u5185\u53D8\u5F97\u5F88\u5F3A"
        });
        local.setDefault("messages.talisman.knight", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u7ED9\u4E88\u4E86\u4F60 5 \u79D2\u7684\u751F\u547D\u6062\u590D"
        });
        local.setDefault("messages.talisman.whirlwind", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u62B5\u6321\u4E86\u6240\u6709\u7684\u5F39\u5C04\u7269"
        });
        local.setDefault("messages.talisman.wizard", new String[] {
            "&a&o\u4F60\u7684\u62A4\u8EAB\u7B26\u63D0\u5347\u4E86\u4E00\u4E2A\u66F4\u597D\u9644\u9B54\u7684\u7B49\u7EA7, \u4F46\u540C\u65F6\u5176\u4ED6\u9644\u9B54\u7B49\u7EA7\u5C06\u4F1A\u4E0B\u964D."
        });
        local.setDefault("messages.broken-leg", new String[] {
            "&c&o\u770B\u8D77\u6765\u4F60\u6454\u65AD\u4E86\u4F60\u7684\u817F, \u4E5F\u8BB8\u5939\u677F\u80FD\u591F\u5E2E\u52A9\u4F60?"
        });
        local.setDefault("messages.fixed-leg", new String[] {
            "&a&o\u6709\u4E86\u5939\u677F\u7684\u5E2E\u52A9. \u611F\u89C9\u597D\u591A\u4E86."
        });
        local.setDefault("messages.start-bleeding", new String[] {
            "&c&o\u4F60\u5F00\u59CB\u6D41\u8840\u4E86. \u4E5F\u8BB8\u7EF7\u5E26\u80FD\u591F\u5E2E\u52A9\u4F60?"
        });
        local.setDefault("messages.stop-bleeding", new String[] {
            "&a&o\u6709\u4E86\u7EF7\u5E26\u7684\u5E2E\u52A9. \u6D41\u8840\u505C\u6B62\u4E86!"
        });
        local.setDefault("messages.disabled-item", new String[] {
            "&4&l\u8FD9\u4E2A\u7269\u54C1\u5DF2\u88AB\u7981\u7528\u4E86! \u4F60\u662F\u600E\u4E48\u5F97\u5230\u5B83\u7684?"
        });
        local.setDefault("messages.research.start", new String[] {
            "&7\u53E4\u8001\u7684\u7075\u9B42\u6B63\u5411\u4F60\u8BC9\u8BF4\u795E\u79D8\u7684\u8BDD\u8BED!"
        });
        local.setDefault("messages.research.progress", new String[] {
            "&7\u4F60\u5F00\u59CB\u6162\u6162\u7406\u89E3 &b%research% &e(%progress%)"
        });
        local.setDefault("commands.stats", new String[] {
            "\u5C55\u793A\u4E00\u4E2A\u73A9\u5BB6\u7684\u7EDF\u8BA1\u8868"
        });
        local.setDefault("messages.fire-extinguish", new String[] {
            "&7\u4F60\u706D\u6389\u4E86\u4F60\u8EAB\u4E0A\u7684\u706B"
        });
        local.setDefault("machines.pattern-not-found", new String[] {
            "&e\u62B1\u6B49, \u4F60\u8BB0\u9519\u5408\u6210\u8868\u4E86\u5427. \u8FD9\u4E0D\u662F\u4E00\u4E2A\u6B63\u786E\u7684\u5408\u6210\u65B9\u5F0F."
        });
        local.setDefault("machines.unknown-material", new String[] {
            "&e\u62B1\u6B49, \u6211\u65E0\u6CD5\u8BC6\u522B\u4F60\u6446\u653E\u7684\u5408\u6210\u8868. \u8BF7\u4F7F\u7528\u6B63\u786E\u7684\u5408\u6210\u8868!"
        });
        local.setDefault("machines.wrong-item", new String[] {
            "&e\u62B1\u6B49, \u6211\u65E0\u6CD5\u8BC6\u522B\u4F60\u53F3\u952E\u7684\u7269\u54C1. \u68C0\u67E5\u5408\u6210\u8868\u770B\u770B\u54EA\u4E9B\u7269\u54C1\u53EF\u4EE5\u4F7F\u7528."
        });
        local.setDefault("machines.full-inventory", new String[] {
            "&e\u62B1\u6B49, \u6211\u7684\u80CC\u5305\u5DF2\u7ECF\u6EE1\u4E86!"
        });
        local.setDefault("miner.no-ores", new String[] {
            "&e\u62B1\u6B49, \u5468\u56F4\u627E\u4E0D\u5230\u77FF\u77F3\u4E86!"
        });
        local.setDefault("backpack.already-open", new String[] {
            "&c\u62B1\u6B49, \u8FD9\u4E2A\u80CC\u5305\u5DF2\u5728\u522B\u5904\u6253\u5F00\u4E86!"
        });
        local.setDefault("backpack.no-stack", new String[] {
            "&c\u4F60\u4E0D\u80FD\u5C06\u80CC\u5305\u5806\u79EF\u8D77\u6765"
        });
        local.setDefault("workbench.not-enhanced", new String[] {
            "&4\u4F60\u4E0D\u80FD\u5728\u539F\u7248\u5DE5\u4F5C\u53F0\u4F7F\u7528\u7C98\u6DB2\u79D1\u6280\u7269\u54C1"
        });
        local.setDefault("anvil.not-working", new String[] {
            "&4\u4F60\u4E0D\u80FD\u5728\u94C1\u7827\u91CC\u4F7F\u7528\u7C98\u6DB2\u79D1\u6280\u7269\u54C1"
        });
        local.setDefault("commands.research.reset", new String[] {
            "&c\u4F60\u5DF2\u91CD\u7F6E\u4E86 %player% \u7684\u6240\u6709\u7814\u7A76"
        });
        local.setDefault("commands.research.reset-target", new String[] {
            "&c\u4F60\u7684\u6240\u6709\u7814\u7A76\u5DF2\u88AB\u91CD\u7F6E"
        });
        local.setDefault("machines.in-use", new String[] {
            "&c\u8FD9\u4E2A\u673A\u5668\u6B63\u5728\u88AB\u5176\u4ED6\u73A9\u5BB6\u4F7F\u7528."
        });
        local.setDefault("gps.waypoint.new", new String[] {
            "&e\u8BF7\u4E3A\u4F60\u7684\u8DEF\u5F84\u70B9\u8D77\u540D &7(\u652F\u6301\u5F69\u8272\u4EE3\u7801!)"
        });
        local.setDefault("gps.waypoint.added", new String[] {
            "&a\u6210\u529F\u65B0\u589E\u4E86\u65B0\u7684\u8DEF\u5F84\u70B9"
        });
        local.setDefault("gps.waypoint.max", new String[] {
            "&4\u4F60\u5DF2\u5230\u8FBE\u8BBE\u7F6E\u8DEF\u5F84\u70B9\u7684\u6700\u5927\u4E0A\u9650!"
        });
        local.setDefault("gps.insufficient-complexity", new String[] {
            "&4GPS \u7F51\u7EDC\u590D\u6742\u5EA6\u4E0D\u591F: &c%complexity%", "&4a) \u4F60\u8FD8\u6CA1\u6709\u8BBE\u7F6E\u4E00\u4E2A GPS \u7F51\u7EDC", "&4b) \u4F60\u7684 GPS \u7F51\u7EDC\u590D\u6742\u5EA6\u4E0D\u591F, \u591A\u8BBE\u7F6E\u51E0\u4E2A\u536B\u661F"
        });
        local.setDefault("gps.geo.scan-required", new String[] {
            "&4\u9700\u8981GEO\u5730\u5F62\u626B\u63CF! &c\u8BF7\u5148\u4F7F\u7528 GEO\u5730\u5F62\u626B\u63CF\u5668!"
        });
        local.setDefault("robot.started", new String[] {
            "&7\u4F60\u7684\u673A\u5668\u4EBA\u91CD\u65B0\u8FD0\u884C\u4E86\u5B83\u7684\u811A\u672C"
        });
        local.setDefault("robot.stopped", new String[] {
            "&7\u4F60\u7684\u673A\u5668\u4EBA\u6682\u505C\u4E86\u5B83\u7684\u811A\u672C"
        });
        local.setDefault("inventory.no-access", new String[] {
            "&4\u4F60\u4E0D\u5141\u8BB8\u4F7F\u7528\u8FD9\u4E2A\u65B9\u5757"
        });
        local.setDefault("machines.ANCIENT_ALTAR.not-enough-pedestals", new String[] {
            "&4\u57FA\u5EA7\u4E0D\u8DB3. \u76EE\u524D\u5DF2\u6446\u653E\u7684\u57FA\u5EA7: &c(%pedestals% / 8)"
        });
        local.setDefault("machines.ANCIENT_ALTAR.unknown-catalyst", new String[] {
            "&4\u65E0\u6548\u7684\u5408\u6210\u914D\u65B9! &c\u8BF7\u5148\u6446\u653E\u5176\u4ED6\u7269\u54C1\u518D\u53F3\u952E!"
        });
        local.setDefault("machines.ANCIENT_ALTAR.unknown-recipe", new String[] {
            "&4\u672A\u77E5\u5408\u6210\u8868! &c\u8BF7\u4F7F\u7528\u6B63\u786E\u7684\u5408\u6210\u65B9\u5F0F!"
        });
        local.setDefault("machines.HOLOGRAM_PROJECTOR.enter-text", new String[] {
            "&7\u8BF7\u5199\u4E0B\u60F3\u663E\u793A\u5728\u5168\u606F\u6587\u672C\u4E0A\u7684\u8BDD. &r(\u652F\u6301\u989C\u8272\u4EE3\u7801)"
        });
        local.setDefault("machines.ELEVATOR.no-destinations", new String[] {
            "&4\u627E\u4E0D\u5230\u76EE\u7684\u5730 (\u68C0\u67E5\u4E0A/\u4E0B\u65B9\u662F\u5426\u4E5F\u653E\u7F6E\u4E86\u7535\u68AF)"
        });
        local.setDefault("machines.CARGO_NODES.must-be-placed", new String[] {
            "&4\u5FC5\u987B\u653E\u7F6E\u5728\u7BB1\u5B50\u6216\u673A\u5668\u4E0A!"
        });
        local.setDefault("android.scripts.already-uploaded", new String[] {
            "&4\u8FD9\u4E2A\u811A\u672C\u5DF2\u88AB\u4E0A\u4F20\u8FC7\u4E86."
        });
        local.setDefault("android.scripts.enter-name", new String[] {
            "", "&e\u8BF7\u4E3A\u4F60\u7684\u811A\u672C\u547D\u540D", ""
        });
        local.setDefault("android.scripts.uploaded", new String[] {
            "&b\u4E0A\u4F20\u4E2D...", "&a\u6210\u529F\u4E0A\u4F20\u4E86\u4F60\u7684\u811A\u672C!"
        });
        local.setDefault("android.scripts.rating.own", new String[] {
            "&4\u4F60\u4E0D\u80FD\u8BC4\u4EF7\u4F60\u81EA\u5DF1\u7684\u811A\u672C!"
        });
        local.setDefault("android.scripts.rating.already", new String[] {
            "&4\u4F60\u5DF2\u4E3A\u8FD9\u4E2A\u811A\u672C\u7559\u4E0B\u8BC4\u4EF7\u4E86!"
        });
        local.save();
    }
}
