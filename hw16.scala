object hw16 extends eecs.cs385 {
  // if working in a group, include all names
  def userName = "Chandler Baker & Kyle Rosado"

  // REMEMBER THAT ignoretest MUST BE SET ON AT LEAST
  // TWO PROBLEMS WHEN YOU'RE DONE.

  // *** insert running time here *** O(n^4)
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
  test("albertsShare", albertsShare _, "loot")


  // *** insert running time here ***
  // SERIOUS BUG COUNT = 3
  def lotteryPick(n: Int, taken: List[Int]): Int = {
    var groups = List[Set[Int]]()

    var s = Set[Int]()
    for (i <- 1 to n){
      if (!taken.contains(i)){
        s+=i
        if (i == n) groups = s+:groups
      }
      else if (s.nonEmpty){
        groups = s+:groups
        s = Set()
      }
    }

    groups = groups.reverse
    var big = Set[Int]()
    for (g <- groups){
      if (g.size > big.size) big = g
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
