//
// Created by 11214 on 2020/7/4.
//
#include <iostream>
#include "Solution718.cpp"

int main() {
    Solution718 solution718;
    vector<int> a;
    a.push_back(1);
    a.push_back(2);
    a.push_back(3);
    a.push_back(2);
    a.push_back(1);

    std::cout << solution718.findLength(a,a);
}
