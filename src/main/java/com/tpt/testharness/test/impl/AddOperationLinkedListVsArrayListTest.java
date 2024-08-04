package com.tpt.testharness.test.impl;

import java.util.ArrayList;
import java.util.LinkedList;

import com.tpt.testharness.test.Test;
import com.tpt.testharness.test.TestSet;

/**
 * The Class AddOperationLinkedListVsArrayListTest.
 */
public class AddOperationLinkedListVsArrayListTest implements TestSet {
	
	/** The iterations. */
	private int iterations;
	
	/**
	 * The Class ArrayListAdditionTest.
	 */
	public class ArrayListAdditionTest implements Test {
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#getTestName()
		 */
		public String getTestName() {
			return "arrayList.add(Integer i...";
		}
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#executeTest()
		 */
		public void executeTest() {
			ArrayList<Integer> container = new ArrayList<>();
			for(int i = 0; i < iterations; i++)
			{
				container.add(i);
			}
		}
	}

	/**
	 * The Class LinkedListAdditionTest.
	 */
	public class LinkedListAdditionTest implements Test {
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#getTestName()
		 */
		public String getTestName() {
			return "linkedList.add(Integer i...";
		}
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#executeTest()
		 */
		public void executeTest() {
			LinkedList<Integer> container = new LinkedList<>();
			for(int i = 0; i < iterations; i++)
			{
				container.add(i);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.tpt.testharness.test.TestSet#getTests()
	 */
	public Test[] getTests() {
		return new Test[] {new ArrayListAdditionTest(), new LinkedListAdditionTest()};
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
		return "Adding element to ArrayList Vs LinkedList";
	}

	/* (non-Javadoc)
	 * @see com.tpt.testharness.test.TestSet#getTestDescription()
	 */
	public String getTestDescription() {
		return "One could think a addition to a ArrayList is less time consuming than LinkedList. Let's check how much the difference is.";
	}
}
