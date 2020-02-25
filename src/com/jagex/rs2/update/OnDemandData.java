package com.jagex.rs2.update;

import com.jagex.rs2.node.NodeSub;



public final class OnDemandData extends NodeSub {

    public OnDemandData() {
        incomplete = true;
    }

    public int dataType;
    public byte buffer[];
    public int ID;
    public boolean incomplete;
    public int loopCycle;
}
