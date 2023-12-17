import java.util.Arrays;

class PLR_STATS {
    /* =================================================================================================== */
    /* ============================= STABLE VALUES - STATED IN CONSTRUCTOR =============================== */
    /* =================================================================================================== */
    /* These stats contain variables (like ACCESSORIES) That affect the end result the same way, regardless the Armor &/or Sword chosen by the user.
      In other words they don't change depending on user-stated values */


    //POTATO BOOKS
    static final int HPSinglePB = 4;
    static final int DefSinglePB = 2;
    static final int DmgSinglePB = 2;
    static final int StrSinglePB = 2;
    static final int TN_HotAndFuming_PB = 15; //Total Number of Hot and Fuming Potato Books (1 item)

    //BASE PLAYER STATS
    static final float BasePlayerHP = 719.2F;
    static final float BasePlayerDef = 100F;
    static final float BasePlayerStr = 70;
    static final float BasePlayerCD = 57;
    static final float BasePlayerCC = 42.5F;
    static final float BasePlayerAtSp = 0;
    static final float BasePLayerFer = 0;
    static final float CombatSkill = 25;

    //PET STATS
    static final float PetStr = 60;
    static final float PetAtSp = 35;

    //EQUIPMENT STATS
    static final int EquipHP = 115;
    static final int EquipDef = 75;
    static final int EquipStr = 60;

    //STATS FROM REFORGES [WITHERED sword][SPIKED armor(stats are multiplied by a factor of 4)]
    static int ReWpnStr = 140;
    static int ReArmorStr = 40; // 4 * 10
    static int ReArmorCD = 40; // 4 * 10
    static int ReArmorCC = 40; // 4 * 10
    static int ReArmorAtSp = 16; // 4 * 4
    static int ReArmorHP = 32; // 4 * 8
    static int ReArmorDef = 32; // 4 * 8

    //POWER STONES
    static final float PwrStStr = 83F;
    static final float PwrStCD = 332F;
    static final float PwrStAtSp = 15F;

    //TUNING POINTS
    static final float TunPntsCD = 5F;
    static final float TunPntsAtSp = 12.3F;

    //POTIONS
    static float PotionCD = 30F;
    static float PotionCC = 20F;
    static float PotionStr = 75F;
    static float PotionDef = 55F;


    //MULTIPLIERS
    static float SupDrMLTPR = 1.00F; //Used by Superior Dragon Armor - * It's both a stable (1.00) & a user-stated value (usually 1.05) *
    static float ArmorDmgMLTPL = 1.00F;
    static float WpnEnchants = 5F; // One For All Ultimate Enchant


    /* =================================================================================================== */





    /* =================================================================================================== */
    /* ================================== UNSTABLE VALUES - STATED BY USER =============================== */
    /* =================================================================================================== */

    /* ITEM STRINGS */

    //METHOD 1 - USER MANUALLY ENTERS STATS
    static String Armor_Name_M1;
    static String Sword_Name_M1;

    //METHOD 2 - ITEM DESCRIPTION -> AUTOMATIC STATS INSERTION
    static String Armor_Name_M2;
    static String Armor_Reforge_M2;
    static String Sword_Name_M2;
    static String Sword_Reforge_M2;

    /*BASE ARMOR STATS*/
    //DEFENCIVE
    static int Base_Armor_HP;
    static int Base_Armor_Def;
    //OFFENSIVE
    static int Base_Armor_Str;
    static int Base_Armor_CD;
    static int Base_Armor_CC;

    /*WEAPON STATS*/
    static int Base_Wpn_Dmg;
    static int Base_Wpn_Str;
    static int Base_Wpn_CC;
    static int Base_Wpn_CD;



    /* =================================================================================================== */
    /* =================================  STATS CALCULATION  ============================================= */
    /* =================================================================================================== */

    //DEFENSIVE STATS

    static float HP() {
        return SupDrMLTPR * (HPSinglePB * 4 /*4items*/ * TN_HotAndFuming_PB) + BasePlayerHP + EquipHP + ReArmorHP + Base_Armor_HP;
    }

