import edu.princeton.cs.algs4;
public class PrefixIntoInfix
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
			if (str.equals(")"))
			{
				operators.push(str);
			}
			else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
			{
				boolean isRightParen;
				boolean isEmpty;
				boolean isWeighterOperater;
				int i = 0;
				do 
				{
					if (i != 0)
					{
						values.push(operators.pop());
					}
					i ++;
					isRightParen = false;
					isWeighterOperater = false;
					if (!operators.isEmpty())
					{
						String stackTop = operators.peek();
						isRightParen = stackTop.equals(")");
						if (stackTop.equals("+") || stackTop.equals("-"))
						{
							isWeighterOperater = true;
						}
						else if ((stackTop.equals("*") || stackTop.equals("/"))
                                && (str.equals("*") || str.equals("/")))
						{
							isWeighterOperater = true;
						}
					}
					if (operators.isEmpty() || isRightParen || isWeighterOperater)
					{
						operators.push(str);
						break;
					}
				}
                while(!(isEmpty || isRightParen || isHigherOperator))

			}
			else if (str.equals("("))
			{
				String poppedString = operators.pop();
				while (!poppedString.equals(")"))
				{
					values.push(poppedString);
					poppedString = operators.pop();
				}
			}
			else 
			{
				values.push(str);
			}
			
		}
        for (String str:operators)
        {
            values.push(str);
        }
        for (String str:values)
        {
            System.out.print(str);
        }
	}
}