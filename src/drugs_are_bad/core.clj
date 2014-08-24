(ns drugs-are-bad.core
  (:gen-class))


(defn weight-sort [ds] 
  (sort-by (fn [d] (:weight d)) ds))

(defn burden-sorted
  ([mw dolls] 
    (filter (fn [d] (>= mw (:weight d))) dolls)))

(defn burden [mw dolls]
  (burden-sorted mw (weight-sort dolls)))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello world"))