    static float Def() {
        return SupDrMLTPR * (DefSinglePB * 4 /*4items*/ * (TN_HotAndFuming_PB) + BasePlayerDef + EquipDef + ReArmorDef + PotionDef + Base_Armor_Def);
    }

    static float EHP() {
        return HP() * 1 * (Def() / 100);
    }

    static float LSB_Def() {
        return 1.25F * Def();
    }

    static float LSB_EHP() {
        return 0.6F * HP() * (1 + Def() / 100) + 0.4F * HP() * 1 + (LSB_Def() / 100);
    }


    //OFFENSIVE STATS
    static float Str() {
        return SupDrMLTPR * (StrSinglePB * (TN_HotAndFuming_PB) + BasePlayerStr + PetStr + EquipStr + ReArmorStr + PotionStr + Base_Wpn_Str + Base_Armor_Str);
    }

    static float CD() {
        return SupDrMLTPR * (BasePlayerCD + ReArmorCD + PwrStCD + TunPntsCD + PotionCD + Base_Wpn_CD + Base_Armor_CD);
    }

    static float CC() {
        return SupDrMLTPR * (BasePlayerCC + PotionCC + ReArmorCC + Base_Wpn_CC + Base_Armor_CC);
    }

    static float AtSp() {
        return SupDrMLTPR * (BasePlayerAtSp + PetAtSp + ReArmorAtSp + PwrStAtSp + TunPntsAtSp);
    }

    static float Fer() {
        return SupDrMLTPR * (BasePLayerFer);
    }


    //DETAILED DAMAGE STATS
    static float InDmg() {
        return (5 + (DmgSinglePB * TN_HotAndFuming_PB) + Base_Wpn_Dmg) * (1 + Str() / 100);
    }

    static float DmgMLTPR() {
        return SupFunc.getDmgMLTPR();
    }

    static float SHDmg() {
        return InDmg() * DmgMLTPR() * ArmorDmgMLTPL * (1 + CD() / 100);
    }

    static float DPS() {
        return SupFunc.getDps();
    }


    /* =================================================================================================== */
    /* ================================== TUTORIAL FUNCTION ============================================== */
    /* =================================================================================================== */

    void TUTORIAL(){Tutorial.getTutorial();};



