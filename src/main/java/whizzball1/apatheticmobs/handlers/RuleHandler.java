package whizzball1.apatheticmobs.handlers;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import whizzball1.apatheticmobs.ApatheticMobs;
import whizzball1.apatheticmobs.rules.Rule;

public class RuleHandler {

    @SubscribeEvent
    public void apathy(LivingSetAttackTargetEvent e) {
        if (!(e.getEntity().getEntityWorld().isRemote)) if (e.getTarget() instanceof PlayerEntity) {
            for (Rule rule : ApatheticMobs.rules.defaultRules) {
                if (rule.shouldExecute(e.getEntity())) if (!rule.execute(e.getEntity())) {
                    return;
                }
            }
            LivingEntity entity = e.getEntityLiving();
            if(entity instanceof VexEntity){
                VexEntity vex = (VexEntity)entity;
                if(vex.getOwner() != null){
                    return;
                }else {
                    vex.setAttackTarget(null);
                }
            }
            if (entity instanceof MobEntity && !(entity instanceof VexEntity)) {
                ((MobEntity) entity).setAttackTarget(null);
                //entity.setRevengeTarget(null);
            }
        }
    }

}
