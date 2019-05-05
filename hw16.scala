object hw16 extends eecs.cs385 {
  // if working in a group, include all names
  def userName = ???

  // REMEMBER THAT ignoretest MUST BE SET ON AT LEAST
  // TWO PROBLEMS WHEN YOU'RE DONE.

  // *** insert running time here ***
  def albertsShare(loot: List[Int]): Int = {
    ???
  }
  ignoretest("albertsShare", albertsShare _, "loot")


  // *** insert running time here ***
  // SERIOUS BUG COUNT = 0
  def lotteryPick(n: Int, taken: List[Int]): Int = {
    ???
  }
  ignoretest("lotteryPick", lotteryPick _, "n", "taken")


  // *** insert running time here ***
  def synchronizationLength(codes: List[String]): Int = {
    ???
  }
  ignoretest("synchronizationLength", synchronizationLength _, "codes")

  // *** insert running time here ***
  def minCuts(msg: String): Int = {
    ???
  }
  ignoretest("minCuts", minCuts _, "msg")
}