    /* =================================================================================================== */
    /* ================================== OUT PUT FUNCTIONS ============================================== */
    /* =================================================================================================== */
    /* OUT PUT FUNCTION N1 - SHOWS ALL STABLE STATS */
    void ShowAllStableStats() {
        SupFunc.ChangeLine();
        System.out.println("""
                /* STABLE STATS
                 These stats contain variables (like ACCESSORIES) That affect the end result the same way, regardless the Armor &/or Sword chosen by the user.
                 [They don't change depending on user-stated values]. */""");
        SupFunc.ChangeLine();

        //POTATO BOOKS
        for (String string : Arrays.asList("//POTATO BOOKS", "HPSinglePB : " + HPSinglePB, "DefSinglePB : " + DefSinglePB, "DmgSinglePB : " + DmgSinglePB, "StrSinglePB : " + StrSinglePB, "Total Number of Hot And Fuming Potato Books (1 item): " + TN_HotAndFuming_PB)) {
            System.out.println(string);
        }
        SupFunc.ChangeLine();

        //BASE PLAYER STATS
        for (String string : Arrays.asList("//BASE PLAYER STATS", "BasePlayerHP : " + BasePlayerHP, "BasePlayerDef : " + BasePlayerDef, "BasePlayerStr : " + BasePlayerStr, "BasePlayerCD : " + BasePlayerCD, "BasePlayerCC : " + BasePlayerCC, "BasePlayerAtSp : " + BasePlayerAtSp, "CombatSkill : " + CombatSkill, "BasePLayerFer : " + BasePLayerFer, "WpnEnchants : " + WpnEnchants)) {
            System.out.println(string);
        }
        SupFunc.ChangeLine();

        //PET STATS
        for (String string : Arrays.asList("//PET STATS", "PetStr : " + PetStr, "PetAtSp : " + PetAtSp)) {
            System.out.println(string);
        }
        SupFunc.ChangeLine();

        //STATS FROM EQUIPMENT
        for (String string : Arrays.asList("//STATS FROM EQUIPMENT", "EquipHP : " + EquipHP, "EquipDef : " + EquipDef, "EquipStr : " + EquipStr)) {
            System.out.println(string);
        }
        SupFunc.ChangeLine();

        //STATS FROM REFORGES [Withered SWORD][SPIKED ARMOR(stats are multiplied by a factor of 4)]
        for (String s : Arrays.asList("//STATS FROM REFORGES [Withered SWORD][SPIKED ARMOR(stats are multiplied by a factor of 4)]", "ReWpnStr : " + ReWpnStr, "ReArmorStr : " + ReArmorStr, "ReArmorCD : " + ReArmorCD, "ReArmorCC : " + ReArmorCC, "ReArmorAtSp : " + ReArmorAtSp, "ReArmorHP : " + ReArmorHP, "ReArmorDef : " + ReArmorDef)) {
            System.out.println(s);
        }
        SupFunc.ChangeLine();

        //POWER STONES
        for (String s : Arrays.asList("//POWER STONES", "PwrStStr : " + PwrStStr, "PwrStCD : " + PwrStCD, "PwrStAtSp : " + PwrStAtSp)) {
            System.out.println(s);
        }
        SupFunc.ChangeLine();

        //TUNING POINTS
        for (String s : Arrays.asList("//TUNING POINTS", "TunPntsCD : " + TunPntsCD, "TunPntsAtSp : " + TunPntsAtSp)) {
            System.out.println(s);
        }
        SupFunc.ChangeLine();

        //POTIONS
        for (String s : Arrays.asList("//POTIONS", "PotionCD : " + PotionCD, "PotionCC : " + PotionCC, "PotionStr : " + PotionStr, "PotionDef : " + PotionDef)) {
            System.out.println(s);
        }
        SupFunc.ChangeLine();

        //MULTIPLIERS
        for (String s : Arrays.asList(" //MULTIPLIERS", "WpnEnchants : " + WpnEnchants, "ArmorDmgMLTPL : " + ArmorDmgMLTPL, "SupDrMLTPR : " + SupDrMLTPR)) {
            System.out.println(s);
        }
        SupFunc.ChangeLine();

        //NOTE FOR SupDrMLTPR VALUE
        System.out.println("""
                //NOTE FOR SupDrMLTPR VALUE:
                if Superior Dragon Armor is used, SupDrMLTPR must be equal to (1.05)
                Otherwise, for ALL OTHER Armor Sets, SupDrMLTPR must be equal to (1)""");
        SupFunc.ChangeLine();

        SupFunc.ChangeLine();
    }


    /* OUT PUT FUNCTION N2 - SHOWS ALL USER-STATED STATS */
    void ShowUserStatedStats() {

        //Counter Check
        if (SupFunc.CounterCheck() == 1) {
            return;
        }

        //Show Names
        SupFunc.ChangeLine();
        SupFunc.ShowNames();
        SupFunc.ChangeLine();

        //SUPERIOR DRAGON ARMOR MULTIPLIER
        System.out.println("SupDrMLTPR : " + SupDrMLTPR);
        SupFunc.ChangeLine();

        /* BASE ARMOR STATS */
        //DEFENSIVE
        for (String s : Arrays.asList("Base_Armor_HP : " + Base_Armor_HP, "Base_Armor_Def : " + Base_Armor_Def, "Base_Armor_Str : " + Base_Armor_Str, "Base_Armor_CD : " + Base_Armor_CD, "Base_Armor_CC : " + Base_Armor_CC)) {
            System.out.println(s);
        }

        //OFFENSIVE
        SupFunc.ChangeLine();

        /* WEAPON STATS */
        for (String s : Arrays.asList("Wpn_DMG : " + Base_Wpn_Dmg, "Wpn_Str : " + Base_Wpn_Str, "Wpn_CC : " + Base_Wpn_CC, "Wpn_CD : " + Base_Wpn_CD)) {
            System.out.println(s);
        }
        SupFunc.ChangeLine();

        SupFunc.ChangeLine();
    }


