/**
 * Created by Oleg Serzhant on 15.10.2016.
 */
public class ParsePost {
    private Stack<Integer> theStack;
    private String input;

    public ParsePost(String s) {
        input = s;
    }

    public int doParse() {
        theStack = new Stack<>(20);
        char ch;
        int j;
        int num1, num2, interAns;
        for (j = 0; j < input.length(); j++)               // Для каждого символа
        {
            ch = input.charAt(j);                          // Чтение символа

            if (ch >= '0' && ch <= '9')                    // Если это цифра
                theStack.push((int) (ch - '0'));           // Занести в стек
            else                                           // Если это оператор
            {
                num2 = theStack.pop();                     // Извлечение операндов
                num1 = theStack.pop();
                switch (ch)                                // Выполнение арифметической операции
                {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    case '^':
                        interAns = (int) Math.pow(num1, num2);
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(interAns);        // Занесение промежуточного результата в стек
            }
        }
        interAns = theStack.pop();              // Получение результата
        return interAns;
    }

}
