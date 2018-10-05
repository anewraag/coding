package practice.templates;

/**
 * Created by asaxena on 9/30/2018.
 */
public class ArrayHelper {
    public static void print2dArray(Object[][] array, int rows, int columns){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print((array[i][j])+" ");
            }
            System.out.println();
        }
    }
}
