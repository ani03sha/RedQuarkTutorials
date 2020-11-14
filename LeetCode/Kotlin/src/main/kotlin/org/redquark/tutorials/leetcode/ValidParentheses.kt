package org.redquark.tutorials.leetcode

import java.util.*

fun isValid(s: String): Boolean {
    // Stack to store left symbols
    val leftSymbols = Stack<Char>()
    // Loop for each character of the string
    for (c in s.toCharArray()) {
        // If left symbol is encountered
        if (c == '(' || c == '{' || c == '[') {
            leftSymbols.push(c)
        }
        // If right symbol is encountered
        else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peek() == '(') {
            leftSymbols.pop()
        } else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peek() == '{') {
            leftSymbols.pop()
        } else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peek() == '[') {
            leftSymbols.pop()
        }
        // If none of the valid symbols is encountered
        else {
            return false
        }
    }
    return leftSymbols.isEmpty()
}

fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
    println(isValid("([)]"))
    println(isValid("{[]}"))
}