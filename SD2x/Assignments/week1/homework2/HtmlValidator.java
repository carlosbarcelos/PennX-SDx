package Assignments.week1.homework2;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> returnStack = new Stack<HtmlTag>();
		HtmlTag t;
		while(!tags.isEmpty()){
			t = tags.remove();
			if(t.isSelfClosing()){ //is self closing tag
				continue;
			} else if(t.isOpenTag()){ //is opening tag
				returnStack.push(t);
			} else { //is closing tag
				if(returnStack.isEmpty()){ //is there anything on the stack
					System.err.println("Uncalled for closing tag. : " + t.toString());
					return null;
				} else if(t.matches(returnStack.peek())){ //is this a matching closing tag
					returnStack.pop();
				} else{
					System.err.println("Closing tag out of order. : " + t.toString());
					return returnStack;
				}
			}
		}
		System.out.println(returnStack);
		return returnStack;
	}
	
}

