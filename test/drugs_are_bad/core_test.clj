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

(deftest weight-sort-test
  (testing "Make sure we can sort dolls by weight"
    (is (= (weight-sort
      [{:name "c" :weight 70 :value 150}
       {:name "b" :weight 50 :value 100} 
       {:name "a" :weight 20 :value 50}])

      [{:name "a" :weight 20 :value 50}
       {:name "b" :weight 50 :value 100} 
       {:name "c" :weight 70 :value 150}]))))

(deftest valsum-test
  (testing "Make sure we can get the combined value of a group of dolls"
    (is (= (valsum
      [{:name "a" :weight 50 :value 20}
       {:name "b" :weight 50 :value 50} 
       {:name "c" :weight 50 :value 50}])

      120))))

(deftest valsum-empty-list-test
  (testing "Make sure we get a value of zero from an empty murder"
    (is (= (valsum
      [])
      0))))

(deftest max-murder-of-dolls-test
  (testing "Make sure we can get the group of dolls with the highest value"
    (is (= (max-murder-of-dolls [
      [{:name "a" :weight 50 :value 20}
       {:name "b" :weight 50 :value 50} 
       {:name "c" :weight 50 :value 50}]

      [{:name "d" :weight 50 :value 500}
       {:name "e" :weight 50 :value 150}]

      [{:name "f" :weight 50 :value 150}
       {:name "g" :weight 50 :value 150}
       {:name "h" :weight 50 :value 50} 
       {:name "i" :weight 50 :value 50}]])

      [{:name "d" :weight 50 :value 500}
       {:name "e" :weight 50 :value 150}]))))

(deftest max-murder-of-dolls-empty-list-test
  (testing "Make sure an empty list of doll groups returns nil"
    (is (= (max-murder-of-dolls
      [])
      nil))))

(deftest micahs-test
  (testing "Make sure the test from Micah's github page works"
    (is (= (name-sort (burden 400 
      [{:name "luke" :weight 9 :value 150}
      {:name "anthony" :weight 13 :value 35}
      {:name "candice" :weight 153 :value 200}
      {:name "dorothy" :weight 50 :value 160}
      {:name "puppy" :weight 15 :value 60}
      {:name "thomas" :weight 68 :value 45}
      {:name "randal" :weight 27 :value 60}
      {:name "april" :weight 39 :value 40}
      {:name "nancy" :weight 23 :value 30}
      {:name "bonnie" :weight 52 :value 10}
      {:name "marc" :weight 11 :value 70}
      {:name "kate" :weight 32 :value 30}
      {:name "tbone" :weight 24 :value 15}
      {:name "tranny" :weight 48 :value 10}
      {:name "uma" :weight 73 :value 40}
      {:name "grumpkin" :weight 42 :value 70}
      {:name "dusty" :weight 43 :value 75}
      {:name "grumpy" :weight 22 :value 80}
      {:name "eddie" :weight 7 :value 20}
      {:name "tory" :weight 18 :value 12}
      {:name "sally" :weight 4 :value 50}
      {:name "babe" :weight 30 :value 10}]))

      (name-sort [
      {:name "sally" :weight 4 :value 50}
      {:name "eddie" :weight 7 :value 20}
      {:name "grumpy" :weight 22 :value 80}
      {:name "dusty" :weight 43 :value 75}
      {:name "grumpkin" :weight 42 :value 70}
      {:name "marc" :weight 11 :value 70}
      {:name "randal" :weight 27 :value 60}
      {:name "puppy" :weight 15 :value 60}
      {:name "dorothy" :weight 50 :value 160}
      {:name "candice" :weight 153 :value 200}
      {:name "anthony" :weight 13 :value 35}
      {:name "luke" :weight 9 :value 150}])))))

