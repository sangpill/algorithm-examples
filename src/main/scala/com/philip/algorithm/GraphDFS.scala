package com.philip.algorithm

object GraphDFS {
  /**
    * 깊이우선 탐색
    *
    * graph는 배열로
    */

  val numOfVertex = 7

  val graph = Array.ofDim[Int](numOfVertex, numOfVertex)
  val visited = Array.ofDim[Int](numOfVertex)

  def DepthFirstSearch(index: Int): Unit ={
    println(s"idx: $index")

    visited(index) = 1
    for(i <- 0 until numOfVertex) {
      if(visited(i)==0 && graph(index)(i)==1) DepthFirstSearch(i)
    }
  }


  def main(args: Array[String]): Unit = {
    graph.update(0,Array(0,1,1,1,0,0,0))
    graph.update(1,Array(0,0,0,0,0,1,1))
    graph.update(2,Array(0,0,0,0,1,0,0))
    graph.update(3,Array(0,0,1,0,1,0,0))
    graph.update(4,Array(0,1,0,0,0,0,0))
    graph.update(5,Array(0,0,0,0,0,0,0))
    graph.update(6,Array(0,0,0,0,1,0,0))

    DepthFirstSearch(0)
  }


}
