package com.zuhi;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	public static char[][] TOKENS = {{'{','}'},{'[',']'},{'(',')'}};
	
	public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
		for(char c:expression.toCharArray()){
			if(isOpenTerm(c)){
				stack.push(c);
			}
			else{
				if( stack.isEmpty() || !matches(stack.pop(),c)){
					return false;
				}
			}
		}
		return stack.isEmpty();
    }
	
	public static boolean matches(char openTerm, char closeTerm) {
		for(char[] array : TOKENS){
			if(array[0] == openTerm){
				return array[1] == closeTerm;
			}	
		}
		return false;
	}

	public static boolean isOpenTerm(char c) {
		for(char[] array : TOKENS){
			if(array[0] == c){
				return true;
			}	
		}
		return false;
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        while(number > 0){
            String expression = input.next();
            if(isBalanced(expression)){
            	System.out.println("Expression is balanced");
            }else{
            	System.out.println("Expression is not balanced");
            }
            
            number--;
        }
        input.close();
	}
}
