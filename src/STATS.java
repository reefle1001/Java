class STATS {

    /* STABLE VALUES - STATED IN CONSTRUCTOR */
    /*These stats contain variables (like ACCESSORIES) That affect the end result the same way, regardless the Armor &/or Sword chosen by the user.
      In other words they don't change depending on user-stated values*/


    //POTATO BOOKS
    int HPSinglePB;
    int DefSinglePB;
    int DmgSinglePB;
    int StrSinglePB;
    int TNofHPB; //Total Number of Hot Potato Books (1 item)
    int TNofFPB; //Total Number of Fuming Potato Books (1 item)

    //BASE PLAYER STATS
    float BasePlayerHP;
    float BasePlayerDef;
    float BasePlayerStr;
    float BasePlayerCD;
    float BasePlayerCC;
    float BasePlayerAtSp;
    static int CombatSkill;
    float BasePLayerFer;

    //PET STATS
    float PetStr;
    float PetAtSp;

    //EQUIPMENT STATS
    int EquipHP;
    int EquipDef;
    int EquipStr;

    //STATS FROM REFORGES
    int ReWpnStr;
    int ReArmorStr;
    int ReArmorCD;
    int ReArmorCC;
    int ReArmorAtSp;
    int ReArmorHP;
    int ReArmorDef;

    //POWER STONES
    int PwrStStr;
    int PwrStCD;
    int PwrStAtSp;

    //TUNING POINTS
    float TunPntsCD;
    float TunPntsAtSp;

    // POTIONS
    float PotionCC;
    float PotionCD;
    float PotionStr;
    float PotionDef;

    //MULTIPLIERS
    static int WpnEnchants; // One For All Enchantment
    float ArmorDmgMLTPL;
    float SupDrMLTPR; //Used by Superior Dragon Armor - * It's both a stable (1.00) & a user-stated value (usually 1.05) *





    /* UNSTABLE VALUES - STATED BY USER */
    //MAKE SURE INTERNAL CHECK FUNCTION COVERS ALL VALUES STATED BY THE USER

    //ARMOR &/OR SWORD NAMES
    static String Armor_Name;
    static String Sword_Name;

    //BASE ARMOR STATS
    //DEFENCIVE
    int Base_Armor_HP;
    int Base_Armor_Def;
    //OFFENSIVE
    int Base_Armor_Str;
    int Base_Armor_CD;
    int Base_Armor_CC;

    //WEAPON STATS
    int Wpn_DMG;
    int Wpn_Str;
    int Wpn_CC;
    int Wpn_CD;



    //CONSTRUCTOR
    STATS() {
        /*STABLE STATS
        These stats contain variables (like ACCESSORIES) That affect the end result the same way, regardless the Armor &/or Sword chosen by the user.
        In other words they don't change depending on user-stated values*/

        //POTATO BOOKS
        HPSinglePB = 4;
        DefSinglePB = 2;
        DmgSinglePB = 2;
        StrSinglePB = 2;
        TNofHPB = 10;
        TNofFPB = 5;

        //BASE PLAYER STATS
        BasePlayerHP = 719.2F;
        BasePlayerDef = 100F;
        BasePlayerStr = 70;
        BasePlayerCD = 57;
        BasePlayerCC = 42.5F;
        BasePlayerAtSp = 0;
        BasePLayerFer = 0;
        CombatSkill = 25;
        WpnEnchants = 5; // One For All Ultimate Enchant

        //PET STATS
        PetStr = 60;
        PetAtSp = 35;

        //EQUIPMENT STATS
        EquipHP = 115;
        EquipDef = 75;
        EquipStr = 60;

        //STATS FROM REFORGES [Withered SWORD][SPIKED ARMOR(stats are multiplied by a factor of 4)]
        ReWpnStr = 140;
        ReArmorStr = 40; //4 * 10
        ReArmorCD = 40; //4 * 10
        ReArmorCC = 40; //4 * 10
        ReArmorAtSp = 16; //4 * 4
        ReArmorHP = 32; //4 * 8
        ReArmorDef = 32; //4 * 8

        //POWER STONES
        PwrStStr = 83;
        PwrStCD = 332;
        PwrStAtSp = 15;

        //TUNING POINTS
        TunPntsCD = 5F;
        TunPntsAtSp = 12.3F;

        //POTIONS
        PotionCD = 30;
        PotionCC = 20;
        PotionStr = 75;
        PotionDef = 55;

        //MULTIPLIERS
        SupDrMLTPR = 1.00F; // Used by Superior Dragon Armor - value 1 is the default one for all other armor sets
        ArmorDmgMLTPL = 1.00F;

    }


    //FUNCTIONS

    //FUNCTION N0 - SHOW ALL STABLE STATS
    void ShowAllStableStats() {
        ChangeLine();
        System.out.println("""
                /*STABLE STATS
                 These stats contain variables (like ACCESSORIES) That affect the end result the same way, regardless the Armor &/or Sword chosen by the user.
                 [They don't change depending on user-stated values].*/""");
        ChangeLine();

        //POTATO BOOKS
        System.out.println("//POTATO BOOKS");
        System.out.println("HPSinglePB : " + HPSinglePB);
        System.out.println("DefSinglePB : " + DefSinglePB);
        System.out.println("DmgSinglePB : " + DmgSinglePB);
        System.out.println("StrSinglePB : " + StrSinglePB);
        System.out.println("Total Number of Hot Potato Books (1 item): " + TNofHPB);
        System.out.println("Total Number of Fuming Potato Books (1 item): " + TNofFPB);
        ChangeLine();

        //BASE PLAYER STATS
        System.out.println("//BASE PLAYER STATS");
        System.out.println("BasePlayerHP : " + BasePlayerHP);
        System.out.println("BasePlayerDef : " + BasePlayerDef);
        System.out.println("BasePlayerStr : " + BasePlayerStr);
        System.out.println("BasePlayerCD : " + BasePlayerCD);
        System.out.println("BasePlayerCC : " + BasePlayerCC);
        System.out.println("BasePlayerAtSp : " + BasePlayerAtSp);
        System.out.println("CombatSkill : " + CombatSkill);
        System.out.println("BasePLayerFer : " + BasePLayerFer);
        System.out.println("WpnEnchants : " + WpnEnchants);
        ChangeLine();

        //PET STATS
        System.out.println("//PET STATS");
        System.out.println("PetStr : " + PetStr);
        System.out.println("PetAtSp : " + PetAtSp);
        ChangeLine();

        //STATS FROM EQUIPMENT
        System.out.println("//STATS FROM EQUIPMENT");
        System.out.println("EquipHP : " + EquipHP);
        System.out.println("EquipDef : " + EquipDef);
        System.out.println("EquipStr : " + EquipStr);
        ChangeLine();

        //STATS FROM REFORGES [Withered SWORD][SPIKED ARMOR(stats are multiplied by a factor of 4)]
        System.out.println("//STATS FROM REFORGES [Withered SWORD][SPIKED ARMOR(stats are multiplied by a factor of 4)]");
        System.out.println("ReWpnStr : " + ReWpnStr);
        System.out.println("ReArmorStr : " + ReArmorStr);
        System.out.println("ReArmorCD : " + ReArmorCD);
        System.out.println("ReArmorCC : " + ReArmorCC);
        System.out.println("ReArmorAtSp : " + ReArmorAtSp);
        System.out.println("ReArmorHP : " + ReArmorHP);
        System.out.println("ReArmorDef : " + ReArmorDef);
        ChangeLine();

        //POWER STONES
        System.out.println("//POWER STONES");
        System.out.println("PwrStStr : " + PwrStStr);
        System.out.println("PwrStCD : " + PwrStCD);
        System.out.println("PwrStAtSp : " + PwrStAtSp);
        ChangeLine();

        //TUNING POINTS
        System.out.println("//TUNING POINTS");
        System.out.println("TunPntsCD : " + TunPntsCD);
        System.out.println("TunPntsAtSp : " + TunPntsAtSp);
        ChangeLine();

        //POTIONS
        System.out.println("//POTIONS");
        System.out.println("PotionCD : " + PotionCD);
        System.out.println("PotionCC : " + PotionCC);
        System.out.println("PotionStr : " + PotionStr);
        System.out.println("PotionDef : " + PotionDef);
        ChangeLine();

        //MULTIPLIERS
        System.out.println(" //MULTIPLIERS");
        System.out.println("WpnEnchants : " + WpnEnchants);
        System.out.println("ArmorDmgMLTPL : " + ArmorDmgMLTPL);
        System.out.println("SupDrMLTPR : " + SupDrMLTPR);
        ChangeLine();

        //NOTE FOR SupDrMLTPR VALUE
        System.out.println("""
                //NOTE FOR SupDrMLTPR VALUE:
                if Superior Dragon Armor is used, SupDrMLTPR must be equal to (1.05)
                Otherwise, for ALL OTHER Armor Sets, SupDrMLTPR must be equal to (1)""");
        ChangeLine();

        ChangeLine();
    }

    /*

    void ShowPlayerStats(){
        ChangeLine();
        ShowNames();
        //SUPERIOR DRAGON ARMOR MULTIPLIER
        System.out.println("SupDrMLTPR : " + SupDrMLTPR);
        //STATS THAT GET CALCULATED BEFORE OR AFTER USER INPUTS DATA
        //DEFENSIVE STATS
        System.out.println("HP : " + HP);
        System.out.println("Def : " + Def);
        System.out.println("Effective Health Points: " + EHP);
        System.out.println("Def (WITH Last Stand Bonus): " + LSB_Def);
        System.out.println("Effective Health Points (WITH Last Stand Bonus): " + LSB_EHP);
        ChangeLine();

        //OFFENSIVE STATS
        System.out.println("Strength : " + Str);
        System.out.println("Critical Damage : " + CD);
        System.out.println("Critical Chance : " + CC);
        System.out.println("Attack Speed : " + AtSp);
        System.out.println("Ferocity : " + Fer);
        ChangeLine();

        //STATS THAT GET CALCULATED AFTER CALCULATION
        System.out.println("Initial Damage : " + InDmg);
        System.out.println("Damage multiplier : " + DmgMLTPR);
        System.out.println("Single Damage Hit : " + SHDmg);
        System.out.println("Damage Per Second (DPS) : " + DPS);
        ChangeLine();

        ChangeLine();
    }

    */



    //BOOLEAN VALUE FOR INTERNAL TEST - Checks if a nonviable value has been stated in input
    boolean test = true;


    //FUNCTION 3 - CHECKS THAT ALL VALUES (OF ARMOR AND/OR SWORD [OR NEITHER]) ARE VIABLE AND STATED
    private static void Show_Any_Armor_Or_Sword_Names() {
        String sNT = "Not Stated";
        if (Armor_Name == null && Sword_Name == null) PrintNames(sNT, sNT);
        else if (Armor_Name != null && Sword_Name != null) PrintNames(Armor_Name, Sword_Name);
        else if (Armor_Name != null /* && Sword_Name == null */) PrintNames(Armor_Name, sNT);
        else /* if ( Armor_Name == null && Sword_Name != null )*/ PrintNames(sNT, Sword_Name);
    }

    private static void PrintNames( String ArmorName, String SwordName ){
        System.out.println("Armor : " + ArmorName);
        System.out.println("Sword : " + SwordName);
    }

    private static void ChangeLine(){
        System.out.println(" ");
    }

    private static void ValueViability(float Value, boolean Test){
        if (Value < 0) {
            String str1, str2;
            str1 = String.valueOf(Value);
            str2 = String.format("Please change following nonviable value : " + str1);
            System.out.println(str2);
            Test = false;
        }
    }



    private static void InterStatCheck_SwordStats(float x1, float x2, float x3, float x4, boolean h){
        for (float v : new float[]{x1, x2, x3, x4}) {
            ValueViability (v, h);
        }
    }

    private static void InterStatCheck_ArmorStats(float x1, float x2, float x3, float x4, float x5, boolean h) {
        for (float v : new float[]{x1, x2, x3, x4, x5}) {
            ValueViability(v, h);
        }
    }



    //FUNCTION N1 - STATING BASE ARMOR NAME/STATS
    void Input_Armor_Stats(String ArmorName, int BaseArmorHP, int BaseArmorDef, int BaseArmorStr, int BaseArmorCD, int BaseArmorCC) {
        this.Armor_Name = ArmorName;
        this.Base_Armor_HP = BaseArmorHP;
        this.Base_Armor_Def = BaseArmorDef;
        this.Base_Armor_Str = BaseArmorStr;
        this.Base_Armor_CD = BaseArmorCD;
        this.Base_Armor_CC = BaseArmorCC;

        //ARMOR STATS
        InterStatCheck_ArmorStats( Base_Armor_HP, Base_Armor_Def, Base_Armor_Str, Base_Armor_CD, Base_Armor_CC, test );
    }


    //FUNCTION N2 - STATING WEAPON STATS
    void Input_Sword_Stats(String SwordName, int WpnDMG, int WpnStr, int WpnCC, int WpnCD) {
        this.Sword_Name = SwordName;
        this.Wpn_DMG = WpnDMG;
        this.Wpn_Str = WpnStr;
        this.Wpn_CC = WpnCC;
        this.Wpn_CD = WpnCD;

        //SWORD STATS
        InterStatCheck_SwordStats( Wpn_DMG , Wpn_Str , Wpn_CC , Wpn_CD , test );

    }


}



