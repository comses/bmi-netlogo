package net.comses.bmi.examples;

import org.nlogo.app.App;
import java.util.HashMap;

// wolf, sheep - energy Double[], location Double[][] 2 x N
// patches - count down Double[]


public class WolfSheep implements BMI {
    private static final String MODEL_NAME = "Wolf Sheep";
    private static final String[] INPUT_VAR_NAMES =
        {"wolf__energy", "sheep__energy", "patches__countdown", "wolf__location", "sheep__location"};
    private static final String[] OUTPUT_VAR_NAMES =
        {"wolf__energy", "sheep__energy", "patches__countdown", "wolf__location", "sheep__location"};
    
    private int tick = 0;
//    HashMap<String, AnyRef> values;

    public WolfSheep() {
        App.main();
    }

    @Override
    public String getComponentName() {
        return MODEL_NAME;
    }

    @Override
    public int getInputVarNameCount() {
        return INPUT_VAR_NAMES.length;
    }

    @Override
    public String[] getInputVarNames() {
        return INPUT_VAR_NAMES;
    }

    @Override
    public int getOutputVarNameCount() {
        return OUTPUT_VAR_NAMES.length;
    }

    @Override
    public String[] getOutputNames() {
        return OUTPUT_VAR_NAMES;
    }

    @Override
    public int getStartTime() {
        return 0;
    }

    @Override
    public int getCurrentTime() {
        return tick;
    }

    @Override
    public void intialize() {
        try {
            java.awt.EventQueue.invokeAndWait(
                    new Runnable() {
                        public void run() {
                            App.app().open("src/main/netlogo/WolfSheep.nlogo");
                        }
                    }
            );
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
        App.app().command("setup");
    }

    @Override
    public void finalize() {}

    @Override
    public void update() {
        App.app().command("go");
    }

//    public AnyRef getValue(String var_name) {
//        App.app().report();
//    }
//    public AnyRef getPatchCountdowns() {
//        return App.app().command("map [p -> [countdown] of p] (sort patches)");
//    }
//
//    public AnyRef getWolfEnergy() {
//        return App.app().command("map [w -> [energy] of w] (sort wolves)");
//    }
//
//    public getSheepEnery() {
//        return App.app().command("map [s -> [energy] of s] (sort sheep)");
//    }
//
//    public setValue(string var_name, Object src) {
//        App.app().command();
//    }
}