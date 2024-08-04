package com.tpt.testharness;

import com.tpt.testharness.executor.TestExecutor;
import com.tpt.testharness.test.impl.LongVsIntSimpleTest;

import java.util.Collection;

/**
 * The Tester Class.
 */
public class Tester
{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args)
	{
		Collection<String> testResults = null;
		testResults = TestExecutor.execute(new LongVsIntSimpleTest(), 2000000);
		/*System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "16");
		testResults = TestExecutor.execute(new LongVsIntSimpleTest(), 20000);
		listTestResults(testResults);
		testResults = TestExecutor.execute(new AddOperationLinkedListVsArrayListTest(), 20000);
		listTestResults(testResults);
		testResults = TestExecutor.execute(new GetOperationLinkedListVsArrayListTest(), 20000);
		listTestResults(testResults);
		testResults = TestExecutor.execute(new OuterIterationVsStreamAndCollectPrimeNumberTest(), 20000);
		testResults = TestExecutor.execute(new WordCloudingInternalStreamVsExternalIterationTest(), 100);*/
		listTestResults(testResults);
		System.out.println("Processors - " + Runtime.getRuntime().availableProcessors());
	}
	
	/**
	 * List test results.
	 *
	 * @param testResults the test results
	 */
	private static void listTestResults(Collection<String> testResults)
	{
		for(String testResult : testResults)
		{
			System.out.println("testResults - " + testResult);
		}
	}

}
