package com.stack;

/**
 * This class uses stack class to evaluate a string expression.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-07
 */
public class EvalExpression {
	private static final String ERROR = "Invalid Expression!";

	// Default constructor
	public EvalExpression() {
	}

	/**
	 * This method evaluates an expression string.
	 * 
	 * @param expr String expression to be evaluated.
	 * @return Integer Result obtained after evaluating the expression string.
	 */
	public static String evaluate(String expr) {
		String[] tokens = expr.split(" ");
		Stack values = new Stack();
		Stack operators = new Stack();

		for (int i = 0; i < tokens.length; i++) {
			if (isNumber(tokens[i])) {
				values.push(tokens[i]);
			}

			else if ("true".equals(tokens[i]) || "false".equals(tokens[i])) {
				values.push(tokens[i]);
			}

			else if ("(".equals(tokens[i])) {
				operators.push(tokens[i]);
			}

			else if (")".equals(tokens[i])) {
				while (!"(".equals(operators.peek())) {
					values.push(performOp(operators.pop(), values.pop(), values.pop()));
				}
				operators.pop();
			}

			else {
				int precedence = getPrecedence(tokens[i]);

				if (precedence != -1) {
					while (!"!".equals(operators.peek()) && !operators.isEmpty()
							&& precedence <= getPrecedence(operators.peek())) {
						values.push(performOp(operators.pop(), values.pop(), values.pop()));
					}
					operators.push(tokens[i]);
				} else {
					return ERROR;
				}
			}
		}

		while (!operators.isEmpty()) {
			if ("!".equals(operators.peek())) {
				values.push(performOp(operators.pop(), values.pop()));
			} else {
				values.push(performOp(operators.pop(), values.pop(), values.pop()));
			}
		}

		String answer = values.pop();

		if (values.isEmpty()) {
			return answer;
		} else {
			return ERROR;
		}
	}

	/**
	 * Returns precedence of an operator.
	 * 
	 * @param op Given operator.
	 * @return Integer Precedence of operator.
	 */
	public static int getPrecedence(String op) {
		switch (op) {
		case "!":
			return 7;
		case "*":
			return 6;
		case "/":
			return 6;
		case "+":
			return 5;
		case "-":
			return 5;
		case "<":
			return 4;
		case ">":
			return 4;
		case "<=":
			return 4;
		case ">=":
			return 4;
		case "==":
			return 3;
		case "!=":
			return 3;
		case "&&":
			return 2;
		case "||":
			return 1;
		default:
			return -1;
		}
	}

	/**
	 * Performs arithmetic operation on numbers and boolean values based on the
	 * given operator.
	 * 
	 * @param op Given operator.
	 * @param a  First operand.
	 * @param b  Second operand.
	 * @return String Result after performing operation.
	 */
	public static String performOp(String op, String b, String a) {
		if (isNumber(a) && isNumber(b)) {
			switch (op) {
			case "+":
				return Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
			case "-":
				return Integer.toString(Integer.parseInt(a) - Integer.parseInt(b));
			case "*":
				return Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
			case "/":
				if ("0".equals(b)) {
					throw new UnsupportedOperationException("Cannot divide by zero!");
				}
				return Integer.toString(Integer.parseInt(a) / Integer.parseInt(b));
			case "<":
				return String.valueOf(Integer.parseInt(a) < Integer.parseInt(b));
			case ">":
				return String.valueOf(Integer.parseInt(a) > Integer.parseInt(b));
			case "<=":
				return String.valueOf(Integer.parseInt(a) <= Integer.parseInt(b));
			case ">=":
				return String.valueOf(Integer.parseInt(a) >= Integer.parseInt(b));
			case "==":
				return String.valueOf(Integer.parseInt(a) == Integer.parseInt(b));
			case "!=":
				return String.valueOf(Integer.parseInt(a) != Integer.parseInt(b));
			default:
				return ERROR;
			}
		}

		else if (("true".equals(a) || "false".equals(a)) && ("true".equals(b) || "false".equals(b))) {
			switch (op) {
			case "==":
				return String.valueOf(Boolean.parseBoolean(a) == Boolean.parseBoolean(b));
			case "!=":
				return String.valueOf(Boolean.parseBoolean(a) != Boolean.parseBoolean(b));
			case "&&":
				return String.valueOf(Boolean.parseBoolean(a) && Boolean.parseBoolean(b));
			case "||":
				return String.valueOf(Boolean.parseBoolean(a) || Boolean.parseBoolean(b));
			default:
				return ERROR;
			}
		}

		else {
			return ERROR;
		}
	}

	/**
	 * Performs unary arithmetic operation on boolean values.
	 * 
	 * @param op Given operator.
	 * @param a  Given operand.
	 * @return String Result after performing operation.
	 */
	public static String performOp(String op, String a) {
		if ("!".equals(op) && "true".equals(a) || "false".equals(a)) {
			return String.valueOf(!Boolean.parseBoolean(a));
		} else {
			return "";
		}
	}

	/**
	 * Checks whether the given string input is a number or not.
	 * 
	 * @param token String input to be checked for number.
	 * @return boolean True if given string represents an integer, False otherwise.
	 */
	public static boolean isNumber(String token) {
		try {
			Integer.parseInt(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		String expressions[] = { "2 + 4 == 7", "( 2 != 2 ) || 3 == 3 && ( 2 * 3 == 3 * 2 )", "true && false",
				"true == 67 > 8 && 77 > 87 || false", "! ! true", "4 == 5 == ! 6 < 7 && true", "2 == ! ! 2 + 3 < 7",
				"2 + 4 < 7 == 5 > -78 == ! true", "4 4 4 - 9", "4 4 - 8 - 8 + + -", "! 5 + 7 == 12", "2 && 3",
				"2 == 5 > 9 == 8" };

		try {
			for (String expr : expressions) {
				System.out.println("\n" + "\"" + expr + "\"" + " => " + EvalExpression.evaluate(expr));
			}
		} catch (Exception e) {
			System.out.println("\n" + e.toString());
		}
	}
}
