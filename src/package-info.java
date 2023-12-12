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















    //FUNCTION N2 - STATING WEAPON STATS
    void Input_Sword_Stats(String SwordName, int WpnDMG, int WpnStr, int WpnCC, int WpnCD) {
        this.Sword_Name = SwordName;
        this.Wpn_DMG = WpnDMG;
        this.Wpn_Str = WpnStr;
        this.Wpn_CC = WpnCC;
        this.Wpn_CD = WpnCD;
    }








    }


    //FUNCTIONS OF CALCULATION

    //FUNCTION N4 - CALCULATES DEFENSIVE STATS - RETURNS EFFECTIVE HEALTH POINTS (EHP)
    float Calc_EHP() {
        System.out.println(N);
        System.out.println(P);
        if(UserUsedAndPassedStatCheck(N, P) == 0) return (0); //Checks that the user has run and passed successfully the test for Viability of Stats

        //HP CALCULATION

        HP =
        System.out.println("Health Points: " + HP);

        //DEFENCE CALCULATION

        Def =
        System.out.println("Defence: " + Def);

        //EFFECTIVE HP CALCULATION

        EHP =

        //OUTPUT
        System.out.println("Effective Health Points: " + EHP);

        ChangeLine();

        //FUNCTION RETURNS EFFECTIVE HEALTH
        return (EHP);
    }


    //FUNCTION N5 - CALCULATES DEFENSIVE STATS - RETURNS STAND BONUS EFFECTIVE HEALTH POINTS (LSB_EHP)
    float Calc_LsStBon_EHP() {

        if(UserUsedAndPassedStatCheck(N, P) == 0) return (0); //Checks that the user has run and passed successfully the test for Viability of Stats

        //HP
        float HP;
        HP = SupDrMLTPR * (HPSinglePB * 4 * (TNofHPB + TNofFPB) + BasePlayerHP + EquipHP + ReArmorHP + Base_Armor_HP); //4 items
        System.out.println("Health Points : " + HP);

        //DEFENCE
        float Def;
        Def = SupDrMLTPR * (DefSinglePB * 4 *(TNofHPB + TNofFPB) + BasePlayerDef + EquipDef + ReArmorDef + PotionDef + Base_Armor_Def); //4items
        System.out.println("Defence : " + Def);
        System.out.println("Defence (WITH Last Stand Bonus): " + 1.25F * Def);

        //EFFECTIVE HP CALCULATION WITH LAST STAND BONUS
        float LSB_EHP, LSB_EHP1, LSB_EHP2;
        LSB_EHP1 = 0.6F * HP * (1 + Def / 100); //FIRST 60% OF HP (NO LAST STAND BONUS)
        LSB_EHP2 = 0.4F * HP * (1 + 1.25F * Def / 100); //LAST 40% OF HP (YES LAST STAND BONUS)
        LSB_EHP = LSB_EHP1 + LSB_EHP2;

        //OUTPUT
        System.out.println("Effective Health Points (WITH Last Stand Bonus): " + LSB_EHP);

        ChangeLine();

        //FUNCTION RETURNS LAST STAND BONUS EFFECTIVE HEALTH POINTS (LSB_EHP)
        return (LSB_EHP);
    }

    //FUNCTION 6 - CALCULATES OFFENSIVE STATS - RETURNS DAMAGE PER SECOND (DPS)
    float Calc_DPS(){

        if(UserUsedAndPassedStatCheck(N, P) == 0) return (0); //Checks that the user has run and passed successfully the test for Viability of Stats

        //CRITICAL CHANCE
        CC =
        System.out.println("Critical Chance : " + CC);

        //STRENGTH
        Str =
        System.out.println("Strength : " + Str);

        //INITIAL DAMAGE
        float InDMG;
        InDMG = (5 + (DmgSinglePB * (TNofHPB+TNofFPB)) + Wpn_DMG)*(1+Str/100);
        /* System.out.println("Initial Damage : " + InDMG); */ //Not really that important to show

//FEROCITY
        Fer =
                System.out.println("Ferocity : " + Fer);

                //ATTACK SPEED
                AtSp =
                System.out.println("Attack Speed : " + AtSp);

                //CRITICAL DAMAGE
                CD =
                System.out.println("Critical Damage : " + CD);


                //MULTIPLIER CALCULATION
                float DmgMLTPR;
                if (CombatSkill<=50)
                DmgMLTPR = 1 + ( CombatSkill * 0.04F ) + WpnEnchants;
                else
                DmgMLTPR = 1 + ( 50 * 0.04F + ( CombatSkill - 50 ) * 0.01F ) + WpnEnchants;
                System.out.println("Damage multiplier : " + DmgMLTPR);

                //SINGLE HIT DAMAGE
                float SHDMG;
                SHDMG = InDMG * DmgMLTPR * ArmorDmgMLTPL * ( 1 + CD / 100 );
                System.out.println("Single Damage Hit : " + SHDMG);

                //DAMAGE PER SECOND
                float DPS = getDps(AtSp, SHDMG);
                System.out.println("Damage Per Second (DPS) : " + DPS);

                ChangeLine();

                //FUNCTION RETURNS DAMAGE PER SECOND (DPS)
                return (DPS);
                }

private static float getDps(float AtSp, float SHDMG) {
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







        }




        }








        */

