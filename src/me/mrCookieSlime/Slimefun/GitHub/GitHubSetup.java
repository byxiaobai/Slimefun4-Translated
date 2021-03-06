// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   GitHubSetup.java

package me.mrCookieSlime.Slimefun.GitHub;

import com.google.gson.*;
import java.util.List;
import me.mrCookieSlime.Slimefun.SlimefunGuide;

// Referenced classes of package me.mrCookieSlime.Slimefun.GitHub:
//            GitHubConnector, Contributor, IntegerFormat

public class GitHubSetup
{

    public GitHubSetup()
    {
    }

    public static void setup()
    {
        new GitHubConnector() {

            public void onSuccess(JsonElement element)
            {
                SlimefunGuide.contributors.clear();
                JsonArray array = element.getAsJsonArray();
                for(int i = 0; i < array.size(); i++)
                {
                    JsonObject object = array.get(i).getAsJsonObject();
                    String name = object.get("login").getAsString();
                    String job = "&cAuthor";
                    int commits = object.get("contributions").getAsInt();
                    String profile = object.get("html_url").getAsString();
                    if(!name.equals("invalid-email-address"))
                    {
                        Contributor contributor = new Contributor(name, job, commits);
                        contributor.profile = profile;
                        SlimefunGuide.contributors.add(contributor);
                    }
                }

                SlimefunGuide.contributors.add(new Contributor("AquaLazuryt", "&6Lead Head Artist", 0));
            }

            public void onFailure()
            {
                SlimefunGuide.contributors.clear();
                SlimefunGuide.contributors.add(new Contributor("TheBusyBiscuit", "&cAuthor", 3));
                SlimefunGuide.contributors.add(new Contributor("John000708", "&cAuthor", 2));
                SlimefunGuide.contributors.add(new Contributor("AquaLazuryt", "&6Lead Head Artist", 0));
            }

            public String getRepository()
            {
                return "TheBusyBiscuit/Slimefun4";
            }

            public String getFileName()
            {
                return "contributors";
            }

            public String getURLSuffix()
            {
                return "/contributors";
            }

        }
;
        new GitHubConnector() {

            public void onSuccess(JsonElement element)
            {
                JsonObject object = element.getAsJsonObject();
                SlimefunGuide.issues = object.get("open_issues_count").getAsInt();
                SlimefunGuide.forks = object.get("forks").getAsInt();
                SlimefunGuide.last_update = IntegerFormat.parseGitHubDate(object.get("pushed_at").getAsString());
            }

            public void onFailure()
            {
            }

            public String getRepository()
            {
                return "TheBusyBiscuit/Slimefun4";
            }

            public String getFileName()
            {
                return "repo";
            }

            public String getURLSuffix()
            {
                return "";
            }

        }
;
        new GitHubConnector() {

            public void onSuccess(JsonElement element)
            {
                JsonObject object = element.getAsJsonObject();
                SlimefunGuide.code_bytes = object.get("Java").getAsInt();
            }

            public void onFailure()
            {
            }

            public String getRepository()
            {
                return "TheBusyBiscuit/Slimefun4";
            }

            public String getFileName()
            {
                return "languages";
            }

            public String getURLSuffix()
            {
                return "/languages";
            }

        }
;
    }
}
