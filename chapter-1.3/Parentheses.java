import java.util.Stack;
/**
*   1.3.4
*   Write a stack client Parentheses that reads in a text stream from standard input
*   and uses a stack to deterine whether its parentheses are properly balanced.
*   For example, you program should print true for [()]{}{()()} and false for [(])
*   (Only fits the standard parenthese protocal can be true);
*/
public class Parentheses {


  public static void main(String[] args)
  {
  	boolean isPaired = true;
  	String string = "[(])";
  	Stack<String> parentheseStack = new Stack<String>();
  	for (int i = 0; i < string.length(); i++)
  	{
  	  char item = string.charAt(i);
  	  String character = String.valueOf(item);
  	  if (character.equals("["))
  	  {
  	  	parentheseStack.push(character);
  	  }
  	  else if (character.equals("("))
  	  {
  	  	parentheseStack.push(character);
  	  }
  	  else if (character.equals("{"))
  	  {
  	  	parentheseStack.push(character);
  	  }
  	  else if (character.equals("]"))
  	  {
  	  	String poppedString = parentheseStack.pop();
  	  	if (!poppedString.equals("[")) 
  	  	{
  	  	  isPaired = false;
  	  	  break;
  	  	}
  	  }

  	  else if (character.equals(")"))
  	  {
  	  	String poppedString = parentheseStack.pop();
  	  	if (!poppedString.equals("(")) 
  	  	{
  	  	  isPaired = false;
  	  	  break;
  	  	}
  	  }

  	  else if (character.equals("}"))
  	  {
  	  	String poppedString = parentheseStack.pop();
  	  	if (!poppedString.equals("{")) 
  	  	{
  	  	  isPaired = false;
  	  	  break;
  	  	}
  	  }
  	}

  	if (!parentheseStack.isEmpty()) 
  	{
  	  isPaired = false;
  	}
  	System.out.println(isPaired);
  }
}