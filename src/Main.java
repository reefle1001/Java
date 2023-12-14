public class Main {
    public static void main(String[] args) {

        STATS s1;
        s1 = new STATS();

        /* s1.ShowAllStableStats(); - WORKS */
        /* s1.ShowUserStatedStats(); - WORKS */
        /* s1.ShowPlayerStats(); - WORKS */

        /* ChangeLine(); - WORKS */
        /* ShowNames(); - WORKS */
        /* PrintNames(); - WORKS */



        s1.Input_Sword_Stats("SwordName",4,5,67,89);
        s1.Input_Armor_Stats("ArmorName",5,7,300,6,2);



        s1.Test01();




    }
}
