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

(deftest single-doll-of-max-weight
  (testing "A single doll of the max weight is returned"
    (is (= (burden 100 
      [{:name "a" :weight 100 :value 100}]) 
      [{:name "a" :weight 100 :value 100}]))))

(deftest underweight-and-overweight-doll
  (testing "If an underweight and overweight are included, return only the underweight"
    (is (= (burden 100 
      [{:name "fatty" :weight 150 :value 100} 
       {:name "skinny" :weight 50 :value 100}]) 
      [{:name "skinny" :weight 50 :value 100}]))))

(deftest three-underweights-yet-only-two-can-fit
  (testing "Three underweight dolls yet only two can fit"
    (is (= (burden 100 
      [{:name "a" :weight 50 :value 50} 
       {:name "b" :weight 50 :value 100} 
       {:name "c" :weight 50 :value 150}])

      [{:name "b" :weight 50 :value 100} 
       {:name "c" :weight 50 :value 150}]))))

(deftest sort-dolls-test
  (testing "Make sure we can sort dolls"
    (is (= (weight-sort
      [{:name "c" :weight 70 :value 150}
       {:name "b" :weight 50 :value 100} 
       {:name "a" :weight 20 :value 50}])

      [{:name "a" :weight 20 :value 50}
       {:name "b" :weight 50 :value 100} 
       {:name "c" :weight 70 :value 150}]))))
