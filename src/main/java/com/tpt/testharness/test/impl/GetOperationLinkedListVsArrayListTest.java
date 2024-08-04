package com.tpt.testharness.test.impl;

import java.util.ArrayList;
import java.util.LinkedList;

import com.tpt.testharness.test.Test;
import com.tpt.testharness.test.TestSet;

/**
 * The Class GetOperationLinkedListVsArrayListTest.
 */
public class GetOperationLinkedListVsArrayListTest implements TestSet {
	
	/** The iterations. */
	private int iterations;
	
	/**
	 * The Class ArrayListAdditionTest.
	 */
	public class ArrayListAdditionTest implements Test {
		private ArrayList<Integer> container = new ArrayList<>();

		public ArrayListAdditionTest()
		{
			for(int i = 0; i < iterations; i++)
			{
				container.add(i);
			}
		}

		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#getTestName()
		 */
		public String getTestName() {
			return "arrayList.get(int i...";
		}
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#executeTest()
		 */
		public void executeTest() {
			for(int i = 0; i < iterations; i++)
			{
				container.get(900);
			}
		}
	}

	/**
	 * The Class LinkedListAdditionTest.
	 */
	public class LinkedListAdditionTest implements Test {
		private LinkedList<Integer> container = new LinkedList<>();
		
		public LinkedListAdditionTest()
		{
			for(int i = 0; i < iterations; i++)
			{
				container.add(i);
			}
		}
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#getTestName()
		 */
		public String getTestName() {
			return "linkedList.get(int i...";
		}
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#executeTest()
		 */
		public void executeTest() {
			for(int i = 0; i < iterations; i++)
			{
				container.get(900);
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
		return "Getting element from ArrayList Vs LinkedList";
	}

	/* (non-Javadoc)
	 * @see com.tpt.testharness.test.TestSet#getTestDescription()
	 */
	public String getTestDescription() {
		return "One could think getting an element by index from an ArrayList is less time consuming than LinkedList. Let's check how much the difference is.";
	}
}
