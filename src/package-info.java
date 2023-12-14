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

