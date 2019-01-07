/**
*    1.3.9 Write a program that takes from standard input an expression without left parentheses
*          and prints the equivalent infix expression with the parentheses inserted. For example, given the input:
*          1 + 2 ) * 3 - 4 ) * 5- 6 ))). your program should print (( 1 + 2 ) * ( ( 3 -4 ) * ( 5 - 6 ))
*
*		   Push operators into one stack
*		   Push values into another stack
*          Ignore the left parentheses
*          Pop one operator from the stack and the values from another stack when it meets the right parentheses, and push the result into the stack;
*          after process it all. reverse it, then we have the correct result;
*/
import java.util.Stack;
public class LeftParenthesesInsert
{
	public static void main(String[] args)
	{
	    String expression = "1 + 2 ) * 3 - 4 ) * 5- 6 )))";
		// use two stacks to solve this problem
		// Operators stack
		Stack<String> operators = new Stack<String>();
		// Values stack
		Stack<String> values = new Stack<String>();
		for (int i = 0; i < expression.length(); i++)
		{
			char item = expression.charAt(i);
			String character = String.valueOf(item);
			if (character.equals("+") || character.equals("-") || character.equals("*") || character.equals("/"))
			{
				operators.push(character);
			}
			else if (character.equals(")"))
			{
				String correctExpression = ")" + values.pop() + operators.pop() + values.pop() + "(";
				values.push(correctExpression);
			}
			else if (!character.equals(" "))
			{
				values.push(character);
			}
		}
		String result = values.pop();
		String sequence = "";
		for (int j = result.length() - 1; j >= 0; j--)
		{
			sequence += result.charAt(j);
		}
		System.out.println("sequence is :" + sequence);
	}
}