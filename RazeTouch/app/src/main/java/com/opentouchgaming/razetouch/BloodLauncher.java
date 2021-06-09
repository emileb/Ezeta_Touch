package com.opentouchgaming.razetouch;

import com.opentouchgaming.androidcore.DebugLog;
import com.opentouchgaming.androidcore.GameEngine;
import com.opentouchgaming.androidcore.SubGame;

import java.io.File;
import java.util.ArrayList;

public class BloodLauncher extends RazeBaseLauncher
{
    BloodLauncher()
    {
        SUB_DIR = "BLOOD";
        new File(getRunDirectory()).mkdirs();
    }

    @Override
    public void updateSubGames(GameEngine engine, ArrayList<SubGame> availableSubGames)
    {
        log.log(DebugLog.Level.D, "updateSubGames");

        availableSubGames.clear();

        SubGame.addGame(availableSubGames, getRunDirectory(), getSecondaryDirectory(), SUB_DIR + ".", ".", 0, WEAPON_WHEEL_NBR, new String[]{"blood.ini"}, R.drawable.blood,
                        "BLOOD", "Copy Blood files to:", "Put your BLOOD.GRP files here.txt");

        SubGame sg = SubGame.addGame(availableSubGames, getRunDirectory(), getSecondaryDirectory(), SUB_DIR, "addons/cryptic", 0, WEAPON_WHEEL_NBR, new String[]{"addons/cryptic/CP01.MAP", "addons/cryptic/cryptic.ini"}, R.drawable.raze,
                             "BLOOD: Cryptic Passage", "Copy your Cryptic Passage files to:", "Put your Cryptic Passage files here.txt");

        sg.setExtraArgs("-game_dir addons/cryptic -cryptic");

        addAddonsDir(engine, availableSubGames, new String[]{"cryptic"});

        super.updateSubGames(engine,availableSubGames);
    }
}
