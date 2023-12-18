class TextClass {
    static void getTutorial(){
        System.out.println("""
                
                
                Hello!
                Welcome to the Super-Duper-Ultra Stats Calculator!
                
                Available Functions:
                [0] GetHelp(...);
                [1] ShowAllStableStats();
                [2] Input_Armor_Stats_Manually(...);
                [3] Input_Sword_Stats_Manually(...);
                [4] Input_Armor_Stats_By_Description(...);
                [5] Input_Sword_Stats_By_Description(...);
                [6] ShowUserStatedStats();
                [7] ShowPlayerStats();
                
                For further information use GetHelp(...) function!
                [Simply insert the number left of each function to learn more about it]
                """);
    }

    static void getHelp0(){
        System.out.println("""
                
                
                This is the <Get Help(...);> Function.
                Use it to get more information about the other functions.
                """);
    }
    static void getHelp1(){
        System.out.println("""
                
                
                This is the <ShowAllStableStats();> Function.
                Use it to show all stats that are independent from user input.
                """);
    }
    static void getHelp2(){
        System.out.println("""
                
                
                This is the <Input_Armor_Stats_Manually(...);> Function.
                Use it to input Manually Armor Stats.
                "Note" : You can only use 1 Armor at a time.
                "Note" : Only non-negative integer values are accepted.
                """);
    }

    static void getHelp3(){
        System.out.println("""
                
                
                This is the <Input_Sword_Stats_Manually(...);> Function.
                Use it to input Manually Sword Stats.
                "Note" : You can only use 1 Sword at a time.
                "Note" : Only non-negative integer values are accepted.
                """);
    }
    static void getHelp4(){
        System.out.println("""
                
                
                This is the <Input_Armor_Stats_By_Description(...);> Function.
                Use it to Input Armor Set by inGame Name.
                "Note" : You can only describe Armor Base Stats or Armor Reforge Stats once.
                "Note" : You can Insert Armor Base Stats and Armor Reforge Stats separately in different functions!
                
                Viable Armor Names Currently :
                    [NONE]
                    [SUPERIOR_DRAGON]
                    (use any text inside the parenthesis)
                    
                Viable Armor Reforge Names Currently :
                    [NONE]
                    [SPIKED]
                    (use any text inside the parenthesis)
                """);
    }
    static void getHelp5(){
        System.out.println("""
                
                
                This is the <Input_Sword_Stats_By_Description(...);> Function.
                Use it to Input Sword by inGame Name.
                "Note" : You can only describe Sword Base Stats or Sword Reforge Stats once.
                "Note" : You can Insert Sword Base Stats and Sword Reforge Stats separately in different functions!
                
                Viable Sword Names Currently :
                    [NONE]
                    [ASPECT_OF_THE_DRAGONS]
                    (use any text inside the parenthesis)
                    
                Viable Sword Reforge Names Currently :
                    [NONE]
                    [WITHERED]
                    (use any text inside the parenthesis)
                """);
    }
    static void getHelp6(){
        System.out.println("""
                
                
                This is the <ShowUserStatedStats();> Function.
                Use it to confirm User-Stated Stats.
                """);
    }
    static void getHelp7(){
        System.out.println("""
                
                
                This is the <ShowPlayerStats();> Function.
                Use it to calculate PLayer Stats.
                """);
    }
    static void getHelpdefault(){
        System.out.println("""
                
                
                Please insert a valid Number (Integer: from 0 up to 7)
                """);
    }


}