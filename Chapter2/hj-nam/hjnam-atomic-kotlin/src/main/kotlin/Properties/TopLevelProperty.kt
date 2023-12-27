package com.ak47.atomickotlinstudy.Properties

val constant = 42 // 불변이므로 최상위 수준에 정의해도 안전

var counter = 0   // 안티패턴: 가변

fun inc() {
    counter ++
}