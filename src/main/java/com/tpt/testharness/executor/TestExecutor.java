package com.tpt.testharness.executor;

import java.util.ArrayList;
import java.util.Collection;

import com.tpt.testharness.test.Test;
import com.tpt.testharness.test.TestSet;

/**
 * The Class TestExecutor.
 */
public class TestExecutor
{

	/**
	 * Execute the test set.
	 *
	 * @param testSet the test set
	 * @param times the times
	 * @return the collection
	 */
	public static Collection<String> execute(TestSet testSet, long times) {
		ArrayList<String> results = new ArrayList<String>();
		
		testSet.init();
		
		if( times <= 0 ) times = testSet.getDefaultTimesToExecute();
		
		
		for(Test test : testSet.getTests()) {
			long time = execute(test, times);
			results.add(test.getTestName() + ": " + time + " ms.");
		}
		
		return results;
	}
	
	/**
	 * Execute the test.
	 *
	 * @param test the test
	 * @param times the times
	 * @return the long
	 */
	public static long execute(Test test, long times) {
		long startTime = System.nanoTime();
		
		for(long i = 0; i < times; i++) {
			test.executeTest();
		}
		
		long endTime = System.nanoTime();
		
		return (endTime - startTime) / 1000000;
	}
}
