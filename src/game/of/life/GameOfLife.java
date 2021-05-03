
package game.of.life;


public class GameOfLife {


    public static void main(String[] args) {
        
//        Game Of Life
//
//        Turim pradine lenta
//
//        kiekvienam langeliui paskaiciuojam kaimynu kieki
//        jei langelis buvo tuscias:
//            jei kaimynu kiekis 3 - naujoj iteracijoj gyventojas atsiras
//            jei kaimynu kiekis <3 arba >3 - naujoj iteracijoj gyventojas neatsiras
//        jei langelis buvo gyvenamas:
//            jei kaimynu kiekis 2 arba 3 - naujoj iteracijoj gyventojas liks gyventi
//            jei kaimynu kiekis <2 arba >3 - naujoj iteracijoj gyventojas mirs
//
//        1. atspausdinti 50 iteraciju
//        2. nutraukti spausdinima, jei nauja iteracija yra tokia pati, kaip ir pries tai buvusi
//        3. nutraukti spausdinima, jei istorijoje yra tokia pati iteracija
//
//          - kaip sugeneruot pradini game of life lauka char[][] field {{‘.’, ‘X’, ‘.’}, {‘.’, ‘X’, ‘.’}, {‘.’, ‘X’, ‘.’}}
//          - jei ner gyventojo tai ‘.’ taskas


//          SPRENDIMAS

//            char[][] field = {
//                {'.', 'X', '.', 'X', '.'},
//                {'.', '.', 'X', 'X', '.'},
//                {'.', 'X', 'X', 'X', '.'},
//                {'.', '.', '.', '.', '.'},
//                {'X', 'X', '.', 'X', '.'}
//            };

//------------------------------------------------------------------------------
//          naujo random field generavimas suteikus dydzio parametrus
//------------------------------------------------------------------------------
            int columns = 10;
            int rows = 10;

            char[][] field = new char[rows][columns];
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (Math.random() < 0.4) {
                        field[i][j] = 'X';
                    } else {
                        field[i][j] = '.';
                    }
                }
            }

//------------------------------------------------------------------------------
//                              copy pirmo field 
//------------------------------------------------------------------------------
            char[][] fieldNaujas = new char[rows][columns];
            
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    fieldNaujas[i][j] = field[i][j];
                }
            }
//------------------------------------------------------------------------------
//                           field originalas
//------------------------------------------------------------------------------
            char[][] fieldOriginalas = new char[rows][columns];
            
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    fieldOriginalas[i][j] = field[i][j];
                }
            }  
//------------------------------------------------------------------------------
//                           antra copy pirmo field 
//------------------------------------------------------------------------------
            char[][] fieldPirmas = new char[rows][columns];
              
//------------------------------------------------------------------------------
//                           trecia copy pirmo field 
//------------------------------------------------------------------------------
            char[][] fieldTikrinimui = new char[rows][columns];
              
             
//------------------------------------------------------------------------------            
//                          originalaus spausdinimas
//------------------------------------------------------------------------------
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
            System.out.println("-----------------");
            


 //------------------------------************-----------------------------------        
