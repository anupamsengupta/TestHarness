package com.tpt.testharness.test;

/**
 * The Interface TestSet.
 */
public interface TestSet {
	
	/** The default times to execute. */
	int DEFAULT_TIMES_TO_EXECUTE = 3000;
	
	/** The default iterations to execute. */
	int DEFAULT_ITERATIONS_TO_EXECUTE = 3000;

	/**
	 * Gets the tests.
	 *
	 * @return the tests
	 */
	Test[] getTests();
	
	/**
	 * Inits the.
	 */
	void init();
	
	/**
	 * Gets the default times to execute.
	 *
	 * @return the default times to execute
	 */
	long getDefaultTimesToExecute();
	
	/**
	 * Gets the test title.
	 *
	 * @return the test title
	 */
	String getTestTitle();

	/**
	 * Gets the test description.
	 *
	 * @return the test description
	 */
	String getTestDescription();
	
}
