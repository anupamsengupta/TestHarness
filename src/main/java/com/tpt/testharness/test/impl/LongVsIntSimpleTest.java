package com.tpt.testharness.test.impl;

import com.tpt.testharness.test.Test;
import com.tpt.testharness.test.TestSet;

/**
 * The Class LongVsIntSimpleTest.
 */
public class LongVsIntSimpleTest implements TestSet {
	
	/** The iterations. */
	private int iterations;
	
	/**
	 * The Class LongTest.
	 */
	public class LongTest implements Test {
		
		/** The i. */
		long i;
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#getTestName()
		 */
		public String getTestName() {
			return "for(long i...";
		}
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#executeTest()
		 */
		public void executeTest() {
			for(i = 0; i < iterations; i++);
		}
	}

	/**
	 * The Class IntTest.
	 */
	public class IntTest implements Test {
		
		/** The i. */
		int i;
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#getTestName()
		 */
		public String getTestName() {
			return "for(int i...";
		}
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#executeTest()
		 */
		public void executeTest() {
			for(i = 0; i < iterations; i++);
		}
	}

	/* (non-Javadoc)
	 * @see com.tpt.testharness.test.TestSet#getTests()
	 */
	public Test[] getTests() {
		return new Test[] {new LongTest(), new IntTest()};
	}

	/* (non-Javadoc)
	 * @see com.tpt.testharness.test.TestSet#init()
	 */
	public void init() {
		iterations = DEFAULT_ITERATIONS_TO_EXECUTE;
	}

	/* (non-Javadoc)
	 * @see com.tpt.testharness.test.TestSet#getDefaultTimesToExecute()
	 */
	public long getDefaultTimesToExecute() {
		return DEFAULT_TIMES_TO_EXECUTE;
	}

	/* (non-Javadoc)
	 * @see com.tpt.testharness.test.TestSet#getTestTitle()
	 */
	public String getTestTitle() {
		return "long vs int loop";
	}

	/* (non-Javadoc)
	 * @see com.tpt.testharness.test.TestSet#getTestDescription()
	 */
	public String getTestDescription() {
		return "One could think a loop controlled by an int is faster than one controlled by a long. Let's check how much the difference is.";
	}
}
