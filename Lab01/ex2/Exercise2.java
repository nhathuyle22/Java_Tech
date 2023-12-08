import vn.edu.tdtu.ArrayOutput;
import vn.edu.tdtu.ArrayHandler;
public class Exercise2 {
    public static void main(String[] args){
        int [] a = {22,5,8,2,3,6};
        int [] b = {12,1,7,4,77,23};
        ArrayOutput.print(a);
        ArrayOutput.print(b);
        int [] c = ArrayHandler.merge(a,b);
        ArrayOutput.print(c);
        ArrayHandler.sort(c);
        ArrayOutput.print(c);
        ArrayOutput.write(c,"output.txt");
    }
}
