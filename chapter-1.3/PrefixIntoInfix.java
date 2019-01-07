import java.util.Stack;
public class prefixIntoInfix
{
	public static void main(String[] args)
	{
		String infixExpression = "2*3/(2-1)+3*(4-1)";
		String prefixExpress;
		Stack<String> operators = new Stack<String>();
		Stack<String> values = new Stack<String>();
		Stack<String> reverseStack = new Stack<String>();
		// first, reverse the infixExpression as a string;
		for (int i = 0; i < infixExpression.length(); i++)
		{
			char item = infixExpression.charAt(i);
			String character = String.valueOf(item);
			reverseStack.push(character);
		}
		// now pop out the character from reverseStack. now we got the character of infixExpress in a reverse way
		while(!reverseStack.isEmpty())
		{
			String str = reverseStack.pop();
			if (str.equals(")") || str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
			{
				operators.push(str);
			}
			else if (str.equals("("))
			{
				String oneExpressionResult = "(" + values.pop() + operators.pop() + values.pop() + operators.pop();
				values.push(oneExpressionResult);
			}
			else
			{
				values.push(str);
			}
		}

		// when the reverse stack is empty, pop out the operators and values
		// combine two values and one operator together, and push it into values afterwards
		while(!operators.isEmpty())
		{
			String result = values.pop() + operators.pop() + values.pop();
			values.push(result);
		}
		prefixExpress = values.pop();
		System.out.println("the prefix express is : " + prefixExpress);
	}
}