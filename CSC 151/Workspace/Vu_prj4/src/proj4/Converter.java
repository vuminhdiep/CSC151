package proj4;

/**
 * CLASS INVARIANTS
 * This class is used to convert infix to postfix
 * the fileReader is an instance variable to store the input path
 * The operator and operand is represented by the Token with the same name.
 * For example, "+" is stored in Token Plus, "-" is stored in Token Minus, "*" is stored in Token Multiply
 * "/" is stored in Token Divide, "^" is stored in Token Exponent,
 * "(" is stored in Token LeftParen, ")" is stored in Token RightParen
 * ";" is stored in Token Semicolon. The operand like "A", "B", "C", etc. is stored in Token Operand
 * 
 * @author Emma Vu
 * @version 5/23/2020
 */
public class Converter{
	
	/**
	 * non-default constructor; Gradescope needs this to run tests
	 * @param infile path to the input file 
	 */
	private FileReader fileReader;
    public Converter(String infile)
    {
        fileReader = new FileReader(infile);
    }

	/**
	 * Read the next token, identify and make the new Token correct type, handle it correspondingly by adding the
	 * right type to the returned string when not reaching ";".
	 * After reaching ";", print out the console infix --> postfix and then empty both infix and postfix.
	 * Read the next token until reaching "EOF", meaning reading all the input file
	 */

	public void convert(){
    	Stack<Token> tokenStack = new Stack<Token>();
    	String toConvert = fileReader.nextToken();
    	String postFix = "";
    	String inFix = "";

    	while(!toConvert.equals("EOF")){
    		Token tokenNext = identifyTokenType(toConvert);
    		postFix += tokenNext.handle(tokenStack);


    		if(!toConvert.equals(";")){
    			inFix += toConvert;
			}

    		else {
				System.out.println(inFix + " --> " + postFix);
				postFix = "";
				inFix = "";
			}
    		toConvert = fileReader.nextToken();

		}


	}

	/**
	 * Identify the correct type of Token from the input string
	 * For example, "+" is stored in Token Plus, "-" is stored in Token Minus, "*" is stored in Token Multiply
	 * "/" is stored in Token Divide, "^" is stored in Token Exponent,
	 * "(" is stored in Token LeftParen, ")" is stored in Token RightParen
	 * ";" is stored in Token Semicolon.
	 * Else, the operand like "A", "B", "C", etc. is stored in Token Operand("A"), Operand("B"), Operand("C"), etc.
	 * @param toIdentify the input string to identify the Token
	 * @return the correct type of Token corresponds to the input string
	 */

	private Token identifyTokenType(String toIdentify){
    	if(toIdentify.equals("+")){
    		return new Plus();
		}
    	else if(toIdentify.equals("-")){
    		return new Minus();
		}
    	else if(toIdentify.equals("*")){
    		return new Multiply();
		}
    	else if(toIdentify.equals("/")){
    		return new Divide();
		}
    	else if(toIdentify.equals("^")){
    		return new Exponent();

		}
    	else if(toIdentify.equals("(")){
    		return new LeftParen();
		}
    	else if(toIdentify.equals(")")){
    		return new RightParen();
		}
    	else if(toIdentify.equals(";")){
    		return new Semicolon();
		}
    	else{
    		return new Operand(toIdentify);
		}
	}

}
