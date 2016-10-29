/**
 * Created by Oleg Serzhant on 15.10.2016.
 */

class In2Post {
    private Stack<Character> theStack;
    private String input;
    private String output = "";

    public In2Post(String in) {
        input = in;
        int stackSize = input.length();
        theStack = new Stack<>(stackSize);
    }

    public String doTrans()      // Преобразование в постфиксную форму
    {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            //theStack.displayStack("For " + ch + " ");
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);        // (приоритет 1)
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);        // (приоритет 2)
                    break;
                case '^':
                    gotOper(ch, 3);        // (приоритет 3)
                    break;
                case '(':
                    theStack.push(ch);     // Занести в стек
                    break;
                case ')':
                    gotParen(ch);          // Извлечение операторов
                    break;
                default:                   // Остается операнд
                    output = output + ch;  // Записать в выходную строку
                    break;
            }
        }
        while (!theStack.isEmpty())           // Извлечение оставшихся операторов
        {
            //theStack.displayStack("While ");
            output = output + theStack.pop();
        }
        //theStack.displayStack("End   ");
        return output;                        // Возвращение постфиксного выражения
    }

    public void gotOper(char opThis, int prec1) {       // Чтение оператора из входной строки
        while (!theStack.isEmpty()) {
            char opTop = (char)theStack.pop();
            if (opTop == '(')            // Если это '('
            {
                theStack.push(opTop);      // Вернуть '('
                break;
            } else                          // Оператор
            {
                int prec2;                        // Приоритет нового оператора
                if (opTop == '+' || opTop == '-') // Определение приоритета
                    prec2 = 1;
                else if (opTop == '^')
                    prec2 = 3;
                else prec2 = 2;
                if (prec2 < prec1)          // Если приоритет нового оператора
                {                           // меньше приоритета старого
                    theStack.push(opTop);   // Сохранить новый оператор
                    break;
                } else                         // Приоритет нового оператора
                    output = output + opTop;  // не меньше приоритета старого
            }
        }
        theStack.push(opThis);               // Занесение в стек нового оператора
    }

    public void gotParen(char ch) {          // Прочитана закрывающая скобка
        while (!theStack.isEmpty()) {
            char chx = (char)theStack.pop();
            if (chx == '(')                  // Если извлечен элемент ‘(‘
                break;                       // Прервать выполнение
            else                             // Если извлечен оператор
                output = output + chx;       // Вывести в постфиксную строку
        }
    }
}