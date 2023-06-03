package elucent.eidolon.datagen;

import elucent.eidolon.Eidolon;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

@Mod.EventBusSubscriber(modid = Eidolon.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Datagen {

    //use runData configuration to generate stuff, event.includeServer() for data, event.includeClient() for assets
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();

        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        gen.addProvider(event.includeServer(), new EidItemTagProvider(gen, new dummy(gen, fileHelper), fileHelper));

    }

    static class dummy extends BlockTagsProvider {

        public dummy(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, Eidolon.MODID, existingFileHelper);
        }

        @Override
        protected void addTags() {
        }
    }
}