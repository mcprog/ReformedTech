package com.mcprog.reformedtech.utility;

import com.mcprog.reformedtech.ReformedTechMod;
import net.minecraft.util.Identifier;

public class ReformedTechIdentifier extends Identifier {
    public ReformedTechIdentifier(String path) {
        super(ReformedTechMod.MODID, path);
    }
}
