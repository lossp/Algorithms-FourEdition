import edu.princeton.cs.algs4.Stack;
/**
*  Here is only the execrise aboout prefix and infix.
*  Computer usually use infix expression to calculate.
*  Here is basically i know as a new beginner.
*/
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
			// get one character out of the reverseStack
			String str = reverseStack.pop();

			// if the str equals ")", then push it into the operator stack
			if (str.equals(")"))
			{
				operators.push(str);
			}
			/** 
			*   if the str is one of the "+ - * /", keeping looping under the four conditions below
			*      1.if the stack is empty, then push it into the stack and end this step.
			*      2.if the top of stack is ")", then push it into the stack and end this step.
			*      3.if this operator at least have the weight as the top stack element, then push it into the stack and end this step.
			*      4.otherwise, operator keeps poping out of the stack operators, util meets the three condition above, then push it into the stack.
			*/      
			else if (str.equals("+") || str.equals('-') || str.equals("*") || str.equals("/"))
			{
				boolean isRightParen;
				boolean isWeighterOperator;
				int i = 0;
				do
				{
					if (i != 0)
					{
						values.push(operators.pop());
					}
					i++;
					isRightParen = false;
					isWeighterOperator =false
					if (!operators.isEmpty())
					{
						String stackTop = operators.peek();
						isRightParen = stackTop.equals(")");
						if (stackTop.equals("+") || stackTop.equals("-"))
						{
							isWeighterOperator = true;
						}
						else if ((stackTop.equals("*") || stackTop.equals("/")) && (str.equals("*") || str.equals("/")))
						{
							isWeighterOperator = true;
						}
					}
					if (operators.isEmpty() || isRightParen || isWeighterOperator)
					{
						operators.push(str);
						break;
					}
				} while (!(isEmpty || isRightParen || isWeighterOperator))
			}

			// if the str equals "(", then pop out the charactor out of the operators until it meets the ")", and toss the ")"
			else if (str.equals(")"))
			{
				String poppedString = operators.pop();
				while(!poppedString.equals(")"))
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
		for (String str: values)
		{
			System.out.print(str);
		}
        
	}
}