class SupFunc {

    /* =================================================================================================== */
    /* ======================================  PLAYER STATS  ============================================= */
    /* =================================================================================================== */

    /* =================================================================================================== */
    /* ===================================  SUPPORTING FUNCTIONS  ======================================== */
    /* =================================================================================================== */

    /* SUPPORTING FUNCTION 1.0 - CHANGES LINE */
    static void ChangeLine(){System.out.println(" ");}

    // SUPPORTING FUNCTION 2.0 - SHOWS IN MAIN ANY ARMOR &/OR SWORD NAMES
    static void ShowNames() {
        String sNT = "Not Stated";
        if (PLR_STATS.Armor_Name_M1 == null && PLR_STATS.Sword_Name_M1 == null) PrintNames(sNT, sNT);
        else if (PLR_STATS.Armor_Name_M1 != null && PLR_STATS.Sword_Name_M1 != null) PrintNames(PLR_STATS.Armor_Name_M1, PLR_STATS.Sword_Name_M1);
        else if (PLR_STATS.Armor_Name_M1 != null /* && STATS.Sword_Name == null */) PrintNames(PLR_STATS.Armor_Name_M1, sNT);
        else /* if ( STATS.Armor_Name == null && STATS.Sword_Name != null )*/ PrintNames(sNT, PLR_STATS.Sword_Name_M1);
    }

    // SUPPORTING FUNCTION 2.1 - PRINT COMMAND
    private static void PrintNames( String ArmorName, String SwordName ){
        System.out.println("Armor : " + ArmorName);
        System.out.println("Sword : " + SwordName);
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

    /* SUPPORTING FUNCTION 4.1 - ARMOR COUNTER CHECK (MAKES SURE USER HAS ONLY STATED 1 ARMOR) */
    private static int CounterCheck_Armor(){

        if(PLR_STATS.Counter_Armor >1)
        {
            System.out.println("You can only have 1 Armor. You currently have : " + PLR_STATS.Counter_Armor);
            return 1; //more than 1 armor have been stated
        }

        else return 0; // <= 1 Armor
    }

    /* SUPPORTING FUNCTION 4.2 - SWORD COUNTER CHECK (MAKES SURE USER HAS ONLY STATED 1 Sword) */
    private static int CounterCheck_Sword(){

        if(PLR_STATS.Counter_Sword > 1)
        {
            System.out.println("You can only have 1 Armor. You currently have : " + PLR_STATS.Counter_Sword);
            return 1; //more than 1 sword have been stated
        }

        else return 0; // <= 1 Sword
    }

    /* SUPPORTING FUNCTION 4.3 - NonValidValues COUNTER CHECK (MAKES SURE USER HAS ONLY STATED VALID VALUES) */
    private static int CounterCheck_NonValidValues(){

        if(PLR_STATS.Counter_NonValidValues > 0)
        {
            System.out.println("Please Change Non Valid Values Noted Above : " + PLR_STATS.Counter_NonValidValues);
            return 1; //non valid values have been stated
        }

        else return 0; //all values are valid
    }
     static int CounterCheck(){
         if (SupFunc.CounterCheck_Armor() == 1) {return 1;} //function returns 1 if more than 1 sword have been described
         if (SupFunc.CounterCheck_Sword() == 1) {return 1;} //function returns 1 if more than 1 armor have been described
         if (SupFunc.CounterCheck_NonValidValues() == 1) {return 1;} //function returns 1 if non valid values have been stated
         else {return 0;} //function returns 0 if everything is cool
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
        if (PLR_STATS.CombatSkill<=50) {
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
