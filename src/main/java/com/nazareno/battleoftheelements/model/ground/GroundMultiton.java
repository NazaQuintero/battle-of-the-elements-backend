package com.nazareno.battleoftheelements.model.ground;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroundMultiton {

    private static GroundMultiton instance;
    private static Map<String, Ground> groundsMap;

    private GroundMultiton() {
        groundsMap = Stream.of(new Object[][] {
                { "LAKE", new Lake() },
                { "VOLCANO", new Volcano() },
                { "CLIFF", new Cliff() },
                { "MOUNTAIN", new Mountain() },
                { "PATH", new Path() },
                { "VOID", new Void() },
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Ground) data[1]));
    }

    public static GroundMultiton getInstance() {
        if (instance == null) {
            instance = new GroundMultiton();
        }
        return instance;
    }

    public Ground getGround(String groundType) {
        return groundsMap.get(groundType);
    }
}
