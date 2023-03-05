/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dese;

import java.util.Formatter;
import java.util.Scanner;


public class Cifrado {
    String l0r0 = "", l0="", r0="";
    public void inicio(){
        Scanner captura2;
        captura2 = new Scanner(System.in);
        System.out.print("Escribe tu dato a cifrar en Hexadecimal: ");
        String Dato="";
        Dato =captura2.next();
        
        char[] caract=Dato.toCharArray();
        String binary1="";
        for(int i=0;i<caract.length;i++){
            int hexa=Integer.parseInt(Character.toString(caract[i]), 16);
            String bintext=Integer.toBinaryString(hexa);
            int binnum=Integer.parseInt(bintext);
            Formatter binformat = new Formatter();
            binformat.format("%04d",binnum);
            String bit=binformat.toString();
            binary1=binary1+""+bit;
        }
        
        int[] IP={58, 50, 42, 34, 26, 18, 10, 2,
                  60, 52, 44, 36, 28, 20, 12, 4,
                  62, 54, 46, 38, 30, 22, 14, 6,
                  64, 56, 48, 40, 32, 24, 16, 8,
                  57, 49, 41, 33, 25, 17, 9, 1,
                  59, 51, 43, 35, 27, 19, 11, 3,
                  61, 53, 45, 37, 29, 21, 13, 5,
                  63, 55, 47, 39, 31, 23, 15, 7,
                };        
        for(int i=0; i<64; i++){
               l0r0=l0r0+binary1.charAt(IP[i]-1);
        }
        l0 = l0r0.substring(0,l0r0.length()/2);
        r0 = l0r0.substring(l0r0.length()/2);
    }
    
    public void cifrado(){
        inicio();
        int[] expansion = {32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,
                          12,13,12,13,14,15,16,17,
                          16,17,18,19,20,21,20,21,
                          22,23,24,25,24,25,26,27,
                          28,29,28,29,30,31,32,1};
        int[] permutacion ={16,7,20,21,29,12,28,17,1,15,23,26,5,18,31,10,2,8,24,14,32,27,3,9,19,13,30,6,22,11,4,25};
        //Llamamos a las llaves
        Llaves llave = new Llaves();
        String[] claves = llave.ObtenerK();
        //Iniciamos las 16 rondas de Feistel
          for (int j=0; j<16; j++)  {
              String r="";
              //Expandimos r0
            for(int i =0; i<48; i++){
                r = r + r0.charAt(expansion[i]-1);
            }
            // xOr con Ki
            String nuevaR="";
            for(int i=0; i<48; i++){
                String num="1";
                if(claves[j].charAt(i)==r.charAt(i)){
                    num="0";
                }
                nuevaR = nuevaR + num;
            }
            r = nuevaR;
            nuevaR="";
            //Dividimos en bloques de 6
            int[][] bloques = new int[8][8];
            for(int i=0; i<8; i++){
            bloques[0][i] = Integer.parseInt((""+r.charAt(0) + r.charAt(5)), 2);
            bloques[1][i] = Integer.parseInt((r.substring(1, 5)), 2);
            //Vamos borrando los primeros 6 dígitos a r hasta que quede vacío
            r=r.substring(6);
            }
            //Hacemos la sustitución con cajas Ss
       String[] bit=new String[8];
       int[][] S1 = 
            {{14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},
            {0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
            {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
            {15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}};
       int[][] S2 = 
            {{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
            {3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
            {0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},
            {13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}};
       int[][] S3 = 
            {{10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},
            {13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},
            {13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},
            {1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}};
       int[][] S4 = 
            {{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},
            {13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
            {10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},
            {3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}};
       int[][] S5=
            {{2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},
            {14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},
            {4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},
            {11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}};
       int[][] S6=
            {{12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},
            {10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},
            {9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},
            {4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}};
       int[][] S7=
        {
            {4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},
            {13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},
            {1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},
            {  6, 11, 13,  8,  1,  4, 10,  7,  9,  5,  0, 15, 14,  2,  3, 12 }
        };
       int[][] S8=
        {
            { 13,  2,  8,  4,  6, 15, 11,  1, 10,  9,  3, 14,  5,  0, 12,  7 },
            {  1, 15, 13,  8, 10,  3,  7,  4, 12,  5,  6, 11,  0, 14,  9,  2 },
            {  7, 11,  4,  1,  9, 12, 14,  2,  0,  6, 10, 13, 15,  3,  5,  8 },
            {  2,  1, 14,  7,  4, 10,  8, 13, 15, 12,  9,  0,  3,  5,  6, 11 }};
       
        for(int i=0; i<8; i++){
            switch(i){
                case 0:
                    bit[i]=Integer.toBinaryString(S1[bloques[0][i]][bloques[1][i]]);
                    break;
                case 1:
                    bit[i]=Integer.toBinaryString(S2[bloques[0][i]][bloques[1][i]]);
                    break;
                case 2:
                    bit[i]=Integer.toBinaryString(S3[bloques[0][i]][bloques[1][i]]);
                    break;
                case 3:
                    bit[i]=Integer.toBinaryString(S4[bloques[0][i]][bloques[1][i]]);
                    break;
                case 4:
                    bit[i]=Integer.toBinaryString(S5[bloques[0][i]][bloques[1][i]]);
                    break;
                case 5:
                    bit[i]=Integer.toBinaryString(S6[bloques[0][i]][bloques[1][i]]);
                    break;
                case 6:
                    bit[i]=Integer.toBinaryString(S7[bloques[0][i]][bloques[1][i]]);
                    break;
                case 7:
                    bit[i]=Integer.toBinaryString(S8[bloques[0][i]][bloques[1][i]]);
                    break;
            }
            while(bit[i].length()<4){
                bit[i]= "0" + bit[i];
            }
            r=r + bit[i];
        }        
        //Permutacion 2
        for(int i=0; i<32; i++){
                nuevaR = nuevaR + r.charAt(permutacion[i]-1);
            }
        r = nuevaR;
        nuevaR = "";
        // xOr con L
        for(int i=0; i<32; i++){
                String num="1";
                if(l0.charAt(i)==r.charAt(i)){
                    num="0";
                }
                nuevaR = nuevaR + num;
            }
        l0 = r0;
        r0 = nuevaR;
          }
    }
    
    public void finalD(){
        cifrado();
        l0r0 = r0 + l0;
        String d="";
        int[] permutacionFinal = {40,8,48,16,56,24,64,32,
                             39,7,47,15,55,23,63,31,
                             38,6,46,14,54,22,62,30,
                             37,5,45,13,53,21,61,29,
                             36,4,44,12,52,20,60,28,
                             35,3,43,11,51,19,59,27,
                             34,2,42,10,50,18,58,26,
                             33,1,41,9,49,17,57,25};
        for(int i=0; i<64; i++){
            d = d + l0r0.charAt(permutacionFinal[i]-1);
        }
        //Convertir d a hexadecimal
        String bloqueH="";
        String[] binario = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        String[] hexadecimal = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        for(int j=0; j<16; j++){
                for (int i=0; i<16; i++){
                String bloque="";
                    if(d.substring(0,4).equals(binario[i])){
                        bloque= hexadecimal[i];
                    }
                bloqueH = bloqueH + bloque;
            }
                d = d.substring(4);
        }
        System.out.println(bloqueH);
    }
}
