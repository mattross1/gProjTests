package com.example.ICETEAM;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {

	public static void main(String[] args) {
		
	System.out.print(test(RemoveFail.class, "RemoveFail"));
	
	System.out.print(test(RemoveSuccess.class, "RemoveSuccess"));
	
	System.out.print(test(SignupSuccess.class, "SignupSuccess"));
	
	System.out.print(test(SignupFail.class, "SignupFail"));
	
	System.out.print(test(UpdateSuccess.class, "UpdateSuccess"));
	
	System.out.print(test(UpdateFail.class, "UpdateFail"));
	
	System.out.print(test(SearchSuccess.class, "SearchSuccess"));
	
	System.out.print(test(SearchNum.class, "SearchNum"));
	
	System.out.print(test(SearchEmpty.class, "SearchEmpty"));
	
	System.out.print(test(SupportSuccess.class, "SupportSuccess"));
		

	}
	
	public static String test(Class classn, String opString)
	{
		Result res = JUnitCore.runClasses(classn);
		for (Failure fail : res.getFailures())
		{
			return "" + opString + ": " + fail.toString() + "\n";
		}
		
		return "" + opString + ": " + res.wasSuccessful() + "\n";
	}

}