    /* OUT PUT FUNCTION N3 - SHOWS ALL PLAYER STATS [AFTER CALCULATIONS] */
    void ShowPlayerStats() {

        //Counter Check
        if (SupFunc.CounterCheck() == 1) {
            return;
        }

        //Show Names
        SupFunc.ChangeLine();
        SupFunc.ShowNames();
        SupFunc.ChangeLine();

        //SUPERIOR DRAGON ARMOR MULTIPLIER
        System.out.println("SupDrMLTPR : " + SupDrMLTPR);
        SupFunc.ChangeLine();

        /* STATS THAT GET CALCULATED BEFORE OR AFTER USER INPUTS DATA */
        //DEFENSIVE STATS
        for (String string : Arrays.asList("HP : " + HP(), "Def : " + Def(), "Effective Health Points: " + EHP(), "Def (WITH Last Stand Bonus): " + LSB_Def(), "Effective Health Points (WITH Last Stand Bonus): " + LSB_EHP())) {
            System.out.println(string);
        }
        SupFunc.ChangeLine();

        //OFFENSIVE STATS
        for (String s : Arrays.asList("Strength : " + Str(), "Critical Damage : " + CD(), "Critical Chance : " + CC(), "Attack Speed : " + AtSp(), "Ferocity : " + Fer())) {
            System.out.println(s);
        }
        SupFunc.ChangeLine();

        //STATS THAT GET CALCULATED AFTER CALCULATION
        for (String s : Arrays.asList("Initial Damage : " + InDmg(), "Damage multiplier : " + DmgMLTPR(), "Single Damage Hit : " + SHDmg(), "Damage Per Second (DPS) : " + DPS())) {
            System.out.println(s);
        }
        SupFunc.ChangeLine();

        SupFunc.ChangeLine();
    }
    /* =================================================================================================== */


    /* =================================================================================================== */
    /* ==================  STATS INSERTION AND VIABILITY TESTING [S.I.A.V.T.] [METHOD 1] ================= */
    /* =================================================================================================== */
    static int Counter_NonValidValues = 0;
    static int Counter_Armor = 0;
    static int Counter_Sword = 0;

    //S.I.A.V.T. FUNCTION N1 - STATING BASE ARMOR NAME & STATS [METHOD 1]
    void Input_Armor_Stats_Manually(String ArmorName, int BaseArmorHP, int BaseArmorDef, int BaseArmorStr, int BaseArmorCD, int BaseArmorCC) {
        //Used to check if you have only 1 armor described
        Counter_Armor++;
        //STAT CHECK
        int[] UserStated_ArmorStats = {BaseArmorHP, BaseArmorDef, BaseArmorStr, BaseArmorCD, BaseArmorCC};
        //IF STAT CHECK PASSED, APPOINT VALUES
        //System.out.println("Don't delete line. Else code doesn't work (idk why) : " + SupFunc.InnerStatCheck( UserStated_ArmorStats ));
        if (SupFunc.InnerStatCheck(UserStated_ArmorStats) == 0) {
            Armor_Name_M1 = ArmorName;
            Base_Armor_HP = BaseArmorHP;
            Base_Armor_Def = BaseArmorDef;
            Base_Armor_Str = BaseArmorStr;
            Base_Armor_CD = BaseArmorCD;
            Base_Armor_CC = BaseArmorCC;
        } else Counter_NonValidValues++;
    }

    //S.I.A.V.T. FUNCTION N2 - STATING WEAPON NAME & STATS [METHOD 1 - USER MANUALLY ENTERS STATS]
    void Input_Sword_Stats_Manually(String SwordName, int WpnDMG, int WpnStr, int WpnCC, int WpnCD) {
        //Used to check if you have only 1 sword described
        Counter_Sword++;
        //Reappoint Boolean Value to true
        //STAT CHECK
        int[] UserStated_SwordStats = {WpnDMG, WpnStr, WpnCC, WpnCD};
        //IF STAT CHECK PASSED, APPOINT VALUES
        //System.out.println("Don't delete line. Else code doesn't work (idk why) : " + SupFunc.InnerStatCheck( UserStated_SwordStats ));
        if (SupFunc.InnerStatCheck(UserStated_SwordStats) == 0) {
            Sword_Name_M1 = SwordName;
            Base_Wpn_Dmg = WpnDMG;
            Base_Wpn_Str = WpnStr;
            Base_Wpn_CC = WpnCC;
            Base_Wpn_CD = WpnCD;
        } else Counter_NonValidValues++;
    }



