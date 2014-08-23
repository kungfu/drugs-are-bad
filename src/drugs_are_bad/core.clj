(ns drugs-are-bad.core
  (:gen-class))


(defn burden
  ([mw dolls] 
    (filter (fn [d] (>= mw (:weight d))) dolls)))





(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello world"))

