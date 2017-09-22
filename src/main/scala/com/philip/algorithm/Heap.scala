package com.philip.algorithm

import scala.collection.mutable

/**
  * Heap은 순서속성을 만족하는 완전 이진 트리이다.
  * (완전이진트리: 최고 깊이를 제외한 노드들이 완전히 채워져 있는 이진 트리.)
  * 순서속성이란? 트리내의 모든 노드가 부모 노드보다 커야 한다는 규칙 (다른 규칙도 상관없음)
  * 즉 "힙에서 가장 작은 데이터를 갖는 노드는 root 이다"를 보장.
  *
  * 구현:
  * 고정된 dataset의 경우 배열로 처리하는것이 효율적이나, 동적으로 추가/삭제되는 경우 buffer로 처리하자.
  * 노드추가, 최소값(root) 삭제 구현
  */

object Heap {


  val heapBuffer: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer()


  def getParentIndex(index: Int): Int = (index-1) / 2

  def getMinChildIndex(index: Int): Int = {
    val leftChildIdx = 2 * index + 1
    val rightChildIdx = 2 * index + 2

    val maxIdx = heapBuffer.size-1

    if(maxIdx < leftChildIdx)
      -1
    else if(maxIdx < rightChildIdx)
      leftChildIdx
    else if(heapBuffer(leftChildIdx) < heapBuffer(rightChildIdx))
      leftChildIdx
    else
      rightChildIdx

  }


  def swapNode(currentIdx: Int, targetIdx: Int): Unit = {

  }

  def updateNode(currentIdx: Int, parentIdx: Int): Unit = {

    if( currentIdx > 0 && heapBuffer(currentIdx) < heapBuffer(parentIdx)) {
      val parentData = heapBuffer(parentIdx)
      val curData = heapBuffer(currentIdx)
      heapBuffer(currentIdx) = parentData
      heapBuffer(parentIdx) = curData

      updateNode(parentIdx, getParentIndex(parentIdx))
    }
  }

  def swapChildNode(currentIdx: Int, childIdx: Int): Unit = {

    if( currentIdx < heapBuffer.size && heapBuffer(childIdx) < heapBuffer(currentIdx) ) {

      val curData = heapBuffer(currentIdx)
      val childData = heapBuffer(childIdx)

      heapBuffer(currentIdx) = childData
      heapBuffer(childIdx) = curData

      swapChildNode(childIdx, getMinChildIndex(childIdx))
    }
  }

  def insert(data: Int): Unit = {
    println(s"insert $data")
    heapBuffer += data

    val currentPos = heapBuffer.size - 1
    updateNode(currentPos, getParentIndex(currentPos))
  }

  def deleteMin(): Int = {
    val min = heapBuffer(0)

    heapBuffer.remove(0)

    swapChildNode(0, getMinChildIndex(0))


    min
  }

  def main(args: Array[String]): Unit = {
    println(getParentIndex(1))

    insert(2)
    insert(8)
    insert(52)
    insert(13)
    insert(37)
    insert(67)
    insert(161)
    insert(17)
    insert(43)
    insert(88)
    insert(7)

    println(heapBuffer)
    println(deleteMin)
    println(heapBuffer)
  }




}
