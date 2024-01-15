package com.gmail.nossr50;

import com.gmail.nossr50.datatypes.experience.SkillXpGain;
import com.gmail.nossr50.datatypes.skills.PrimarySkillType;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.DelayQueue;

public class KiocgFix {
    private static final Map<UUID, DelayQueue<SkillXpGain>> playerGainedSkillsXp = new HashMap<>();
    private static final Map<UUID, Map<PrimarySkillType, Float>> playerRollingSkillsXp = new HashMap<>();

    public static DelayQueue<SkillXpGain> getGainedSkillsXp(final UUID uuid) {
        return playerGainedSkillsXp.computeIfAbsent(uuid, key -> new DelayQueue<>());
    }

    public static Map<PrimarySkillType, Float> getRollingSkillsXp(final UUID uuid) {
        return playerRollingSkillsXp.computeIfAbsent(uuid, key -> new EnumMap<>(PrimarySkillType.class));
    }
}
