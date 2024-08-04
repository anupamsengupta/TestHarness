package com.tpt.testharness.test.impl;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.tpt.testharness.test.Test;
import com.tpt.testharness.test.TestSet;

public class WordCloudingInternalStreamVsExternalIterationTest implements TestSet {
	/** The iterations. */
	private int iterations;
	
	private static final String[] arr={
			"years ago, I was sitting at the Frankfurt Airport, bored out of my skull. In those days we did not have infinite fast wifi ",
			"the strange cast was all about in the Comparator.comparing() method. We see that it looks as if the lambda is being ",
			"You might remember Naftalin from his excellent Java books on Generics and Lambdas. As a result, I've learned a ",
			"experimentation to come up with my own conclusions. After writing dozens of lambdas, I've come up with Heinz's ",
			"years ago, I was sitting at the Frankfurt Airport, bored out of my skull. In those days we did not have infinite fast wifi ",
			"the strange cast was all about in the Comparator.comparing() method. We see that it looks as if the lambda is being ",
			"You might remember Naftalin from his excellent Java books on Generics and Lambdas. As a result, I've learned a ",
			"experimentation to come up with my own conclusions. After writing dozens of lambdas, I've come up with Heinz's ",
			"years ago, I was sitting at the Frankfurt Airport, bored out of my skull. In those days we did not have infinite fast wifi ",
			"the strange cast was all about in the Comparator.comparing() method. We see that it looks as if the lambda is being ",
			"You might remember Naftalin from his excellent Java books on Generics and Lambdas. As a result, I've learned a ",
			"experimentation to come up with my own conclusions. After writing dozens of lambdas, I've come up with Heinz's ",
			"years ago, I was sitting at the Frankfurt Airport, bored out of my skull. In those days we did not have infinite fast wifi ",
			"the strange cast was all about in the Comparator.comparing() method. We see that it looks as if the lambda is being ",
			"You might remember Naftalin from his excellent Java books on Generics and Lambdas. As a result, I've learned a ",
			"experimentation to come up with my own conclusions. After writing dozens of lambdas, I've come up with Heinz's ",
			"years ago, I was sitting at the Frankfurt Airport, bored out of my skull. In those days we did not have infinite fast wifi ",
			"the strange cast was all about in the Comparator.comparing() method. We see that it looks as if the lambda is being ",
			"You might remember Naftalin from his excellent Java books on Generics and Lambdas. As a result, I've learned a ",
			"experimentation to come up with my own conclusions. After writing dozens of lambdas, I've come up with Heinz's "
			};
	
	public class WordCloudingInternalIterationStreamTest implements Test {
	
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#getTestName()
		 */
		public String getTestName() {
			return "Inner loop plus Stream Word Cloud Test";
		}
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#executeTest()
		 */
		public void executeTest() {
    	Arrays.stream(arr)
    	//.parallel()
			.map(line -> line.split(" "))
			//.parallel()
			.flatMap(Arrays::stream)
			//.sorted()
			//.parallel()
			.collect(groupingBy(String::intern, counting()));
		}
	}

	/**
	 * The Class StreamAndCollectPrimeNumberTest.
	 */
	public class WordCloudingExternalIterationTest implements Test {
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#getTestName()
		 */
		public String getTestName() {
			return "Outer loop Word Cloud Test";
		}
		
		/* (non-Javadoc)
		 * @see com.tpt.testharness.test.Test#executeTest()
		 */
		public void executeTest() 
		{
			Map<String, Long> wordCloudMap = new HashMap<>();
			for(int i=0; i < arr.length; i++)
			{
				String line = arr[i];
				String[] words = line.split(" ");
				for(int j=0; j < words.length; j++)
				{
					Long count = wordCloudMap.get(words[j]);
					if( null == count )
					{
						wordCloudMap.put(words[j], 1L);
					}
					else
					{
						wordCloudMap.put(words[j], count + 1L);
					}
				}
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see com.tpt.testharness.test.TestSet#getTests()
	 */
	public Test[] getTests() {
		return new Test[] {new WordCloudingExternalIterationTest(), new WordCloudingInternalIterationStreamTest()};
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
		return "Check difference between word clouding calculation in outer loop. That is using simple for iteration and with inner loop and parallel streams.";
	}
}