//------------------------------------------------------------------------------
//                        SEKANCIU FIELDS GENERAVIMAS
//------------------------------------------------------------------------------
            for (int i = 1; i <= 50; i++) { // pakeist i <= 50
//                int nelygus = 0;
                  int kartojasi = 0;
                
                for(int m = 0; m < field.length; m++){      // eilutes paemimas 
                    char[] eiluteNauja = fieldNaujas[m];    // eilute
                    char[] eiluteSena = field[m];           // eilute

                    
                    for(int g = 0; g < eiluteNauja.length; g++){    // kiekvieno langelio tikrinimas 
                        int kaimynai = 0; 
//------------------------------------------------------------------------------                        
//                              tikrinami SONINIAI 
//------------------------------------------------------------------------------                           
                           if(g != (eiluteNauja.length - 1) && eiluteSena[g + 1] == 'X'){   // jei sekantis yra gyventojas
                               kaimynai++;
//                               System.out.println("desinej yra");
                           };
                           if(g != 0 && eiluteSena[g - 1] == 'X'){      // jei sekantis yra gyventojas
                               kaimynai++;
//                               System.out.println("kairej yra");
                           };
//------------------------------------------------------------------------------                           
//                            tikrinami VIRSUTINIAI
//------------------------------------------------------------------------------                           
                           if(m != 0){      // tikrinama ar eilute nera virsutine
                               char[] upEilute = field[m - 1];   // virsutine eilute
                               
                               if(upEilute[g] == 'X'){  // jei virsutinis yra gyventojas
                                  kaimynai++;
//                                  System.out.println("virsuj yra");
                               };
                               if(g != 0 && upEilute[g - 1] == 'X'){    // jei virsutinis kairys yra gyventojas
                                  kaimynai++;
//                                  System.out.println("virsuj kairej yra");
                               };
                               if(g != (eiluteNauja.length - 1) && upEilute[g + 1] == 'X'){  // jei virsutinis desinys yra gyventojas
                                  kaimynai++;
//                                  System.out.println("virsuj desinej yra");
                               };
                           } 
//------------------------------------------------------------------------------                           
//                            tikrinami APATINIAI
//------------------------------------------------------------------------------                           
                           if(m != (field.length - 1)){     // tikrinama ar eilute nera apatine
                               char[] downEilute = field[m + 1];   // apatine eilute
                               
                               if(downEilute[g] == 'X'){    // jei apatinis yra gyventojas
                                  kaimynai++;
//                                   System.out.println("apacioj yra");
                               };
                               if(g != 0 && downEilute[g - 1] == 'X'){  // jei apatinis kairys yra gyventojas
                                  kaimynai++;
//                                  System.out.println("apacioj kairej yra");
                               };
                               if(g != (eiluteNauja.length - 1) && downEilute[g + 1] == 'X'){   // jei apatinis desinys yra gyventojas
                                  kaimynai++;
//                                  System.out.println("apacioj desinej yra");
                               };
                           } 
//------------------------------------------------------------------------------                           
//                      kaimynu skaiciaus tikrinimas
//------------------------------------------------------------------------------                           
                            if(eiluteSena[g] == '.' && kaimynai == 3 ){
                                fieldNaujas[m][g] = 'X';
                            } 
                            
                            if(eiluteSena[g] == 'X' && kaimynai < 2 || kaimynai > 3){
                                fieldNaujas[m][g] = '.';
                            }                  
                    }
                    System.out.println(eiluteNauja);
                }
//------------------------------------------------------------------------------                
//                   ar naujas toks pat kaip pries tai?
//------------------------------------------------------------------------------
//                for (int s = 0; s < field.length; s++) {
//                    for (int j = 0; j < field[s].length; j++) {
//                        char buves = field[s][j];
//                        char naujas = fieldNaujas[s][j];
//                        
//                        if(naujas != buves)
//                        nelygus++;
//                    }
//                }
//                
//                if(nelygus == 0){
//                    break;
//                }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------                
//                   ar naujas toks pat yra kadanors buves?
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
            for (int g = 0; g < field.length; g++) {
                for (int j = 0; j < field[g].length; j++) {
                    fieldTikrinimui[g][j] = fieldOriginalas[g][j];
                }
            } 
            for (int g = 0; g < field.length; g++) {
                for (int j = 0; j < field[g].length; j++) {
                    fieldPirmas[g][j] = fieldOriginalas[g][j];
                }
            }  

                for(int d = 0; d < i; d++){
                    int nelygus2 = 0;
                    
                    for(int b = 0; b < fieldTikrinimui.length; b++){

                        char[] eiluteNauja = fieldTikrinimui[b];    // eilute
                        char[] eiluteSena = fieldPirmas[b];           // eilute
                        
                        for(int g = 0; g < fieldTikrinimui.length; g++){    // kiekvieno langelio tikrinimas 
                            int kaimynai = 0; 
//----------------------------------------------------                       
//                              tikrinami SONINIAI 
//----------------------------------------------------                          
                           if(g != (eiluteNauja.length - 1) && eiluteSena[g + 1] == 'X'){   // jei sekantis yra gyventojas
                               kaimynai++;

                           };
                           if(g != 0 && eiluteSena[g - 1] == 'X'){      // jei sekantis yra gyventojas
                               kaimynai++;
                           };
//----------------------------------------------------                         
//                            tikrinami VIRSUTINIAI
//----------------------------------------------------                         
                           if(b != 0){      // tikrinama ar eilute nera virsutine
                               char[] upEilute = fieldPirmas[b - 1];   // virsutine eilute
                               
                               if(upEilute[g] == 'X'){  // jei virsutinis yra gyventojas
                                  kaimynai++;
                               };
                               if(g != 0 && upEilute[g - 1] == 'X'){    // jei virsutinis kairys yra gyventojas
                                  kaimynai++;
                               };
                               if(g != (eiluteNauja.length - 1) && upEilute[g + 1] == 'X'){  // jei virsutinis desinys yra gyventojas
                                  kaimynai++;
                               };
                           } 
//---------------------------------------------------                           
//                            tikrinami APATINIAI
//---------------------------------------------------                          
                           if(b != (field.length - 1)){     // tikrinama ar eilute nera apatine
                               char[] downEilute = fieldPirmas[b + 1];   // apatine eilute
                               
                               if(downEilute[g] == 'X'){    // jei apatinis yra gyventojas
                                  kaimynai++;
                               };
                               if(g != 0 && downEilute[g - 1] == 'X'){  // jei apatinis kairys yra gyventojas
                                  kaimynai++;
                               };
                               if(g != (eiluteNauja.length - 1) && downEilute[g + 1] == 'X'){   // jei apatinis desinys yra gyventojas
                                  kaimynai++;
                               };
                           } 
//---------------------------------------------------                         
//                      kaimynu skaiciaus tikrinimas
//---------------------------------------------------                          
                            if(eiluteSena[g] == '.' && kaimynai == 3 ){
                                fieldTikrinimui[b][g] = 'X';
                            } 

                            if(eiluteSena[g] == 'X'){
                                if(kaimynai < 2 || kaimynai > 3){
                                   fieldTikrinimui[b][g] = '.';
                                }
                            }                  
                        }  
                    }
//------------------------------------------------------- 
//                         fields lyginimas
//------------------------------------------------------- 
                    for (int s = 0; s < field.length ; s++) {
                        for (int j = 0; j < field[s].length; j++) {
                            char buves = fieldPirmas[s][j];
                            char dabartinis = fieldNaujas[s][j];
                            if(dabartinis != buves){
                                nelygus2++;
                            }
                        }
                    }
//-------------------------------------------------------               
//                  sukuriama nauja buvusioji tikrinimui
//-------------------------------------------------------             
                for (int s = 0; s < field.length; s++) {
                    for (int j = 0; j < field[s].length; j++) {
                        fieldPirmas[s][j] = fieldTikrinimui[s][j];
                    }
                }

                    if(nelygus2 == 0){
                        System.out.println("jau buvo");
                        kartojasi = 1;
                    } 
                }
                
                if(kartojasi != 0){
                    break;
                }
//------------------------------------------------------------------------------                
//                          sukuriama nauja buvusioji
//------------------------------------------------------------------------------                
                for (int s = 0; s < field.length; s++) {
                    for (int j = 0; j < field[s].length; j++) {
                        field[s][j] = fieldNaujas[s][j];
                    }
                }
                System.out.println("--------");
            }


        
        
    }
    
}

