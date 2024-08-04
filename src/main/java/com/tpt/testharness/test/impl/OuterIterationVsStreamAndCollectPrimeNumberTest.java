package com.tpt.testharness.test.impl;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import com.tpt.testharness.test.Test;
import com.tpt.testharness.test.TestSet;

/**
 * The Class OuterIterationVsStreamAndCollectPrimeNumberTest.
 */
public class OuterIterationVsStreamAndCollectPrimeNumberTest implements TestSet {
	private ArrayList<Integer> integers = (ArrayList<Integer>)IntStream.rangeClosed(1, DEFAULT_ITERATIONS_TO_EXECUTE).boxed().collect(toList());
	
	/** The iterations. */
	private int iterations;
	
	/**
	 * The Class OuterIterationPrimeNumberTest.
	 */
	public class OuterIterationPrimeNumberTest implements Test {
	
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#getTestName()
		 */
		public String getTestName() {
			return "Outer loop for prime";
		}
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#executeTest()
		 */
		public void executeTest() {
			Map<Boolean, List<Integer>> partitionedNums = new HashMap<>();
			ArrayList<Integer> primes = new ArrayList<>();
			ArrayList<Integer> nonPrimes = new ArrayList<>();
			partitionedNums.put(true, primes);
			partitionedNums.put(true, nonPrimes);

			Iterator<Integer> integersItr = integers.iterator();
			while(integersItr.hasNext())
			{
				Integer numCandidate = integersItr.next();
				if(isPrime( numCandidate ))
				{
					primes.add( numCandidate );
				}
				else
				{
					nonPrimes.add( numCandidate );
				}
			}
		}
		
	}

	/**
	 * The Class StreamAndCollectPrimeNumberTest.
	 */
	public class StreamAndCollectPrimeNumberTest implements Test {
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#getTestName()
		 */
		public String getTestName() {
			return "Stream and Collect for prime";
		}
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#executeTest()
		 */
		public void executeTest() {
			integers.stream().parallel()
					.collect(partitioningBy(candidate -> isPrime(candidate)));
		}
		
	}

	/**
	 * Checks if candidate is prime.
	 *
	 * @param candidate the candidate
	 * @return true, if is prime
	 */
	public boolean isPrime(int candidate)
	{
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
	}
	
	/* (non-Javadoc)
	 * @see com.tpt.testharness.test.TestSet#getTests()
	 */
	public Test[] getTests() {
		return new Test[] {new OuterIterationPrimeNumberTest(), new StreamAndCollectPrimeNumberTest()};
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
		return "outer vs inner loop";
	}

	/* (non-Javadoc)
	 * @see com.tpt.testharness.test.TestSet#getTestDescription()
	 */
	public String getTestDescription() {
		return "Check difference between prime number calculation in outer loop. That is using simple for iteration and with streams.";
	}
}
