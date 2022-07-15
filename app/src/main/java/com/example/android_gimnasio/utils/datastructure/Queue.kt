package com.example.android_gimnasio.utils.datastructure

class Queue<T> {
    private val elements: MutableList<T> = mutableListOf()

    fun isEmpty() = elements.isEmpty()
    fun count() = elements.size
    fun enqueue(item: T) = elements.add(item)
    fun dequeue() = if (!isEmpty()) elements.removeAt(0) else null
    fun peek() = if (!isEmpty()) elements[0] else null

    override fun toString(): String = elements.toString()
}