////destytojo 1
//char[][] field = {
//            {'.', 'X', '.', 'X', '.'},
//            {'.', '.', 'X', 'X', '.'},
//            {'.', 'X', 'X', 'X', '.'},
//            {'.', '.', '.', '.', '.'},
//            {'X', 'X', '.', 'X', '.'}
//        };
// 
////        char[][] field = new char[15][50];
////        for (int i = 0; i < field.length; i++) {
////            for (int j = 0; j < field[i].length; j++) {
////                if (Math.random() < 0.25) {
////                    field[i][j] = 'X';
////                } else {
////                    field[i][j] = '.';
////                }
////            }
////        }
// 
//        for (int i = 0; i < field.length; i++) {
//            for (int j = 0; j < field[i].length; j++) {
//                System.out.print(field[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("0-----------------");
// 
//        for (int i = 1; i <= 50; i++) {
//            char[][] newField = new char[field.length][field[0].length];
//            for (int y = 0; y < field.length; y++) {
//                for (int x = 0; x < field[y].length; x++) {
//                    int kk = 0;
//                    if (y > 0) {
//                        kk += (x > 0 && field[y-1][x-1] == 'X') ? 1 : 0;
//                        kk += (field[y-1][x] == 'X') ? 1 : 0;
//                        kk += (x < field[y-1].length - 1 && field[y-1][x+1] == 'X') ? 1 : 0;
//                    }
//                    kk += (x > 0 && field[y][x-1] == 'X') ? 1 : 0;
//                    kk += (x < field[y].length - 1 && field[y][x+1] == 'X') ? 1 : 0;
//                    if (y < field.length - 1) {
//                        kk += (x > 0 && field[y+1][x-1] == 'X') ? 1 : 0;
//                        kk += (field[y+1][x] == 'X') ? 1 : 0;
//                        kk += (x < field[y+1].length - 1 && field[y+1][x+1] == 'X') ? 1 : 0;
//                    }
//                    if (field[y][x] == 'X') {
//                        if (kk == 2 || kk == 3) {
//                            newField[y][x] = 'X';
//                        } else {
//                            newField[y][x] = '.';
//                        }
//                    } else {
//                        if (kk == 3) {
//                            newField[y][x] = 'X';
//                        } else {
//                            newField[y][x] = '.';
//                        }
//                    }
//                }
//            }
//            for (int y = 0; y < newField.length; y++) {
//                for (int x = 0; x < newField[y].length; x++) {
//                    System.out.print(newField[y][x]);
//                }
//                System.out.println();
//            }
//            System.out.print(i);
//            System.out.println("-----------------");
//            field = newField;
//        }




