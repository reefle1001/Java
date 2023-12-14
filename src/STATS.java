class STATS {

    /* STABLE VALUES - STATED IN CONSTRUCTOR */
    /*These stats contain variables (like ACCESSORIES) That affect the end result the same way, regardless the Armor &/or Sword chosen by the user.
      In other words they don't change depending on user-stated values*/


    //POTATO BOOKS
    static int HPSinglePB;
    static int DefSinglePB;
    static int DmgSinglePB;
    static int StrSinglePB;
    static int TNofHPB; //Total Number of Hot Potato Books (1 item)
    static int TNofFPB; //Total Number of Fuming Potato Books (1 item)

    //BASE PLAYER STATS
    static float BasePlayerHP;
    static float BasePlayerDef;
    static float BasePlayerStr;
    static float BasePlayerCD;
    static float BasePlayerCC;
    static float BasePlayerAtSp;
    static int CombatSkill;
    static float BasePLayerFer;

    //PET STATS
    static float PetStr;
    static float PetAtSp;

    //EQUIPMENT STATS
    static int EquipHP;
    static int EquipDef;
    static int EquipStr;

    //STATS FROM REFORGES
    static int ReWpnStr;
    static int ReArmorStr;
    static int ReArmorCD;
    static int ReArmorCC;
    static int ReArmorAtSp;
    static int ReArmorHP;
    static int ReArmorDef;

    //POWER STONES
    static int PwrStStr;
    static int PwrStCD;
    static int PwrStAtSp;

    //TUNING POINTS
    static float TunPntsCD;
    static float TunPntsAtSp;

    // POTIONS
    static float PotionCC;
    static float PotionCD;
    static float PotionStr;
    static float PotionDef;

    //MULTIPLIERS
    static int WpnEnchants; // One For All Enchantment
    static float ArmorDmgMLTPL;
    static float SupDrMLTPR; //Used by Superior Dragon Armor - * It's both a stable (1.00) & a user-stated value (usually 1.05) *





    /* UNSTABLE VALUES - STATED BY USER */
    //MAKE SURE INTERNAL CHECK FUNCTION COVERS ALL VALUES STATED BY THE USER

    //ARMOR &/OR SWORD NAMES
    static String Armor_Name;
    static String Sword_Name;

    //BASE ARMOR STATS
    //DEFENCIVE
    static int Base_Armor_HP;
    static int Base_Armor_Def;
    //OFFENSIVE
    static int Base_Armor_Str;
    static int Base_Armor_CD;
    static int Base_Armor_CC;

    //WEAPON STATS
    static int Wpn_DMG;
    static int Wpn_Str;
    static int Wpn_CC;
    static int Wpn_CD;



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



    void ShowPlayerStats(){
        ChangeLine();
        ShowNames();
        //SUPERIOR DRAGON ARMOR MULTIPLIER
        System.out.println("SupDrMLTPR : " + SupDrMLTPR);
        //STATS THAT GET CALCULATED BEFORE OR AFTER USER INPUTS DATA
        //DEFENSIVE STATS
        System.out.println("HP : " + HP());
        System.out.println("Def : " + Def());
        System.out.println("Effective Health Points: " + EHP());
        System.out.println("Def (WITH Last Stand Bonus): " + LSB_Def());
        System.out.println("Effective Health Points (WITH Last Stand Bonus): " + LSB_EHP());
        ChangeLine();

        //OFFENSIVE STATS
        System.out.println("Strength : " + Str());
        System.out.println("Critical Damage : " + CD());
        System.out.println("Critical Chance : " + CC());
        System.out.println("Attack Speed : " + AtSp());
        System.out.println("Ferocity : " + Fer());
        ChangeLine();

        //STATS THAT GET CALCULATED AFTER CALCULATION
        System.out.println("Initial Damage : " + InDmg());
        System.out.println("Damage multiplier : " + DmgMLTPR());
        System.out.println("Single Damage Hit : " + SHDmg());
        System.out.println("Damage Per Second (DPS) : " + DPS());
        ChangeLine();

        ChangeLine();
    }







    //FUNCTION 3 - CHECKS THAT ALL VALUES (OF ARMOR AND/OR SWORD [OR NEITHER]) ARE VIABLE AND STATED
    private static void ShowNames() {
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

    private static void ChangeLine(){System.out.println(" ");}

    private static void ValueViability(float Value){
        if (Value < 0) {
            String str1, str2;
            str1 = String.valueOf(Value);
            str2 = String.format("Please change following nonviable value : " + str1);
            System.out.println(str2);
        }
    }



    private static void InnerStatCheck_ArmorStats(float[] array) {
        for (float v : array) {
            ValueViability (v);
        }
    }

    private static void InnerStatCheck_SwordStats(float[] array){
        for (float v : array) {
            ValueViability (v);
        }
    }

    float[] UserStated_SwordStats = {Wpn_DMG, Wpn_Str, Wpn_CC, Wpn_CD};
    float[] UserStated_ArmorStats = {Base_Armor_HP, Base_Armor_Def, Base_Armor_Str, Base_Armor_CD, Base_Armor_CC};

    //FUNCTION N1 - STATING BASE ARMOR NAME/STATS
    void Input_Armor_Stats(String ArmorName, int BaseArmorHP, int BaseArmorDef, int BaseArmorStr, int BaseArmorCD, int BaseArmorCC) {
        Armor_Name = ArmorName;
        Base_Armor_HP = BaseArmorHP;
        Base_Armor_Def = BaseArmorDef;
        Base_Armor_Str = BaseArmorStr;
        Base_Armor_CD = BaseArmorCD;
        Base_Armor_CC = BaseArmorCC;
        //ARMOR STATS
        InnerStatCheck_ArmorStats( UserStated_ArmorStats );
    }

    //FUNCTION N2 - STATING WEAPON STATS
    void Input_Sword_Stats(String SwordName, int WpnDMG, int WpnStr, int WpnCC, int WpnCD) {
        Sword_Name = SwordName;
        Wpn_DMG = WpnDMG;
        Wpn_Str = WpnStr;
        Wpn_CC = WpnCC;
        Wpn_CD = WpnCD;
        //SWORD STATS
        InnerStatCheck_SwordStats( UserStated_SwordStats );
    }


    /* == Stats Calculation == */

    //DEFENSIVE STATS
    private static float HP() {return SupDrMLTPR * ((HPSinglePB * 4 * (TNofHPB + TNofFPB)) + BasePlayerHP + EquipHP + ReArmorHP + Base_Armor_HP ); /*4items*/}
    private static float Def() {return  SupDrMLTPR * ((DefSinglePB * 4 *(TNofHPB + TNofFPB)) + BasePlayerDef + EquipDef + ReArmorDef + PotionDef + Base_Armor_Def ); /*4items*/}
    private static float EHP() {return HP() * 1 * ( Def() / 100);}
    private static float LSB_Def() {return 1.25F * Def();}
    private static float LSB_EHP() {return 0.6F * HP() * (1 + Def() / 100) + 0.4F * HP() * 1 + (LSB_Def() / 100);}




    //OFFENSIVE STATS
    private static float Str() {return SupDrMLTPR * ((StrSinglePB * (TNofHPB + TNofFPB)) + BasePlayerStr + PetStr + EquipStr + ReArmorStr + PotionStr + Wpn_Str + Base_Armor_Str);}
    private static float CD() {return SupDrMLTPR * (BasePlayerCD + ReArmorCD +  PwrStCD + TunPntsCD + PotionCD + Wpn_CD + Base_Armor_CD);}
    private static float CC() {return SupDrMLTPR * (BasePlayerCC + PotionCC + ReArmorCC + Wpn_CC + Base_Armor_CC);}
    private static float AtSp() {return SupDrMLTPR * (BasePlayerAtSp + PetAtSp + ReArmorAtSp + PwrStAtSp + TunPntsAtSp);}
    private static float Fer() {return SupDrMLTPR * (BasePLayerFer);}


    //DETAILED DAMAGE STATS
    private static float InDmg() {return (5 + (DmgSinglePB * (TNofHPB+TNofFPB)) + Wpn_DMG)*(1+Str()/100);}
    private static float DmgMLTPR(){
        float DmgMLTPR;
        if (CombatSkill<=50)
            DmgMLTPR = 1 + ( CombatSkill * 0.04F ) + WpnEnchants;
        else
            DmgMLTPR = 1 + ( 50 * 0.04F + ( CombatSkill - 50 ) * 0.01F ) + WpnEnchants;
    return (DmgMLTPR);}
    private static float SHDmg() {return InDmg() * DmgMLTPR() * ArmorDmgMLTPL * ( 1 + CD() / 100 );}
    private static float DPS() {
        float DPS;
        int InvTicks = 0; //Invulnerability Ticks
        float InvTime; //Invulnerability Time
        //Invulnerability ticks Depending on Attack Speed
        if (AtSp() >= -13 && AtSp() <= -5 ) InvTicks = 11;
        else if (AtSp() >= -4 && AtSp() <= 5 ) InvTicks = 10;
        else if (AtSp() >= 6 && AtSp() <= 17 ) InvTicks = 9;
        else if (AtSp() >= 18 && AtSp() <= 33 ) InvTicks = 8;
        else if (AtSp() >= 34 && AtSp() <= 53 ) InvTicks = 7;
        else if (AtSp() >= 54 && AtSp() <= 81 ) InvTicks = 6;
        else if (AtSp() >= 82 && AtSp() <= 100 ) InvTicks = 5;
        //Calculating Invulnerability timing
        InvTime = InvTicks * 0.05F;
        //Calculating DPS
        DPS = SHDmg() * ( 1 / InvTime );
        return DPS;
    }



}



