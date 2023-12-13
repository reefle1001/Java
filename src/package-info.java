                      /*
                      //DO BOSSES ONLY WHEN YOU HAVE LEARNED TO USE MULTIPLE CLASSES
                      //BOSS FIGHT
                      BossFight Spider;
                      Spider = new BossFight();
                      Spider.BossConditions(60,7000,60);
                      Spider.ShowBossSuccessRate();

                      //ENEMY STATS
                      int EnHP;
                      int EnDPS;
                      int BossTime;


                      //ASKING FOR BOSSFIGHT STATS
                      void BossConditions(int Boss_Time, int Enemy_HP, int Player_DPS){
                      this.BossTime = Boss_Time;
                      this.EnHP = Enemy_HP;
                      this.PlayerDPS = Player_DPS;
                      }

                      //CHECK IF BOSS IS WINNABLE
                      float ShowBossSuccessRate(){
                      if(EnHP<=0||PlayerDPS<=0||BossTime<=0) return (0);
                      float perc;
                      perc = (float) EnHP /(BossTime*PlayerDPS);
                      if (perc<=1) System.out.println("Boss is fightable by a " + perc + " percentage. (lower percentage = easier boss)");
                      else System.out.println("Boss is not fightable by a " + perc + " percentage. lower percentage = easier boss");
                      return (perc);
                      }


                      */





    /*  == BOOLEAN VALUES FOR STAT CHECK ==

    boolean N = false; //Checks that the user has run the test for Viability of Stats (StatCheck)
    boolean P = false; //Checks that the user has passes the StatCheck

    */


        /*  == TEST FOR STAT CHECK ==

    private static void ExamineBooleansForStatCheck(boolean test, boolean P){
            if(test){
                P = true;
                System.out.println("You passed the Test! (All Values were viable).");
            }
            else {
                System.out.println("You didn't pass the Test. (Some Values weren't viable).");
            }
    }

    */


    /*

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

    */
/*
                      //STATS THAT GET CALCULATED BEFORE OR AFTER USER INPUTS DATA
                      //DEFENSIVE STATS
        HP = SupDrMLTPR * ((HPSinglePB * 4 * (TNofHPB + TNofFPB)) + BasePlayerHP + EquipHP + ReArmorHP + Base_Armor_HP); //4 items
                Def = SupDrMLTPR * ((DefSinglePB * 4 *(TNofHPB + TNofFPB)) + BasePlayerDef + EquipDef + ReArmorDef + PotionDef + Base_Armor_Def); //4items
                EHP = HP * ( 1 * ( Def / 100));
                LSB_Def = 1.25F * Def;
                LSB_EHP = (0.6F * HP * (1 + (Def / 100))) + 0.4F * HP * (1 + LSB_Def / 100);


                //OFFENSIVE STATS
                Str = SupDrMLTPR * ((StrSinglePB * (TNofHPB + TNofFPB)) + BasePlayerStr + PetStr + EquipStr + ReArmorStr + PotionStr + Wpn_Str + Base_Armor_Str);
                CD = SupDrMLTPR * (BasePlayerCD + ReArmorCD +  PwrStCD + TunPntsCD + PotionCD + Wpn_CD + Base_Armor_CD);;
                CC = SupDrMLTPR * (BasePlayerCC + PotionCC + ReArmorCC + Wpn_CC + Base_Armor_CC);
                AtSp = SupDrMLTPR * (BasePlayerAtSp + PetAtSp + ReArmorAtSp + PwrStAtSp + TunPntsAtSp);
                Fer = SupDrMLTPR * (BasePLayerFer);


                //STATS THAT GET CALCULATED AFTER CALCULATION
                InDmg = (5 + (DmgSinglePB * (TNofHPB+TNofFPB)) + Wpn_DMG)*(1+Str/100);
                DmgMLTPR = getDmgMLTPR();
                SHDmg = InDmg * DmgMLTPR * ArmorDmgMLTPL * ( 1 + CD / 100 );
                DPS = getDPS( AtSp, SHDmg);

*/

                      /*

                      //STATS THAT GET CALCULATED BEFORE OR AFTER USER INPUTS DATA
                      //DEFENSIVE STATS
                      float HP;
                      float Def;
                      float EHP;
                      float LSB_EHP;
                      float LSB_Def;
                      //OFFENSIVE STATS
                      float Str;
                      float CD;
                      float CC;
                      float AtSp;
                      float Fer;


                      //STATS THAT GET CALCULATED AFTER CALCULATION
                      float InDmg;
                      float SHDmg;
                      float DmgMLTPR;
                      float DPS;


                       */


                      /*

                      private static float getDmgMLTPR(){
        float DmgMLTPR;
        if (CombatSkill<=50)
            DmgMLTPR = 1 + ( CombatSkill * 0.04F ) + WpnEnchants;
        else
            DmgMLTPR = 1 + ( 50 * 0.04F + ( CombatSkill - 50 ) * 0.01F ) + WpnEnchants;
        return (DmgMLTPR);
    }
    private static float getDPS(float AtSp, float SHDMG) {
        float DPS;
        int InvTicks = 0; //Invulnerability Ticks
        float InvTime; //Invulnerability Time
        //Invulnerability ticks Depending on Attack Speed
        if (AtSp >= -13 && AtSp <= -5 ) InvTicks = 11;
        else if (AtSp >= -4 && AtSp <= 5 ) InvTicks = 10;
        else if (AtSp >= 6 && AtSp <= 17 ) InvTicks = 9;
        else if (AtSp >= 18 && AtSp <= 33 ) InvTicks = 8;
        else if (AtSp >= 34 && AtSp <= 53 ) InvTicks = 7;
        else if (AtSp >= 54 && AtSp <= 81 ) InvTicks = 6;
        else if (AtSp >= 82 && AtSp <= 100 ) InvTicks = 5;
        //Calculating Invulnerability timing
        InvTime = InvTicks * 0.05F;
        //Calculating DPS
        DPS = SHDMG * ( 1 / InvTime );
        return DPS;
    }

                       */