// DESTYTOJO VARIANTAS 2
//
//char[][] field = {
//            {'.', 'X', '.', 'X', '.'},
//            {'.', '.', 'X', 'X', '.'},
//            {'.', 'X', 'X', 'X', '.'},
//            {'.', '.', '.', '.', '.'},
//            {'X', 'X', '.', 'X', '.'}
//        };
// 
////        char[][] field = new char[15][50];
////        for (int i = 0; i < field.length; i++) {
////            for (int j = 0; j < field[i].length; j++) {
////                if (Math.random() < 0.25) {
////                    field[i][j] = 'X';
////                } else {
////                    field[i][j] = '.';
////                }
////            }
////        }
// 
//        for (int i = 0; i < field.length; i++) {
//            for (int j = 0; j < field[i].length; j++) {
//                System.out.print(field[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("0-----------------");
// 
//        for (int i = 1; i <= 50; i++) {
//            // sukuriam nauja lapa
//            char[][] newField = new char[field.length][field[0].length];
//            // naujo lapo uzpildymas
//            for (int y = 0; y < field.length; y++) {
//                for (int x = 0; x < field[y].length; x++) {
//                    // skaiciuojam kaimynu kieki aplink langeli,
//                    // kurio koordinates x, y
//                    int kk = 0;
//                    if (y > 0) {
//                        kk += (x > 0 && field[y-1][x-1] == 'X') ? 1 : 0;
//                        kk += (field[y-1][x] == 'X') ? 1 : 0;
//                        kk += (x < field[y-1].length - 1 && field[y-1][x+1] == 'X') ? 1 : 0;
//                    }
//                    kk += (x > 0 && field[y][x-1] == 'X') ? 1 : 0;
//                    kk += (x < field[y].length - 1 && field[y][x+1] == 'X') ? 1 : 0;
//                    if (y < field.length - 1) {
//                        kk += (x > 0 && field[y+1][x-1] == 'X') ? 1 : 0;
//                        kk += (field[y+1][x] == 'X') ? 1 : 0;
//                        kk += (x < field[y+1].length - 1 && field[y+1][x+1] == 'X') ? 1 : 0;
//                    }
//                    // nusprendziam ar naujam lape koordinatese x, y
//                    // gyventojas bus ar ne
//                    if (field[y][x] == 'X') {
//                        if (kk == 2 || kk == 3) {
//                            newField[y][x] = 'X';
//                        } else {
//                            newField[y][x] = '.';
//                        }
//                    } else {
//                        if (kk == 3) {
//                            newField[y][x] = 'X';
//                        } else {
//                            newField[y][x] = '.';
//                        }
//                    }
//                }
//            }
//            // palyginam sena lapa su nauju
//            boolean lygus = true;
//            for (int y = 0; y < newField.length && lygus; y++) {
//                for (int x = 0; x < newField[y].length && lygus; x++) {
//                    if (field[y][x] != newField[y][x]) {
//                        lygus = false;
//                    }
//                }
//            }
//            // jei lapai lygus - nutraukiam pagrindini cikla
//            if (lygus) {
//                break;
//            }
//            // spausdinam nauja lapa
//            for (int y = 0; y < newField.length; y++) {
//                for (int x = 0; x < newField[y].length; x++) {
//                    System.out.print(newField[y][x]);
//                }
//                System.out.println();
//            }
//            System.out.print(i);
//            System.out.println("-----------------");
//            // perimam nauja lapa i kita ranka (naujas tampa senu)
//            field = newField;
//        }


