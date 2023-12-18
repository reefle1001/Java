class SupFunc {

    /* =================================================================================================== */
    /* ===================================  SUPPORTING FUNCTIONS  ======================================== */
    /* =================================================================================================== */

    /* SUPPORTING FUNCTION 1.0 - CHANGES LINE */
    static void ChangeLine(){System.out.println(" ");}


    // SUPPORTING FUNCTION 2.0 - SHOWS IN MAIN ANY ARMOR &/OR SWORD NAMES

    static void ShowNames() {
        String s1, s2;
        s2 = s1 = null;

        if (PLR_STATS.Armor_Name_M1!=null) s1 = PLR_STATS.Armor_Name_M1;
        else if (PLR_STATS.Armor_Name_M2!=null) s1 = PLR_STATS.Armor_Name_M2;
        else s1 = "NONE";

        if (PLR_STATS.Sword_Name_M1!=null) s2 = PLR_STATS.Sword_Name_M1;
        else if (PLR_STATS.Sword_Name_M2!=null) s2 = PLR_STATS.Sword_Name_M2;
        else s1 = "NONE";

        System.out.println("Armor : " + s1);
        System.out.println("Sword : " + s2);

    }



    /* SUPPORTING FUNCTION 3.0 - USING ANOTHER S.F., MAKES SURE ALL USER-STATED VALUES ARE VIABLE */

    static int InnerStatCheck (int[] array) {
        /*CHECKS IF ALL VALUES ARE VIABLE*/
        for (int v : array) {
            ValueViability ( v );
        }
        /*BOOLEAN L EXPRESSES THAT AT LEAST ONE VALUE IS NON-VIABLE*/
        int L = 0;
        if (!K) { L = 1; }; //Array contains non valid value
        K = true; // Reappointing K to true after stat check
        return (L == 1 ? 1 : 0); //Function returns : <(1) if Array contains non valid value> or <(0) if Array contains valid values>
    }

    private static boolean K = true;

    /* SUPPORTING FUNCTION 3.1 - MAKES SURE USER-STATED VALUE IS VIABLE */
    private static void ValueViability ( float Value ){
        if (Value < 0) /*Value non-viable*/{

            /* STRINGS - PRINTS NON-VIABLE VALUES FOR CHANGE*/
            String str1, str2;
            str1 = String.valueOf(Value);
            str2 = String.format("Please change following non-viable value : " + str1);
            SupFunc.ChangeLine();
            System.out.println(str2);

            /*BOOLEAN K EXPRESSES VALUE IS NON-VIABLE*/
            K = false;
        }
    }

    /* SUPPORTING FUNCTION 4 - COUNTER CHECK */

    /* SUPPORTING FUNCTION 4.0 - NonValidValues COUNTER CHECK (MAKES SURE USER HAS ONLY STATED VALID VALUES) */
    private static int CounterCheck_NonValidValues(){

        if(PLR_STATS.Counter_NonValidValues > 0)
        {
            System.out.println("Please Change Non Valid Values Noted Above : " + PLR_STATS.Counter_NonValidValues);
            return 1; //non valid values have been stated
        }

        else return 0; //all values are valid
    }

    /* SUPPORTING FUNCTION 4.1 - ARMOR BASE STATS COUNTER CHECK (MAKES SURE USER HAS ONLY STATED 1 ARMOR BASE STATS INSTANCE) */
    private static int CounterCheck_Armor_Base_Stats(){

        if(PLR_STATS.Counter_Armor_Base_Stats >1)
        {
            System.out.println("You can only have 1 ARMOR BASE STATS INSTANCE. You currently have : " + PLR_STATS.Counter_Armor_Base_Stats);
            return 1; //more than 1 armor have been stated
        }

        else return 0; // <= 1 Armor
    }

    /* SUPPORTING FUNCTION 4.2 - SWORD BASE STATS COUNTER CHECK (MAKES SURE USER HAS ONLY STATED 1 SWORD BASE STATS INSTANCE) */
    private static int CounterCheck_Sword_Base_Stats(){

        if(PLR_STATS.Counter_Sword_Base_Stats > 1)
        {
            System.out.println("You can only have 1 SWORD BASE STATS INSTANCE. You currently have : " + PLR_STATS.Counter_Sword_Base_Stats);
            return 1; //more than 1 sword have been stated
        }

        else return 0; // <= 1 Sword
    }

    /* SUPPORTING FUNCTION 4.3 - ARMOR REFORGE STATS COUNTER CHECK (MAKES SURE USER HAS ONLY STATED 1 ARMOR REFORGE STATS INSTANCE) */
    private static int CounterCheck_Armor_Reforge_Stats(){

        if(PLR_STATS.Counter_Armor_Reforge_Stats > 1)
        {
            System.out.println("You can only have 1 ARMOR REFORGE STATS INSTANCE. You currently have : " + PLR_STATS.Counter_Armor_Reforge_Stats);
            return 1; //more than 1 sword have been stated
        }

        else return 0; // <= 1 Sword
    }

    /* SUPPORTING FUNCTION 4.1 - SWORD REFORGE STATS COUNTER CHECK (MAKES SURE USER HAS ONLY STATED 1 SWORD REFORGE STATS INSTANCE) */
    private static int CounterCheck_Sword_Reforge_Stats(){

        if(PLR_STATS.Counter_Sword_Reforge_Stats > 1)
        {
            System.out.println("You can only have 1 SWORD REFORGE STATS INSTANCE. You currently have : " + PLR_STATS.Counter_Sword_Reforge_Stats);
            return 1; //more than 1 sword have been stated
        }

        else return 0; // <= 1 Sword
    }

    /* SUPPORTING FUNCTION 4.5 - Counter Check - Checks if counters have been surpassed */
     static int CounterCheck(){
         int L = 0; // We introduce L so if there are multiple Counter Overpasses, we get to see all output warnings
         if (SupFunc.CounterCheck_NonValidValues() == 1) {L = 1;}
         if (SupFunc.CounterCheck_Armor_Base_Stats() == 1) {L = 1;}
         if (SupFunc.CounterCheck_Sword_Base_Stats() == 1) {L = 1;}
         if (SupFunc.CounterCheck_Armor_Reforge_Stats() == 1) {L = 1;}
         if (SupFunc.CounterCheck_Sword_Reforge_Stats() == 1) {L = 1;}
         if (L == 1) {return 1;} //function returns 1 if there are more than 1 same stats instances
         else {return 0;} //function returns 0 if every counter has not been surpassed.
     }




    /* =================================================================================================== */
    /* ====================================  STATS CALCULATIONS  ========================================= */
    /* =================================================================================================== */


    static float getDps(){
        float Dps;
        int InvTicks = 0; //Invulnerability Ticks
        float InvTime; //Invulnerability Time
        float x = PLR_STATS.AtSp();
        //Invulnerability ticks Depending on Attack Speed
        if (x >= -13 && x <= -5 ) InvTicks = 11;
        else if (x >= -4 && x <= 5 ) InvTicks = 10;
        else if (x >= 6 && x <= 17 ) InvTicks = 9;
        else if (x >= 18 && x <= 33 ) InvTicks = 8;
        else if (x >= 34 && x <= 53 ) InvTicks = 7;
        else if (x >= 54 && x <= 81 ) InvTicks = 6;
        else if (x >= 82 && x <= 100 ) InvTicks = 5;
        //Calculating Invulnerability timing
        InvTime = InvTicks * 0.05F;
        //Calculating DPS
        Dps = PLR_STATS.SHDmg() * ( 1 / InvTime );
        return Dps;
    }


    static float getDmgMLTPR(){
        float DmgMltpr;
        if (PLR_STATS.CombatSkill <= 50) {
            DmgMltpr = 1 + ( PLR_STATS.CombatSkill * 0.04F ) + PLR_STATS.WpnEnchants;
        } else DmgMltpr = 1 + ( 50 * 0.04F + ( PLR_STATS.CombatSkill - 50 ) * 0.01F ) + PLR_STATS.WpnEnchants;
        return (DmgMltpr);
    }




    /* =================================================================================================== */
    /* =======================================  ENEMY STATS  ============================================= */
    /* =================================================================================================== */




    /* =================================================================================================== */
    /* ====================================  COMBAT CALCULATIONS  ======================================== */
    /* =================================================================================================== */





}
