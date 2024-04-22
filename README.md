The project contains 5 files - 3 for each of the tasks and additional 2 helper classes.
Each one of the 3 task classes have its own main() method which allows user to provide all necessary input.

<h2>Task 1</h2>
This task just simply checks knowledge of sorting algorithms. I chose quick sort as it's one of the fastest algorithms out there. As for the rest of required basic information (number of elements, number of distinct elements...), I did as simple as possible. For counting distinct elements I'm using hashset, and once sorting is done the first element is the smallest value in the array while the last element holds the biggest value.

<h2>Task 2</h2>
This is basically just a 2 sum problem, but with a small twist that we need to also count repeated numbers. So if we would have array like { 7, 6, 6 } we would need to output "6, 7" twice as 6 appears twice. A good solution to 2 sum problem uses array sorting and hashing which is also what I am using in my solution.

Before any sum-checking is done, I sort array in ascending order. Then I traverse through the array, subtract value of the current element from the sum in question and check the difference. If my hashmap does not contain this difference, I add current element of the array to it. If current element already exists in the hashmap, I increment how many times it appears. If the hashmap does contain the difference, I simply create a new pair of numbers (current element and the difference) - a pair of those numbers is created as many times as the difference ever appeared throughout the execution of the program.

To better illustrate this solution:
Our input is array { 1, 2, 10, 7, 5, 3, 6, 6, 13, 0 } and we want to check for two numbers in the array which sum gives us 13.
First we sort the array, so we have: { 0, 1, 2, 3, 5, 6, 6, 7, 10, 13 }.
We then traverse through the array. The first element is 0. The difference is 13 (13-0=13). Our hashmap does not yet contain any elements, so it also does not contain the number 13. We store 0 in the hashmap and we also count how many times 0 has appeared which is 1.
Next element is 1. 13 - 1 = 12. 12 is not present in hashmap. Again store 1 in hashmap including counting of its appearances.
And so on until we reach 6. 13 - 6 = 7. 7 does exist in our array, but not in our hashmap yet (remember: we add all elements to hashmap in ascending order; if current element is 6, we cannot have 7 in hashmap yet). We store 6 and it has appeared 1 time so far.
Next number is once again 6. 13 - 6 = 7. And again 7 does not yet exist in the hashmap. So we just increment number of appearances of 6 in our hashmap - number 6 has appeared twice.
And next number is 7. 13 - 7 = 6. 6 exists in our hashmap. How many times did 6 appear? 2. So we simply create 2 pairs of same numbers - 6 and 7.

<h2>Task 3</h2>
I solved this one using just Union Find. In Union Find, when we do a union we get two elements as arguments. If their representatives are the same, then they exist in the same subset. If their representatives are different, we have created a new subset.
But how exactly could we store information on how many subsets we have? In Union Find we basically start by assigning representatives to each element. And at the beginning each element is its own representative which means that we have as many subsets as we have elements. We can have a variable counter which tracks number of subsets and initially we can set it to the total number of elements. Then each time we create a new subset in Union we subtract from the counter.