// DESTYTOJO VARIANTAS 3
//char[][] field = {
//            {'.', '.', '.', '.', '.'},
//            {'.', '.', 'X', '.', '.'},
//            {'.', '.', 'X', '.', '.'},
//            {'.', '.', 'X', '.', '.'},
//            {'.', '.', '.', '.', '.'}
//        };
// 
////        char[][] field = new char[15][50];
////        for (int i = 0; i < field.length; i++) {
////            for (int j = 0; j < field[i].length; j++) {
////                if (Math.random() < 0.25) {
////                    field[i][j] = 'X';
////                } else {
////                    field[i][j] = '.';
////                }
////            }
////        }
// 
//        for (int i = 0; i < field.length; i++) {
//            for (int j = 0; j < field[i].length; j++) {
//                System.out.print(field[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("0-----------------");
// 
//        char[][][] history = new char[50][field.length][field[0].length];
// 
//        for (int i = 1; i <= 50; i++) {
//            // sukuriam nauja lapa
//            char[][] newField = new char[field.length][field[0].length];
//            // naujo lapo uzpildymas
//            for (int y = 0; y < field.length; y++) {
//                for (int x = 0; x < field[y].length; x++) {
//                    // skaiciuojam kaimynu kieki aplink langeli,
//                    // kurio koordinates x, y
//                    int kk = 0;
//                    if (y > 0) {
//                        kk += (x > 0 && field[y-1][x-1] == 'X') ? 1 : 0;
//                        kk += (field[y-1][x] == 'X') ? 1 : 0;
//                        kk += (x < field[y-1].length - 1 && field[y-1][x+1] == 'X') ? 1 : 0;
//                    }
//                    kk += (x > 0 && field[y][x-1] == 'X') ? 1 : 0;
//                    kk += (x < field[y].length - 1 && field[y][x+1] == 'X') ? 1 : 0;
//                    if (y < field.length - 1) {
//                        kk += (x > 0 && field[y+1][x-1] == 'X') ? 1 : 0;
//                        kk += (field[y+1][x] == 'X') ? 1 : 0;
//                        kk += (x < field[y+1].length - 1 && field[y+1][x+1] == 'X') ? 1 : 0;
//                    }
//                    // nusprendziam ar naujam lape koordinatese x, y
//                    // gyventojas bus ar ne
//                    if (field[y][x] == 'X') {
//                        if (kk == 2 || kk == 3) {
//                            newField[y][x] = 'X';
//                        } else {
//                            newField[y][x] = '.';
//                        }
//                    } else {
//                        if (kk == 3) {
//                            newField[y][x] = 'X';
//                        } else {
//                            newField[y][x] = '.';
//                        }
//                    }
//                }
//            }
//            // padedam sena lapa i istorijos dezute
//            history[i-1] = field;
//            // palyginam nauja lapa su visais senais
//            boolean kartojasi = false;
//            for (int z = i - 1; z >= 0 && !kartojasi; z--) {
//                boolean lygus = true;
//                for (int y = 0; y < newField.length && lygus; y++) {
//                    for (int x = 0; x < newField[y].length && lygus; x++) {
//                        if (history[z][y][x] != newField[y][x]) {
//                            lygus = false;
//                        }
//                    }
//                }
//                if (lygus) {
//                    kartojasi = true;
//                }
//            }
//            // jei istorijoj radom besikartojanti lapa - nutraukiam pagrindini cikla
//            if (kartojasi) {
//                break;
//            }
//            // spausdinam nauja lapa
//            for (int y = 0; y < newField.length; y++) {
//                for (int x = 0; x < newField[y].length; x++) {
//                    System.out.print(newField[y][x]);
//                }
//                System.out.println();
//            }
//            System.out.print(i);
//            System.out.println("-----------------");
//            // perimam nauja lapa i kita ranka (naujas tampa senu)
//            field = newField;
//        }