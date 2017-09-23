/*
Ignacio Muriel Gonzalez Rul 140101
 * Expresion regular usada : abc(aa)*
el programa toma cada estado como un metodo de la clase Automata, en cada metodo se evalua el caracter
que se esta mandando en el estado, si el caracter mandado coincide con las condiciones
para que se cumpla una cadena valida, el programa continua en caso contrario la cadena no es valida y la ejecucion termina

el programa cuenta con un contador, para ir recorriendo el arreglo de caracteres, el cual se crea atraves de la cadena insertada, la cual es 
convertida a un arreglo de caracteres, cada ves que se pasa de estaod el contador aumenta en una unidad, para evaluar en el siguient eestado el siguiente caracter

teniendo en cuenta que la cadena debera empezar con a, y esta a debera de estar concatenada con bc, 

y despues hay dos opciones, es decir abc es una cadena valida, pero podemos tener un numero ilimitado de a siempre y cuando este sea par
 
observar expresion regular = abc(aa)* la cadena debera terminar con un numero par de 'a'

 */
package automata;
import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author Nacho
 */
public class Automata {
    int contador;
    char [] caracter;
    boolean EstadoValido;
  
    
    public static void main(String[] args) {
       String condition="si";
        while(condition.equals("si")){
        String ER;
        System.out.println("automata a evaluar : abc(aa)*");
        System.out.println("introduzca la cadena a evaluar");
       Scanner scn =new Scanner(System.in);
       Automata at =new Automata();
       ER=scn.next();
       //se guardan la cadena insertada en un arreglo de caracteres
       at.caracter=ER.toCharArray();
       at.Estadoq0();
       System.out.println("desea introducir otra cadena? R=si, R=no");
       condition=scn.next();
     }
       
    }
    
    public void Estadoq0(){
        //estadoq0 para pasar de este estado la cadena almenos debera contener una a
        contador=0;
        EstadoValido=false;
        if(contador<caracter.length){
            System.out.println("ENTRANDO Q0");
            if(caracter[contador]=='a'){
                contador ++;
                Estadoq1();
            }
        
        }else{
            System.out.println("cadena no valida");
        }
    
    }
    
   public void Estadoq1(){
       //si se llego a q1 es porque la cadena almenos tiene una a, en este estaod se verifica que despues de la a siga la b 
       if(contador<caracter.length){
           if(caracter[contador]=='b'){
               System.out.println("ENTRANDO Q1");
               contador++;
               Estadoq2();
           }else{
                System.out.println("cadena no valida para este automata");
           }
           
       }else{
           System.out.println("no se cuenta con la concatencion a b c");
       }
   }
   
  public void Estadoq2(){
      //si se llego hasta aqui es porque la cadena lleva el sigueinte orden:ab aqui se revisa, que el sigueinte caracter sea c
      if (contador<caracter.length){
          if(caracter[contador]=='c'){
              System.out.println("ENTRANDO Q2");
              contador++;
              Estadoq3();
          }else{
              System.out.println("cadena no valida");
          }
      
      }
  
  }
  
  public void Estadoq3(){
      //si se llego aqui la cadena puede ser valida o no, eso dependera de si el contador sigue siendo menor a la longitud de la cadena insertada
      //en caso de que no, se valida que el arreglo caracter en contador-1 sea c o a sera valida
      if(contador<caracter.length){
         if(caracter[contador]=='a'){
             System.out.println("ENTRANDO Q3");
          contador++;
          Estadoq4();
         }else{
             System.out.println("cadena NO valida, se esperaba una a");
         
        }
      }else {
          if(contador==caracter.length){
              if(caracter[contador-1]=='c'|| caracter[contador-1]=='a'){
                  System.out.print("Cadena valida");
              }else{
                  System.out.print("Cadena no valida se esperaba almenos una 'a' mas ");
              }
          }
      }
          
       
     
  }
  
  public void Estadoq4(){
      //si se llego a q4, la cadena obligatoriamente tendra que llevar aa, en este estado se valida la priemra a, si es correcto
      //se vuelve al estado q3 y si el contador sigue siendo mas pequeño que la cadena se debera evaluar que siempre el numero de a consecutivas tiene que ser par
      //en caso contrario si la cadena es igual al contador, se evalua en q3 que la ultima letra sea a, si es asi la cadena es valida
      
      if(contador<caracter.length){
          System.out.println("ENTRANDO Q4");
         if(caracter[contador]=='a'){
          contador++;
          Estadoq3();
         }else{
         System.out.println("Cadena no valida se esperaba otra a");
         }
      }else{
          System.out.println("Cadena no valida se esperaba otra a");
      }
  }
  
}
