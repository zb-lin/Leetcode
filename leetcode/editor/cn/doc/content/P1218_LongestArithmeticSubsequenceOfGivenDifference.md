<p>给你一个整数数组&nbsp;<code>arr</code>&nbsp;和一个整数&nbsp;<code>difference</code>，请你找出并返回 <code>arr</code>&nbsp;中最长等差子序列的长度，该子序列中相邻元素之间的差等于 <code>difference</code> 。</p>

<p><strong>子序列</strong> 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 <code>arr</code> 派生出来的序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,2,3,4], difference = 1
<strong>输出：</strong>4
<strong>解释：</strong>最长的等差子序列是 [1,2,3,4]。</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,3,5,7], difference = 1
<strong>输出：</strong>1
<strong>解释：</strong>最长的等差子序列是任意单个元素。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,5,7,8,5,3,4,2,1], difference = -2
<strong>输出：</strong>4
<strong>解释：</strong>最长的等差子序列是 [7,5,3,1]。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= arr.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= arr[i], difference &lt;= 10<sup>4</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>动态规划</li></div></div><br><div><li>👍 299</li><li>👎 0</li></div>