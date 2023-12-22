import java.util.Arrays;

class PLR_STATS {
    /* =================================================================================================== */
    /* ============================= STABLE VALUES - STATED IN CONSTRUCTOR =============================== */
    /* =================================================================================================== */
    /* These stats contain variables (like ACCESSORIES) That affect the end result the same way, regardless the Armor &/or Sword chosen by the user.
      In other words they don't change depending on user-stated values */

    /* FINAL VALUES - TRUE STABLES*/
    //POTATO BOOKS
    static final int HPSinglePB = 4;
    static final int DefSinglePB = 2;
    static final int DmgSinglePB = 2;
    static final int StrSinglePB = 2;
    static final int TN_HotAndFuming_PB = 15; //Total Number of Hot and Fuming Potato Books (1 item)

    /* SOON TO BE UNSTABLE VALUES ONCE YOU CAN INSERT VALUES AS USER */
    //BASE PLAYER STATS
    static float BasePlayerHP;
    static float BasePlayerDef;
    static float BasePlayerStr;
    static float BasePlayerCD;
    static float BasePlayerCC;
    static float BasePlayerAtSp;
    static float BasePLayerFer;
    static float CombatSkill;

    //PET STATS
    static float PetStr;
    static float PetAtSp;

    //EQUIPMENT STATS
    static int EquipHP;
    static int EquipDef;
    static int EquipStr;


    //POWER STONES
    static float PwrStStr;
    static float PwrStCD;
    static float PwrStAtSp;

    //TUNING POINTS
    static float TunPntsCD;
    static float TunPntsAtSp;

    //POTIONS
    static float PotionCD;
    static float PotionCC;
    static float PotionStr;
    static float PotionDef;


    //MULTIPLIERS
    static float SupDrMLTPR; //Used by Superior Dragon Armor - * It's both a stable (1.00) & a user-stated value (usually 1.05) *
    static float ArmorDmgMLTPL;
    static float WpnEnchants; // One For All Ultimate Enchant





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

    //STATS FROM REFORGES [each Armor Reforge is shown as single-item boost)]
    static int ReWpnStr;
    static int ReArmorStr;
    static int ReArmorCD;
    static int ReArmorCC;
    static int ReArmorAtSp;
    static int ReArmorHP;
    static int ReArmorDef;



    /* =================================================================================================== */
    /* ====================================  CONSTRUCTORS  =============================================== */
    /* =================================================================================================== */

    PLR_STATS(){

    }

    PLR_STATS(String STANDARD_STATS){
        if (STANDARD_STATS.equals("STANDARD_STATS")){
            //BASE PLAYER STATS
            BasePlayerHP = 719.2F;
            BasePlayerDef = 100F;
            BasePlayerStr = 70;
            BasePlayerCD = 57;
            BasePlayerCC = 42.5F;
            BasePlayerAtSp = 0;
            BasePLayerFer = 0;
            CombatSkill = 25;

            //PET STATS
            PetStr = 60;
            PetAtSp = 35;

            //EQUIPMENT STATS
            EquipHP = 115;
            EquipDef = 75;
            EquipStr = 60;


            //POWER STONES
            PwrStStr = 83F;
            PwrStCD = 332F;
            PwrStAtSp = 15F;

            //TUNING POINTS
            TunPntsCD = 5F;
            TunPntsAtSp = 12.3F;

            //POTIONS
            PotionCD = 30F;
            PotionCC = 20F;
            PotionStr = 75F;
            PotionDef = 55F;


            //MULTIPLIERS
            SupDrMLTPR = 1.00F; //Used by Superior Dragon Armor - * It's both a stable (1.00) & a user-stated value (usually 1.05) *
            ArmorDmgMLTPL = 1.00F;
            WpnEnchants = 5F; // One For All Ultimate Enchant

        }
        else return;
    }



    /* =================================================================================================== */
    /* =================================  STATS CALCULATION  ============================================= */
    /* =================================================================================================== */

    //DEFENSIVE STATS

    static float HP() {
        return SupDrMLTPR * (HPSinglePB * 4 /*4items*/ * TN_HotAndFuming_PB) + BasePlayerHP + EquipHP + (4 * ReArmorHP) + Base_Armor_HP;
    }

