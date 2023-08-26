package elucent.eidolon.codex;

import elucent.eidolon.capability.Facts;
import elucent.eidolon.codex.CruciblePage.CrucibleStep;
import elucent.eidolon.codex.IndexPage.FactLockedEntry;
import elucent.eidolon.codex.IndexPage.IndexEntry;
import elucent.eidolon.codex.IndexPage.ResearchLockedEntry;
import elucent.eidolon.codex.IndexPage.SignLockedEntry;
import elucent.eidolon.codex.ListPage.ListEntry;
import elucent.eidolon.codex.RitualPage.RitualIngredient;
import elucent.eidolon.codex.SignIndexPage.SignEntry;
import elucent.eidolon.registries.EidolonEntities;
import elucent.eidolon.registries.Registry;
import elucent.eidolon.registries.Researches;
import elucent.eidolon.ritual.RitualRegistry;
import elucent.eidolon.spell.Signs;
import elucent.eidolon.spell.Spells;
import elucent.eidolon.util.ColorUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CodexChapters {
    static public final List<Category> categories = new CopyOnWriteArrayList<>();
    static Category NATURE, RITUALS, ARTIFICE, THEURGY, SIGNS, RUNES, SPELLS;

    static Chapter NATURE_INDEX, MONSTERS, CRITTERS, ORES, PEWTER, ENCHANTED_ASH, PLANTS, RESEARCHS, DECORATIONS,
            RITUALS_INDEX, BRAZIER, ITEM_PROVIDERS, CRYSTAL_RITUAL, SUMMON_RITUAL, ALLURE_RITUAL, REPELLING_RITUAL, DECEIT_RITUAL, TIME_RITUALS, PURIFY_RITUAL, SANGUINE_RITUAL, RECHARGE_RITUAL, CAPTURE_RITUAL,
            ARTIFICE_INDEX, WOODEN_STAND, TALLOW, CRUCIBLE, ARCANE_GOLD, REAGENTS, SOUL_GEMS, SHADOW_GEM, WARPED_SPROUTS, BASIC_ALCHEMY, INLAYS, BASIC_BAUBLES, MAGIC_WORKBENCH, VOID_AMULET, WARDED_MAIL, SOULFIRE_WAND, BONECHILL_WAND, REAPER_SCYTHE, CLEAVING_AXE, SOUL_ENCHANTER, REVERSAL_PICK, WARLOCK_ARMOR, GRAVITY_BELT, PRESTIGIOUS_PALM, MIND_SHIELDING_PLATE, RESOLUTE_BELT, GLASS_HAND, SOULBONE, RAVEN_CLOAK, ARROW_RING, NECROMANCER_STAFF,
            THEURGY_INDEX, INTRO_SIGNS, EFFIGY, ALTARS, ALTAR_LIGHTS, ALTAR_SKULLS, ALTAR_HERBS, GOBLET, CENSER, DARK_PRAYER, ANIMAL_SACRIFICE, DARK_TOUCH, STONE_ALTAR, UNHOLY_EFFIGY, HOLY_EFFIGY, VILLAGER_SACRIFICE, LIGHT_PRAYER, INCENSE_BURN, HEAL, HOLY_TOUCH,
            SIGNS_INDEX, WICKED_SIGN, SACRED_SIGN, BLOOD_SIGN, SOUL_SIGN, MIND_SIGN, FLAME_SIGN, WINTER_SIGN, HARMONY_SIGN, DEATH_SIGN, WARDING_SIGN, MAGIC_SIGN,
            RUNES_INDEX,
            SPELLS_INDEX, MANA, LIGHT, FIRE_TOUCH, CHILL_TOUCH, ZOMBIFY, CURE_ZOMBIE, ENTHRALL, SMITE;

    public static void init() {

        //NATURE
        {
            MONSTERS = new Chapter(
                    "eidolon.codex.chapter.monsters",
                    new TitlePage("eidolon.codex.page.monsters.zombie_brute"),
                    new EntityPage(EidolonEntities.ZOMBIE_BRUTE.get()),
                    new TitlePage("eidolon.codex.page.monsters.wraith"),
                    new EntityPage(EidolonEntities.WRAITH.get()),
                    new TitlePage("eidolon.codex.page.monsters.chilled")
            );

            CRITTERS = new Chapter(
                    "eidolon.codex.chapter.critters",
                    new TitlePage("eidolon.codex.page.critters.raven"),
                    new EntityPage(EidolonEntities.RAVEN.get()),
                    new TitlePage("eidolon.codex.page.critters.slimy_slug"),
                    new EntityPage(EidolonEntities.SLIMY_SLUG.get())
            );

            ORES = new Chapter(
                    "eidolon.codex.chapter.ores",
                    new TitlePage("eidolon.codex.page.ores.lead_ore"),
                    new TitlePage("eidolon.codex.page.ores.silver_ore"),
                    new SmeltingPage(new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Registry.LEAD_ORE.get())),
                    new SmeltingPage(new ItemStack(Registry.SILVER_INGOT.get()), new ItemStack(Registry.SILVER_ORE.get())),

                    new CraftingPage(new ItemStack(Registry.LEAD_BLOCK.get()),
                            new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Registry.LEAD_INGOT.get()),
                            new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Registry.LEAD_INGOT.get()),
                            new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Registry.LEAD_INGOT.get())),
                    new CraftingPage(new ItemStack(Registry.SILVER_BLOCK.get()),
                            new ItemStack(Registry.SILVER_INGOT.get()), new ItemStack(Registry.SILVER_INGOT.get()), new ItemStack(Registry.SILVER_INGOT.get()),
                            new ItemStack(Registry.SILVER_INGOT.get()), new ItemStack(Registry.SILVER_INGOT.get()), new ItemStack(Registry.SILVER_INGOT.get()),
                            new ItemStack(Registry.SILVER_INGOT.get()), new ItemStack(Registry.SILVER_INGOT.get()), new ItemStack(Registry.SILVER_INGOT.get())),
                    new CraftingPage(new ItemStack(Registry.LEAD_NUGGET.get(), 9), new ItemStack(Registry.LEAD_INGOT.get())),
                    new CraftingPage(new ItemStack(Registry.SILVER_NUGGET.get(), 9), new ItemStack(Registry.SILVER_INGOT.get()))
            );

            PEWTER = new Chapter(
                    "eidolon.codex.chapter.pewter",
                    new TitlePage("eidolon.codex.page.pewter"),
                    new CraftingPage(new ItemStack(Registry.PEWTER_BLEND.get(), 2),
                            new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Items.IRON_INGOT)),
                    new SmeltingPage(new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_BLEND.get())),
                    new CraftingPage(new ItemStack(Registry.PEWTER_BLOCK.get()),
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()),
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()),
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get())),
                    new CraftingPage(new ItemStack(Registry.PEWTER_NUGGET.get(), 9), new ItemStack(Registry.PEWTER_INGOT.get()))
            );

            ENCHANTED_ASH = new Chapter(
                    "eidolon.codex.chapter.enchanted_ash",
                    new TitlePage("eidolon.codex.page.enchanted_ash"),
                    new SmeltingPage(new ItemStack(Registry.ENCHANTED_ASH.get(), 2), new ItemStack(Items.BONE))
            );

            PLANTS = new Chapter(
                    "eidolon.codex.chapter.plants",
                    new TitlePage("eidolon.codex.page.plants"),
                    new TextPage("eidolon.codex.page.plants.1"),
                    new WorktablePage(Registry.ATHAME.get().getDefaultInstance(), ItemStack.EMPTY, ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INGOT.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INLAY.get()), ItemStack.EMPTY,
                            Items.ENDER_PEARL.getDefaultInstance(), ItemStack.EMPTY, ItemStack.EMPTY,
                            Items.GOLD_NUGGET.getDefaultInstance(), ItemStack.EMPTY, new ItemStack(Registry.SILVER_NUGGET.get()), ItemStack.EMPTY
                    ),
                    new WorktablePage(Registry.PLANTER.get().asItem().getDefaultInstance(), new ItemStack(Registry.PEWTER_INGOT.get()), Items.DIRT.getDefaultInstance(), new ItemStack(Registry.PEWTER_INGOT.get()),
                            new ItemStack(Items.OAK_PLANKS), new ItemStack(Registry.PEWTER_INLAY.get()), new ItemStack(Items.OAK_PLANKS),
                            new ItemStack(Items.OAK_PLANKS), ItemStack.EMPTY, new ItemStack(Items.OAK_PLANKS),
                            new ItemStack(Registry.ENCHANTED_ASH.get()), ItemStack.EMPTY, new ItemStack(Registry.SOUL_SHARD.get()), ItemStack.EMPTY
                    )

            );

            RESEARCHS = new Chapter(
                    "eidolon.codex.chapter.researchs",
                    new TitlePage("eidolon.codex.page.researchs.0"),
                    new CraftingPage(Registry.RESEARCH_TABLE.get().asItem().getDefaultInstance(),
                            ItemStack.EMPTY, new ItemStack(Registry.MAGIC_CANDLE.get()), ItemStack.EMPTY,
                            new ItemStack(Items.RED_CARPET), new ItemStack(Items.RED_CARPET), new ItemStack(Items.RED_CARPET),
                            new ItemStack(Items.OAK_PLANKS), new ItemStack(Items.OAK_PLANKS), new ItemStack(Items.OAK_PLANKS)
                    ),
                    new CruciblePage(new ItemStack(Registry.MAGICIANS_WAX.get(), 4),
                            new CrucibleStep(new ItemStack(Registry.ENDER_CALX.get())),
                            new CrucibleStep(new ItemStack(Items.REDSTONE, 4), new ItemStack(Items.RED_DYE, 2)),
                            new CrucibleStep(2, new ItemStack(Registry.TALLOW.get()))
                    ),
                    new CraftingPage(new ItemStack(Registry.ARCANE_SEAL.get(), 2),
                            ItemStack.EMPTY, new ItemStack(Registry.MAGICIANS_WAX.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.MAGICIANS_WAX.get()), new ItemStack(Registry.MAGICIANS_WAX.get()), new ItemStack(Registry.MAGICIANS_WAX.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.MAGICIANS_WAX.get()), ItemStack.EMPTY
                    ),
                    new CruciblePage(new ItemStack(Registry.MAGIC_INK.get(), 2),
                            new CrucibleStep(new ItemStack(Items.GLOW_INK_SAC), new ItemStack(Items.BLACK_DYE, 2)),
                            new CrucibleStep(1, new ItemStack(Items.BLUE_DYE)),
                            new CrucibleStep(1, new ItemStack(Registry.SILVER_NUGGET.get(), 2)),
                            new CrucibleStep(new ItemStack(Items.GLASS_BOTTLE))
                    ),
                    new CruciblePage(new ItemStack(Registry.PARCHMENT.get(), 4),
                            new CrucibleStep(new ItemStack(Items.LEATHER)),
                            new CrucibleStep(1),
                            new CrucibleStep(1),
                            new CrucibleStep(new ItemStack(Items.PAPER, 3), new ItemStack(Registry.ENCHANTED_ASH.get()))
                    ),
                    new CraftingPage(new ItemStack(Registry.NOTETAKING_TOOLS.get()),
                            new ItemStack(Registry.PARCHMENT.get()), new ItemStack(Registry.MAGIC_INK.get()), ItemStack.EMPTY,
                            new ItemStack(Items.FEATHER), new ItemStack(Registry.ARCANE_GOLD_NUGGET.get()), ItemStack.EMPTY,
                            ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY
                    )

            );

            DECORATIONS = new Chapter(
                    "eidolon.codex.chapter.decorations",
                    new TitlePage("eidolon.codex.page.decorations"),
                    new CruciblePage(new ItemStack(Registry.ELDER_BRICK.get(), 16),
                            new CrucibleStep(new ItemStack(Blocks.MUD, 4)),
                            new CrucibleStep(1, new ItemStack(Registry.ENCHANTED_ASH.get()), new ItemStack(Registry.SOUL_SHARD.get()))
                    ),
                    new CraftingPage(new ItemStack(Registry.ELDER_BRICKS.getBlock(), 4),
                            new ItemStack(Registry.ELDER_BRICK.get()), new ItemStack(Registry.ELDER_BRICK.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.ELDER_BRICK.get()), new ItemStack(Registry.ELDER_BRICK.get()), ItemStack.EMPTY,
                            ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY
                    ),
                    new CraftingPage(new ItemStack(Registry.BONE_PILE.getBlock(), 1),
                            new ItemStack(Items.BONE), new ItemStack(Items.BONE), new ItemStack(Items.BONE),
                            new ItemStack(Items.BONE), new ItemStack(Items.BONE), new ItemStack(Items.BONE),
                            new ItemStack(Items.BONE), new ItemStack(Items.BONE), new ItemStack(Items.BONE)
                    )
            );

            NATURE_INDEX = new Chapter(
                    "eidolon.codex.chapter.nature_index",
                    new TitledIndexPage("eidolon.codex.page.nature_index.0",
                            new IndexEntry(MONSTERS, new ItemStack(Registry.TATTERED_CLOTH.get())),
                            new IndexEntry(CRITTERS, new ItemStack(Registry.RAVEN_FEATHER.get())),
                            new IndexEntry(ORES, new ItemStack(Registry.LEAD_ORE.get())),
                            new IndexEntry(PEWTER, new ItemStack(Registry.PEWTER_INGOT.get())),
                            new IndexEntry(ENCHANTED_ASH, new ItemStack(Registry.ENCHANTED_ASH.get())),
                            new IndexEntry(PLANTS, new ItemStack(Registry.OANNA_BLOOM.get()))
                    ),
                    new IndexPage(
                            new IndexEntry(RESEARCHS, new ItemStack(Registry.RESEARCH_TABLE.get())),
                            new IndexEntry(DECORATIONS, new ItemStack(Registry.ELDER_BRICKS_EYE.get()))
                    )
            );

            categories.add(NATURE = new Category(
                    "nature",
                    new ItemStack(Registry.ZOMBIE_HEART.get()),
                    ColorUtil.packColor(255, 89, 143, 76),
                    NATURE_INDEX
            ));
        }

        //RITUALS
        {
            BRAZIER = new Chapter(
                    "eidolon.codex.chapter.brazier",
                    new TitlePage("eidolon.codex.page.brazier.0"),
                    new TextPage("eidolon.codex.page.brazier.1"),
                    new CraftingPage(new ItemStack(Registry.BRAZIER.get()),
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()),
                            ItemStack.EMPTY, new ItemStack(Blocks.COAL_BLOCK), ItemStack.EMPTY,
                            new ItemStack(Items.STICK), ItemStack.EMPTY, new ItemStack(Items.STICK))
            );

            ITEM_PROVIDERS = new Chapter(
                    "eidolon.codex.chapter.item_providers",
                    new TitlePage("eidolon.codex.page.item_providers.0"),
                    new CraftingPage(new ItemStack(Registry.STONE_HAND.get()),
                            ItemStack.EMPTY, new ItemStack(Blocks.STONE_SLAB), ItemStack.EMPTY,
                            new ItemStack(Blocks.STONE_SLAB), new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONE_SLAB),
                            ItemStack.EMPTY, new ItemStack(Blocks.STONE), ItemStack.EMPTY),
                    new TitlePage("eidolon.codex.page.item_providers.1"),
                    new CraftingPage(new ItemStack(Registry.NECROTIC_FOCUS.get()),
                            new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONE),
                            new ItemStack(Blocks.STONE), new ItemStack(Items.BONE), new ItemStack(Blocks.STONE),
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INLAY.get()), new ItemStack(Registry.PEWTER_INGOT.get()))
            );

            CRYSTAL_RITUAL = new Chapter(
                    "eidolon.codex.chapter.crystal_ritual",
                    new TitledRitualPage("eidolon.codex.page.crystal_ritual", RitualRegistry.CRYSTAL_RITUAL, new ItemStack(Items.BONE_MEAL),
                            new RitualIngredient(new ItemStack(Items.REDSTONE), false),
                            new RitualIngredient(new ItemStack(Items.REDSTONE), false)),
                    new TextPage("eidolon.codex.page.crystal_ritual")
            );

            SUMMON_RITUAL = new Chapter(
                    "eidolon.codex.chapter.summon_ritual",
                    new TitledRitualPage("eidolon.codex.page.summon_ritual.0", RitualRegistry.SUMMON_ZOMBIE, new ItemStack(Items.CHARCOAL),
                            new RitualIngredient(new ItemStack(Items.ROTTEN_FLESH), false),
                            new RitualIngredient(new ItemStack(Items.ROTTEN_FLESH), true),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TextPage("eidolon.codex.page.summon_ritual.0"),
                    new TitledRitualPage("eidolon.codex.page.summon_ritual.1", RitualRegistry.SUMMON_SKELETON, new ItemStack(Items.CHARCOAL),
                            new RitualIngredient(new ItemStack(Items.BONE), false),
                            new RitualIngredient(new ItemStack(Items.BONE), true),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TitledRitualPage("eidolon.codex.page.summon_ritual.2", RitualRegistry.SUMMON_PHANTOM, new ItemStack(Items.CHARCOAL),
                            new RitualIngredient(new ItemStack(Items.PHANTOM_MEMBRANE), false),
                            new RitualIngredient(new ItemStack(Items.PHANTOM_MEMBRANE), true),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TitledRitualPage("eidolon.codex.page.summon_ritual.3", RitualRegistry.SUMMON_WITHER_SKELETON, new ItemStack(Items.CHARCOAL),
                            new RitualIngredient(new ItemStack(Items.BONE), false),
                            new RitualIngredient(new ItemStack(Blocks.SOUL_SAND), true),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TitledRitualPage("eidolon.codex.page.summon_ritual.4", RitualRegistry.SUMMON_HUSK, new ItemStack(Items.CHARCOAL),
                            new RitualIngredient(new ItemStack(Items.ROTTEN_FLESH), false),
                            new RitualIngredient(new ItemStack(Blocks.SAND), true),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TitledRitualPage("eidolon.codex.page.summon_ritual.5", RitualRegistry.SUMMON_DROWNED, new ItemStack(Items.CHARCOAL),
                            new RitualIngredient(new ItemStack(Items.ROTTEN_FLESH), false),
                            new RitualIngredient(new ItemStack(Items.PRISMARINE_SHARD), true),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TitledRitualPage("eidolon.codex.page.summon_ritual.6", RitualRegistry.SUMMON_STRAY, new ItemStack(Items.CHARCOAL),
                            new RitualIngredient(new ItemStack(Items.BONE), false),
                            new RitualIngredient(new ItemStack(Items.STRING), true),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TitledRitualPage("eidolon.codex.page.summon_ritual.7", RitualRegistry.SUMMON_WRAITH, new ItemStack(Items.CHARCOAL),
                            new RitualIngredient(new ItemStack(Registry.TATTERED_CLOTH.get()), false),
                            new RitualIngredient(new ItemStack(Registry.TATTERED_CLOTH.get()), true),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false))
            );

            ALLURE_RITUAL = new Chapter(
                    "eidolon.codex.chapter.allure_ritual",
                    new TitledRitualPage("eidolon.codex.page.allure_ritual", RitualRegistry.ALLURE_RITUAL, new ItemStack(Items.ROSE_BUSH),
                            new RitualIngredient(new ItemStack(Items.GOLDEN_APPLE), false),
                            new RitualIngredient(new ItemStack(Items.RED_DYE), false),
                            new RitualIngredient(new ItemStack(Items.RED_DYE), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TextPage("eidolon.codex.page.allure_ritual")
            );

            REPELLING_RITUAL = new Chapter(
                    "eidolon.codex.chapter.repelling_ritual",
                    new TitledRitualPage("eidolon.codex.page.repelling_ritual", RitualRegistry.REPELLING_RITUAL, new ItemStack(Items.NAUTILUS_SHELL),
                            new RitualIngredient(new ItemStack(Items.IRON_INGOT), false),
                            new RitualIngredient(new ItemStack(Items.LEATHER), false),
                            new RitualIngredient(new ItemStack(Items.QUARTZ), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TextPage("eidolon.codex.page.repelling_ritual")
            );

            DECEIT_RITUAL = new Chapter(
                    "eidolon.codex.chapter.deceit_ritual",
                    new TitledRitualPage("eidolon.codex.page.deceit_ritual", RitualRegistry.DECEIT_RITUAL, new ItemStack(Items.EMERALD),
                            new RitualIngredient(new ItemStack(Items.EMERALD), false),
                            new RitualIngredient(new ItemStack(Items.FERMENTED_SPIDER_EYE), false),
                            new RitualIngredient(new ItemStack(Items.RED_MUSHROOM), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TextPage("eidolon.codex.page.deceit_ritual")
            );

            TIME_RITUALS = new Chapter(
                    "eidolon.codex.chapter.time_rituals",
                    new TitledRitualPage("eidolon.codex.page.time_rituals.0", RitualRegistry.DAYLIGHT_RITUAL, new ItemStack(Items.SUNFLOWER),
                            new RitualIngredient(new ItemStack(Items.CHARCOAL), false),
                            new RitualIngredient(new ItemStack(Items.WHEAT_SEEDS), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TextPage("eidolon.codex.page.time_rituals.0"),
                    new TitledRitualPage("eidolon.codex.page.time_rituals.1", RitualRegistry.MOONLIGHT_RITUAL, new ItemStack(Items.BLACK_DYE),
                            new RitualIngredient(new ItemStack(Items.SNOWBALL), false),
                            new RitualIngredient(new ItemStack(Items.SPIDER_EYE), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TextPage("eidolon.codex.page.time_rituals.1")
            );

            PURIFY_RITUAL = new Chapter(
                    "eidolon.codex.chapter.purify_ritual",
                    new TitledRitualPage("eidolon.codex.page.purify_ritual", RitualRegistry.PURIFY_RITUAL, new ItemStack(Items.GLISTERING_MELON_SLICE),
                            new RitualIngredient(new ItemStack(Registry.ENCHANTED_ASH.get()), false),
                            new RitualIngredient(new ItemStack(Registry.ENCHANTED_ASH.get()), false),
                            new RitualIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.HEALING), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)),
                    new TextPage("eidolon.codex.page.purify_ritual")
            );

            SANGUINE_RITUAL = new Chapter(
                    "eidolon.codex.chapter.sanguine_ritual",
                    new TitledRitualPage("eidolon.codex.page.sanguine_ritual.0", RitualRegistry.SANGUINE_SWORD, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.HARMING),
                            new RitualIngredient(new ItemStack(Registry.SHADOW_GEM.get()), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false),
                            new RitualIngredient(new ItemStack(Items.IRON_SWORD), true),
                            new RitualIngredient(new ItemStack(Items.GHAST_TEAR), false),
                            new RitualIngredient(new ItemStack(Items.NETHER_WART), false),
                            new RitualIngredient(new ItemStack(Items.NETHER_WART), false)),
                    new TextPage("eidolon.codex.page.sanguine_ritual.0"),
                    new TitledRitualPage("eidolon.codex.page.sanguine_ritual.1", RitualRegistry.SANGUINE_AMULET, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.HARMING),
                            new RitualIngredient(new ItemStack(Items.REDSTONE), false),
                            new RitualIngredient(new ItemStack(Items.REDSTONE), false),
                            new RitualIngredient(new ItemStack(Items.DIAMOND), false),
                            new RitualIngredient(new ItemStack(Registry.BASIC_AMULET.get()), true),
                            new RitualIngredient(new ItemStack(Registry.LESSER_SOUL_GEM.get()), false),
                            new RitualIngredient(new ItemStack(Items.REDSTONE), false),
                            new RitualIngredient(new ItemStack(Items.REDSTONE), false)),
                    new TextPage("eidolon.codex.page.sanguine_ritual.1")
            );
            RECHARGE_RITUAL = new Chapter(
                    "eidolon.codex.chapter.recharge_ritual",
                    new TitledRitualPage("eidolon.codex.page.recharge_ritual.soulfire", RitualRegistry.RECHARGE_SOULFIRE_RITUAL, Registry.LESSER_SOUL_GEM.get().getDefaultInstance(),
                            new RitualIngredient(Items.BLAZE_POWDER.getDefaultInstance(), false),
                            new RitualIngredient(Items.BLAZE_POWDER.getDefaultInstance(), false),
                            new RitualIngredient(Registry.SOULFIRE_WAND.get().getDefaultInstance(), true),
                            new RitualIngredient(Items.REDSTONE.getDefaultInstance(), false)
                    ),
                    new TitledRitualPage("eidolon.codex.page.recharge_ritual.bonechill", RitualRegistry.RECHARGE_BONECHILL_RITUAL, Registry.LESSER_SOUL_GEM.get().getDefaultInstance(),
                            new RitualIngredient(Items.SNOWBALL.getDefaultInstance(), false),
                            new RitualIngredient(Items.SNOWBALL.getDefaultInstance(), false),
                            new RitualIngredient(Registry.BONECHILL_WAND.get().getDefaultInstance(), true),
                            new RitualIngredient(Items.REDSTONE.getDefaultInstance(), false)
                    ),
                    new TextPage("eidolon.codex.page.recharge_ritual")
            );
            CAPTURE_RITUAL = new Chapter(
                    "eidolon.codex.chapter.capture_ritual",
                    new TitledRitualPage("eidolon.codex.page.capture_ritual", RitualRegistry.ABSORB_RITUAL, new ItemStack(Registry.DEATH_ESSENCE.get()),
                            new RitualIngredient(new ItemStack(Registry.TATTERED_CLOTH.get()), false),
                            new RitualIngredient(new ItemStack(Registry.TATTERED_CLOTH.get()), false),
                            new RitualIngredient(new ItemStack(Items.BONE), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false),
                            new RitualIngredient(new ItemStack(Registry.SOUL_SHARD.get()), false)
                    ),
                    new TextPage("eidolon.codex.page.capture_ritual")
            );

            RITUALS_INDEX = new Chapter(
                    "eidolon.codex.chapter.rituals",
                    new TitledIndexPage("eidolon.codex.page.rituals.0",
                            new IndexEntry(BRAZIER, new ItemStack(Registry.BRAZIER.get())),
                            new IndexEntry(ITEM_PROVIDERS, new ItemStack(Registry.STONE_HAND.get())),
                            new IndexEntry(CRYSTAL_RITUAL, new ItemStack(Registry.SOUL_SHARD.get())),
                            new IndexEntry(SUMMON_RITUAL, new ItemStack(Items.ROTTEN_FLESH)),
                            new IndexEntry(ALLURE_RITUAL, new ItemStack(Items.CARROT_ON_A_STICK)),
                            new IndexEntry(REPELLING_RITUAL, new ItemStack(Items.SHIELD))
                    ),
                    new IndexPage(
                            new IndexEntry(DECEIT_RITUAL, new ItemStack(Items.EMERALD)),
                            new IndexEntry(TIME_RITUALS, new ItemStack(Items.CLOCK)),
                            new IndexEntry(PURIFY_RITUAL, new ItemStack(Items.GOLDEN_APPLE)),
                            new IndexEntry(SANGUINE_RITUAL, new ItemStack(Registry.SANGUINE_AMULET.get())),
                            new IndexEntry(RECHARGE_RITUAL, new ItemStack(Registry.SOULFIRE_WAND.get())),
                            new IndexEntry(CAPTURE_RITUAL, new ItemStack(Registry.SUMMONING_STAFF.get()))
                    )
            );

            categories.add(RITUALS = new Category(
                    "rituals",
                    new ItemStack(Registry.LESSER_SOUL_GEM.get()),
                    ColorUtil.packColor(255, 223, 178, 43),
                    RITUALS_INDEX
            ));

        }

        //ARTIFICE
        {

            WOODEN_STAND = new Chapter(
                    "eidolon.codex.chapter.wooden_stand",
                    new TitlePage("eidolon.codex.page.wooden_stand.0"),
                    new CraftingPage(new ItemStack(Registry.WOODEN_STAND.get()),
                            ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Items.STICK), ItemStack.EMPTY,
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get())),
                    new TitlePage("eidolon.codex.page.wooden_stand.1"),
                    new CruciblePage(new ItemStack(Registry.FUNGUS_SPROUTS.get(), 2),
                            new CrucibleStep(new ItemStack(Items.BROWN_MUSHROOM)),
                            new CrucibleStep(2, new ItemStack(Items.BONE_MEAL)),
                            new CrucibleStep(new ItemStack(Items.WHEAT_SEEDS)))
            );

            TALLOW = new Chapter(
                    "eidolon.codex.chapter.tallow",
                    new TitlePage("eidolon.codex.page.tallow.0"),
                    new SmeltingPage(new ItemStack(Registry.TALLOW.get()), new ItemStack(Items.ROTTEN_FLESH)),
                    new TitlePage("eidolon.codex.page.tallow.1"),
                    new CraftingPage(new ItemStack(Registry.CANDLE.get(), 4),
                            ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Items.STRING), ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Registry.TALLOW.get()), ItemStack.EMPTY),
                    new CraftingPage(new ItemStack(Registry.CANDLESTICK.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_NUGGET.get()), ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Registry.CANDLE.get()), ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_NUGGET.get()), ItemStack.EMPTY)
            );

            CRUCIBLE = new Chapter(
                    "eidolon.codex.chapter.crucible",
                    new TitlePage("eidolon.codex.page.crucible.0"),
                    new TextPage("eidolon.codex.page.crucible.1"),
                    new CraftingPage(new ItemStack(Registry.CRUCIBLE.get()),
                            new ItemStack(Registry.PEWTER_INGOT.get()), ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INGOT.get()),
                            new ItemStack(Registry.PEWTER_INGOT.get()), ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INGOT.get()),
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()))
            );

            ARCANE_GOLD = new Chapter(
                    "eidolon.codex.chapter.arcane_gold",
                    new TitlePage("eidolon.codex.page.arcane_gold"),
                    new CruciblePage(new ItemStack(Registry.ARCANE_GOLD_INGOT.get(), 2),
                            new CrucibleStep(new ItemStack(Items.REDSTONE, 2), new ItemStack(Registry.SOUL_SHARD.get())),
                            new CrucibleStep(new ItemStack(Items.GOLD_INGOT, 2))),
                    new CraftingPage(new ItemStack(Registry.ARCANE_GOLD_BLOCK.get()),
                            new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), new ItemStack(Registry.ARCANE_GOLD_INGOT.get()),
                            new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), new ItemStack(Registry.ARCANE_GOLD_INGOT.get()),
                            new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), new ItemStack(Registry.ARCANE_GOLD_INGOT.get())),
                    new CraftingPage(new ItemStack(Registry.ARCANE_GOLD_NUGGET.get(), 9), new ItemStack(Registry.ARCANE_GOLD_INGOT.get()))
            );

            REAGENTS = new Chapter(
                    "eidolon.codex.chapter.reagents",
                    new TitlePage("eidolon.codex.page.reagents.0"),
                    new CruciblePage(new ItemStack(Registry.SULFUR.get(), 2),
                            new CrucibleStep(new ItemStack(Items.COAL), new ItemStack(Registry.ENCHANTED_ASH.get()))),
                    new TitlePage("eidolon.codex.page.reagents.1"),
                    new CruciblePage(new ItemStack(Registry.DEATH_ESSENCE.get(), 4),
                            new CrucibleStep(new ItemStack(Registry.ZOMBIE_HEART.get()), new ItemStack(Items.ROTTEN_FLESH)),
                            new CrucibleStep(2, new ItemStack(Items.BONE_MEAL, 2)),
                            new CrucibleStep(new ItemStack(Items.CHARCOAL))),
                    new TitlePage("eidolon.codex.page.reagents.2"),
                    new CruciblePage(new ItemStack(Registry.CRIMSON_ESSENCE.get(), 4),
                            new CrucibleStep(new ItemStack(Blocks.CRIMSON_FUNGUS), new ItemStack(Items.NETHER_WART)),
                            new CrucibleStep(1, new ItemStack(Registry.SULFUR.get()))),
                    new CruciblePage(new ItemStack(Registry.CRIMSON_ESSENCE.get(), 2),
                            new CrucibleStep(new ItemStack(Blocks.CRIMSON_ROOTS), new ItemStack(Items.NETHER_WART)),
                            new CrucibleStep(1, new ItemStack(Registry.SULFUR.get()))),
                    new CruciblePage(new ItemStack(Registry.CRIMSON_ESSENCE.get(), 2),
                            new CrucibleStep(new ItemStack(Blocks.WEEPING_VINES), new ItemStack(Items.NETHER_WART)),
                            new CrucibleStep(1, new ItemStack(Registry.SULFUR.get()))),
                    new TitlePage("eidolon.codex.page.reagents.3"),
                    new CruciblePage(new ItemStack(Registry.ENDER_CALX.get(), 2),
                            new CrucibleStep(new ItemStack(Items.ENDER_PEARL), new ItemStack(Registry.ENCHANTED_ASH.get())))
            );

            SOUL_GEMS = new Chapter(
                    "eidolon.codex.chapter.soul_gems",
                    new TitlePage("eidolon.codex.page.soul_gems"),
                    new CruciblePage(new ItemStack(Registry.LESSER_SOUL_GEM.get()),
                            new CrucibleStep(new ItemStack(Items.REDSTONE, 2), new ItemStack(Items.LAPIS_LAZULI, 2)),
                            new CrucibleStep(2, new ItemStack(Registry.SOUL_SHARD.get(), 4)),
                            new CrucibleStep(new ItemStack(Items.QUARTZ)))
            );

            SHADOW_GEM = new Chapter(
                    "eidolon.codex.chapter.shadow_gem",
                    new TitlePage("eidolon.codex.page.shadow_gem"),
                    new CruciblePage(new ItemStack(Registry.SHADOW_GEM.get()),
                            new CrucibleStep(new ItemStack(Items.COAL)),
                            new CrucibleStep(1, new ItemStack(Items.GHAST_TEAR), new ItemStack(Registry.DEATH_ESSENCE.get())),
                            new CrucibleStep(1, new ItemStack(Registry.SOUL_SHARD.get(), 2), new ItemStack(Registry.DEATH_ESSENCE.get())),
                            new CrucibleStep(new ItemStack(Items.DIAMOND)))
            );

            WARPED_SPROUTS = new Chapter(
                    "eidolon.codex.chapter.warped_sprouts",
                    new TitlePage("eidolon.codex.page.warped_sprouts.0"),
                    new CruciblePage(new ItemStack(Registry.WARPED_SPROUTS.get(), 2),
                            new CrucibleStep(new ItemStack(Items.WARPED_FUNGUS)),
                            new CrucibleStep(2, new ItemStack(Registry.ENDER_CALX.get())),
                            new CrucibleStep(new ItemStack(Items.NETHER_WART))),
                    new TitlePage("eidolon.codex.page.warped_sprouts.1")
            );

            BASIC_ALCHEMY = new Chapter(
                    "eidolon.codex.chapter.basic_alchemy",
                    new TitlePage("eidolon.codex.page.basic_alchemy.0"),
                    new CruciblePage(new ItemStack(Items.LEATHER),
                            new CrucibleStep(new ItemStack(Registry.ENCHANTED_ASH.get(), 2)),
                            new CrucibleStep(2, new ItemStack(Items.ROTTEN_FLESH))),
                    new TitlePage("eidolon.codex.page.basic_alchemy.1"),
                    new CruciblePage(new ItemStack(Items.ROTTEN_FLESH),
                            new CrucibleStep(new ItemStack(Items.PORKCHOP), new ItemStack(Items.RED_MUSHROOM))),
                    new TitlePage("eidolon.codex.page.basic_alchemy.2"),
                    new CruciblePage(new ItemStack(Items.GUNPOWDER, 4),
                            new CrucibleStep(new ItemStack(Items.BONE_MEAL), new ItemStack(Registry.SULFUR.get())),
                            new CrucibleStep(1, new ItemStack(Items.CHARCOAL))),
                    new TitlePage("eidolon.codex.page.basic_alchemy.3"),
                    new CruciblePage(new ItemStack(Items.GOLDEN_APPLE),
                            new CrucibleStep(new ItemStack(Items.GOLD_INGOT, 2)),
                            new CrucibleStep(2, new ItemStack(Registry.ENCHANTED_ASH.get())),
                            new CrucibleStep(new ItemStack(Items.APPLE))),
                    new CruciblePage(new ItemStack(Items.GOLDEN_CARROT),
                            new CrucibleStep(new ItemStack(Items.GOLD_NUGGET, 2)),
                            new CrucibleStep(2, new ItemStack(Registry.ENCHANTED_ASH.get())),
                            new CrucibleStep(new ItemStack(Items.CARROT))),
                    new CruciblePage(new ItemStack(Items.GLISTERING_MELON_SLICE),
                            new CrucibleStep(new ItemStack(Items.GOLD_NUGGET, 2)),
                            new CrucibleStep(2, new ItemStack(Registry.ENCHANTED_ASH.get())),
                            new CrucibleStep(new ItemStack(Items.MELON_SLICE)))
            );

            INLAYS = new Chapter(
                    "eidolon.codex.chapter.inlays",
                    new TitlePage("eidolon.codex.page.inlays"),
                    new CraftingPage(new ItemStack(Registry.PEWTER_INLAY.get(), 2),
                            ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INGOT.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.PEWTER_INGOT.get()), ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INGOT.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INGOT.get()), ItemStack.EMPTY),
                    new CraftingPage(new ItemStack(Registry.GOLD_INLAY.get(), 2),
                            ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_INGOT.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), ItemStack.EMPTY)
            );

            BASIC_BAUBLES = new Chapter(
                    "eidolon.codex.chapter.basic_baubles",
                    new TitlePage("eidolon.codex.page.basic_baubles"),
                    new CraftingPage(new ItemStack(Registry.BASIC_AMULET.get()),
                            ItemStack.EMPTY, new ItemStack(Items.STRING), ItemStack.EMPTY,
                            new ItemStack(Items.STRING), ItemStack.EMPTY, new ItemStack(Items.STRING),
                            ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), ItemStack.EMPTY),
                    new CraftingPage(new ItemStack(Registry.BASIC_RING.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.SOUL_SHARD.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_INGOT.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), ItemStack.EMPTY),
                    new CraftingPage(new ItemStack(Registry.BASIC_BELT.get()),
                            ItemStack.EMPTY, new ItemStack(Items.LEATHER), ItemStack.EMPTY,
                            new ItemStack(Items.LEATHER), ItemStack.EMPTY, new ItemStack(Items.LEATHER),
                            ItemStack.EMPTY, new ItemStack(Items.LEATHER), ItemStack.EMPTY)
            );

            MAGIC_WORKBENCH = new Chapter(
                    "eidolon.codex.chapter.magic_workbench",
                    new TitlePage("eidolon.codex.page.magic_workbench"),
                    new CraftingPage(new ItemStack(Registry.WORKTABLE.get()),
                            new ItemStack(Blocks.RED_CARPET), new ItemStack(Blocks.RED_CARPET), new ItemStack(Blocks.RED_CARPET),
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Blocks.OAK_PLANKS), new ItemStack(Registry.PEWTER_INGOT.get()),
                            new ItemStack(Blocks.OAK_PLANKS), new ItemStack(Blocks.OAK_PLANKS), new ItemStack(Blocks.OAK_PLANKS))
            );

            VOID_AMULET = new Chapter(
                    "eidolon.codex.chapter.void_amulet",
                    new TitlePage("eidolon.codex.page.void_amulet"),
                    new WorktablePage(new ItemStack(Registry.VOID_AMULET.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INGOT.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.PEWTER_INLAY.get()), new ItemStack(Registry.BASIC_AMULET.get()), new ItemStack(Registry.PEWTER_INLAY.get()),
                            ItemStack.EMPTY, new ItemStack(Blocks.OBSIDIAN), ItemStack.EMPTY,
                            new ItemStack(Registry.SOUL_SHARD.get()), ItemStack.EMPTY, new ItemStack(Registry.SOUL_SHARD.get()), ItemStack.EMPTY)
            );

            WARDED_MAIL = new Chapter(
                    "eidolon.codex.chapter.warded_mail",
                    new TitlePage("eidolon.codex.page.warded_mail"),
                    new WorktablePage(new ItemStack(Registry.WARDED_MAIL.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.LESSER_SOUL_GEM.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.ENCHANTED_ASH.get()), new ItemStack(Items.IRON_CHESTPLATE), new ItemStack(Registry.ENCHANTED_ASH.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.ENCHANTED_ASH.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.PEWTER_INLAY.get()), new ItemStack(Registry.PEWTER_INLAY.get()), new ItemStack(Registry.PEWTER_INLAY.get()), new ItemStack(Registry.PEWTER_INLAY.get()))
            );

            SOULFIRE_WAND = new Chapter(
                    "eidolon.codex.chapter.soulfire_wand",
                    new TitlePage("eidolon.codex.page.soulfire_wand"),
                    new WorktablePage(new ItemStack(Registry.SOULFIRE_WAND.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), new ItemStack(Registry.SHADOW_GEM.get()),
                            ItemStack.EMPTY, new ItemStack(Items.STICK), new ItemStack(Registry.ARCANE_GOLD_INGOT.get()),
                            new ItemStack(Registry.GOLD_INLAY.get()), ItemStack.EMPTY, ItemStack.EMPTY,
                            new ItemStack(Registry.LESSER_SOUL_GEM.get()), new ItemStack(Items.BLAZE_POWDER), new ItemStack(Items.BLAZE_POWDER), new ItemStack(Items.BLAZE_POWDER))
            );

            BONECHILL_WAND = new Chapter(
                    "eidolon.codex.chapter.bonechill_wand",
                    new TitlePage("eidolon.codex.page.bonechill_wand"),
                    new WorktablePage(new ItemStack(Registry.BONECHILL_WAND.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.WRAITH_HEART.get()),
                            ItemStack.EMPTY, new ItemStack(Items.STICK), new ItemStack(Registry.PEWTER_INGOT.get()),
                            new ItemStack(Registry.PEWTER_INLAY.get()), ItemStack.EMPTY, ItemStack.EMPTY,
                            new ItemStack(Registry.LESSER_SOUL_GEM.get()), new ItemStack(Items.BONE_MEAL), new ItemStack(Items.BONE_MEAL), new ItemStack(Items.BONE_MEAL))
            );

            REAPER_SCYTHE = new Chapter(
                    "eidolon.codex.chapter.reaper_scythe",
                    new TitlePage("eidolon.codex.page.reaper_scythe"),
                    new WorktablePage(new ItemStack(Registry.REAPER_SCYTHE.get()),
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()), ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Items.STICK), new ItemStack(Registry.PEWTER_INGOT.get()),
                            new ItemStack(Items.STICK), ItemStack.EMPTY, ItemStack.EMPTY,
                            new ItemStack(Registry.UNHOLY_SYMBOL.get()), new ItemStack(Registry.TATTERED_CLOTH.get()), new ItemStack(Registry.SOUL_SHARD.get()), new ItemStack(Registry.TATTERED_CLOTH.get())),
                    new TitlePage("eidolon.codex.page.death_scythe"),
                    new WorktablePage(new ItemStack(Registry.DEATHBRINGER_SCYTHE.get()),
                            new ItemStack(Items.BONE), new ItemStack(Items.WITHER_SKELETON_SKULL), new ItemStack(Items.BONE),
                            new ItemStack(Items.BONE), new ItemStack(Registry.REAPER_SCYTHE.get()), new ItemStack(Items.BONE),
                            new ItemStack(Items.BONE), new ItemStack(Items.SKELETON_SKULL), new ItemStack(Items.BONE),
                            new ItemStack(Registry.SHADOW_GEM.get()), new ItemStack(Registry.DEATH_ESSENCE.get()), new ItemStack(Registry.SHADOW_GEM.get()), new ItemStack(Registry.DEATH_ESSENCE.get()))

            );

            CLEAVING_AXE = new Chapter(
                    "eidolon.codex.chapter.cleaving_axe",
                    new TitlePage("eidolon.codex.page.cleaving_axe"),
                    new WorktablePage(new ItemStack(Registry.CLEAVING_AXE.get()),
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Items.STICK), ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Items.STICK), ItemStack.EMPTY,
                            new ItemStack(Registry.UNHOLY_SYMBOL.get()), ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INLAY.get()), ItemStack.EMPTY)
            );

            SOUL_ENCHANTER = new Chapter(
                    "eidolon.codex.chapter.soul_enchanter",
                    new TitlePage("eidolon.codex.page.soul_enchanter.0"),
                    new TextPage("eidolon.codex.page.soul_enchanter.1"),
                    new WorktablePage(new ItemStack(Registry.SOUL_ENCHANTER.get()),
                            ItemStack.EMPTY, new ItemStack(Items.BOOK), ItemStack.EMPTY,
                            new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), new ItemStack(Blocks.OBSIDIAN), new ItemStack(Registry.ARCANE_GOLD_INGOT.get()),
                            new ItemStack(Blocks.OBSIDIAN), new ItemStack(Blocks.OBSIDIAN), new ItemStack(Blocks.OBSIDIAN),
                            new ItemStack(Items.DIAMOND), new ItemStack(Registry.GOLD_INLAY.get()), new ItemStack(Items.DIAMOND), new ItemStack(Registry.GOLD_INLAY.get()))
            );

            REVERSAL_PICK = new Chapter(
                    "eidolon.codex.chapter.reversal_pick",
                    new TitlePage("eidolon.codex.page.reversal_pick"),
                    new WorktablePage(new ItemStack(Registry.REVERSAL_PICK.get()),
                            new ItemStack(Blocks.OBSIDIAN), new ItemStack(Blocks.CRYING_OBSIDIAN), new ItemStack(Blocks.OBSIDIAN),
                            ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INGOT.get()), ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INLAY.get()), ItemStack.EMPTY,
                            new ItemStack(Items.ENDER_PEARL), new ItemStack(Registry.SOUL_SHARD.get()), new ItemStack(Registry.LESSER_SOUL_GEM.get()), new ItemStack(Registry.SOUL_SHARD.get()))
            );

            WARLOCK_ARMOR = new Chapter(
                    "eidolon.codex.chapter.warlock_armor",
                    new TitlePage("eidolon.codex.page.warlock_armor.0"),
                    new WorktablePage(new ItemStack(Registry.WICKED_WEAVE.get(), 8),
                            new ItemStack(Items.WHITE_WOOL), new ItemStack(Items.WHITE_WOOL), new ItemStack(Items.WHITE_WOOL),
                            new ItemStack(Items.WHITE_WOOL), new ItemStack(Registry.SHADOW_GEM.get()), new ItemStack(Items.WHITE_WOOL),
                            new ItemStack(Items.WHITE_WOOL), new ItemStack(Items.WHITE_WOOL), new ItemStack(Items.WHITE_WOOL),
                            new ItemStack(Registry.UNHOLY_SYMBOL.get()), ItemStack.EMPTY, new ItemStack(Items.BLUE_DYE), ItemStack.EMPTY),
                    new TitlePage("eidolon.codex.page.warlock_armor.1"),
                    new WorktablePage(new ItemStack(Registry.WARLOCK_HAT.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.WICKED_WEAVE.get()), ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Registry.WICKED_WEAVE.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.WICKED_WEAVE.get()), ItemStack.EMPTY, new ItemStack(Registry.WICKED_WEAVE.get()),
                            new ItemStack(Registry.SOUL_SHARD.get()), ItemStack.EMPTY, new ItemStack(Registry.SOUL_SHARD.get()), ItemStack.EMPTY),
                    new TitlePage("eidolon.codex.page.warlock_armor.2"),
                    new WorktablePage(new ItemStack(Registry.WARLOCK_CLOAK.get()),
                            new ItemStack(Registry.WICKED_WEAVE.get()), new ItemStack(Registry.WICKED_WEAVE.get()), new ItemStack(Registry.WICKED_WEAVE.get()),
                            new ItemStack(Registry.WICKED_WEAVE.get()), new ItemStack(Registry.WICKED_WEAVE.get()), new ItemStack(Registry.WICKED_WEAVE.get()),
                            new ItemStack(Registry.WICKED_WEAVE.get()), ItemStack.EMPTY, new ItemStack(Registry.WICKED_WEAVE.get()),
                            new ItemStack(Registry.SOUL_SHARD.get()), ItemStack.EMPTY, new ItemStack(Registry.SOUL_SHARD.get()), ItemStack.EMPTY),
                    new TitlePage("eidolon.codex.page.warlock_armor.3"),
                    new WorktablePage(new ItemStack(Registry.WARLOCK_BOOTS.get()),
                            ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY,
                            new ItemStack(Registry.WICKED_WEAVE.get()), ItemStack.EMPTY, new ItemStack(Registry.WICKED_WEAVE.get()),
                            new ItemStack(Registry.WICKED_WEAVE.get()), ItemStack.EMPTY, new ItemStack(Registry.WICKED_WEAVE.get()),
                            new ItemStack(Registry.SOUL_SHARD.get()), ItemStack.EMPTY, new ItemStack(Registry.SOUL_SHARD.get()), ItemStack.EMPTY)
            );

            GRAVITY_BELT = new Chapter(
                    "eidolon.codex.chapter.gravity_belt",
                    new TitlePage("eidolon.codex.page.gravity_belt"),
                    new WorktablePage(new ItemStack(Registry.GRAVITY_BELT.get()),
                            ItemStack.EMPTY, new ItemStack(Items.ENDER_PEARL), ItemStack.EMPTY,
                            new ItemStack(Items.FEATHER), new ItemStack(Registry.BASIC_BELT.get()), new ItemStack(Items.FEATHER),
                            ItemStack.EMPTY, new ItemStack(Registry.LESSER_SOUL_GEM.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.ENDER_CALX.get()), new ItemStack(Registry.PEWTER_INLAY.get()), new ItemStack(Registry.ENDER_CALX.get()), new ItemStack(Registry.PEWTER_INLAY.get()))
            );

            PRESTIGIOUS_PALM = new Chapter(
                    "eidolon.codex.chapter.prestigious_palm",
                    new TitlePage("eidolon.codex.page.prestigious_palm"),
                    new WorktablePage(new ItemStack(Registry.PRESTIGIOUS_PALM.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.WICKED_WEAVE.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.WICKED_WEAVE.get()), new ItemStack(Registry.WICKED_WEAVE.get()), new ItemStack(Registry.WICKED_WEAVE.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.LESSER_SOUL_GEM.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.WARPED_SPROUTS.get()), new ItemStack(Registry.ENDER_CALX.get()), new ItemStack(Registry.SOUL_SHARD.get()), new ItemStack(Registry.ENDER_CALX.get()))
            );

            MIND_SHIELDING_PLATE = new Chapter(
                    "eidolon.codex.chapter.mind_shielding_plate",
                    new TitlePage("eidolon.codex.page.mind_shielding_plate"),
                    new WorktablePage(new ItemStack(Registry.MIND_SHIELDING_PLATE.get()),
                            new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Registry.LEAD_INGOT.get()),
                            new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Registry.LEAD_INGOT.get()), new ItemStack(Registry.LEAD_INGOT.get()),
                            new ItemStack(Items.LEATHER), new ItemStack(Registry.SOUL_SHARD.get()), new ItemStack(Items.LEATHER),
                            new ItemStack(Items.LAPIS_BLOCK), ItemStack.EMPTY, new ItemStack(Items.QUARTZ), ItemStack.EMPTY)
            );

            RESOLUTE_BELT = new Chapter(
                    "eidolon.codex.chapter.resolute_belt",
                    new TitlePage("eidolon.codex.page.resolute_belt"),
                    new WorktablePage(new ItemStack(Registry.RESOLUTE_BELT.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.GOLD_INLAY.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), new ItemStack(Registry.BASIC_BELT.get()), new ItemStack(Registry.ARCANE_GOLD_INGOT.get()),
                            ItemStack.EMPTY, new ItemStack(Items.DIAMOND), ItemStack.EMPTY,
                            new ItemStack(Items.LEATHER), new ItemStack(Registry.SOUL_SHARD.get()), new ItemStack(Registry.ENCHANTED_ASH.get()), new ItemStack(Registry.SOUL_SHARD.get()))
            );

            GLASS_HAND = new Chapter(
                    "eidolon.codex.chapter.glass_hand",
                    new TitlePage("eidolon.codex.page.glass_hand"),
                    new WorktablePage(new ItemStack(Registry.GLASS_HAND.get()),
                            ItemStack.EMPTY, new ItemStack(Blocks.DIAMOND_BLOCK), ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Registry.BASIC_AMULET.get()), ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Blocks.GLASS), ItemStack.EMPTY,
                            new ItemStack(Registry.ZOMBIE_HEART.get()), new ItemStack(Registry.LESSER_SOUL_GEM.get()), new ItemStack(Registry.WRAITH_HEART.get()), new ItemStack(Registry.LESSER_SOUL_GEM.get()))
            );

            SOULBONE = new Chapter(
                    "eidolon.codex.chapter.soulbone_amulet",
                    new TitlePage("eidolon.codex.page.soulbone_amulet"),
                    new TitlePage("eidolon.codex.page.soulbone_amulet.1"),
                    new WorktablePage(new ItemStack(Registry.SOULBONE_AMULET.get()),
                            Items.BONE.getDefaultInstance(), new ItemStack(Registry.BASIC_AMULET.get()), Items.BONE.getDefaultInstance(),
                            Items.BONE.getDefaultInstance(), new ItemStack(Registry.WRAITH_HEART.get()), Items.BONE.getDefaultInstance(),
                            ItemStack.EMPTY, new ItemStack(Registry.SHADOW_GEM.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.ENDER_CALX.get()), new ItemStack(Registry.DEATH_ESSENCE.get()), new ItemStack(Registry.ENDER_CALX.get()), new ItemStack(Registry.DEATH_ESSENCE.get()))
            );

            //WIPS

            RAVEN_CLOAK = new Chapter("eidolon.codex.chapter.raven_cloak",
                    new TitlePage("eidolon.codex.page.raven_cloak"),
                    new WorktablePage(new ItemStack(Registry.RAVEN_CLOAK.get()),
                            new ItemStack(Registry.RAVEN_FEATHER.get()), ItemStack.EMPTY, new ItemStack(Registry.RAVEN_FEATHER.get()),
                            new ItemStack(Registry.WICKED_WEAVE.get()), new ItemStack(Registry.WICKED_WEAVE.get()), new ItemStack(Registry.WICKED_WEAVE.get()),
                            new ItemStack(Registry.TATTERED_CLOTH.get()), new ItemStack(Registry.GRAVITY_BELT.get()), new ItemStack(Registry.TATTERED_CLOTH.get()),
                            Items.PHANTOM_MEMBRANE.getDefaultInstance(), new ItemStack(Registry.RAVEN_FEATHER.get()), Items.PHANTOM_MEMBRANE.getDefaultInstance(), new ItemStack(Registry.RAVEN_FEATHER.get())
                    )
            );

            NECROMANCER_STAFF = new Chapter("eidolon.codex.chapter.summoning_staff",
                    new TitlePage("eidolon.codex.page.summoning_staff")
            );

            ARROW_RING = new Chapter("eidolon.codex.chapter.angel_sight",
                    new TitlePage("eidolon.codex.page.angel_sight"),
                    new WorktablePage(new ItemStack(Registry.ANGELS_SIGHT.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.SHADOW_GEM.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.BASIC_RING.get()), new ItemStack(Registry.PEWTER_INGOT.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.PEWTER_INGOT.get()), ItemStack.EMPTY,
                            Items.WITHER_SKELETON_SKULL.getDefaultInstance(), Items.ARROW.getDefaultInstance(), new ItemStack(Registry.UNHOLY_SYMBOL.get()), Items.ARROW.getDefaultInstance())
            );


            ARTIFICE_INDEX = new Chapter(
                    "eidolon.codex.chapter.artifice",
                    new TitledIndexPage("eidolon.codex.page.artifice",
                            new IndexEntry(WOODEN_STAND, new ItemStack(Registry.WOODEN_STAND.get())),
                            new IndexEntry(TALLOW, new ItemStack(Registry.TALLOW.get())),
                            new IndexEntry(CRUCIBLE, new ItemStack(Registry.CRUCIBLE.get())),
                            new IndexEntry(ARCANE_GOLD, new ItemStack(Registry.ARCANE_GOLD_INGOT.get())),
                            new IndexEntry(REAGENTS, new ItemStack(Registry.DEATH_ESSENCE.get())),
                            new IndexEntry(SOUL_GEMS, new ItemStack(Registry.LESSER_SOUL_GEM.get()))
                    ),
                    new IndexPage(
                            new IndexEntry(SHADOW_GEM, new ItemStack(Registry.SHADOW_GEM.get())),
                            new IndexEntry(BASIC_ALCHEMY, new ItemStack(Items.GUNPOWDER)),
                            new IndexEntry(WARPED_SPROUTS, new ItemStack(Registry.WARPED_SPROUTS.get())),
                            new IndexEntry(INLAYS, new ItemStack(Registry.GOLD_INLAY.get())),
                            new IndexEntry(BASIC_BAUBLES, new ItemStack(Registry.BASIC_RING.get())),
                            new IndexEntry(MAGIC_WORKBENCH, new ItemStack(Registry.WORKTABLE.get())),
                            new IndexEntry(VOID_AMULET, new ItemStack(Registry.VOID_AMULET.get()))
                    ),
                    new IndexPage(
                            new IndexEntry(WARDED_MAIL, new ItemStack(Registry.WARDED_MAIL.get())),
                            new IndexEntry(SOULFIRE_WAND, new ItemStack(Registry.SOULFIRE_WAND.get())),
                            new IndexEntry(BONECHILL_WAND, new ItemStack(Registry.BONECHILL_WAND.get())),
                            new IndexEntry(REAPER_SCYTHE, new ItemStack(Registry.REAPER_SCYTHE.get())),
                            new IndexEntry(CLEAVING_AXE, new ItemStack(Registry.CLEAVING_AXE.get())),
                            new IndexEntry(SOUL_ENCHANTER, new ItemStack(Registry.SOUL_ENCHANTER.get())),
                            new IndexEntry(REVERSAL_PICK, new ItemStack(Registry.REVERSAL_PICK.get()))
                    ),
                    new IndexPage(
                            new IndexEntry(WARLOCK_ARMOR, new ItemStack(Registry.WARLOCK_HAT.get())),
                            new IndexEntry(GRAVITY_BELT, new ItemStack(Registry.GRAVITY_BELT.get())),
                            new IndexEntry(PRESTIGIOUS_PALM, new ItemStack(Registry.PRESTIGIOUS_PALM.get())),
                            new IndexEntry(MIND_SHIELDING_PLATE, new ItemStack(Registry.MIND_SHIELDING_PLATE.get())),
                            new IndexEntry(RESOLUTE_BELT, new ItemStack(Registry.RESOLUTE_BELT.get())),
                            new IndexEntry(GLASS_HAND, new ItemStack(Registry.GLASS_HAND.get())),
                            new IndexEntry(SOULBONE, new ItemStack(Registry.SOULBONE_AMULET.get()))
                    ),
                    new IndexPage(
                            new IndexEntry(RAVEN_CLOAK, new ItemStack(Registry.RAVEN_CLOAK.get())),
                            new IndexEntry(NECROMANCER_STAFF, new ItemStack(Registry.SUMMONING_STAFF.get())),
                            new IndexEntry(ARROW_RING, new ItemStack(Registry.ANGELS_SIGHT.get()))
                    )
            );

            categories.add(ARTIFICE = new Category(
                    "artifice",
                    new ItemStack(Registry.GOLD_INLAY.get()),
                    ColorUtil.packColor(255, 204, 57, 72),
                    ARTIFICE_INDEX
            ));
        }

        //THEURGY
        {
            INTRO_SIGNS = new Chapter(
                    "eidolon.codex.chapter.intro_signs",
                    new TitlePage("eidolon.codex.page.intro_signs.0"),
                    new TextPage("eidolon.codex.page.intro_signs.1")
            );

            EFFIGY = new Chapter(
                    "eidolon.codex.chapter.effigy",
                    new TitlePage("eidolon.codex.page.effigy"),
                    new CraftingPage(new ItemStack(Registry.STRAW_EFFIGY.get()),
                            ItemStack.EMPTY, new ItemStack(Items.WHEAT), ItemStack.EMPTY,
                            new ItemStack(Items.WHEAT), new ItemStack(Items.WHEAT), new ItemStack(Items.WHEAT),
                            ItemStack.EMPTY, new ItemStack(Items.WHEAT), ItemStack.EMPTY)
            );

            ALTARS = new Chapter(
                    "eidolon.codex.chapter.altars",
                    new TitlePage("eidolon.codex.page.altars.0"),
                    new TextPage("eidolon.codex.page.altars.1"),
                    new CraftingPage(new ItemStack(Registry.WOODEN_ALTAR.get(), 3),
                            new ItemStack(Blocks.OAK_SLAB), new ItemStack(Blocks.OAK_SLAB), new ItemStack(Blocks.OAK_SLAB),
                            new ItemStack(Blocks.OAK_PLANKS), ItemStack.EMPTY, new ItemStack(Blocks.OAK_PLANKS),
                            new ItemStack(Blocks.OAK_PLANKS), ItemStack.EMPTY, new ItemStack(Blocks.OAK_PLANKS))
            );

            ALTAR_LIGHTS = new Chapter(
                    "eidolon.codex.chapter.altar_lights",
                    new TitlePage("eidolon.codex.page.altar_lights.0"),
                    new ListPage("eidolon.codex.page.altar_lights.1",
                            new ListEntry("torch", new ItemStack(Items.TORCH)),
                            new ListEntry("lantern", new ItemStack(Items.LANTERN)),
                            new ListEntry("candle", new ItemStack(Registry.CANDLE.get())),
                            new ListEntry("candlestick", new ItemStack(Registry.CANDLESTICK.get())))
            );

            ALTAR_SKULLS = new Chapter(
                    "eidolon.codex.chapter.altar_skulls",
                    new TitlePage("eidolon.codex.page.altar_skulls.0"),
                    new ListPage("eidolon.codex.page.altar_skulls.1",
                            new ListEntry("skull", new ItemStack(Items.SKELETON_SKULL)),
                            new ListEntry("zombie", new ItemStack(Items.ZOMBIE_HEAD)),
                            new ListEntry("wither_skull", new ItemStack(Items.WITHER_SKELETON_SKULL)))
            );

            ALTAR_HERBS = new Chapter(
                    "eidolon.codex.chapter.altar_herbs",
                    new TitlePage("eidolon.codex.page.altar_herbs.0"),
                    new ListPage("eidolon.codex.page.altar_herbs.1",
                            new ListEntry("crimson_fungus", new ItemStack(Items.CRIMSON_FUNGUS)),
                            new ListEntry("warped_fungus", new ItemStack(Items.WARPED_FUNGUS)),
                            new ListEntry("wither_rose", new ItemStack(Items.WITHER_ROSE)))
            );

            GOBLET = new Chapter(
                    "eidolon.codex.chapter.goblet",
                    new TitlePage("eidolon.codex.page.goblet"),
                    new CraftingPage(new ItemStack(Registry.GOBLET.get()),
                            new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_INGOT.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), ItemStack.EMPTY,
                            ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), ItemStack.EMPTY)
            );
            CENSER = new Chapter(
                    "eidolon.codex.chapter.censer",
                    new TitlePage("eidolon.codex.page.censer"),
                    new CraftingPage(new ItemStack(Registry.CENSER.get()),
                            ItemStack.EMPTY, new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), ItemStack.EMPTY,
                            new ItemStack(Registry.SILVER_INGOT.get()), ItemStack.EMPTY, new ItemStack(Registry.SILVER_INGOT.get()),
                            new ItemStack(Registry.ARCANE_GOLD_INGOT.get()), new ItemStack(Registry.PEWTER_INGOT.get()), new ItemStack(Registry.ARCANE_GOLD_INGOT.get()))
            );

            DARK_PRAYER = new Chapter(
                    "eidolon.codex.chapter.dark_prayer",
                    new ChantPage("eidolon.codex.page.dark_prayer.0", Spells.DARK_PRAYER.signs()),
                    new TextPage("eidolon.codex.page.dark_prayer.1")
            );
            LIGHT_PRAYER = new Chapter(
                    "eidolon.codex.chapter.light_prayer",
                    new ChantPage("eidolon.codex.page.light_prayer.0", Spells.LIGHT_PRAYER.signs()),
                    new TextPage("eidolon.codex.page.light_prayer.1")
            );


            ANIMAL_SACRIFICE = new Chapter(
                    "eidolon.codex.chapter.animal_sacrifice",
                    new ChantPage("eidolon.codex.page.animal_sacrifice", Spells.DARK_ANIMAL_SACRIFICE.signs())
            );

            INCENSE_BURN = new Chapter(
                    "eidolon.codex.chapter.censer_offering",
                    new TitlePage("eidolon.codex.page.censer_offering"),
                    new CruciblePage(new ItemStack(Registry.OFFERING_INCENSE.get(), 2),
                            new CrucibleStep(new ItemStack(Registry.MERAMMER_RESIN.get()), new ItemStack(Registry.ENCHANTED_ASH.get())),
                            new CrucibleStep(new ItemStack(Registry.OANNA_BLOOM.get(), 2)),
                            new CrucibleStep(2)
                    )
            );

            DARK_TOUCH = new Chapter(
                    "eidolon.codex.chapter.dark_touch",
                    new ChantPage("eidolon.codex.page.dark_touch.0", Spells.DARK_TOUCH.signs()),
                    new TextPage("eidolon.codex.page.dark_touch.1")
            );

            HOLY_TOUCH = new Chapter(
                    "eidolon.codex.chapter.holy_touch",
                    new ChantPage("eidolon.codex.page.holy_touch.0", Spells.HOLY_TOUCH.signs()),
                    new TextPage("eidolon.codex.page.holy_touch.1")
            );

            STONE_ALTAR = new Chapter(
                    "eidolon.codex.chapter.stone_altar",
                    new TitlePage("eidolon.codex.page.stone_altar"),
                    new WorktablePage(new ItemStack(Registry.STONE_ALTAR.get(), 3),
                            new ItemStack(Blocks.SMOOTH_STONE_SLAB), new ItemStack(Blocks.SMOOTH_STONE_SLAB), new ItemStack(Blocks.SMOOTH_STONE_SLAB),
                            new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONE),
                            new ItemStack(Blocks.STONE), new ItemStack(Registry.PEWTER_INLAY.get()), new ItemStack(Blocks.STONE),
                            new ItemStack(Registry.SOUL_SHARD.get()), ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY)
            );

            UNHOLY_EFFIGY = new Chapter(
                    "eidolon.codex.chapter.unholy_effigy",
                    new TitlePage("eidolon.codex.page.unholy_effigy"),
                    new WorktablePage(new ItemStack(Registry.ELDER_EFFIGY.get()),
                            ItemStack.EMPTY, new ItemStack(Blocks.SMOOTH_STONE), ItemStack.EMPTY,
                            new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONE),
                            ItemStack.EMPTY, new ItemStack(Blocks.STONE), ItemStack.EMPTY,
                            new ItemStack(Registry.UNHOLY_SYMBOL.get()), ItemStack.EMPTY, new ItemStack(Registry.GOLD_INLAY.get()), ItemStack.EMPTY)
            );

            HOLY_EFFIGY = new Chapter(
                    "eidolon.codex.chapter.holy_effigy",
                    new TitlePage("eidolon.codex.page.holy_effigy"),
                    new WorktablePage(new ItemStack(Registry.ELDER_EFFIGY.get()),
                            ItemStack.EMPTY, new ItemStack(Blocks.SMOOTH_STONE), ItemStack.EMPTY,
                            new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONE), new ItemStack(Blocks.STONE),
                            ItemStack.EMPTY, new ItemStack(Blocks.STONE), ItemStack.EMPTY,
                            new ItemStack(Registry.HOLY_SYMBOL.get()), ItemStack.EMPTY, new ItemStack(Registry.GOLD_INLAY.get()), ItemStack.EMPTY)
            );

            VILLAGER_SACRIFICE = new Chapter(
                    "eidolon.codex.chapter.villager_sacrifice",
                    new ChantPage("eidolon.codex.page.villager_sacrifice", Spells.DARK_VILLAGER_SACRIFICE.signs())
            );

            HEAL = new Chapter(
                    "eidolon.codex.chapter.lay_on_hands",
                    new ChantPage("eidolon.codex.page.lay_on_hands", Spells.LAY_ON_HANDS.signs())
            );

            THEURGY_INDEX = new Chapter(
                    "eidolon.codex.chapter.theurgy",
                    new TitledIndexPage(
                            "eidolon.codex.page.theurgy",
                            new IndexEntry(INTRO_SIGNS, new ItemStack(Items.PAPER)),
                            new IndexEntry(EFFIGY, new ItemStack(Registry.STRAW_EFFIGY.get())),
                            new IndexEntry(ALTARS, new ItemStack(Registry.WOODEN_ALTAR.get())),
                            new IndexEntry(ALTAR_LIGHTS, new ItemStack(Registry.CANDLE.get())),
                            new IndexEntry(ALTAR_SKULLS, new ItemStack(Items.SKELETON_SKULL)),
                            new IndexEntry(ALTAR_HERBS, new ItemStack(Items.WITHER_ROSE))
                    ),
                    new IndexPage(
                            new IndexEntry(GOBLET, new ItemStack(Registry.GOBLET.get())),
                            new SignLockedEntry(DARK_PRAYER, new ItemStack(Registry.SHADOW_GEM.get()), Signs.WICKED_SIGN),
                            new SignLockedEntry(ANIMAL_SACRIFICE, new ItemStack(Items.PORKCHOP), Signs.BLOOD_SIGN),
                            new SignLockedEntry(DARK_TOUCH, new ItemStack(Registry.UNHOLY_SYMBOL.get()), Signs.SOUL_SIGN, Signs.WICKED_SIGN),
                            new SignLockedEntry(STONE_ALTAR, new ItemStack(Registry.STONE_ALTAR.get()), Signs.SOUL_SIGN),
                            new SignLockedEntry(UNHOLY_EFFIGY, new ItemStack(Registry.ELDER_EFFIGY.get()), Signs.WICKED_SIGN, Signs.SOUL_SIGN),
                            new FactLockedEntry(VILLAGER_SACRIFICE, new ItemStack(Items.IRON_SWORD), Facts.VILLAGER_SACRIFICE)
                    ),
                    //TODO light path - EFFIGY
                    new IndexPage(
                            new IndexEntry(CENSER, new ItemStack(Registry.CENSER.get().asItem())),
                            new SignLockedEntry(LIGHT_PRAYER, new ItemStack(Registry.ENCHANTED_ASH.get()), Signs.SACRED_SIGN),
                            new SignLockedEntry(INCENSE_BURN, new ItemStack(Registry.OFFERING_INCENSE.get()), Signs.FLAME_SIGN),
                            new SignLockedEntry(HOLY_TOUCH, new ItemStack(Registry.HOLY_SYMBOL.get()), Signs.SOUL_SIGN, Signs.SACRED_SIGN),
                            new SignLockedEntry(STONE_ALTAR, new ItemStack(Registry.STONE_ALTAR.get()), Signs.SOUL_SIGN),
                            new SignLockedEntry(HOLY_EFFIGY, new ItemStack(Registry.ELDER_EFFIGY.get()), Signs.SACRED_SIGN, Signs.SOUL_SIGN),
                            new FactLockedEntry(HEAL, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.HEALING), Facts.VILLAGER_HEALING)
                    )
            );


            categories.add(THEURGY = new Category(
                    "theurgy",
                    new ItemStack(Registry.GOBLET.get()),
                    ColorUtil.packColor(255, 94, 90, 219),
                    THEURGY_INDEX
            ));

        }

        //SIGNS
        {
            WICKED_SIGN = new Chapter(
                    "eidolon.codex.chapter.wicked_sign",
                    new TitlePage("eidolon.codex.page.wicked_sign"),
                    new SignPage(Signs.WICKED_SIGN)
            );

            SACRED_SIGN = new Chapter(
                    "eidolon.codex.chapter.sacred_sign",
                    new TitlePage("eidolon.codex.page.sacred_sign"),
                    new SignPage(Signs.SACRED_SIGN)
            );

            BLOOD_SIGN = new Chapter(
                    "eidolon.codex.chapter.blood_sign",
                    new TitlePage("eidolon.codex.page.blood_sign"),
                    new SignPage(Signs.BLOOD_SIGN)
            );

            SOUL_SIGN = new Chapter(
                    "eidolon.codex.chapter.soul_sign",
                    new TitlePage("eidolon.codex.page.soul_sign"),
                    new SignPage(Signs.SOUL_SIGN)
            );

            MIND_SIGN = new Chapter(
                    "eidolon.codex.chapter.mind_sign",
                    new TitlePage("eidolon.codex.page.mind_sign"),
                    new SignPage(Signs.MIND_SIGN)
            );

            FLAME_SIGN = new Chapter(
                    "eidolon.codex.chapter.flame_sign",
                    new TitlePage("eidolon.codex.page.flame_sign"),
                    new SignPage(Signs.FLAME_SIGN)
            );

            WINTER_SIGN = new Chapter(
                    "eidolon.codex.chapter.winter_sign",
                    new TitlePage("eidolon.codex.page.winter_sign"),
                    new SignPage(Signs.WINTER_SIGN)
            );

            HARMONY_SIGN = new Chapter(
                    "eidolon.codex.chapter.harmony_sign",
                    new TitlePage("eidolon.codex.page.harmony_sign"),
                    new SignPage(Signs.HARMONY_SIGN)
            );

            DEATH_SIGN = new Chapter(
                    "eidolon.codex.chapter.death_sign",
                    new TitlePage("eidolon.codex.page.death_sign"),
                    new SignPage(Signs.DEATH_SIGN)
            );

            WARDING_SIGN = new Chapter(
                    "eidolon.codex.chapter.warding_sign",
                    new TitlePage("eidolon.codex.page.warding_sign"),
                    new SignPage(Signs.WARDING_SIGN)
            );

            MAGIC_SIGN = new Chapter(
                    "eidolon.codex.chapter.magic_sign",
                    new TitlePage("eidolon.codex.page.magic_sign"),
                    new SignPage(Signs.MAGIC_SIGN)
            );

            SIGNS_INDEX = new Chapter(
                    "eidolon.codex.chapter.signs_index",
                    new SignIndexPage(
                            new SignEntry(WICKED_SIGN, Signs.WICKED_SIGN),
                            new SignEntry(SACRED_SIGN, Signs.SACRED_SIGN),
                            new SignEntry(BLOOD_SIGN, Signs.BLOOD_SIGN),
                            new SignEntry(SOUL_SIGN, Signs.SOUL_SIGN),
                            new SignEntry(MIND_SIGN, Signs.MIND_SIGN),
                            new SignEntry(FLAME_SIGN, Signs.FLAME_SIGN)
                    ),
                    new SignIndexPage(
                            new SignEntry(WINTER_SIGN, Signs.WINTER_SIGN),
                            new SignEntry(MAGIC_SIGN, Signs.MAGIC_SIGN),
                            new SignEntry(HARMONY_SIGN, Signs.HARMONY_SIGN),
                            new SignEntry(DEATH_SIGN, Signs.DEATH_SIGN),
                            new SignEntry(WARDING_SIGN, Signs.WARDING_SIGN)
                    )
            );

            categories.add(SIGNS = new Category(
                    "signs",
                    new ItemStack(Registry.UNHOLY_SYMBOL.get()),
                    ColorUtil.packColor(255, 163, 74, 207),
                    SIGNS_INDEX
            ));
        }

        //SPELLS
        {
            MANA = new Chapter("eidolon.codex.chapter.mana",
                    new TitlePage("eidolon.codex.page.mana"));

            LIGHT = new Chapter(
                    "eidolon.codex.chapter.light",
                    new ChantPage("eidolon.codex.page.light", Spells.LIGHT_CHANT.signs())
            );
            FIRE_TOUCH = new Chapter(
                    "eidolon.codex.chapter.fire_touch",
                    new ChantPage("eidolon.codex.page.fire_touch", Spells.FIRE_CHANT.signs())
            );

            CHILL_TOUCH = new Chapter(
                    "eidolon.codex.chapter.chill_touch",
                    new ChantPage("eidolon.codex.page.chill_touch", Spells.FROST_CHANT.signs())
            );

            ZOMBIFY = new Chapter(
                    "eidolon.codex.chapter.villager_zombie",
                    new ChantPage("eidolon.codex.page.villager_zombie", Spells.ZOMBIFY.signs())
            );

            CURE_ZOMBIE = new Chapter(
                    "eidolon.codex.chapter.villager_cure",
                    new ChantPage("eidolon.codex.page.villager_cure", Spells.CURE_ZOMBIE_CHANT.signs())
            );

            ENTHRALL = new Chapter(
                    "eidolon.codex.chapter.enthrall",
                    new ChantPage("eidolon.codex.page.enthrall", Spells.ENTHRALL_UNDEAD.signs()),
                    new TextPage("eidolon.codex.page.enthrall.1")
            );

            SMITE = new Chapter(
                    "eidolon.codex.chapter.smite",
                    new ChantPage("eidolon.codex.page.smite", Spells.SMITE_CHANT.signs())
            );

            SPELLS_INDEX = new Chapter(
                    "eidolon.codex.chapter.spells",
                    new TitledIndexPage(
                            "eidolon.codex.page.spells",
                            new SignLockedEntry(LIGHT, new ItemStack(Items.LANTERN), Signs.FLAME_SIGN),
                            new ResearchLockedEntry(FIRE_TOUCH, new ItemStack(Items.FLINT_AND_STEEL), Researches.FIRE_SPELL),
                            new ResearchLockedEntry(CHILL_TOUCH, new ItemStack(Items.ICE), Researches.FROST_SPELL),
                            new FactLockedEntry(ZOMBIFY, new ItemStack(Registry.ZOMBIE_HEART.get()), Facts.ZOMBIFY),
                            new FactLockedEntry(CURE_ZOMBIE, new ItemStack(Items.GOLDEN_APPLE), Facts.ZOMBIE_CURE),
                            new FactLockedEntry(ENTHRALL, new ItemStack(Registry.SUMMONING_STAFF.get()), Facts.ENTHRALL),
                            new FactLockedEntry(SMITE, new ItemStack(Registry.SILVER_SWORD.get()), Facts.SMITE)
                    )
            );

            categories.add(SPELLS = new Category(
                    "spells",
                    new ItemStack(Registry.PARCHMENT.get()),
                    ColorUtil.packColor(255, 70, 70, 194),
                    SPELLS_INDEX
            ));
        }
    }
}
