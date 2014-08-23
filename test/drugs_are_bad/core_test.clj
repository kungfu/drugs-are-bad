(ns drugs-are-bad.core-test
  (:require [clojure.test :refer :all]
            [drugs-are-bad.core :refer :all]))

(deftest empty-doll-list
  (testing "An empty doll list returns an empty list"
    (is (= (burden 100 []) []))))

(deftest single-underweight-doll
  (testing "A single underweight doll is returned"
    (is (= (burden 100 
      [{:name "a" :weight 50 :value 100}]) 
      [{:name "a" :weight 50 :value 100}]))))

(deftest single-overweight-doll
  (testing "A single overweight doll is not returned"
    (is (= (burden 100 
      [{:name "a" :weight 150 :value 100}]) 
      []))))
