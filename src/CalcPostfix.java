import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Oleg Serzhant on 15.10.2016.
 */

public class CalcPostfix {
    public static void main(String[] args) throws IOException {
        String input, out;
        int output;

        while(true) {

            System.out.print("Enter arithmetic expression: ");
            System.out.flush();
            input = getString();
            if (input.equals("")) break;

            In2Post theTrans = new In2Post(input);
            out = theTrans.doTrans();
            System.out.println("Postfix is " + out);

            ParsePost aParser = new ParsePost(out);
            output = aParser.doParse();
            System.out.println("Evaluates to " + output + '\n');
        }

    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}