    static float Def() {
        return SupDrMLTPR * (DefSinglePB * 4 /*4items*/ * (TN_HotAndFuming_PB) + BasePlayerDef + EquipDef + (4 * ReArmorDef) + PotionDef + Base_Armor_Def);
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
        return SupDrMLTPR * ((StrSinglePB * (TN_HotAndFuming_PB)) + BasePlayerStr + PetStr + EquipStr + (4 /*4items*/ * ReArmorStr) + PotionStr + Base_Wpn_Str + Base_Armor_Str);
    }

    static float CD() {
        return SupDrMLTPR * (BasePlayerCD + (4  /*4items*/ * ReArmorCD) + PwrStCD + TunPntsCD + PotionCD  + Base_Armor_CD);
    }

    static float CC() {
        return SupDrMLTPR * (BasePlayerCC + PotionCC + (4  /*4items*/ * ReArmorCC) + Base_Armor_CC);
    }

    static float AtSp() {
        return SupDrMLTPR * (BasePlayerAtSp + PetAtSp + (4  /*4items*/ * ReArmorAtSp) + PwrStAtSp + TunPntsAtSp);
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
    /* ===================================== TUTORIAL/GET HELP FUNCTION ================================== */
    /* =================================================================================================== */

    void Welcome(){TextClass.getTutorial();};
    void GetHelp(int Number){
        switch (Number){
            case 0 -> TextClass.getHelp0();
            case 1 -> TextClass.getHelp1();
            case 2 -> TextClass.getHelp2();
            case 3 -> TextClass.getHelp3();
            case 4 -> TextClass.getHelp4();
            case 5 -> TextClass.getHelp5();
            case 6 -> TextClass.getHelp6();
            case 7 -> TextClass.getHelp7();
            default -> TextClass.getHelpdefault();
        }
    }



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
        for (String s : Arrays.asList("Base_Armor_HP : " + Base_Armor_HP, "Base_Armor_Def : " + Base_Armor_Def)) {
            System.out.println(s);
        }
        SupFunc.ChangeLine();

        //OFFENSIVE
        for (String s : Arrays.asList("Base_Armor_Str : " + Base_Armor_Str , "Base_Armor_CD : " + Base_Armor_CD , "Base_Armor_CC : " + Base_Armor_CC)) {
            System.out.println(s);
        }
        SupFunc.ChangeLine();

        /* WEAPON STATS */
        for (String s : Arrays.asList("Wpn_DMG : " + Base_Wpn_Dmg, "Wpn_Str : " + Base_Wpn_Str )) {
            System.out.println(s);
        }
        SupFunc.ChangeLine();

        //STATS FROM REFORGES  [each Armor Reforge is shown as single-item boost)]
        for (String s : Arrays.asList("//STATS FROM REFORGES [each Armor Reforge is shown as single-item boost)]", "ReWpnStr : " + ReWpnStr, "ReArmorStr : " + ReArmorStr, "ReArmorCD : " + ReArmorCD, "ReArmorCC : " + ReArmorCC, "ReArmorAtSp : " + ReArmorAtSp, "ReArmorHP : " + ReArmorHP, "ReArmorDef : " + ReArmorDef)) {
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
    /* =========================  STATS INSERTION AND VIABILITY TESTING [METHOD 1] ======================= */
    /* =================================================================================================== */

    /* Counters that check on user not surpassing described stats */
    static int Counter_NonValidValues = 0;
    static int Counter_Armor_Base_Stats = 0;
    static int Counter_Sword_Base_Stats = 0;
    static int Counter_Armor_Reforge_Stats = 0;
    static int Counter_Sword_Reforge_Stats = 0;


    //FUNCTION N1 - STATING BASE ARMOR NAME & STATS [METHOD 1]
    void Input_Armor_Stats_Manually(String ArmorName, int BaseArmorHP, int BaseArmorDef, int BaseArmorStr, int BaseArmorCD, int BaseArmorCC) {

        //Used to check if you have only 1 armor described
        Counter_Armor_Base_Stats++;

        //STAT CHECK
        int[] UserStated_ArmorStats = {BaseArmorHP, BaseArmorDef, BaseArmorStr, BaseArmorCD, BaseArmorCC};

        //IF STAT CHECK PASSED, APPOINT VALUES
        if (SupFunc.InnerStatCheck(UserStated_ArmorStats) == 0) {
            Armor_Name_M1 = ArmorName;
            Base_Armor_HP = BaseArmorHP;
            Base_Armor_Def = BaseArmorDef;
            Base_Armor_Str = BaseArmorStr;
            Base_Armor_CD = BaseArmorCD;
            Base_Armor_CC = BaseArmorCC;
        }

        else Counter_NonValidValues++;

    }

    //S.I.A.V.T. FUNCTION N2 - STATING WEAPON NAME & STATS [METHOD 1 - USER MANUALLY ENTERS STATS]
    void Input_Sword_Stats_Manually(String SwordName, int WpnDMG, int WpnStr) {

        //Used to check if you have only 1 sword described
        Counter_Sword_Base_Stats++;

        //STAT CHECK
        int[] UserStated_SwordStats = {WpnDMG, WpnStr};

        //IF STAT CHECK PASSED, APPOINT VALUES
        if (SupFunc.InnerStatCheck(UserStated_SwordStats) == 0) {
            Sword_Name_M1 = SwordName;
            Base_Wpn_Dmg = WpnDMG;
            Base_Wpn_Str = WpnStr;
        }

        else Counter_NonValidValues++;

    }

    //

    /*void Input_Pet_Stats_Manually(String PetName, int PetStr, int PetAtSp){
        ...
    }

    void Input_TuningPoints_Stats_Manually(...){
        ...
    }

    void Input_ReforgeStones_Stats_Manually(...){
        ...
    }*/





    /* =================================================================================================== */
    /* ================  AUTOMATIC STATS INSERTION BY ITEM DESCRIPTION [METHOD 2]  ======================= */
    /* =================================================================================================== */


    void Input_Armor_Stats_By_Description(String ArmorName, String ArmorReforge){

        //Used to check if you have only 1 instance were armor base/reforge stats are described
        Counter_Armor_Base_Stats++;
        Counter_Armor_Reforge_Stats++;

        //boolean Values to check if viable names have been stated
        boolean End_M2_ArmorName = true;
        boolean End_M2_ArmorReforge = true;


        int I_NA = 0;

        switch (ArmorName) {
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

        switch (ArmorReforge) {
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

        Armor_Name_M2 = ArmorName;
        Armor_Reforge_M2 = ArmorReforge;


        switch (I_NA) {
            case 1:
                //No Base Armor stats were stated. Therefore, we subtract -1 on the counter
                Counter_Armor_Base_Stats--;
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
                //No Reforge Armor stats were stated. Therefore, we subtract -1 on the counter
                Counter_Armor_Reforge_Stats--;
                break;
            case 2:
                ReArmorHP = 8;
                ReArmorDef = 8;
                ReArmorStr = 10;
                ReArmorCD = 10;
                ReArmorCC = 10;
                ReArmorAtSp = 4;
                break;
        }

    }

    void Input_Sword_Stats_By_Description(String SwordName, String SwordReforge){

        //Used to check if you have only 1 instance were sword base/reforge stats are described
        Counter_Sword_Base_Stats++;
        Counter_Sword_Reforge_Stats++;

        //boolean Values to check if viable names have been stated
        boolean End_M2_SwordName = true;
        boolean End_M2_SwordReforge = true;


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
                //No Base Sword stats were stated. Therefore, we subtract -1 on the counter
                Counter_Sword_Base_Stats--;
                break;
            case 2:
                Base_Wpn_Dmg = 225;
                Base_Wpn_Str = 100;
                break;
        }


        switch (I_RS) {
            case 1:
                //No Reforge Sword stats were stated. Therefore, we subtract -1 on the counter
                Counter_Sword_Reforge_Stats--;
                break;
            case 2:
                ReWpnStr = 140;
                break;
        }


    }




}

