<p>给你一个由&nbsp;<code>n</code>&nbsp;个数对组成的数对数组&nbsp;<code>pairs</code>&nbsp;，其中&nbsp;<code>pairs[i] = [left<sub>i</sub>, right<sub>i</sub>]</code>&nbsp;且&nbsp;<code>left<sub>i</sub>&nbsp;&lt; right<sub>i</sub></code><sub> 。</sub></p>

<p>现在，我们定义一种 <strong>跟随</strong> 关系，当且仅当&nbsp;<code>b &lt; c</code>&nbsp;时，数对&nbsp;<code>p2 = [c, d]</code>&nbsp;才可以跟在&nbsp;<code>p1 = [a, b]</code>&nbsp;后面。我们用这种形式来构造 <strong>数对链</strong> 。</p>

<p>找出并返回能够形成的 <strong>最长数对链的长度</strong> 。</p>

<p>你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>pairs =&nbsp;[[1,2], [2,3], [3,4]]
<strong>输出：</strong>2
<strong>解释：</strong>最长的数对链是 [1,2] -&gt; [3,4] 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>pairs = [[1,2],[7,8],[4,5]]
<b>输出：</b>3
<b>解释：</b>最长的数对链是 [1,2] -&gt; [4,5] -&gt; [7,8] 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == pairs.length</code></li> 
 <li><code>1 &lt;= n &lt;= 1000</code></li> 
 <li><code>-1000 &lt;= left<sub>i</sub>&nbsp;&lt; right<sub>i</sub>&nbsp;&lt;= 1000</code></li> 
</ul>

<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>动态规划</li><li>排序</li></div></div><br><div><li>👍 445</li><li>👎 0</li></div>