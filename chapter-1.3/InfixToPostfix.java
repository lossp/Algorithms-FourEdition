import edu.princeton.cs.algs4.*;
/**
*	1.3.11 Write a program EvaluatePostfix that takes a postfix expression from standard input, 
*		   evaluates it, and prints the value. (Piping the output of your program from the previous exercise to this program gives
*		   equivalent behavior to Evaluate)	
*
*
*
*	infix to postfix algorithm
*		1.When it comes to vlaue, push it into value stack
*		2.When meets the open paren, push it into operator stack
*		3.When meets the close paren, first of all. To see if the operator is empty or not
*			if it`s empty, throw an exception and handle it.
*			if it`s not, pop out the operators from the stack until it meets a open paren, if it meets no open paren,
*			throw an exception and handle it.
*		4.When the operator is one of "+ - * /"
*			a) loop: pop out elements from stack under these circumstance
*					1): stack is not empty 
*						and stack top element is not an open paren
*						and stack top element is not lighter than the operator
*           b) else push the operator into the stack
*		5.When then infixExpression is all read in. If there are any elements left in the stack, pop them out.
*		  If the element is an empty paren, it means that`s not a match, throw an Exception.
*/

public class InfixToPostfix
{
	public static void main(String[] args)
	{
		String infixExpression = "2*3/(2-1)+3*(4-1)";
		Stack<String> operators = new Stack<String>();
		for (int i = 0; i < infixExpression.length(); i++)
		{
			char item = infixExpression.charAt(i);
			String str = String.valueOf(item);
			if (str.equals("("))
			{
				operators.push(str);
			}
			else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
			{
				boolean isLighter = false;
				boolean isEmpty = operators.isEmpty();
				boolean isOpenParen = false;
				if (!isEmpty) 
				{
					String stackTop = operators.peek();
					isOpenParen = stackTop.equals("(");
					if ((stackTop.equals("+") || stackTop.equals("-")) && (str.equals("*") || str.equals("/"))) {
                        isLighter = true;
                    }
				}
				if (!(isEmpty || isOpenParen || isLighter))
				{
					for (int j = 0; j < operators.size(); j++)
					{
						StdOut.print(operators.pop());
					}
				}
				operators.push(str);

			}
			else if (str.equals(")"))
			{
				String poppedString = operators.pop();
				while (!poppedString.equals("("))
				{
					StdOut.print(poppedString);
					poppedString = operators.pop();
				}
			}
			else
			{
				StdOut.print(str);
			}
		}
		for (String str: operators)
		{
			StdOut.print(str);
		}
	}
}