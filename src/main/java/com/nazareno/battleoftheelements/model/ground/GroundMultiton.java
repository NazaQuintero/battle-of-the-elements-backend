package com.nazareno.battleoftheelements.model.ground;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.nazareno.battleoftheelements.model.ground.GroundType.*;

public class GroundMultiton {

    private static GroundMultiton instance;
    private static Map<String, Ground> groundsMap;

    private GroundMultiton() {
        groundsMap = Stream.of(new Object[][] {
                { LAKE.toString(), new Lake() },
                { VOLCANO.toString(), new Volcano() },
                { CLIFF.toString(), new Cliff() },
                { MOUNTAIN.toString(), new Mountain() },
                { PATH.toString(), new Path() },
                { VOID.toString(), new Void() },
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Ground) data[1]));
    }

    public static GroundMultiton getInstance() {
        if (instance == null) {
            instance = new GroundMultiton();
        }
        return instance;
    }

    public Ground getGround(GroundType groundType) {
        return groundsMap.get(groundType.toString());
    }
}
