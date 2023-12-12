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
    int CombatSkill;
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
    int WpnEnchants; // One For All Enchantment
    float ArmorDmgMLTPL;






    /* UNSTABLE VALUES - STATED BY USER */
    //MAKE SURE INTERNAL CHECK FUNCTION COVERS ALL VALUES STATED BY THE USER

    //ARMOR &/OR SWORD NAMES
    String Armor_Name;
    String Sword_Name;

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

    //MULTIPLIERS
    float SupDrMLTPR; //Used by Superior Dragon Armor



    /* STATS THAT GET CALCULATED BEFORE OR/AFTER USER INPUTS DATA */
    //DEFENSIVE STATS
    float HP;
    float Def;
    float EHP;
    float Str;
    float CD;
    float CC;
    float AtSp;
    float Fer;


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

        /* STATS THAT GET CALCULATED BEFORE OR/AFTER USER INPUTS DATA */
        //DEFENSIVE STATS
        HP = SupDrMLTPR * ((HPSinglePB * 4 * (TNofHPB + TNofFPB)) + BasePlayerHP + EquipHP + ReArmorHP + Base_Armor_HP); //4 items
        Def = SupDrMLTPR * ((DefSinglePB * 4 *(TNofHPB + TNofFPB)) + BasePlayerDef + EquipDef + ReArmorDef + PotionDef + Base_Armor_Def); //4items
        EHP = HP * (1 + Def / 100);;

        //OFFENSIVE STATS
        Str = SupDrMLTPR * ((StrSinglePB * (TNofHPB + TNofFPB)) + BasePlayerStr + PetStr + EquipStr + ReArmorStr + PotionStr + Wpn_Str + Base_Armor_Str);
        CD = SupDrMLTPR * (BasePlayerCD + ReArmorCD +  PwrStCD + TunPntsCD + PotionCD + Wpn_CD + Base_Armor_CD);;
        CC = SupDrMLTPR * (BasePlayerCC + PotionCC + ReArmorCC + Wpn_CC + Base_Armor_CC);
        AtSp = SupDrMLTPR * (BasePlayerAtSp + PetAtSp + ReArmorAtSp + PwrStAtSp + TunPntsAtSp);
        Fer = SupDrMLTPR * (BasePLayerFer);


        /* STATS THAT GET CALCULATED AFTER CALCULATION */
        SHDmg = getSHDMG();
        InDmg = getSHDMG();
        SHDMG = getSHDMG();
        SHDMG = getSHDMG();





    }

    //FUNCTIONS

    //FUNCTION N0 - SHOW ALL STABLE STATS
    void ShowAllStableStats() {
        ChangeLine();
        System.out.println("/*STABLE STATS");
        System.out.println("These stats contain variables (like ACCESSORIES) That affect the end result the same way, regardless the Armor &/or Sword chosen by the user.");
        System.out.println("In other words they don't change depending on user-stated values.*/");
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
        System.out.println("//NOTE FOR SupDrMLTPR VALUE:");
        System.out.println("if Superior Dragon Armor is used, SupDrMLTPR must be equal to (1.05)");
        System.out.println("Otherwise, for ALL OTHER Armor Sets, SupDrMLTPR must be equal to (1)");
        ChangeLine();

        ChangeLine();
    }

    //FUNCTION 3 - CHECKS THAT ALL VALUES (OF ARMOR AND/OR SWORD [OR NEITHER]) ARE VIABLE AND STATED
    void StatCheck() {

        //TESTING IF ARMOR AND/OR SWORD HABE BEEN STATED
        int K = 0;
        if (Armor_Name == null && Sword_Name == null) K = 1;
        else if (Armor_Name != null && Sword_Name != null) K = 2;
        else if (Armor_Name != null /* && Sword_Name == null */) K = 3;
        else /* if ( Armor_Name == null && Sword_Name != null )*/ K = 4;

        ChangeLine();

        //INTRO LINE
        System.out.println("StatCheck :");

        //STATING STRINGS
        String  sNT;
        sNT = "Not Stated";

        //CHECKING DIFFERENT CASES
        switch (K) {

            //NEITHER ARMOR NOR ARMOR STATS ARE GIVEN
            case 1:

                //Displaying if any Armor &/or Sword is Stated
                ShowNames( sNT , sNT )


                //NO TEST (NO VALUES WERE PROVIDED) - PRINTING RESULT MESSAGE
                System.out.println(" No Test Needed! ")
                P = true;
                break;

            //BOTH ARMOR AND SWORD STATS ARE GIVEN
            case 2:
                //Displaying if any Armor &/or Sword is Stated
                ShowNames( Armor_Name , Sword_Name )

                //ARMOR STATS
                VV_ArmorStats( Base_Armor_HP, Base_Armor_Def, Base_Armor_Str, Base_Armor_CD, Base_Armor_CC, test );

                //SWORD STATS
                VV_SwordStats( Wpn_DMG , Wpn_Str , Wpn_CC , Wpn_CD , test );

                //TEST CHECK - PRINTING RESULT MESSAGE
                ExamineBooleansForStatCheck(test, P);
                break;

            //ONLY ARMOR STATS ARE GIVEN (NO SWORD STATS)
            case 3:
                //Displaying if any Armor &/or Sword is Stated
                ShowNames( Armor_Name , sNT )

                //STATS
                VV_ArmorStats( Base_Armor_HP, Base_Armor_Def, Base_Armor_Str, Base_Armor_CD, Base_Armor_CC, test );

                //TEST CHECK - PRINTING RESULT MESSAGE
                ExamineBooleansForStatCheck(test, P);
                break;

            //ONLY SWORD STATS ARE GIVEN (NO ARMOR STATS)
            case 4:

                //Displaying if any Armor &/or Sword is Stated
                ShowNames( sNT , Sword_Name )

                //STATS
                VV_SwordStats( Wpn_DMG , Wpn_Str , Wpn_CC , Wpn_CD ,test );

                //TEST CHECK - PRINTING RESULT MESSAGE
                ExamineBooleansForStatCheck(test, P);
                break;
        }

        ChangeLine();
    }

    private static void ExamineBooleansForStatCheck(boolean test, boolean P){
        if(test){
            P = true;
            System.out.println("You passed the Test! (All Values were viable).");
        }
        else {
            System.out.println("You didn't pass the Test. (Some Values weren't viable).");
        }
    }


    private static int UserUsedAndPassedStatCheck(boolean N, boolean P){

        //Check that the user has run the test for Viability of Stats
        if (!N){
            System.out.println("Please run the StatCheck before any Stat Calculation!");
            ChangeLine();
            return (0);
        }

        //Check that the user has passed the StatTest
        if (!P){
            System.out.println("Please Pass Successfully the StatCheck before any Stat Calculation!");
            ChangeLine();
            return (0);
        }

        ChangeLine();

        return (1);

    }

    private static void VV_SwordStats(float x1, float x2, float x3, float x4, boolean h){
        ValueViability ( x1 , h);
        ValueViability ( x2 , h);
        ValueViability ( x3 , h);
        ValueViability ( x4 , h);
    }


    private static void ShowNames( String ArmorName, String SwordName ){
        System.out.println("Armor : " + ArmorName);
        System.out.println("Sword : " + SwordName);
    }



    private static void ChangeLine(){
        System.out.println(" ");
    }


    //BOOLEAN VALUES FOR INTERNAL TEST
    boolean N = false; //Checks that the user has run the test for Viability of Stats (StatCheck)
    boolean P = false; //Checks that the user has passes the StatCheck
    boolean test = true; //Checks if a nonviable Armor value has been stated in input


    //FUNCTION N1 - STATING BASE ARMOR NAME/STATS
    void Input_Armor_Stats(String ArmorName, int BaseArmorHP, int BaseArmorDef, int BaseArmorStr, int BaseArmorCD, int BaseArmorCC) {
        this.Armor_Name = ArmorName;
        this.Base_Armor_HP = BaseArmorHP;
        this.Base_Armor_Def = BaseArmorDef;
        this.Base_Armor_Str = BaseArmorStr;
        this.Base_Armor_CD = BaseArmorCD;
        this.Base_Armor_CC = BaseArmorCC;

        //INNER CHECK (ARMOR INPUT VALUES)

    }

    private static void VV_ArmorStats(float x1, float x2, float x3, float x4, float x5, boolean h) {
        ValueViability(x1, h);
        ValueViability(x2, h);
        ValueViability(x3, h);
        ValueViability(x4, h);
        ValueViability(x5, h);
    }

    private static void ValueViability(float Value, boolean test){
        if (Value < 0) {
            String str1, str2;
            str1 = String.valueOf(Value);
            str2 = String.format("Please change following nonviable value : " + str1);
            System.out.println(str2);
            test = false;
        }
    }


    private static float getSHDMG(){
        return (0);
    }




}






