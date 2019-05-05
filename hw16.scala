object hw16 extends eecs.cs385 {
  // if working in a group, include all names
  def userName = "Chandler Baker & Kyle Rosado"

  // REMEMBER THAT ignoretest MUST BE SET ON AT LEAST
  // TWO PROBLEMS WHEN YOU'RE DONE.

  // *** O(n^4) ***
  def albertsShare(loot: List[Int]): Int = {

    val n = loot.length

    def bettysShare(fir:List[Int],sec:List[Int]):Int = {
      val n1 = fir.length
      val n2 = sec.length
      var choice = 0
      var ret = 0

      if (n1 > 1) {
        for (i <- 1 to n1-1){
          val (one,two) = carlasShare(fir.take(i),fir.drop(i),sec)
          val sum1 = one.sum
          val sum2 = two.sum
          if (sum1 > sum2){
            if (sum1 > choice){
              choice = sum1
              ret = sum2
            }
            else if (sum1 == choice){
              ret = ret min sum2
            }
          }
          else {
            if (sum2 > choice){
              choice = sum2
              ret = sum1
            }
            else if (sum2 == choice){
              ret = ret min sum1
            }
          }
        }
      }

      if (n2 > 1){
        for (i <- 1 to n2-1){
          val (one,two) = carlasShare(fir,sec.take(i),sec.drop(i))
          val sum1 = one.sum
          val sum2 = two.sum
          if (sum1 > sum2){
            if (sum1 > choice){
              choice = sum1
              ret = sum2
            }
            else if (sum1 == choice){
              ret = ret min sum2
            }
          }
          else {
            if (sum2 > choice){
              choice = sum2
              ret = sum1
            }
            else if (sum2 == choice){
              ret = ret min sum1
            }
          }
        }
      }
      ret
    }

    def carlasShare(fir:List[Int],sec:List[Int],tri:List[Int]):(List[Int],List[Int]) = {
      val sum1 = fir.sum
      val sum2 = sec.sum
      val sum3 = tri.sum
      if (sum1 >= sum2 && sum1 >= sum3) (sec,tri)
      else if (sum2 >= sum3) (fir,tri)
      else (fir,sec)
    }

    var ans = 0
    for (i <- 1 to n-1){
      ans = bettysShare(loot.take(i), loot.drop(i)) max ans
    }
    ans
  }
  ignoretest("albertsShare", albertsShare _, "loot")


  // *** O(nlogn) ***
  //
  // The first for loop runs in nlogn
  //
  // The second for loop goes through at worst n/2 Sets, where each Set is size 1
  // because we can choose every other number.  In this case, .size is constant, so
  // it runs in linear time for n/2, which we can reduce to n.
  //
  // If we have one large group, the for loop will run in constant time, and the Set
  // will have n-1 elements, making .size linear.  It will run in n-1 time, or just n
  //
  // If there is one choice taken in the middle, we will have 2 Sets of (n/2)-1
  // so the for loop will run twice and each .size will run in (n/2)-1, which is also
  // linear.
  // SERIOUS BUG COUNT = 3
  def lotteryPick(n: Int, taken: List[Int]): Int = {
    var groups = List[Set[Int]]()
    val take2 = taken.toSet

    var s = Set[Int]()
    for (i <- 1 to n){
      if (!take2.contains(i)){
        s += i
        if (i == n) groups = s+:groups
      }
      else if (s.nonEmpty){
        groups = s :: groups
        s = Set()
      }
    }


    var big = Set[Int]()
    for (g <- groups){

      var gw = (g.size)/2 +1
      var bw = (big.size)/2 +1

      if (g.max == n) gw = g.size
      else if (g.min == 1) gw = g.size

      if (big.nonEmpty && big.max == n) bw = big.size
      else if (big.nonEmpty && big.min == 1) bw = big.size

      if (gw >= bw) big = g
    }

    if (big.min == 1 && big.max != 1) big.max-1
    else big.min
  }
  test("lotteryPick", lotteryPick _, "n", "taken")


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
