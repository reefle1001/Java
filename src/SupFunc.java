class SupFunc {

    /* =================================================================================================== */
    /* ==============================  SUPPORTING FUNCTIONS  ============================================= */
    /* =================================================================================================== */

    /* SUPPORTING FUNCTION 1.0 - CHANGES LINE */
    static void ChangeLine(){System.out.println(" ");}

    // SUPPORTING FUNCTION 2.0 - SHOWS IN MAIN ANY ARMOR &/OR SWORD NAMES
    static void ShowNames() {
        String sNT = "Not Stated";
        if (STATS.Armor_Name == null && STATS.Sword_Name == null) PrintNames(sNT, sNT);
        else if (STATS.Armor_Name != null && STATS.Sword_Name != null) PrintNames(STATS.Armor_Name, STATS.Sword_Name);
        else if (STATS.Armor_Name != null /* && STATS.Sword_Name == null */) PrintNames(STATS.Armor_Name, sNT);
        else /* if ( STATS.Armor_Name == null && STATS.Sword_Name != null )*/ PrintNames(sNT, STATS.Sword_Name);
    }

    // SUPPORTING FUNCTION 2.1 - PRINT COMMAND
    private static void PrintNames( String ArmorName, String SwordName ){
        System.out.println("Armor : " + ArmorName);
        System.out.println("Sword : " + SwordName);
    }

    /* BOOLEAN VALUES - CHECKS USER HAS RUN AND PASSED THE STAT CHECK SUCCESSFULLY */
    static boolean K = true;
    static boolean L = true;


    /* SUPPORTING FUNCTION 3.0 - USING ANOTHER S.F., MAKES SURE ALL USER-STATED VALUES ARE VIABLE */
    static void InnerStatCheck(int[] array) {
        /*CHECKS IF ALL VALUES ARE VIABLE*/
        for (int v : array) {
            ValueViability (v);
        }
        /*BOOLEAN L EXPRESSES THAT AT LEAST ONE VALUE IS NON-VIABLE*/
        if (!K) L = false;
    }

    /* SUPPORTING FUNCTION 3.1 - MAKES SURE USER-STATED VALUE IS VIABLE */
    private static void ValueViability(float Value){
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

}
