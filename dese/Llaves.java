/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dese;

import java.util.Formatter;
import java.util.Scanner;


public class Llaves {
    
    private String[] k= new String[16];
    
    public String[] ObtenerK(){
    Scanner captura = new Scanner(System.in);
        System.out.print("Escribe tu clave en Hexadecimal: ");
        String clave = captura.next();
        
        char[] caract1=clave.toCharArray();
        String binary="";
        for(int i=0;i<caract1.length;i++){
            int hexa=Integer.parseInt(Character.toString(caract1[i]), 16);
            String bintext=Integer.toBinaryString(hexa);
            int binnum=Integer.parseInt(bintext);
            Formatter binformat = new Formatter();
            binformat.format("%04d",binnum);
            String bit=binformat.toString();
            binary=binary+""+bit;
        }

        int[] PC1={57, 49, 41, 33, 25, 17, 9, 1,
                   58, 50, 42, 34, 26, 18, 10, 2,
                   59, 51, 43, 35, 27, 19, 11, 3,
                   60, 52, 44, 36, 63, 55, 47, 39,
                   31, 23, 15, 7, 62, 54, 46, 38,
                   30, 22, 14, 6, 61, 53, 45, 37, 
                   29, 21, 13, 5, 28, 20, 12, 4    
        };
       
        String c0d0 = "";
        for(int i=0; i<56; i++){
            c0d0=c0d0+""+binary.charAt(PC1[i]-1);
        }
        
        
        

        int cont = 0; 
        String c0="";
        String d0="";

        for (int i = 0; i<c0d0.length(); i++) {
            cont++;
            if (cont<32) {
                c0= c0d0.substring(0,c0d0.length()/2);
            }
            if (cont>32){
            d0=c0d0.substring(c0d0.length()/2,c0d0.length());
        }
        }


        int[] iteraciones={1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1   
        };
        //se recorren las sub cadenas con la caja de interaciones
        //primera cadena
        String subC1=c0d0.substring(0,c0d0.length()/2);
        String subD1=c0d0.substring(c0d0.length()/2,c0d0.length());
        String i1=subC1.substring(0,iteraciones[0]);
        String i2=subD1.substring(0,iteraciones[0]);
        subC1=subC1.substring(iteraciones[0],subC1.length());
        subC1+=i1;
        subD1=subD1.substring(iteraciones[0],subD1.length());
        subD1+=i2;
        
        //segunda cadena
        String c1d1=subC1+subD1;
        String subC2=c1d1.substring(0,c1d1.length()/2);
        String subD2=c1d1.substring(c1d1.length()/2,c1d1.length());
        String a1=subC2.substring(0,iteraciones[0]);
        String a2=subD2.substring(0,iteraciones[0]);
        subC2=subC2.substring(iteraciones[0],subC2.length());
        subC2+=a1;
        subD2=subD2.substring(iteraciones[0],subD2.length());
        subD2+=a2;
        
        //tercera cadena
        String c2d2=subC2+subD2;
        String subC3=c2d2.substring(0,c2d2.length()/2);
        String subD3=c2d2.substring(c2d2.length()/2,c2d2.length());
        String b1=subC3.substring(0,iteraciones[2]);
        String b2=subD3.substring(0,iteraciones[2]);
        subC3=subC3.substring(iteraciones[2],subC3.length());
        subC3+=b1;
        subD3=subD3.substring(iteraciones[2],subD3.length());
        subD3+=b2;
        
        //cuarta cadena
        String c3d3=subC3+subD3;
        String subC4=c3d3.substring(0,c3d3.length()/2);
        String subD4=c3d3.substring(c3d3.length()/2,c3d3.length());
        String c1=subC4.substring(0,iteraciones[2]);
        String c2=subD4.substring(0,iteraciones[2]);
        subC4=subC4.substring(iteraciones[2],subC4.length());
        subC4+=c1;
        subD4=subD4.substring(iteraciones[2],subD4.length());
        subD4+=c2;
        
        //quinta cadena
        String c4d4=subC4+subD4;
        String subC5=c4d4.substring(0,c4d4.length()/2);
        String subD5=c4d4.substring(c4d4.length()/2,c4d4.length());
        String d1=subC5.substring(0,iteraciones[2]);
        String d2=subD5.substring(0,iteraciones[2]);
        subC5=subC5.substring(iteraciones[2],subC5.length());
        subC5+=d1;
        subD5=subD5.substring(iteraciones[2],subD5.length());
        subD5+=d2;
        
        //sexta cadena
        String c5d5=subC5+subD5;
        String subC6=c5d5.substring(0,c5d5.length()/2);
        String subD6=c5d5.substring(c5d5.length()/2,c5d5.length());
        String e1=subC6.substring(0,iteraciones[2]);
        String e2=subD6.substring(0,iteraciones[2]);
        subC6=subC6.substring(iteraciones[2],subC6.length());
        subC6+=e1;
        subD6=subD6.substring(iteraciones[2],subD6.length());
        subD6+=e2;
        
        //septima cadena
        String c6d6=subC6+subD6;
        String subC7=c6d6.substring(0,c6d6.length()/2);
        String subD7=c6d6.substring(c6d6.length()/2,c6d6.length());
        String f1=subC7.substring(0,iteraciones[2]);
        String f2=subD7.substring(0,iteraciones[2]);
        subC7=subC7.substring(iteraciones[2],subC7.length());
        subC7+=f1;
        subD7=subD7.substring(iteraciones[2],subD7.length());
        subD7+=f2;
        
        //octava cadena
        String c7d7=subC7+subD7;
        String subC8=c7d7.substring(0,c7d7.length()/2);
        String subD8=c7d7.substring(c7d7.length()/2,c7d7.length());
        String g1=subC8.substring(0,iteraciones[2]);
        String g2=subD8.substring(0,iteraciones[2]);
        subC8=subC8.substring(iteraciones[2],subC8.length());
        subC8+=g1;
        subD8=subD8.substring(iteraciones[2],subD8.length());
        subD8+=g2;
        
        //octava cadena
        String c8d8=subC8+subD8;
        String subC9=c8d8.substring(0,c8d8.length()/2);
        String subD9=c8d8.substring(c8d8.length()/2,c8d8.length());
        String h1=subC9.substring(0,iteraciones[0]);
        String h2=subD9.substring(0,iteraciones[0]);
        subC9=subC9.substring(iteraciones[0],subC9.length());
        subC9+=h1;
        subD9=subD9.substring(iteraciones[0],subD9.length());
        subD9+=h2;
        
        //decima cadena
        String c9d9=subC9+subD9;
        String subC10=c9d9.substring(0,c9d9.length()/2);
        String subD10=c9d9.substring(c9d9.length()/2,c9d9.length());
        String j1=subC10.substring(0,iteraciones[2]);
        String j2=subD10.substring(0,iteraciones[2]);
        subC10=subC10.substring(iteraciones[2],subC10.length());
        subC10+=j1;
        subD10=subD10.substring(iteraciones[2],subD10.length());
        subD10+=j2;
        
        //onceava cadena
        String c10d10=subC10+subD10;
        String subC11=c10d10.substring(0,c10d10.length()/2);
        String subD11=c10d10.substring(c10d10.length()/2,c10d10.length());
        String jj1=subC11.substring(0,iteraciones[2]);
        String jj2=subD11.substring(0,iteraciones[2]);
        subC11=subC11.substring(iteraciones[2],subC11.length());
        subC11+=jj1;
        subD11=subD11.substring(iteraciones[2],subD11.length());
        subD11+=jj2;
        
        //doceava cadena
        String c11d11=subC11+subD11;
        String subC12=c11d11.substring(0,c11d11.length()/2);
        String subD12=c11d11.substring(c11d11.length()/2,c11d11.length());
        String jjj1=subC12.substring(0,iteraciones[2]);
        String jjj2=subD12.substring(0,iteraciones[2]);
        subC12=subC12.substring(iteraciones[2],subC12.length());
        subC12+=jjj1;
        subD12=subD12.substring(iteraciones[2],subD12.length());
        subD12+=jjj2;
        
        //treceaba cadena
        String c12d12=subC12+subD12;
        String subC13=c12d12.substring(0,c12d12.length()/2);
        String subD13=c12d12.substring(c12d12.length()/2,c12d12.length());
        String jjjj1=subC13.substring(0,iteraciones[2]);
        String jjjj2=subD13.substring(0,iteraciones[2]);
        subC13=subC13.substring(iteraciones[2],subC13.length());
        subC13+=jjjj1;
        subD13=subD13.substring(iteraciones[2],subD13.length());
        subD13+=jjjj2;
        
        //catorceaba cadena
        String c13d13=subC13+subD13;
        String subC14=c13d13.substring(0,c13d13.length()/2);
        String subD14=c13d13.substring(c13d13.length()/2,c13d13.length());
        String jjjjj1=subC14.substring(0,iteraciones[2]);
        String jjjjj2=subD14.substring(0,iteraciones[2]);
        subC14=subC14.substring(iteraciones[2],subC14.length());
        subC14+=jjjjj1;
        subD14=subD14.substring(iteraciones[2],subD14.length());
        subD14+=jjjjj2;
        
        //quinceaba cadena
        String c14d14=subC14+subD14;
        String subC15=c14d14.substring(0,c14d14.length()/2);
        String subD15=c14d14.substring(c14d14.length()/2,c14d14.length());
        String jjjjjj1=subC15.substring(0,iteraciones[2]);
        String jjjjjj2=subD15.substring(0,iteraciones[2]);
        subC15=subC15.substring(iteraciones[2],subC15.length());
        subC15+=jjjjjj1;
        subD15=subD15.substring(iteraciones[2],subD15.length());
        subD15+=jjjjjj2;
        
        //dieciseisaba cadena
        String c15d15=subC15+subD15;
        String subC16=c15d15.substring(0,c15d15.length()/2);
        String subD16=c15d15.substring(c15d15.length()/2,c15d15.length());
        String qjjjjjj1=subC16.substring(0,iteraciones[0]);
        String qjjjjjj2=subD16.substring(0,iteraciones[0]);
        subC16=subC16.substring(iteraciones[0],subC16.length());
        subC16+=qjjjjjj1;
        subD16=subD16.substring(iteraciones[0],subD16.length());
        subD16+=qjjjjjj2;
        String c16d16=subC16+subD16;
        
        //metemos los datos a la caja de permutación
         int[] PC2={14, 17, 11, 24, 1, 5, 3, 28,
                   15, 6, 21, 10, 23, 19, 12, 4,
                   26, 8, 16, 7, 27, 20, 13, 2,
                   41, 52, 31, 37, 47, 55, 30, 40,
                   51, 45, 33, 48, 44, 49, 39, 56,
                   34, 53, 46, 42, 50, 36, 29, 32,
        };
        //sacamos llaves 
        k[0]="";
        for (int i = 0; i<PC2.length; i++) {
            k[0] = k[0]+c1d1.charAt(PC2[i]-1);
        }
        k[1]="";
        for (int i = 0; i<PC2.length; i++) {
            k[1] = k[1]+c2d2.charAt(PC2[i]-1);
        }
        k[2]="";
        for (int i = 0; i<PC2.length; i++) {
            k[2] = k[2]+c3d3.charAt(PC2[i]-1);
        }
        k[3]="";
        for (int i = 0; i<PC2.length; i++) {
            k[3] = k[3]+c4d4.charAt(PC2[i]-1);
        }
        k[4]="";
        for (int i = 0; i<PC2.length; i++) {
            k[4] = k[4]+c5d5.charAt(PC2[i]-1);
        }
        k[5]="";
        for (int i = 0; i<PC2.length; i++) {
            k[5] = k[5]+c6d6.charAt(PC2[i]-1);
        }
        k[6]="";
        for (int i = 0; i<PC2.length; i++) {
            k[6] = k[6]+c7d7.charAt(PC2[i]-1);
        }
       k[7]="";
        for (int i = 0; i<PC2.length; i++) {
            k[7] = k[7]+c8d8.charAt(PC2[i]-1);
        }
        k[8]="";
        for (int i = 0; i<PC2.length; i++) {
            k[8] = k[8]+c9d9.charAt(PC2[i]-1);
        }
        k[9]="";
        for (int i = 0; i<PC2.length; i++) {
            k[9] = k[9]+c10d10.charAt(PC2[i]-1);
        }
        k[10]="";
        for (int i = 0; i<PC2.length; i++) {
            k[10] = k[10]+c11d11.charAt(PC2[i]-1);
        }
        k[11]="";
        for (int i = 0; i<PC2.length; i++) {
            k[11] = k[11]+c12d12.charAt(PC2[i]-1);
        }
        k[12]="";
        for (int i = 0; i<PC2.length; i++) {
            k[12] = k[12]+c13d13.charAt(PC2[i]-1);
        }
        k[13]="";
        for (int i = 0; i<PC2.length; i++) {
            k[13] = k[13]+c14d14.charAt(PC2[i]-1);
        }
        k[14]="";
        for (int i = 0; i<PC2.length; i++) {
            k[14] = k[14]+c15d15.charAt(PC2[i]-1);
        }
        k[15]="";
        for (int i = 0; i<PC2.length; i++) {
            k[15] = k[15]+c16d16.charAt(PC2[i]-1);
        }
        return k;
    }
        
}
