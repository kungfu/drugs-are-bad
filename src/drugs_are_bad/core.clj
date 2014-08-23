(ns drugs-are-bad.core
  (:gen-class))


(defn burden
  ([mw dolls] 
    (if (empty? dolls) 
      [] 
      (if (< mw (:weight (first dolls)))
        []
        [(first dolls)]))))





(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello world"))

