(ns drugs-are-bad.jsonhacks-test
  (:require [clojure.test :refer :all]
            [drugs-are-bad.jsonhacks :refer :all]))

(deftest empty-doll-list
  (testing "An empty doll list returns an empty list"
    (is (= (hack-get-dolls-from-post-data
      {"maxWeight" 100})
      []))))

(deftest simple-doll-list
  (testing "A simple doll list returns what you'd expect"
    (is (= (hack-get-dolls-from-post-data
      {"maxWeight" 100
        "dolls[0][name]" "a"
        "dolls[0][weight]" 50
        "dolls[0][value]" 100

        "dolls[1][name]" "b"
        "dolls[1][weight]" 60
        "dolls[1][value]" 110})
      [
      {:name "a" :weight 50 :value 100}
      {:name "b" :weight 60 :value 110}
      ]))))

