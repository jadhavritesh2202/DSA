<h2><a href="https://www.geeksforgeeks.org/problems/maximum-subset-sum--170648/1">Max Sum with At Least 1 of Every Adjacent</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">Given an integer array <strong>arr[].&nbsp;</strong>Find the <strong>maximum </strong>subset-sum of elements that you can make from the given array such that for every <strong>two consecutive</strong> elements in the array, at least one of the elements is present in our subset.<strong>&nbsp;</strong></span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [1, -1, 3, 4]
<strong>Output: </strong>8
<strong>Explanation: </strong>
We can choose 0th,2nd &amp; 3rd index(0 based Index),so that it can satisfy the condition &amp; can make maximum sum 8.
</span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] =  [0, 2, 0]
<strong>Output: </strong>2
<strong>Explanation: </strong>We can choose 1st index. Here the maximum possible sum is 2.</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>2 ≤ n ≤ 10<sup>5</sup>, n is length of the array<br>-10<sup>4</sup><sup>&nbsp;</sup>≤ arr[i] ≤ 10<sup>4</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Microsoft</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;