    /* =================================================================================================== */



    /* =================================================================================================== */
    /* ================  AUTOMATIC STATS INSERTION BY ITEM DESCRIPTION [METHOD 2]  ======================= */
    /* =================================================================================================== */


    void Input_Armor_Stats_By_Description(String ItemName, String ItemReforge){
        //Used to check if you have only 1 armor described
        Counter_Armor++;
        //boolean Values to check if viable names have been stated
        boolean End_M2_ArmorName = true;
        boolean End_M2_ArmorReforge = true;
        //code
        int I_NA = 0;
        switch (ItemName) {
            case "NONE" -> I_NA = 1;
            case "SUPERIOR_DRAGON" -> I_NA = 2;
            default -> {
                System.out.println("""
                                Please Insert Viable Armor Name :
                                [NONE]
                                [SUPERIOR_DRAGON]
                                (use any text inside the parenthesis)
                                """);
                Counter_NonValidValues++;
                End_M2_ArmorName = false;
            }
        }
        int I_RA = 0;
        switch (ItemReforge) {
            case "NONE" -> I_RA = 1;
            case "SPIKED" -> I_RA = 2;
            default -> {
                System.out.println("""
                                Please Insert Viable Armor Reforge Name :
                                [NONE]
                                [SPIKED]
                                (use any text inside the parenthesis)
                                """);
                Counter_NonValidValues++;
                End_M2_ArmorReforge = false;
            }
        }

        if (!End_M2_ArmorName) {return;}
        if (!End_M2_ArmorReforge) {return;}

        Armor_Name_M2 = ItemName;
        Armor_Reforge_M2 = ItemReforge;


        switch (I_NA) {
            case 1:
                break;
            case 2:
                Base_Armor_HP = 450;
                Base_Armor_Def = 600;
                Base_Armor_Str = 40;
                Base_Armor_CD = 40;
                Base_Armor_CC = 8;
                SupDrMLTPR = 1.05F;
                break;
        }

        switch (I_RA) {
            case 1:
                break;
            case 2:
                ReArmorHP = 32;
                ReArmorDef = 32;
                ReArmorStr = 40;
                ReArmorCD = 40;
                ReArmorCC = 40;
                ReArmorAtSp = 16;
                break;
        }

    }

    void Input_Sword_Stats_By_Description(String SwordName, String SwordReforge){
        //Used to check if you have only 1 sword described
        Counter_Sword++;
        //boolean Values to check if viable names have been stated
        boolean End_M2_SwordName = true;
        boolean End_M2_SwordReforge = true;
        //code
        int I_NS = 0;
        switch (SwordName) {
            case "NONE" -> I_NS = 1;
            case "ASPECT_OF_THE_DRAGONS" -> I_NS = 2;
            default -> {
                System.out.println("""
                                Please Insert Viable Sword Name :
                                [NONE]
                                [ASPECT_OF_THE_DRAGONS]
                                (use any text inside the parenthesis)
                                """);
                Counter_NonValidValues++;
                End_M2_SwordName = false;
            }
        }
        int I_RS = 0;
        switch (SwordReforge) {
            case "NONE" -> I_RS = 1;
            case "WITHERED" -> I_RS = 2;
            default -> {
                System.out.println("""
                                Please Insert Viable Sword Reforge Name :
                                [NONE]
                                [WITHERED]
                                (use any text inside the parenthesis)
                                """);
                Counter_NonValidValues++;
                End_M2_SwordReforge = false;
            }
        }

        if (!End_M2_SwordName) {
            return;
        }
        if (!End_M2_SwordReforge) {
            return;
        }

        Sword_Name_M2 = SwordName;
        Sword_Reforge_M2 = SwordReforge;


        switch (I_NS) {
            case 1:
                break;
            case 2:
                Base_Wpn_Dmg = 225;
                Base_Wpn_Str = 100;
                Base_Wpn_CD = 0;
                Base_Wpn_CC = 0;
                break;
        }

        switch (I_RS) {
            case 1:
                break;
            case 2:
                ReWpnStr = 140;
                break;
        }


    }








}


