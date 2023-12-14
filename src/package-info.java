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










                       */

