package com.galaxy.merchant;

/**
 * This class maps the error codes to error messages
 * Use printMessage() method to notify the user
 * Must be provided with error code in printMessage() method
 * 
 * @author Karan
 *
 */
public class ErrorMessage {


	public ErrorMessage(){

	}

	/**
	 * This method prints the message for the particular error code
	 */
	public void printMessage(ErrorCodes error)
	{
		String message= getMessage(error);

		if(message !=null)
			System.out.println(message);

	}

	public String getMessage(ErrorCodes error)
	{
		String message= null;

		switch(error)
		{
		case NO_INPUT : message = "No input was specified ! Program exited";
		break;
		case INVALID : message = "Input format is wrong ! input discarded";
		break;
		case INVALID_ROMAN_CHARACTER : message = "Illegal character specified in roman number ! Input discarded";
		break;
		case INVALID_ROMAN_STRING : message =  "Wrong Roman number, voilated roman number format";
		break;
		case INCORRECT_LINE_TYPE : message =  "Exception caused during processing due to incorrect line type supplied";
		break;
		case NO_IDEA : message = "I have no idea what you are talking about";
		break;
		default : break;
		}
		return message;
	}
}
